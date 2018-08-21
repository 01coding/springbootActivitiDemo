package com.zjrodger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class
})
@ComponentScan
public class BootServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootServerApplication.class, args);
        System.out.println("SpringBoot应用启动成功。");
    }

}
