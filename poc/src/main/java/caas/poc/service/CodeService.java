package caas.poc.service;

import caas.poc.entity.Code;
import caas.poc.entity.Dataset;
import caas.poc.repository.CodeRepository;
import caas.poc.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CodeService {
    @Autowired
    private CodeRepository codeRepository;

    @Autowired
    private WorkspaceRepository workspaceRepository;

    public Code create(Integer workspaceId, String name, String type, String content) {
        Code code = new Code();
        code.workspaceId = workspaceId;
        code.name = name;
        code.type = type;
        code.content = content;
        codeRepository.saveAndFlush(code);
        return code;
    }

    public Code get(Integer id) {
        return codeRepository.getOne(id);
    }

    public List<Code> getList(Integer workspaceId) {
        return codeRepository.findAllByWorkspaceId(workspaceId);
    }
}
