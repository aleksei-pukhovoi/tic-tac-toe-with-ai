package tictactoe.players;

import tictactoe.Table;

import java.util.Scanner;

public class UserPlayer extends Player {
    private final Scanner scanner;

    public UserPlayer(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void makeMove(Table table, char input) {
        while (true) {
            System.out.print("Enter the coordinates: > ");
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                continue;
            }
            String[] symbols = line.split(" +");
            if (symbols.length != 2) {
                System.out.println("You should enter numbers!");
                continue;
            }
            String strI = symbols[0];
            String strJ = symbols[1];
            if (strI.matches("[0-9]+") && strJ.matches("[0-9]+")) {
                int i = Integer.parseInt(strI) - 1;
                int j = Integer.parseInt(strJ) - 1;
                if (i >= 0 && i < 3 && j >= 0 && j < 3) {
                    if (table.getValue(i, j) == ' ') {
                        table.setValue(i, j, input);
                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
