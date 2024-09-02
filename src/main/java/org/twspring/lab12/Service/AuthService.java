package org.twspring.lab12.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.twspring.lab12.Model.User;
import org.twspring.lab12.Repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    public void register(User user) {

        user.setRole("USER");
        String hash= new BCryptPasswordEncoder().encode(user.getPassword());//Hash password
        user.setPassword(hash);

        userRepository.save(user);
    }

    //logout
}
