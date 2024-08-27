package view;

import models.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawingForm extends JFrame {

	private JPanel contentPane;
	private DrawingPanel drawingPanel = new DrawingPanel();
	static Color outline = Color.BLACK;
	static Color area = Color.WHITE;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawingForm frame = new DrawingForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DrawingForm() {
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		drawingPanel.setBackground(new Color(255, 255, 255));
		drawingPanel.setBorder(null);
		
		
		JPanel PnlButton = new JPanel();
		PnlButton.setBackground(new Color(192, 192, 192));
		
		JButton btnPoint = new JButton("Point");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.obj = 1;
				
				for(Shape shape : DrawingPanel.shapeArrayList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.obj = 2;
				for(Shape shape : DrawingPanel.shapeArrayList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.obj = 3;
				for(Shape shape : DrawingPanel.shapeArrayList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.obj = 4;
				for(Shape shape : DrawingPanel.shapeArrayList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnDonut = new JButton("Donut");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrawingPanel.obj = 5;
				for(Shape shape : DrawingPanel.shapeArrayList) {
					shape.setSelected(false);
				}
			}
		});
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(DrawingPanel.shapeArrayList.isEmpty()) {
				JOptionPane.showMessageDialog(null,"Please Select Something","information",JOptionPane.INFORMATION_MESSAGE);
				return;
			}else {
				DrawingPanel.obj = 6;
			}
			}
		});

		JButton btnDelete = getjButton();


		GroupLayout gl_PnlButton = new GroupLayout(PnlButton);
		gl_PnlButton.setHorizontalGroup(
			gl_PnlButton.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_PnlButton.createSequentialGroup()
					.addContainerGap(50, Short.MAX_VALUE)
					.addGroup(gl_PnlButton.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSelect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDonut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCircle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnRectangle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLine, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPoint, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(29))
		);
		gl_PnlButton.setVerticalGroup(
			gl_PnlButton.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlButton.createSequentialGroup()
					.addGap(79)
					.addComponent(btnPoint)
					.addGap(18)
					.addComponent(btnLine)
					.addGap(18)
					.addComponent(btnRectangle)
					.addGap(18)
					.addComponent(btnCircle)
					.addGap(18)
					.addComponent(btnDonut)
					.addGap(18)
					.addComponent(btnSelect)
					.addGap(18)
					.addComponent(btnDelete)
					.addGap(18)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		PnlButton.setLayout(gl_PnlButton);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(drawingPanel);
		GroupLayout gl_pnlDrawing = new GroupLayout(drawingPanel);
		gl_pnlDrawing.setHorizontalGroup(
			gl_pnlDrawing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
		);
		gl_pnlDrawing.setVerticalGroup(
			gl_pnlDrawing.createParallelGroup(Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
		);
		drawingPanel.setLayout(gl_pnlDrawing);
		contentPane.add(PnlButton, BorderLayout.EAST);
	}

	private static JButton getjButton() {
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(DrawingPanel.shapeArrayList.isEmpty()) {
				JOptionPane.showMessageDialog(null,"Please select what do you want to delete","Error",JOptionPane.ERROR_MESSAGE);
				return;
				}
				for(Shape shape : DrawingPanel.shapeArrayList) {
					if(shape.isSelected()) {
						int ans = JOptionPane.showConfirmDialog(null,"Are u sure?","Warning",JOptionPane.YES_NO_OPTION);
						if(ans==0) {
							DrawingPanel.shapeArrayList.remove(shape);
						}
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Please select object","Error",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		return btnDelete;
	}
}
