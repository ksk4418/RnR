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
@Entity(name = "Access")
@Table(name = "Access", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"ROLE_NM", "pageId" }) })
public class Access implements Serializable {

	@Id
	@TableGenerator(name = "accessId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "accessId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "accessId")
	@Column(name = "ACCESS_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "ROLE_NM", length = 120, nullable = false)
	private String accessName = "Home"; //considered as Role Name

	@Column(name = "pageId", length = 20, nullable = false)
	private long pageId;
	
	@Column(name = "insertFl", length = 1, nullable = false)
	private char insertFl = 'N';
	
	@Column(name = "updateFl", length = 1, nullable = false)
	private char updateFl = 'N';
	
	@Column(name = "deleteFl", length = 1, nullable = false)
	private char deleteFl = 'N';

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

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public long getPageId() {
		return pageId;
	}

	public void setPageId(long pageId) {
		this.pageId = pageId;
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

	public char getInsertFl() {
		return insertFl;
	}

	public void setInsertFl(char insertFl) {
		this.insertFl = insertFl;
	}

	public char getUpdateFl() {
		return updateFl;
	}

	public void setUpdateFl(char updateFl) {
		this.updateFl = updateFl;
	}

	public char getDeleteFl() {
		return deleteFl;
	}

	public void setDeleteFl(char deleteFl) {
		this.deleteFl = deleteFl;
	}

	
}
