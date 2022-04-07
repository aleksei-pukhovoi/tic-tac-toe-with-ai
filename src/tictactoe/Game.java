package tictactoe;

import tictactoe.players.*;

import java.util.Scanner;

public class Game {

    private final Scanner scanner;
    private Player playerOne;
    private Player playerTwo;
    private final char inputX;
    private final char inputO;

    public Game(Scanner scanner) {
        this.scanner = scanner;
        inputX = 'X';
        inputO = 'O';
    }

    public void startGame(int n) {
        String[] players = {"user", "easy", "medium", "hard"};
        while (true) {
            System.out.print("Input command: > ");
            String[] inputCommands = getLines(scanner.nextLine());
            if (inputCommands[0].equals("exit")) {
                break;
            }
            if (!isInputCommand(inputCommands, players)) {
                continue;
            }
            Table table = new Table(n);
            play(table, n);
        }
    }

    private void play(Table table, int n) {
        table.print();
        while (true) {
            //move player1
            playerOne.makeMove(table, inputX);
            table.print();
            if (isResult(playerOne, table, n, inputX)) {
                break;
            }
            //move player2
            playerTwo.makeMove(table, inputO);
            table.print();
            if (isResult(playerTwo, table, n, inputO)) {
                break;
            }
        }
    }

    private boolean isInputCommand(String[] inputCommands, String[] players) {
        String badInput = "Bad parameters!";
        if (inputCommands.length == 3 &&
                inputCommands[0].equals("start") &&
                isPlayer(inputCommands[1], players) &&
                isPlayer(inputCommands[2], players)) {
            playerOne = getPlayer(inputCommands[1]);
            playerTwo = getPlayer(inputCommands[2]);
            return true;
        }
        System.out.println(badInput);
        return false;
    }

    private Player getPlayer(String player) {
        switch (player) {
            case ("user"):
                return new UserPlayer(scanner);
            case ("easy"):
                return new EasyPlayer();
            case ("medium"):
                return new MediumPlayer();
            case ("hard"):
                return new HardPlayer();
        }
        throw new IllegalArgumentException();
    }

    private String[] getLines(String input) {
        String[] lines = input.split(" ");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replace(" ", "");
        }
        return lines;
    }

    private boolean isPlayer(String input, String... players) {
        for (String player : players) {
            if (player.equals(input)) {
                return true;
            }
        }
        return false;
    }

    private boolean isResult(Player player, Table table, int n, char input) {
        if (player.isWinner(table, input)) {
            System.out.println(input + " wins");
            return true;
        }
        if (!table.isEmptySlot()) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
}
