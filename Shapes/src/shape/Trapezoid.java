package shape;

import java.util.Objects;

import util.Validator;

public class Trapezoid extends AbstractShape implements Cloneable {
	
	private float topWidth;
	private float bottomWidth;
	private float height;
	
	public Trapezoid(float topWidth, float bottomWidth, float height) {
		
		
		super();
		this.setTopWidth(topWidth);
		this.setBottomWidth(bottomWidth);
		this.setHeight(height);
	}
	
	public void setTopWidth(float value) {
		
		Validator.absolute(value);
		this.topWidth = value;
	}
	
	public void setBottomWidth(float value) {
		
		Validator.absolute(value);
		this.bottomWidth = value;
	}
	
	public void setHeight(float value) {
	
		Validator.absolute(value);
	this.height = value;
	
	}
	
	public float getTopWidth() {
		return this.topWidth;
	}
	
	public float getBottomWidth() {
		return this.bottomWidth;
	}
	
	public float getHeight() {
		return this.height;
	}

	@Override
	public float area() {
		
		return (float)(((bottomWidth + topWidth) * height) / 2);
	}

	@Override
	public float perimeter() {
		
		float x = (bottomWidth - topWidth) / 2;
		float obliqueSide = (float)Math.sqrt(Math.pow(x, 2) + Math.pow(height, 2));
		
		return (float)(bottomWidth + topWidth) + (2 * obliqueSide);
	}
	
	@Override
	public String toString() {
		
		return String.format("Trapezoid{\nbottom width: %f\ntop width: %f\nheight: %f\narea: %.2f\nperimeter: %.2f}", 
				bottomWidth, topWidth, height, area(), perimeter());
	}
	
	@Override
	public Trapezoid clone() {
		try {
			return (Trapezoid) super.clone();
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
		
		Trapezoid other = (Trapezoid) obj;
		return ((Float.floatToIntBits(bottomWidth) == Float.floatToIntBits(other.bottomWidth)) &&
				(Float.floatToIntBits(topWidth) == Float.floatToIntBits(other.topWidth)) && 
				(Float.floatToIntBits(height) == Float.floatToIntBits(other.height) ));
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getClass(),
				Float.floatToIntBits(bottomWidth),
				Float.floatToIntBits(topWidth),
				Float.floatToIntBits(height));
	}

}


