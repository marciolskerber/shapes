package ui.console;

import java.util.InputMismatchException;
import java.util.Scanner;
import shape.Shape;
import shape.ShapeFactory;

public class CircleReader implements ShapeReader{
	
	private Scanner scanner;
	
	public CircleReader(Scanner scanner) {
		this.scanner = scanner;
	}
	
	private final
	String MESSAGE = """
		Criar Circulo
			raio: """;
	
	private final
	String INVALID_VALUE_MESSAGE = "O valor não pode ser negativo.";
	
	private final
	String ERROR_MESSAGE = "Erro: ";

@Override
public Shape readNewShape() {
	float radius = -1;
	do {
		try {
			System.out.println(MESSAGE);
			radius = scanner.nextFloat();
			
			if(radius < 0)
				System.out.println(INVALID_VALUE_MESSAGE);
		}
		catch(InputMismatchException e) {
			System.out.println(ERROR_MESSAGE + e.getMessage());
		}
		
		scanner.nextLine();
		} while (radius < 0);
	
	return ShapeFactory.createCircle(radius);
	}

}