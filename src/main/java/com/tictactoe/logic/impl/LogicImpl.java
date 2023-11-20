package com.tictactoe.logic.impl;

import com.tictactoe.config.AppConstance;
import com.tictactoe.logic.Logic;
import com.tictactoe.printer.Printer;
import org.jetbrains.annotations.NotNull;


/**
 * {@inheritDoc}
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 17.11.2023
 */
public class LogicImpl implements Logic {

    @Override
    public byte toFindWinner(char @NotNull [] gameBoard, boolean isGameBoardAvailable) {
        byte winner = AppConstance.CONTINUE;
        if (compWin(gameBoard)) {
            winner = AppConstance.COMP_WIN;
        } else if (userWin(gameBoard)) {
            winner = AppConstance.USER_WIN;
        } else if (!isGameBoardAvailable) {
            winner = AppConstance.DRAW;
        }
        return winner;
    }
    @Override
    public boolean compWin(char[] gameBoard) {
        return (gameBoard[0] == '0' && gameBoard[1] == '0' && gameBoard[2] == '0') ||
                (gameBoard[3] == '0' && gameBoard[4] == '0' && gameBoard[5] == '0') ||
                (gameBoard[6] == '0' && gameBoard[7] == '0' && gameBoard[8] == '0') ||
                (gameBoard[0] == '0' && gameBoard[3] == '0' && gameBoard[6] == '0') ||
                (gameBoard[1] == '0' && gameBoard[4] == '0' && gameBoard[7] == '0') ||
                (gameBoard[2] == '0' && gameBoard[5] == '0' && gameBoard[8] == '0') ||
                (gameBoard[0] == '0' && gameBoard[4] == '0' && gameBoard[8] == '0') ||
                (gameBoard[2] == '0' && gameBoard[4] == '0' && gameBoard[6] == '0');
    }

    @Override
    public boolean userWin(char[] gameBoard) {
        return (gameBoard[0] == 'X' && gameBoard[1] == 'X' && gameBoard[2] == 'X') ||
                (gameBoard[3] == 'X' && gameBoard[4] == 'X' && gameBoard[5] == 'X') ||
                (gameBoard[6] == 'X' && gameBoard[7] == 'X' && gameBoard[8] == 'X') ||
                (gameBoard[0] == 'X' && gameBoard[3] == 'X' && gameBoard[6] == 'X') ||
                (gameBoard[1] == 'X' && gameBoard[4] == 'X' && gameBoard[7] == 'X') ||
                (gameBoard[2] == 'X' && gameBoard[5] == 'X' && gameBoard[8] == 'X') ||
                (gameBoard[0] == 'X' && gameBoard[4] == 'X' && gameBoard[8] == 'X') ||
                (gameBoard[2] == 'X' && gameBoard[4] == 'X' && gameBoard[6] == 'X');
    }

    @Override
    public boolean verifyUserInput(byte input, char[] gameBoard, Printer printer) {
        if (input > 0 && input < 10) {
            if (gameBoard[input - 1] == 'X' || gameBoard[input - 1] == '0') {
                printer.printRespondToAlreadyUsingCell();
                return false;
            } else {
                return true;
            }
        } else
            printer.printRespondToInvalidSymbol();
        return false;
    }

    @Override
    public boolean verifyCompInput(int compInput, char[] gameBoard) {
        return gameBoard[compInput-1] == ' ';
    }
}
