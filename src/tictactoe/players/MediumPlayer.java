package tictactoe.players;

import tictactoe.Table;

public class MediumPlayer extends Player {

    @Override
    public void makeMove(Table table, char input) {
        System.out.println("Making move level \"medium\"");
        char anotherInput = (input == 'X') ? 'O' : 'X';
        //check either ai can win and do it
        if (!(checkDiagonals(table, input, input) ||
                checkRows(table, input, input) ||
                //check either another player can win and block it
                checkDiagonals(table, anotherInput, input) ||
                checkRows(table, anotherInput, input))) {
            super.makeMove(table, input);
        }
    }

    private boolean checkRows(Table table, char checkInput, char myInput) {
        char fieldEmpty = ' ';
        int checkSum = checkInput * 2 + fieldEmpty;
        for (int i = 0; i < table.getLength(); i++) {
            int sumI = 0;
            int sumJ = 0;
            int rowI = -1;
            int rowJ = -1;
            int columnI = -1;
            int columnJ = -1;
            for (int j = 0; j < table.getLength(); j++) {
                if (table.getValue(i, j) == fieldEmpty) {
                    rowI = i;
                    rowJ = j;
                }
                if (table.getValue(j, i) == fieldEmpty) {
                    columnI = j;
                    columnJ = i;
                }
                sumI += table.getValue(i, j);
                sumJ += table.getValue(j, i);
            }
            if (sumI == checkSum) {
                table.setValue(rowI, rowJ, myInput);
                return true;
            }
            if (sumJ == checkSum) {
                table.setValue(columnI, columnJ, myInput);
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(Table table, char checkInput, char myInput) {
        char fieldEmpty = ' ';
        int checkSum = checkInput * 2 + fieldEmpty;
        int n = table.getLength();
        int diag1 = 0;
        int diag2 = 0;
        int diag1I = -1;
        int diag1J = -1;
        int diag2I = -1;
        int diag2J = -1;
        for (int i = 0; i < n; i++) {
            if (table.getValue(i, i) == fieldEmpty) {
                diag1I = i;
                diag1J = i;
            }
            if (table.getValue(i, n - 1 - i) == fieldEmpty) {
                diag2I = i;
                diag2J = n - 1 - i;
            }
            diag1 += table.getValue(i, i);
            diag2 += table.getValue(i, n - 1 - i);
        }
        if (diag1 == checkSum) {
            table.setValue(diag1I, diag1J, myInput);
            return true;
        }
        if (diag2 == checkSum) {
            table.setValue(diag2I, diag2J, myInput);
            return true;
        }
        return false;
    }
}
