package dto;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private String remainTime;

	public MemberVO(String id, String pw, String name, String remainTime) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.remainTime = remainTime;
	}

	public String getID() {
		return id;
	}

	public void setPW(String pw) {
		this.pw = pw;
	}

	public String getPW() {
		return pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getRemainTime() {
		return remainTime;
	}
}
