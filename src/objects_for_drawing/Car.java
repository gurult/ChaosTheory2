package objects_for_drawing;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import Transformations.AffineTransformations;
import cord_system.CordSystem;

public class Car {
	
	public MyRectangle firstWheel;
	public MyRectangle secondWheel;
	//public Line 
	public Point2D point; // taðkas, kurio atþvilgiu daromas posukis
	
	Line line = new Line();
	
	public Car() {
		init();
	}
	
	public void init() {
		
		 firstWheel = new MyRectangle(0, 500, 50);	
		 secondWheel = new MyRectangle(90, CordSystem.hillfunction(90), 50);
	
		//------------------------------------
		 point = new Point2D.Double();
		
		 // pirmas ratas
		 point.setLocation(0, 500);
		 putOnTheLine(firstWheel, point);
		
		 //antras ratas
		 point.setLocation(90, CordSystem.hillfunction(90));
		 putOnTheLine(secondWheel, point);
		

	}
	
	private void putOnTheLine(MyRectangle rec, Point2D p) {
		AffineTransformations.rotateRectangle(30, p, rec, 'n');
		AffineTransformations.affineTransformNeg(p, rec.midlePoint, 30);

	}
	
	// Nupieðti ratà
	public void DrawCar(Graphics2D gg) {
		firstWheel.drawMyRectangle(gg);
		secondWheel.drawMyRectangle(gg);
		gg.draw(new Line2D.Double(firstWheel.midlePoint, secondWheel.midlePoint));

	}
	
	public void rotateCar(double kampas, Point2D p, char c) {
		
		AffineTransformations.rotateRectangle(kampas, p, firstWheel, c);
		AffineTransformations.rotateRectangle(kampas, p, secondWheel, c);
		
		AffineTransformations.affineTransform(p, firstWheel.midlePoint, kampas, c);
		AffineTransformations.affineTransform(p, secondWheel.midlePoint, kampas, c);
	}

}
