package Models;

public class RoomModel {
	private int id;
	private String type;
	private int price;
	private String availability;
	public RoomModel(int id, String type, int price, String availability) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
		this.availability = availability;
	}
	
	public RoomModel(String type, int price, String availability) {
		super();
		this.type = type;
		this.price = price;
		this.availability = availability;
	}
	
	public RoomModel() {
		this.id = 0;
		this.type = "";
		this.price = 0;
		this.availability = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "RoomModel [id=" + id + ", type=" + type + ", price=" + price + ", availability=" + availability + "]";
	}
	
	
}
