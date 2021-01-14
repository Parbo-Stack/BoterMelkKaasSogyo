package novi.basics;

import java.util.Scanner;

import static novi.basics.DrawBoard.drawBoard;
import static novi.basics.PlayerHasWon.playerHasWon;


public class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Let's play Tic Tac Toe!");
        System.out.print("Player 1, what is your name? ");
        String p1 = in.nextLine();
        System.out.print("Player 2, what is your name? ");
        String p2 = in.nextLine();


        boolean player1 = true;


        boolean gameEnded = false;
        while (!gameEnded) {


            drawBoard(board);

            if (player1) {
                System.out.println(p1 + "'s Turn (x):");
            } else {
                System.out.println(p2 + "'s Turn (o):");
            }

            char c = '-';
            if (player1) {
                c = 'x';
            } else {
                c = 'o';
            }


            int row = 0;
            int col = 0;


            while (true) {


                System.out.print("Enter a row number (0, 1, or 2): ");
                row = in.nextInt();
                System.out.print("Enter a column number (0, 1, or 2): ");
                col = in.nextInt();


                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("This position is off the bounds of the board! Try again.");


                } else if (board[row][col] != '-') {
                    System.out.println("Someone has already made a move at this position! Try again.");


                } else {
                    break;
                }

            }


            board[row][col] = c;

            if (playerHasWon(board) == 'x') {
                System.out.println(p1 + " has won!");
                gameEnded = true;
            } else if (playerHasWon(board) == 'o') {
                System.out.println(p2 + " has won!");
                gameEnded = true;
            } else {


                if (boardIsFull(board)) {
                    System.out.println("It's a tie!");
                    gameEnded = true;
                } else {

                    player1 = !player1;
                }

            }

        }

        drawBoard(board);
    }


    //Make a function to check if all of the positions on the board have been filled
    public static boolean boardIsFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}

