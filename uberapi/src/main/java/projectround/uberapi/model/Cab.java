package projectround.uberapi.model;

public class Cab {

	private String cabId;
	private String driverName;
	private String cabName;
	private int totalFare;

	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

	public Cab() {
		super();
	}

	public Cab(String cabId, String driverName, String cabName) {
		super();
		this.cabId = cabId;
		this.driverName = driverName;
		this.cabName = cabName;
	}

	public String getCabId() {
		return cabId;
	}

	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getCabName() {
		return cabName;
	}

	public void setCabName(String cabName) {
		this.cabName = cabName;
	}

}
