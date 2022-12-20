package net.dg.springrestweather.client.thingspeak;

import net.dg.springrestweather.model.thingspeak.ThingSpeakResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ThingSpeakClient", url = "${thingSpeak.url}", decode404 = true)
public interface ThingSpeakClient {

  @GetMapping("/feeds.json")
  ThingSpeakResponse getData(
      @RequestParam("api_key") String apiKey, @RequestParam("results") String results);
}
