package hotelLuton;

import javax.swing.*; // import necessary classes
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelSettingsUI extends JFrame {  // Declare the class and implement the ActionListener interface

	// Declare instance variables
	
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel languageLabel;
    private JComboBox<String> languageCombo;
    private JLabel currencyLabel;
    private JComboBox<String> currencyCombo;
    private JLabel dateFormatLabel;
    private JComboBox<String> dateFormatCombo;
    private JCheckBox emailNotificationsCheckbox;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton aboutButton;

    public HotelSettingsUI() { // Create a constructor
    	setSize(400,400);
    	setLocationRelativeTo(null);
    	
    	
        mainPanel = new JPanel(null);
        mainPanel.setPreferredSize(new Dimension(400, 350));

        titleLabel = new JLabel("Hotel Settings");
        titleLabel.setBounds(150, 20, 100, 20);
        mainPanel.add(titleLabel);

        languageLabel = new JLabel("Language:");
        languageLabel.setBounds(50, 70, 80, 20);
        mainPanel.add(languageLabel);

        languageCombo = new JComboBox<>(new String[]{"English", "Spanish", "French", "German"});
        languageCombo.setBounds(150, 70, 100, 20);
        mainPanel.add(languageCombo);

        currencyLabel = new JLabel("Currency:");
        currencyLabel.setBounds(50, 110, 80, 20);
        mainPanel.add(currencyLabel);

        currencyCombo = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY"});
        currencyCombo.setBounds(150, 110, 100, 20);
        mainPanel.add(currencyCombo);

        dateFormatLabel = new JLabel("Date Format:");
        dateFormatLabel.setBounds(50, 150, 80, 20);
        mainPanel.add(dateFormatLabel);

        dateFormatCombo = new JComboBox<>(new String[]{"MM/dd/yyyy", "dd/MM/yyyy", "yyyy-MM-dd"});
        dateFormatCombo.setBounds(150, 150, 100, 20);
        mainPanel.add(dateFormatCombo);

        emailNotificationsCheckbox = new JCheckBox("Receive Email Notifications");
        emailNotificationsCheckbox.setBounds(50, 190, 200, 20);
        mainPanel.add(emailNotificationsCheckbox);

        saveButton = new JButton("Save");
        saveButton.setBounds(50, 250, 80, 30);
        mainPanel.add(saveButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(150, 250, 80, 30);
        mainPanel.add(cancelButton);

        aboutButton = new JButton("About Us");
        aboutButton.setBounds(250, 250, 100, 30);
        
        aboutButton.addActionListener(new ActionListener() { //add a listener to adapt the about button which opens AboutUsUI while clicking on it
            public void actionPerformed(ActionEvent e) {
                new AboutUsUI();
            }
            });
        mainPanel.add(aboutButton);

        add(mainPanel);
        
        
        
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HotelSettingsUI.this, "Settings saved successfully.");
            }
        });
        setVisible(true);
    
    }
  
    public static void main(String[] args) {
        HotelSettingsUI settingsUI = new HotelSettingsUI();
        settingsUI.setVisible(true);
    }
}