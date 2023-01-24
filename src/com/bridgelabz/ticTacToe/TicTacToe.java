package com.bridgelabz.ticTacToe;

import java.util.Scanner;

public class TicTacToe {
    
    private static char[] board = new char[10];
    static char player, computer;
    static Scanner scanner = new Scanner(System.in);

    static void selectIndex() {
        for (int i = 1; i <= 9; i++) {
            board[i] = ' ';
    
        }
    }
    // Taking input from user
    // creating method to select x & O

    public static void check() {
        System.out.println("Please Select Your Captial Letter : 'X' or 'O' ");
        char choice = scanner.next().charAt(0);
        if (player == 'X') {
            computer = 'O';
        } else
            computer = 'X';
            System.out.println("You have selected : " + player);
            System.out.println("Computer's choice is : " + computer);
    }

    public static void showBoard() {
		System.out.println("Welcome to Tic Tac Toe ");
		System.out.println(board[1]+" | "+board[2]+" | "+board[3]);
		System.out.println("---------");
		System.out.println(board[4]+" | "+board[5]+" | "+board[6]);
		System.out.println("---------");
		System.out.println(board[7]+" | "+board[8]+" | "+board[9]);
	}
    
    public static void userMove() {
        System.out.println("Enter index from 1-9 to make the Move");
        int playLocation = scanner.nextInt();
        if (playLocation < 10 && playLocation > 0) {
            board[playLocation] = player;
            showBoard();
        } else {
            System.out.println("Invalid Choice");
        }
    }
    public static void main(String[] args){
        System.out.println("Welcome To Tic Tac Toe Game");
        selectIndex();
        check();
        showBoard();
        userMove();
    }
}
