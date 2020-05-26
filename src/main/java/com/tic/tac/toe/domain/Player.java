package com.tic.tac.toe.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    public final static String COMPUTER_CHAR = "X";
    public final static String PLAYER_CHAR = "O";

    private int currentRow;
    private int currentCol;
    private Board board;
    private int[] rowWinnerCounter;
    private int[] colWinnerCounter;
    private int leftToRightCounter;
    private int rightToLeftCounter;
    private String name;
    private String token;

    public Player(Board board, String name, String token) {
        this.board = board;
        this.rowWinnerCounter = new int[board.getSize()];
        this.colWinnerCounter = new int[board.getSize()];
        this.leftToRightCounter = 0;
        this.rightToLeftCounter = 0;
        this.name = name;
        this.token = token;
    }

    public void play(int rowPos, int colPos, String character) {
        this.board.putValue(character, rowPos, colPos);
        this.setCurrentRow(rowPos);
        this.setCurrentCol(colPos);
    }

}
