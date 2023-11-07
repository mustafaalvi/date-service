package com.hour.carmedy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class DateService {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SpringApplication.run(DateService.class, args);
    }
}