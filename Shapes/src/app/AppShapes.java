package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import shape.Shape;
import shape.ShapeFactory.ShapeType;
import ui.console.ShapeReader;
import ui.console.ShapeReaderFactory;
import ui.menu.Menu;

public class AppShapes {

	static enum MessageType {
		ERROR, INFORMATION
	};

	static private Scanner scanner = new Scanner(System.in);

	private List<Shape> shapes = new ArrayList<>(); 
	private Menu menu = new Menu();

	private void run() {

		int option = -1;
		do {
			try {
				option = menu.showMainMenu();
				switch (option) {
				case 1 -> createShape();
				case 2 -> showShapeList();
				case 3 -> deleteShape();
				case 4 -> saveToFile();
				case 5 -> readFromFile();

				}
			} catch (RuntimeException e) {
				showMessage(MessageType.ERROR, e.getMessage());
			}
		} while (option != 0);
	}

	private void createShape() {
		int option = -1;
		do {
			try {
				option = menu.showShapeMenu();
				if (option != 0)
					createShape(ShapeType.valueOf(option - 1));

			} catch (RuntimeException e) {
				showMessage(MessageType.ERROR, e.getMessage());

			}

		} while (option != 0);

	}

	private void createShape(ShapeType shapeType) {
		ShapeReader reader = ShapeReaderFactory.createReader(shapeType, null);
		Shape shape = reader.readNewShape();
		shapes.add(shape);
	}

	private void showShapeList( ) {
		
		for (int i = 0; i < shapes.size(); i++) {
		    Shape shape = shapes.get(i);
		    
		    System.out.println("------------------------------------");
		    
		    System.out.println("Forma #" + (i + 1) + ": " + shape.toString()); 
		    
		    System.out.println("  Área: " + String.format("%.2f", shape.area()));
		    System.out.println("  Perímetro: " + String.format("%.2f", shape.perimeter()));
		}
	}

	private void deleteShape() {
		throw new RuntimeException("Delete Shape - Unsuported!");
	}

	private void saveToFile() {
		throw new RuntimeException("Save To File - Unsuported!");
	}

	private void readFromFile() {
		throw new RuntimeException("Read From File - Unsuported!");
	}

	private void showMessage(MessageType type, String message) {

		System.out.printf("%s: %s\n", type, message);
		System.out.printf("TECLE ENTER");
		scanner.nextLine();
	}

	public static void main(String[] args) {
		(new AppShapes()).run();
	}

}