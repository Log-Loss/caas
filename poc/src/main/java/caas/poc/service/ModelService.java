package caas.poc.service;

import caas.poc.entity.Dataset;
import caas.poc.entity.Model;
import caas.poc.entity.User;
import caas.poc.repository.DatasetRepository;
import caas.poc.repository.ModelRepository;
import caas.poc.repository.UserRepository;
import caas.poc.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    public Model create(Integer workspaceId, String name, String config) {
        Model model = new Model();
        model.workspace = workspaceRepository.findOne(workspaceId);
        model.name = name;
        model.config = config;
        modelRepository.saveAndFlush(model);
        return model;
    }

    public Model setName(Integer id, String name) {
        Model model = modelRepository.findOne(id);
        model.name = name;
        modelRepository.saveAndFlush(model);
        return model;
    }

    public Model setConfig(Integer id, String config) {
        Model model = modelRepository.findOne(id);
        model.config = config;
        modelRepository.saveAndFlush(model);
        return model;
    }

    public Model setDataset(Integer id, Integer datasetId) {
        Model model = modelRepository.findOne(id);
        model.dataset = datasetRepository.findOne(datasetId);
        modelRepository.saveAndFlush(model);
        return model;
    }

    public Model removeDataset(Integer id) {
        Model model = modelRepository.findOne(id);
        model.dataset = null;
        modelRepository.saveAndFlush(model);
        return model;
    }

    public void remove(Integer id) {
        modelRepository.delete(id);
    }
}
