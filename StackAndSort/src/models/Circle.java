package models;

import view.CircleDialog;
import view.DrawingPanel;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	private Point center;
	private int radius;
	
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}


	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center,radius);
		setSelected(selected);
	}
	
	public String toString() {
		return "[ center = " + center + ", radius= " + radius + " selected = " + isSelected() + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setColor(getOutline());
		g.drawOval(
		this.getCenter().getX() - this.getRadius(),
		this.getCenter().getY() - this.getRadius(),
		this.getRadius()*2,
		this.getRadius()*2);		
		
		if(isSelected()) {
		g.drawRect(this.getCenter().getX()-3, this.getCenter().getY()-3, 6, 6);
		g.drawRect(this.getCenter().getX()-3,this.getCenter().getY()-this.getRadius() -3 ,6 ,6);
		g.drawRect(this.getCenter().getX()-3,this.getCenter().getY()+this.getRadius() -3 ,6 ,6);
		g.drawRect(this.getCenter().getX()-this.getRadius() -3, this.getCenter().getY()-3,6,6);
		g.drawRect(this.getCenter().getX()+this.getRadius() -3, this.getCenter().getY()-3,6,6);
		}
	}
	@Override
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= this.getRadius();
	}
	@Override
	public void move(int newX, int newY) {
		center.move(newX, newY);
		
	}
	@Override
	public void DialogEdit() {
		CircleDialog circleDialog = new CircleDialog();
		for(Shape shape : DrawingPanel.shapeArrayList) {
			if(shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				circleDialog.getFieldXCoord().setText(split[5]);
				circleDialog.getFieldYCoord().setText(split[8]);
				circleDialog.getFieldRadius().setText(split[14]);
			}
		}
		circleDialog.setVisible(true);
		
	}
	@Override
	public void AreaPainter(Graphics g) {
		
		g.setColor(getFill());
		g.fillOval(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius() , this.getRadius() *2 , this.getRadius() *2);		
	}
		
	}

