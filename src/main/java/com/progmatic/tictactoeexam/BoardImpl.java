package com.progmatic.tictactoeexam;

import com.progmatic.tictactoeexam.enums.PlayerType;
import com.progmatic.tictactoeexam.exceptions.CellException;
import com.progmatic.tictactoeexam.interfaces.Board;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ákos Somodi
 */
public class BoardImpl implements Board {

    private final Cell[][] board;
    private static final int ROW_COUNT = 3;
    private static final int COL_COUNT = 3;

    // create the board in constructor
    public BoardImpl() {
        this.board = new Cell[COL_COUNT][ROW_COUNT];
        for (int i = 0; i < COL_COUNT; i++) {
            for (int j = 0; j < ROW_COUNT; j++) {
                this.board[i][j] = new Cell(j, i);
            }

        }
    }

    @Override
    public PlayerType getCell(int rowIdx, int colIdx) throws CellException {
        if (rowIdx >= this.board.length || rowIdx < 0
                || colIdx >= this.board.length || colIdx < 0) {
            throw new CellException(rowIdx, colIdx, "This cell is not on the board.");
        }

        return this.board[colIdx][rowIdx].getCellsPlayer();
    }

    @Override
    public void put(Cell cell) throws CellException {
        if (getCell(cell.getRow(), cell.getCol()) != PlayerType.EMPTY) {
            throw new CellException(cell.getRow(), cell.getCol(), "This cell is not empty.");
        } else {
            this.board[cell.getCol()][cell.getRow()].setCellsPlayer(cell.getCellsPlayer());
        }
    }

    @Override
    public boolean hasWon(PlayerType p) {

        //        throw new UnsupportedOperationException("Not supported yet.");
        if (p == PlayerType.EMPTY) {
            return false;
        }

        int counter = 0;

        //vertical
        for (int i = 0; i < COL_COUNT; i++) {
            if (this.board[i][0].getCellsPlayer() == this.board[i][1].getCellsPlayer()
                    && this.board[i][1].getCellsPlayer() == this.board[i][2].getCellsPlayer()
                    && this.board[i][0].getCellsPlayer() == p) {
                return true;
            }
        }

        //horizontal
        for (int i = 0; i < this.ROW_COUNT; i++) {
            if (this.board[0][i].getCellsPlayer() == this.board[1][i].getCellsPlayer()
                    && this.board[1][i].getCellsPlayer() == this.board[2][i].getCellsPlayer()
                    && this.board[0][i].getCellsPlayer() == p) {
                return true;
            }
        }

        //diagonal A & B
        for (int i = 0; i < ROW_COUNT; i++) {
            if (board[i][i].getCellsPlayer() == p) {
                counter++;
            }
        }
        if (counter == 3) {
            return true;
        }
        counter = 0;

        for (int i = 0; i < ROW_COUNT; i++) {
            if (board[ROW_COUNT - 1 - i][i].getCellsPlayer() == p) {
                counter++;
            }
        }
        if (counter == 3) {
            return true;
        }

        return false;
    }

    @Override
    public List<Cell> emptyCells() {
        List<Cell> emptyList = new ArrayList<>();
        for (int i = 0; i < COL_COUNT; i++) {
            for (int j = 0; j < ROW_COUNT; j++) {
                if (board[i][j].getCellsPlayer() == PlayerType.EMPTY) {
                    emptyList.add(board[i][j]);
                }
            }
        }
        return emptyList;
    }

}
