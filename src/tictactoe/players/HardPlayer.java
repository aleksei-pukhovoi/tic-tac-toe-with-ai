package tictactoe.players;

import tictactoe.Table;

import java.util.ArrayList;
import java.util.List;

public class HardPlayer extends Player {

    @Override
    public void makeMove(Table table, char input) {
        System.out.println("Making move level \"hard\"");
        Move move = minimax(table, input);
        table.setValue(move.getI(), move.getJ(), input);
    }

    public Move minimax(Table table, char input) {
        List<Move> availSpots = table.getEmptyIndexies();

        // checks for the terminal states such as win, lose, and tie
        if (this.isWinner(table, 'X')) {
            Move move = new Move();
            move.setScore(10);
            return move;
        }
        else if (isWinner(table, 'O')) {
            Move move = new Move();
            move.setScore(-10);
            return move;
        }
        else if (availSpots.size() == 0) {
            Move move = new Move();
            move.setScore(0);
            return move;
        }
        // a list to collect all available moves
        List<Move> moves = collectMoves(table, availSpots, input);

        return getBestMove(moves, input);
    }

    private List<Move> collectMoves(Table table, List<Move> availSpots, char input) {
        List<Move> moves = new ArrayList<>();
        for (Move availSpot : availSpots) {
            int currentI = availSpot.getI();
            int currentJ = availSpot.getJ();
            table.setValue(currentI, currentJ, input);
            Move currentMove = (input == 'X') ? minimax(table, 'O') : minimax(table, 'X');
            currentMove.setI(currentI);
            currentMove.setJ(currentJ);
            table.setValue(currentI, currentJ, ' ');
            moves.add(currentMove);
        }
        return moves;
    }

    private Move getBestMove(List<Move> moves, char input) {
        int bestMove = 0;
        if (input == 'X') {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < moves.size(); i++) {
                int score = moves.get(i).getScore();
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < moves.size(); i++) {
                int score = moves.get(i).getScore();
                if (score < bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }
        return moves.get(bestMove);
    }
}
