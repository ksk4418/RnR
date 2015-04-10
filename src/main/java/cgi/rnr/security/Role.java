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
@Entity(name = "Role")
@Table(name = "Role", uniqueConstraints = { @UniqueConstraint(columnNames = { "ROLE_NM" }) })
public class Role implements Serializable {

	@Id
	@TableGenerator(name = "roleId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "roleId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "roleId")
	@Column(name = "ROLE_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "ROLE_NM", length = 120, nullable = false)
	private String roleName = "Member";

	@Column(name = "ACTIVE", length = 1, nullable = false)
	private char activeFl = 'Y';
	
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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


}
