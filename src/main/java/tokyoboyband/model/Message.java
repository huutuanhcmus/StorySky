package tokyoboyband.model;

public class Message {
	public String message;
	public String alert;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAlert() {
		return alert;
	}
	public void setAlert(String alert) {
		this.alert = alert;
	}
	
	public void success(String message) {
		alert = "success";
		this.message = message;
	}
	
	public void danger(String message) {
		alert = "danger";
		this.message = message;
	}
}
