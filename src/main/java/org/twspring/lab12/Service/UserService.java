package org.twspring.lab12.Service;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.twspring.lab12.Api.ApiException;
import org.twspring.lab12.Model.User;
import org.twspring.lab12.Repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //register/post is within the AuthService

    public void updateUser(Integer userId, User user) {
        User oldUser = userRepository.findUserById(userId);

        oldUser.setUsername(user.getUsername());
        String hash= new BCryptPasswordEncoder().encode(user.getPassword());
        oldUser.setPassword(hash);
        userRepository.save(oldUser);
    }

    public void deleteUserByTheUser(User user) {
        userRepository.delete(user);
    }

    public void deleteUserByAdmin(Integer userId) {
        User user = userRepository.findUserById(userId);
        if (user == null) {
            throw new ApiException("user not found");
        }
        userRepository.delete(user);
    }
}
