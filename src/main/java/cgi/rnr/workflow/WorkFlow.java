package cgi.rnr.workflow;

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

@Entity(name = "WorkFlow")
public class WorkFlow implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@TableGenerator(name = "workFlowId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "workFlowId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "workFlowId")
	@Column(name = "WORKFLOW_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "WORKFLOW_NM", length = 120, nullable = false)
	private String workFlowName;

	@Column(name = "WORKFLOW_DESC", length = 250, nullable = false)
	private String workFlowDesc;

	@Column(name = "ACTIVE", nullable = false, length = 1)
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

	public String getWorkFlowName() {
		return workFlowName;
	}

	public void setWorkFlowName(String workFlowName) {
		this.workFlowName = workFlowName;
	}

	public String getWorkFlowDesc() {
		return workFlowDesc;
	}

	public void setWorkFlowDesc(String workFlowDesc) {
		this.workFlowDesc = workFlowDesc;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
