package hotelLuton;

import java.awt.Color; // import necessary classes
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Controller.UpdateBooking;
import Models.BookingModel;
 
public class viewBooking implements ActionListener, ListSelectionListener { // Declare the class and implement the ActionListener, ListSelectionListener interface
	
	//Declare instance variable
	
	JFrame frame;
	JPanel backgroundPanel;
	JLabel lutonLabel,checkInLabel, checkOutLabel, guestsLabel, childrensLabel,bookingIdLabel,
			bookingStatusLabel,viewBookingLabel,receptionistLabel,viewCustomerLabel;
	JTextField childrensText, guestsText;
	JTextField bookingIdText, checkInText, checkOutText, bookingStatusText;
	JButton updateButton, confirmButton, backButton;
	JTable table1;
	DefaultTableModel tableModel;
	JScrollPane scroll;

	public viewBooking() { // Create a constructor

		frame = new JFrame();
		backgroundPanel = new JPanel();
		lutonLabel = new JLabel();
		bookingIdLabel = new JLabel();
		bookingStatusLabel = new JLabel();
		checkInLabel = new JLabel();
		checkOutLabel = new JLabel();
		guestsLabel = new JLabel();
		childrensLabel = new JLabel();
		childrensText = new JTextField();
		guestsText = new JTextField();
		checkInText = new JTextField();
		bookingIdText = new JTextField();
		checkOutText = new JTextField();
		bookingStatusText = new JTextField();
		updateButton = new JButton();
		confirmButton = new JButton();
		backButton = new JButton();
		viewBookingLabel = new JLabel();
		receptionistLabel = new JLabel();
		viewCustomerLabel = new JLabel();

		frame.setSize(1000, 700);
		frame.setTitle("Booking");
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);

		backgroundPanel.setBounds(0, 00, 1000, 700);
		backgroundPanel.setBackground(Color.black);
		backgroundPanel.setLayout(null);
		frame.add(backgroundPanel);

		lutonLabel.setText("LUTON HOTEL");
		lutonLabel.setBounds(50, 30, 350, 40);
		lutonLabel.setForeground(Color.ORANGE);
		lutonLabel.setFont(new Font("Arial", Font.BOLD, 36));
		backgroundPanel.add(lutonLabel);


		updateButton.setBounds(250, 560, 150, 35);
		updateButton.setText("Update Booking");
		updateButton.setFocusable(false);
		updateButton.addActionListener(this);
		backgroundPanel.add(updateButton);

		backButton.setBounds(690, 560, 100, 35);
		backButton.setText("Back");
		backButton.setFocusable(false);
		backButton.addActionListener(this);
		backgroundPanel.add(backButton);

		String[] columnNames = { "booking_id", "check_in", "check_out", "no_of_guests", "booking_status",
				"customer_id", "room_id" };

		tableModel = new DefaultTableModel();
		tableModel.setColumnIdentifiers(columnNames);
		table1 = new JTable();
		table1.setModel(tableModel);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table1.setFillsViewportHeight(true);
		table1.setDefaultEditor(Object.class, null);
		table1.getSelectionModel().addListSelectionListener(this);

		table1.setDefaultEditor(Object.class, null);
		scroll = new JScrollPane(table1);
		scroll.setBounds(50, 100, 900, 250);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hotel_management", "root", "");
			String sql = "SELECT * FROM booking WHERE customer_id = ?";
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setInt(1, Global.customer_id);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				int booking_id = rs.getInt("booking_id");
				String check_in = rs.getString("check_in");
				String check_out = rs.getString("check_out");
				int no_of_guests = rs.getInt("no_of_guests");
				String booking_status = rs.getString("booking_status");
				int customer_id = rs.getInt("customer_id");
				int room_id = rs.getInt("room_id");
				tableModel.addRow(new Object[] { booking_id, check_in, check_out, no_of_guests, booking_status,
						customer_id, room_id });
			}
			rs.close();
			pstat.close();
			conn.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		backgroundPanel.add(scroll);


		
		checkInLabel.setText("Check In:");
		checkInLabel.setBounds(30, 460, 100, 30);
		checkInLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		checkInLabel.setForeground(Color.ORANGE);
		backgroundPanel.add(checkInLabel);

		checkInText.setBounds(150, 460, 200, 35);
		backgroundPanel.add(checkInText);

		checkOutLabel.setText("Check Out:");
		checkOutLabel.setBounds(380, 460, 120, 30);
		checkOutLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		checkOutLabel.setForeground(Color.ORANGE);
		backgroundPanel.add(checkOutLabel);

		checkOutText.setBounds(500, 460, 200, 35);
		backgroundPanel.add(checkOutText);

		guestsLabel.setText("No of guests:");
		guestsLabel.setBounds(30, 500, 150, 30);
		guestsLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		guestsLabel.setForeground(Color.ORANGE);
		backgroundPanel.add(guestsLabel);

		guestsText.setBounds(180, 500, 50, 35);
		backgroundPanel.add(guestsText);

		bookingIdLabel.setText("Booking id:");
		bookingIdLabel.setBounds(350, 400, 100, 30);
		bookingIdLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		bookingIdLabel.setForeground(Color.ORANGE);
		backgroundPanel.add(bookingIdLabel);

		bookingIdText.setBounds(450, 400, 50, 35);
		bookingIdText.setEditable(false);
		backgroundPanel.add(bookingIdText);

		bookingStatusLabel.setText("Booking status:");
		bookingStatusLabel.setBounds(520, 500, 130, 30);
		bookingStatusLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		bookingStatusLabel.setForeground(Color.ORANGE);
		backgroundPanel.add(bookingStatusLabel);

		bookingStatusText.setBounds(650, 500, 150, 35);
		backgroundPanel.add(bookingStatusText);

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new viewBooking();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		 if (e.getSource() == updateButton) {

			UpdateBooking jdbc = new UpdateBooking();

			String checkin =checkInText.getText() ;
			String checkout =checkOutText.getText();
			int guests = Integer.parseInt(guestsText.getText());
			int bookingid =Integer.parseInt(bookingIdText.getText());
			String BookingStatus = bookingStatusText.getText();
			BookingModel booking = new BookingModel(bookingid,checkin, checkout,guests,BookingStatus);
			boolean result = jdbc.update(booking);
			if (result==true) {
				JOptionPane.showMessageDialog(frame, "Record Updated");
				new viewBooking();
				frame.setVisible(false);
				
			} else {
				JOptionPane.showMessageDialog(frame, "Record failed to update");
			}}
		if (e.getSource() == backButton) {
			new BookingUI();
			frame.setVisible(false);
		}
		else if(e.getSource() == confirmButton) {
			bookingStatusText.setText("Booking Confirmed");
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting()) {
			int selectedRow = table1.getSelectedRow();
			if (selectedRow != -1) {
				TableModel model = table1.getModel();
				String checkIn = model.getValueAt(selectedRow, 1).toString();
				String checkOut = model.getValueAt(selectedRow, 2).toString();
				String guests = model.getValueAt(selectedRow, 3).toString();
				String bookingId = model.getValueAt(selectedRow, 0).toString();
				String bookingStatus = model.getValueAt(selectedRow, 4).toString();
				checkInText.setText(checkIn);
				checkOutText.setText(checkOut);
				bookingIdText.setText(bookingId);
				bookingStatusText.setText(bookingStatus);
				guestsText.setText(guests.toString());
			}
		}

	}

}
