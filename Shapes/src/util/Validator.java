package util;

public abstract class Validator {
	
	static private String message = "Invalid value:";
	
	static public void absolute(long value) {
		if(value < 0)
			
			throw new RuntimeException(String.format("%s %d", message, value));
	}
	
	static public void absolute(double value) {
		
		if(value < 0)
			throw new RuntimeException(String.format("%s %f", message, value));
		}
	
	private Validator() {/*blocks instantiation*/}
}


