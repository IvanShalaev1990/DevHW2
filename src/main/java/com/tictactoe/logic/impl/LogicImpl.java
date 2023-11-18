package com.tictactoe.logic.impl;

import com.tictactoe.config.AppConstance;
import com.tictactoe.logic.Logic;
import com.tictactoe.printer.Printer;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.Scanner;

/**
 * {@inheritDoc}
 *
 * @author Shalaiev Ivan
 * @version 1.0.0 17.11.2023
 */
public class LogicImpl implements Logic {
    @Override
    public void cleanGameBoard(char[] gameBoard) {
        for (char i = 0; i < 9; i++) {
            gameBoard[i] = ' ';
        }
    }

    @Override
    public byte toFindWinner(char @NotNull [] gameBoard, boolean isGameBoardAvailable) {
        byte winner = AppConstance.CONTINUE;
        if ((gameBoard[0] == '0' && gameBoard[1] == '0' && gameBoard[2] == '0') ||
                (gameBoard[3] == '0' && gameBoard[4] == '0' && gameBoard[5] == '0') ||
                (gameBoard[6] == '0' && gameBoard[7] == '0' && gameBoard[8] == '0') ||
                (gameBoard[0] == '0' && gameBoard[3] == '0' && gameBoard[6] == '0') ||
                (gameBoard[1] == '0' && gameBoard[4] == '0' && gameBoard[7] == '0') ||
                (gameBoard[2] == '0' && gameBoard[5] == '0' && gameBoard[8] == '0') ||
                (gameBoard[0] == '0' && gameBoard[4] == '0' && gameBoard[8] == '0') ||
                (gameBoard[2] == '0' && gameBoard[4] == '0' && gameBoard[6] == '0')) {
            winner = AppConstance.COMP_WIN;
        } else if ((gameBoard[0] == 'X' && gameBoard[1] == 'X' && gameBoard[2] == 'X') ||
                (gameBoard[3] == 'X' && gameBoard[4] == 'X' && gameBoard[5] == 'X') ||
                (gameBoard[6] == 'X' && gameBoard[7] == 'X' && gameBoard[8] == 'X') ||
                (gameBoard[0] == 'X' && gameBoard[3] == 'X' && gameBoard[6] == 'X') ||
                (gameBoard[1] == 'X' && gameBoard[4] == 'X' && gameBoard[7] == 'X') ||
                (gameBoard[2] == 'X' && gameBoard[5] == 'X' && gameBoard[8] == 'X') ||
                (gameBoard[0] == 'X' && gameBoard[4] == 'X' && gameBoard[8] == 'X') ||
                (gameBoard[2] == 'X' && gameBoard[4] == 'X' && gameBoard[6] == 'X')) {
            winner = AppConstance.USER_WIN;
        } else if (!isGameBoardAvailable) {
            winner = AppConstance.DRAW;
        }
        return winner;
    }

    @Override
    public void userInput(Scanner scanner, char[] gameBoard, Printer printer) {
        boolean isAnswerCorrect = true;
        byte input;
        while (isAnswerCorrect) {
            input = scanner.nextByte();
            if (input > 0 && input < 10) {
                if (gameBoard[input - 1] == 'X' || gameBoard[input - 1] == '0')
                    printer.printRespondToAlreadyUsingCell();
                else {
                    gameBoard[input - 1] = 'X';
                    isAnswerCorrect = false;
                }
            } else
                printer.printRespondToInvalidSymbol();
        }
    }

    @Override
    public void compInput(Random random, char[] gameBoard) {
        boolean isPut = false;
        while (!isPut) {
            int cellNumber = random.nextInt(0, 8);
            if (gameBoard[cellNumber] == ' ') {
                gameBoard[cellNumber] = '0';
                isPut = true;
            }
        }
    }

    @Override
    public boolean isGameBoardAvailable(char[] gameBoard) {
        boolean isAvailable = false;
        for (char cell : gameBoard) {
            if (cell == ' ') {
                isAvailable = true;
                return isAvailable;
            }
        }
        return isAvailable;
    }
}
