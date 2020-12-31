package com.scistor;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 巍(Vision)
 * @version 1.0
 * @date 2020/12/31 15:19
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.scistor"})
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }

}
