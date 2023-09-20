package com.tl.soap.demo.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ws.config.annotation.EnableWs;

@SpringBootApplication
@EnableWs
public class SoapServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapServerApplication.class, args);
    }

}
