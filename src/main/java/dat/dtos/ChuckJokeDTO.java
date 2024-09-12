package dat.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChuckJokeDTO implements JokePart {

    @JsonProperty("icon_url")  // Map JSON property to this field
    private String iconUrl;
    private String id;
    private String url;
    private String value;  // The joke text

    @Override
    public void addToJokeDTO(JokeDTO jokeDTO) {
        jokeDTO.setChuckJoke(this);
    }

    @Override
    public String getJoke() {
        return value;
    }
}
