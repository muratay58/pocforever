package com.ayceay.main;

import com.ayceay.configuration.MainConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com.ayceay"})
public class MainServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                new Class[]
                        {MainServerApplication.class
                                , MainConfiguration.class}
                , args);
    }
}
