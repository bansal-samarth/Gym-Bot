package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class selectExercise extends JFrame implements ActionListener {
    JLabel titleLabel;
    JButton Upper_Body, Lower_Body;

    public selectExercise() {
        setTitle("Choose Exercise");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(400, 300);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);

        titleLabel = new JLabel("Select One");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 40));
        titleLabel.setForeground(Color.MAGENTA);
        titleLabel.setBounds(100, 30, 400, 30);
        add(titleLabel);

        Upper_Body = new JButton("Upper Body");
        Upper_Body.setBounds(90, 110, 200, 40);
        Upper_Body.setFont(new Font("Serif", Font.BOLD,30));
        Upper_Body.setForeground(Color.RED);
        Upper_Body.addActionListener(this);

        Lower_Body = new JButton("Lower Body");
        Lower_Body.setBounds(90, 160, 200, 40);
        Lower_Body.setFont(new Font("Serif", Font.BOLD,30));
        Lower_Body.setForeground(Color.BLUE);
        Lower_Body.addActionListener(this);

        add(Upper_Body);
        add(Lower_Body);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Upper_Body) {
            JOptionPane.showMessageDialog(this,"Your Upper Body Training will start now");
            dispose();
            new upperBody();

        } else if (e.getSource() == Lower_Body) {
            JOptionPane.showMessageDialog(this,"Your Lower Body Training will start now");
            dispose();
            new lowerBody();
        }
    }

    public static void main(String[] args) {
        new selectExercise();
    }
    }

