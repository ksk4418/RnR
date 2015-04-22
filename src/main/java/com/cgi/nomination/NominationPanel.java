package com.cgi.nomination;

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

@Entity(name = "NominationPanel")
@Table(name = "NominationPanel", uniqueConstraints = { @UniqueConstraint(columnNames = { "PG_MEM_ID","NOM_ID" }) })
public class NominationPanel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "nominationPanelId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "nominationPanelId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "nominationPanelId")
	@Column(name = "NOM_PANEL_ID", length = 20, nullable = false)
	private long nominationPanelId;

	@Column(name = "NOM_ID", length = 20, nullable = false)
	private long nominationId;

	@Column(name = "PG_MEM_ID", length = 120, nullable = false)
	private String panelGroupMemberId;

	@Column(name = "VOTE", length = 1, nullable = false)
	private int vote = -1;

	@Column(name = "level", length = 1, nullable = false)
	private int level = 0;

	@Column(name = "LAST_UP_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateDate = new Date();

	@Column(name = "VERS_NO", nullable = true)
	private int rowVersionNo = 1;

	public long getNominationPanelId() {
		return nominationPanelId;
	}

	public void setNominationPanelId(long nominationPanelId) {
		this.nominationPanelId = nominationPanelId;
	}

	public long getNominationId() {
		return nominationId;
	}

	public void setNominationId(long nominationId) {
		this.nominationId = nominationId;
	}

	public String getPanelGroupMemberId() {
		return panelGroupMemberId;
	}

	public void setPanelGroupMemberId(String panelGroupMemberId) {
		this.panelGroupMemberId = panelGroupMemberId;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
