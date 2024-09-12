package dat.dtos;

import lombok.Data;

@Data
public class DadJokeDTO implements JokePart {


    private String id;
    private String joke;
    private String status;

    @Override
    public void addToJokeDTO(JokeDTO jokeDTO) {
        jokeDTO.setDadJoke(this);
    }

    @Override
    public String getJoke() {
        return joke;
    }
}
