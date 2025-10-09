package shape;

import java.util.Objects;

import util.Validator;

public class Triangle extends AbstractShape implements Cloneable {
	
	private float sideA;
	private float sideB;
	private float sideC;
	
	public Triangle(float sideA, float sideB, float sideC) {
		
		super();
		this.setSideA(sideA);
		this.setSideB(sideB);
		this.setSideC(sideC);
	}
	
	public void setSideA(float value) {
		
		Validator.absolute(value);
		this.sideA = value;
	}
	
	public void setSideB(float value) {
		
		Validator.absolute(value);
		this.sideB = value;
	}
	
	public void setSideC(float value) {
		
		Validator.absolute(value);
		this.sideC = value;
	
	}
	
	public float getSideA() {
		return this.sideA;
	}
	
	public float getSideB() {
		return this.sideB;
	}
	
	public float getSideC() {
		return this.sideC;
	}

	@Override
	public float area() {
		
		float s = (sideA + sideB + sideC) / 2;
		return (float)(Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)));

	}

	@Override
	public float perimeter() {
		
		return (float)(sideA + sideB + sideC);
	}
	
	@Override
	public String toString() {
		
		return String.format("Triangle{\na: %.2f\nb: %.2f\nc: %.2f\narea: %2.f\nperimeter: %.2f}", 
				sideA, sideB, sideC, area(), perimeter());
	}
	
	@Override
	public Triangle clone() {
		try {
			return (Triangle) super.clone();
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
		
		Triangle other = (Triangle) obj;
		return ((Float.floatToIntBits(sideA) == Float.floatToIntBits(other.sideA)) &&
				(Float.floatToIntBits(sideB) == Float.floatToIntBits(other.sideB)) &&
				(Float.floatToIntBits(sideC) == Float.floatToIntBits(other.sideC)));
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(getClass(),
				Float.floatToRawIntBits(sideA),
				Float.floatToRawIntBits(sideB),
				Float.floatToRawIntBits(sideC));
		
	}
	
	
}
