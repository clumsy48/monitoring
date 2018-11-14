package com.github.clumsy;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@Configuration
@Profile({"test"})
public class CustomMetric {

    private Counter counter = Metrics.counter("handler.calls", "uri", "/messages");

    private static int metricValue = 0;

    @Scheduled(initialDelay = 3000, fixedRate = 5000)
    public int getCustomMetricValue() {
        log.debug("current value {} ", metricValue);
        counter.increment();
        return metricValue++;
    }
}
