package ui.console;

import java.util.Scanner;

import shape.Shape;
import shape.ShapeFactory;

public class TriangleReader extends AbstractShapeReader {
	
	 private static final String MESSAGE = """
		        Criar Triângulo 
		    """;
	 
	 public TriangleReader (Scanner scanner) {
		 super(scanner);
	 }
	 
	 @Override
	 public Shape readNewShape() {
	        System.out.println(MESSAGE);
	        float sideA = readPositiveFloat("    Lado A: ");
	        float sideB = readPositiveFloat("    Lado B: ");
	        float sideC = readPositiveFloat("    Lado C: ");
	       
	        return ShapeFactory.createTriangle(sideA, sideB, sideC);
	    }
}
