package pages;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class viewSchedule extends JFrame implements ActionListener {

    private static final String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
    private static final String[][] workoutPlan = { 
        { "Lower Body"},
        { "Upper Body"},
        { "Lower Body" },
        { "Upper Body"},
        { "Lower Body"},
        { "Upper Body" },
        { "Rest" }
    };
    private static final String[] motivation = {
        "Push yourself, because no one else is going to do it for you.",
        "Don't stop when you're tired. Stop when you're done.",
        "Your only limit is the one you set for yourself."
    };

    private JLabel dayLabel, scheduleLabel, motivationLabel;
    private JComboBox<String> dayComboBox;
    private JButton viewButton, motivationButton,exitButton;
    private JPanel panel;

    public viewSchedule() {
        JFrame frame = new JFrame("Training Advice");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);

        dayLabel = new JLabel("Select day of the week: ");
        dayLabel.setForeground(Color.MAGENTA);
        dayLabel.setFont(new Font("Arial", Font.BOLD, 30));
        scheduleLabel = new JLabel();
        scheduleLabel.setForeground(Color.YELLOW);
        motivationLabel = new JLabel();
        motivationLabel.setForeground(Color.GREEN);

        dayComboBox = new JComboBox<String>(daysOfWeek);

        viewButton = new JButton("View Schedule");
        viewButton.setFont(new Font("Arial", Font.BOLD, 20));
        viewButton.setBackground(Color.BLACK);
        viewButton.setForeground(Color.BLUE);
        viewButton.addActionListener(this);

        motivationButton = new JButton("Get Motivated!");
        motivationButton.setFont(new Font("Arial", Font.BOLD, 20));
        motivationButton.setBackground(Color.BLACK);
        motivationButton.setForeground(Color.GREEN);
        motivationButton.addActionListener(this);

        panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.add(dayLabel);
        panel.add(dayComboBox);
        panel.add(viewButton);
        panel.add(scheduleLabel);
        panel.add(motivationButton);
        panel.add(motivationLabel);
        frame.add(panel);
        
        exitButton = new JButton("EXIT");
        exitButton.setBackground(Color.black);
        exitButton.setForeground(Color.RED);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                }
            }
        );
        panel.add(exitButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            int dayIndex = dayComboBox.getSelectedIndex();
            String day=String.valueOf(dayComboBox.getSelectedItem());
            String schedule = "";
            for (String exercise : workoutPlan[dayIndex]) {
                schedule += exercise + " ";
            }
            scheduleLabel.setText("Your gym schedule for " + daysOfWeek[dayIndex] + " is: " + schedule);
            motivationLabel.setText("");
        } else if (e.getSource() == motivationButton) {
            Random rand = new Random();
            int index = rand.nextInt(motivation.length);
            motivationLabel.setText(motivation[index]);

        } else if (e.getSource() == motivationButton) {
            Random rand = new Random();
            int index = rand.nextInt(motivation.length);
            motivationLabel.setText(motivation[index]);
        }
    }

    public static void main(String[] args) {
        new viewSchedule();
    }
}
