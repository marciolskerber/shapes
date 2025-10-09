package shape;

public class EquilateralTriangle extends Triangle {
	
	public EquilateralTriangle(float side) {
		super(side, side, side);
	}
	
	@Override
	public String toString() {
		return String.format("EquilateralTriangle{\nside: %f\n area: %2.f\nperimeter: %2.f}", 
				getSideA(), area(), perimeter());
		
	}
}