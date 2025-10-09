package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

import shape.Shape;
import shape.ShapeFactory;

public class AppTest {
	
public static void main(String[] args) {
		
		List <Shape> shapes = new ArrayList<>();
		
		Collections.addAll(shapes,
				ShapeFactory.createCircle(2),
				ShapeFactory.createEllipse(5, 10),
				ShapeFactory.createRectangle(10, 20),
				ShapeFactory.createSquare(10));
		
		Gson gson = new Gson();
		
		String fileName = "shapes.txt";
		File file = new File(fileName);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {for(Shape shape : shapes) {
			String json = gson.toJson(shape);
			writer.append(json);
			writer.newLine();
		};
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(file.getAbsolutePath());
	}
}
