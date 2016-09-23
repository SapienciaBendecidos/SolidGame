/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solidgame.refactor.instructions.builders;

import com.solidgame.refactor.instructions.Instruction;
import java.util.List;

/**
 *
 * @author lisaula
 */
public interface InstructionBuilder {

    public List<Instruction> load() throws Exception;
    
}
