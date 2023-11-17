package com.tictactoe.printer.impl;

import com.tictactoe.printer.Printer;

/**
 * {@inheritDoc}
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 17.11.2023
 */
public class PrinterImpl implements Printer {
    @Override
    public void printStart() {
        System.out.println("Enter box number to select. Enjoy!\n");
    }

    @Override
    public void printGameBoard(char[] gameBoard) {
        System.out.println("\n\n " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " \n");
    }

    @Override
    public void printWinnerName(int winner) {
        switch (winner) {
            case 1 -> System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 2 -> System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            case 3 -> System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }

    @Override
    public void printRespondToInvalidSymbol() {
        System.out.println("Invalid input. Enter again.");
    }

    @Override
    public void printRespondToAlreadyUsingSymbol() {
        System.out.println("That one is already in use. Enter another.");
    }
}
