package cgi.rnr.awards;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AwardPage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "awardPageId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "awardPageId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "awardPageId")
	@Column(name = "AWARD_PAGE_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "AWARD_ID", nullable = false)
	private long awardId; // --REFERENCES AWARD TABLE

	@Column(name = "DEST_PAGE", nullable = false)
	private int destPage;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lastUpdateDate = Calendar.getInstance();

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

	public int getDestPage() {
		return destPage;
	}

	public void setDestPage(int destPage) {
		this.destPage = destPage;
	}

	public Calendar getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Calendar lastUpdateDate) {
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
