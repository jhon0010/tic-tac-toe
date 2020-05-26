package com.tic.tac.toe.domain;

import lombok.Getter;

@Getter
public class Board {

    private final int size;
    private final String[][] board;

    public Board(int size) {
        this.size = size;
        board = new String[size][size];
    }

    public void putValue(String value, int rowPos, int colPos) {

        if (rowPos > board.length || colPos > board.length){
            System.out.println("Invalid position for your movement");
        }

        if (isValidPosition(rowPos, colPos)) {
            this.board[rowPos][colPos] = value;
        }

    }

    public void playAutomatically() {
        for(int i =0; i < board.length ; i++){
            for(int j=0; j < board.length ; j++){
                if (isValidPosition(i, j)){
                    putValue(Player.COMPUTER_CHAR,i,j);
                    return;
                }
            }
        }
    }

    private boolean isValidPosition(int row, int col){
        if (this.board[row][col] != null && !this.board[row][col].isEmpty()) {
            System.out.println("The position " + row +  "-" + col +  " is not empty please move in another position");
            return false;
        }

        return true;
    }

    public void printBoard(){

        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[i].length; j++) {

                var token = board[i][j] == null ? "-" : board[i][j];
                System.out.print(token + " | ");
            }
            System.out.println();
        }

    }

    public boolean validateIfIsWinPlay(Player player) {

        if(player.getCurrentRow() == 0 && player.getCurrentCol() == 0){
            return false;
        }

        int col = player.getCurrentCol();
        int row = player.getCurrentRow();

        player.getColWinnerCounter()[col] = player.getColWinnerCounter()[col] + 1;
        player.setColWinnerCounter(player.getColWinnerCounter());

        player.getRowWinnerCounter()[row] = player.getRowWinnerCounter()[row] + 1;
        player.setRowWinnerCounter(player.getRowWinnerCounter());

        player.setLeftToRightCounter(player.getLeftToRightCounter() + col == row ? 1 : 0);
        int size = this.size;
        player.setRightToLeftCounter(player.getRightToLeftCounter() + row == size - col ? 1:0 );

        if (
                player.getColWinnerCounter()[col] == size ||
                        player.getRowWinnerCounter()[row] == size ||
                        player.getLeftToRightCounter()    == size ||
                        player.getRightToLeftCounter()    == size
        ) {
            System.out.println("The player " + player.getName() + " won the game ");
            return true;
        }

        return false;
    }

}
