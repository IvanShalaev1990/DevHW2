package com.tictactoe.util.impl;

import com.tictactoe.util.Util;

/**
 * {@inheritDoc}
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 20.11.2023
 */
public class UtilImpl implements Util {
    @Override
    public void cleanGameBoard(char[] gameBoard) {
        for (char i = 0; i < 9; i++) {
            gameBoard[i] = ' ';
        }
    }

    @Override
    public boolean isGameBoardAvailable(char[] gameBoard) {
        for (char cell : gameBoard) {
            if (cell == ' ') {
                return true;
            }
        }
        return false;
    }

    @Override
    public void modifyGameBoard(byte input, char[] gameBoard, char symbol) {
        gameBoard[input - 1] = symbol;
    }
}
