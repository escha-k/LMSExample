package com.zerobase.fastlms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FastlmsApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FastlmsApplication.class, args);
    }
    
}
