package se.remchii.musicsharingapi.service;

import org.springframework.stereotype.Service;
import se.remchii.musicsharingapi.model.User;
import se.remchii.musicsharingapi.model.UserRegistration;
import se.remchii.musicsharingapi.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserRegistration userInfo) {
        System.out.println(userInfo);
        return new User();
    }
}
