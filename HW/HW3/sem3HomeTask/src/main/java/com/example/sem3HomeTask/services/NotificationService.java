package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyUser(User user) {
        if (user!=null){
            System.out.println("A new user has been created: " + user.getName());
        }else {
            System.out.println("Cant create new user");
        }
    }

    public void sendNotification(String s) {
        System.out.println(s);
    }


}
