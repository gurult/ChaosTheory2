package objects_for_drawing;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MyRectangle {
	
	public Point2D a = new Point2D.Double();
	public Point2D b = new Point2D.Double();
	public Point2D c = new Point2D.Double();
	public Point2D d = new Point2D.Double();
	public Point2D midlePoint = new Point2D.Double();
	// x1 y1 yra kordinates apatinis kairysis kampas
	
	public MyRectangle(double x1, double y1, int length) {
		this.a.setLocation(x1, y1);
		
		double x = this.a.getX();
		double y = this.a.getY();
		
		b.setLocation(x, y - length);
		c.setLocation(x + length, y - length);
		d.setLocation(x + length, y);
		
		MidlePoint();
	}
	
	public void drawMyRectangle(Graphics2D gg) 
	{
		
		gg.draw(new Line2D.Double(a,b));
		gg.draw(new Line2D.Double(a,d));
		
		gg.draw(new Line2D.Double(c,b));
		gg.draw(new Line2D.Double(c,d));
		
	}
	
	public void MidlePoint()
	{
		double x = (c.getX() - a.getX()) / 2 + a.getX();
		double y = Math.abs((a.getY() - c.getY()) / 2 + c.getY());
		midlePoint.setLocation(x,y);
	}
	
	public Point2D getMidle()
	{
		return midlePoint;
	}
}
