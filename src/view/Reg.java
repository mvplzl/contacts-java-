package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Reg extends JFrame implements ActionListener, KeyListener {
	JTextField nameField = new JTextField();
	JPasswordField passField = new JPasswordField();
	JPasswordField confirmField = new JPasswordField();
	public Reg(){
		this.setSize(270,220);
		this.setLocationRelativeTo(null);
		this.setLayout(new GridLayout(5,1));
		
		ImageIcon icon = new ImageIcon("src/reg.png");
		JLabel titleLabel = new JLabel(icon);
		
		JPanel namePanel = new JPanel();
		JLabel nameLabel = new JLabel("用户名");
		namePanel.setLayout(new GridLayout(1,2));
		namePanel.add(nameLabel);
		namePanel.add(nameField);
		
		JPanel passPanel = new JPanel();
		JLabel passLabel = new JLabel("密码");
		passPanel.setLayout(new GridLayout(1,2));
		passPanel.add(passLabel);
		passPanel.add(passField);
		
		JPanel confirmPanel = new JPanel();
		JLabel confirmLabel = new JLabel("确认密码");
		confirmPanel.setLayout(new GridLayout(1,2));
		confirmPanel.add(confirmLabel);
		confirmPanel.add(confirmField);
		
		JButton btn = new JButton("确定");
		btn.addActionListener(this);
		
		this.add(titleLabel);
		this.add(namePanel);
		this.add(passPanel);
		this.add(confirmPanel);
		this.add(btn);
		
		this.setVisible(true);
	}
	
	public void test(){
		String name = nameField.getText().toString();
		String pass = passField.getText().toString();
		String confirm = confirmField.getText().toString();
		boolean flag = true;//判断输入是否合法
		if(!pass.equals(confirm) && !pass.equals("") && !confirm.equals("")){
			flag = false;
			JOptionPane.showMessageDialog(null, "两次输入密码不一致");
		}
		try{//验证用户名是否被占用
			File f = new File("src/usertable.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while(br.ready()){
				String a = br.readLine();
				String u = a.split("&")[0];
				if(name.equals(u)){
					JOptionPane.showMessageDialog(null, "用户名已存在，可以使用" + name + 100*(int)Math.random());
					flag = false;
					break;
				}
			}
		}catch(Exception e){
			
		}
		if(name.equals("") || pass.equals("") || confirm.equals("")){
			flag = false;
			JOptionPane.showMessageDialog(null, "请将信息填写完整");
		}
		if(flag){
			String info = name + "&" + pass;
			try{
				File f = new File("src/usertable.txt");
				FileWriter fw = new FileWriter(f, true);//追加模式
				PrintWriter pw = new PrintWriter(fw);
				pw.println(info);
				pw.close();
			}catch(Exception e){
				
			}
			this.setVisible(false);
			JOptionPane.showMessageDialog(null, "注册成功");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("确定")){
			test();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 10){
			test();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
