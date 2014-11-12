package cord_system;

public final class CordSystem {
	
	private CordSystem(){
		
	}
	
	public static double hillfunction(double x) {
		return 500 - 0.5 * x; 
	}
	
	// function which converts from euclide cord. system to java cord. system.
	
	public static int convertToJavaX(double x) {
		// x belongs 0 to 22
		return (int)(20 + 30 * x);
	}
	
	public static int convertToJavaY(double y) {
		return (int)(450 - 30 * y);
	}
	
	// function which converts from java cord. system to euclide cord. system.
	
	public static double convertToEuclidex(double x) {
		return (double) ((x - 20) / 30);
	}
	
	public static double convertToEuclideY(double y) {
		return (double) ((y - 450) / (-30));
	}
}
