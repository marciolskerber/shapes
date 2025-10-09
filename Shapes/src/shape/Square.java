package shape;

public class Square extends Rectangle implements Cloneable {
	
	public Square(float width, float height) {
		
		super(width, height);
	}
	
	@Override
	public void setWidth(float width) {
		
		super.setWidth(width);
		super.setHeight(width);
	}
	
	@Override
	public void setHeight(float height) {
		
		super.setHeight(height);
		super.setWidth(height);
	}
	
	@Override
	public String toString() {
		
		return String.format("Square{\nwidth: %f\nheight: %f\narea: %.2f\n perimeter: %.2f}", 
				getWidth(), getHeight(), area(), perimeter());
	}
}