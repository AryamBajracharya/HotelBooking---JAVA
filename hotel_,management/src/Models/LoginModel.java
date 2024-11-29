package Models;

public class LoginModel {
	private int customerId;
	private String email;
	private String password;
	
	public LoginModel(int customerId, String email, String password) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.password = password;
	}
	
	public LoginModel() {
		this.customerId = 0;
		this.email = "";
		this.password = "";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginModel [customerId=" + customerId + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
