package com.bridgelabz.ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final Scanner scanner = new Scanner(System.in);
    private char board[] = new char[10];
    private char usersymbol, computersymbol;
    private int player = 0;

    TicTacToe() {
        createBoard();
        tossForFirstPlay();
        takeUserInput();
    }

    /**
     * created a method named createboard. it will iterate this for loop from 1 to
     * 10. Board valus assigned empty space.
     */
    private void createBoard() {
        for (int count = 1; count < 10; count++) {
            board[count] = ' ';
        }
    }

    /**
     * It'll take user input 'x' and '0'. Compare those to assign the values whether
     * it's computersymbol or usersymbol.
     */
    private void takeUserInput() {
        System.out.println("Your turn:(Choose x or o) ");
        String symbol = scanner.next();
        if (symbol.equals("x")) {
            usersymbol = 'x';
            computersymbol = 'o';
        } else if (symbol.equals("o")) {
            usersymbol = 'o';
            computersymbol = 'x';
        } else {
            System.out.println("invalid option");
        }
    }

    /**
     * this showBoard method is showing the empty board of 3*3 matrices. inside this
     * board it'll take the board values assigned empty space.
     */

    private void showBoard() {
        String horizontalPart = "+---+---+---+";
        for (int row = 0; row < 3; row++) {
            System.out.println(horizontalPart);
            for (int coloumn = 1; coloumn < 4; coloumn++) {
                System.out.print("| " + board[row * 3 + coloumn] + " ");
            }
            System.out.print("|\n");
        }
        System.out.print(horizontalPart);
        System.out.print("\n");
    }

    /**
     * this makeMove method will take user input from 1 to 9 place your move on the
     * given input. if player==0 then it'll assign the value as given by computer.
     */
    public boolean makeMove(int index, int player) {
        if (board[index] == ' ') {
            if (player == 0) {
                System.out.println("Computer played: ");
                board[index] = computersymbol;
            } else {
                System.out.println("Player played: ");
                board[index] = usersymbol;
            }
            showBoard();
            checkWin();
            return false;
        } else {
            return true;
        }
    }

    /**
     * this tossForFirstPlay method will get the input from user and check whether
     * it's a head or tail by using random function
     */
    public void tossForFirstPlay() {
        int player;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Toss (H or T):");
        String toss = scanner.next();
        int i = (int) Math.round(Math.random()) % 2;
        if ((i == 1 && toss.equals("H")) || (i == 0 && toss.equals("T"))) {
            System.out.println("Congratulations! You've won the Toss.");
            player = 1;
        } else {
            System.out.println("You've lost Toss. Computer plays first.");
            player = 0;
        }
    }

    public void playGame() {
        int i;
        for (i = 0; i < 9; i++) {
            if (player == 0) {
                computerPlay();
                player = 1;
            } else {
                System.out.println("Select Position (1-9): ");
                while (makeMove(scanner.nextInt(), player)) {
                    System.out.println("Try different place.");
                }
                player = 0;
            }
        }
        if (i == 9) {
            System.out.println("Game Draw!");
            System.exit(0);
        }
    }

    /**
     * this checkWin method will check all the possible winning chances...
     */
    public void checkWin() {
        if ((board[1] == usersymbol && board[2] == usersymbol && board[3] == usersymbol)
                || (board[4] == usersymbol && board[5] == usersymbol && board[6] == usersymbol)
                || (board[7] == usersymbol && board[8] == usersymbol && board[9] == usersymbol)
                || (board[1] == usersymbol && board[4] == usersymbol && board[7] == usersymbol)
                || (board[2] == usersymbol && board[5] == usersymbol && board[8] == usersymbol)
                || (board[3] == usersymbol && board[6] == usersymbol && board[9] == usersymbol)
                || (board[1] == usersymbol && board[5] == usersymbol && board[9] == usersymbol)
                || (board[3] == usersymbol && board[5] == usersymbol && board[7] == usersymbol)) {
            System.out.println("Player Wins!");
            System.exit(0);
        }

        if ((board[1] == computersymbol && board[2] == computersymbol && board[3] == computersymbol)
                || (board[4] == computersymbol && board[5] == computersymbol && board[6] == computersymbol)
                || (board[7] == computersymbol && board[8] == computersymbol && board[9] == computersymbol)
                || (board[1] == computersymbol && board[4] == computersymbol && board[7] == computersymbol)
                || (board[2] == computersymbol && board[5] == computersymbol && board[8] == computersymbol)
                || (board[3] == computersymbol && board[6] == computersymbol && board[9] == computersymbol)
                || (board[1] == computersymbol && board[5] == computersymbol && board[9] == computersymbol)
                || (board[3] == computersymbol && board[5] == computersymbol && board[7] == computersymbol)) {
            System.out.println("Player Lost!");
            System.exit(0);
        }

    }

    private void computerPlay() {
        // TODO: Implementation computer playing logic
        while (makeMove((int) (Math.random() * 8) + 1, 0)) {
            System.out.println("");
        }
    }

    /**
     * Here i have created a main method to execute the program. an object got
     * created named tictactoe.which called the following methods.
     * 
     * @param args
     */
    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe(); // created object for class TicTacToeGame
        tictactoe.showBoard();
        tictactoe.playGame();

    }
}
