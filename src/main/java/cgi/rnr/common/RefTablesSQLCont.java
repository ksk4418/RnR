package cgi.rnr.common;

import cgi.rnr.util.Utils;

public class RefTablesSQLCont {

	// Reference pages
	public static final StringBuffer AWARDS = new StringBuffer();
	public static final StringBuffer AWARDSGRP = new StringBuffer();
	public static final StringBuffer AWARDSGRPEXT = new StringBuffer();
	public static final StringBuffer AWARDCRITERIA = new StringBuffer();
	public static final StringBuffer AWARDELIG = new StringBuffer();
	public static final StringBuffer ACCESS = new StringBuffer();
	public static final StringBuffer AWARDELIG_COUNT = new StringBuffer();
	public static final StringBuffer AWARDELIG_SEARCH = new StringBuffer();
	public static final StringBuffer WRKFLOWLVL = new StringBuffer();
	public static final StringBuffer QUARTER = new StringBuffer();
	public static final StringBuffer PANEL_MEMBERS = new StringBuffer();
	public static final StringBuffer PAGE_CATEG = new StringBuffer();
	public static final StringBuffer MEM_ROLE = new StringBuffer();
	public static final StringBuffer NOMINATED = new StringBuffer();
	public static final StringBuffer NOMINATED_PUBLISHED = new StringBuffer();
	public static final StringBuffer NOMINATIONS_RECEIVED = new StringBuffer();
	public static final StringBuffer NOMINATIONS_MEMBERS = new StringBuffer();
	public static final StringBuffer NOMINATIONS_MEMBERS_PUBLISHED = new StringBuffer();

