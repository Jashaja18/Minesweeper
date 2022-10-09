/**
 * Jashanpreet Jandu
 * TCSS 360 A
 * Assignment 1: Minesweeper
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("minesweeper_input.txt"));
        minesweeper(input);
    }

    private static void minesweeper(Scanner theScan) {
        int row = theScan.nextInt();
        int col = theScan.nextInt();
        while(row != 0 && col != 0) {
            char[][] board = new char[row][col];
            for(int i = 0; i < row; i++) {
                String line = theScan.next();
                for(int j = 0; j < col; j++) {
                    board[i][j] = line.charAt(j);
                }
            }
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(board[i][j] == '*') {
                        System.out.print('*');
                    } else {
                        System.out.print(countMines(board, i, j));
                    }
                }
                System.out.println();
            }
            System.out.println();
            row = theScan.nextInt();
            col = theScan.nextInt();
        }
    }

    private static int countMines(char[][] theField, int theRow, int theCol) {
        int count = 0;
        for(int i = theRow - 1; i <= theRow + 1; i++) {
            for(int j = theCol - 1; j <= theCol + 1; j++) {
                if(i >= 0 && i < theField.length && j >= 0 && j < theField[0].length) {
                    if(theField[i][j] == '*') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static void printMineField(int[][] theField) {
        for(int i = 0; i < theField.length; i++) {
            for(int j = 0; j < theField[0].length; j++) {
                System.out.print(theField[i][j] + " ");
            }
            System.out.println();
        }
    }
}