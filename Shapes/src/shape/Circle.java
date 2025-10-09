package shape;

import util.Validator;

public class Circle extends Ellipse {
	
	public Circle(float radius) {
		super(radius, radius);
	}
	
	public float getRadius() {
		return this.getMajorRadius();
	}
	
	public void setRadius(float value) {
		Validator.absolute(value);
		this.setMajorRadius(value);
		this.setMinorRadius(value);
	}
	
	@Override
	public String toString() {
		return String.format("Circle{ radius: %.2f | area: %.2f | perimeter: %.2f}", 
				getRadius(), area(), perimeter());
	}
}