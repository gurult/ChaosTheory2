package objects_for_drawing;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import Transformations.AffineTransformations;
import cord_system.CordSystem;

public class Car {
	
	public MyRectangle firstWheel;
	public MyRectangle secondWheel;
	
	public Point2D point; // taðkas, kurio atþvilgiu daromas posukis
	
	public Car() {
		init();
		putOnTheLine(firstWheel, firstWheel.a);
		putOnTheLine(secondWheel, secondWheel.a);
	}
	
	private void init() {

		point = new Point2D.Double();
		
		firstWheel = new MyRectangle();
		 
		firstWheel.a = new Point2D.Double(0,0);
		firstWheel.b = new Point2D.Double(0,1);
		firstWheel.c = new Point2D.Double(1,0);
		firstWheel.d = new Point2D.Double(1,1);
		
		secondWheel = new MyRectangle();
		 
		secondWheel.a = new Point2D.Double(2, 1);
		secondWheel.b = new Point2D.Double(2, 2);
		secondWheel.c = new Point2D.Double(3, 1);
		secondWheel.d = new Point2D.Double(3, 2);
	}
	
	private void putOnTheLine(MyRectangle rec, Point2D p) {
		
		// padedama padanga taip, kad ji atitiktø tiesæ y = 0.5 * x
		MyRectangle temp = rec;
		point.setLocation(p);
		
		AffineTransformations.affineTransformPos(point, temp.a, 30);
		AffineTransformations.affineTransformPos(point, temp.b, 30);
		AffineTransformations.affineTransformPos(point, temp.c, 30);
		AffineTransformations.affineTransformPos(point, temp.d, 30);
		
	}
	
	// Nupieðti ratà
	public void DrawWheels(Graphics2D gg, MyRectangle t) {
		gg.draw(new Line2D.Double(
				CordSystem.convertToJavaX(t.a.getX()),
				CordSystem.convertToJavaY(t.a.getY()),
				CordSystem.convertToJavaX(t.b.getX()),
				CordSystem.convertToJavaY(t.b.getY())
				));
		
		gg.draw(new Line2D.Double(
				CordSystem.convertToJavaX(t.d.getX()),
				CordSystem.convertToJavaY(t.d.getY()),
				CordSystem.convertToJavaX(t.c.getX()),
				CordSystem.convertToJavaY(t.c.getY())
				));
		
		gg.draw(new Line2D.Double(
				CordSystem.convertToJavaX(t.d.getX()),
				CordSystem.convertToJavaY(t.d.getY()),
				CordSystem.convertToJavaX(t.b.getX()),
				CordSystem.convertToJavaY(t.b.getY())
				));
		
		gg.draw(new Line2D.Double(
				CordSystem.convertToJavaX(t.a.getX()),
				CordSystem.convertToJavaY(t.a.getY()),
				CordSystem.convertToJavaX(t.c.getX()),
				CordSystem.convertToJavaY(t.c.getY())
				));
	}
	
	public void rotateWheels(MyRectangle temp, double angle) {
		
	}

}
