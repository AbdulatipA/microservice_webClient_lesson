package org.example.service_b;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public User createUser(User user) {
        return userRepo.save(user);
    }
}
