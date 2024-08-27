package view;

import models.Circle;
import models.Shape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CircleDialog extends JDialog {

	private final JPanel mainPanel = new JPanel();
	private JTextField fieldXCoord;
	private JTextField fieldYCoord;
	private JTextField fieldRadius;
	private JPanel colorPanel;
	public boolean confirmation;
	private Color borderColor = Color.black;
	private Color fillColor = Color.black;
	private boolean borderSelected;
	private boolean fillSelected;

	public static void main(String[] args) {
		try {
			CircleDialog dialog = new CircleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CircleDialog() {
		setModal(true);
		setBounds(100, 100, 293, 300);
		getContentPane().setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		{
			colorPanel = new JPanel();
			fieldXCoord = new JTextField();
			fieldXCoord.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			fieldXCoord.setColumns(10);
			fieldYCoord = new JTextField();
			fieldYCoord.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			fieldYCoord.setColumns(10);
			fieldRadius = new JTextField();
			fieldRadius.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if (!(((c >= '0') && (c <= '9')) || (c == KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			fieldRadius.setColumns(10);
			JLabel labelXCoord = new JLabel("X coordinate");
			JLabel labelYCoord = new JLabel("Y coordinate");
			JLabel labelRadius = new JLabel("Radius");

			GroupLayout groupLayout = new GroupLayout(colorPanel);
			groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
													.addGap(35)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(labelXCoord)
															.addComponent(labelYCoord)
															.addComponent(labelRadius))
													.addGap(63)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
															.addComponent(fieldRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
															.addComponent(fieldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
															.addComponent(fieldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									)
									.addContainerGap(23, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(fieldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(labelXCoord))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(fieldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(labelYCoord))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
											.addComponent(fieldRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(labelRadius))
									.addGap(28)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE))
									.addContainerGap(60, Short.MAX_VALUE))
			);
			colorPanel.setLayout(groupLayout);
		}
		mainPanel.setLayout(new BorderLayout(0, 0));
		mainPanel.add(colorPanel);
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			{
				JButton okButton = getjButton();
				buttonPanel.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPanel.add(cancelButton);
			}
		}
	}

	private JButton getjButton() {
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fieldXCoord.getText().trim().isEmpty() || fieldYCoord.getText().trim().isEmpty() || fieldRadius.getText().trim().isEmpty()) {
					confirmation = false;
					getToolkit().beep();
					JOptionPane.showMessageDialog(null, "Fill in all empty fields", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					for (Shape shape : DrawingPanel.shapeArrayList) {
						if (shape.isSelected()) {
							shape.move(Integer.parseInt(fieldXCoord.getText()),
									Integer.parseInt(fieldYCoord.getText()));

							((Circle)shape).setRadius(Integer.parseInt(fieldRadius.getText()));

							if (borderSelected) {
								shape.setOutline(borderColor);
								borderSelected = false;
							}
							if (fillSelected) {
								shape.setFill(fillColor);
								fillSelected = false;
							}
						}
					}
					confirmation = true;
					dispose();
				}
			}
		});
		okButton.setActionCommand("OK");
		return okButton;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public JTextField getFieldXCoord() {
		return fieldXCoord;
	}

	public void setFieldXCoord(JTextField fieldXCoord) {
		this.fieldXCoord = fieldXCoord;
	}

	public JTextField getFieldYCoord() {
		return fieldYCoord;
	}

	public void setFieldYCoord(JTextField fieldYCoord) {
		this.fieldYCoord = fieldYCoord;
	}

	public JTextField getFieldRadius() {
		return fieldRadius;
	}

	public void setFieldRadius(JTextField fieldRadius) {
		this.fieldRadius = fieldRadius;
	}

	public JPanel getColorPanel() {
		return colorPanel;
	}

	public void setColorPanel(JPanel colorPanel) {
		this.colorPanel = colorPanel;
	}

	public boolean isConfirmation() {
		return confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public boolean isBorderSelected() {
		return borderSelected;
	}

	public void setBorderSelected(boolean borderSelected) {
		this.borderSelected = borderSelected;
	}

	public boolean isFillSelected() {
		return fillSelected;
	}

	public void setFillSelected(boolean fillSelected) {
		this.fillSelected = fillSelected;
	}
}
