package com.adria.middlepf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class MiddlePfApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MiddlePfApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
    }
    @Bean
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder();
    }
}
