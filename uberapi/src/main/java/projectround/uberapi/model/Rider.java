package projectround.uberapi.model;

public class Rider {
	
	private String riderId;
	private String riderName;
	private int xCordinate;
	private int yCordinate;
	private int dropLocationX;
	private int dropLocationY;

	public int getDropLocationX() {
		return dropLocationX;
	}
	public void setDropLocationX(int dropLocationX) {
		this.dropLocationX = dropLocationX;
	}
	public int getDropLocationY() {
		return dropLocationY;
	}
	public void setDropLocationY(int dropLocationY) {
		this.dropLocationY = dropLocationY;
	}
	public int getxCordinate() {
		return xCordinate;
	}
	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}
	public int getyCordinate() {
		return yCordinate;
	}
	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}
	public String getRiderId() {
		return riderId;
	}
	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}
	public String getRiderName() {
		return riderName;
	}
	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}
	public Rider(String riderId, String riderName) {
		super();
		this.riderId = riderId;
		this.riderName = riderName;
	}
	public Rider() {
		super();
	}
	

}
