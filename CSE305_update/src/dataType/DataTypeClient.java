package dataType;

public class DataTypeClient extends DataTypePerson {
	private String email;
	private String custNum;
	private String creditCard;
	private String rating;

	public String getEmail() {
		return email;
	}
	public void setEmail(String s){
		email = s;
	}
	public String getCustNum() {
		return custNum;
	}
	public void setCustNum(String s){
		custNum = s;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String s){
		creditCard = s;
	}
	public String getRating(){
		return rating;
	}
	public void setRating(String s){
		rating = s;
	}
}
