package sort;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Point;
import models.Rectangle;
import stack.StackDialog;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class SortForm extends JFrame {

	private JPanel contentPane;
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	ArrayList<Rectangle> rectangleArrayList = new ArrayList<>();
	Stack<Rectangle> stack = new Stack<Rectangle>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					SortForm frame = new SortForm();
					frame.setVisible(true);
			}
		});
	}

	public SortForm() {
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
		);
		
		JList list = new JList();
		list.setModel(listModel);
		scrollPane.setViewportView(list);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JPanel pnlDown = new JPanel();

		JButton addBtn = getAddButton();

		JButton btnNewButton_1 = getRemoveButton();
		GroupLayout glPnlDown = new GroupLayout(pnlDown);
		glPnlDown.setHorizontalGroup(
			glPnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(glPnlDown.createSequentialGroup()
					.addGap(65)
					.addComponent(addBtn)
					.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(70))
		);
		glPnlDown.setVerticalGroup(
			glPnlDown.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, glPnlDown.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(glPnlDown.createParallelGroup(Alignment.BASELINE)
						.addComponent(addBtn)
						.addComponent(btnNewButton_1)))
		);

		pnlDown.setLayout(glPnlDown);
		GroupLayout glContentPane = new GroupLayout(contentPane);
		glContentPane.setHorizontalGroup(
			glContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(glContentPane.createSequentialGroup()
					.addGroup(glContentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(pnlDown, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnlCenter, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		glContentPane.setVerticalGroup(
			glContentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(glContentPane.createSequentialGroup()
					.addComponent(pnlCenter, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlDown, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(glContentPane);
	}

	private JButton getRemoveButton() {
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listModel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please, select something to remove", "Error",
					JOptionPane.ERROR_MESSAGE);
					getToolkit().beep();
				}
				StackDialog deleteStackDialog = new StackDialog();
				String[] split = listModel.firstElement().split(" ");
				deleteStackDialog.getFieldXCoord().setText(split[1]);
				deleteStackDialog.getFieldYCoord().setText(split[4]);
				deleteStackDialog.getFieldWidth().setText(split[7]);
				deleteStackDialog.getFieldHeight().setText(split[10]);
				deleteStackDialog.getFieldXCoord().setEditable(false);
				deleteStackDialog.getFieldYCoord().setEditable(false);
				deleteStackDialog.getFieldWidth().setEditable(false);
				deleteStackDialog.getFieldHeight().setEditable(false);
				deleteStackDialog.setVisible(true);

				if(deleteStackDialog.isDelete()) {
				//	rectangleArrayList.removeFirst();
					listModel.removeElementAt(0);
				}
			}
		});
		return btnNewButton_1;
	}

	private JButton getAddButton() {
		JButton addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 {
					 StackDialog stackDialog = new StackDialog();
						stackDialog.setVisible(true);
						if(stackDialog.isOk) {
							Rectangle rec = new Rectangle(new Point
							(Integer.parseInt(stackDialog.getFieldXCoord().getText()),
							(Integer.parseInt(stackDialog.getFieldYCoord().getText()))),
							(Integer.parseInt(stackDialog.getFieldWidth().getText())),
							(Integer.parseInt(stackDialog.getFieldHeight().getText())));
							rectangleArrayList.add(rec);
							Collections.sort(rectangleArrayList);
							listModel.add(rectangleArrayList.indexOf(rec),"X: " + rec.getUpperLeft().getX() + " , Y: " + rec.getUpperLeft().getY() + " , Width: "
							+ rec.getWidth() + " , Height: " + rec.getHeight());
							System.out.println(stack);
						}
				 }
			}
		});
		return addBtn;
	}
}
