package com.example.jpaexampleproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class }) // исключить класс DataSource
public class JpaExampleProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaExampleProjectApplication.class, args);
    }

}
