package ui.menu;

import java.util.Scanner;

import shape.ShapeFactory.ShapeType;

public class Menu {

	static private 
	Scanner scanner = new Scanner(System.in);
	
	//--------------------------------------------------------
	private int readOption(int min, int max) {
		
		int option =-1;
		while(option < min || option > max) {
			
			System.out.print("Opção: ");
			option = scanner.nextInt();
			scanner.nextLine();
		}
		return option;
	}
	
	//--------------------------------------------------------
	public int showMainMenu() {
		
		System.out.println("""
				|-----------------------------------------|
				|         ESCOLHA UMA OPÇÃO               |
				|-----------------------------------------|
				|   1 - Criar uma nova Forma Geométrica   |
				|   2 - Ver a lista de Formas Geométricas |
				|   3 - Excluir uma Forma Geométrica      |
				|   4 - Salvar lista em Arquivo           |
				|   5 - Carregar lista do Arquivo         |
				|   0 - Sair                              |
				|-----------------------------------------|
				""");
		return readOption(0,5);
	}
	
	//--------------------------------------------------------
	public int showShapeMenu() {
		
		System.out.println("""
				|-----------------------------------------|
				|   ESCOLHA UMA FORMA GEOMÉTRICA          |
				|-----------------------------------------|
				|   1 - Elipse                            |
				|   2 - Circulo                           |
				|   3 - Retângulo                         |
				|   4 - Quadrado                          |
				|   5 - Losango                           |
				|   6 - Triângulo                         |
				|   7 - Triângulo Equilátero              |
				|   8 - Triângulo Isósceles               |
				|   9 - Triângulo Reto                    | 
				|  10 - Hexagono                          |
				|  11 - Pentagono                         |
				|  12 - Heptagono                         |
				|  13 - Octagono                          |
				|  14 - Trapézio                          |
				|  15 - Trapézio Isósceles                |
				|  16 - Trapézio Reto                     |
				|   0 - VOLTAR AO MENU ANTERIOR           |
				|-----------------------------------------|
 				""");
		return readOption(0,16);
	}
	
	/* ********************************************************
	* For test only
	**********************************************************/
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		int mainOption = 0;
		do {
			mainOption = menu.showMainMenu();
			
			if(mainOption == 1) {
				
				int shapeOption = menu.showShapeMenu();
				while (shapeOption != 0) {
					
					ShapeType shapeType = ShapeType.valueOf(shapeOption - 1);
					String messageFormat = "Opção %d criar: %s (tecle 'ENTER')\n"; 
					System.out.printf(messageFormat, shapeOption, shapeType);
					scanner.nextLine();
					shapeOption = menu.showShapeMenu();
				}
			}
		} while (mainOption != 0);
		System.out.println("Fim.");
	}
}
