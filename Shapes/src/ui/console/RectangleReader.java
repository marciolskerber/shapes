package ui.console;

import java.util.Scanner;
import shape.Shape;
import shape.ShapeFactory;

public class RectangleReader extends AbstractShapeReader {

    private static final String MESSAGE = """
        Criar Retangulo
    """;
    
    public RectangleReader(Scanner scanner) {
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