package cgi.rnr.common;

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
@Entity(name = "Hierarchy")
@Table(name = "Hierarchy", uniqueConstraints = { @UniqueConstraint(columnNames = { "NAME" }) })
public class Hierarchy implements Serializable {

	@Id
	@TableGenerator(name = "hierarchyId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "hierarchyId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "hierarchyId")
	@Column(name = "HIERARCHY_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "NAME", length = 120, nullable = false)
	private String name;

	@Column(name = "COLUMN_NM", length = 120, nullable = false)
	private String columnName;

	@Column(name = "DISP_NM", length = 120, nullable = false)
	private String displayName;

	@Column(name = "TBL_NM", length = 120, nullable = false)
	private String tableName;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
