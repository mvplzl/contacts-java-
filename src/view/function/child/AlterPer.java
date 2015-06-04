package view.function.child;

import controller.PerControl;
import dao.WriteData;
import model.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lzl on 15-6-4.
 */
public class AlterPer extends JFrame implements ActionListener {
    JTextField nameField = new JTextField();
    JTextField numberField = new JTextField();
    JTextField sortField = new JTextField();
    JTextField emailField = new JTextField();
    Person alteredPer;
    public AlterPer(Person per){
        this.setSize(270,270);
        this.setLocationRelativeTo(null);
        alteredPer = per;
        ImageIcon icon = new ImageIcon("src/funalter.png");
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

        JButton btn = new JButton("修改");
        btn.addActionListener(this);
        pan.add(btn);

        nameField.setText(per.getName());
        numberField.setText(per.getNumber());
        sortField.setText(per.getSort());
        emailField.setText(per.getEmail());

        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(pan, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("修改")){
            String name = nameField.getText().toString();
            String number = numberField.getText().toString();
            String sort = sortField.getText().toString();
            String email = emailField.getText().toString();
            PerControl.alter(alteredPer, name, number, sort, email);
            new WriteData();
            JOptionPane.showMessageDialog(null, "修改成功！");
        }
    }
}
