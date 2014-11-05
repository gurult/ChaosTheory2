package Transformations;
import java.awt.geom.Point2D;

// klase yra final, kad niekas negalëtø jos paveldët
public final class AffineTransformations {

// privatus Constructorius
	private AffineTransformations() {
		// empty because we do not wan let have an instance of the class
	}

	// a - kokio taðko atþvilgiu darysime posuká
	// b - koki taðkà sukane
	// angDeg - kokiu kampu nurodome laipsniais

//---------------------------------------------------------------------
	// daro posuká taðko a atþvilgiu prieð laikrodþio rodyklæ
	
	// a - kokio taðko atþvilgiu darysime posuká
	// b - koki taðkà sukane
	// angDeg - kokiu kampu nurodome laipsniais

	public static void affineTransformPos(Point2D a, Point2D b, double angDeg) {

		double rad = Math.toRadians(angDeg);

		double functionX = ((Math.cos(rad) * (b.getX() - a.getX())) + 
							(Math.sin(rad) * (a.getY() - b.getY())))
							+ a.getX();

		double functionY = (Math.sin(rad) * (b.getX() - a.getX()) + 
							Math.cos(rad) * (b.getY() - a.getY())) + 
							a.getY();

		b.setLocation(functionX, functionY);
	
	}
//---------------------------------------------------------------------
	// daro posuká taðko a atþvilgiu pagal laikrodþio rodyklæ
	
	// a - kokio taðko atþvilgiu darysime posuká
	// b - koki taðkà sukane
	// angDeg - kokiu kampu nurodome laipsniais

	public static void affineTransformNeg(Point2D a, Point2D b, double angDeg) {

		double rad = Math.toRadians(angDeg);

		double functionX =  (Math.cos(rad) * (b.getX() - a.getX()) + 
							 Math.sin(rad) * (b.getY() - a.getY()))
							+ a.getX();

		double functionY = (Math.sin(rad) * (a.getX() - b.getX()) +
							Math.cos(rad) * (b.getY() - a.getY())) + a.getY();

		b.setLocation(functionX, functionY);

	}	
//------------------------------------------------------------------------

}
