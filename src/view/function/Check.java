package view.function;

import view.function.child.CheckBusiness;
import view.function.child.CheckPersonal;
import view.function.child.CheckWork;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Check extends JFrame implements MouseListener {
	JLabel workLabel;
	JLabel personalLabel;
	JLabel businessLabel;
	public Check(){
		this.setSize(430,250);
		this.setLocationRelativeTo(null);
		ImageIcon title = new ImageIcon("src/funcheck.png");
		JLabel titleLabel = new JLabel(title);
		
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(1,3));
		ImageIcon work = new ImageIcon("src/work.png");
		ImageIcon personal = new ImageIcon("src/personal.png");
		ImageIcon business = new ImageIcon("src/business.png");
		workLabel = new JLabel(work);
		personalLabel = new JLabel(personal);
		businessLabel = new JLabel(business);
		workLabel.addMouseListener(this);
		personalLabel.addMouseListener(this);
		businessLabel.addMouseListener(this);
		pan.add(workLabel);
		pan.add(personalLabel);
		pan.add(businessLabel);
		
		this.setLayout(new BorderLayout());
		this.add(titleLabel, BorderLayout.NORTH);
		this.add(pan, BorderLayout.CENTER);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent().equals(workLabel)){
			new CheckWork();
		}
		if(e.getComponent().equals(personalLabel)){
			new CheckPersonal();
		}
		if(e.getComponent().equals(businessLabel)){
			new CheckBusiness();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
