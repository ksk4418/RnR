package cgi.rnr.awards;

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

@Entity(name = "AwardGroupExt")
@Table(name = "AwardGroupExt", uniqueConstraints = { @UniqueConstraint(columnNames = {"GRP_NM","FY","QTR_ID" }) })
public class AwardGroupExt implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@TableGenerator(name = "awardGroupExtId", table = "UNID", pkColumnName = "unidKey", pkColumnValue = "awardGroupExtId", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "awardGroupExtId")
	@Column(name = "AWARD_GRP_EXT_ID", length = 20, nullable = false)
	private long id;

	@Column(name = "GRP_NM", length = 120, nullable = false)
	private String awardGroupName;

	@Column(name = "GRP_EXT_NM", length = 120, nullable = false)
	private String awardGroupExtName;

	@Column(name = "DISP_MSG", length = 250, nullable = false)
	private String displayMessage;

	@Column(name = "OPEN_NOM", length = 1, nullable = false)
	private char openForNominations = 'N';

	@Column(name = "CLOSE_NOM", length = 1, nullable = false)
	private char closeNominations = 'N';

	@Column(name = "CLOSE_PG_REVIEW", length = 1, nullable = false)
	private char closePanelGroupReviews = 'N';

	@Column(name = "OPEN_PG_REVIEW", length = 1, nullable = false)
	private char openPanelGroupReviews = 'N';

	@Column(name = "PUBLISH", length = 1, nullable = false)
	private char publish = 'N';

	@Column(name = "FY", length = 4, nullable = false)
	private String fy="2015";

	@Column(name = "QTR_ID", length = 20, nullable = false)
	private long qtrId = 1;

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

	public String getAwardGroupName() {
		return awardGroupName;
	}

	public void setAwardGroupName(String awardGroupName) {
		this.awardGroupName = awardGroupName;
	}

	public String getAwardGroupExtName() {
		return awardGroupExtName;
	}

	public void setAwardGroupExtName(String awardGroupExtName) {
		this.awardGroupExtName = awardGroupExtName;
	}

	public String getDisplayMessage() {
		return displayMessage;
	}

	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}

	public char getOpenForNominations() {
		return openForNominations;
	}

	public void setOpenForNominations(char openForNominations) {
		this.openForNominations = openForNominations;
	}

	public char getCloseNominations() {
		return closeNominations;
	}

	public void setCloseNominations(char closeNominations) {
		this.closeNominations = closeNominations;
	}

	public char getClosePanelGroupReviews() {
		return closePanelGroupReviews;
	}

	public void setClosePanelGroupReviews(char closePanelGroupReviews) {
		this.closePanelGroupReviews = closePanelGroupReviews;
	}

	public char getOpenPanelGroupReviews() {
		return openPanelGroupReviews;
	}

	public void setOpenPanelGroupReviews(char openPanelGroupReviews) {
		this.openPanelGroupReviews = openPanelGroupReviews;
	}

	public char getPublish() {
		return publish;
	}

	public void setPublish(char publish) {
		this.publish = publish;
	}

	public String getFy() {
		return fy;
	}

	public void setFy(String fy) {
		this.fy = fy;
	}

	public long getQtrId() {
		return qtrId;
	}

	public void setQtrId(long qtrId) {
		this.qtrId = qtrId;
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
