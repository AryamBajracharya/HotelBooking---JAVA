package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Models.RegisterModel;

public class JdbcRegisterUser {

	public boolean register(RegisterModel user) {
		boolean result = false;
		String sql = "INSERT INTO customer (`name`, `email`, `password`, `customer_type`, `country`, `phone`, `credit_card`, `city`, `age`, `gender` ) VALUES (?,?,?,?,?,?,?,?,?,?);";
	
		try {
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hotel_management","root","");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, user.getName());
			pstat.setString(2, user.getEmail());
			pstat.setString(3, user.getPassword());
			pstat.setString(4, user.getCustomerType());
			pstat.setString(5, user.getCountry());
			pstat.setInt(6, user.getPhone());
			pstat.setString(7, user.getCreditCard());
			pstat.setString(8, user.getCity());
			pstat.setInt(9, user.getAge());
			pstat.setString(10, user.getGender());
			pstat.executeUpdate();
			pstat.close();
			con.close();
			result = true;
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		return result;
	}
}
