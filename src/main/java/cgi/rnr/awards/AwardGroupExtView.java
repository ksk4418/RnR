package cgi.rnr.awards;

import java.io.Serializable;
import java.math.BigInteger;

public class AwardGroupExtView implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigInteger id;

	private String awardGroupExtName;

	private String awardGroupName;

	private String displayMessage;

	private char openForNominations = 'N';

	private char closeNominations = 'N';

	private char closePanelGroupReviews = 'N';

	private char openPanelGroupReviews = 'N';

	private char publish = 'N';

	private String fy = "2015";

	private BigInteger qtrId;

	private String fyQtr;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getAwardGroupName() {
		return awardGroupName;
	}

	public void setAwardGroupName(String awardGroupName) {
		this.awardGroupName = awardGroupName;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getFyQtr() {
		return fyQtr;
	}

	public void setFyQtr(String fyQtr) {
		this.fyQtr = fyQtr;
	}

	public BigInteger getQtrId() {
		return qtrId;
	}

	public void setQtrId(BigInteger qtrId) {
		this.qtrId = qtrId;
	}

}
