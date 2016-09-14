package com.solidgame;

import java.util.ArrayList;

public class SolidGame {
	public ArrayList<String> commands;
	private int row=0, column=0;
	private char [][] board = {
			{'R', ' ', ' ', 'P'}, 
			{'P', 'P', ' ', 'P'}, 
			{'P', 'P', ' ', ' '},
			{'P', 'P', ' ', 'F'}};
	private CommandFiles commandGetter;

	public SolidGame(){
		try{
			commandGetter = new CommandFiles();
			commands = commandGetter.getCommandos();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void showTablero(){
		for (int i = 0; i < board[0].length; i++) {
			System.out.println(board[i]);			
		}
	}
	
	public boolean validateMove(String step){
		switch(step){
			case "arriba":
				if(row>0){
					if(board[row-1][column]!='P'){
						return true;
					}
				}
			break;
			case "abajo":
				if(row<board.length-1){
					if(board[row+1][column]!='P'){
						return true;
					}
				}
			break;
			case "derecha":
				if(column<board[0].length-1){
					if(board[row][column+1]!='P'){
						return true;
					}
				}
			break;
			case "izquierda":
				if(column>0){
					if(board[row][column-1]!='P'){
						return true;
					}
				}
			break;
		}
		
		return false;
	}

	public static void main(String[] args) {
		SolidGame game = new SolidGame();
		for (int i=0; i<game.commands.size(); i++) {
			System.out.println(game.commands.get(i));
			System.out.println(game.validateMove(game.commands.get(i)));
		}
		
	}
}
