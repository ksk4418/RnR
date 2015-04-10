package com.cgi.nomination;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Nomination")
public class Nomination implements Serializable {

	private static final long serialVersionUID = -5470027388009456869L;
	@Id
	@TableGenerator(name = "nominationId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "nominationId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "nominationId")
	@Column(name = "NOM_ID", nullable = false, length = 20)
	private long id;

	@Column(name = "AWARD_ID", nullable = false, length = 20)
	private long awardId;

	@Column(name = "NOM_DT", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date nominationDate = new Date();

	@Column(name = "EMPLOYEE_ID", length = 12, nullable = true)
	private String employeeId;

	@Column(name = "NOMINATED_BY", length = 120, nullable = true)
	private String nominatedBy;

	@Column(name = "PRJ_NM", length = 120, nullable = false)
	private String projectName;

	@Column(name = "CITATION", length = 1500, nullable = false)
	private String citation;

	@Column(name = "NOM_PHASE", length = 1, nullable = false)
	private int nominationPhase;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lastUpdateDate = Calendar.getInstance();

	@Column(name = "VERS_NO", nullable = true)
	private int rowVersionNo = 1;

	@SuppressWarnings("deprecation")
	@Column(name = "FY", nullable = false)
	private int FY = new Date().getYear();

	@SuppressWarnings("deprecation")
	@Column(name = "QTR", nullable = false)
	private int quarter = new Date().getMonth() / 4;

	@Column(name = "PHASE", nullable = false)
	private long awardPhase;

	public Nomination() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAwardId() {
		return awardId;
	}

	public void setAwardId(long awardId) {
		this.awardId = awardId;
	}

	public Date getNominationDate() {
		return nominationDate;
	}

	public void setNominationDate(Date nominationDate) {
		this.nominationDate = nominationDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getCitation() {
		return citation;
	}

	public void setCitation(String citation) {
		this.citation = citation;
	}

	public int getNominationPhase() {
		return nominationPhase;
	}

	public void setNominationPhase(int nominationPhase) {
		this.nominationPhase = nominationPhase;
	}

	public Calendar getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Calendar lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getRowVersionNo() {
		return rowVersionNo;
	}

	public void setRowVersionNo(int rowVersionNo) {
		this.rowVersionNo = rowVersionNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getFY() {
		return FY;
	}

	public void setFY(int fY) {
		FY = fY;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public String getNominatedBy() {
		return nominatedBy;
	}

	public void setNominatedBy(String nominatedBy) {
		this.nominatedBy = nominatedBy;
	}

	public long getAwardPhase() {
		return awardPhase;
	}

	public void setAwardPhase(long awardPhase) {
		this.awardPhase = awardPhase;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}
