package caas.poc.service;

import caas.poc.entity.Dataset;
import caas.poc.entity.User;
import caas.poc.entity.Workspace;
import caas.poc.repository.DatasetRepository;
import caas.poc.repository.UserRepository;
import caas.poc.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatasetService {
    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    public Dataset create(Integer workspaceId, String name, Byte[] content, Boolean isPublic) {
        Dataset dataset = new Dataset();
        dataset.name = name;
        dataset.content = content;
        dataset.isPublic = isPublic;
        dataset.workspace = workspaceRepository.findOne(workspaceId);
        datasetRepository.saveAndFlush(dataset);
        return dataset;
    }

    public Dataset setName(Integer id, String name) {
        Dataset dataset = datasetRepository.findOne(id);
        dataset.name = name;
        datasetRepository.saveAndFlush(dataset);
        return dataset;
    }

    public Dataset setIsPublic(Integer id, Boolean isPublic) {
        Dataset dataset = datasetRepository.findOne(id);
        dataset.isPublic = isPublic;
        datasetRepository.saveAndFlush(dataset);
        return dataset;
    }

    public Dataset setContent(Integer id, Byte[] content) {
        Dataset dataset = datasetRepository.findOne(id);
        dataset.content = content;
        datasetRepository.saveAndFlush(dataset);
        return dataset;
    }

    public void remove(Integer id) {
        datasetRepository.delete(id);
    }

}
