package hotelLuton;

import java.awt.Color; // import necessary classes
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutUsUI {

    private JFrame frame; //Declare the instance variables
    private JPanel panel;
    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JLabel locationLabel;
    private JLabel contactLabel;
    
    public AboutUsUI() { // Create constructor
        frame = new JFrame("About Us"); 
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        
        titleLabel = new JLabel("Welcome to Hotel Luton");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        
        descriptionLabel = new JLabel("<html>Hotel Luton is a luxury hotel located in the heart of the city. Our hotel offers comfortable rooms and excellent amenities to make your stay enjoyable. We pride ourselves on our exceptional customer service and attention to detail.</html>");
        descriptionLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        
        locationLabel = new JLabel("<html><b>Location:</b> 123 Main Street, Luton, LU1 2AT</html>");
        locationLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        
        contactLabel = new JLabel("<html><b>Contact:</b> 01234 567890 | info@hotelluton.com</html>");
        contactLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        
        
        // Set positions and sizes of components
        
        titleLabel.setBounds(20, 20, 300, 30);
        descriptionLabel.setBounds(20, 60, 400, 100);
        locationLabel.setBounds(20, 180, 360, 20);
        contactLabel.setBounds(20, 210, 360, 20);

        
        // Add components to panel
        
        panel.add(titleLabel);
        panel.add(descriptionLabel);
        panel.add(locationLabel);
        panel.add(contactLabel);

        
        // Add panel to frame and make visible
        
        frame.add(panel);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new AboutUsUI();
    }
}
