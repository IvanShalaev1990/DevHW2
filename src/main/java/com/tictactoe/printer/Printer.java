package com.tictactoe.printer;

/**
 * Interface for printing game info.
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 17.11.2023
 */
public interface Printer {
    /**
     * Method which print very first info.
     *
     * @author Shalaiev Ivan
     */
    void printStart();

    /**
     * Method which print game board with info.
     *
     * @param box Array with a game info.
     * @author Shalaiev Ivan
     */
    void printGameBoard(char[] box);

    /**
     * Method to print a game winner.
     *
     * @param winner A number with game result.
     * @author Shalaiev Ivan
     */
    void printWinnerName(int winner);
    /**
     * Method which print message when invalid symbol was pressed.
     *
     * @author Shalaiev Ivan
     */
    void printRespondToInvalidSymbol();
    /**
     * Method which print message when a symbol already in use.
     *
     * @author Shalaiev Ivan
     */
    void printRespondToAlreadyUsingSymbol();
}
