package caas.poc.service;

import caas.poc.Dataset.BuildInDataset;
import caas.poc.entity.Job;
import caas.poc.repository.JobRepository;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public Job create(Integer modelId, Integer workspaceId, Integer datasetId, String config, String type, String datasetName, Integer epochs, Integer batchSize) {
        Job job = new Job();
        job.modelId = modelId;
        job.workspaceId = workspaceId;
        job.config = getNetConfig(config, type);
        job.datasetId = datasetId;
        job.datasetName = datasetName;
        job.createTime = new Date();
        job.epochs = epochs;
        job.batchSize = batchSize;
        jobRepository.saveAndFlush(job);
        return job;
    }

    public Job start(Integer id) throws Exception {
        Job job = jobRepository.findOne(id);
        job.startTime = new Date();

        int nEpochs = job.epochs;
        MultiLayerConfiguration configuration = MultiLayerConfiguration.fromJson(job.config);
        MultiLayerNetwork model = new MultiLayerNetwork(configuration);

        BuildInDataset dataset = new BuildInDataset(job.datasetName, job.epochs, job.batchSize);
        DataSetIterator trainIter = dataset.getTrainIter();
        DataSetIterator testIter = dataset.getTestIter();

        model.init();
        System.out.println("Train model....");
        model.setListeners(new ScoreIterationListener(1));
        for (int i = 0; i < nEpochs; i++) {
            model.fit(trainIter);
            System.out.println("Completed epoch " + i);

            System.out.println("Evaluate model....");
            Evaluation eval = model.evaluate(testIter);
            System.out.println(eval.stats());
            testIter.reset();
        }

        model.predict(testIter.next().getFeatureMatrix());
        System.out.println("**************** finished ********************");
        
        return job;
    }

    public void remove(Integer id) {
        jobRepository.delete(id);
    }

    public void removeAll() {
        jobRepository.deleteAll();
    }

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Boolean exists(Integer id) {
        return jobRepository.exists(id);
    }

    public List<Job> findAllByWorkspaceId(Integer workspaceId) {
        return jobRepository.findAllByWorkspaceId(workspaceId);
    }

    public Object findOne(Integer id) {
        return jobRepository.findOne(id);
    }

    private String getNetConfig(String config, String type) {
        //设置header
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");

        //设置参数
        HttpEntity<String> requestEntity = new HttpEntity<>(config, httpHeaders);

        //执行请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp = restTemplate.exchange("http://localhost:10001/" + type, HttpMethod.POST, requestEntity, String.class);

        //获取返回的header
        List<String> val = resp.getHeaders().get("Set-Cookie");

        //获得返回值
        return resp.getBody();
    }

    public Job update(Integer id, Integer epochs, Integer batchSize) {
        Job job = jobRepository.findOne(id);
        job.epochs = epochs;
        job.batchSize = batchSize;
        jobRepository.saveAndFlush(job);
        return job;
    }
}
