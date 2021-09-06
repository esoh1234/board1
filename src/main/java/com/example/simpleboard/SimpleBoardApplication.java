package com.example.simpleboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SimpleBoardApplication {

    public static void main(String[] args) {
        System.getProperty("spring.devtools.restart.enabled","false");
        System.getProperty("spring.devtools.livereload.enabled","true");
        SpringApplication.run(SimpleBoardApplication.class, args);
    }

}
