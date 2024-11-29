package hotelLuton;
import java.awt.Color; // import necessary classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Services extends JFrame implements ActionListener { // Declare the class and implement the ActionListener interface

	// Declare instance variables
	
    private JLabel servicePageLabel ;
    private JButton closeButton,viewBookingButton,viewServicesButton,BookingButton,roomServiceButton,barButton;

    public Services() { // Create a constructor
        setTitle("Booking");
        setSize(1000,700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        
        closeButton = new JButton("Close");
        closeButton.addActionListener(this);
        closeButton.setBounds(850,600,100,35);

		
		BookingButton = new JButton("Booking");
		BookingButton.setBounds(430,30,150,35);
		BookingButton.setFocusable(false);
		BookingButton.setBorder(null);
		BookingButton.addActionListener(this);
		BookingButton.setBackground(Color.black);
		BookingButton.setForeground(Color.white);
		
		viewBookingButton = new JButton("View Booking");
		viewBookingButton.setBounds(600,30,150,35);
		viewBookingButton.setFocusable(false);
		viewBookingButton.setBorder(null);
		viewBookingButton.addActionListener(this);
		viewBookingButton.setBackground(Color.black);
		viewBookingButton.setForeground(Color.white);
		
		viewServicesButton = new JButton("Services");
		viewServicesButton.setBounds(770,30,150,35);
		viewServicesButton.setFocusable(false);
		viewServicesButton.setBorder(null);
		viewServicesButton.addActionListener(this);
		viewServicesButton.setBackground(Color.black);
		viewServicesButton.setForeground(Color.white);
		
		roomServiceButton = new JButton("Room Service");
		roomServiceButton.setBounds(250,300,250,50);
		roomServiceButton.setFocusable(false);
		roomServiceButton.setBorder(null);
		roomServiceButton.addActionListener(this);
		roomServiceButton.setBackground(Color.white);
		roomServiceButton.setForeground(Color.black);
		
		barButton = new JButton("Bar");
		barButton.setBounds(550,300,250,50);
		barButton.setFocusable(false);
		barButton.setBorder(null);
		barButton.addActionListener(this);
		barButton.setBackground(Color.white);
		barButton.setForeground(Color.black);


    
		servicePageLabel = new JLabel();
		servicePageLabel.setBounds(0,0,1000,700);
		 ImageIcon service = new ImageIcon("photos/hotelBookNow.jpg");
		 servicePageLabel.setIcon(service);
		
		 servicePageLabel.add(barButton);
		 servicePageLabel.add(roomServiceButton);
		 servicePageLabel.add(viewServicesButton);
		 servicePageLabel.add(BookingButton);
        servicePageLabel.add(viewBookingButton);
        servicePageLabel.add(closeButton);
        add(servicePageLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Services();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeButton) {
			setVisible(false);
		}
		
	
		else if(e.getSource() == viewBookingButton) {
			new viewBooking();
			setVisible(false);
		}
		
		else if(e.getSource() == BookingButton) {
			new BookingUI();
			setVisible(false);
		}
		
		else if(e.getSource() == barButton) {
			new BarUI();
		}
		
		else if(e.getSource() == roomServiceButton) {
			new HotelServicesUI();
		}
		
		
	}
}
