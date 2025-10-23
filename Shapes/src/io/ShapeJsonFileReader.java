package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import shape.Shape;

public class ShapeJsonFileReader {
	
	private final 
	Gson gson = new Gson();
	
	private final
	File file;
	
	public ShapeJsonFileReader(File file) {
		this.file = file;	
	}
	
	public ShapeJsonFileReader(String fileName) {
		this(new File(fileName));
	}
	
	public List<Shape> readAll() throws IOException {
		
		try(BufferedReader reader = new BufferedReader(new FileReader
		
	}
	
}
