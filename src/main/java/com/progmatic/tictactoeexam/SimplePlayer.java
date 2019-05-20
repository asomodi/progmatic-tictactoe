package com.progmatic.tictactoeexam;

import com.progmatic.tictactoeexam.enums.PlayerType;
import com.progmatic.tictactoeexam.interfaces.AbstractPlayer;
import com.progmatic.tictactoeexam.interfaces.Board;

/**
 *
 * @author Ákos Somodi
 */
public class SimplePlayer extends AbstractPlayer {

    public SimplePlayer(PlayerType p) {
        super(p);
    }

    @Override
    public Cell nextMove(Board b) {
        if (b.emptyCells().isEmpty()) {
            return null;
        }
        Cell c = b.emptyCells().get(0);
        return new Cell(c.getRow(), c.getCol(), this.myType);
    }

}
