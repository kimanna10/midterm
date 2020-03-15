package com.anna.Mid.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


//Configuration class
@Configuration
@ComponentScan("com.anna.Mid")
@PropertySource("application.properties")
public class Config {
}