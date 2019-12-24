package io.amoe.design.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DesignPatternApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DesignPatternApplication.class, args);
    }

}
