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

@Entity(name = "AwardGroup")
@Table(name = "AwardGroup", uniqueConstraints = { @UniqueConstraint(columnNames = { "GRP_NM","AWARD_ID" }) })
public class AwardGroup implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@TableGenerator(name = "awardGroupId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "awardGroupId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "awardGroupId")
	@Column(name = "AWARD_GRP_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "GRP_NM", length = 120, nullable = false)
	private String awardGroupName;

	@Column(name = "GRP_DESC", length = 250, nullable = false)
	private String awardGroupDesc;

	@Column(name = "AWARD_ID", length = 20, nullable = false)
	private long awardId;

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

	public long getAwardId() {
		return awardId;
	}

	public void setAwardId(long awardId) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
