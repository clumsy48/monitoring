package com.github.clumsy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RequiredArgsConstructor
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@RestController
@Slf4j
public class Application {
    private final ApplicationContext applicationContext;
    private final DataSource dataSource;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(){
        return "Hello Prometheus";
    }

}
