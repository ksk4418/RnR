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

@SuppressWarnings("serial")
@Entity(name = "Quarter")
public class Quarter implements Serializable {

	@Id
	@TableGenerator(name = "qtrId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "qtrId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "qtrId")
	@Column(name = "QTR_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "FY", length = 5, nullable = false)
	private String FY;

	@Column(name = "QTR", length = 1, nullable = false)
	private String qtr;

	@Column(name = "NAME", length = 120, nullable = false)
	private String name;

	@Column(name = "OPEN_FL", length = 1, nullable = false)
	private char openFl = 'N';

	@Column(name = "CLOSE_FL", length = 1, nullable = false)
	private char closeFl = 'N';

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

	public String getFY() {
		return FY;
	}

	public void setFY(String fY) {
		FY = fY;
	}

	public String getQtr() {
		return qtr;
	}

	public void setQtr(String qtr) {
		this.qtr = qtr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getOpenFl() {
		return openFl;
	}

	public void setOpenFl(char openFl) {
		this.openFl = openFl;
	}

	public char getCloseFl() {
		return closeFl;
	}

	public void setCloseFl(char closeFl) {
		this.closeFl = closeFl;
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

}
