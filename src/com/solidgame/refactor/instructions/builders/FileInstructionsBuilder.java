/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solidgame.refactor.instructions.builders;

import com.solidgame.refactor.exceptions.InvalidInstructionException;
import com.solidgame.refactor.instructions.DownInstruction;
import com.solidgame.refactor.instructions.RightInstruction;
import com.solidgame.refactor.instructions.LeftInstruction;
import com.solidgame.refactor.instructions.UpInstruction;
import com.solidgame.refactor.instructions.Instruction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lisaula
 */
public class FileInstructionsBuilder implements InstructionBuilder{
    String fileName;

    public FileInstructionsBuilder(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Instruction> load() throws Exception {
        ArrayList<Instruction> instructions = new ArrayList<>();

        FileReader file = new FileReader(fileName);
        BufferedReader fileBuffer = new BufferedReader(file);
        String instructionName;

        while ((instructionName = fileBuffer.readLine()) != null) {
            instructions.add(createInstruction(instructionName));
        }
        return instructions;
    }

    private Instruction createInstruction(String instructionName) throws InvalidInstructionException {
        Instruction instruction;
            switch(instructionName) {
                case "arriba" : 
                        instruction = new UpInstruction();
                    break;
                case "abajo" :
                        instruction = new DownInstruction();
                    break;
                case "derecha" :
                        instruction = new RightInstruction();
                    break;
                case "izquierda" :
                        instruction = new LeftInstruction();
                   break;
                default:
                    throw new InvalidInstructionException();
            }
            return instruction;
    }

    
}
