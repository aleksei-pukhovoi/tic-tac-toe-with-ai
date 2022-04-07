package tictactoe.players;

import tictactoe.Table;

public class EasyPlayer extends Player {

    @Override
    public void makeMove(Table table, char input) {
        System.out.println("Making move level \"easy\"");
        super.makeMove(table, input);
    }
}
