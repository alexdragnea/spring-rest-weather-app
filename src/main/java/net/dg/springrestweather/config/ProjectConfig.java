package net.dg.springrestweather.config;

import feign.Retryer;
import net.dg.springrestweather.client.errordecoder.FeignErrorDecoder;
import net.dg.springrestweather.client.retryer.CustomRetryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "net.dg.springrestweather.client")
public class ProjectConfig {

  @Bean
  public FeignErrorDecoder feignErrorDecoder() {
    return new FeignErrorDecoder();
  }

  @Bean
  public Retryer retryer() {
    return new CustomRetryer();
  }
}
