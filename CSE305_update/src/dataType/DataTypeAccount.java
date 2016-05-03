package dataType;

public class DataTypeAccount implements java.io.Serializable{
	private String id;
	private String DateOpened;
	private String ownerId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDateOpened() {
		return DateOpened;
	}
	public void setDateOpened(String dateOpened) {
		DateOpened = dateOpened;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
}
