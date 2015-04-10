package cgi.rnr.security;

import java.io.Serializable;
import java.math.BigInteger;

@SuppressWarnings("serial")
public class PageCategView implements Serializable {

	private BigInteger id;

	private String categoryName;

	private BigInteger pageId;
	private String pageName;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BigInteger getPageId() {
		return pageId;
	}

	public void setPageId(BigInteger pageId) {
		this.pageId = pageId;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

}
