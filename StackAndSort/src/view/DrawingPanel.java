package view;

import models.*;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel implements MouseListener{
	
	public int mx;
	public int my;
	Point startLine;
	static int obj = 0;
	public static ArrayList<Shape> shapeArrayList = new ArrayList<Shape>();
	
	public DrawingPanel() {
		addMouseListener(this);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape shape : shapeArrayList) {
			shape.AreaPainter(g);
			shape.draw(g);
		}
		repaint();
	}
	
	public void deleteSelectedShapes() {
		ArrayList<Shape> shapesToRemove = new ArrayList<Shape>();
		for(Shape shape : shapeArrayList) {
			if(shape.isSelected()) {
				shapesToRemove.add(shape);
			}
		}
		shapeArrayList.removeAll(shapesToRemove);
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		mx=e.getX();
		my=e.getY();
		
		switch(obj) {
		case 1:
			Point p = new Point(mx, my, false);
			p.setOutline(DrawingForm.outline);
			shapeArrayList.add(p);
			System.out.print(shapeArrayList);
			break;
		case 2:
			if (startLine == null) {
				startLine = new Point (mx,my,false);
				}
				else {
					Point endLine = new Point(mx,my,false);
					Line line = new Line(startLine,endLine,false);
					line.setOutline(DrawingForm.outline);
					shapeArrayList.add(line);
					System.out.print(shapeArrayList);
					startLine=null;
				}
			break;
		case 3:
			RectangleDialog rectangleDialog = new RectangleDialog();
			rectangleDialog.getFieldXCoord().setText(String.valueOf(mx));
			rectangleDialog.getFieldXCoord().setEditable(false);
			rectangleDialog.getFieldYCoord().setText(String.valueOf(my));
			rectangleDialog.getFieldYCoord().setEditable(false);
			rectangleDialog.setVisible(true);
			if(rectangleDialog.isOk) {
				Rectangle r = new Rectangle(new Point(mx,my),
						Integer.parseInt(rectangleDialog.getTxtWidth().getText()),
						Integer.parseInt(rectangleDialog.getTxtHeight().getText()),
						false);
				r.setOutline(DrawingForm.outline);
				r.setFill(DrawingForm.area);
				System.out.println(r);
				shapeArrayList.add(r);
			}
			break;
		case 4:
			CircleDialog circleDialog = new CircleDialog();
			circleDialog.getFieldXCoord().setText(String.valueOf(mx));
			circleDialog.getFieldYCoord().setText(String.valueOf(my));
			circleDialog.getFieldXCoord().setEditable(false);
			circleDialog.getFieldYCoord().setEditable(false);
			circleDialog.setVisible(true);{
				Circle c = new Circle(new Point(mx,my),
						Integer.parseInt(circleDialog.getFieldRadius().getText()),false);
				System.out.println(c);
				c.setOutline(DrawingForm.outline);
				c.setFill(DrawingForm.area);
				shapeArrayList.add(c);
			}
			break;
		case 5:
			DonutDialog donutDialog = new DonutDialog();
			donutDialog.getFieldXCoord().setText(String.valueOf(mx));
			donutDialog.getFieldYCoord().setText(String.valueOf(my));
			donutDialog.getFieldXCoord().setEditable(false);
			donutDialog.getFieldYCoord().setEditable(false);
			donutDialog.setVisible(true);
			{
				Donut d = new Donut(new Point(mx,my),
						Integer.parseInt(donutDialog.getFieldRadius().getText()),
						Integer.parseInt(donutDialog.getFieldInnerRadius().getText()),false);
				System.out.println(d);
				d.setOutline(DrawingForm.outline);
				d.setFill(DrawingForm.area);
				shapeArrayList.add(d);
			}
			break;
		case 6:
			boolean match = false;
			Collections.reverse(shapeArrayList);
			for(Shape shape : shapeArrayList) {
				shape.setSelected(false);
				if(!match) {
					if(shape.contains(mx, my)) {
						shape.setSelected(true);
						match = true;
					}
				}
			}
			Collections.reverse(shapeArrayList);
			break;		
			}
		}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
