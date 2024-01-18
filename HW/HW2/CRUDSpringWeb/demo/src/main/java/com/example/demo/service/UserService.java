package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * Удаляет пользователя по id из БД
     * @param id - id Пользователя
     */
    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    /**
     * Обновляет данные пользователя
      * @param user
     */
    public void updateById(User user){
        userRepository.updateById(user);
    }

    /**
     * Получаем пользователя по id
     * @param id - id пользователя
     */
    public User getUserById(int id){
        List<User> usrs=userRepository.getUserById(id);
        return usrs.get(0);

    }

}
