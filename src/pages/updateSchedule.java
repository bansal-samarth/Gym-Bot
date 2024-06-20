package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class updateSchedule {
    private static String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
    private static String[][] workoutPlan = { 
        { "Lower Body"},
        { "Upper Body"},
        { "Lower Body" },
        { "Upper Body"},
        { "Lower Body"},
        { "Upper Body" },
        { "Rest" }
    };
    
    updateSchedule(){
        JFrame frame = new JFrame("Schedule Manager");
        frame.setSize(600, 200);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.black);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(new FlowLayout());
        
        JLabel dayLabel = new JLabel("Select a day of the week:");
        dayLabel.setFont(new Font("Arial", Font.BOLD, 30));
        dayLabel.setForeground(Color.YELLOW);

        JComboBox<String> dayComboBox = new JComboBox<>(daysOfWeek);
        dayComboBox.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel workoutLabel = new JLabel("Select a workout type:");
        workoutLabel.setFont(new Font("Arial", Font.BOLD, 30));
        workoutLabel.setForeground(Color.CYAN);

        JComboBox<String> workoutComboBox = new JComboBox<>(new String[]{"Upper Body", "Lower Body", "Rest"});
        workoutComboBox.setFont(new Font("Arial", Font.BOLD, 20));
        
        JButton updateButton = new JButton("Update Schedule");
        updateButton.setBackground(Color.black);
        updateButton.setForeground(Color.MAGENTA);
        updateButton.setFont(new Font("Arial", Font.BOLD, 25));
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int day = dayComboBox.getSelectedIndex();
                String workoutType = (String) workoutComboBox.getSelectedItem();
                if (workoutType.equalsIgnoreCase("Upper Body")) {
                    workoutPlan[day] = new String[]{"Upper Body"};
                    JOptionPane.showMessageDialog(frame, "Your upper body workout plan for " + daysOfWeek[day] + " has been updated.");
                } else if (workoutType.equalsIgnoreCase("Lower Body")) {
                    workoutPlan[day] = new String[]{"Lower Body"};
                    JOptionPane.showMessageDialog(frame, "Your lower body workout plan for " + daysOfWeek[day] + " has been updated.");
                } else if (workoutType.equalsIgnoreCase("Rest")) {
                    workoutPlan[day] = new String[]{"Rest"};
                    JOptionPane.showMessageDialog(frame, "Your rest day workout plan for " + daysOfWeek[day] + " has been updated.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid workout type, please try again.");
                }
            }
        });
        
        panel.add(dayLabel);
        panel.add(dayComboBox);
        panel.add(workoutLabel);
        panel.add(workoutComboBox);
        panel.add(updateButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.RED);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                }
            }
        );
        panel.add(exitButton);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void main(String[]args){
        new updateSchedule();
    }
}