	static {

		MEM_ROLE.append(
				"select MemberRole.MROLE_ID as id, MemberRole.ROLE_ID as roleId, MemberRole.EMPL_ID as employeeId, (select Role.ROLE_NM from Role ")
				.append("where Role.ROLE_ID = MemberRole.ROLE_ID) as roleName, (select Member.EMPL_NM from Member where Member.EMPL_ID = MemberRole.EMPL_ID) ")
				.append("as employeeName from MemberRole");

		PAGE_CATEG
				.append("select PageCateg.PG_CAT_ID as id, PageCateg.CATEG_NM as categoryName, PageCateg.pageId as pageId, ")
				.append("(Select Pages.PAGE_DISP from Pages where Pages.PAGE_ID = PageCateg.pageId) as pageName ")
				.append("from PageCateg");

		PANEL_MEMBERS
				.append("select PanelMembers.PANEL_MEM_ID as panelMemberId, PanelMembers.PANEL_ID as panelId, PanelMembers.MEMBER_UID as memberUID, ")
				.append("(select Panel.PANEL_NM from Panel where Panel.PANEL_ID = PanelMembers.PANEL_ID) as panelName from PanelMembers");

		QUARTER.append(
				"select Quarter.QTR_ID as id, Quarter.FY as fy, Quarter.QTR as qtr, Quarter.NAME as name, Quarter.OPEN_FL as openFl, ")
				.append("Quarter.CLOSE_FL as closeFl, concat(Quarter.fy, '/QTR-', CAST(Quarter.QTR AS CHAR)) as quarterName ")
				.append("from Quarter ");

		WRKFLOWLVL
				.append("select WorkFlowLevels.WF_LVL_ID as workFlowLevelsId, WorkFlowLevels.WORKFLOW_ID as workFlowId, WorkFlowLevels.LEVEL_NM as workFlowLevelName, ")
				.append("(select WORKFLOW_NM from WorkFlow where WorkFlow.WORKFLOW_ID =  WorkFlowLevels.WORKFLOW_ID) as workFlowName, ")

				// Level 1
				.append("WorkFlowLevels.ENABLED1 as enableFl1, WorkFlowLevels.MEM_LVL1 as memberLevel1, ")
				.append("case when WorkFlowLevels.MEM_LVL1 = 1 then 'Member' when WorkFlowLevels.MEM_LVL1=2 then 'RM' ")
				.append("when WorkFlowLevels.MEM_LVL1=3 then 'PM' when WorkFlowLevels.MEM_LVL1=4 then 'SPM' when WorkFlowLevels.MEM_LVL1=5 then 'ED' ")
				.append("when WorkFlowLevels.MEM_LVL1=6 then 'GH' when WorkFlowLevels.MEM_LVL1=7 then 'GL' when WorkFlowLevels.MEM_LVL1=8 then 'SGL' ")
				.append("end as memberName1, PANEL_ID1 as panelId1, (select PANEL_NM from Panel where WorkFlowLevels.PANEL_ID1 = Panel.PANEL_ID) as panelName1, ")
				.append("WorkFlowLevels.EMAIL_FL1 as emailFlag1, ")

				// Level 2
				.append("WorkFlowLevels.ENABLED2 as enableFl2, WorkFlowLevels.MEM_LVL2 as memberLevel2, ")
				.append("case when WorkFlowLevels.MEM_LVL2=1 then 'Member' when WorkFlowLevels.MEM_LVL2=2 then 'RM' ")
				.append("when WorkFlowLevels.MEM_LVL2=3 then 'PM' when WorkFlowLevels.MEM_LVL2=4 then 'SPM' when WorkFlowLevels.MEM_LVL2=5 then 'ED' ")
				.append("when WorkFlowLevels.MEM_LVL2=6 then 'GH' when WorkFlowLevels.MEM_LVL2=7 then 'GL' when WorkFlowLevels.MEM_LVL2=8 then 'SGL' ")
				.append("end as memberName2, PANEL_ID2 as panelId2, (select PANEL_NM from Panel where WorkFlowLevels.PANEL_ID2 = Panel.PANEL_ID) as panelName2, ")
				.append("WorkFlowLevels.EMAIL_FL2 as emailFlag2, ")

				// Level 3
				.append("WorkFlowLevels.ENABLED3 as enableFl3, WorkFlowLevels.MEM_LVL3 as memberLevel3, ")
				.append("case when WorkFlowLevels.MEM_LVL3=1 then 'Member' when WorkFlowLevels.MEM_LVL3=2 then 'RM' ")
				.append("when WorkFlowLevels.MEM_LVL3=3 then 'PM' when WorkFlowLevels.MEM_LVL3=4 then 'SPM' when WorkFlowLevels.MEM_LVL3=5 then 'ED' ")
				.append("when WorkFlowLevels.MEM_LVL3=6 then 'GH' when WorkFlowLevels.MEM_LVL3=7 then 'GL' when WorkFlowLevels.MEM_LVL3=8 then 'SGL' ")
				.append("end as memberName3, PANEL_ID3 as panelId3, (select PANEL_NM from Panel where WorkFlowLevels.PANEL_ID3 = Panel.PANEL_ID) as panelName3, ")
				.append("WorkFlowLevels.EMAIL_FL3 as emailFlag3, ")

				// Level 4
				.append("WorkFlowLevels.MEM_LVL4 as memberLevel4, WorkFlowLevels.ENABLED4 as enableFl4, ")
				.append("case when WorkFlowLevels.MEM_LVL4=1 then 'Member' when WorkFlowLevels.MEM_LVL4=2 then 'RM' ")
				.append("when WorkFlowLevels.MEM_LVL4=3 then 'PM' when WorkFlowLevels.MEM_LVL4=4 then 'SPM' when WorkFlowLevels.MEM_LVL4=5 then 'ED' ")
				.append("when WorkFlowLevels.MEM_LVL4=6 then 'GH' when WorkFlowLevels.MEM_LVL4=7 then 'GL' when WorkFlowLevels.MEM_LVL4=8 then 'SGL' ")
				.append("end as memberName4, PANEL_ID4 as panelId4, (select PANEL_NM from Panel where WorkFlowLevels.PANEL_ID4 = Panel.PANEL_ID) as panelName4, ")
				.append("WorkFlowLevels.EMAIL_FL4 as emailFlag4, ")

				// Level 5
				.append("WorkFlowLevels.MEM_LVL5 as memberLevel5, WorkFlowLevels.ENABLED5 as enableFl5, ")
				.append("case when WorkFlowLevels.MEM_LVL5=1 then 'Member' when WorkFlowLevels.MEM_LVL5=2 then 'RM' ")
				.append("when WorkFlowLevels.MEM_LVL5=3 then 'PM' when WorkFlowLevels.MEM_LVL5=4 then 'SPM' when WorkFlowLevels.MEM_LVL5=5 then 'ED' ")
				.append("when WorkFlowLevels.MEM_LVL5=6 then 'GH' when WorkFlowLevels.MEM_LVL5=7 then 'GL' when WorkFlowLevels.MEM_LVL5=8 then 'SGL' ")
				.append("end as memberName5, PANEL_ID5 as panelId5, (select PANEL_NM from Panel where WorkFlowLevels.PANEL_ID5 = Panel.PANEL_ID) as panelName5, ")
				.append("WorkFlowLevels.EMAIL_FL5 as emailFlag5, ")

				// Level 6
				.append("WorkFlowLevels.MEM_LVL6 as memberLevel6, WorkFlowLevels.ENABLED6 as enableFl6, ")
				.append("case when WorkFlowLevels.MEM_LVL6=1 then 'Member' when WorkFlowLevels.MEM_LVL6=2 then 'RM' ")
				.append("when WorkFlowLevels.MEM_LVL6=3 then 'PM' when WorkFlowLevels.MEM_LVL6=4 then 'SPM' when WorkFlowLevels.MEM_LVL6=5 then 'ED' ")
				.append("when WorkFlowLevels.MEM_LVL6=6 then 'GH' when WorkFlowLevels.MEM_LVL6=7 then 'GL' when WorkFlowLevels.MEM_LVL6=8 then 'SGL' ")
				.append("end as memberName6, PANEL_ID6 as panelId6, (select PANEL_NM from Panel where WorkFlowLevels.PANEL_ID6 = Panel.PANEL_ID) as panelName6, ")
				.append("WorkFlowLevels.EMAIL_FL6 as emailFlag6, ")

				.append("WorkFlowLevels.AWARD_CRITERIA_ID as awardCriteriaId, ")
				.append("(select AwardCriteria.CRITERIA_NM from AwardCriteria where AwardCriteria.AWARD_CRITERIA_ID =  WorkFlowLevels.AWARD_CRITERIA_ID) as awardCriteriaName")
				.append(" from WorkFlowLevels");

		AWARDS.append(
				"select concat(CAST(a.AWARD_ID AS CHAR), ' ') as id, a.AWARD_NM as awardName, a.AWARD_DESC as awardDesc, a.FREQ_ID as frequencyId, ")
				.append(" (select FREQ_NM from Frequency f where f.FREQ_ID = a.FREQ_ID) as freqName, a.ACTIVE as activeFl ")
				.append(" , case when a.AWARD_TYP=1 then 'Individual' when a.AWARD_TYP=2 then 'Team' ")
				.append(" when a.AWARD_TYP=3 then 'Engagement' when a.AWARD_TYP=4 then 'Others' end as awardType, ")
				.append(" case when a.MIN_ROLE=1 then 'Member' when a.MIN_ROLE=2 then 'RM' ")
				.append(" when a.MIN_ROLE=3 then 'PM' when a.MIN_ROLE=4 then 'SPM' when a.MIN_ROLE=5 then 'ED' ")
				.append(" when a.MIN_ROLE=6 then 'GH' when a.MIN_ROLE=7 then 'GL' when a.MIN_ROLE=8 then 'SGL' ")
				.append(" end as minimumRole, case when a.MAX_ROLE=1 then 'Member' when a.MAX_ROLE=2 then 'RM' ")
				.append(" when a.MAX_ROLE=3 then 'PM' when a.MAX_ROLE=4 then 'SPM' when a.MAX_ROLE=5 then 'ED' ")
				.append(" when a.MAX_ROLE=6 then 'GH' when a.MAX_ROLE=7 then 'GL' when a.MAX_ROLE=8 then 'SGL' ")
				.append(" end as maximumRole, a.MIN_ROLE as minimumRoleId, a.AWARD_TYP as awardTypeId, a.MAX_ROLE as maximumRoleId ")
				.append(" from Award a ");

		AWARDSGRP
				.append("select concat(CAST(g.AWARD_GRP_ID AS CHAR), ' ') as id, g.GRP_NM as awardGroupName, g.GRP_DESC as awardGroupDesc, ")
				.append(" g.AWARD_ID as awardId, (select a.award_nm from Award a where a.AWARD_ID = g.award_id) as awardName")
				.append(" from AwardGroup g ");

		AWARDSGRPEXT
				.append("select ge.AWARD_GRP_EXT_ID as id, ge.GRP_EXT_NM as awardGroupExtName, ")
				.append(" ge.GRP_NM as awardGroupName, ge.DISP_MSG as displayMessage, ")
				.append(" ge.OPEN_NOM as openForNominations, ge.CLOSE_NOM as closeNominations, ge.CLOSE_PG_REVIEW as closePanelGroupReviews, ")
				.append(" ge.OPEN_PG_REVIEW as openPanelGroupReviews, ge.PUBLISH as publish, ge.FY as fy, ")
				.append(" (select concat(q.FY, '/QTR-', q.QTR) from Quarter q where q.QTR_ID = ge.QTR_ID) as fyQtr, ge.QTR_ID as qtrId ")
				.append(" from AwardGroupExt ge ");

		AWARDCRITERIA
				.append("select c.CRITERIA_NM as criteriaName, c.AWARD_CRITERIA_ID as id, c.AWARD_ID as awardId")
				.append(", (select a.award_nm from Award a where a.AWARD_ID = c.award_id) as awardName")
				.append(", c.VERTICAL_ID as verticalId, (")
				.append(Utils.getNullValueCheckDB(Utils.MYSQL))
				.append("((select v.VERTICAL_NM from Vertical v where v.vertical_id = c.vertical_id), 'All')) as verticalName")
				.append(", c.PROJECT_ID as projectId, (")
				.append(Utils.getNullValueCheckDB(Utils.MYSQL))
				.append("((select p.project_nm from Project p where p.PROJECT_ID = c.PROJECT_ID), 'All')) as projectName")
				.append(", c.COMPANY_ID as companyId, (")
				.append(Utils.getNullValueCheckDB(Utils.MYSQL))
				.append("((select cmp.CMP_NM from Company cmp where cmp.CMP_ID = c.COMPANY_ID), 'All')) as companyName")
				.append(", c.CONTINENT_ID as continentId, (")
				.append(Utils.getNullValueCheckDB(Utils.MYSQL))
				.append("((select con.BUS_NM from Continent con where con.BUS_ID = c.CONTINENT_ID), 'All')) as continentName")
				.append(", c.COUNTRY_ID as countryId, (")
				.append(Utils.getNullValueCheckDB(Utils.MYSQL))
				.append("((select ctry.CNTRY_NM from Country ctry where ctry.CNTRY_ID = c.COUNTRY_ID), 'All')) as countryName")
				.append(", c.STATE_ID as stateId, (")
				.append(Utils.getNullValueCheckDB(Utils.MYSQL))
				.append("((select s.ST_NM from State s where s.STATE_ID = c.STATE_ID), 'All')) as stateName")
				.append(", c.LOCATION_ID as locationId, (")
				.append(Utils.getNullValueCheckDB(Utils.MYSQL))
				.append("((select l.LOC_NM from Location l where l.LOC_ID = c.LOCATION_ID), 'All')) as locationName")
				.append(", c.CITY_ID as cityId, (")
				.append(Utils.getNullValueCheckDB(Utils.MYSQL))
				.append("((select cty.city_nm from City cty where cty.CITY_ID = c.CITY_ID), 'All')) as cityName")
				.append(", c.SUB_CITY_ID as subCityId, (")
				.append(Utils.getNullValueCheckDB(Utils.MYSQL))
				.append("((select sc.SCITY_NM from SubCity sc where sc.SCITY_ID = c.SUB_CITY_ID), 'All')) as subCityName")
				.append(", c.CRITERIA_DESC as awardCriteriaDesc, c.QUOTA_PC as quotaPercentage, c.QUOTA_QTY as quotaQuantity")
				.append(", c.QUOTA_ALINGNED_TO as quotaAlinedToRole, c.ACTIVE as activeFl")
				.append(", case when c.QUOTA_ALINGNED_TO=1 then 'Member' when c.QUOTA_ALINGNED_TO=2 then 'RM' ")
				.append(" when c.QUOTA_ALINGNED_TO=3 then 'PM' when c.QUOTA_ALINGNED_TO=4 then 'SPM' when c.QUOTA_ALINGNED_TO=5 then 'ED' ")
				.append(" when c.QUOTA_ALINGNED_TO=6 then 'GH' when c.QUOTA_ALINGNED_TO=7 then 'GL' when c.QUOTA_ALINGNED_TO=8 then 'SGL' ")
				.append(" end as quotaAlinedToRoleName, concat(CAST(c.QUOTA_PC AS CHAR), '%') as quotaPer")
				.append(" from AwardCriteria c ");

		AWARDELIG
				.append("select concat(CAST(e.AWARD_ELIG_ID AS CHAR), ' ') as AWARD_ELIG_ID, ")
				.append(" (select AWARD_NM from Award a where a.AWARD_ID = e.AWARD_ID) as AWARD_NM, e.AWARD_ID as AWARD_ID, ")
				.append(" e.DESCRIPTION as DESCRIPTION, concat('Title Group - ', CAST(e.TITLE_GROUP AS CHAR)) as TITLE_GROUP ")
				.append(" from AwardElig e ");

		AWARDELIG_SEARCH
				.append("where e.AWARD_ID in (select a.award_id from Award a where a.AWARD_NM like '%searchRequest%')");

		AWARDELIG_COUNT.append("select count(*) from AwardElig e ").append(
				AWARDELIG_SEARCH);

		ACCESS.append(
				"select a.ACCESS_ID as id, a.ROLE_NM as accessName, a.pageId as pageId, a.insertFl as insertFl, ")
				.append("a.updateFl as updateFl, a.deleteFl as deleteFl, (select p.page_nm from Pages p where p.PAGE_ID = a.pageId) as pageName from Access a");

		NOMINATED
				.append("select nom.id as id, nom.nominationDate as nomDate, nom.quarter as qtr, nom.FY as fy, nom.nominationPhase as phase, nom.awardId as awardId, ")
				.append("(select phase.name from NominationPhase phase where nom.nominationPhase = phase.id) as name, ")
				.append("(select distinct award.awardName from Award award where award.id = nom.awardId) as awardName, ")
				.append("(select distinct mem.employeeName from Member mem where mem.employeeId = nom.employeeId) as employeeName ")
				.append(", nom.projectName as projectName, nom.nominatedBy as nominatedby, nom.employeeId as employeeId, ")
				.append(Constants.NOMINATED)
				.append(" as type from Nomination nom ")
				.append("where nom.nominatedBy = 'replaceEmplId' ")
				.append("and not exists (select award.id from Award award, AwardGroup ag, AwardGroupExt age, Quarter qtr where award.id = nom.awardId ")
				.append("and qtr.qtr = nom.quarter and qtr.FY = nom.FY and ag.awardGroupName = age.awardGroupName and age.publish = 'Y' and age.qtrId = qtr.id ")
				.append(" and ag.awardId = award.id))) ")
				.append(" order by nom.id desc");

		NOMINATED_PUBLISHED
				.append("select nom.id as id, nom.nominationDate as nomDate, nom.quarter as qtr, nom.FY as fy, nom.nominationPhase as phase, nom.awardId as awardId, ")
				.append("(select phase.name from NominationPhase phase where nom.nominationPhase = phase.id) as name, ")
				.append("(select distinct award.awardName from Award award where award.id = nom.awardId) as awardName, ")
				.append("(select distinct mem.employeeName from Member mem where mem.employeeId = nom.employeeId) as employeeName ")
				.append(", nom.projectName as projectName, nom.nominatedBy as nominatedby, nom.employeeId as employeeId, ")
				.append(Constants.NOMINATED_PUBLISHED)
				.append(" as type from Nomination nom ")
				.append("where nom.nominatedBy = 'replaceEmplId' ")
				.append("and exists (select award.id from Award award, AwardGroup ag, AwardGroupExt age, Quarter qtr where award.id = nom.awardId ")
				.append("and qtr.qtr = nom.quarter and qtr.FY = nom.FY and ag.awardGroupName = age.awardGroupName and age.publish = 'Y' and age.qtrId = qtr.id ")
				.append(" and ag.awardId = award.id))) and nom.employeeId <> 'replaceEmplId' ")
				.append(" order by nom.id desc");

		NOMINATIONS_RECEIVED
				// Gives awards which are published
				.append("select nom.id as id, nom.nominationDate as nomDate, nom.quarter as qtr, nom.FY as fy, nom.nominationPhase as phase, nom.awardId as awardId, ")
				.append("(select phase.name from NominationPhase phase where nom.nominationPhase = phase.id) as name, ")
				.append("(select distinct award.awardName from Award award where award.id = nom.awardId) as awardName, ")
				.append("(select distinct mem.employeeName from Member mem where mem.employeeId = nom.employeeId) as employeeName ")
				.append(", nom.projectName as projectName, nom.nominatedBy as nominatedby, nom.employeeId as employeeId, ")
				.append(Constants.NOMINATIONS_RECEIVED)
				.append(" as type from Nomination nom ")
				.append("where nom.employeeId = 'replaceEmplId' ")
				.append("and nominatedBy <> 'replaceEmplId' ")
				.append("and exists (select award.id from Award award, AwardGroup ag, AwardGroupExt age, Quarter qtr where award.id = nom.awardId ")
				.append("and qtr.qtr = nom.quarter and qtr.FY = nom.FY and ag.awardGroupName = age.awardGroupName and age.publish = 'Y' and age.qtrId = qtr.id ")
				.append(" and ag.awardId = award.id)))")
				.append(" order by nom.id desc");

		NOMINATIONS_MEMBERS
				.append("select nom.id as id, nom.nominationDate as nomDate, nom.quarter as qtr, nom.FY as fy, nom.nominationPhase as phase, nom.awardId as awardId, ")
				.append("(select phase.name from NominationPhase phase where nom.nominationPhase = phase.id) as name, ")
				.append("(select distinct award.awardName from Award award where award.id = nom.awardId) as awardName, ")
				.append("(select distinct mem.employeeName from Member mem where mem.employeeId = nom.employeeId) as employeeName ")
				.append(", nom.projectName as projectName, nom.nominatedBy as nominatedby, nom.employeeId as employeeId, ")
				.append(Constants.NOMINATIONS_MEMBERS)
				.append(" as type from Nomination nom ")
				.append("where nom.employeeId in (")
				.append("select m.employeeId from Member m where ")
				.append(Constants.RM_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.PM_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.SPM_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.ED_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.GH_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.GL_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.SGL_COL)
				.append(" = 'replaceMemberName') and nom.employeeId <> 'replaceEmplId' ")
				.append("and not exists (select award.id from Award award, AwardGroup ag, AwardGroupExt age, Quarter qtr where award.id = nom.awardId ")
				.append("and qtr.qtr = nom.quarter and qtr.FY = nom.FY and ag.awardGroupName = age.awardGroupName and age.publish = 'Y' and age.qtrId = qtr.id ")
				.append(" and ag.awardId = award.id)))")
				.append(" order by nom.id desc");

		NOMINATIONS_MEMBERS_PUBLISHED
				.append("select nom.id as id, nom.nominationDate as nomDate, nom.quarter as qtr, nom.FY as fy, nom.nominationPhase as phase, nom.awardId as awardId, ")
				.append("(select phase.name from NominationPhase phase where nom.nominationPhase = phase.id) as name, ")
				.append("(select distinct award.awardName from Award award where award.id = nom.awardId) as awardName, ")
				.append("(select distinct mem.employeeName from Member mem where mem.employeeId = nom.employeeId) as employeeName ")
				.append(", nom.projectName as projectName, nom.nominatedBy as nominatedby, nom.employeeId as employeeId, ")
				.append(Constants.NOMINATIONS_MEMBERS_PUBLISHED)
				.append(" as type from Nomination nom ")
				.append("where nom.employeeId in (")
				.append("select m.employeeId from Member m where ")
				.append(Constants.RM_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.PM_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.SPM_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.ED_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.GH_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.GL_COL)
				.append(" = 'replaceMemberName' or ")
				.append(Constants.SGL_COL)
				.append(" = 'replaceMemberName') ")
				.append("and exists (select award.id from Award award, AwardGroup ag, AwardGroupExt age, Quarter qtr where award.id = nom.awardId ")
				.append("and qtr.qtr = nom.quarter and qtr.FY = nom.FY and ag.awardGroupName = age.awardGroupName and age.publish = 'Y' and age.qtrId = qtr.id ")
				.append(" and ag.awardId = award.id))) and nom.employeeId <> 'replaceEmplId' and nom.nominatedBy <> 'replaceEmplId' ")
				.append(" order by nom.id desc");
	}
}
