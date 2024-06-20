package pages;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.*;
import javax.swing.*;

public class setAlarm extends JFrame implements ActionListener {
    private JButton setButton;
    private JButton exitButton;
    private JTextField minuteField;

    public setAlarm() {
        setTitle("Rest Alarm Setter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.BLACK);

        JLabel minuteLabel = new JLabel("Enter the number of minutes until the alarm:");
        minuteLabel.setFont(new Font("Arial", Font.BOLD, 20));
        minuteLabel.setForeground(Color.ORANGE);
        minuteLabel.setBackground(Color.BLACK);
        add(minuteLabel);

        minuteField = new JTextField(10);
        minuteField.setFont(new Font("Arial", Font.BOLD, 16));
        add(minuteField);

        setButton = new JButton("Set Alarm");
        setButton.setFont(new Font("Arial", Font.BOLD, 18));
        setButton.setForeground(Color.MAGENTA);
        setButton.setBackground(Color.BLACK);
        setButton.addActionListener(this);
        add(setButton);
        
        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 18));
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.RED);
        exitButton.addActionListener(this);
        add(exitButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == setButton) {
            int minutes = Integer.parseInt(minuteField.getText());

            try {
                Thread.sleep(minutes * 60 * 1000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(this, "Alarm interrupted.");
                return;
            }

            playAudio("src/pages/alarm.wav");
            JOptionPane.showMessageDialog(this, "ALARM!");
        } else if (e.getSource() == exitButton) {
            dispose();
        }
    }

    private void playAudio(String filename) {
       try{
        File musicPath = new File(filename);
        if(musicPath.exists()){
            AudioInputStream audioInput =AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        }
        else{
            JOptionPane.showMessageDialog(this, "File does not exist");
            }
       }
       catch(Exception e){
        JOptionPane.showMessageDialog(this, "File does not exist");
        }
        
    }

    public static void main(String[] args) {
        new setAlarm();
    }
}
