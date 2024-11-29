package Models;

public class RegisterModel {
	private int customerId;
	private String name;
	private String email;
	private String password;
	private String customerType;
	private String country;
	private int phone;
	private String creditCard;
	private String city;
	private int age;
	private String gender;
	
	public RegisterModel( String name, String email, String password, String customerType,
			String country, int phone, String creditCard, String city, int age, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.customerType = customerType;
		this.country = country;
		this.phone = phone;
		this.creditCard = creditCard;
		this.city = city;
		this.age = age;
		this.gender = gender;
	}
	
	public RegisterModel() {
		this.name = "";
		this.email = "";
		this.password = "";
		this.customerType = "";
		this.country = "";
		this.phone = 0;
		this.creditCard = "";
		this.city = "";
		this.age = 0;
		this.gender = "";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "RegisterModel [customerId=" + customerId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", customerType=" + customerType + ", country=" + country + ", phone=" + phone
				+ ", creditCard=" + creditCard + ", city=" + city + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	
	
	
}
