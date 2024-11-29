package Models;

public class BookingModel {
private int id;
private String checkIn;
private String checkOut;
private int guests;
private String status;
private int customerId;
private int roomId;

public BookingModel(int id, String checkIn, String checkOut, int guests, String status, int customerId, int roomId) {
	super();
	this.id = id;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
	this.guests = guests;
	this.status = status;
	this.customerId = customerId;
	this.roomId = roomId;
}
public BookingModel(int id, String checkIn, String checkOut, int guests, String status) {
	super();
	this.id = id;
	this.checkIn = checkIn;
	this.checkOut = checkOut;
	this.guests = guests;
	this.status = status;
}

public BookingModel(String checkIn, String checkOut, int guests, String status) {
	super();
	this.checkIn = checkIn;
	this.checkOut = checkOut;
	this.guests = guests;
	this.status = status;
}


public BookingModel() {
	this.id = 0;
	this.checkIn = "";
	this.checkOut = "";
	this.guests = 0;
	this.status = "";
	this.customerId = 0;
	this.roomId = 0;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCheckIn() {
	return checkIn;
}

public void setCheckIn(String checkIn) {
	this.checkIn = checkIn;
}

public String getCheckOut() {
	return checkOut;
}

public void setCheckOut(String checkOut) {
	this.checkOut = checkOut;
}

public int getGuests() {
	return guests;
}

public void setGuests(int guests) {
	this.guests = guests;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public int getCustomerId() {
	return customerId;
}

public void setCustomerId(int customerId) {
	this.customerId = customerId;
}

public int getRoomId() {
	return roomId;
}

public void setRoomId(int roomId) {
	this.roomId = roomId;
}

@Override
public String toString() {
	return "BookingModel [id=" + id + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", guests=" + guests
			+ ", status=" + status + ", customerId=" + customerId + ", roomId=" + roomId + "]";
}



}
