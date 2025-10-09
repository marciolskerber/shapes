package ui.console;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class AbstractShapeReader implements ShapeReader {
    
    protected Scanner scanner;

    public AbstractShapeReader(Scanner scanner) {
        this.scanner = scanner;
    }
    
    protected float readPositiveFloat(String prompt) {
        float value = -1;
        do {
            try {
                System.out.print(prompt);
                value = scanner.nextFloat();
                if (value < 0) {
                    System.out.println("O valor não pode ser negativo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
                value = -1;
            } finally {
                scanner.nextLine();
            }
        } while (value < 0);
        return value;
    }
}