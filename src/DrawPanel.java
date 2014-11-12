import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.Timer;

import Transformations.AffineTransformations;
import objects_for_drawing.Car;
import objects_for_drawing.Line;
import objects_for_drawing.MyRectangle;
import cord_system.CordSystem;

@SuppressWarnings("serial")
public class DrawPanel extends JComponent {
	
	
	public static int kampas = 0;
	Car car = new Car();
	
	Point2D temp1 = new Point2D.Double();
	Point2D temp2 = new Point2D.Double();
	
	public static int counter = 0;
	
	private Timer tm = new Timer(30,new ActionListener(){
		public void actionPerformed(ActionEvent ae){
			
			//double kampas = 0;
			if (counter == 0) 
			{
				if(kampas == 0)
				{
					temp1.setLocation(car.firstWheel.d);
					temp2.setLocation(car.secondWheel.d);
					
					System.out.println(car.secondWheel.d);
					System.out.println(car.firstWheel.d);
					System.out.println("veikia");
				}
					AffineTransformations.rotateRectangle(kampas, temp1, car.firstWheel, 'p');
					AffineTransformations.affineTransform(temp1, car.firstWheel.midlePoint, kampas, 'p');
					
				
					AffineTransformations.rotateRectangle(kampas, temp2, car.secondWheel, 'p');
					AffineTransformations.affineTransform(temp2, car.secondWheel.midlePoint, kampas, 'p');
					
					kampas +=1;
					
					if (kampas == 14) {
						counter = (counter + 1 ) % 4;
						kampas = 0;
					}
			}
			
			if (counter == 1) 
			{
				if(kampas == 0)
				{
					temp1.setLocation(car.firstWheel.c);
					temp2.setLocation(car.secondWheel.c);
					
					System.out.println(car.secondWheel.c);
					System.out.println(car.firstWheel.c);
					System.out.println("veikia1");
				}
					AffineTransformations.rotateRectangle(kampas, temp1, car.firstWheel, 'p');
					AffineTransformations.affineTransform(temp1, car.firstWheel.midlePoint, kampas, 'p');
					
				
					AffineTransformations.rotateRectangle(kampas, temp2, car.secondWheel, 'p');
					AffineTransformations.affineTransform(temp2, car.secondWheel.midlePoint, kampas, 'p');
					
					kampas +=1;
					
					if (kampas == 14) {
						counter = (counter + 1 ) % 4;
						kampas = 0;
					}
			}
			
			if (counter == 2) 
			{
				if(kampas == 0)
				{
					temp1.setLocation(car.firstWheel.b);
					temp2.setLocation(car.secondWheel.b);
					
					System.out.println(car.secondWheel.b);
					System.out.println(car.firstWheel.b);
					System.out.println("veikia2");
				}
					AffineTransformations.rotateRectangle(kampas, temp1, car.firstWheel, 'p');
					AffineTransformations.affineTransform(temp1, car.firstWheel.midlePoint, kampas, 'p');
					
				
					AffineTransformations.rotateRectangle(kampas, temp2, car.secondWheel, 'p');
					AffineTransformations.affineTransform(temp2, car.secondWheel.midlePoint, kampas, 'p');
					
					kampas +=1;
					
					if (kampas == 14) {
						counter = (counter + 1 ) % 4;
						kampas = 0;
					}
			}
			
			if (counter == 3) 
			{
				if(kampas == 0)
				{
					temp1.setLocation(car.firstWheel.a);
					temp2.setLocation(car.secondWheel.a);
					
					System.out.println(car.secondWheel.a);
					System.out.println(car.firstWheel.a);
					System.out.println("veikia3.");
				}
					AffineTransformations.rotateRectangle(kampas, temp1, car.firstWheel, 'p');
					AffineTransformations.affineTransform(temp1, car.firstWheel.midlePoint, kampas, 'p');
					
				
					AffineTransformations.rotateRectangle(kampas, temp2, car.secondWheel, 'p');
					AffineTransformations.affineTransform(temp2, car.secondWheel.midlePoint, kampas, 'p');
					
					kampas +=1;
					
					if (kampas == 14) {
						counter = (counter + 1 ) % 4;
						kampas = 0;
					}
			}
			
			
			repaint();
			
		}
	});
	
	public DrawPanel()
	{
	
	} 
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D gg = (Graphics2D)g;
		
		int Width = getWidth();
		int Height = getHeight();
		
		// Debug begin -------->
			//System.out.println(Width + " " + Height);
		//Debug end    <--------

		
		//---------------------------
		tm.start();
		car.DrawCar(gg);
			drawHill(g);
		if(car.firstWheel.a.getX() >  500 
	
				) {
			System.out.println("eureka");

			tm.stop();
			counter = 0;
			kampas = 0; 
			car.init();
			tm.start();
		}
			
			
		
		}
	

	

	
	// function for drawning x and y axes
	
	private void drawAxes(Graphics g) {
		

	}
	
	private void drawHill(Graphics g) {
		Line hill = new Line();
		hill.a = new Point2D.Double();
		hill.b = new Point2D.Double();
		
		hill.a.setLocation(0, CordSystem.hillfunction(0));
		hill.b.setLocation(450, CordSystem.hillfunction(450)); 
		
		((Graphics2D)g).draw(new Line2D.Double(hill.a, hill.b));
	}
	
}





