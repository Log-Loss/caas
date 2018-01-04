package caas.poc.service;

import caas.poc.entity.User;
import caas.poc.entity.Workspace;
import caas.poc.repository.UserRepository;
import caas.poc.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceService {
    @Autowired
    private WorkspaceRepository workspaceRepository;
    @Autowired
    private UserRepository userRepository;

    public Workspace create(Integer userId, String name) {
        Workspace workspace = new Workspace();
        workspace.user = userRepository.findOne(userId);
        workspace.name = name;
        workspaceRepository.saveAndFlush(workspace);
        return workspace;
    }

    public Workspace update(Integer id, String name) {
        Workspace workspace = workspaceRepository.findOne(id);
        workspace.name = name;
        workspaceRepository.saveAndFlush(workspace);
        return workspace;
    }

    public void remove(Integer id) {
        workspaceRepository.delete(id);
    }

    public Workspace find(Integer id) {
        return workspaceRepository.findOne(id);
    }

    public Boolean exists(Integer id) {
        return workspaceRepository.exists(id);
    }
}
