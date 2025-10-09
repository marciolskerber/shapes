package shape;

import java.util.Objects;

import util.Validator;

public class Rectangle extends AbstractShape implements Cloneable{
	
	private float width;
	private float height;
	
	public Rectangle(float width, float height) {
		
		super();
		this.setWidth(width);
		this.setHeight(height);
		
	}
	
	public void setWidth(float value) {
		
		Validator.absolute(value);
		this.width = value;
	}
	
	public void setHeight(float value) {
		
		Validator.absolute(value);
		this.height = value;
	}
	
	public float getWidth() {
		return this.width;
		
	}
	
	public float getHeight() {
		return this.height;
	}

	@Override
	public float area() {
		
		return (float)(width * height);
	}

	@Override
	public float perimeter() {
		
		return (float)(2 * width) + (2 * height);
	}
	
	@Override
	public String toString() {
		
		return String.format("Rectangle{width: %.2f | height: %.2f | area: %.2f | perimeter: %.2f}", 
				width, height, area(), perimeter());
	}
	
	@Override
	public Rectangle clone() {
		try {
			return (Rectangle) super.clone();
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
		
		Rectangle other = (Rectangle) obj;
		return ((Float.floatToIntBits(width) == Float.floatToIntBits(other.width)) &&
				(Float.floatToIntBits(height) == Float.floatToIntBits(other.height)));
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(getClass(),
				Float.floatToRawIntBits(width),
				Float.floatToRawIntBits(height));
		
	}

}


