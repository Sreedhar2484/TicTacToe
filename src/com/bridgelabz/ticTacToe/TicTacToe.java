package com.bridgelabz.ticTacToe;

import java.util.Scanner;

public class TicTacToe {
    
    private static char[] board = new char[10];
    static char player, computer;
    static Scanner scanner = new Scanner(System.in);

    static void startGame() {
        for (int i = 1; i <= 9; i++) {
            board[i] = ' ';
    
        }
    }
    // Taking input from user
    // creating method to select x & O

    public static void check() {
        System.out.println("Please Select Your Letter : 'X' or 'O' ");
        char choice = scanner.next().charAt(0);
        if (choice == 'X') {
            player = 'X';
            computer = 'O';
        } else if (choice == 'Y') {
            player = 'O';
            computer = 'X';
        }
    }

    public void showBoard(){
		System.out.println("Welcome to Tic Tac Toe ");
		System.out.println(board[1]+" | "+board[2]+" | "+board[3]);
		System.out.println("---------");
		System.out.println(board[4]+" | "+board[5]+" | "+board[6]);
		System.out.println("---------");
		System.out.println(board[7]+" | "+board[8]+" | "+board[9]);
	}
    public static void main(String[] args){
        TicTacToe newObj = new TicTacToe();
        newObj.startGame();
        newObj.check();
        newObj.showBoard();
    }
}
