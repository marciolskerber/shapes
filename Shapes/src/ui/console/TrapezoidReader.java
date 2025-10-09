package ui.console;

import java.util.Scanner;

import shape.Shape;
import shape.ShapeFactory;

public class TrapezoidReader extends AbstractShapeReader {
	
	 private static final String MESSAGE = """
		        Criar Trapézio
		    """;
	 
	 public TrapezoidReader (Scanner scanner) {
		 super(scanner);
	 }
	 
	 @Override
	 public Shape readNewShape() {
	        System.out.println(MESSAGE);
	        float bottonWidth = readPositiveFloat("    Largura Inferior: ");
	        float topWidth = readPositiveFloat("    Largura Superior: ");
	        float height = readPositiveFloat("    Altura: ");
	       
	        return ShapeFactory.createTriangle(bottonWidth, topWidth, height);
	    }
}
