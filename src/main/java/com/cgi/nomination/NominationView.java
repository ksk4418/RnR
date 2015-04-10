package com.cgi.nomination;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@SuppressWarnings("serial")
public class NominationView implements Serializable {

	private BigInteger id;

	private BigInteger awardId;
	private String awardName;

	private Date nominationDate;

	private String employeeId;
	private String employeeName;

	private String nominatedBy;
	private String nominatedByName;

	private String projectName;

	private String citation;

	private int nominationPhase;
	private String nomPhase;

	private int FY;

	private int quarter;

	private int vote;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getAwardId() {
		return awardId;
	}

	public void setAwardId(BigInteger awardId) {
		this.awardId = awardId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
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

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getNominatedBy() {
		return nominatedBy;
	}

	public void setNominatedBy(String nominatedBy) {
		this.nominatedBy = nominatedBy;
	}

	public String getNominatedByName() {
		return nominatedByName;
	}

	public void setNominatedByName(String nominatedByName) {
		this.nominatedByName = nominatedByName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public String getNomPhase() {
		return nomPhase;
	}

	public void setNomPhase(String nomPhase) {
		this.nomPhase = nomPhase;
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

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

}
