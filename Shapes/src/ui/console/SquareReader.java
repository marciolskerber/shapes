package ui.console;

import java.util.Scanner;

import shape.Shape;
import shape.ShapeFactory;

public class SquareReader extends RectangleReader {
	
	private static final String MESSAGE = """
	        Criar Quadrado
	    """;

	public SquareReader(Scanner scanner) {
		super(scanner);
	}
	
	@Override
	public Shape readNewShape() {
		System.out.println(MESSAGE);
		float width = readPositiveFloat("    largura: ");
		float height = readPositiveFloat("    altura: ");
		
		return ShapeFactory.createRectangle(width, height);
		
	}

}
