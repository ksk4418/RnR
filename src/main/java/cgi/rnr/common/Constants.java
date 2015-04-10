package cgi.rnr.common;

import java.io.Serializable;

public interface Constants extends Serializable {

	public static int MEMBER = 1;
	public static int RM = 2;
	public static int PM = 3;
	public static int SPM = 4;
	public static int ED = 5;
	public static int GH = 6;
	public static int GL = 7;
	public static int SGL = 8;

	public static String MEMBER_COL = "employeeName";
	public static String RM_COL = "reportingManager";
	public static String PM_COL = "projectManager";
	public static String SPM_COL = "SPMName";
	public static String ED_COL = "engagementDirectorName";
	public static String GH_COL = "groupHeadName";
	public static String GL_COL = "groupLeadName";
	public static String SGL_COL = "stratagicGroupLeadName";

	public static String MEMBER_COL_NM = "EMPL_NM";
	public static String RM_COL_NM = "RM";
	public static String PM_COL_NM = "PM";
	public static String SPM_COL_NM = "SPM";
	public static String ED_COL_NM = "ED";
	public static String GH_COL_NM = "GRP_HEAD";
	public static String GL_COL_NM = "GRP_LEAD";
	public static String SGL_COL_NM = "STRG_GRP_LEAD";

	public static int NOMINATED = 1;
	public static int NOMINATED_PUBLISHED = 2;
	public static int NOMINATIONS_RECEIVED = 3;
	public static int NOMINATIONS_MEMBERS = 4;
	public static int NOMINATIONS_MEMBERS_PUBLISHED = 5;

	public static int SUBMITTED = 1;
	public static int READY_FOR_REVIEW = 2;
	public static int IN_PROCESS = 3;
	public static int REVIEWED = 4;
	public static int APPROVED = 5;
	public static int REJECTED = 6;

	public static final String ERRMSG = "errorMessage";
	public static final String ERR = "Error occured while processing request<br />";
	public static final String ERRPG = "error";
	public static final String AWARD = "Award";
	public static final String AWARDNM = "awardName";
	public static final String AWARDGRPNM = "awardGroupName";
	public static final String CRITERIANM = "criteriaName";
	public static final String RESPONSETEXT = "responseText";
	public static final String AJAXRESP = "commonPages/ajaxCallResponse";
	public static final String SESSIONEXP = "Session Expired";
	public static final String SESSIONID = "sessionId";
	public static final String ACTION = "action";
	public static final String ACTVFL = "activeFl";
	public static final String AWARDDESC = "awardDesc";
	public static final String INVALIDREQUEST = "Invalid Request";
}
