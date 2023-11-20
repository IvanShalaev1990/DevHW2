package com.tictactoe.util;

/**
 * Interface with util methods.
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 20.11.2023
 */

public interface Util {
    /**
     * Method to clean all info in gameBoard.
     *
     * @param gameBoard Array with a game info.
     */
    void cleanGameBoard(char[] gameBoard);

    /**
     * Method shows is a free space on a board.
     *
     * @param gameBoard Array with a game info.
     * @return is game board available.
     */
    boolean isGameBoardAvailable(char[] gameBoard);

    /**
     * Method to modify a game board.
     *
     * @param input     Input.
     * @param gameBoard Array with a game info
     * @param symbol    What we past in a game board.
     */
    void modifyGameBoard(byte input, char[] gameBoard, char symbol);
}
