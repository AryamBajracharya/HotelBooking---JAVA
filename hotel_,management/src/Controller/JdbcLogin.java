package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Models.LoginModel;

public class JdbcLogin {

	public LoginModel login(LoginModel user) {
		boolean result = false;
		String sql = ("SELECT * FROM customer WHERE email = ? AND password=?");
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/hotel_management","root","");
			PreparedStatement pstat = con.prepareStatement(sql);
			pstat.setString(1, user.getEmail());
			pstat.setString(2, user.getPassword());
			ResultSet rs = pstat.executeQuery();
			while(rs.next()) {
				user.setCustomerId(rs.getInt("customer_id"));
			}
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
		
		return user;
	}
}
