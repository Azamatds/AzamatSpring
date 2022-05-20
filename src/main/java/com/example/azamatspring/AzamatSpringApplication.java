package com.example.azamatspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AzamatSpringApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AzamatSpringApplication.class, args);

    }
}
