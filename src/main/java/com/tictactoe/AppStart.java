package com.tictactoe;

import com.tictactoe.config.AppConstance;
import com.tictactoe.logic.Logic;
import com.tictactoe.logic.impl.LogicImpl;
import com.tictactoe.printer.Printer;
import com.tictactoe.printer.impl.PrinterImpl;
import com.tictactoe.util.Util;
import com.tictactoe.util.impl.UtilImpl;

import java.util.Random;
import java.util.Scanner;

public class AppStart {
    private Scanner scanner;
    private Printer printer;
    private Random random;
    private Logic logic;
    private Util util;
    private boolean isGameBoardAvailable;
    private boolean isUserInputCorrect;
    private boolean isCompInputCorrect;
    private byte winner;
    private byte input;
    private byte inputComp;

    AppStart() {
        scanner = new Scanner(System.in);
        printer = new PrinterImpl();
        random = new Random();
        logic = new LogicImpl();
        util = new UtilImpl();
        isGameBoardAvailable = false;
        isUserInputCorrect = false;
        isCompInputCorrect = false;
        winner = AppConstance.CONTINUE;
        start();
    }

    public void start() {
        char[] gameBoard = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        printer.printStart();
        boolean isGameBoarNotEmpty = true;
        while (winner < 0) {
            printer.printGameBoard(gameBoard);
            if (isGameBoarNotEmpty) {
                util.cleanGameBoard(gameBoard);
                isGameBoarNotEmpty = false;
            }
            while (!isUserInputCorrect) {
                input = scanner.nextByte();
                isUserInputCorrect = logic.verifyUserInput(input, gameBoard, printer);
            }
            isUserInputCorrect = false;
            util.modifyGameBoard(input, gameBoard, 'X');
            isGameBoardAvailable = util.isGameBoardAvailable(gameBoard);
            winner = logic.toFindWinner(gameBoard, isGameBoardAvailable);
            if (winner < 0) {
                while (!isCompInputCorrect) {
                    inputComp = (byte)random.nextInt(1, 9);
                    isCompInputCorrect = logic.verifyCompInput(inputComp, gameBoard);
                }
                isCompInputCorrect = false;
                util.modifyGameBoard(inputComp, gameBoard, '0');
                isGameBoardAvailable = util.isGameBoardAvailable(gameBoard);
                winner = logic.toFindWinner(gameBoard, isGameBoardAvailable);
            }
        }
        printer.printGameBoard(gameBoard);
        printer.printWinnerName(winner);
    }

}

