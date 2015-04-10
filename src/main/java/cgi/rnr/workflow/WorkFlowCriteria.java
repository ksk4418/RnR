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

@Entity(name = "WORKFLOWCRITERIA")
public class WorkFlowCriteria implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@TableGenerator(name = "workFlowCriteriaId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "workFlowCriteriaId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "workFlowCriteriaId")
	@Column(name = "CRITERIA_ID", length = 20, nullable = false)
	private long workFlowCriteriaId;

	@Column(name = "WORKFLOW_ID", length = 20, nullable = false)
	private long workFlowId;

	@Column(name = "CRITERIA_NM", length = 120, nullable = false)
	private String workFlowCriteriaName;

	@Column(name = "CRITERIA_DESC", length = 250, nullable = false)
	private String workFlowCriteriaDesc;

	@Column(name = "AWARD_CRITERIA_ID", length = 20, nullable = true)
	private long awardCriteriaId;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate = new Date();

	@Column(name = "LAST_UP_UID", nullable = true, length = 50)
	private String lastUpdateUID;

	@Column(name = "VERS_NO", nullable = true)
	private int rowVersionNumber;

	public long getWorkFlowCriteriaId() {
		return workFlowCriteriaId;
	}

	public void setWorkFlowCriteriaId(long workFlowCriteriaId) {
		this.workFlowCriteriaId = workFlowCriteriaId;
	}

	public long getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(long workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getWorkFlowCriteriaName() {
		return workFlowCriteriaName;
	}

	public void setWorkFlowCriteriaName(String workFlowCriteriaName) {
		this.workFlowCriteriaName = workFlowCriteriaName;
	}

	public String getWorkFlowCriteriaDesc() {
		return workFlowCriteriaDesc;
	}

	public void setWorkFlowCriteriaDesc(String workFlowCriteriaDesc) {
		this.workFlowCriteriaDesc = workFlowCriteriaDesc;
	}

	public long getAwardCriteriaId() {
		return awardCriteriaId;
	}

	public void setAwardCriteriaId(long awardCriteriaId) {
		this.awardCriteriaId = awardCriteriaId;
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
