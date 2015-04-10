package cgi.rnr.awards;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "AwardElig")
public class AwardElig implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "awardElegibilityId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "awardElegibilityId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "awardElegibilityId")
	@Column(name = "AWARD_ELIG_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "AWARD_ID", nullable = false)
	private long awardId; // --REFERENCES AWARD TABLE

	@Column(name = "DESCRIPTION", nullable = true, length = 120)
	private String description;

	@Column(name = "TITLE_GROUP", nullable = false)
	private int titleGroup;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate = new Date();

	@Column(name = "LAST_UP_UID", nullable = true, length = 50)
	private String lastUpdateUID;

	@Column(name = "VERS_NO", nullable = true)
	private int rowVersionNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAwardId() {
		return awardId;
	}

	public void setAwardId(long awardId) {
		this.awardId = awardId;
	}

	public int getTitleGroup() {
		return titleGroup;
	}

	public void setTitleGroup(int titleGroup) {
		this.titleGroup = titleGroup;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
