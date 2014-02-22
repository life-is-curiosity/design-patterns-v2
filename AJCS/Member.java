package AJCS;

import java.util.Date;

public abstract class Member {

	private String id;
	private Date goodTill;
	private String name;
	private String postal;

	public abstract boolean validate(String id);

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getGoodTill() {
		return goodTill;
	}

	public void setGoodTill(Date goodTill) {
		this.goodTill = goodTill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

}
