package pages;
import java.sql.*;
import proj.connected;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class info extends JFrame implements ActionListener {

    JFrame frame=new JFrame(getTitle(), getGraphicsConfiguration());

    JLabel nameLabel, emailNumberLabel, ageLabel, genderLabel,titlelabel,heightLabel,weightLabel,goalLabel;
    JTextField nameTextField, emailTextField, ageTextField,heightTextField,weightTextField;
    JRadioButton mRadioButtons, fRadioButton, meRadioButton, bcaRadioButton;
    JCheckBox verifyCheckBox;
    JButton submitButton;
    JComboBox<String> goalsBox;
    static String gender,goal,name,email;
    static double height,weight,age;

    public info() {

        frame.setTitle("GYMBOT: details");
        frame.setSize(700, 700);
        frame.setLayout(null);

        frame.getContentPane().setBackground(Color.black);

        titlelabel = new JLabel("--------  DETAILS  --------");
        titlelabel.setBounds(150, 30, 500, 30);
        titlelabel.setFont(new Font("Arial", Font.BOLD, 40));
        titlelabel.setForeground(Color.MAGENTA);
        frame.add(titlelabel);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nameLabel.setForeground(Color.GREEN);
        nameLabel.setBounds(200, 90, 100, 30);
        frame.add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(300, 90, 200, 30);
        frame.add(nameTextField);

        emailNumberLabel = new JLabel("E-mail:");
        emailNumberLabel.setFont(new Font("Arial", Font.BOLD, 20));
        emailNumberLabel.setForeground(Color.GREEN);
        emailNumberLabel.setBounds(200, 130, 100, 30);
        frame.add(emailNumberLabel);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 130, 200, 30);
        frame.add(emailTextField);

        ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        ageLabel.setForeground(Color.GREEN);
        ageLabel.setBounds(200, 170, 100, 30);
        frame.add(ageLabel);

        ageTextField = new JTextField();
        ageTextField.setBounds(300, 170, 200, 30);
        frame.add(ageTextField);

        genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 20));
        genderLabel.setForeground(Color.GREEN);
        genderLabel.setBounds(200, 210, 100, 30);
        frame.add(genderLabel);

        mRadioButtons = new JRadioButton("Male");
        mRadioButtons.setFont(new Font("Arial", Font.PLAIN, 18));
        mRadioButtons.setBackground(Color.black);
        mRadioButtons.setForeground(Color.BLUE);
        mRadioButtons.setBounds(300, 210, 70, 30);
        frame.add(mRadioButtons);

        fRadioButton = new JRadioButton("Female");
        fRadioButton.setFont(new Font("Arial", Font.PLAIN, 18));
        fRadioButton.setBackground(Color.black);
        fRadioButton.setForeground(Color.RED);
        fRadioButton.setBounds(370, 210, 100, 30);
        frame.add(fRadioButton);

        heightLabel = new JLabel("Height:");
        heightLabel.setFont(new Font("Arial", Font.BOLD, 20));
        heightLabel.setForeground(Color.GREEN);
        heightLabel.setBounds(200, 250, 100, 30);
        frame.add(heightLabel);

        heightTextField = new JTextField();
        heightTextField.setBounds(300, 250, 200, 30);
        frame.add(heightTextField);

        weightLabel = new JLabel("Weight:");
        weightLabel.setFont(new Font("Arial", Font.BOLD, 20));
        weightLabel.setForeground(Color.GREEN);
        weightLabel.setBounds(200, 290, 100, 30);
        frame.add(weightLabel);

        weightTextField = new JTextField();
        weightTextField.setBounds(300, 290, 200, 30);
        frame.add(weightTextField);

        goalLabel = new JLabel("Goal:");
        goalLabel.setFont(new Font("Arial", Font.BOLD, 20));
        goalLabel.setForeground(Color.GREEN);
        goalLabel.setBounds(200, 330, 100, 30);
        frame.add(goalLabel);

        String[] goals = {"Lose weight", "Maintain weight", "Gain weight"};
        goalsBox = new JComboBox<>(goals);
        goalsBox.setBounds(300, 330, 200, 30);
        frame.add(goalsBox);

        ButtonGroup branchButtonGroup = new ButtonGroup();
        branchButtonGroup.add(mRadioButtons);
        branchButtonGroup.add(fRadioButton);

        verifyCheckBox = new JCheckBox("Verify your details before submission");
        verifyCheckBox.setFont(new Font("Arial", Font.PLAIN, 12));
        verifyCheckBox.setBackground(Color.black);
        verifyCheckBox.setForeground(Color.GRAY);
        verifyCheckBox.setBounds(230, 390, 300, 30);
        frame.add(verifyCheckBox);

        submitButton = new JButton("Submit");
        submitButton.setBounds(300, 430, 100, 30);
        submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        submitButton.setForeground(Color.RED);
        submitButton.setBackground(Color.white);
        frame.add(submitButton);

        submitButton.addActionListener(this);
        frame.setVisible(true);
                
    }

    public void actionPerformed(ActionEvent e) {
        name = nameTextField.getText();
        email = emailTextField.getText();
        age = Integer.parseInt(ageTextField.getText());
        height = Integer.parseInt(heightTextField.getText());
        weight = Integer.parseInt(weightTextField.getText());
        goal = goalsBox.getSelectedItem().toString();

        if(mRadioButtons.isSelected()){
            gender="male";
        }if(fRadioButton.isSelected()) {
            gender="female";
        } else {
            gender="unknown";
        }
        try{
            Connection con=connected.getcon();
            PreparedStatement ps=con.prepareStatement("insert into info values(?,?,?,?,?,?)");
            ps.setString(1,name);
            ps.setString(2, String.valueOf(age));
            ps.setString(3, email);
            ps.setString(4, gender);
            ps.setString(5, String.valueOf(height));
            ps.setString(6, String.valueOf(weight));
            ps.executeUpdate();
            JFrame jf=new JFrame();
            JOptionPane.showMessageDialog(jf,"Successfully Updated");
            new menu().setVisible(true);
            setVisible(false);
        }
        catch(Exception ex){
            JFrame jf=new JFrame();
            JOptionPane.showMessageDialog(jf,ex);
        }

    }

    public static void main(String[] args) {
        new info();
    
    }
}
