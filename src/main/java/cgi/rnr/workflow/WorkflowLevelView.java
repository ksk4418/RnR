package cgi.rnr.workflow;

import java.io.Serializable;
import java.math.BigInteger;

@SuppressWarnings("serial")
public class WorkflowLevelView implements Serializable {

	private int memberLevel;

	private BigInteger panelId;
	private char emailFl;

	public int getMemberLevel() {
		return memberLevel;
	}

	public void setMemberLevel(int memberLevel) {
		this.memberLevel = memberLevel;
	}

	public BigInteger getPanelId() {
		return panelId;
	}

	public void setPanelId(BigInteger panelId) {
		this.panelId = panelId;
	}

	public char getEmailFl() {
		return emailFl;
	}

	public void setEmailFl(char emailFl) {
		this.emailFl = emailFl;
	}

}
