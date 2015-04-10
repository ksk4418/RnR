package com.cgi.member;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberTag implements Serializable {

	public int id;
	public String memberName;

	public MemberTag(int id, String memberName) {
		this.id = id;
		this.memberName = memberName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}
