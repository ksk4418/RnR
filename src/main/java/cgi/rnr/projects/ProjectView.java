package cgi.rnr.projects;

import java.io.Serializable;

public class ProjectView implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String projectName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
