package SolidGame;

/*import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.io.RandomAccessFile;*/

public class SolidGame {
	private String [] comandos;
	private char [][] tablero = {
			{'R', ' ', ' ', 'P'}, 
			{'P', 'P', ' ', 'P'}, 
			{'P', 'P', ' ', ' '},
			{'P', 'P', ' ', 'F'}};
	private CommandFiles commandGetter;

	public SolidGame(){
		try{
			commandGetter = new CommandFiles();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void showTablero(){
		for (int i = 0; i < tablero[0].length; i++) {
			System.out.println(tablero[i]);			
		}
	}
}