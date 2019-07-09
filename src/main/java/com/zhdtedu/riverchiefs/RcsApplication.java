package com.zhdtedu.riverchiefs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.zhdtedu.riverchiefs.dao.*","com.zhdtedu.core.dao"})
public class RcsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RcsApplication.class, args);
    }

}
