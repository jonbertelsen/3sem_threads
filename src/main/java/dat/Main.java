package dat;

import dat.dtos.ChuckJokeDTO;
import dat.dtos.DadJokeDTO;
import dat.dtos.JokeDTO;

public class Main {
    public static void main(String[] args) {

        JokeDTO jokeDTO = new JokeDTO();
        DadJokeDTO dadJokeDTO = JokeService.fetchDadjoke();
        dadJokeDTO.addToJokeDTO(jokeDTO);
        ChuckJokeDTO chuckJokeDTO = JokeService.fetchChuckJoke();
        chuckJokeDTO.addToJokeDTO(jokeDTO);
        System.out.println(jokeDTO.getDadJoke().getJoke());
        System.out.println(jokeDTO.getChuckJoke().getJoke());

        // Record the start time
        long startTime = System.currentTimeMillis();

        CallableFutureExample.runTasks();

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Task runtime: " + duration + " milliseconds");
    }
}
