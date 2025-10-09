package ui.console;

import java.util.Scanner;

import shape.Shape;
import shape.ShapeFactory;

public class IsoscelesTriangleReader extends AbstractShapeReader {
	
	 private static final String MESSAGE = """
		        Criar Triangulo Isosceles
		    """;
	 
	 public IsoscelesTriangleReader (Scanner scanner) {
		 super(scanner);
	 }
	 
	 @Override
	 public Shape readNewShape() {
	        System.out.println(MESSAGE);
	        float sideA = readPositiveFloat("    Lado A: ");
	        float sideB = readPositiveFloat("    Lado B: ");
	       
	        return ShapeFactory.createIsoscelesTriangle(sideA, sideB);
	    }
}
