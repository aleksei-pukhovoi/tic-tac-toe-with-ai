package tictactoe;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int n = 3;
        Game game = new Game(sc);
        game.startGame(n);
    }
}
