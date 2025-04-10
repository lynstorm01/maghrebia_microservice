package tn.esprit.pisinister;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.context.annotation.Bean;


import tn.esprit.pisinister.Entity.Status;
import tn.esprit.pisinister.Repository.SinisterRepository;
import tn.esprit.pisinister.Entity.Sinister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient

public class PiSinisterApplication {
    @Autowired
    private SinisterRepository sinisterRepository;

    public static void main(String[] args) {
        SpringApplication.run(PiSinisterApplication.class, args);
    }



}

