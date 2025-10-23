package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shape.Circle;
import shape.Rectangle;
import shape.Shape;
import shape.Square;
import shape.Triangle;

public class ShapeJsonFileWriter {

	private final Gson gson = new GsonBuilder()
			.excludeFieldsWithModifiers(Modifier.STATIC)
			.create();

	private final File file;

	public ShapeJsonFileWriter(File file) {
		this.file = file;
	}

	public ShapeJsonFileWriter(String fileName) {
		this(new File(fileName));
	}

	public void write(Shape... shapes) throws IOException {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))){write(writer, shapes);
		}
	}
	
	public void append(Shape... shapes) throws IOException {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){write(writer, shapes);
		}
	}
	
	private void write(BufferedWriter writer, Shape... shapes) throws IOException {for(Shape shape: shapes) {
		String shapeJSON = gson.toJson(shape);
		writer.append(shapeJSON);
		writer.newLine();
	}
	writer.flush();
	}
	
	//--------------------------------
	// for test only
	//--------------------------------
	public static void main(String[] args) throws Exception {
	List<Shape> list = new ArrayList<>();
	list.add(new Circle(5.0f));
	list.add(new Rectangle(2.0f, 3.5f));
	list.add(new Triangle(3, 4, 5));
	String fileName = "shapes.txt";
	ShapeJsonFileWriter shapeWriter = new ShapeJsonFileWriter(fileName);Shape[] shapeArray = list.toArray(new Shape[0]);
	shapeWriter.write(shapeArray);
	shapeWriter.append(new Square(4.0f, 0));
	}
}
