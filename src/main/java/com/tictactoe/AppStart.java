package com.tictactoe;

import com.tictactoe.config.AppConstance;
import com.tictactoe.logic.Logic;
import com.tictactoe.logic.impl.LogicImpl;
import com.tictactoe.printer.Printer;
import com.tictactoe.printer.impl.PrinterImpl;

import java.util.Random;
import java.util.Scanner;

public class AppStart {
    private Scanner scanner = new Scanner(System.in);
    private Printer printer = new PrinterImpl();
    private Random random = new Random();
    private Logic logic = new LogicImpl();
    private boolean isGameBoardAvailable = false;
    private byte winner = AppConstance.CONTINUE;
    AppStart(){
        scanner = new Scanner(System.in);
        printer = new PrinterImpl();
        random = new Random();
        logic = new LogicImpl();
        isGameBoardAvailable = false;
        winner = AppConstance.CONTINUE;
        start();
    }
    public void start(){
        char[] gameBoard = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        printer.printStart();
        boolean isGameBoarNotEmpty = true;
        while (winner < 0) {
            printer.printGameBoard(gameBoard);
            if (isGameBoarNotEmpty) {
                logic.cleanGameBoard(gameBoard);
                isGameBoarNotEmpty = false;
            }
            isGameBoardAvailable = logic.isGameBoardAvailable(gameBoard);
            logic.userInput(scanner, gameBoard, printer);
            winner = logic.toFindWinner(gameBoard, isGameBoardAvailable);
            if (winner < 0) {
                isGameBoardAvailable = logic.isGameBoardAvailable(gameBoard);
                logic.compInput(random, gameBoard);
                winner = logic.toFindWinner(gameBoard, isGameBoardAvailable);
            }
        }
        printer.printGameBoard(gameBoard);
        printer.printWinnerName(winner);
    }

}

