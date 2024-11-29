package hotelLuton;

import java.awt.Color; // import necessary classes
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Controller.JdbcBooking;
import Models.BookingModel;
import Models.RoomModel;

public class BookingUI extends JFrame implements ActionListener { // Declare the class and implement the ActionListener interface

	// Declare instance variables
	
    private JLabel title, checkInLabel, checkOutLabel, numOfGuestsLabel,room,roomPrice,bookingPageLabel ;
    private JTextField   numOfGuestsField;
    private JButton bookButton, closeButton,viewBookingButton,viewServicesButton,BookingButton,settingsButton;
    JComboBox typeField;
    JPanel backgroundPanel;
    JDateChooser checkInField,checkOutField;

    public BookingUI() { //Create a constructor
        setTitle("Booking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        backgroundPanel = new JPanel();
        backgroundPanel.setBounds(500,200,300, 300);

        // Create the components
        
        title = new JLabel("BOOK NOW");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setForeground(Color.red);

        checkInLabel = new JLabel("Check-in Date:");
        checkInLabel.setHorizontalAlignment(JLabel.CENTER);

        checkOutLabel = new JLabel("Check-out Date:");
        checkOutLabel.setHorizontalAlignment(JLabel.CENTER);
        
        numOfGuestsLabel = new JLabel("Number of Guests:");
        numOfGuestsLabel.setHorizontalAlignment(JLabel.CENTER);
        
        room = new JLabel("Room Type:");
        room.setHorizontalAlignment(JLabel.CENTER);

        checkInField = new JDateChooser();
        checkOutField = new JDateChooser();
        numOfGuestsField = new JTextField();
        
        String roomType[]= {"Single","Double","Twin"};
        typeField = new JComboBox(roomType);
        
       
        bookButton = new JButton("Book now");
        bookButton.addActionListener(this);
        closeButton = new JButton("Close");
        closeButton.addActionListener(this);

        bookingPageLabel = new JLabel();
        ImageIcon booking = new ImageIcon("photos/hotelBookNow.jpg"); // Load an image
        bookingPageLabel.setIcon(booking);
        bookingPageLabel.setBounds(0, 0, 1000, 700);

        JLabel hotelLabel = new JLabel("Luton Hotel");
        hotelLabel.setFont(new Font("Arial", Font.BOLD, 30));
        hotelLabel.setForeground(Color.red);
        hotelLabel.setBounds(20, 20, 250, 50);
        bookingPageLabel.add(hotelLabel);

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
        
		settingsButton = new JButton("...");
		settingsButton.setBounds(930, 30, 50, 35);
		settingsButton.setFocusable(false);
		settingsButton.setBorder(null);
		settingsButton.addActionListener(this);
		settingsButton.setBackground(Color.black);
		settingsButton.setForeground(Color.white);
		

		bookingPageLabel.add(settingsButton);
		add(bookingPageLabel); 
        backgroundPanel.setLayout(new GridLayout(7, 2));
        backgroundPanel.add(title);
        backgroundPanel.add(new JPanel()); // Spacer
        backgroundPanel.add(checkInLabel);
        backgroundPanel.add(checkInField);
        backgroundPanel.add(checkOutLabel);
        backgroundPanel.add(checkOutField);
        backgroundPanel.add(numOfGuestsLabel);
        backgroundPanel.add(numOfGuestsField);
        backgroundPanel.add(room);
        backgroundPanel.add(typeField);
        
        backgroundPanel.add(new JPanel()); // Spacer
        backgroundPanel.add(new JPanel()); // Spacer
        backgroundPanel.add(bookButton);
        backgroundPanel.add(closeButton);

        bookingPageLabel.add(BookingButton);
        bookingPageLabel.add(viewServicesButton);
        bookingPageLabel.add(viewBookingButton);
        bookingPageLabel.add(settingsButton);
        bookingPageLabel.add(backgroundPanel);
        add(bookingPageLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BookingUI();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeButton) {
			setVisible(false);
		}
		
		else if(e.getSource() == bookButton) {
			Date selectedDate = checkInField.getDate();
			String checkIn = null;
			if (selectedDate != null) {
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    checkIn = dateFormat.format(selectedDate);
			}
			Date selectedDate2 = checkOutField.getDate();
			String checkOut = null;
			if (selectedDate2 != null) {
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    checkOut = dateFormat.format(selectedDate2);
			}
			int guests = Integer.parseInt(  numOfGuestsField.getText());
			String status = "Booking pending";
			
			
			String type = typeField.getSelectedItem().toString();
			int price = 0;
			if(typeField.getSelectedIndex()==0) {
				price = 2000;
			}
			if(typeField.getSelectedIndex()==1) {
				price = 2222;
			}
			if(typeField.getSelectedIndex()==2) {
				price = 2444;
			}
			String availability = "Available";

			RoomModel room = new RoomModel(type,price,availability);
			BookingModel booking = new BookingModel(checkIn,checkOut,guests,status);
			JdbcBooking jdbc = new JdbcBooking();
			
			boolean result = jdbc.book(room,booking);
			if(result) {
				JOptionPane.showMessageDialog(this,"Booking Successful");
			}
			else {
				JOptionPane.showMessageDialog(this,"Booking failed");
				}
		}
		else if(e.getSource() == viewBookingButton) {
			new viewBooking();
			setVisible(false);
		}
		else if(e.getSource() == viewServicesButton) {
			new Services();
			setVisible(false);
		}
		
		else if(e.getSource()==settingsButton) {
			new HotelSettingsUI();
		}

	        

	}
}
