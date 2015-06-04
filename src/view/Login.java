package view;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by lzl on 2015/5/22.
 */
public class Login extends JFrame implements ActionListener, KeyListener {
	JTextField userField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	public Login(){
        this.setSize(253,220);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon title = new ImageIcon("src/title.png");//标题
        JLabel titleLabel = new JLabel(title);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3,1));
        
        JPanel userPanel = new JPanel();
        JLabel userLabel = new JLabel("用户名");
        
        userPanel.setLayout(new GridLayout(1,2));
        userPanel.add(userLabel);
        userPanel.add(userField);
        JPanel passPanel = new JPanel();
        JLabel passLabel = new JLabel("密码");
        
        passPanel.setLayout(new GridLayout(1,2));
        passPanel.add(passLabel);
        passPanel.add(passwordField);
        inputPanel.add(userPanel);
        inputPanel.add(passPanel);
        
        JPanel loginPanel = new JPanel();//下半部分
        JButton regButton = new JButton("注册");
        JButton loginButton = new JButton("登录");
        JButton cancelButton = new JButton("退出");
        regButton.addActionListener(this);
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);
        loginPanel.setLayout(new FlowLayout());
        loginPanel.add(regButton);
        loginPanel.add(loginButton);
        loginPanel.add(cancelButton);
        
        inputPanel.add(loginPanel);
        
        userField.addKeyListener(this);//监听键盘
        passwordField.addKeyListener(this);
        
        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
    public static void main(String[] args){
        new Login();
    }
    
    private void test(){
    	String user = userField.getText().toString();
		String pass = passwordField.getText().toString();
		boolean flag = false;//验证是否成功
		try{
			File f = new File("src/usertable.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while(br.ready()){
				String test = br.readLine();
				String u = test.split("&")[0];
				String p = test.split("&")[1];
				if(user.equals(u) && pass.equals(p)){
					flag = true;
					new Main();
					this.setVisible(false);
				}
			}
		}catch(Exception e1){
			
		}
		if(!flag){
			JOptionPane.showMessageDialog(null, "用户名或密码错误");
		}
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("登录")){
			test();
		}
		if(e.getActionCommand().equals("退出")){
			dispose();
		}
		if(e.getActionCommand().equals("注册")){
			new Reg();
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
