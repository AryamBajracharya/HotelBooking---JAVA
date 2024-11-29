package hotelLuton;

import java.awt.Color;       // Import necessary classes
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

public class HotelLoginUI extends JFrame implements ActionListener { // Declare the class and implement the ActionListener interface

	JLabel title, emailLabel, passwordLabel, loginImageLabel,StaffLabel; // Declare instance variables
	JTextField emailField;
	JPasswordField passwordField;
	JButton loginButton, closeButton, createAccountButton;

	public HotelLoginUI() {  // Constructor method to create the user interface
		System.out.print(" ");
		
		setTitle("Hotel Login");        // Set the properties of the JFrame	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		loginImageLabel = new JLabel();

		// Create the components
		title = new JLabel("HOTEL LOGIN");
		title.setFont(new Font("Arial", Font.BOLD, 28));
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setForeground(Color.red);

		emailLabel = new JLabel("Username:");
		passwordLabel = new JLabel("Password:");

		emailField = new JTextField();
		passwordField = new JPasswordField();

		loginButton = new JButton("Login");
		closeButton = new JButton("Close");
		createAccountButton = new JButton("Create Account");

		// Create the layout for positioning
		setLayout(null);

		title.setBounds(100, 20, 200, 50);

		emailLabel.setBounds(70, 80, 80, 30);
		passwordLabel.setBounds(70, 120, 80, 30);

		emailField.setBounds(160, 80, 150, 30);
		passwordField.setBounds(160, 120, 150, 30);

		loginButton.setBounds(120, 160, 150, 30);

		closeButton.setBounds(30, 220, 150, 30);
		createAccountButton.setBounds(220, 220, 150, 30);

		ImageIcon Login = new ImageIcon("photos/hotel.png");    // Load an image
		loginImageLabel.setIcon(Login);
		loginImageLabel.setBounds(100, 50, 400, 400);
		
		StaffLabel = new JLabel("Login as staff");
		StaffLabel.setBounds(10, 190, 150, 30);
		StaffLabel.setForeground(Color.red);
		StaffLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		// Add a mouse listener to the staff login label to open the staff login window
		StaffLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new StaffLogin();
                setVisible(false);
            }
        });

		 // Add all the components to the JFrame
		add(StaffLabel);
		add(title);
		add(emailLabel);
		add(passwordLabel);
		add(emailField);
		add(passwordField);
		add(loginButton);
		add(closeButton);
		add(createAccountButton);
		add(loginImageLabel);

		   // Add action listeners to the buttons
		loginButton.addActionListener(this);
		createAccountButton.addActionListener(this);
		closeButton.addActionListener(this);

		setVisible(true);

	}

	public static void main(String[] args) {
		new HotelLoginUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton) {
			try {
				LoginModel user = new LoginModel();
				ManageLogin loginUser = new ManageLogin();
				user.setEmail(emailField.getText());
				user.setPassword(passwordField.getText());
				loginUser.setUser(user);
				loginUser.login();
				user = loginUser.getUser();
				if(user.getCustomerId()>=1) {
					
					Global.customer_id= user.getCustomerId();
					Global.email= user.getEmail();
					JOptionPane.showMessageDialog(this, "Welcome : "+Global.email);
					new BookingUI();
					setVisible(false);
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Login Failed");
				}
			}
			catch (Exception ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage());
			
			}
		}
		else if(e.getSource()==closeButton) {
			setVisible(false);
		}
		else if(e.getSource()==createAccountButton) {
			new HotelRegistrationUI();
			setVisible(false);
		}

	}
}