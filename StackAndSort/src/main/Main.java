package main;

import models.Circle;
import models.Donut;
import models.Point;

public class Main{

	public static void main(String[] args) {
		
		//Point p1 = new Point();
		
	//	p1.setX(5);
	//	p1.setY(10);
	//	p1.setSelected(true);
		
	//	System.out.println(p1);
		
	//	Point p2 = new Point(10,23);
	//	p2.setSelected(true);
		
	//	System.out.println(p2);
		
	//	Line l1 = new Line();
		//	Point p1 = new Point(1,1);
		//	Point p2 = new Point(2,2);
		//	l1.setStart(p1);
		//	l1.setEnd(p2);
		//	l1.setSelected(false);
		//	System.out.println(l1);
		
	//	Rectangle r1 = new Rectangle();
	//	r1.setUpperLeft(new Point(5,5));
	//	r1.setHeight(3);
	//	r1.setWidth(6);
	//	r1.setSelected(true);
	//	System.out.println(r1);
		
		Circle c1 = new Circle();
		c1.setCenter(new Point(5,5));
		c1.setRadius(8);
		c1.setSelected(false);
		System.out.println(c1);
		
		Donut d1 = new Donut(new Point(5,5), 5, 3, false);
		System.out.println(d1);
		
	}
	
	

}
