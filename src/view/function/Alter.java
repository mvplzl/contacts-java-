package view.function;

import controller.PerControl;
import model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Alter extends JFrame implements ActionListener {

	public Alter() {
		this.setSize(270, 500);
		this.setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("src/funalter.png");
		JLabel titleLabel = new JLabel(icon);

		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(15, 1));
		ArrayList<String> info = PerControl.dial();
		for(String per : info){
			JButton btn = new JButton(per);
			btn.addActionListener(this);
			pan.add(btn);
		}
		this.add(titleLabel, BorderLayout.NORTH);
		this.add(pan, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PerControl.childAlter(e);
	}
}
