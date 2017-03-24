/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solidgame.refactor;

import com.solidgame.refactor.boards.MatrixBoard;
import com.solidgame.refactor.instructions.builders.FileInstructionsBuilder;
import com.solidgame.refactor.instructions.builders.InstructionBuilder;

/**
 *
 * @author lisaula
 */
public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "TuringMachine.ser";
        Game game = new Game(new MatrixBoard(),new FileInstructionsBuilder(fileName));
        game.init();
        game.play();
    }
   
}
