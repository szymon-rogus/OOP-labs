package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, IllegalAccessException {

        //
        MazeGame mazeGame = new MazeGame();
        MazeFactory m1 = MazeFactory.getInstance();
        MazeFactory m2 = MazeFactory.getInstance();

        if(m1.equals(m2)){
            System.out.println("Equals!");
        }
    }
}



