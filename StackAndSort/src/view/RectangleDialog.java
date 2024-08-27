package view;

import models.Rectangle;
import models.Shape;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RectangleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField fieldYCoord;
	private JTextField fieldXCoord;
	private JTextField txtHeight;
	private JTextField txtWidth;
	private JButton okButton;
	private JButton cancelButton;
	private JPanel PanelCenter;
	public boolean isOk;
	private Color outline = Color.black;
	private Color fill = Color.black;
	private boolean outlineBool;
	private boolean fillBool;
	private JButton btnOutline;
	private JButton btnArea;


	public static void main(String[] args) {
			RectangleDialog dialog = new RectangleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
	}

	public RectangleDialog() {
		setModal(true);
		setBounds(100, 100, 299, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			PanelCenter = new JPanel();
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
				txtHeight = new JTextField();
				txtHeight.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
							e.consume();
							getToolkit().beep();
					}
					}
				});
				txtHeight.setColumns(10);
			}
			{
				txtWidth = new JTextField();
				txtWidth.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
							e.consume();
							getToolkit().beep();
					}
					}
				});
				txtWidth.setColumns(10);
			}
			
			JLabel lblXCoordinate = new JLabel("X coordinate");
			
			JLabel lblYCoordinate = new JLabel("Y coordinate");
			
			JLabel lblHeight = new JLabel("Height");
			
			JLabel lblWidth = new JLabel("Width");

			GroupLayout glPnlCenter = new GroupLayout(PanelCenter);
			glPnlCenter.setHorizontalGroup(
				glPnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(glPnlCenter.createSequentialGroup()
						.addGap(19)
						.addGroup(glPnlCenter.createParallelGroup(Alignment.TRAILING)
							.addGroup(glPnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYCoordinate)
								.addComponent(lblHeight)
								.addComponent(lblWidth)
								.addComponent(lblXCoordinate)))
						.addGroup(glPnlCenter.createParallelGroup(Alignment.LEADING)
							.addGroup(glPnlCenter.createSequentialGroup()
								.addGap(66)
								.addGroup(glPnlCenter.createParallelGroup(Alignment.LEADING)
									.addComponent(fieldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(fieldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(13, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, glPnlCenter.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGap(27))))
			);
			glPnlCenter.setVerticalGroup(
				glPnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(glPnlCenter.createSequentialGroup()
						.addGap(23)
						.addGroup(glPnlCenter.createParallelGroup(Alignment.TRAILING)
							.addComponent(fieldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXCoordinate))
						.addGap(18)
						.addGroup(glPnlCenter.createParallelGroup(Alignment.TRAILING)
							.addComponent(fieldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblYCoordinate))
						.addGap(18)
						.addGroup(glPnlCenter.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblHeight))
						.addGap(18)
						.addGroup(glPnlCenter.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblWidth))
						.addGap(18)
						.addContainerGap(25, Short.MAX_VALUE))
			);
			PanelCenter.setLayout(glPnlCenter);
		}
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(PanelCenter);
		{
			JPanel PnlButton = new JPanel();
			getContentPane().add(PnlButton, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(fieldXCoord.getText().trim().isEmpty() || fieldYCoord.getText().trim().isEmpty() || txtWidth.getText().trim().isEmpty() ||
								txtHeight.getText().trim().isEmpty()) {
							isOk = false;
							getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Fill in all empty fields","Error",JOptionPane.ERROR_MESSAGE);
						}
						else {
							for(Shape shape : DrawingPanel.shapeArrayList) {
								if(shape.isSelected()) {
									shape.move(Integer.parseInt(fieldXCoord.getText()),
									Integer.parseInt(fieldYCoord.getText()));
									
									((Rectangle)shape).setWidth(Integer.parseInt(txtWidth.getText()));
									((Rectangle)shape).setHeight(Integer.parseInt(txtHeight.getText()));
									
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
					}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout glPnlButton = new GroupLayout(PnlButton);
			glPnlButton.setHorizontalGroup(
				glPnlButton.createParallelGroup(Alignment.LEADING)
					.addGroup(glPnlButton.createSequentialGroup()
						.addGap(158)
						.addComponent(okButton)
						.addGap(5)
						.addComponent(cancelButton))
			);
			glPnlButton.setVerticalGroup(
				glPnlButton.createParallelGroup(Alignment.LEADING)
					.addGroup(glPnlButton.createSequentialGroup()
						.addGap(5)
						.addGroup(glPnlButton.createParallelGroup(Alignment.LEADING)
							.addComponent(okButton)
							.addComponent(cancelButton)))
			);
			PnlButton.setLayout(glPnlButton);
		}
	}

	public JTextField getFieldYCoord() {
		return fieldYCoord;
	}

	public void setFieldYCoord(JTextField fieldYCoord) {
		this.fieldYCoord = fieldYCoord;
	}

	public JTextField getFieldXCoord() {
		return fieldXCoord;
	}

	public void setFieldXCoord(JTextField fieldXCoord) {
		this.fieldXCoord = fieldXCoord;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}
}
