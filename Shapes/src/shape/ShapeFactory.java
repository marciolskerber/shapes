package shape;

public class ShapeFactory {
	
	static public enum ShapeType {
		ELLIPSE, CIRCLE, RECTANGLE, SQUARE, RHOMBUS, TRIANGLE, EQUILATERAL_TRIANGLE, ISOSCELES_TRIANGLE, RIGHT_TRIANGLE, HEXAGON, PENTAGON,
		HEPTAGON, OCTAGON, TRAPEZIUM, ISOSCELES_TRAPEZIUM, RIGHT_TRAPEZIUM;
		
		public static ShapeType valueOf(int index) {
			return values() [index];
		}
	};
	
	static private
	final RuntimeException NOT_SUPPORTED = new RuntimeException("Operation not supported");
	
	private ShapeFactory() {/* to block instantiation */}
	
	static public
	Shape createEllipse(float majorRadius, float minorRadius) {
		return new Ellipse(majorRadius, minorRadius);
	}
	
	static public
	Shape createCircle(float radius) {
		return new Circle(radius);
	}
	
	static public
	Shape createRectangle(float width, float height) {
		return new Rectangle(width, height);
	}
	
	static public
	Shape createSquare(float side) {
		return new Square(side, side);
	}
	
	static public
	Shape createHexagon(float radius) {
		return new Hexagon(radius);
	}
	
	static public
	Shape createTrapezoid(float topWidth, float bottomWidth, float height) {
		return new Trapezoid(topWidth, bottomWidth, height);
	}
	
	static public
	Shape createTriangle(float sideA, float sideB, float sideC) {
		return new Triangle(sideA, sideB, sideC);
	}
	
	static public
	Shape createIsoscelesTriangle(float base, float side) {
		return new IsoscelesTriangle(base, side);
	}
	
	static public
	Shape createEquilateralTriangle(float side) {
		return new EquilateralTriangle(side);
	}
	
	static public
	Shape create(String shapeName, float... args) {
		
		ShapeType shapeType = ShapeType.valueOf(shapeName.toUpperCase());
		
		return create(shapeType, args);
	}
	
	static public
	Shape create(ShapeType shapeType, float... args) {
		
		switch(shapeType) {
		
		case CIRCLE:
			return createCircle(args[0]);
			
		case ELLIPSE:
			return createEllipse(args[0], args[1]);
		
		case HEXAGON:
			return createHexagon(args[0]);
			
		case RECTANGLE:
			return createRectangle(args[0], args[1]);
		
		case SQUARE:
			return createSquare(args[0]);
		
		case TRAPEZIUM:
			return createTrapezoid(args[0], args[1], args[2]);
		
		case TRIANGLE:
			return createTriangle(args[0], args[1], args[2]);
		
		case ISOSCELES_TRIANGLE:
			return createIsoscelesTriangle(args[0], args[1]);
			
		case EQUILATERAL_TRIANGLE:
			return createEquilateralTriangle(args[0]);
			
		default:
			throw NOT_SUPPORTED;
		}
	}
}