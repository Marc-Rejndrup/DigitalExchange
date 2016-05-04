package dataType;

public class DataTypeClient extends DataTypePerson {
	private String email;
	private long custNum;
	private long creditCard;
	private short rating;
	
	public DataTypeClient(String fullName,String telephone,String email, long custNum, long cc, short rating){
		super(fullName,telephone);
		
		
		this.email = email;
		this.custNum = custNum;
		this.creditCard = cc;
		this.rating = rating;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String s){
		email = s;
	}
	public long getCustNum() {
		return custNum;
	}
	public void setCustNum(long s){
		custNum = s;
	}
	public long getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(long s){
		creditCard = s;
	}
	public short getRating(){
		return rating;
	}
	public void setRating(short s){
		rating = s;
	}
}
