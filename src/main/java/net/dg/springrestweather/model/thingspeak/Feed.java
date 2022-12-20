package net.dg.springrestweather.model.thingspeak;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Feed {

  @JsonProperty("created_at")
  private Date createdAt;

  @JsonProperty("entry_id")
  private int entryId;

  private String field1;
  private String field2;
  private String field3;
}
