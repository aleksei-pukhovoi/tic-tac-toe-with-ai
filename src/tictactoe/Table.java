package tictactoe;

import tictactoe.players.Move;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {
   private final char[][] board;

   public Table(int n) {
      this.board = getTable(n);
   }

   public void print() {
      int lineLength = 3 + board[0].length * 2;
      drawLine(lineLength);
      for (char[] chars :board) {
         System.out.print("| ");
         for (char aChar : chars) {
            System.out.print(aChar + " ");
         }
         System.out.println("|");
      }
      drawLine(lineLength);
   }

   private void drawLine(int lineLength) {
      for (int i = 0; i < lineLength; i++) {
         System.out.print("-");
      }
      System.out.println();
   }

   private char[][] getTable(int n) {
      char[][] array = new char[n][n];
      for (char[] chars : array) {
         Arrays.fill(chars, ' ');
      }
      return array;
   }

   public void setValue(int i, int j, char value) {
      board[i][j] = value;
   }

   public char getValue(int i, int j) {
      return board[i][j];
   }

   public List<Move> getEmptyIndexies() {
      List<Move> emptyIndexies = new ArrayList<>();
      for (int i = 0; i < board.length; i++) {
         for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == ' ') {
               emptyIndexies.add(new Move(i, j));
            }
         }
      }
      return emptyIndexies;
   }

   public boolean isEmptySlot() {
      for (char[] chars : board) {
         for (char ch : chars) {
            if (ch == ' ') {
               return true;
            }
         }
      }
      return false;
   }

   public int getLength() {
      return board.length;
   }
}
