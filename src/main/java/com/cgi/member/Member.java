package com.cgi.member;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity (name="Member")
@NamedQuery(name = "Member.byNameandId", query = "from Member where employeeId = ? and employeeName = ?")
@Table(name = "Member" , uniqueConstraints = { @UniqueConstraint(columnNames = { "EMPL_ID" }) })
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "memId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "memId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "memId")
	@Column(name = "ID", length = 20, nullable = false)
	private long id;

	@Column(name = "EMPL_ID", nullable = false, length = 12)
	private String employeeId;

	@Column(name = "EMPL_NM", nullable = false, length = 120)
	private String employeeName;

	@Column(name = "MEM_EMAIL", nullable = false, length = 120)
	private String memberEmail;

	@Column(name = "DOJ", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;

	@Column(name = "DESIG", nullable = false, length = 120)
	private String designation;

	@Column(name = "TG", nullable = false, length = 1)
	private int titleGroup = 1;

	@Column(name = "CGI_EXP", nullable = false, scale = 4, precision = 2)
	private double cgiExp = 0.0;

	@Column(name = "PREV_EXP", nullable = false, scale = 4, precision = 2)
	private double prevExp = 0.0;

	@Column(name = "TOT_EXP", nullable = false, scale = 4, precision = 2)
	private double totalExp = 0.0;

	@Column(name = "LOC", nullable = false, length = 120)
	private String location;

	@Column(name = "HRBUID", nullable = false, length = 50)
	private String HRBUId;

	@Column(name = "PRJ_ID", nullable = false, length = 50)
	private String projectId;

	@Column(name = "PRJ_DESC", nullable = false, length = 150)
	private String projectDescription;

	@Column(name = "ASGNMT_STRT_DT", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date assignmentStartDate = new Date();

	@Column(name = "ASGNMT_END_DT", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date assignmentEndDate = new Date();

	@Column(name = "WRK_DAY_HRS", nullable = false, scale = 4, precision = 2)
	private double workHoursPerDay = 9.0;

	@Column(name = "PRJ_ROLE", nullable = false, length = 120)
	private String projectRole;

	@Column(name = "RELEASE_MNTH", nullable = false, length = 50)
	private String releaseMonth;

	@Column(name = "RM", nullable = false, length = 120)
	private String reportingManager;

	@Column(name = "PM", nullable = false, length = 120)
	private String projectManager;

	@Column(name = "SPM", nullable = false, length = 120)
	private String SPMName;

	@Column(name = "ED", nullable = false, length = 120)
	private String engagementDirectorName;

	@Column(name = "GRP_HEAD", nullable = false, length = 120)
	private String groupHeadName;

	@Column(name = "GRP_LEAD", nullable = false, length = 120)
	private String groupLeadName;

	@Column(name = "STRG_GRP_LEAD", nullable = false, length = 120)
	private String stratagicGroupLeadName;

	@Column(name = "PYRAMID_ACCT", nullable = false, length = 120)
	private String pyramidAccount;

	@Column(name = "VERTICAL", nullable = false, length = 120)
	private String vertical;

	@Column(name = "DEPT_ID", nullable = false, length = 50)
	private String departmentId;

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

	public void setAwardId(long id) {
		this.id = id;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getTitleGroup() {
		return titleGroup;
	}

	public void setTitleGroup(int titleGroup) {
		this.titleGroup = titleGroup;
	}

	public double getCgiExp() {
		return cgiExp;
	}

	public void setCgiExp(double cgiExp) {
		this.cgiExp = cgiExp;
	}

	public double getPrevExp() {
		return prevExp;
	}

	public void setPrevExp(double prevExp) {
		this.prevExp = prevExp;
	}

	public double getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(double totalExp) {
		this.totalExp = totalExp;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHRBUId() {
		return HRBUId;
	}

	public void setHRBUId(String hRBUId) {
		HRBUId = hRBUId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getAssignmentStartDate() {
		return assignmentStartDate;
	}

	public void setAssignmentStartDate(Date assignmentStartDate) {
		this.assignmentStartDate = assignmentStartDate;
	}

	public Date getAssignmentEndDate() {
		return assignmentEndDate;
	}

	public void setAssignmentEndDate(Date assignmentEndDate) {
		this.assignmentEndDate = assignmentEndDate;
	}

	public double getWorkHoursPerDay() {
		return workHoursPerDay;
	}

	public void setWorkHoursPerDay(double workHoursPerDay) {
		this.workHoursPerDay = workHoursPerDay;
	}

	public String getProjectRole() {
		return projectRole;
	}

	public void setProjectRole(String projectRole) {
		this.projectRole = projectRole;
	}

	public String getReleaseMonth() {
		return releaseMonth;
	}

	public void setReleaseMonth(String releaseMonth) {
		this.releaseMonth = releaseMonth;
	}

	public String getReportingManager() {
		return reportingManager;
	}

	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getSPMName() {
		return SPMName;
	}

	public void setSPMName(String sPMName) {
		SPMName = sPMName;
	}

	public String getEngagementDirectorName() {
		return engagementDirectorName;
	}

	public void setEngagementDirectorName(String engagementDirectorName) {
		this.engagementDirectorName = engagementDirectorName;
	}

	public String getGroupHeadName() {
		return groupHeadName;
	}

	public void setGroupHeadName(String groupHeadName) {
		this.groupHeadName = groupHeadName;
	}

	public String getGroupLeadName() {
		return groupLeadName;
	}

	public void setGroupLeadName(String groupLeadName) {
		this.groupLeadName = groupLeadName;
	}

	public String getStratagicGroupLeadName() {
		return stratagicGroupLeadName;
	}

	public void setStratagicGroupLeadName(String stratagicGroupLeadName) {
		this.stratagicGroupLeadName = stratagicGroupLeadName;
	}

	public String getPyramidAccount() {
		return pyramidAccount;
	}

	public void setPyramidAccount(String pyramidAccount) {
		this.pyramidAccount = pyramidAccount;
	}

	public String getVertical() {
		return vertical;
	}

	public void setVertical(String vertical) {
		this.vertical = vertical;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
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

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public void setId(long id) {
		this.id = id;
	}

}
