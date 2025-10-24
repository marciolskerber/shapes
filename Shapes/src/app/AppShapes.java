package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import io.ShapeJsonFileReader;
import io.ShapeJsonFileWriter;
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

			}
			catch (Exception e) {
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
		ShapeReader reader = ShapeReaderFactory.createReader(shapeType, scanner);
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

	private void saveToFile() throws IOException {

		System.out.print("Digite o nome do arquivo: ");
		String fileName = scanner.nextLine();

		System.out.print("Sobrescrever caso já exista? (S/N)");
		boolean overWrite = scanner.nextLine().toUpperCase().startsWith("S");

		ShapeJsonFileWriter writer = new ShapeJsonFileWriter(fileName);
		if(overWrite)
			writer.write(this.shapes.toArray(new Shape[0]));
		else
			writer.append(this.shapes.toArray(new Shape[0]));

	}

	private void readFromFile() {

		System.out.print("Digite o local e nome do arquivo para ler as formas (ex: shapes.json): ");
		String filePath = scanner.nextLine();

		try {

			ShapeJsonFileReader fileReader = new ShapeJsonFileReader(filePath);

			List<Shape> loadedShapes = fileReader.readAll();

			this.shapes = loadedShapes; 

			showMessage(MessageType.INFORMATION, String.format("%d formas carregadas com sucesso de: %s", this.shapes.size(), filePath));

		} catch (IOException e) {
			showMessage(MessageType.ERROR, "Erro ao ler as formas. Verifique o caminho e permissões: " + e.getMessage());
		} catch (Exception e) { 
			showMessage(MessageType.ERROR, "Erro durante o processamento do arquivo: " + e.getMessage());
		}
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


