package com.solidgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CommandFiles {

	public ArrayList<String> getCommandos() throws IOException{
		ArrayList<String> comandos = new ArrayList<>();
		
		FileReader file = new FileReader("test.scmd");
		BufferedReader buffer = new BufferedReader(file);
		String cadena;

		while ((cadena=buffer.readLine()) != null) {
			comandos.add(cadena);
		}

		return comandos;
	}
}
