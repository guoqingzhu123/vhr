package com.example.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.example.vhr.mapper")
@EnableSwagger2
@SpringBootApplication
public class VhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrApplication.class, args);
    }

}
