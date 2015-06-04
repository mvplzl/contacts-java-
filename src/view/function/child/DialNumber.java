package view.function.child;


import javax.swing.*;
import java.awt.*;

/**
 * Created by lzl on 15-6-4.
 */
public class DialNumber extends JFrame implements Runnable {
    int x = 0;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(x,160,150,30);
    }

    public DialNumber(String info){
        this.setSize(270,200);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("src/fundial.png");
        JLabel titleLabel = new JLabel(icon);

        String name = info.split("#")[0];
        String number = info.split("#")[1];

        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(2,1));
        pan.setBackground(Color.WHITE);
        JLabel labName = new JLabel("     正在拨打" + name + "...");
        JLabel labNumber = new JLabel("     "+number);
        pan.add(labName);
        pan.add(labNumber);

        Thread t = new Thread(this);
        t.start();

        this.add(titleLabel, BorderLayout.NORTH);
        this.add(pan, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void run() {
        while(true){
            x++;
            if(x>150){
                x = 0;
            }
            try{
                Thread.sleep(50);
            }catch (Exception e){

            }
            repaint();
        }
    }
}
