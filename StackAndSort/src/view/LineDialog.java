package view;

import models.Line;
import models.Point;
import models.Shape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField fieldXStart;
	private JTextField fieldYStart;
	private JTextField fieldXEnd;
	private JTextField fieldYEnd;
	public boolean isOk;
	private final Color outline = Color.black;
	private boolean outlineBool;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			LineDialog dialog = new LineDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
	}

	public JTextField getFieldXStart() {
		return fieldXStart;
	}

	public void setFieldXStart(JTextField fieldXStart) {
		this.fieldXStart = fieldXStart;
	}

	public JTextField getFieldYStart() {
		return fieldYStart;
	}

	public void setFieldYStart(JTextField fieldYStart) {
		this.fieldYStart = fieldYStart;
	}

	public JTextField getFieldXEnd() {
		return fieldXEnd;
	}

	public void setFieldXEnd(JTextField fieldXEnd) {
		this.fieldXEnd = fieldXEnd;
	}

	public JTextField getFieldYEnd() {
		return fieldYEnd;
	}

	public void setFieldYEnd(JTextField fieldYEnd) {
		this.fieldYEnd = fieldYEnd;
	}

	/**
	 * Create the dialog.
	 */
	public LineDialog() {
		setModal(true);
		setBounds(100, 100, 284, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel PnlCenter = new JPanel();
			getContentPane().add(PnlCenter, BorderLayout.CENTER);
			{
				fieldXStart = new JTextField();
				fieldXStart.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent e) {
						char c = e.getKeyChar();
						if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
							e.consume();
							getToolkit().beep();
						}
					}
				});
				fieldXStart.setColumns(10);
			}
			fieldYStart = new JTextField();
			fieldYStart.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			fieldYStart.setColumns(10);
			fieldXEnd = new JTextField();
			fieldXEnd.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			fieldXEnd.setColumns(10);
			fieldYEnd = new JTextField();
			fieldYEnd.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
					}
				}
			});
			fieldYEnd.setColumns(10);
			JLabel lblXStart = new JLabel("X start");
			JLabel lblYStart = new JLabel("Y start");
			JLabel lblXEnd = new JLabel("X end");
			JLabel lblYEnd = new JLabel("Y end");

			GroupLayout gl_PnlCenter = new GroupLayout(PnlCenter);
			gl_PnlCenter.setHorizontalGroup(
				gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_PnlCenter.createSequentialGroup()
						.addGap(33)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_PnlCenter.createSequentialGroup()
								.addComponent(lblXStart)
								.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
								.addComponent(fieldXStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_PnlCenter.createSequentialGroup()
								.addComponent(lblXEnd)
								.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
								.addComponent(fieldXEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_PnlCenter.createSequentialGroup()
								.addComponent(lblYStart)
								.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
								.addComponent(fieldYStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_PnlCenter.createSequentialGroup()
								.addComponent(lblYEnd)
								.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)))
						.addGap(33))
			);
			gl_PnlCenter.setVerticalGroup(
				gl_PnlCenter.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_PnlCenter.createSequentialGroup()
						.addGap(32)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(fieldXStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXStart))
						.addGap(18)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(fieldYStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblYStart))
						.addGap(18)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(fieldXEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblXEnd))
						.addGap(18)
						.addGroup(gl_PnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(fieldYEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblYEnd))
						.addContainerGap(62, Short.MAX_VALUE))
			);
			PnlCenter.setLayout(gl_PnlCenter);
		}
		{
			JPanel PnlButton = new JPanel();
			PnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(PnlButton, BorderLayout.SOUTH);
			{
				JButton okButton = getjButton();
				PnlButton.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				PnlButton.add(cancelButton);
			}
		}
	}

	private JButton getjButton() {
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fieldXStart.getText().trim().isEmpty() || fieldYStart.getText().trim().isEmpty() || fieldXEnd.getText().trim().isEmpty() || fieldYEnd.getText().trim().isEmpty()) {
					isOk = false;
					getToolkit().beep();
					JOptionPane.showMessageDialog(null,"Fill in all empty fields","Error",JOptionPane.ERROR_MESSAGE);
					dispose();
				}
				else {
					for(Shape shape : DrawingPanel.shapeArrayList) {
						if(shape.isSelected()) {
							((Line)shape).setStart(new Point(
									Integer.parseInt(fieldXStart.getText()),
									Integer.parseInt(fieldYStart.getText())));

							((Line)shape).setStart(new Point(
									Integer.parseInt(fieldXEnd.getText()),
									Integer.parseInt(fieldYEnd.getText())));
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
		return okButton;
	}

}
