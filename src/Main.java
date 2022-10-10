/**
 * Jashanpreet Jandu
 * TCSS 360 A
 * Assignment 1: Minesweeper
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class is the main class of the program. It reads the input file and
 * creates a new game board. It then prints the board and starts the game.
 *
 * @author Jashanpreet Jandu
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("minesweeper_input.txt"));
        minesweeper(input);
    }

    /**
     * This method will read the input file and print the output to the console.
     * @param theScan the input file
     */
    private static void minesweeper(Scanner theScan) {
        int row = theScan.nextInt();
        int col = theScan.nextInt();
        int fMine = 1;
        while(row != 0 && col != 0) {
            char[][] board = new char[row][col];
            for (int i = 0; i < row; i++) {
                String line = theScan.next();
                for (int j = 0; j < col; j++) {
                    board[i][j] = line.charAt(j);
                }
            }
            // this will print the board
            printMineField(board, fMine);
            row = theScan.nextInt();
            col = theScan.nextInt();
            fMine++;
        }
    }

    /**
     * This method will print the minefield.
     * @param theRow the minefield
     * @param theCol the first mine
     */
    private static void countMines(int[][] theField, int theRow, int theCol) {
        int count = 0;
        for(int i = theRow - 1; i <= theRow + 1; i++) {
            for(int j = theCol - 1; j <= theCol + 1; j++) {
                if(i >= 0 && i < theField.length && j >= 0 && j < theField[0].length) {
                    if(theField[i][j] == 1) {
                        count++;
                    }
                }
            }
        }
        System.out.print(count);
    }

    /**
     * This method will print the minefield.
     * @param theMine the minefield
     * @param theField the first mine
     */
    private static void printMineField(char[][] theField, int theMine) {
        int[][] mineField = new int[theField.length][theField[0].length];
        System.out.println("Field #" + theMine + ":");
        for(int i = 0; i < theField.length; i++) {
            for(int j = 0; j < theField[0].length; j++) {
                if(theField[i][j] == '*') {
                    mineField[i][j] = 1;
                }
            }
        }
        // this will print the minefield with the numbers
        for(int i = 0; i < theField.length; i++) {
            for(int j = 0; j < theField[0].length; j++) {
                if(theField[i][j] == '*') {
                    System.out.print('*');
                } else {
                    countMines(mineField, i, j);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}