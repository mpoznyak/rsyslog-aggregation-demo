package com.mmpoznyak.syslogdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class ServiceAApplication {

    private final ServiceOperations serviceOperations;

    public ServiceAApplication(ServiceOperations serviceOperations) {
        this.serviceOperations = serviceOperations;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceAApplication.class, args);
    }

    @Scheduled(fixedRate = 3000)
    public void scheduleLogin() {
        Random r = new Random();
        var randomIp =  r.nextInt(256) + "." + r.nextInt(256) + "."
                + r.nextInt(256) + "." + r.nextInt(256);
        serviceOperations.login(UUID.randomUUID().toString(), randomIp);
    }

    @Scheduled(fixedRate = 4000)
    public void scheduleUpdateProfile() {
        serviceOperations.updateProfile(UUID.randomUUID().toString(), "profile");
    }

    @Scheduled(fixedRate = 2000)
    public void scheduleLogout() {
        serviceOperations.logout(UUID.randomUUID().toString());
    }

    @Scheduled(fixedRate = 10000)
    public void scheduleDeleteAccount() {
        serviceOperations.deleteAccount(UUID.randomUUID().toString());
    }
}
