package com.progmatic.tictactoeexam;

import com.progmatic.tictactoeexam.enums.PlayerType;
import com.progmatic.tictactoeexam.interfaces.AbstractPlayer;
import com.progmatic.tictactoeexam.interfaces.Board;
import java.util.List;

/**
 *
 * @author Ákos Somodi
 */
public class VictoryAwarePlayer extends AbstractPlayer {

    public VictoryAwarePlayer(PlayerType p) {
        super(p);
    }

    @Override
    public Cell nextMove(Board b) {
        List<Cell> c = b.emptyCells();

        for (Cell cell : c) {
            if (b.hasWon(this.myType)) {
                return cell;
            }
        }
        return null;

    }

}
