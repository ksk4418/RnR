package cgi.rnr.workflow;

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

@Entity(name = "WorkFlowLevels")
@Table(name = "WorkFlowLevels", uniqueConstraints = { @UniqueConstraint(columnNames = { "LEVEL_NM","WORKFLOW_ID" }) })
public class WorkFlowLevels implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@TableGenerator(name = "workFlowLevelsId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "workFlowLevelsId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "workFlowLevelsId")
	@Column(name = "WF_LVL_ID", length = 20, nullable = false)
	private long workFlowLevelsId;

	@Column(name = "WORKFLOW_ID", length = 20, nullable = false)
	private long workFlowId;

	@Column(name = "LEVEL_NM", length = 120, nullable = false)
	private String workFlowLevelName;

	@Column(name = "ENABLED1", nullable = false, length = 1)
	private char enableFl1 = 'N';

	@Column(name = "MEM_LVL1", length = 1, nullable = true)
	private int memberLevel1 = 2;

	@Column(name = "PANEL_ID1", length = 20, nullable = true)
	private long panelId1;

	@Column(name = "EMAIL_FL1", length = 1, nullable = false)
	private char emailFlag1 = 'N';

	@Column(name = "ENABLED2", nullable = false, length = 1)
	private char enableFl2 = 'N';

	@Column(name = "MEM_LVL2", length = 1, nullable = true)
	private int memberLevel2 = 2;

	@Column(name = "PANEL_ID2", length = 20, nullable = true)
	private long panelId2;

	@Column(name = "EMAIL_FL2", length = 1, nullable = false)
	private char emailFlag2 = 'N';

	@Column(name = "ENABLED3", nullable = false, length = 1)
	private char enableFl3 = 'N';

	@Column(name = "MEM_LVL3", length = 1, nullable = true)
	private int memberLevel3 = 2;

	@Column(name = "PANEL_ID3", length = 20, nullable = true)
	private long panelId3;

	@Column(name = "EMAIL_FL3", length = 1, nullable = false)
	private char emailFlag3 = 'N';

	@Column(name = "ENABLED4", nullable = false, length = 1)
	private char enableFl4 = 'N';

	@Column(name = "MEM_LVL4", length = 1, nullable = true)
	private int memberLevel4 = 2;

	@Column(name = "PANEL_ID4", length = 20, nullable = true)
	private long panelId4;

	@Column(name = "EMAIL_FL4", length = 1, nullable = false)
	private char emailFlag4 = 'N';

	@Column(name = "ENABLED5", nullable = false, length = 1)
	private char enableFl5 = 'N';

	@Column(name = "MEM_LVL5", length = 1, nullable = true)
	private int memberLevel5 = 2;

	@Column(name = "PANEL_ID5", length = 20, nullable = true)
	private long panelId5;

	@Column(name = "EMAIL_FL5", length = 1, nullable = false)
	private char emailFlag5 = 'N';

	@Column(name = "ENABLED6", nullable = false, length = 1)
	private char enableFl6 = 'N';

	@Column(name = "MEM_LVL6", length = 1, nullable = true)
	private int memberLevel6 = 2;

	@Column(name = "PANEL_ID6", length = 20, nullable = true)
	private long panelId6;

	@Column(name = "EMAIL_FL6", length = 1, nullable = false)
	private char emailFlag6 = 'N';

	@Column(name = "AWARD_CRITERIA_ID", length = 20, nullable = false)
	private long awardCriteriaId;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate = new Date();

	@Column(name = "LAST_UP_UID", nullable = true, length = 50)
	private String lastUpdateUID;

	@Column(name = "VERS_NO", nullable = true)
	private int rowVersionNumber;

	public long getWorkFlowLevelsId() {
		return workFlowLevelsId;
	}

	public void setWorkFlowLevelsId(long workFlowLevelsId) {
		this.workFlowLevelsId = workFlowLevelsId;
	}

	public long getWorkFlowId() {
		return workFlowId;
	}

	public void setWorkFlowId(long workFlowId) {
		this.workFlowId = workFlowId;
	}

	public String getWorkFlowLevelName() {
		return workFlowLevelName;
	}

	public void setWorkFlowLevelName(String workFlowLevelName) {
		this.workFlowLevelName = workFlowLevelName;
	}

	public char getEnableFl1() {
		return enableFl1;
	}

	public void setEnableFl1(char enableFl1) {
		this.enableFl1 = enableFl1;
	}

	public int getMemberLevel1() {
		return memberLevel1;
	}

	public void setMemberLevel1(int memberLevel1) {
		this.memberLevel1 = memberLevel1;
	}

	public long getPanelId1() {
		return panelId1;
	}

	public void setPanelId1(long panelId1) {
		this.panelId1 = panelId1;
	}

	public char getEmailFlag1() {
		return emailFlag1;
	}

	public void setEmailFlag1(char emailFlag1) {
		this.emailFlag1 = emailFlag1;
	}

	public char getEnableFl2() {
		return enableFl2;
	}

	public void setEnableFl2(char enableFl2) {
		this.enableFl2 = enableFl2;
	}

	public int getMemberLevel2() {
		return memberLevel2;
	}

	public void setMemberLevel2(int memberLevel2) {
		this.memberLevel2 = memberLevel2;
	}

	public long getPanelId2() {
		return panelId2;
	}

	public void setPanelId2(long panelId2) {
		this.panelId2 = panelId2;
	}

	public char getEmailFlag2() {
		return emailFlag2;
	}

	public void setEmailFlag2(char emailFlag2) {
		this.emailFlag2 = emailFlag2;
	}

	public char getEnableFl3() {
		return enableFl3;
	}

	public void setEnableFl3(char enableFl3) {
		this.enableFl3 = enableFl3;
	}

	public int getMemberLevel3() {
		return memberLevel3;
	}

	public void setMemberLevel3(int memberLevel3) {
		this.memberLevel3 = memberLevel3;
	}

	public long getPanelId3() {
		return panelId3;
	}

	public void setPanelId3(long panelId3) {
		this.panelId3 = panelId3;
	}

	public char getEmailFlag3() {
		return emailFlag3;
	}

	public void setEmailFlag3(char emailFlag3) {
		this.emailFlag3 = emailFlag3;
	}

	public char getEnableFl4() {
		return enableFl4;
	}

	public void setEnableFl4(char enableFl4) {
		this.enableFl4 = enableFl4;
	}

	public int getMemberLevel4() {
		return memberLevel4;
	}

	public void setMemberLevel4(int memberLevel4) {
		this.memberLevel4 = memberLevel4;
	}

	public long getPanelId4() {
		return panelId4;
	}

	public void setPanelId4(long panelId4) {
		this.panelId4 = panelId4;
	}

	public char getEmailFlag4() {
		return emailFlag4;
	}

	public void setEmailFlag4(char emailFlag4) {
		this.emailFlag4 = emailFlag4;
	}

	public char getEnableFl5() {
		return enableFl5;
	}

	public void setEnableFl5(char enableFl5) {
		this.enableFl5 = enableFl5;
	}

	public int getMemberLevel5() {
		return memberLevel5;
	}

	public void setMemberLevel5(int memberLevel5) {
		this.memberLevel5 = memberLevel5;
	}

	public long getPanelId5() {
		return panelId5;
	}

	public void setPanelId5(long panelId5) {
		this.panelId5 = panelId5;
	}

	public char getEmailFlag5() {
		return emailFlag5;
	}

	public void setEmailFlag5(char emailFlag5) {
		this.emailFlag5 = emailFlag5;
	}

	public char getEnableFl6() {
		return enableFl6;
	}

	public void setEnableFl6(char enableFl6) {
		this.enableFl6 = enableFl6;
	}

	public int getMemberLevel6() {
		return memberLevel6;
	}

	public void setMemberLevel6(int memberLevel6) {
		this.memberLevel6 = memberLevel6;
	}

	public long getPanelId6() {
		return panelId6;
	}

	public void setPanelId6(long panelId6) {
		this.panelId6 = panelId6;
	}

	public char getEmailFlag6() {
		return emailFlag6;
	}

	public void setEmailFlag6(char emailFlag6) {
		this.emailFlag6 = emailFlag6;
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
