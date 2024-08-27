package models;

import view.LineDialog;
import view.DrawingPanel;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	private Point start;
	private Point end;

	
	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end = end;
	}
	
	public Line() {
		
	}
	
	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}
	
	public Line(Point start,Point end,boolean selected) {
		this(start,end);
		setSelected(selected);
	}
	
	public String toString() {
		return "Line [start= " + start + ", end= " + end + ",selected = " + isSelected() + "]";
	}
	
	public Point middleOfLine() {
		int middleX = (this.getStart().getX() + this.getEnd().getX())/2;
		int middleY = (this.getStart().getY() + this.getEnd().getY())/2;
		Point middle = new Point(middleX,middleY);
		return middle;
	}
	@Override
	public int compareTo(Object o) {
		return 0;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.setColor(getOutline());
		g.drawLine(this.getStart().getX(), this.getStart().getY(), this.getEnd().getX(), this.getEnd().getY());
		if(isSelected()) {
			g.drawRect(this.getStart().getX() -3, this.getStart().getY()-3,6,6);
			g.drawRect(this.getEnd().getX()-3, this.getEnd().getY()-3, 6, 6);
			g.drawRect(this.middleOfLine().getX()-3, this.middleOfLine().getY() -3, 6,6);
		}
	}
	
	public double lenght() {
		return start.distance(end.getX(), end.getY());
	}
	@Override
	public boolean contains(int x, int y) {
		return (start.distance(x, y) + end.distance(x, y))- lenght()<0.1;
	}
	@Override
	public void move(int newX, int newY) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void DialogEdit() {
		LineDialog lineDialog = new LineDialog();
		for(Shape shape : DrawingPanel.shapeArrayList) {
			if(shape.isSelected()) {
				String[] split = shape.toString().split(" ");
				lineDialog.getFieldXStart().setText(split[4]);
				lineDialog.getFieldYStart().setText(split[7]);
				lineDialog.getFieldXEnd().setText(split[15]);
				lineDialog.getFieldYEnd().setText(split[18]);
			}
		}
		lineDialog.setVisible(true);
		
	}
	@Override
	public void AreaPainter(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
