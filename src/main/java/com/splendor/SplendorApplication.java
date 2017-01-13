package com.splendor;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SplendorApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

//		SpringApplication.run(SplendorApplication.class, args);
        new SplendorApplication()
                .configure(new SpringApplicationBuilder(SplendorApplication.class))
                .run(args);
    }
}
