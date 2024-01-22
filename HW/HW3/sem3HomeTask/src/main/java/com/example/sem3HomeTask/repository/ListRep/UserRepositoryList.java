package com.example.sem3HomeTask.repository.ListRep;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("List")
public class UserRepositoryList implements UserRepository {

    private List<User> users;

    public UserRepositoryList(List<User> users) {
        this.users = users;
        this.users.add(new User("Иван", 25, "my@mail.com"));
        this.users.add(new User("Петр", 27, "my1@mail.com"));
        this.users.add(new User("Стас", 30, "my2@mail.com"));
    }
    @Override
    public List<User> getUsers()  {
        return users;
    }
    @Override
    public User addUser(User user) {
        if (user != null) {
            users.add(user);
            return user;
        }
        return null;
    }

}
