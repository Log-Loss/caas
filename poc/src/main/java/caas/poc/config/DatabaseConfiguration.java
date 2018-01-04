package caas.poc.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class DatabaseConfiguration {
    @EventListener(ApplicationReadyEvent.class)
    void config() {
        System.out.println(1);
    }
}