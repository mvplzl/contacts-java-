package view;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.ReadData;
import view.function.Add;
import view.function.Alter;
import view.function.Check;
import view.function.Delete;
import view.function.Dial;
import view.function.Set;


public class Main extends JFrame implements MouseListener {
	JLabel checkLabel;
	JLabel addLabel;
	JLabel dialLabel;
	JLabel alterLabel;
	JLabel deleteLabel;
	JLabel setLabel;
	public Main(){
		this.setSize(230,340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		new ReadData();//初始化数据，从文件中读取存储的数据写入到链表
		ImageIcon checkIcon = new ImageIcon("src/check.png");
		checkLabel = new JLabel(checkIcon);
		checkLabel.addMouseListener(this);
		ImageIcon addIcon = new ImageIcon("src/add.png");
		addLabel = new JLabel(addIcon);
		addLabel.addMouseListener(this);
		ImageIcon dialIcon = new ImageIcon("src/dial.png");
		dialLabel = new JLabel(dialIcon);
		dialLabel.addMouseListener(this);
		ImageIcon alterIcon = new ImageIcon("src/alter.png");
		alterLabel = new JLabel(alterIcon);
		alterLabel.addMouseListener(this);
		ImageIcon deleteIcon = new ImageIcon("src/delete.png");
		deleteLabel = new JLabel(deleteIcon);
		deleteLabel.addMouseListener(this);
		ImageIcon setIcon = new ImageIcon("src/set.png");
		setLabel = new JLabel(setIcon);
		setLabel.addMouseListener(this);
		this.setLayout(new GridLayout(3,2));
		this.add(checkLabel);
		this.add(addLabel);
		this.add(dialLabel);
		this.add(alterLabel);
		this.add(deleteLabel);
		this.add(setLabel);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent().equals(checkLabel)){
			new Check();
		}
		if(e.getComponent().equals(addLabel)){
			new Add();
		}
		if(e.getComponent().equals(dialLabel)){
			new Dial();
		}
		if(e.getComponent().equals(alterLabel)){
			new Alter();
		}
		if(e.getComponent().equals(deleteLabel)){
			new Delete();
		}
		if(e.getComponent().equals(setLabel)){
			new Set();
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
