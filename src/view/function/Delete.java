package view.function;

import controller.PerControl;
import dao.WriteData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Delete extends JFrame implements ActionListener {
	public Delete(){
		this.setSize(270, 500);
		this.setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("src/fundelete.png");
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
		PerControl.delete(e);
		new WriteData();
		JOptionPane.showMessageDialog(null, "删除成功！");
		this.setVisible(false);
		new Delete();
	}
}
