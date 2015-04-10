package cgi.rnr.security;

import java.io.Serializable;
import java.math.BigInteger;

@SuppressWarnings("serial")
public class AccessView implements Serializable {

	private BigInteger id;

	private String accessName;

	private BigInteger pageId;

	private char insertFl = 'N';

	private char updateFl = 'N';

	private char deleteFl = 'N';

	private String pageName;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public BigInteger getPageId() {
		return pageId;
	}

	public void setPageId(BigInteger pageId) {
		this.pageId = pageId;
	}

	public char getInsertFl() {
		return insertFl;
	}

	public void setInsertFl(char insertFl) {
		this.insertFl = insertFl;
	}

	public char getUpdateFl() {
		return updateFl;
	}

	public void setUpdateFl(char updateFl) {
		this.updateFl = updateFl;
	}

	public char getDeleteFl() {
		return deleteFl;
	}

	public void setDeleteFl(char deleteFl) {
		this.deleteFl = deleteFl;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

}
