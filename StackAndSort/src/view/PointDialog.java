package view;

import models.Shape;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PointDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField fieldXCoord;
	private JTextField fieldYCoord;
	private JLabel lblXCoord;
	private JButton okButton;
	private JButton cancelButton;
	public boolean isOk;
	private Color outline = Color.black;
	private boolean outlineBool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PointDialog dialog = new PointDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PointDialog() {
		setModal(true); 
		setBounds(100, 100, 286, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel PnlCenter = new JPanel();
			contentPanel.add(PnlCenter);
			{
				lblXCoord = new JLabel("X coordinate");
			}
			{
				fieldXCoord = new JTextField();
				fieldXCoord.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
							e.consume();
							getToolkit().beep();
					}
					}
				});
				fieldXCoord.setColumns(10);
			}
			{
				fieldYCoord = new JTextField();
				fieldYCoord.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
							e.consume();
							getToolkit().beep();
					}
					}
				});
				fieldYCoord.setColumns(10);
			}
			JLabel lblYCoordinate = new JLabel("Y coordinate");

			GroupLayout gl_PnlCenter = new GroupLayout(PnlCenter);
			gl_PnlCenter.setHorizontalGroup(
				gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_PnlCenter.createSequentialGroup()
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_PnlCenter.createSequentialGroup()
								.addGap(25)
								.addGroup(gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_PnlCenter.createSequentialGroup()
										.addComponent(lblYCoordinate)
										.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
										.addComponent(fieldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_PnlCenter.createSequentialGroup()
										.addComponent(lblXCoord)
										.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
										.addComponent(fieldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGap(72))
			);
			gl_PnlCenter.setVerticalGroup(
				gl_PnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlCenter.createSequentialGroup()
						.addGap(27)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(fieldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXCoord))
						.addGap(30)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(fieldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblYCoordinate))

						.addContainerGap(85, Short.MAX_VALUE))
			);
			PnlCenter.setLayout(gl_PnlCenter);
		}
		{
			JPanel PnlButton = new JPanel();
			getContentPane().add(PnlButton, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(fieldXCoord.getText().trim().isEmpty() || fieldYCoord.getText().trim().isEmpty()) {
							getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Fill in all empty fields","Error",JOptionPane.ERROR_MESSAGE);
							dispose();
						}
						else {
							for(Shape shape : DrawingPanel.shapeArrayList) {
								if(shape.isSelected()) {
									shape.move(Integer.parseInt(fieldXCoord.getText()),
											Integer.parseInt(fieldYCoord.getText()));
									if(outlineBool) {
										shape.setOutline(outline);
										outlineBool=false;
									}
								}
							}
							
						}
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(e -> dispose());
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_PnlButton = new GroupLayout(PnlButton);
			gl_PnlButton.setHorizontalGroup(
				gl_PnlButton.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlButton.createSequentialGroup()
						.addGap(148)
						.addComponent(okButton)
						.addGap(5)
						.addComponent(cancelButton))
			);
			gl_PnlButton.setVerticalGroup(
				gl_PnlButton.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlButton.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_PnlButton.createParallelGroup(Alignment.LEADING)
							.addComponent(okButton)
							.addComponent(cancelButton)))
			);
			PnlButton.setLayout(gl_PnlButton);
		}
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
}
