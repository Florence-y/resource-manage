package com.florence.resources;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Florence
 */
@SpringBootApplication
@MapperScan("com.florence.resources.mapper")
public class ResourcesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResourcesApplication.class, args);
    }

}
