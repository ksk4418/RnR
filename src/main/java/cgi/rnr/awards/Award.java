package cgi.rnr.awards;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity(name = "Award")
@Table(name = "Award", uniqueConstraints = { @UniqueConstraint(columnNames = { "AWARD_NM" }) })
public class Award implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@TableGenerator(name = "awardId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "awardId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "awardId")
	@Column(name = "AWARD_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "AWARD_NM", length = 120, nullable = false)
	private String awardName;

	@Column(name = "AWARD_DESC", length = 250, nullable = false)
	private String awardDesc;

	@Column(name = "FREQ_ID", nullable = false)
	private long frequencyId;

	@Column(name = "ACTIVE", nullable = false, length = 1)
	private char activeFl = 'N';

	@Column(name = "AWARD_TYP", nullable = true, length = 1)
	// individual/Team/Engagement/Community Award
	private int awardType = 1;

	@Column(name = "MIN_ROLE", nullable = true, length = 1)
	private int minimumRole = 1;

	@Column(name = "MAX_ROLE", nullable = true, length = 1)
	private int maximumRole = 8;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate = new Date();

	@Column(name = "LAST_UP_UID", nullable = true, length = 50)
	private String lastUpdateUID;

	@Column(name = "VERS_NO", nullable = true)
	private int rowVersionNumber;

	// Can be nominated within CGI, Vertical, Engagement, Project
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public long getFrequencyId() {
		return frequencyId;
	}

	public void setFrequencyId(long frequencyId) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAwardType() {
		return awardType;
	}

	public void setAwardType(int awardType) {
		this.awardType = awardType;
	}

	public int getMinimumRole() {
		return minimumRole;
	}

	public void setMinimumRole(int minimumRole) {
		this.minimumRole = minimumRole;
	}

	public int getMaximumRole() {
		return maximumRole;
	}

	public void setMaximumRole(int maximumRole) {
		this.maximumRole = maximumRole;
	}

}
