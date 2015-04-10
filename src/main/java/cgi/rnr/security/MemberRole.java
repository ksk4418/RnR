package cgi.rnr.security;

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

@SuppressWarnings("serial")
@Entity(name = "MemberRole")
@Table(name = "MemberRole", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"ROLE_ID", "EMPL_ID" }) })
public class MemberRole implements Serializable {

	@Id
	@TableGenerator(name = "mRoleId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "mRoleId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "mRoleId")
	@Column(name = "MROLE_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "ROLE_ID", length = 20, nullable = false)
	private long roleId;

	@Column(name = "EMPL_ID", length = 12, nullable = false)
	private String employeeId;

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

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
