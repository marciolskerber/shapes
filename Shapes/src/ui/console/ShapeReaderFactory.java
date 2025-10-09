package ui.console;

import java.util.Scanner;
import shape.Shape;
import shape.ShapeFactory.ShapeType;

public class ShapeReaderFactory {

    private ShapeReaderFactory() {/* para bloquear a instanciação */}

    public static ShapeReader createReader(ShapeType shapeType, Scanner scanner) {
        
        switch (shapeType) {
            case CIRCLE:
                return new CircleReader(scanner);
            case ELLIPSE:
                return new EllipseReader(scanner);
            case RECTANGLE:
                return new RectangleReader(scanner);
            case SQUARE:
                return new SquareReader(scanner);
            case TRIANGLE:
                return new TriangleReader(scanner);
            case EQUILATERAL_TRIANGLE:
                return new EquilateralTriangleReader(scanner);
            case ISOSCELES_TRIANGLE:
                return new IsoscelesTriangleReader(scanner);
            case HEXAGON:
                return new HexagonReader(scanner);
            
            default:
                throw new IllegalArgumentException("Leitor de Forma não suportado para o tipo: " + shapeType);
        }
    }
    
    
    public static ShapeReader createReader(String shapeName, Scanner scanner) {
        ShapeType shapeType = ShapeType.valueOf(shapeName.toUpperCase());
        return createReader(shapeType, scanner);
    }
    
   
    public static void executeReader(Scanner scanner, ShapeType shapeType) {
        
        String shapeName = shapeType.name().replace('_', ' '); 
        System.out.printf("\n--- Testando o %s ---\n", shapeName);
        ShapeReader shapeReader = createReader(shapeType, scanner);
        Shape shape = shapeReader.readNewShape();
        System.out.println("\nResultado: " + shape);
    }
}