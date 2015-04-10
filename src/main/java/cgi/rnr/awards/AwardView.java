package cgi.rnr.awards;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@SuppressWarnings("serial")
public class AwardView implements Serializable {

	private String id;

	private String awardName;

	private String awardDesc;

	private BigInteger frequencyId;

	private String freqName;

	private char activeFl = 'N';

	private Date lastUpdateDate = new Date();

	private String lastUpdateUID;

	private int rowVersionNumber;

	private String minimumRole = "Member";

	private String awardType = "Individual";

	private String maximumRole = "SGL";

	private int minimumRoleId;

	private int awardTypeId;

	private int maximumRoleId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardDesc() {
		return awardDesc;
	}

	public void setAwardDesc(String awardDesc) {
		this.awardDesc = awardDesc;
	}

	public BigInteger getFrequencyId() {
		return frequencyId;
	}

	public void setFrequencyId(BigInteger frequencyId) {
		this.frequencyId = frequencyId;
	}

	public char getActiveFl() {
		return activeFl;
	}

	public void setActiveFl(char activeFl) {
		this.activeFl = activeFl;
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

	public String getFreqName() {
		return freqName;
	}

	public void setFreqName(String freqName) {
		this.freqName = freqName;
	}

	public String getMinimumRole() {
		return minimumRole;
	}

	public void setMinimumRole(String minimumRole) {
		this.minimumRole = minimumRole;
	}

	public String getAwardType() {
		return awardType;
	}

	public void setAwardType(String awardType) {
		this.awardType = awardType;
	}

	public int getMinimumRoleId() {
		return minimumRoleId;
	}

	public void setMinimumRoleId(int minimumRoleId) {
		this.minimumRoleId = minimumRoleId;
	}

	public int getAwardTypeId() {
		return awardTypeId;
	}

	public void setAwardTypeId(int awardTypeId) {
		this.awardTypeId = awardTypeId;
	}

	public String getMaximumRole() {
		return maximumRole;
	}

	public void setMaximumRole(String maximumRole) {
		this.maximumRole = maximumRole;
	}

	public int getMaximumRoleId() {
		return maximumRoleId;
	}

	public void setMaximumRoleId(int maximumRoleId) {
		this.maximumRoleId = maximumRoleId;
	}

}
