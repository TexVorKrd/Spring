package com.example.demo.repositories;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "data.parameter.sql-req")
public class SQLRequestConfig {

    private String findAll;
    private String save;
    private String deleteById;
    private String updateById;
    public SQLRequestConfig() {
    }
}
