package net.dg.springrestweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class SpringRestWeatherApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringRestWeatherApplication.class, args);
  }
}
