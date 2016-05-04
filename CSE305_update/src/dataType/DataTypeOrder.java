package dataType;

public class DataTypeOrder implements java.io.Serializable{
	private String NumShares;
	private String PricePerShare;
	private String Id;
	private String DateTime;
	private String Percentage;
	private String Price;
	private String OrderType;
	private String AccountId;
	private String Stock;
	private String Fee;
	public String getNumShares() {
		return NumShares;
	}
	public void setNumShares(String numshares) {
		NumShares = numshares;
	}
	public String getPricePerShare() {
		return PricePerShare;
	}
	public void setPricePerShare(String pricePerShare) {
		PricePerShare = pricePerShare;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getDateTime() {
		return DateTime;
	}
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
	public String getPercentage() {
		return Percentage;
	}
	public void setPercentage(String percentage) {
		Percentage = percentage;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getOrderType() {
		return OrderType;
	}
	public void setOrderType(String orderType) {
		OrderType = orderType;
	}
	public String getAccountId() {
		return AccountId;
	}
	public void setAccountId(String accountId) {
		AccountId = accountId;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	public String getFee() {
		return Fee;
	}
	public void setFee(String fee) {
		Fee = fee;
	}

}
