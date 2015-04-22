package cgi.rnr.projects;

import java.io.Serializable;
import java.util.Calendar;

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

@Entity(name = "Project")
@Table(name = "Project", uniqueConstraints = { @UniqueConstraint(columnNames = { "PROJECT_NM" }) })
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@TableGenerator(name = "projectId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "projectId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "projectId")
	@Column(name = "PROJECT_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "PROJECT_NM", length = 120, nullable = false)
	private String projectName;

	@Column(name = "PROJECT_DESC", length = 250, nullable = false)
	private String projectDesc;

	@Column(name = "ACTIVE", nullable = false, length = 1)
	private boolean activeFl = true;

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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public boolean isActiveFl() {
		return activeFl;
	}

	public void setActiveFl(boolean activeFl) {
		this.activeFl = activeFl;
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
