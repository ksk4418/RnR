package cgi.rnr.awards;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class AwardGroupView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String awardGroupName;

	private String awardGroupDesc;

	private BigInteger awardId;

	private String awardName;

	private Date lastUpdateDate;

	private String lastUpdateUID;

	private int rowVersionNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAwardGroupName() {
		return awardGroupName;
	}

	public void setAwardGroupName(String awardGroupName) {
		this.awardGroupName = awardGroupName;
	}

	public String getAwardGroupDesc() {
		return awardGroupDesc;
	}

	public void setAwardGroupDesc(String awardGroupDesc) {
		this.awardGroupDesc = awardGroupDesc;
	}

	public BigInteger getAwardId() {
		return awardId;
	}

	public void setAwardId(BigInteger awardId) {
		this.awardId = awardId;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateUID() {
		return lastUpdateUID;
	}

	public void setLastUpdateUID(String lastUpdateUID) {
		this.lastUpdateUID = lastUpdateUID;
	}

	public int getRowVersionNumber() {
		return rowVersionNumber;
	}

	public void setRowVersionNumber(int rowVersionNumber) {
		this.rowVersionNumber = rowVersionNumber;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

}
