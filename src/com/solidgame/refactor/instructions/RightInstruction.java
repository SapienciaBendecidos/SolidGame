/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solidgame.refactor.instructions;

import com.solidgame.refactor.boards.Board;
import com.solidgame.refactor.instructions.Instruction;

/**
 *
 * @author lisaula
 */
public class RightInstruction implements Instruction {

    public RightInstruction() {
    }

    @Override
    public void execute(Board board) throws Exception{
        board.movePlayer(DIRECTION.RIGHT);
    }
    
}
