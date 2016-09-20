/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solidgame.refactor;

class Game {
    private Board board;
    private InstructionBuilder builder;
    private List<Instruction> instructions;
    
    Game(Board board, InstructionBuilder builder) {
        this.board = board;
        this.builder = builder;
    }

    void init() {
        board.init();
        instructions = builder.load();
    }

    void play() {
        for (Instruction instruction : instructions) {
            instruction.execute(board);
        }
    }
    
}
