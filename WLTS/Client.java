package WLTS;

import java.util.Date;

public abstract class Client {

	private int cid;
	private Date expiryDate;
	private String fullName;
	private String homeAddress;

	public abstract boolean validate(int cid);

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getName() {
		return fullName;
	}

	public void setName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return homeAddress;
	}

	public void setAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

}
