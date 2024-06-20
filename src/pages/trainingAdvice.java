package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class trainingAdvice {
    
    private static ArrayList<String> upperBodyExercises = new ArrayList<String>();
    private static ArrayList<String> lowerBodyExercises = new ArrayList<String>();

    trainingAdvice(){
        
        upperBodyExercises.add("Bench press");
        upperBodyExercises.add("Push-ups");
        upperBodyExercises.add("Dumbbell curls");
        
        lowerBodyExercises.add("Squats");
        lowerBodyExercises.add("Lunges");
        lowerBodyExercises.add("Deadlifts");
        
        JFrame frame = new JFrame("Training Advice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        panel.add(textArea);
        textArea.setBounds(100, 100, 100, 100);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.CYAN);
        textArea.setFont(new Font("Arial", Font.BOLD, 20));
        
        textArea.append("Here's some training advice: \n\n");
        
        textArea.append("Upper Body Workout: \n");
        for (String exercise : upperBodyExercises) {
            textArea.append("- " + exercise + "\n");
        }
        
        textArea.append("\nLower Body Workout: \n");
        for (String exercise : lowerBodyExercises) {
            textArea.append("- " + exercise + "\n");
        }
        
        JButton addUpperButton = new JButton("Add Upper Body Exercise");
        addUpperButton.setBackground(Color.black);
        addUpperButton.setForeground(Color.GREEN);
        addUpperButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exercise = JOptionPane.showInputDialog(frame, "Enter new upper body exercise:");
                upperBodyExercises.add(exercise);
                textArea.setText("");
                textArea.append("Here's some training advice: \n\n");
                textArea.append("Upper Body Workout: \n");
                for (String exerciseu : upperBodyExercises) {
                    textArea.append("- " + exerciseu + "\n");
                }
                textArea.append("\nLower Body Workout: \n");
                for (String exerciset : lowerBodyExercises) {
                    textArea.append("- " + exerciset + "\n");
                }
            }
        });
        panel.add(addUpperButton);
        
        JButton addLowerButton = new JButton("Add Lower Body Exercise");
        addLowerButton.setBackground(Color.black);
        addLowerButton.setForeground(Color.BLUE);
        addLowerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exercise = JOptionPane.showInputDialog(frame, "Enter new lower body exercise:");
                lowerBodyExercises.add(exercise);
                textArea.setText("");
                textArea.append("Here's some training advice: \n\n");
                textArea.append("Upper Body Workout: \n");
                for (String exercisez : upperBodyExercises) {
                    textArea.append("- " + exercisez + "\n");
                }
                textArea.append("\nLower Body Workout: \n");
                for (String exerciseb : lowerBodyExercises) {
                    textArea.append("- " + exerciseb + "\n");
                }
            }
        });
        panel.add(addLowerButton);
        
        JButton removeUpperButton = new JButton("Remove Upper Body Exercise");
        removeUpperButton.setBackground(Color.black);
        removeUpperButton.setForeground(Color.GREEN);
        removeUpperButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exercise = JOptionPane.showInputDialog(frame, "Enter upper body exercise to remove:");
                upperBodyExercises.remove(exercise);
                textArea.setText("");
                textArea.append("Here's some training advice: \n\n");
                textArea.append("Upper Body Workout: \n");
                for (String exercisex: upperBodyExercises) {
                    textArea.append("- " + exercisex + "\n");
                }
                textArea.append("\nLower Body Workout: \n");
                for (String exerciseq : lowerBodyExercises) {
                    textArea.append("- " + exerciseq + "\n");
                }
                }});
                panel.add(removeUpperButton);

                JButton removeLowerButton = new JButton("Remove Lower Body Exercise");
                removeLowerButton.setBackground(Color.black);
                removeLowerButton.setForeground(Color.BLUE);
                removeLowerButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String exercise = JOptionPane.showInputDialog(frame, "Enter lower body exercise to remove:");
                        lowerBodyExercises.remove(exercise);
                        textArea.setText("");
                        textArea.append("Here's some training advice: \n\n");
                        textArea.append("Upper Body Workout: \n");
                        for (String exercisee : upperBodyExercises) {
                            textArea.append("- " + exercisee + "\n");
                        }
                        textArea.append("\nLower Body Workout: \n");
                        for (String exercises : lowerBodyExercises) {
                            textArea.append("- " + exercises + "\n");
                        }
                    }
                });
                panel.add(removeLowerButton);

                Button exitButton = new Button("Exit");
                exitButton.setBackground(Color.black);
                exitButton.setForeground(Color.RED);
                exitButton.setFont(new Font("Arial", Font.BOLD, 20));
                exitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                }
            });
            panel.add(exitButton);
                
                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setVisible(true);
            }
        
            public static void main(String[]args){
                new trainingAdvice();
            } 
        }


