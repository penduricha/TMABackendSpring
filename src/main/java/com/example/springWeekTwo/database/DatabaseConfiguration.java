package com.example.springWeekTwo.database;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseConfiguration {
    //lay thong tin cua application.yaml
    @Value("${spring.datasource.host}")
    private String host;

    @Value("${spring.datasource.port}")
    private int port;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.database-name}")
    private String databaseName;
    public String getJdbcUrl() {
        return String.format("jdbc:postgresql://%s:%d/%s",host, port, databaseName);
        //jdbc:postgresql://localhost:5432/school
    }
}