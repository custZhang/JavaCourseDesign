package com.zspstu.config;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value = "com.zspstu")
@PropertySource({"classpath:jdbc.properties","classpath:path.properties","classpath:notice.properties"})
@Import({JdbcConfig.class,MybatisConfig.class})
public class SpringConfig {
}
