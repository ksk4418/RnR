package com.cgi.member;

import java.io.Serializable;
import java.util.Calendar;
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

@Entity(name="MemberExt")
@Table(name = "RMG_DATA_EXT" , uniqueConstraints = { @UniqueConstraint(columnNames = { "RM_ID","EMPL_ID" }) })
public class MemberExt implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "memberExtId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "memberExtId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "memberExtId")
	@Column(name = "MEM_EXT_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "EMPL_ID", nullable = false, length = 12)
	private String employeeId;

	@Column(name = "DOJ", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfJoining = new Date();
	
	@Column(name = "RM_ID", nullable = false, length = 12)
	private String rmId;

	@Column(name = "RM_EMAIL", nullable = false, length = 120)
	private String rmEmail;
	
	@Column(name = "GENDER", nullable = false, length = 1)
	private char gender = 'F';
	
	@Column(name = "DESIG", nullable = false, length = 120)
	private String designation;

	@Column(name = "TG", nullable = false, length = 20)
	private String titleGroup = "TG - 0";
	
	@Column(name = "MEM_EMAIL", nullable = false, length = 120)
	private String memberEmail;

	@Column(name = "CONTACT", nullable = false, length = 120)
	private String contact;

	@Column(name = "QUALIFICATION", nullable = false, length = 120)
	private String qualification;

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

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getRmId() {
		return rmId;
	}

	public void setRmId(String rmId) {
		this.rmId = rmId;
	}

	public String getRmEmail() {
		return rmEmail;
	}

	public void setRmEmail(String rmEmail) {
		this.rmEmail = rmEmail;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getTitleGroup() {
		return titleGroup;
	}

	public void setTitleGroup(String titleGroup) {
		this.titleGroup = titleGroup;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
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
