package tictactoe.players;

import tictactoe.Table;

import java.util.Random;

public class Player {

    public void makeMove(Table table, char input) {
        int n = table.getLength();
        Random random = new Random(n * 2L);
        while (true) {
            int i = random.nextInt(n);
            int j = random.nextInt(n);
            if (table.getValue(i, j) == ' ') {
                table.setValue(i, j, input);
                break;
            }
        }
    }

    public boolean isWinner(Table table, char input) {
        //check diagonals
        int n = table.getLength();
        int check1 = 0;
        int check2 = 0;
        for (int i = 0; i < n; i++) {
            check1 += table.getValue(i, i);
            check2 += table.getValue(i, n - 1 - i);
        }
        if (check1 == input * 3 || check2 == input * 3) {
            return true;
        }
        //check rows
        for (int i = 0; i < n; i++) {
            check1 = 0;
            check2 = 0;
            for (int j = 0; j < n; j++) {
                check1 += table.getValue(i, j);
                check2 += table.getValue(j, i);
            }
            if (check1 == input * 3 || check2 == input * 3) {
                return true;
            }
        }
        return false;
    }
}
