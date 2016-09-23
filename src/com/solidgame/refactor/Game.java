/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solidgame.refactor;

import com.solidgame.refactor.boards.Board;
import com.solidgame.refactor.instructions.builders.InstructionBuilder;
import com.solidgame.refactor.instructions.Instruction;
import com.solidgame.refactor.exceptions.PlayerNotInDestinationException;
import java.util.List;

class Game {
    private Board board;
    private InstructionBuilder builder;
    private List<Instruction> instructions;
    
    Game(Board board, InstructionBuilder builder) {
        this.board = board;
        this.builder = builder;
    }

    void init() throws Exception {
        board.init();
        instructions = builder.load();
    }

    void play() throws Exception{
        for (Instruction instruction : instructions) {
            instruction.execute(board);
        }
        if (!board.hasPlayerArrivedDestination()) {
            throw new PlayerNotInDestinationException();
        }
    }
    
}
