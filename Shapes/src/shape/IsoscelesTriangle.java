package shape;

public class IsoscelesTriangle extends Triangle {
	
	public IsoscelesTriangle(float base, float side) {
		super(base, side, side);
	}

	@Override
	public String toString() {
		return String.format("IsoscelesTriangle{\nbase: %f\nside: %f\narea: %2.f\nperimeter: %2.f}", 
				getSideA(), getSideB(), area(), perimeter());
	}
}