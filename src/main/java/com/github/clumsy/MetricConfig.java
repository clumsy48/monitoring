package com.github.clumsy;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
@Profile({"test"})
@RequiredArgsConstructor
public class MetricConfig {

    private final MeterRegistry meterRegistry;

    @Bean
    public Counter getSimpleCounter(){
        return Counter.builder("simpleCounter")
                .tag("dev", "performance")
                .description("simple counter")
                .register(meterRegistry);
    }
    @Bean
    public Timer getTimer(){
        return Timer.builder("simpleTimer")
                .tag("dev", "performance")
                .description("simple timer")
                .register(meterRegistry);
    }
}
