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
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            int r = input.nextInt();
            int c = input.nextInt();
            char[][] grid = new char[r][c];
            for (int j = 0; j < r; j++) {
                String line = input.next();
                for (int k = 0; k < c; k++) {
                    grid[j][k] = line.charAt(k);
                }
            }
            System.out.println("Field #" + (i + 1) + ":");
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (grid[j][k] == '*') {
                        System.out.print('*');
                    } else {
                        int count = 0;
                        if (j > 0 && k > 0 && grid[j - 1][k - 1] == '*') {
                            count++;
                        }
                        if (j > 0 && grid[j - 1][k] == '*') {
                            count++;
                        }
                        if (j > 0 && k < c - 1 && grid[j - 1][k + 1] == '*') {
                            count++;
                        }
                        if (k > 0 && grid[j][k - 1] == '*') {
                            count++;
                        }
                        if (k < c - 1 && grid[j][k + 1] == '*') {
                            count++;
                        }
                        if (j < r - 1 && k > 0 && grid[j + 1][k - 1] == '*') {
                            count++;
                        }
                        if (j < r - 1 && grid[j + 1][k] == '*') {
                            count++;
                        }
                        if (j < r - 1 && k < c - 1 && grid[j + 1][k + 1] == '*') {
                            count++;
                        }
                        System.out.print(count);
                    }
                }
                System.out.println();
            }
            if (i < n - 1) {
                System.out.println();
            }
        }
    }
}

//        int row  = input.nextInt();
//        int col = input.nextInt();
//        int fieldCase = 1;
//        while (row != 0 || col != 0){
//            char[][] field = new char[row][col];
//            for (int i = 0; i < row; i++){
//                String line = input.next();
//                for (int j = 0; j < col; j++){
//                    field[i][j] = line.charAt(j);
//                }
//            }
//            System.out.println("Field #" + fieldCase + ":");
//            for (int i = 0; i < row; i++){
//                for (int j = 0; j < col; j++){
//                    if (field[i][j] == '*'){
//                        System.out.print("*");
//                    } else {
//                        int count = 0;
//                        if (i > 0 && j > 0 && field[i-1][j-1] == '*'){
//                            count++;
//                        }
//                        if (i > 0 && field[i-1][j] == '*'){
//                            count++;
//                        }
//                        if (i > 0 && j < col-1 && field[i-1][j+1] == '*'){
//                            count++;
//                        }
//                        if (j > 0 && field[i][j-1] == '*'){
//                            count++;
//                        }
//                        if (j < col-1 && field[i][j+1] == '*'){
//                            count++;
//                        }
//                        if (i < row-1 && j > 0 && field[i+1][j-1] == '*'){
//                            count++;
//                        }
//                        if (i < row-1 && field[i+1][j] == '*'){
//                            count++;
//                        }
//                        if (i < row-1 && j < col-1 && field[i+1][j+1] == '*'){
//                            count++;
//                        }
//                        System.out.print(count);
//                    }
//                }
//                System.out.println();
//            }
//            row = input.nextInt();
//            col = input.nextInt();
//            if (row != 0 || col != 0){
//                System.out.println();
//            }
//            fieldCase++;
//        }
//    }
//}
