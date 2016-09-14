package SolidGame;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CommandFiles{
	private RandomAccessFile rComandos;
	//public ArrayList<String> comandos;

	public CommandFiles() throws IOException{
		rComandos = new RandomAccessFile("test.scmd", "r");
	}

	public String[] getCommandos() throws IOException{
		ArrayList<String> comandos = new ArrayList<>();

		while (rComandos.getFilePointer() < rComandos.length()) {
			comandos.add(rComandos.readUTF());
		}

		return comandos.toArray();
	}
}