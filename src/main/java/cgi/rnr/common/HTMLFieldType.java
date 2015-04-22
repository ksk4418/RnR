package cgi.rnr.common;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity(name = "HTML_FLD_TYP")
@Table(name = "HTML_FLD_TYP", uniqueConstraints = { @UniqueConstraint(columnNames = { "FIELD_NM" }) })
public class HTMLFieldType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "FIELD_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "FIELD_NM", length = 120, nullable = false)
	private String filedName;

	@Column(name = "", length = 300, nullable = false)
	private String fieldContent;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Calendar lastUpdateDate = Calendar.getInstance();

	@Column(name = "LAST_UP_UID", nullable = true, length = 50)
	private String lastUpdateUID;

	@Column(name = "VERS_NO", nullable = true)
	private int versionNumber;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFiledName() {
		return filedName;
	}

	public void setFiledName(String filedName) {
		this.filedName = filedName;
	}

	public String getFieldContent() {
		return fieldContent;
	}

	public void setFieldContent(String fieldContent) {
		this.fieldContent = fieldContent;
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

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
