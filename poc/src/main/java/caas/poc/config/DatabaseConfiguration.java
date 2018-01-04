package caas.poc.config;

import caas.poc.repository.WorkspaceRepository;
import caas.poc.service.DatasetService;
import caas.poc.service.ModelService;
import caas.poc.service.UserService;
import caas.poc.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class DatabaseConfiguration {
    @Autowired
    UserService userService;

    @Autowired
    WorkspaceService workspaceService;

    @Autowired
    DatasetService datasetService;

    @Autowired
    ModelService modelService;

    @EventListener(ApplicationReadyEvent.class)
    public void config() {
        userService.create("user@email.com", "password");
        userService.create("user1@email.com", "password1");
        userService.create("user2@email.com", "password2");

        workspaceService.create(1, "workspace");
        workspaceService.create(1, "workspace1");

        workspaceService.create(2, "2workspace");
        workspaceService.create(2, "2workspace1");



    }
}