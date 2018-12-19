package com.github.clumsy;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalTime;

@RequiredArgsConstructor
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@RestController
@Slf4j
public class Application implements CommandLineRunner {

    private final Counter counter;
    private final Timer timer;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        while (true){
            Duration start = Duration.ofNanos(LocalTime.now().getNano());

            Thread.sleep(1000);
            counter.increment();
            Duration end = Duration.ofNanos(LocalTime.now().getNano());
            timer.record(Duration.ofNanos(end.getNano()-start.getNano()));

        }
    }
}
