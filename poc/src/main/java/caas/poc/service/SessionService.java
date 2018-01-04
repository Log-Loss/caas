package caas.poc.service;

import caas.poc.entity.User;
import caas.poc.repository.SessionRepository;
import caas.poc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;


}
