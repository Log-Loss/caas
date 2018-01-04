package caas.poc.service;

import caas.poc.entity.Dataset;
import caas.poc.entity.User;
import caas.poc.entity.Workspace;
import caas.poc.repository.DatasetRepository;
import caas.poc.repository.UserRepository;
import caas.poc.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DatasetService {
    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    public Dataset create(Integer workspaceId, String name, byte[] content, Boolean isPublic) {
        Dataset dataset = new Dataset();
        dataset.name = name;
        dataset.content = content;
        dataset.isPublic = isPublic;
        dataset.workspaceId = workspaceId;
        datasetRepository.saveAndFlush(dataset);
        return dataset;
    }

    public Dataset setName(Integer id, String name) {
        Dataset dataset = datasetRepository.findOne(id);
        dataset.name = name;
        datasetRepository.saveAndFlush(dataset);
        return dataset;
    }

    public Dataset findOne(Integer id) {
        return datasetRepository.findOne(id);
    }

    public List<Dataset> findAll() {
        return datasetRepository.findAll();
    }

    public List<Dataset> findAllByIsPublic(Boolean isPublic) {
        return datasetRepository.findAllByIsPublic(isPublic);
    }

    public List<Dataset> findAllByIsWorkspaceId(Integer workspaceId) {
        return datasetRepository.findAllByWorkspaceId(workspaceId);
    }

    public Dataset findByWorkspaceIdAndName(Integer workspaceId, String name) {
        return datasetRepository.findByWorkspaceIdAndName(workspaceId, name);
    }

    public Boolean exist(Integer id) {
        return datasetRepository.exists(id);
    }

    public Boolean existsByWorkspaceIdAndName(Integer workspaceId, String name) {
        return datasetRepository.existsByWorkspaceIdAndName(workspaceId, name);
    }

    public Boolean existsByWorkspaceIdAndAndIsPublic(String name, Boolean isPublic) {
        return datasetRepository.existsByNameAndIsPublic(name, isPublic);
    }

    public void remove(Integer id) {
        datasetRepository.delete(id);
    }
    public void removeAll() {
        datasetRepository.deleteAll();
    }
    public Boolean isPublic(Integer id) {
        return datasetRepository.findOne(id).isPublic;
    }

}
