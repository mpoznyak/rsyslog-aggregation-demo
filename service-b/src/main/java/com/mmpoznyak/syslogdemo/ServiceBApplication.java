package com.mmpoznyak.syslogdemo;

import com.mmpoznyak.syslogdemo.logging.Audit;
import com.mmpoznyak.syslogdemo.logging.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableScheduling
public class ServiceBApplication {

    private final ServiceOperations serviceOperations;

    public ServiceBApplication(ServiceOperations serviceOperations) {
        this.serviceOperations = serviceOperations;
    }

    public static void main(String[] args) {

        SpringApplication.run(ServiceBApplication.class, args);
    }

    @Scheduled(fixedRate = 3000)
    public void printAnyNotImportant() {
        serviceOperations.printAnyNotImportant(UUID.randomUUID().toString());
    }

    @Scheduled(fixedRate = 2000)
    public void scheduleUpdateProfile() {
        serviceOperations.updateProfile(UUID.randomUUID().toString(), "orders");
    }

}
