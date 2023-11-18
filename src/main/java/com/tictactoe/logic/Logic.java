package com.tictactoe.logic;

import com.tictactoe.printer.Printer;

import java.util.Random;
import java.util.Scanner;

/**
 * Interface app's logic.
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 17.11.2023
 */
public interface Logic {
    /**
     * Method to clean all info in gameBoard.
     *
     * @param gameBoard Array with a game info.
     */
    void cleanGameBoard(char[] gameBoard);

    /**
     * Method to find winner.
     *
     * @param gameBoard Array with a game info.
     */
    byte toFindWinner(char[] gameBoard, boolean isGameBoardAvailable);

    /**
     * Method to read user's input.
     *
     * @param scanner User input.
     */
    void userInput(Scanner scanner, char[] gameBoard, Printer printer);

    /**
     * Method to computer selection calculations.
     *
     * @param random    Computer input.
     * @param gameBoard Array with a game info.
     */
    void compInput(Random random, char[] gameBoard);

    /**
     * Method shows is a free space on a board.
     *
     * @param gameBoard Array with a game info.
     * @return is game board available.
     */
    boolean isGameBoardAvailable(char[] gameBoard);
}
