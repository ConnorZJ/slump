package com.xzj.slump;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xzj.slump.dao")
public class SlumpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlumpApplication.class, args);
    }

}
