import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
import javax.swing.Timer;

import Transformations.AffineTransformations;
import objects_for_drawing.Car;
import objects_for_drawing.Line;
import cord_system.CordSystem;

@SuppressWarnings("serial")
public class DrawPanel extends JComponent {
	
	
	public static int kampas = 0;
	Car car = new Car();
	
	Point2D temp1 = new Point2D.Double();
	Point2D temp2 = new Point2D.Double();
	
	public static int counter = 0;
	
        private void transformWheel(Point2D firstWheelPoint, Point2D secondWheelPoint){
            temp1.setLocation(firstWheelPoint);
            temp2.setLocation(secondWheelPoint);
            System.out.println(secondWheelPoint);
            System.out.println(firstWheelPoint);
            System.out.println("veikia: " + counter);
        }
        
        private void transform(String point){
            
            boolean correctRotation = true; //try set to false
            
            if(kampas == 0)
            {
                switch (point){
                    case "a":
                        transformWheel(car.firstWheel.a, car.secondWheel.a);
                        if (correctRotation)
                            break;
                    case "b":
                        transformWheel(car.firstWheel.b, car.secondWheel.b);
                        if (correctRotation)
                            break;
                    case "c":
                        transformWheel(car.firstWheel.c, car.secondWheel.c);
                        if (correctRotation)
                            break;
                    case "d":
                        transformWheel(car.firstWheel.d, car.secondWheel.d);
                        if (correctRotation)
                            break;
                }
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
        
	private Timer tm = new Timer(30,new ActionListener(){
		public void actionPerformed(ActionEvent ae){
                    //double kampas = 0;
                    switch (counter){
                        case 0:
                            transform("d");
                            break;
                        case 1:
                            transform("c");
                            break;
                        case 2:
                            transform("b");
                            break;
                        case 3:
                            transform("a");
                            break;
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





