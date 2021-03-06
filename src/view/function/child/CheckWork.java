package view.function.child;

import controller.PerControl;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by lzl on 15-6-2.
 */
public class CheckWork extends JFrame {
    public CheckWork(){
        this.setSize(270,500);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("src/childwork.png");
        JLabel titleLabel = new JLabel(icon);

        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(15,1));
        ArrayList<String> info = PerControl.check("办公类");
        for(String per : info){
            pan.add(new JButton(per));
        }
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(pan, BorderLayout.CENTER);
        this.setVisible(true);
    }
}
