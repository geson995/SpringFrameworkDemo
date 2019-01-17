package com.hnu.easy_ball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EasyBallApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyBallApplication.class, args);
    }

}

