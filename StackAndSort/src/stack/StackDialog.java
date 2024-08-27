package stack;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackDialog extends JDialog {

	private final JPanel CentarPanel = new JPanel();
	private JTextField fieldHeight;
	private JTextField fieldWidth;
	private JPanel ButtonPanel;
	private JButton okButton;
	public JTextField getFieldHeight() {
		return fieldHeight;
	}

	public void setFieldHeight(JTextField fieldHeight) {
		this.fieldHeight = fieldHeight;
	}

	public JTextField getFieldWidth() {
		return fieldWidth;
	}

	public void setFieldWidth(JTextField fieldWidth) {
		this.fieldWidth = fieldWidth;
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

	private JButton cancelButton;
	private JTextField fieldYCoord;
	private JTextField fieldXCoord;
	private JTextPane txtPaneXCoord;
	private JTextPane txtPaneYCoord;
	private JTextPane txtPaneWidth;
	private JTextPane txtPaneHeighth;
	public boolean isOk;
	private boolean delete;

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public static void main(String[] args) {
		try {
			StackDialog dialog = new StackDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StackDialog() {
		setModal(true);
		setBounds(100, 100, 338, 300);
		CentarPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		{
			ButtonPanel = new JPanel();
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(fieldXCoord.getText().trim().isEmpty() || fieldYCoord.getText().trim().isEmpty() || fieldWidth.getText().trim().isEmpty() ||
								fieldHeight.getText().trim().isEmpty()) {
							isOk = false;
							getToolkit().beep();
							JOptionPane.showMessageDialog(null,"Fill in all empty fields","Error",JOptionPane.ERROR_MESSAGE);
						}
						else {
							isOk = true;
							setDelete(true);
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
						setDelete(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
		}
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(CentarPanel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(ButtonPanel, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addComponent(CentarPanel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(ButtonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_ButtonPnl = new GroupLayout(ButtonPanel);
		gl_ButtonPnl.setHorizontalGroup(
			gl_ButtonPnl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ButtonPnl.createSequentialGroup()
					.addGap(164)
					.addComponent(okButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cancelButton)
					.addGap(148))
		);
		gl_ButtonPnl.setVerticalGroup(
			gl_ButtonPnl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ButtonPnl.createSequentialGroup()
					.addGroup(gl_ButtonPnl.createParallelGroup(Alignment.BASELINE)
						.addComponent(okButton)
						.addComponent(cancelButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		ButtonPanel.setLayout(gl_ButtonPnl);
		{
			fieldWidth = new JTextField();
			fieldWidth.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
				}
				}
			});
			fieldWidth.setHorizontalAlignment(SwingConstants.TRAILING);
			fieldWidth.setColumns(10);
		}
		{
			fieldHeight = new JTextField();
			fieldHeight.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(((c>='0')&& (c<='9')) || (c== KeyEvent.VK_BACK_SPACE))) {
						e.consume();
						getToolkit().beep();
				}
				}
			});
			fieldHeight.setColumns(10);
		}
		
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
		txtPaneXCoord = new JTextPane();
		txtPaneXCoord.setText("X coordinates");
		txtPaneYCoord = new JTextPane();
		txtPaneYCoord.setText("Y coordinates");
		txtPaneWidth = new JTextPane();
		txtPaneWidth.setText("Width");
		txtPaneHeighth = new JTextPane();
		txtPaneHeighth.setText("Height");
		GroupLayout gl_CenterPnl = new GroupLayout(CentarPanel);
		gl_CenterPnl.setHorizontalGroup(
			gl_CenterPnl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CenterPnl.createSequentialGroup()
					.addGroup(gl_CenterPnl.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPaneXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPaneYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPaneWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPaneHeighth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_CenterPnl.createParallelGroup(Alignment.LEADING)
						.addComponent(fieldWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fieldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36))
		);
		gl_CenterPnl.setVerticalGroup(
			gl_CenterPnl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_CenterPnl.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_CenterPnl.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_CenterPnl.createSequentialGroup()
							.addComponent(txtPaneXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtPaneYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtPaneWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtPaneHeighth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_CenterPnl.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(fieldXCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(fieldYCoord, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(fieldWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(fieldHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(75, Short.MAX_VALUE))
		);
		CentarPanel.setLayout(gl_CenterPnl);
		getContentPane().setLayout(groupLayout);
	}
}
