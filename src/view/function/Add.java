package view.function;

import controller.PerControl;
import dao.WriteData;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Add extends JFrame implements ActionListener {
	JTextField nameField = new JTextField();
	JTextField numberField = new JTextField();
	JTextField sortField = new JTextField();
	JTextField emailField = new JTextField();
	public Add(){
		this.setSize(270,270);
		this.setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("src/funadd.png");
		JLabel titleLabel = new JLabel(icon);
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(5,1));
		
		JLabel nameLabel = new JLabel("姓名");
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(1,2));
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		JLabel numberLabel = new JLabel("电话");
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new GridLayout(1,2));
		numberPanel.add(numberLabel);
		numberPanel.add(numberField);
		
		JLabel sortLabel = new JLabel("分类");
		JPanel sortPanel = new JPanel();
		sortPanel.setLayout(new GridLayout(1,2));
		sortPanel.add(sortLabel);
		sortPanel.add(sortField);
		
		JLabel emailLabel = new JLabel("邮件");
		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new GridLayout(1,2));
		emailPanel.add(emailLabel);
		emailPanel.add(emailField);

		pan.add(namePanel);
		pan.add(numberPanel);
		pan.add(sortPanel);
		pan.add(emailPanel);
		
		JButton btn = new JButton("确定");
		btn.addActionListener(this);
		pan.add(btn);
		
		this.setLayout(new BorderLayout());
		this.add(titleLabel, BorderLayout.NORTH);
		this.add(pan, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确定")){
			String name = nameField.getText().toString();
			String number = numberField.getText().toString();
			String sort = sortField.getText().toString();
			String email = emailField.getText().toString();
			switch (PerControl.add(name, number, sort, email)){
				case 1:
					new WriteData();
					JOptionPane.showMessageDialog(null, "增加成功！");
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "存储空间已满，不能再录入新数据！");
					break;
				case 3:
					JOptionPane.showMessageDialog(null, "数据录入重复，录入失败！");
					break;
			}
		}
	}
}
