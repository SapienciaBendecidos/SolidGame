package com.solidgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SolidGame {

    public ArrayList<String> commands;
    private static int row = 0, column = 0;
    public Map<String, Callable<Integer>> movementDictionary = new HashMap<>();
    
    private char[][] board = {
        {'R', ' ', ' ', 'P'},
        {'P', 'P', ' ', 'P'},
        {'P', 'P', ' ', ' '},
        {'P', 'P', ' ', 'F'}};
    private CommandFile commandGetter;

    public SolidGame() {
        try {
            commandGetter = new CommandFile();
            commands = commandGetter.getCommandos();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showBoard() {
        for (int i = 0; i < board[0].length; i++) {
            System.out.println(board[i]);
        }
    }

    public void populateDictionary(){
        movementDictionary.put("arriba", ()->column++);
        movementDictionary.put("abajo", ()->column--);
        movementDictionary.put("derecha", ()->row++);
        movementDictionary.put("izquierda", ()->row--);
    }
    
    public void updatePosition(String step) throws Exception{
       if(movementDictionary.containsKey(step)) {
           movementDictionary.get(step).call();
       }else
           throw new CommandNotFoundException(step);
    }

    public boolean validateWinner() {
        if (board[row][column] == 'F') {
            return true;
        }
        return false;
    }

    public void move() throws Exception {
        if (commands.size() > 0) {
            if (validateMove(commands.get(0))) {
                moveCommand();
            } else {
                System.out.println("Game over\nInvalid Position");
            }
        } else {
            System.out.println("Game Over");
        }
    }

    private void moveCommand() throws Exception {
        updatePosition(commands.get(0));
        System.out.println("You've moved: " + commands.get(0));
        commands.remove(0);
        if (validateWinner()) {
            System.out.println("...You Won...");
        } else {
            move();
        }
    }

    public boolean validateMove(String step) {
        switch (step) {
            case "arriba":
                if (row > 0) {
                    if (board[row - 1][column] != 'P') {
                        return true;
                    }
                }
                break;
            case "abajo":
                if (row < board.length - 1) {
                    if (board[row + 1][column] != 'P') {
                        return true;
                    }
                }
                break;
            case "derecha":
                if (column < board[0].length - 1) {
                    if (board[row][column + 1] != 'P') {
                        return true;
                    }
                }
                break;
            case "izquierda":
                if (column > 0) {
                    if (board[row][column - 1] != 'P') {
                        return true;
                    }
                }
                break;
        }

        return false;
    }

    public static void main(String[] args) {
        SolidGame game = new SolidGame();
        game.populateDictionary();
        for (int i = 0; i < game.commands.size(); i++) {
            System.out.println(game.commands.get(i));
            System.out.println(game.validateMove(game.commands.get(i)));
        }
        try {
            game.move();
        } catch (Exception ex) {
            Logger.getLogger(SolidGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
