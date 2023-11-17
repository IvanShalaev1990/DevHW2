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
    public void printGameBoard(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
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
