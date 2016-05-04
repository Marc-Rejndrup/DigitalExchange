package dataType;

public class DataTypePerson implements java.io.Serializable{
	private String ssn;
	private String zipCode;
	private String fullName;
	private String address;
	private String telephone;
	
	// Default constructor
	public DataTypePerson() {
	}
	
	// Used by DataTypeClient's super(name,tele#)
	public DataTypePerson(String fullName,String telephone){
		this.fullName = fullName;
		this.telephone = telephone;
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
