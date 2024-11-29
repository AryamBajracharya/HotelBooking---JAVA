package hotelLuton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; // import necessary classes

public class HotelServicesUI extends JFrame { // Declare the class and implement the ActionListener interface
 
	//Declare instance variables
	
    JPanel mainPanel;
    JLabel titleLabel;
    JCheckBox roomServiceCheckBox;
    JCheckBox laundryCheckBox;
    JCheckBox spaCheckBox;
    JCheckBox gymCheckBox;
    JButton saveButton;
   JButton cancelButton;

    public HotelServicesUI() { // Create a constructor
    	setSize(400,400);
    	setLocationRelativeTo(null);
    	setLayout(null);
    	
    	//Create components and set their positioning
        mainPanel = new JPanel(null);
        mainPanel.setBounds(0,0,400, 300);
        mainPanel.setLayout(null);

        titleLabel = new JLabel("Hotel Services");
        titleLabel.setBounds(150, 20, 100, 20);
        mainPanel.add(titleLabel);

        roomServiceCheckBox = new JCheckBox("Room Service");
        roomServiceCheckBox.setBounds(50, 80, 120, 20);
        mainPanel.add(roomServiceCheckBox);

        laundryCheckBox = new JCheckBox("Laundry");
        laundryCheckBox.setBounds(50, 110, 100, 20);
        mainPanel.add(laundryCheckBox);

        spaCheckBox = new JCheckBox("Spa");
        spaCheckBox.setBounds(200, 80, 80, 20);
        mainPanel.add(spaCheckBox);

        gymCheckBox = new JCheckBox("Gym");
        gymCheckBox.setBounds(200, 110, 80, 20);
        mainPanel.add(gymCheckBox);

        saveButton = new JButton("Save");
        saveButton.setBounds(70, 200, 80, 30);
        mainPanel.add(saveButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 200, 80, 30);
        mainPanel.add(cancelButton);

       add(mainPanel);
        setLocationRelativeTo(null);
        
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HotelServicesUI.this, "Settings saved successfully.");
            }
        });
        setVisible(true);
        setVisible(true);
    }

    public static void main(String[] args) {
         new HotelServicesUI();
    }
}