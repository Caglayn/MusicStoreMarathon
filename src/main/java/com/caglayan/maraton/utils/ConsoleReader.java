package com.caglayan.maraton.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader {
	private static ConsoleReader instance;
	
	private BufferedReader reader;
	
	private ConsoleReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static ConsoleReader getInstance() {
		if(instance == null) {
			instance = new ConsoleReader();
		}
		return instance;
	}
	
	public BufferedReader getReader() {
		if(reader == null) {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}
		return this.reader;
	}

	public String readString(){
		String returnValue = "";
		try {
			returnValue= this.getReader().readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	public int readInt(){
		int returnValue = 0;
		try {
			returnValue= Integer.parseInt(this.getReader().readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	public double readDouble(){
		double returnValue = 0;
		try {
			returnValue= Double.parseDouble(this.getReader().readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}
