package com.tic.tac.toe;

import com.tic.tac.toe.domain.Board;
import com.tic.tac.toe.domain.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter the n * n the size of the board " );
        int size = in.nextInt();
        Board board = new Board(size);
        board.printBoard();
        System.out.println("Your board was successfully created with " + size + " * " + size + " size");

        System.out.println("Whats your name ? ");
        String playerName = in.next();

        Player player = new Player(board,playerName, Player.PLAYER_CHAR);
        Player cpu = new Player(board,"CPU", Player.COMPUTER_CHAR);

        while (true){
            playInPosition(in, player);
            if (board.validateIfIsWinPlay(player)) break;
            board.playAutomatically();
            if(board.validateIfIsWinPlay(cpu)) break;
            board.printBoard();
        }

        board.printBoard();
    }

    private static void playInPosition(Scanner in, Player player) {

        System.out.println("Enter the row position for your movement");
        int movRowPos = in.nextInt() - 1;
        System.out.println("Enter the col position for your movement");
        int movColPos = in.nextInt() - 1;
        player.play(movRowPos, movColPos, player.getToken());
    }

}
