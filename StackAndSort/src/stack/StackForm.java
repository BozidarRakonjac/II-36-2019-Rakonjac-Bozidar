package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Stack;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Point;
import models.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StackForm extends JFrame {
	private JPanel contentPane;
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	Stack<Rectangle> stack = new Stack<Rectangle>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackForm frame = new StackForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StackForm() {
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
		);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList jList = new JList();
		scrollPane.setViewportView(jList);
		jList.setModel(listModel);
		
		JPanel PnlDown = new JPanel();
		contentPane.add(PnlDown, BorderLayout.SOUTH);

		JButton AddBtn = getjButton();

		JButton RemoveBtn = getRemoveBtn();
		GroupLayout gl_PnlDown = new GroupLayout(PnlDown);
		gl_PnlDown.setHorizontalGroup(
			gl_PnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlDown.createSequentialGroup()
					.addGap(35)
					.addComponent(AddBtn)
					.addGap(212)
					.addComponent(RemoveBtn))
		);
		gl_PnlDown.setVerticalGroup(
			gl_PnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlDown.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_PnlDown.createParallelGroup(Alignment.LEADING)
						.addComponent(AddBtn)
						.addComponent(RemoveBtn)))
		);
		PnlDown.setLayout(gl_PnlDown);
	}

	private JButton getRemoveBtn() {
		JButton RemoveBtn = new JButton("Remove");
		RemoveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listModel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nothing to remove", "Error",
					JOptionPane.ERROR_MESSAGE);
					getToolkit().beep();
				}
				StackDialog stackDeleteDialog = new StackDialog();
				String[] split = listModel.firstElement().split(" ");
				stackDeleteDialog.getFieldXCoord().setText(split[1]);
				stackDeleteDialog.getFieldYCoord().setText(split[4]);
				stackDeleteDialog.getFieldWidth().setText(split[7]);
				stackDeleteDialog.getFieldHeight().setText(split[10]);
				stackDeleteDialog.getFieldXCoord().setEditable(false);
				stackDeleteDialog.getFieldYCoord().setEditable(false);
				stackDeleteDialog.getFieldWidth().setEditable(false);
				stackDeleteDialog.getFieldHeight().setEditable(false);
				stackDeleteDialog.setVisible(true);

				if(stackDeleteDialog.isDelete()) {
					stack.pop();
					listModel.removeElementAt(0);
				}
			}
		});
		return RemoveBtn;
	}

	private JButton getjButton() {
		JButton AddBtn = new JButton("Add");
		AddBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StackDialog stackdlg = new StackDialog();
				stackdlg.setVisible(true);
				if(stackdlg.isOk) {
					Rectangle rec = new Rectangle(new Point
					(Integer.parseInt(stackdlg.getFieldXCoord().getText()),
					(Integer.parseInt(stackdlg.getFieldYCoord().getText()))),
					(Integer.parseInt(stackdlg.getFieldWidth().getText())),
					(Integer.parseInt(stackdlg.getFieldHeight().getText())));
					stack.push(rec);
					listModel.add(0,"X: " + rec.getUpperLeft().getX() + " , Y: " + rec.getUpperLeft().getY() + " , Width: "
					+ rec.getWidth() + " , Height: " + rec.getHeight());
					System.out.println(stack);
				}
			}
		});
		return AddBtn;
	}
}
