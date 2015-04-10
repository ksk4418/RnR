package com.cgi.nomination;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "NominationForm")
@Table(name = "NOMINATION_DATA")
public class NominationForm implements Serializable {

	private static final long serialVersionUID = 5787025614310276894L;
	@Id
	@TableGenerator(name = "nominationDataId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "nominationDataId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "nominationDataId")
	@Column(name = "NOM_DATA_ID", length = 20, nullable = false)
	private long nominationDataId;

	@Column(name = "NOM_ID", length = 20, nullable = false)
	private long nominationId;

	@Column(name = "TEXT1", length = 1500, nullable = false)
	private String inputText1;

	@Column(name = "TEXT2", length = 1500, nullable = true)
	private String inputText2;

	@Column(name = "SCORE", length = 4, precision = 2, nullable = false)
	private Double score = 0.0;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lastUpdateDate = Calendar.getInstance();

	@Column(name = "VERS_NO", nullable = true)
	private int rowVersionNo = 1;

	public NominationForm() {
		super();
	}

	public NominationForm(long nominationDataId, long awardId,
			String inputText1, String inputText2, Double score) {
		super();
		this.nominationDataId = nominationDataId;
		this.inputText1 = inputText1;
		this.inputText2 = inputText2;
		this.score = score;
	}

	public String toString() {
		return "NominationForm [NOM_FORM_ID=" + nominationDataId + ", awardId="
				+ ", inputText1=" + inputText1 + ", inputText2=" + inputText2
				+ ", score=" + score + "]";
	}

	public long getNominationDataId() {
		return nominationDataId;
	}

	public void setNominationDataId(long nominationDataId) {
		this.nominationDataId = nominationDataId;
	}

	public long getNominationId() {
		return nominationId;
	}

	public void setNominationId(long nominationId) {
		this.nominationId = nominationId;
	}

	public String getInputText1() {
		return inputText1;
	}

	public void setInputText1(String inputText1) {
		this.inputText1 = inputText1;
	}

	public String getInputText2() {
		return inputText2;
	}

	public void setInputText2(String inputText2) {
		this.inputText2 = inputText2;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
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

}
