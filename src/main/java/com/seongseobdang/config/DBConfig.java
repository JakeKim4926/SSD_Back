package com.seongseobdang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {
    "com.seongseobdang.model.dao",
})
public class DBConfig {
}