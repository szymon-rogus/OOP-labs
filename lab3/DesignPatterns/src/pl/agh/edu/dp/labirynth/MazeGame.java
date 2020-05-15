package pl.agh.edu.dp.labirynth;

public class MazeGame {
    public Maze createMaze(MazeFactory mazeFactory) throws IllegalAccessException {

        Maze maze = mazeFactory.createMaze();

        return maze;
    }
}
