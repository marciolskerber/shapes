package shape;

import java.util.Objects;

import util.Validator;

public class Hexagon extends AbstractShape implements Cloneable {
	
	private float radius;
	
	public Hexagon(float radius) {
		super();
		this.setRadius(radius);
	}
	
	public void setRadius(float value) {
		
		Validator.absolute(value);
		this.radius = value;
	}
	
	public float getRadius() {
		return this.radius;
	}

	@Override
	public float area() {
		
		return (float)((3 * Math.sqrt(3) / 2 ) * Math.pow(radius, 2));
	}

	@Override
	public float perimeter() {
		
		return (float)(6 * radius);
	}
	
	@Override
	public String toString() {
		
		return String.format("Hexagon{ radius: %f\n area: %2.f\n perimeter: %2.f}", 
				radius, area(), perimeter());
	}
	
	@Override
	public Hexagon clone() {
		try {
			return (Hexagon) super.clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(this.getClass() != obj.getClass())
			return false;
		
		Hexagon other = (Hexagon) obj;
		return (Float.floatToIntBits(radius) == Float.floatToIntBits(other.getRadius()));
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(getClass(),
				Float.floatToRawIntBits(radius));
	}
}
