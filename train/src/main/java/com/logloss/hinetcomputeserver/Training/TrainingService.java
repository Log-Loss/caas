package com.logloss.hinetcomputeserver.Training;

import com.logloss.hinetcomputeserver.Dataset.BuildInDataset;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    public void trainModel(MultiLayerConfiguration configuration, TrainingConfig trainingConfig) throws Exception {
        int nEpochs = trainingConfig.getEpochs();
        MultiLayerNetwork model = new MultiLayerNetwork(configuration);

        BuildInDataset dataset = new BuildInDataset(trainingConfig);
        DataSetIterator trainIter = dataset.getTrainIter();
        DataSetIterator testIter = dataset.getTestIter();

        model.init();
        System.out.println("Train model....");
        model.setListeners(new ScoreIterationListener(1));
        for( int i=0; i<nEpochs; i++ ) {
            model.fit(trainIter);
            System.out.println("Completed epoch " + i);

            System.out.println("Evaluate model....");
            Evaluation eval = model.evaluate(testIter);
            System.out.println(eval.stats());
            testIter.reset();
        }

        model.predict(testIter.next().getFeatureMatrix());
        System.out.println("**************** finished ********************");
    }
}
