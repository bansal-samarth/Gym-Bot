package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.sound.sampled.*;

public class lowerBody implements ActionListener {
    
    private JFrame frame;
    private JLabel label;
    private JButton startButton;
    
    public lowerBody() {
        frame = new JFrame("Lower Body Workout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.black);
        frame.setLocationRelativeTo(null);

        label = new JLabel("Lower Body workout:");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLUE);
        label.setBounds(35, 50, 400, 30);
        
        startButton = new JButton("Start Workout");
        startButton.setFont(new Font("Arial", Font.PLAIN, 15));
        startButton.setForeground(Color.magenta);
        startButton.setBackground(Color.black);
        startButton.setBounds(110, 100, 150, 30);
        startButton.addActionListener(this);
        
        frame.add(label);
        frame.add(startButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(135, 150, 100, 30);
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.RED);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                }
            }
        );
        frame.add(exitButton);
        
        frame.setSize(380, 250);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
                
                JOptionPane.showMessageDialog(frame,"Starting workout...");
                playAudio("src/pages/lunges.wav");
                JOptionPane.showMessageDialog(frame,"Do 5 Lunges.");
                playAudio("src/pages/break.wav");
                JOptionPane.showMessageDialog(frame,"Take a 30 second break.");
                playAudio("src/pages/squats.wav");
                JOptionPane.showMessageDialog(frame,"Do squats for 30 seconds.");
                playAudio("src/pages/break.wav");
                JOptionPane.showMessageDialog(frame,"Take a 30 second break.");
                playAudio("src/pages/hipbridge.wav");
                JOptionPane.showMessageDialog(frame,"Do 10 Hip-Bridges.");
                playAudio("src/pages/lower.wav");
            
            JOptionPane.showMessageDialog(frame, "Congratulations! You have completed your workout.");
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
                JOptionPane.showMessageDialog(frame, "File does not exist");
                }
           }
           catch(Exception e){
                JOptionPane.showMessageDialog(frame, "File does not exist");
            }
    }
    
    public static void main(String[] args) {
        new lowerBody();
    }
}
