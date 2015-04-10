package cgi.rnr.awards;

import java.io.Serializable;
import java.math.BigInteger;

public class AwardEligView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String AWARD_ELIG_ID;

	private String AWARD_NM;

	private BigInteger AWARD_ID;

	private String DESCRIPTION;

	private String TITLE_GROUP;

	public String getAWARD_ELIG_ID() {
		return AWARD_ELIG_ID;
	}

	public void setAWARD_ELIG_ID(String aWARD_ELIG_ID) {
		AWARD_ELIG_ID = aWARD_ELIG_ID;
	}

	public String getAWARD_NM() {
		return AWARD_NM;
	}

	public void setAWARD_NM(String aWARD_NM) {
		AWARD_NM = aWARD_NM;
	}

	public BigInteger getAWARD_ID() {
		return AWARD_ID;
	}

	public void setAWARD_ID(BigInteger aWARD_ID) {
		AWARD_ID = aWARD_ID;
	}

	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}

	public String getTITLE_GROUP() {
		return TITLE_GROUP;
	}

	public void setTITLE_GROUP(String tITLE_GROUP) {
		TITLE_GROUP = tITLE_GROUP;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
