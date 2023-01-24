package com.bridgelabz.ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    
    private static char[] board = new char[10];
    static char player, computer;
     private static int  playLocation;
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
        playLocation = scanner.nextInt();
        if (playLocation < 10 && playLocation > 0) {
            board[playLocation] = player;
            showBoard();
        } else {
            System.out.println("Invalid Choice");
        }
    }

    public static boolean isEmpty(){
        if(board[playLocation] == ' '){
            return true;
        } else 
             return false;
    }
    
    /*
     * Tossing the coin to checking who won the first
     */
    public static void checkToss() {
        Random random = new Random();
        int tossResult = random.nextInt(2) + 1;
        System.out.println("\nChoose 1 for Heads or 2 for Tails");
        int selectCoin = scanner.nextInt();

        if (selectCoin == tossResult) {
            System.out.println("\nPlayer Won The Toss! Player Starts");
        } else {
            System.out.println("\nComputer Won The Toss! Computer Starts");
        }
    }
    public static void main(String[] args){
        System.out.println("Welcome To Tic Tac Toe Game");
        checkToss();
        selectIndex();
        check();
        showBoard();
        userMove();
        isEmpty();
    }
}
