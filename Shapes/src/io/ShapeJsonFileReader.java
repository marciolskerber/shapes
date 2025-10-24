package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Modifier;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import shape.Shape;

public class ShapeJsonFileReader {

	private final Gson gson = new GsonBuilder()
	.excludeFieldsWithModifiers(Modifier.STATIC)
	.create();

	private final File file;

	public ShapeJsonFileReader(File file) {
		this.file = file;	
	}

	public ShapeJsonFileReader(String fileName) {
		this(new File(fileName));
	}

	public List<Shape> readAll() throws IOException {

		java.lang.reflect.Type listType = new TypeToken<ArrayList<Shape>>(){}.getType();
		List<Shape> shapes;


		try(BufferedReader reader = new BufferedReader(new FileReader(this.file))) {

			shapes = gson.fromJson(reader, listType);
			return shapes != null ? shapes : new ArrayList<>();
		}

	}

}