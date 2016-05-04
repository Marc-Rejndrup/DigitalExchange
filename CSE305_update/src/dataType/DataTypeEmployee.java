package dataType;

public class DataTypeEmployee extends DataTypePerson{
	private String id;
	private String ssn;
	private String hourlyRate;
	private String startDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(String hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
}
