package com.bridgelabz.ticTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    char gameBoard[] = null;
    char playerLetter = '\0';
    char computerLetter = '\0';
    String winner = null;
    int turn = 0;
    int firstPlayer = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Tic Tac Toe Game Program in Java!");
        TicTacToe gameObj = new TicTacToe();
        gameObj.initialiseGame();
        if (gameObj.toss() == 1)
            System.out.println("\nPlayer won the toss.\nPlayer plays first.");
        else
            System.out.println("\nComputer won the toss.\nComputer plays first.");
        gameObj.choosePlayerLetter();
        gameObj.showBoard();
        gameObj.playerPlays();
        gameObj.showBoard();
        gameObj.checkWinOrTie();
        gameObj.computerPlays();
    }

    void initialiseGame() {
        gameBoard = new char[10];
        for (int index = 0; index < 10; index++)
            gameBoard[index] = ' ';
        turn = 0;
        winner = null;
    }

    void choosePlayerLetter() {
        System.out.println("\nPlayer please choose your play Letter.");
        System.out.println("Enter 'X' to play 'X' on your turn.");
        System.out.println("Or Enter 'O' to play 'O' on your turn.");
        char playerInput = sc.next().charAt(0);
        if (playerInput == 'X' || playerInput == 'x') {
            playerLetter = 'X';
            computerLetter = 'O';
        } else if (playerInput == 'O' || playerInput == 'o') {
            playerLetter = 'O';
            computerLetter = 'X';
        } else {
            System.out.println("\nInvalid Input.\nPlease try again!");
            choosePlayerLetter();
        }
    }

    void showBoard() {
        System.out.println("\nCurrent Board : ");
        System.out.println("-------------");
        System.out.println("| " + gameBoard[1] + " | " + gameBoard[2] + " | " + gameBoard[3] + " |");
        System.out.println("-------------");
        System.out.println("| " + gameBoard[4] + " | " + gameBoard[5] + " | " + gameBoard[6] + " |");
        System.out.println("-------------");
        System.out.println("| " + gameBoard[7] + " | " + gameBoard[8] + " | " + gameBoard[9] + " |");
        System.out.println("-------------");
    }

    void playerPlays() {
        System.out.print("\nEnter an empty cell number [1-9] where do want make your move : ");
        byte playerCell = sc.nextByte();
        if (playerCell > 9 || playerCell < 1) {
            System.out.println("\nInvalid selection.\nPlease try again!");
            playerPlays();
        } else if (gameBoard[playerCell] != ' ') {
            System.out.println("\nThe cell you selected is not empty.\nPlease try again!");
            playerPlays();
        } else
            gameBoard[playerCell] = playerLetter;
    }

    int toss() {
        return (Math.random() > 0.5 ? 1 : 0);
    }

    void checkWinOrTie() {
        char winLetter = ' ';
        byte cellsStillEmpty = 0;
        winner = null;

        for (int pattern = 1; pattern < 9; pattern++) {
            switch (pattern) {
                case 1:
                    if (gameBoard[1] == gameBoard[2] && gameBoard[1] == gameBoard[3])
                        winLetter = gameBoard[1];
                    break;
                case 2:
                    if (gameBoard[4] == gameBoard[5] && gameBoard[4] == gameBoard[6])
                        winLetter = gameBoard[4];
                    break;
                case 3:
                    if (gameBoard[7] == gameBoard[8] && gameBoard[7] == gameBoard[9])
                        winLetter = gameBoard[7];
                    break;
                case 4:
                    if (gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7])
                        winLetter = gameBoard[1];
                    break;
                case 5:
                    if (gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8])
                        winLetter = gameBoard[2];
                    break;
                case 6:
                    if (gameBoard[3] == gameBoard[6] && gameBoard[3] == gameBoard[9])
                        winLetter = gameBoard[3];
                    break;
                case 7:
                    if (gameBoard[1] == gameBoard[5] && gameBoard[1] == gameBoard[9])
                        winLetter = gameBoard[1];
                    break;
                case 8:
                    if (gameBoard[3] == gameBoard[5] && gameBoard[3] == gameBoard[7])
                        winLetter = gameBoard[3];
                    break;
            }
        }
        if (winLetter == playerLetter)
            winner = "PLAYER";
        else if (winLetter == computerLetter)
            winner = "COMPUTER";
        else {
            for (int counter = 1; counter <= 9; counter++) {
                if (gameBoard[counter] == ' ')
                    cellsStillEmpty++;
            }
            if (cellsStillEmpty == 0)
                winner = "TIE";
        }
        if (winner != null)
            displayResults();
    }

    void displayResults() {
        if (winner == "TIE")
            System.out.println("\n\nIt's a TIE!\nPlease try again.");
        else
            System.out.println("\n\n" + winner + " wins!");
    }

    void computerPlays() {
        if (turn <= 2)
            generateRandomMove();
        else
            generateWinningMove();
        turn++;
    }

    void generateRandomMove() {
        int position = (int) (Math.random() * 9) + 1;
        if (gameBoard[position] == ' ')
            gameBoard[position] = computerLetter;
        else
            generateRandomMove();
    }

    void generateWinningMove() {
        boolean madeMove = false;
        if (gameBoard[1] == computerLetter && gameBoard[2] == computerLetter && gameBoard[3] == ' ') {
            gameBoard[3] = computerLetter;
            madeMove = true;
        } else if (gameBoard[2] == computerLetter && gameBoard[3] == computerLetter && gameBoard[1] == ' ') {
            gameBoard[1] = computerLetter;
            madeMove = true;
        } else if (gameBoard[1] == computerLetter && gameBoard[3] == computerLetter && gameBoard[2] == ' ') {
            gameBoard[2] = computerLetter;
            madeMove = true;
        }

        else if (gameBoard[4] == computerLetter && gameBoard[5] == computerLetter && gameBoard[6] == ' ') {
            gameBoard[6] = computerLetter;
            madeMove = true;
        } else if (gameBoard[5] == computerLetter && gameBoard[6] == computerLetter && gameBoard[4] == ' ') {
            gameBoard[4] = computerLetter;
            madeMove = true;
        } else if (gameBoard[4] == computerLetter && gameBoard[6] == computerLetter && gameBoard[5] == ' ') {
            gameBoard[5] = computerLetter;
            madeMove = true;
        }

        else if (gameBoard[7] == computerLetter && gameBoard[8] == computerLetter && gameBoard[9] == ' ') {
            gameBoard[9] = computerLetter;
            madeMove = true;
        } else if (gameBoard[8] == computerLetter && gameBoard[9] == computerLetter && gameBoard[7] == ' ') {
            gameBoard[7] = computerLetter;
            madeMove = true;
        } else if (gameBoard[7] == computerLetter && gameBoard[9] == computerLetter && gameBoard[8] == ' ') {
            gameBoard[8] = computerLetter;
            madeMove = true;
        }

        else if (gameBoard[1] == computerLetter && gameBoard[4] == computerLetter && gameBoard[7] == ' ') {
            gameBoard[7] = computerLetter;
            madeMove = true;
        } else if (gameBoard[4] == computerLetter && gameBoard[7] == computerLetter && gameBoard[1] == ' ') {
            gameBoard[1] = computerLetter;
            madeMove = true;
        } else if (gameBoard[1] == computerLetter && gameBoard[7] == computerLetter && gameBoard[4] == ' ') {
            gameBoard[4] = computerLetter;
            madeMove = true;
        }

        else if (gameBoard[2] == computerLetter && gameBoard[5] == computerLetter && gameBoard[8] == ' ') {
            gameBoard[8] = computerLetter;
            madeMove = true;
        } else if (gameBoard[5] == computerLetter && gameBoard[8] == computerLetter && gameBoard[2] == ' ') {
            gameBoard[2] = computerLetter;
            madeMove = true;
        } else if (gameBoard[2] == computerLetter && gameBoard[8] == computerLetter && gameBoard[5] == ' ') {
            gameBoard[5] = computerLetter;
            madeMove = true;
        }

        else if (gameBoard[3] == computerLetter && gameBoard[6] == computerLetter && gameBoard[9] == ' ') {
            gameBoard[9] = computerLetter;
            madeMove = true;
        } else if (gameBoard[6] == computerLetter && gameBoard[9] == computerLetter && gameBoard[3] == ' ') {
            gameBoard[3] = computerLetter;
            madeMove = true;
        } else if (gameBoard[3] == computerLetter && gameBoard[9] == computerLetter && gameBoard[6] == ' ') {
            gameBoard[6] = computerLetter;
            madeMove = true;
        }

        else if (gameBoard[1] == computerLetter && gameBoard[5] == computerLetter && gameBoard[9] == ' ') {
            gameBoard[9] = computerLetter;
            madeMove = true;
        } else if (gameBoard[5] == computerLetter && gameBoard[9] == computerLetter && gameBoard[1] == ' ') {
            gameBoard[1] = computerLetter;
            madeMove = true;
        } else if (gameBoard[1] == computerLetter && gameBoard[9] == computerLetter && gameBoard[5] == ' ') {
            gameBoard[5] = computerLetter;
            madeMove = true;
        }

        else if (gameBoard[3] == computerLetter && gameBoard[5] == computerLetter && gameBoard[7] == ' ') {
            gameBoard[7] = computerLetter;
            madeMove = true;
        } else if (gameBoard[5] == computerLetter && gameBoard[7] == computerLetter && gameBoard[3] == ' ') {
            gameBoard[3] = computerLetter;
            madeMove = true;
        } else if (gameBoard[3] == computerLetter && gameBoard[7] == computerLetter && gameBoard[5] == ' ') {
            gameBoard[5] = computerLetter;
            madeMove = true;
        }

        if (madeMove == false)
            blockPlayersMove();
    }

    void blockPlayersMove() {
        if (gameBoard[2] == playerLetter && gameBoard[3] == playerLetter && gameBoard[1] == ' ')
            gameBoard[1] = computerLetter;
        else if (gameBoard[4] == playerLetter && gameBoard[7] == playerLetter && gameBoard[1] == ' ')
            gameBoard[1] = computerLetter;
        else if (gameBoard[5] == playerLetter && gameBoard[9] == playerLetter && gameBoard[1] == ' ')
            gameBoard[1] = computerLetter;

        else if (gameBoard[1] == playerLetter && gameBoard[2] == playerLetter && gameBoard[3] == ' ')
            gameBoard[3] = computerLetter;
        else if (gameBoard[6] == playerLetter && gameBoard[9] == playerLetter && gameBoard[3] == ' ')
            gameBoard[3] = computerLetter;
        else if (gameBoard[5] == playerLetter && gameBoard[7] == playerLetter && gameBoard[3] == ' ')
            gameBoard[3] = computerLetter;

        else if (gameBoard[8] == playerLetter && gameBoard[9] == playerLetter && gameBoard[7] == ' ')
            gameBoard[7] = computerLetter;
        else if (gameBoard[1] == playerLetter && gameBoard[4] == playerLetter && gameBoard[7] == ' ')
            gameBoard[7] = computerLetter;
        else if (gameBoard[3] == playerLetter && gameBoard[5] == playerLetter && gameBoard[7] == ' ')
            gameBoard[7] = computerLetter;

        else if (gameBoard[7] == playerLetter && gameBoard[8] == playerLetter && gameBoard[9] == ' ')
            gameBoard[9] = computerLetter;
        else if (gameBoard[3] == playerLetter && gameBoard[6] == playerLetter && gameBoard[9] == ' ')
            gameBoard[9] = computerLetter;
        else if (gameBoard[1] == playerLetter && gameBoard[5] == playerLetter && gameBoard[9] == ' ')
            gameBoard[9] = computerLetter;

        else if (gameBoard[4] == playerLetter && gameBoard[6] == playerLetter && gameBoard[5] == ' ')
            gameBoard[5] = computerLetter;
        else if (gameBoard[2] == playerLetter && gameBoard[8] == playerLetter && gameBoard[5] == ' ')
            gameBoard[5] = computerLetter;
        else if (gameBoard[1] == playerLetter && gameBoard[9] == playerLetter && gameBoard[5] == ' ')
            gameBoard[5] = computerLetter;
        else if (gameBoard[3] == playerLetter && gameBoard[7] == playerLetter && gameBoard[5] == ' ')
            gameBoard[5] = computerLetter;

        else if (gameBoard[1] == playerLetter && gameBoard[3] == playerLetter && gameBoard[2] == ' ')
            gameBoard[2] = computerLetter;
        else if (gameBoard[4] == playerLetter && gameBoard[5] == playerLetter && gameBoard[6] == ' ')
            gameBoard[6] = computerLetter;
        else if (gameBoard[5] == playerLetter && gameBoard[6] == playerLetter && gameBoard[4] == ' ')
            gameBoard[4] = computerLetter;
        else if (gameBoard[7] == playerLetter && gameBoard[9] == playerLetter && gameBoard[8] == ' ')
            gameBoard[8] = computerLetter;
        else if (gameBoard[1] == playerLetter && gameBoard[7] == playerLetter && gameBoard[4] == ' ')
            gameBoard[4] = computerLetter;
        else if (gameBoard[2] == playerLetter && gameBoard[5] == playerLetter && gameBoard[8] == ' ')
            gameBoard[8] = computerLetter;
        else if (gameBoard[5] == playerLetter && gameBoard[8] == playerLetter && gameBoard[2] == ' ')
            gameBoard[2] = computerLetter;
        else if (gameBoard[3] == playerLetter && gameBoard[9] == playerLetter && gameBoard[6] == ' ')
            gameBoard[6] = computerLetter;
    }

    void playersTurn() {
        playerPlays();
        showBoard();
        checkWinOrTie();
    }

    void computersTurn() {
        computerPlays();
        showBoard();
        checkWinOrTie();
    }

    void startGame() {
        firstPlayer = toss();
        initialiseGame();
        choosePlayerLetter();
        if (firstPlayer == 1)
            System.out.println("\nPlayer won the toss.\nPlayer plays first.");
        else
            System.out.println("\nComputer won the toss.\nComputer plays first.");
        showBoard();
    }

    void continueTillGameOver() {
        while (winner == null) {
            if (firstPlayer == 1) {
                playersTurn();
                if (winner != null)
                    break;
                else
                    computersTurn();
            } else {
                computersTurn();
                if (winner != null)
                    break;
                else
                    playersTurn();
            }
            turn++;
        }
    }
}