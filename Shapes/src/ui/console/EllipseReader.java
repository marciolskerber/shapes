package ui.console;

import java.util.Scanner;
import shape.Shape;
import shape.ShapeFactory;

public class EllipseReader extends AbstractShapeReader {

    private static final String MESSAGE = """
        Criar Elipse
    """;

    public EllipseReader(Scanner scanner) {
        super(scanner);
    }

    @Override
    public Shape readNewShape() {
        System.out.println(MESSAGE);
        float majorRadius = readPositiveFloat("    raio maior: ");
        float minorRadius = readPositiveFloat("    raio menor: ");
        
        return ShapeFactory.createEllipse(majorRadius, minorRadius);
    }
}