package pages;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class menu extends Frame {

    public menu() {
        super("Gym-Bot");

        Label label = new Label("Choose an option:");
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.magenta);
        label.setBackground(Color.black);
        label.setAlignment(Label.CENTER);
        add(label, BorderLayout.NORTH);

        Panel panel = new Panel(new GridLayout(3, 3));
        panel.setPreferredSize(new Dimension(300, 150));
        panel.setBackground(Color.black);

        JButton startButton = new JButton("Start workout");
        startButton.setFont(new Font("Arial", Font.PLAIN, 30));
        startButton.setForeground(Color.CYAN);
        startButton.setBackground(Color.black);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new selectExercise();
            }
        });
        panel.add(startButton);

        JButton adviceButton = new JButton("Training advice");
        adviceButton.setBackground(Color.black);
        adviceButton.setForeground(Color.green);
        adviceButton.setFont(new Font("Arial", Font.PLAIN, 30));
        adviceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new trainingAdvice();
            }
        });
        panel.add(adviceButton);

        JButton updateButton = new JButton("Update schedule");
        updateButton.setBackground(Color.black);
        updateButton.setForeground(Color.yellow);
        updateButton.setFont(new Font("Arial", Font.PLAIN, 30));
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new updateSchedule();
            }
        });
        panel.add(updateButton);

        JButton viewButton = new JButton("View schedule");
        viewButton.setBackground(Color.black);
        viewButton.setForeground(Color.pink); 
        viewButton.setFont(new Font("Arial", Font.PLAIN, 30));
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new viewSchedule();
            }
        });
        panel.add(viewButton);

        JButton alarmButton = new JButton("Set alarm");
        alarmButton.setBackground(Color.black);
        alarmButton.setForeground(Color.blue);
        alarmButton.setFont(new Font("Arial", Font.PLAIN, 30));
        alarmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new setAlarm();
            }
        });
        panel.add(alarmButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBackground(Color.black);
        exitButton.setFont(new Font("Arial", Font.PLAIN, 30));
        exitButton.setForeground(Color.RED);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);

        add(panel, BorderLayout.CENTER);

        setSize(700, 700);
        setVisible(true);
    }

    public static void main(String[] args) {
        new menu();
    }

    
}
