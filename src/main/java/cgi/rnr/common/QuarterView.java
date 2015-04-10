package cgi.rnr.common;

import java.io.Serializable;
import java.math.BigInteger;

@SuppressWarnings("serial")
public class QuarterView implements Serializable {

	private BigInteger id;

	private String fy;

	private String qtr;

	private String name;

	private char openFl;

	private char closeFl;

	private String quarterName;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getFy() {
		return fy;
	}

	public void setFy(String fy) {
		this.fy = fy;
	}

	public String getQtr() {
		return qtr;
	}

	public void setQtr(String qtr) {
		this.qtr = qtr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getOpenFl() {
		return openFl;
	}

	public void setOpenFl(char openFl) {
		this.openFl = openFl;
	}

	public char getCloseFl() {
		return closeFl;
	}

	public void setCloseFl(char closeFl) {
		this.closeFl = closeFl;
	}

	public String getQuarterName() {
		return quarterName;
	}

	public void setQuarterName(String quarterName) {
		this.quarterName = quarterName;
	}

}
