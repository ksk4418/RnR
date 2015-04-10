package cgi.rnr.common;

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

@Entity(name = "Frequency")
public class Frequency implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "frequencyId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "frequencyId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "frequencyId")
	@Column(name = "FREQ_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "FREQ_NM", length = 120, nullable = false)
	private String frequencyName;

	@Column(name = "FREQ_DESC", length = 1500, nullable = false)
	private String frequencyDesc;

	@Column(name = "FREQ_DAYS", nullable = false)
	private int frequencyDays = 1;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate = new Date();

	@Column(name = "LAST_UP_UID", length = 50, nullable = true)
	private String lastUpdateUID;

	@Column(name = "VERS_NO", nullable = false)
	private int rowVersionNumber = 1;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrequencyName() {
		return frequencyName;
	}

	public void setFrequencyName(String frequencyName) {
		this.frequencyName = frequencyName;
	}

	public String getFrequencyDesc() {
		return frequencyDesc;
	}

	public void setFrequencyDesc(String frequencyDesc) {
		this.frequencyDesc = frequencyDesc;
	}

	public int getFrequencyDays() {
		return frequencyDays;
	}

	public void setFrequencyDays(int frequencyDays) {
		this.frequencyDays = frequencyDays;
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
