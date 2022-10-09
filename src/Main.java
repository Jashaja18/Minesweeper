/**
 * Jashanpreet Jandu
 * TCSS 360 A
 * Assignment 1: Minesweeper
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        minesweeper(input);
    }

    private static void minesweeper(Scanner theScan) {
        int row = theScan.nextInt();
        int col = theScan.nextInt();
        int fMine = 1;
        int[][] mineField = new int[row][col];
        while (row != 0 && col != 0) {
            for (int i = 0; i < row; i++) {
                String line = theScan.next();
                for (int j = 0; j < col; j++) {
                    if (line.charAt(j) == '*') {
                        mineField[i][j] = fMine;
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mineField[i][j] != fMine) {
                        mineField[i][j] = countMines(mineField, i, j);
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mineField[i][j] == fMine) {
                        System.out.print("*");
                    } else {
                        System.out.print(mineField[i][j]);
                    }
                }
                System.out.println();
            }
            row = theScan.nextInt();
            col = theScan.nextInt();
            if (row != 0 && col != 0) {
                System.out.println();
            }
        }
    }

    private static int countMines(int[][] theField, int theRow, int theCol) {
        int count = 0;
        int fMine = 1;
        int row = theField.length;
        int col = theField[0].length;
        if (theRow - 1 >= 0 && theCol - 1 >= 0 && theField[theRow - 1][theCol - 1] == fMine) {
            count++;
        }
        if (theRow - 1 >= 0 && theField[theRow - 1][theCol] == fMine) {
            count++;
        }
        if (theRow - 1 >= 0 && theCol + 1 < col && theField[theRow - 1][theCol + 1] == fMine) {
            count++;
        }
        if (theCol - 1 >= 0 && theField[theRow][theCol - 1] == fMine) {
            count++;
        }
        if (theCol + 1 < col && theField[theRow][theCol + 1] == fMine) {
            count++;
        }
        if (theRow + 1 < row && theCol - 1 >= 0 && theField[theRow + 1][theCol - 1] == fMine) {
            count++;
        }
        if (theRow + 1 < row && theField[theRow + 1][theCol] == fMine) {
            count++;
        }
        if (theRow + 1 < row && theCol + 1 < col && theField[theRow + 1][theCol + 1] == fMine) {
            count++;
        }
        return count;
    }

    private static void printMineField(int[][] theField) {
        for (int[] ints : theField) {
            for (int j = 0; j < theField[0].length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }
}