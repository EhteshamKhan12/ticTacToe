package tictactoe;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char[][] field = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = ' ';
            }
        }
        printArray(field);
                
        boolean gameOver = false;
         if (win(field, 'X') & !win(field, 'O')) {
            System.out.println("X wins");
            System.exit(0);
            gameOver = true;
        }

        if (!win(field, 'X') & win(field, 'O')) {
            System.out.println("O wins");
            System.exit(0);
            gameOver = true;
        }
            
          
        while (true) {
            System.out.println("Enter the coordinates: ");
            try {
                int a = Integer.parseInt(scanner.next());
                int b = Integer.parseInt(scanner.next());
                boolean draw = draw(field);
                if (a > 3 || b > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                } else if (field[a - 1][b - 1] == 'X' || field[a - 1][b - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                } else if (win(field, 'X') & !win(field, 'O')) {
                    System.out.println("X wins");
                    System.exit(0);
                    gameOver = true;
                    } else if (!win(field, 'X') & win(field, 'O')) {
                    System.out.println("O wins");
                    System.exit(0);
                    gameOver = true;
                } else if (draw) {
                    System.out.println("Draw");
                    System.exit(0);
                } else {
                    int countx = countX(field);
                    int counto = countO(field);
                    if (countx == counto) {
                        field[a - 1][b - 1] = 'X';
                        printArray(field);
                    } else {
                        field[a - 1][b - 1] = 'O';
                        printArray(field);
                    }
               }            
            } catch (NumberFormatException nfe) {
                    System.out.println("You should enter numbers!");
                    continue;
            }
        }
     
    }
    
    static int countX (char[][] array) {
        int xCount = 0;
        // int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 'X')
                xCount++;
            }
        }
        return xCount;
    }
    static int countO (char[][] array) {
        int oCount = 0;
        // int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == 'O')
                oCount++;
            }
        }
        return oCount;
    }
    
    static boolean draw(char[][] array) {
        boolean draww = true;
        // boolean flag = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] == ' ') {
                    // flag = false;
                    draww = false;
                }  
            }
        }
        return draww;    
    }

    static void printArray(char[][] array) {
        
        int q = 0;
        char[] arrayyy = new char[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrayyy[q++] = array[i][j];            
            }
        }
        int u = 0;
        System.out.println("---------");
        for (int j = 0; j < 3; j++) {
            System.out.printf("| %c %c %c |%n", arrayyy[u++], arrayyy[u++], arrayyy[u++]);
        }
        System.out.println("---------");
    }

    static boolean horizontalWin(char[][] array, char c) {
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            if (array[i][0] == c & array[i][0] == array[i][1] & array[i][1] == array[i][2]) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    static boolean verticalWin(char[][] array, char c) {
        boolean flag = false;
        for (int j = 0; j < 3; j++) {
            if (array[0][j] == c & array[0][j] == array[1][j] & array[1][j] == array[2][j]) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    static boolean diagonalWin(char[][] array, char c) {
        boolean flag = false;
        if (array[0][0] == c & array[0][0] == array[1][1] & array[1][1] == array[2][2]) {
            flag = true;
        }
        if (array[0][2] == c & array[0][2] == array[1][1] & array[1][1] == array[2][0]) {
            flag = true;
        }
        return flag;
    }

    static boolean win(char[][] array, char c) {
        return verticalWin(array, c) | horizontalWin(array, c) | diagonalWin(array, c);
    }
}
