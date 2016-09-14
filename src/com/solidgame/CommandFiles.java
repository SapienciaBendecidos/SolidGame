package com.solidgame;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class CommandFiles {
	private FileReader rComandos;
	//public ArrayList<String> comandos;

	public CommandFiles() throws IOException{
		rComandos = new FileReader("test.scmd");
	}

	public ArrayList<String> getCommandos() throws IOException{
		ArrayList<String> comandos = new ArrayList<>();
		
		FileReader f = new FileReader("test.scmd");
		BufferedReader bf = new BufferedReader(f);
		String cadena;

		while ((cadena=bf.readLine()) != null) {
			comandos.add(cadena);
		}

		return comandos;
	}
}
