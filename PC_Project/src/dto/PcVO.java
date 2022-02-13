package dto;

public class PcVO {
	private int seat;
	private String startTime;
	private String endTime;
	private int buyTime;
	private String id;
	
	public PcVO(int seat,String startTime,String endTime,int buyTime,String id) {
		this.seat=seat;
		this.startTime=startTime;
		this.endTime=endTime;
		this.buyTime=buyTime;
		this.id=id;
	}
	public int getSeat() {
		return seat;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public int getBuyTime() {
		return buyTime;
	}
	public String getID() {
		return id;
	}
	
}
