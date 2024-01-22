package com.example.sem3HomeTask.repository.H2Rep;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("H2")
public class UserRepositoryH2 implements UserRepository {

    private List<User> users;
    private final JdbcTemplate jdbc;

    SQLRequestConfig sqlRequestConfig;

    public UserRepositoryH2(JdbcTemplate jdbc, SQLRequestConfig sqlRequestConfig) {

        this.jdbc = jdbc;
        this.sqlRequestConfig = sqlRequestConfig;

        String sql = sqlRequestConfig.getFindAll();

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setAge(r.getInt("age"));
            rowObject.setName(r.getString("name"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };

        this.users = this.jdbc.query(sql, userRowMapper);

    }
    @Override
    public List<User> getUsers() {
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