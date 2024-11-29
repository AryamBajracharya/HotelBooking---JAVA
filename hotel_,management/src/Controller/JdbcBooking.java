package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Models.BookingModel;
import Models.RoomModel;
import hotelLuton.Global;



public class JdbcBooking{
	public boolean book(RoomModel room, BookingModel book) {
		boolean result = false;
		String sql = "INSERT INTO room(`room_id`,`room_type`, `room_price`,`room_availability`) VALUES (?,?,?,?)";
		String sql2 = "INSERT INTO booking (`check_in`, `check_out`, `no_of_guests`,`booking_status`, `customer_id`, `room_id`) VALUES ( ?, ?, ?, ?, ?,?)";

		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hotel_management", "root", "");
			PreparedStatement pstat = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstat.setInt(1, room.getId());
			pstat.setString(2, room.getType());
			pstat.setInt(3, room.getPrice());
			pstat.setString(4, room.getAvailability());

			pstat.executeUpdate();
			
			ResultSet rs = pstat.getGeneratedKeys();
			int roomId = 0;
			if (rs.next()) {

				roomId = rs.getInt(1);
			}

		

			PreparedStatement pstat1 = con.prepareStatement(sql2);
			pstat1.setString(1, book.getCheckIn());
			pstat1.setString(2, book.getCheckOut());
			pstat1.setInt(3, book.getGuests());
			pstat1.setString(4, book.getStatus());
			pstat1.setInt(5, Global.customer_id);
			pstat1.setInt(6, roomId);
			pstat1.executeUpdate();

			
			
			pstat.close();
			pstat1.close();
			con.close();
			
			
			result = true;

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			System.out.println(ex.getMessage());
	
		}

		return result;

	}

	
}
