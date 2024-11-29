package hotelLuton;

import java.awt.Color;    // Import necessary classes
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.ManageLogin;
import Models.LoginModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.JdbcRegisterUser;
import Models.RegisterModel;

public class HotelRegistrationUI extends JFrame implements ActionListener {  // Declare the class and implement the ActionListener interface

	 // Declare instance variables
	
    private JLabel title, nameLabel, emailLabel, passwordLabel, customerTypeLabel, countryLabel, phoneLabel, creditCardLabel, cityLabel, ageLabel, genderLabel;
    private JTextField nameField, emailField, addressField, phoneField, creditCardField, cityField, ageField;
    private JPasswordField passwordField;
    private JRadioButton maleRadioButton, femaleRadioButton, otherRadioButton;
    private ButtonGroup genderButtonGroup;
    private JButton registerButton, closeButton;
    JComboBox customerTypeField;

    public HotelRegistrationUI() { // create constructor
        setTitle("Hotel Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false); 

        // Create the components
        title = new JLabel("HOTEL REGISTRATION");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.red);


        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");
        customerTypeLabel = new JLabel("Customer Type:");
        countryLabel = new JLabel("country:");
        phoneLabel = new JLabel("Phone:");
        creditCardLabel = new JLabel("Credit Card Number:");
        cityLabel = new JLabel("City:");
        ageLabel = new JLabel("Age:");
        genderLabel = new JLabel("Gender:");

        nameField = new JTextField();
        emailField = new JTextField();
        addressField = new JTextField();
        phoneField = new JTextField();
        creditCardField = new JTextField();
        cityField = new JTextField();
        ageField = new JTextField();
        passwordField = new JPasswordField();
        String type[] = {"Corporate","Non-Corporate"};
        customerTypeField = new JComboBox(type);

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        otherRadioButton = new JRadioButton("Other");

        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);
        genderButtonGroup.add(otherRadioButton);

        registerButton = new JButton("Register"); // add ActionListener to the button
        registerButton.addActionListener(this);
        closeButton = new JButton("Close");
        closeButton.addActionListener(this);

        // Create the layout for positioning 
        setLayout(null);
        
        title.setBounds(50, 30, 300, 40);
        add(title);

        nameLabel.setBounds(50, 90, 100, 20);
        add(nameLabel);

        nameField.setBounds(160, 90, 200, 20);
        add(nameField);

        emailLabel.setBounds(50, 120, 100, 20);
        add(emailLabel);

        emailField.setBounds(160, 120, 200, 20);
        add(emailField);

        passwordLabel.setBounds(50, 150, 100, 20);
        add(passwordLabel);

        passwordField.setBounds(160, 150, 200, 20);
        add(passwordField);

        customerTypeLabel.setBounds(50, 180, 120, 20);
        add(customerTypeLabel);

        
        customerTypeField.setBounds(160, 180, 200, 20);
        add(customerTypeField);

        countryLabel.setBounds(50, 210, 100, 20);
        add(countryLabel);

        addressField.setBounds(160, 210, 200, 20);
        add(addressField);

        phoneLabel.setBounds(50, 240, 100, 20);
        add(phoneLabel);

        phoneField.setBounds(160, 240, 200, 20);
        add(phoneField);

        creditCardLabel.setBounds(50, 270, 120, 20);
        add(creditCardLabel);

        creditCardField.setBounds(160, 270, 200,20);
        add(creditCardField);

        creditCardLabel.setBounds(50, 270, 120, 20);
        add(creditCardLabel);
        
        cityLabel.setBounds(50, 300, 100, 20);
        add(cityLabel);

        cityField.setBounds(160, 300, 200, 20);
    	add(cityField);

    	ageLabel.setBounds(50, 330, 100, 20);
    	add(ageLabel);

    	ageField.setBounds(160, 330, 200, 20);
    	add(ageField);

    	genderLabel.setBounds(50, 360, 100, 20);
    	add(genderLabel);

    	maleRadioButton.setBounds(160, 360, 80, 20);
    	add(maleRadioButton);

    	femaleRadioButton.setBounds(240, 360, 80, 20);
    	add(femaleRadioButton);

    	otherRadioButton.setBounds(320, 360, 80, 20);
    	add(otherRadioButton);

    	registerButton.setBounds(80, 400, 100, 30);
    	add(registerButton);

    	closeButton.setBounds(220, 400, 100, 30);
    	add(closeButton);

    	setVisible(true);
}

    public static void main(String[] args) {
    new HotelRegistrationUI();
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeButton) {
			dispose();
		}
		else if(e.getSource() == registerButton) {
			String name = nameField.getText();
			int phone = Integer.parseInt(phoneField.getText());
			int age =  Integer.parseInt(ageField.getText());
			String cType = customerTypeField.getSelectedItem().toString();
			String email = emailField.getText();
			String password = passwordField.getText();
			String country = addressField.getText();
			String city = cityField.getText();
			String card = creditCardField.getText();
			String gender = "";
			if(maleRadioButton.isSelected()) {
				gender = "Male";
			}
			else if(femaleRadioButton.isSelected()) {
				gender = "Female";
			}
			else if(otherRadioButton.isSelected()) {
				gender = "Others";
			}
			
			RegisterModel user = new RegisterModel( name, email,password,  cType,
					 country,phone, card,city,age,gender);
			JdbcRegisterUser jdbc = new JdbcRegisterUser();
			boolean result = jdbc.register(user);
			if(result) {
				JOptionPane.showMessageDialog(this, "Record saved");
				new HotelLoginUI();
				setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(this, "Record not saved");
			}
		}
		
	}
}

