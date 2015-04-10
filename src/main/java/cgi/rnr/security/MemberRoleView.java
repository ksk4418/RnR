package cgi.rnr.security;

import java.io.Serializable;
import java.math.BigInteger;

@SuppressWarnings("serial")
public class MemberRoleView implements Serializable {

	private BigInteger id;

	private BigInteger roleId;
	private String roleName;

	private String employeeId;
	private String employeeName;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public BigInteger getRoleId() {
		return roleId;
	}

	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}