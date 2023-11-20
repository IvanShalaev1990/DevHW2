package com.tictactoe.logic;

import com.tictactoe.printer.Printer;


/**
 * Interface app's logic.
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 17.11.2023
 */
public interface Logic {
    /**
     * Method to find winner.
     *
     * @param gameBoard Array with a game info.
     */
    byte toFindWinner(char[] gameBoard, boolean isGameBoardAvailable);

    /**
     * Method to verify user input.
     *
     * @param input     User input.
     * @param gameBoard gameBoard Array with a game info.
     * @param printer   Print message if user input is incorrect.
     * @return Is user input correct.
     */
    boolean verifyUserInput(byte input, char[] gameBoard, Printer printer);

    /**
     * Method to verify comp input.
     *
     * @param compInput Computer input.
     * @param gameBoard Array with a game info.
     * @return Is comp input correct.
     */
    boolean verifyCompInput(int compInput, char[] gameBoard);

    /**
     * Method to compute is a comp win.
     *
     * @param gameBoard Array with a game info.
     * @return Is comp win.
     */
    boolean compWin(char[] gameBoard);

    /**
     * Method to compute is a user win.
     *
     * @param gameBoard Array with a game info.
     * @return Is comp user.
     */
    boolean userWin(char[] gameBoard);
}
