package caas.poc.service;

import caas.poc.entity.User;
import caas.poc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Object create(String name, String password) {
        User user = new User();
        user.name = name;
        user.password = password;
        userRepository.saveAndFlush(user);
        return user;
    }

    public Object update(Integer id, String name, String password) {
        User user = userRepository.findOne(id);
        user.name = name;
        user.password = password;
        userRepository.saveAndFlush(user);
        return user;
    }

    public void remove(Integer id) {
        userRepository.delete(id);
    }

    public Object find(Integer id) {
        return userRepository.findOne(id);
    }

    public Object findByName(String name) {
        return userRepository.findByName(name);
    }

    public Boolean exists(Integer id) {
        return userRepository.exists(id);
    }

    public Boolean existsName(String name) {
        return userRepository.existsByName(name);
    }

}
