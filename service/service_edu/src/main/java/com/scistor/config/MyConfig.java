package com.scistor.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 巍(Vision)
 * @version 1.0
 * @date 2020/12/31 15:22
 */

@Configuration
@MapperScan("com.scistor.mapper")
public class MyConfig {

}
