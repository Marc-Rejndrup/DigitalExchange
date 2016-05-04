package dataType;

public class DataTypeEmployee extends DataTypePerson{
	private String hourlyRate;
	private String startDate;
	private String employeeId;
	private String manager;
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
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}

}
