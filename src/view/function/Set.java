package view.function;


import javax.swing.*;
import java.awt.*;

public class Set extends JFrame{
	public Set() {
		this.setSize(352, 268);
		this.setLocationRelativeTo(null);
		ImageIcon icon = new ImageIcon("src/funset.png");
		JLabel titleLabel = new JLabel(icon);

        ImageIcon back = new ImageIcon("src/setback.png");
		JLabel backLabel = new JLabel(back);

        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(backLabel, BorderLayout.CENTER);
		this.setVisible(true);
	}

}
