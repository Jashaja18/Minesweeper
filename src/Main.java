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

    private static int countMines(int[][] mineField, int i, int j) {
        int count = 0;
        if (i > 0 && j > 0 && mineField[i - 1][j - 1] == 1) {
            count++;
        }
        if (i > 0 && mineField[i - 1][j] == 1) {
            count++;
        }
        if (i > 0 && j < mineField[0].length - 1 && mineField[i - 1][j + 1] == 1) {
            count++;
        }
        if (j > 0 && mineField[i][j - 1] == 1) {
            count++;
        }
        if (j < mineField[0].length - 1 && mineField[i][j + 1] == 1) {
            count++;
        }
        if (i < mineField.length - 1 && j > 0 && mineField[i + 1][j - 1] == 1) {
            count++;
        }
        if (i < mineField.length - 1 && mineField[i + 1][j] == 1) {
            count++;
        }
        if (i < mineField.length - 1 && j < mineField[0].length - 1 && mineField[i + 1][j + 1] == 1) {
            count++;
        }
        return count;
    }

    private static void printMineField(int[][] mineField) {
        for (int[] ints : mineField) {
            for (int j = 0; j < mineField[0].length; j++) {
                System.out.print(ints[j]);
            }
            System.out.println();
        }
    }
}