package com.bridgelabz.ticTacToe;

public class TicTacToe {
    private static char[] board = new char[10];

    static void startGame() {
        for (int i = 1; i <= 9; i++) {
            board[i] = ' ';
            System.out.println(board);
        }
    }

    public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe ");
		System.out.println(board[1]+" | "+board[2]+" | "+board[3]);
		System.out.println("---------");
		System.out.println(board[4]+" | "+board[5]+" | "+board[6]);
		System.out.println("---------");
		System.out.println(board[7]+" | "+board[8]+" | "+board[9]);
		startGame();
	}
}
