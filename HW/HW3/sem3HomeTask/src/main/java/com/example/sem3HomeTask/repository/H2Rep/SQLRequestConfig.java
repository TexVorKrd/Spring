package com.example.sem3HomeTask.repository.H2Rep;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@ConfigurationProperties(prefix = "data.parameter.sql-req")
public class SQLRequestConfig {

    private String findAll;
    private String save;

}
