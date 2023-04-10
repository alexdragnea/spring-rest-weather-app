package net.dg.springrestweather;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestWeatherApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringRestWeatherApplication.class, args);
    String[] abbreviations = {
      "IoT", "API", "Aws", "HTTP", "UI", "WiFi", "EN", "BOOT", "I/O", "USB", "UI", "BR", "EDR",
      "ROM", "RAM", "SRAM", "KB", "PWM", "ADC", "SPI", "UART", "DAC", "GPIO", "WFA", "WPA", "WAPI",
      "OTP", "SHA", "RSA", "EEC", "AES", "RNG", "I2C", "AGL", "VIN", "SCL", "SSID", "JSON", "XML",
      "HTML", "CSS", "IAAS", "PAAS", "SAAS", "GMAIL", "EC2", "REST", "URL", "WWW", "URI", "GIT",
      "OOP", "JDK", "JVM", "LTS", "POM", "POJO", "CI/CD", "OWASP", "OWM", "QA", "SUT", "E2E", "CSS",
      "DOM", "JSX", "PR", "YAML", "S3", "RDS", "VCC", "GND", "SDA", "SCL"
    };

    // Sort the array of abbreviations alphabetically
    Arrays.sort(abbreviations);

    // Print the sorted abbreviations
    for (String abbreviation : abbreviations) {
      System.out.println(abbreviation);
    }
  }
}
