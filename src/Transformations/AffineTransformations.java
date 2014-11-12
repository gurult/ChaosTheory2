package Transformations;
import java.awt.geom.Point2D;

import objects_for_drawing.MyRectangle;

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
	
	public static void affineTransform(Point2D a, Point2D b, double angDeg, char c) {
		
		if (c == 'p'){
			affineTransformPos(a, b, angDeg);
		} else {
			affineTransformNeg(a, b, angDeg);
		}
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
	public static void rotateRectangle(double kampas, Point2D point,MyRectangle rec, char p ) 
	{
		if (p == 'n')
		{
			affineTransformNeg(point, rec.a, kampas);
			affineTransformNeg(point, rec.b, kampas);
			affineTransformNeg(point, rec.c, kampas);
			affineTransformNeg(point, rec.d, kampas);
		}
		
		if (p == 'p')
		{
			affineTransformPos(point, rec.a, kampas);
			affineTransformPos(point, rec.b, kampas);
			affineTransformPos(point, rec.c, kampas);
			affineTransformPos(point, rec.d, kampas);
		}
	}
	
}
