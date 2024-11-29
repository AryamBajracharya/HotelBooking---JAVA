package hotelLuton;

import java.awt.Color; // import necessary classes
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StaffLogin extends JFrame implements ActionListener{ // Declare the class and implement the ActionListener interface
	
	//Declare instance variables
	
JButton loginButton,backButton;
JLabel staffIdLabel,pinLabel,staffLoginLabel;
JTextField idText;
JPasswordField pinText;

	public StaffLogin() { //Create a constructor
		setSize(300,300);
		setLocationRelativeTo(null);
		setTitle("Staff Login");
		setLayout(null);
		
		staffLoginLabel = new JLabel("Staff Login");
		staffLoginLabel.setBounds(20,30,150,30);
		staffLoginLabel.setForeground(Color.red);
		staffLoginLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		staffIdLabel = new JLabel("Staff Id:");
		staffIdLabel.setBounds(20,80,150,30);
		staffIdLabel.setForeground(Color.red);
		staffIdLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		idText = new JTextField();
		idText.setBounds(100,80,100,30);
		
		pinLabel = new JLabel("Pin:");
		pinLabel.setBounds(20,130,150,30);
		pinLabel.setForeground(Color.red);
		pinLabel.setFont(new Font("Arial", Font.BOLD, 16));
		
		pinText = new JPasswordField();
		pinText.setBounds(100,130,100,30);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(100,180,100,35);
		loginButton.addActionListener(this);
		
		backButton = new JButton("Back");
		backButton.setBounds(100,220,100,35);
		loginButton.addActionListener(this);
		
		add(backButton);
		add(loginButton);
		add(pinText);
		add(idText);
		add(pinLabel);
		add(staffIdLabel);
		add(staffLoginLabel);
		setVisible(true);
	}
	public static void main(String[]args) {
		new StaffLogin();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			new HotelLoginUI();
			setVisible(false);
		}
		
		else if(e.getSource() == loginButton) {
			int pin = Integer.parseInt(pinText.getText());
			int id = Integer.parseInt(idText.getText());
			if(pin == 5678 && id == 5678 ) {
				new ReceptionistUI();
				setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(this, "Error pin/staff id");
			}
		}
	}
}
