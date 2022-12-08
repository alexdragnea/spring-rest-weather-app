package net.dg.springrestweather.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "net.dg.springrestweather.client")
public class ProjectConfig {}
