package caas.poc.service;

import caas.poc.entity.Code;
import caas.poc.entity.User;
import caas.poc.repository.CodeRepository;
import caas.poc.repository.UserRepository;
import caas.poc.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
    @Autowired
    private CodeRepository codeRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    public Code create(Integer workspaceId, String name, String type, String content) {
        Code code = new Code();
        code.workspace = workspaceRepository.findOne(workspaceId);
        code.name = name;
        code.type = type;
        code.content = content;
        codeRepository.saveAndFlush(code);
        return code;
    }
}
