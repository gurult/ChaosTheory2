import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

import objects_for_drawing.MyRectangle;
import cord_system.CordSystem;
import Transformations.AffineTransformations;
import objects_for_drawing.Car;

@SuppressWarnings("serial")
public class DrawPanel extends JComponent {
	
	public DrawPanel() {
		
	} 
	
	public void paintComponent(Graphics g){
		Graphics2D gg = (Graphics2D)g;
		
		int Width = getWidth();
		int Height = getHeight();
		drawAxes(g);
		drawHill(g);
		
		// Debug begin -------->
			System.out.println(Width + " " + Height);
		//Debug end    <--------
		
		// test rectangle
		Car car  = new Car();
		car.DrawWheels(gg, car.firstWheel);
		car.DrawWheels(gg, car.secondWheel);
		
		}
	

	

	
	// function for drawning x and y axes
	
	private void drawAxes(Graphics g) {
		
		g.drawLine(CordSystem.convertToJavaX(0), CordSystem.convertToJavaY(0), 
				   CordSystem.convertToJavaX(22), CordSystem.convertToJavaY(0));
		
		g.drawLine(CordSystem.convertToJavaX(0), CordSystem.convertToJavaY(0), 
				   CordSystem.convertToJavaX(0), CordSystem.convertToJavaY(14));
	}
	
	private void drawHill(Graphics g) {
		// our hill function x range belongs 0 to 21
		int x1 = CordSystem.convertToJavaX(0);
		int y1 = CordSystem.convertToJavaY((int)CordSystem.hillfunction(0));
		
		int x2 = (CordSystem.convertToJavaX(21));
		int y2 = CordSystem.convertToJavaY((int)CordSystem.hillfunction(21));
		((Graphics2D) g).draw(new Line2D.Float(x1, y1, x2, y2));
		
		((Graphics2D) g).draw(new Line2D.Double(15.89, 25.3, 2.0, 7));
	}
	
}





