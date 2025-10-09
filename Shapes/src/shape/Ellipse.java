package shape;

import java.util.Objects;
import util.Validator;

public class Ellipse extends AbstractShape implements Cloneable {
	
	private float majorRadius;
	private float minorRadius;
	
	public Ellipse(float majorRadius, float minorRadius) {
		super();
		this.setMajorRadius(majorRadius);
		this.setMinorRadius(minorRadius);
	}
	
	public void setMajorRadius(float value) {
		Validator.absolute(value);
		this.majorRadius = value;
	}
	
	public void setMinorRadius(float value) {
		Validator.absolute(value);
		this.minorRadius = value;
	}
	
	public float getMajorRadius() {
		return this.majorRadius;
	}
	
	public float getMinorRadius() {
		return this.minorRadius;
	}

	@Override
	public float area() {
		return (float) (Math.PI * majorRadius * minorRadius);
	}

	@Override
	public float perimeter() {
		return (float) (2 * Math.PI * Math.sqrt((Math.pow(majorRadius, 2) + Math.pow(minorRadius, 2)) / 2));
	}
	
	@Override
	public String toString() {
		return String.format("Ellipse{major radius: %.2f | minor radius: %.2f | area: %.2f | perimeter: %.2f}", 
				majorRadius, minorRadius, area(), perimeter());
	}
	
	@Override
	public Ellipse clone() {
		try {
			return (Ellipse) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Ellipse other = (Ellipse) obj;
		return Float.floatToIntBits(majorRadius) == Float.floatToIntBits(other.majorRadius)
				&& Float.floatToIntBits(minorRadius) == Float.floatToIntBits(other.minorRadius);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getClass(), Float.floatToIntBits(majorRadius), Float.floatToIntBits(minorRadius));
	}
}