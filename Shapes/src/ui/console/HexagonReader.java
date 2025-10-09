package ui.console;

import java.util.Scanner;

import shape.Shape;
import shape.ShapeFactory;

public class HexagonReader extends AbstractShapeReader {
	
	 private static final String MESSAGE = """
		        Criar Hexágono
		    """;
	 
	 public HexagonReader(Scanner scanner) {
		 super(scanner);
	 }
	 
	 @Override
	 public Shape readNewShape() {
	        System.out.println(MESSAGE);
	        float radius = readPositiveFloat("    Raio: ");
	       
	        return ShapeFactory.createHexagon(radius);
	    }
}
