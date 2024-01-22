package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private NotificationService notificationService;

    private UserRepository userRepository;

    public void createUser(User user) {
        if (user != null) userRepository.addUser(user);
        notificationService.notifyUser(user);
    }
}
