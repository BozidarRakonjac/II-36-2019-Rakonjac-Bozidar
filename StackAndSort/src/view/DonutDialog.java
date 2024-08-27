package view;

import models.Donut;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DonutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JTextField fieldXCoord;
	private JTextField fieldYCoord;
	private JTextField fieldRadius;
	private JTextField fieldInnerRadius;
	private Color outline = Color.black;
	private Color fill = Color.black;
	public boolean isOk;
	private boolean outlineBool;
	private boolean fillBool;
	
	public static void main(String[] args) {
		try {
			DonutDialog dialog = new DonutDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/**
	 * Create the dialog.
	 */
	public DonutDialog() {
		setModal(true);
		setBounds(100, 100, 273, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			panel = new JPanel();
		}
		fieldXCoord = new JTextField();
		fieldXCoord.setColumns(10);
		fieldYCoord = new JTextField();
		fieldYCoord.setColumns(10);
		fieldRadius = new JTextField();
		fieldRadius.setColumns(10);
		fieldInnerRadius = new JTextField();
		fieldInnerRadius.setColumns(10);
		JLabel lblXCoord = new JLabel("X coordinate");
		JLabel lblYCoord = new JLabel("Y coordinate");
		JLabel lblRadius = new JLabel("Radius");
		JLabel lblnnerRadius = new JLabel("Inner Radius");
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblXCoord)
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
							.addComponent(fieldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblYCoord)
							.addPreferredGap(ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
							.addComponent(fieldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblRadius)
							.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
							.addComponent(fieldRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblnnerRadius)
							.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
							.addComponent(fieldInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblXCoord))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYCoord))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRadius))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(fieldInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblnnerRadius))
					.addGap(18)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = getjButton();
				buttonPane.add(okButton);
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
				buttonPane.add(cancelButton);
			}
		}
	}

	private JButton getjButton() {
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldXCoord.getText().trim().isEmpty() || fieldYCoord.getText().trim().isEmpty() || fieldRadius.getText().trim().isEmpty() || fieldInnerRadius.getText().trim().isEmpty()) {
					isOk = false;
					getToolkit().beep();
					JOptionPane.showMessageDialog(null,"Fill in all empty fields","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(Integer.parseInt(fieldRadius.getText())>
					Integer.parseInt(fieldInnerRadius.getText())) {
						for(Shape shape : DrawingPanel.shapeArrayList) {
							if(shape.isSelected()) {
								shape.move(Integer.parseInt(fieldXCoord.getText()),
									Integer.parseInt(fieldYCoord.getText()));

								((Donut)shape).setRadius(Integer.parseInt(fieldRadius.getText()));
								((Donut)shape).setInnerRadius(Integer.parseInt(fieldInnerRadius.getText()));
								if(outlineBool) {
									shape.setOutline(outline);
									outlineBool=false;
								}
								if(fillBool) {
									shape.setFill(fill);
									fillBool=false;
								}
							}
						}
					isOk = true;
					dispose();

				}
					else {
						isOk=false;
						JOptionPane.showMessageDialog(null, "Inner radius must be smaller than radius","Error",JOptionPane.ERROR_MESSAGE);
					}
			}
			}
		});
		okButton.setActionCommand("OK");
		return okButton;
	}

	public JTextField getFieldXCoord() {
		return fieldXCoord;
	}

	public JTextField getFieldYCoord() {
		return fieldYCoord;
	}
	
	public JTextField getFieldRadius() {
		return fieldRadius;
	}

	public JTextField getFieldInnerRadius() {
		return fieldInnerRadius;
	}


}
