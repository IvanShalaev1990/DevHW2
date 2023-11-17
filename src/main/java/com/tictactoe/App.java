package com.tictactoe;

import com.tictactoe.config.AppConstance;
import com.tictactoe.printer.Printer;
import com.tictactoe.printer.impl.PrinterImpl;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Printer printer = new PrinterImpl();
        byte input;
        byte rand;
        byte i;
        boolean boxAvailable = false;
        byte winner = 0;
        char gameBoard[] = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        printer.printStart();

        boolean boxEmpty = false;
        while (true) {
            printer.printGameBoard(gameBoard);
            if(!boxEmpty){
                for(i = 0; i < 9; i++)
                    gameBoard[i] = ' ';
                boxEmpty = true;
            }
            printer.printWinnerName(winner);
            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (gameBoard[input - 1] == 'X' || gameBoard[input - 1] == 'O')
                        printer.printRespondToAlreadyUsingSymbol();
                    else {
                        gameBoard[input - 1] = 'X';
                        break;
                    }
                }
                else
                    printer.printRespondToInvalidSymbol();
            }

            if((gameBoard[0]=='X' && gameBoard[1]=='X' && gameBoard[2]=='X') || (gameBoard[3]=='X' && gameBoard[4]=='X' && gameBoard[5]=='X') || (gameBoard[6]=='X' && gameBoard[7]=='X' && gameBoard[8]=='X') ||
               (gameBoard[0]=='X' && gameBoard[3]=='X' && gameBoard[6]=='X') || (gameBoard[1]=='X' && gameBoard[4]=='X' && gameBoard[7]=='X') || (gameBoard[2]=='X' && gameBoard[5]=='X' && gameBoard[8]=='X') ||
               (gameBoard[0]=='X' && gameBoard[4]=='X' && gameBoard[8]=='X') || (gameBoard[2]=='X' && gameBoard[4]=='X' && gameBoard[6]=='X')){
                   winner = AppConstance.USER_WIN;
                   continue;
            }

            boxAvailable = false;
            for(i=0; i<9; i++){
                if(gameBoard[i] != 'X' && gameBoard[i] != 'O'){
                    boxAvailable = true;
                    break;
                }
            }

            if(boxAvailable == false){
                winner = AppConstance.DRAW;
                continue;
            }

            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (gameBoard[rand - 1] != 'X' && gameBoard[rand - 1] != 'O') {
                    gameBoard[rand - 1] = 'O';
                    break;
                }
            }

            if((gameBoard[0]=='O' && gameBoard[1]=='O' && gameBoard[2]=='O') || (gameBoard[3]=='O' && gameBoard[4]=='O' && gameBoard[5]=='O') || (gameBoard[6]=='O' && gameBoard[7]=='O' && gameBoard[8]=='O') ||
               (gameBoard[0]=='O' && gameBoard[3]=='O' && gameBoard[6]=='O') || (gameBoard[1]=='O' && gameBoard[4]=='O' && gameBoard[7]=='O') || (gameBoard[2]=='O' && gameBoard[5]=='O' && gameBoard[8]=='O') ||
               (gameBoard[0]=='O' && gameBoard[4]=='O' && gameBoard[8]=='O') || (gameBoard[2]=='O' && gameBoard[4]=='O' && gameBoard[6]=='O')){
                winner = AppConstance.COMP_WIN;
                continue;
            }
        }

    }
}