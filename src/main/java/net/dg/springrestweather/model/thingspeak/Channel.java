package net.dg.springrestweather.model.thingspeak;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Channel {

  private int id;
  private String name;
  private String latitude;
  private String longitude;
  private String field1;
  private String field2;
  private String field3;

  @JsonProperty("created_at")
  private Date createdAt;

  @JsonProperty("updated_at")
  private Date updatedAt;

  @JsonProperty("last_entry_id")
  public int lastEntryId;
}
