package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Models.BookingModel;

public class UpdateBooking {

	
	
	public boolean update(BookingModel booking) {
		boolean r = false;
		String sql = "UPDATE booking SET `check_in`=?, `check_out`=?, `no_of_guests`=?,`booking_status`=? WHERE `booking_id`=?";
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hotel_management","root","");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1 , booking.getCheckIn());
			pstat.setString(2 , booking.getCheckOut());
			pstat.setInt(3 , booking.getGuests());
			pstat.setString(4 , booking.getStatus());
			pstat.setInt(5 , booking.getId());
			pstat.executeUpdate();
			pstat.close();
			con.close();
			r = true;
		}
		
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return r;
	}

}
