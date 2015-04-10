package com.cgi.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cgi.rnr.awards.Award;
import cgi.rnr.awards.AwardView;
import cgi.rnr.common.Constants;
import cgi.rnr.common.FY;
import cgi.rnr.common.Quarter;
import cgi.rnr.common.RefTablesSQLCont;

import com.cgi.member.Member;
import com.cgi.nomination.NominationPanel;
import com.cgi.nomination.NominationView;
import com.cgi.panel.PanelMembers;
import com.cgi.service.RNRService;

/**
 * @author santhosh.kumar
 *
 */
@Controller
public class HomeController {

	@SuppressWarnings("rawtypes")
	@Autowired
	public RNRService rnrService;
	
	@Autowired
	public CommonBean commonBean;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		return "home/home";
	}

	@RequestMapping(value = "/home.cgi", method = RequestMethod.GET)
	public String home1(Locale locale, Model model, HttpSession session) {
		return "home/home";
	}

	@RequestMapping(value = "/searchAwards.cgi", method = RequestMethod.GET)
	public String searchAwardGet(Model model, HttpSession session,
			ServletRequest request) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		return "searchAwards";
	}

	@RequestMapping(value = "/searchAwards.cgi", method = RequestMethod.POST)
	public String searchAwardPost(Model model, HttpSession session,
			ServletRequest request) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		try {
			model.addAttribute(
					"searchAwards",
					rnrService.getResultsBySQL("select nom.id, nom.FY, nom.quarter, nom.employeeId, rmg.employeeName, rmg.designation, rmg.projectDescription, "
							+ "phase.name, award.awardName, nom.nominatedBy from Nomination nom, Member rmg, NominationPhase phase, "
							+ "Award award where award.id = nom.awardId and nom.employeeId like '%"
							+ (request.getParameter("emplId") == null ? ""
									: request.getParameter("emplId").replace(
											'*', '%'))
							+ "%' and nom.employeeId = rmg.employeeId and phase.id= nom.nominationPhase and rmg.employeeName like '%"
							+ request.getParameter("emplName")
									.replace('*', '%')
							+ "%' and nom.FY = '"
							+ request.getParameter("fiscalYear")
							+ "' and nom.quarter = '"
							+ request.getParameter("quarter")
							+ "' and award.awardName like '%"
							+ (request.getParameter("award") == null ? ""
									: request.getParameter("award").replace(
											'*', '%'))
							+ "%'"
							+ "and (nom.nominationPhase = 5 or rmg.reportingManager = '"
							+ session.getAttribute("memberName")
							+ "' or rmg.SPMName = '"
							+ session.getAttribute("memberName")
							+ "' or rmg.projectManager = '"
							+ session.getAttribute("memberName")
							+ "' or rmg.engagementDirectorName = '"
							+ session.getAttribute("memberName")
							+ "' or rmg.groupHeadName = '"
							+ session.getAttribute("memberName")
							+ "' or rmg.groupLeadName = '"
							+ session.getAttribute("memberName")
							+ "' or rmg.stratagicGroupLeadName ='"
							+ session.getAttribute("memberName")
							+ "' or nom.nominatedBy = '"
							+ session.getAttribute("memberId")
							+ "')"
							+ " order by nom.FY desc, nom.quarter desc"));
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("errorMessage",
					"Error occured while processing request<br />" + ex);
			return "error";
		}

		return "nominations/nomActivities/searchAwards";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchAwardsPanel.cgi", method = RequestMethod.GET)
	public String searchAwardsPanel(Model model, HttpSession session,
			ServletRequest request) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		try {

			List<Quarter> qtr = (List<Quarter>) rnrService
					.getResultsBySQL("from Quarter q where q.id in (select age.qtrId from AwardGroupExt age where age.openForNominations = 'Y'"
							+ " and age.closeNominations = 'Y' and age.openPanelGroupReviews = 'Y' and age.closePanelGroupReviews = 'N')");
			List<NominationView> nom = new ArrayList<NominationView>();
			StringBuffer panelSearchSQL = new StringBuffer();

			if (qtr.size() > 0) {
				panelSearchSQL
						.append("select nom.NOM_ID as id, nom.AWARD_ID as awardId, (select a.AWARD_NM from Award a where a.AWARD_ID = nom.AWARD_ID) as awardName, ")
						.append("nom.EMPLOYEE_ID as employeeId, (select m.EMPL_NM from Member m where m.EMPL_ID = nom.EMPLOYEE_ID) as employeeName, nom.NOM_DT as nominationDate, ")
						.append("nom.NOMINATED_BY as nominatedBy, (select m.EMPL_NM from Member m where m.EMPL_ID = nom.NOMINATED_BY) as nominatedByName, ")
						.append("nom.PRJ_NM as projectName, nom.CITATION as citation, nom.NOM_PHASE as nominationPhase, ")
						.append("(select np.NAME from nominationphase np where np.PHASE_ID = nom.NOM_PHASE) as nomPhase, nom.fy as FY, nom.qtr as quarter, ")
						.append("(select np.vote from nominationpanel np where np.nom_id = nom.nom_id and np.pg_mem_id = '")
						.append(session.getAttribute("UID"))
						.append("') as vote")
						.append(" from nomination nom where nom.qtr = ")
						.append(qtr.get(0).getQtr())
						.append(" and nom.fy =")
						.append(qtr.get(0).getFY())
						.append(" and nom.nom_id in (select np.nom_id from NominationPanel np where np.pg_mem_id = '")
						.append(session.getAttribute("UID")).append("')");

				nom = rnrService.getRecordsBySQL(panelSearchSQL.toString(),
						NominationView.class);
			}

			model.addAttribute("searchAwardsPanel", nom);

		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("errorMessage",
					"Error occured while processing request<br />" + ex);
			return commonBean.navigate("ERR", session, model, rnrService);
		}

		return "nominations/nomActivities/searchAwardsPanel";
	}

	@RequestMapping(value = "/searchAwardsPanel.cgi", method = RequestMethod.POST)
	public String searchAwardsPanelPost(Model model, HttpSession session,
			ServletRequest request) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		try {
			rnrService
					.runUpdateOrDelete("update nominationpanel set vote = 1, vers_no = vers_no + 1 where pg_mem_id = '"
							+ session.getAttribute("UID")
							+ "' and nom_id = "
							+ request.getParameter("id"));

		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("errorMessage",
					"Error occured while processing request<br />" + ex);
			return commonBean.navigate("ERR", session, model, rnrService);
		}

		return "redirect:searchAwardsPanel.cgi";
	}

	@RequestMapping(value = "/index.cgi", method = RequestMethod.GET)
	public String home1(Locale locale, Model model, HttpSession session,
			HttpServletRequest request) {
		if (request.getParameter("cntry") == null)
			return "home/index";
		else
			return "home/index_" + request.getParameter("ctry").toLowerCase();
	}

	@RequestMapping(value = "/logout.cgi", method = RequestMethod.GET)
	public String logout(Locale locale, Model model, ServletRequest request,
			HttpSession session) {
		try {
			session.removeAttribute("sessionId");
			session.removeAttribute("memberDetails1");
			session.removeAttribute("memberName");
			session.removeAttribute("memberId");
			session.removeAttribute("vertical");
			session.removeAttribute("UID");
			session.removeAttribute("panelMember");
			session.removeAttribute("memberLevel");
			session.removeAttribute("FY");
			session.removeAttribute("QTR");
			session.removeAttribute("QTRID");
			session.removeAttribute("Menus");
			session.removeAttribute("nominationTypes");
			session.removeAttribute("listOfAwards");
			session.invalidate();
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("errorMessage",
					"Error occured while processing request<br />" + ex);
			return "error";
		}
		return "redirect:home.cgi";
	}

	@RequestMapping(value = "/login.cgi", method = RequestMethod.GET)
	public String loginGet(Locale locale, Model model, ServletRequest request,
			HttpSession session) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		return "redirect:homeDashBoard.cgi";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/login.cgi", method = RequestMethod.POST)
	public String login(Locale locale, Model model, ServletRequest request,
			HttpSession session) {
		boolean valid = false;
		String error = "login";
		try {
			// valid = Utils.authorize(request.getParameter("userName"),
			// request.getParameter("password"));

			valid = true;
			List<Member> list = rnrService.getObjectsByColumn("memberEmail",
					request.getParameter("userName").toString() + "@cgi.com",
					Member.class);
			int memberLevel = 1; // Member
			if (list.size() > 0) {
				session.setAttribute("sessionId", session.getId());
				model.addAttribute("MemberDetails", list.get(0));
				session.setAttribute("memberDetails1", list.get(0));
				session.setAttribute("memberId", list.get(0).getEmployeeId());
				session.setAttribute("memberName", list.get(0)
						.getEmployeeName());
				session.setAttribute("vertical", list.get(0).getVertical());
				session.setAttribute("UID", request.getParameter("userName")
						.toString());
				session.setMaxInactiveInterval(2000);

				List<PanelMembers> listPanel = rnrService.getObjectsByColumn(
						"panelGroupMemberId",
						(String) session.getAttribute("UID"),
						NominationPanel.class);
				if (listPanel != null && listPanel.size() > 0)
					session.setAttribute("panelMember", true);

				try {
					List l = rnrService.getResultsBySQL("select "
							+ Constants.RM_COL + " from Member where "
							+ Constants.RM_COL + "='"
							+ session.getAttribute("memberName") + "'");
					if (l.size() > 0)
						memberLevel = 2;
					l = rnrService.getResultsBySQL("select " + Constants.PM_COL
							+ " from Member where " + Constants.PM_COL + "='"
							+ session.getAttribute("memberName") + "'");
					if (l.size() > 0)
						memberLevel = 3;
					l = rnrService.getResultsBySQL("select "
							+ Constants.SPM_COL + " from Member where "
							+ Constants.SPM_COL + "='"
							+ session.getAttribute("memberName") + "'");
					if (l.size() > 0)
						memberLevel = 4;
					l = rnrService.getResultsBySQL("select " + Constants.ED_COL
							+ " from Member where " + Constants.ED_COL + "='"
							+ session.getAttribute("memberName") + "'");
					if (l.size() > 0)
						memberLevel = 5;
					l = rnrService.getResultsBySQL("select " + Constants.GH_COL
							+ " from Member where " + Constants.GH_COL + "='"
							+ session.getAttribute("memberName") + "'");
					if (l.size() > 0)
						memberLevel = 6;
					l = rnrService.getResultsBySQL("select " + Constants.GL_COL
							+ " from Member where " + Constants.GL_COL + "='"
							+ session.getAttribute("memberName") + "'");
					if (l.size() > 0)
						memberLevel = 7;
					l = rnrService.getResultsBySQL("select "
							+ Constants.SGL_COL + " from Member where "
							+ Constants.SGL_COL + "='"
							+ session.getAttribute("memberName") + "'");
					if (l.size() > 0)
						memberLevel = 8;

					session.setAttribute("memberLevel", memberLevel);

				} catch (Exception ex) {
					ex.printStackTrace();
					model.addAttribute("errorMessage",
							"Error occured while processing request<br />" + ex);
					return "commonPages/error";
				}
			} else
				valid = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			valid = false;
			error = "login1";
		}
		if (valid)
			return "redirect:homeDashBoard.cgi";
		return "redirect:index.cgi?error=" + error;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getEmployeeNames", method = RequestMethod.GET)
	public @ResponseBody List<Member> returnEmployees(
			@RequestParam String tagName, Locale locale, Model model,
			HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			response.setHeader("Access-Control", "*");
			response.setHeader("Access-Control-Allow-Origin", "*");

			StringBuffer memberSql = new StringBuffer();
			memberSql.append("from Member where vertical = '")
					.append((String) session.getAttribute("vertical"))
					.append("' and ").append(" employeeName like '%")
					.append(tagName == null ? "" : tagName).append("%'");

			List<Award> listAward = (List<Award>) rnrService
					.getResultsBySQL("from Award where awardName='"
							+ request.getParameter("awardId") + "'");
			if (listAward.size() > 0) {
				memberSql
						.append(" and titleGroup in (select titleGroup from AwardElig ae where ae.awardId = "
								+ listAward.get(0).getId() + " )");

				switch (listAward.get(0).getMinimumRole()) {
				case Constants.RM:
					memberSql.append(" and (").append(Constants.RM_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.PM_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.SPM_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.ED_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.GH_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.GL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.SGL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.PM:
					memberSql.append(" and (").append(Constants.PM_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.SPM_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.ED_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.GH_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.GL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.SGL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.SPM:
					memberSql.append(" and (").append(Constants.SPM_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.ED_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.GH_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.GL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.SGL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.ED:
					memberSql.append(" and (").append(Constants.ED_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.GH_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.GL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.SGL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.GH:
					memberSql.append(" and (").append(Constants.GH_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.GL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("' or ").append(Constants.SGL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.GL:
					memberSql.append(" and (").append(Constants.GL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("'").append(Constants.SGL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.SGL:
					memberSql.append(" and (").append(Constants.SGL_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				default:
					break;
				}

				switch (listAward.get(0).getMaximumRole()) {
				case Constants.RM:
					memberSql.append(" and (").append(Constants.PM_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.SPM_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.ED_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.GH_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.GL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.SGL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.PM:
					memberSql.append(" and (").append(Constants.SPM_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.ED_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.GH_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.GL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.SGL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.SPM:
					memberSql.append(" and (").append(Constants.ED_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.GH_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.GL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.SGL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.ED:
					memberSql.append(" and (").append(Constants.GH_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.GL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.SGL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.GH:
					memberSql.append(" and (").append(Constants.GL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("' and ").append(Constants.SGL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.GL:
					memberSql.append(" and (").append(Constants.SGL_COL)
							.append(" <> '")
							.append(session.getAttribute("memberName"))
							.append("')");
					break;
				case Constants.SGL:
					break;
				default:
					break;
				}
			}

			return (List<Member>) rnrService.getResultsBySQL(memberSql
					.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ArrayList<Member>();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getEmployeeNames", method = RequestMethod.POST)
	public @ResponseBody HashMap returnEmployeesPost(Locale locale,
			Model model, HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId())) {
			HashMap<String, Object> se = new HashMap<String, Object>();
			se.put("rows", (new ArrayList<String>()).add("Session Expired"));
			return se;
		}
		try {
			Map m = request.getParameterMap();
			Set<String> s = m.keySet();
			String orderBy = null;
			for (String str : s) {
				if (str.startsWith("sort")) {
					orderBy = str.substring(str.indexOf("[") + 1,
							str.length() - 1) + " " + request.getParameter(str);
				}
			}

			int current = Integer.parseInt(request.getParameter("current"));
			int rowCount = Integer.parseInt(request.getParameter("rowCount"));
			int startCurrent = (current * rowCount) - rowCount;
			int recordCount = 0;
			if (request.getParameter("searchPhrase") == null
					|| request.getParameter("searchPhrase").trim().length() < 1)
				recordCount = rnrService.getCount("Member", (String) null);
			else
				recordCount = rnrService.getCount(
						"Member",
						"employeeName like '%"
								+ request.getParameter("searchPhrase") + "%'");

			HashMap<String, Object> hm = new HashMap();
			if (request.getParameter("searchPhrase") == null
					|| request.getParameter("searchPhrase").trim().length() < 1)
				hm.put("rows", rnrService.getRecords("Member", null, orderBy,
						startCurrent, rowCount));
			else
				hm.put("rows", rnrService.getRecords(
						"Member",
						"employeeName like '%"
								+ request.getParameter("searchPhrase") + "%'",
						orderBy, startCurrent, rowCount));
			hm.put("current", current);
			hm.put("rowCount", rowCount);
			hm.put("total", recordCount);
			return hm;
		} catch (Exception ex) {
			ex.printStackTrace();
			HashMap<String, Object> se = new HashMap<String, Object>();
			se.put("rows",
					(new ArrayList<String>()).add("Error occured:" + ex
							+ ", please try again"));
			return se;
		}
	}

	@RequestMapping(value = "/sessionExpired.cgi", method = RequestMethod.GET)
	public String sessionExpiredGet(Locale locale, Model model) {
		return "commonPages/sessionExpired";
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/homeDashBoard.cgi", method = RequestMethod.GET)
	public String homeDashboardGet(Locale locale, Model model,
			HttpSession session) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		try {

			session.removeAttribute("listOfAwards");
			session.removeAttribute("nominationTypes");
			session.removeAttribute("Menus");

			List<FY> activeFy = (List<FY>) rnrService
					.getResultsBySQL("from FY where openFl = 'Y' and closeFl = 'N'");
			if (activeFy.size() > 0)
				session.setAttribute("FY", activeFy.get(0).getFY());
			else
				session.setAttribute("FY", null);

			List<Quarter> activeQtr = (List<Quarter>) rnrService
					.getResultsBySQL("from Quarter where openFl = 'Y' and closeFl = 'N'");
			if (activeQtr.size() > 0) {
				session.setAttribute("QTR", activeQtr.get(0).getQtr());
				session.setAttribute("QTRID", activeQtr.get(0).getId());
			} else
				session.setAttribute("QTR", null);
			List l = rnrService
					.getResultsBySQL("select count(id) from Nomination where nominatedBy='"
							+ session.getAttribute("memberId") + "'");
			long maxNominationId = 0;
			if (l.size() > 0)
				maxNominationId = (l.get(0) == null ? 0 : (long) l.get(0));
			model.addAttribute("totalNominated", maxNominationId);
			l = rnrService
					.getResultsBySQL("select count(id) from Nomination where employeeId='"
							+ session.getAttribute("memberId") + "'");
			maxNominationId = 0;
			if (l.size() > 0)
				maxNominationId = (l.get(0) == null ? 0 : (long) l.get(0));
			model.addAttribute("totalGotNominated", maxNominationId);
			l = rnrService
					.getResultsBySQL("select count(id) from Nomination where employeeId='"
							+ session.getAttribute("memberId")
							+ "' and nominationPhase=5");
			maxNominationId = 0;
			if (l.size() > 0)
				maxNominationId = (l.get(0) == null ? 0 : (long) l.get(0));
			model.addAttribute("totalAwarded", maxNominationId);
			l = rnrService
					.getResultsBySQL("select count(id) from Nomination where nominatedBy='"
							+ session.getAttribute("memberId")
							+ "' and nominationPhase=5");
			maxNominationId = 0;
			if (l.size() > 0)
				maxNominationId = (l.get(0) == null ? 0 : (long) l.get(0));
			model.addAttribute("totalNominationsAwarded", maxNominationId);

			l = null;
			List nominated = rnrService.getRequiredRecordsBySQL(
					RefTablesSQLCont.NOMINATED.toString().replace(
							"replaceEmplId",
							(String) session.getAttribute("memberId")), 0, 4);
			model.addAttribute("nominated", nominated);
			//
			List nominatedPublished = rnrService.getRequiredRecordsBySQL(
					RefTablesSQLCont.NOMINATED_PUBLISHED.toString().replace(
							"replaceEmplId",
							(String) session.getAttribute("memberId")), 0, 2);
			// model.addAttribute("nominatedPublished", nominatedPublished);

			List nominationsReceivied = rnrService.getRequiredRecordsBySQL(
					RefTablesSQLCont.NOMINATIONS_RECEIVED.toString().replace(
							"replaceEmplId",
							(String) session.getAttribute("memberId")), 0, 4);
			model.addAttribute("nominationsReceivied", nominationsReceivied);

			List nominationToMembers = rnrService
					.getRequiredRecordsBySQL(
							RefTablesSQLCont.NOMINATIONS_MEMBERS
									.toString()
									.replace(
											"replaceMemberName",
											(String) session
													.getAttribute("memberName"))
									.replace(
											"replaceEmplId",
											(String) session
													.getAttribute("memberId")),
							0, 4);
			model.addAttribute("nominationToMembers", nominationToMembers);

			List nominationToMembersPublished = rnrService
					.getRequiredRecordsBySQL(
							RefTablesSQLCont.NOMINATIONS_MEMBERS_PUBLISHED
									.toString()
									.replace(
											"replaceMemberName",
											(String) session
													.getAttribute("memberName"))
									.replace(
											"replaceEmplId",
											(String) session
													.getAttribute("memberId")),
							0, 2);
			nominationToMembersPublished.addAll(nominatedPublished);

			model.addAttribute("nominationToMembersPublished",
					nominationToMembersPublished);

			StringBuffer nomMessage = new StringBuffer();

			if (!(session.getAttribute("QTR") == null || session
					.getAttribute("FY") == null)) {
				List<AwardView> avlist = (List<AwardView>) rnrService
						.getRecordsBySQL(
								"select concat(cast(a.AWARD_ID as char), ' ') as id, a.AWARD_NM as awardName, "
										+ " (case when a.AWARD_TYP = 1 then 'Individual'"
										+ " when a.AWARD_TYP = 2 then 'Team' when a.AWARD_TYP = 3 then 'Engagement'"
										+ " when a.AWARD_TYP = 4 then 'Others' end) as awardType"
										+ ", a.FREQ_ID as frequencyId, cast(a.MIN_ROLE as char) as minimumRole,  cast(a.MAX_ROLE as char) as maximumRole, a.AWARD_DESC as awardDesc"
										+ ", (select f.FREQ_NM from frequency f where f.FREQ_ID = a.FREQ_ID) as freqName from award a where a.award_id in"
										+ " (select ag.AWARD_ID from awardgroup ag where ag.GRP_NM in"
										+ " (SELECT age.grp_nm FROM awardgroupext age where age.OPEN_NOM = 'Y'"
										+ " and age.CLOSE_NOM = 'N' and age.fy = '"
										+ session.getAttribute("FY")
										+ "' and age.qtr_id in (select qu.qtr_id from quarter qu where qu.qtr='"
										+ session.getAttribute("QTR") + "')))"
										+ " and a.min_role <= "
										+ session.getAttribute("memberLevel")
										+ " and a.max_role >= "
										+ session.getAttribute("memberLevel")
										+ " and a.ACTIVE = 'Y'",
								AwardView.class);
				List<String> nominationTypes = new ArrayList<String>();
				Map<String, List> awards = new HashMap<String, List>();
				List<String> awardList = new ArrayList<String>();
				String prevAwardType = "";
				StringBuffer nomOpenMsg = new StringBuffer();

				for (AwardView av : avlist) {
					if (!nominationTypes.contains(av.getAwardType())) {
						if (nominationTypes.size() > 0) {
							awards.put(prevAwardType, awardList);
							awardList = new ArrayList<String>();
						}
						prevAwardType = av.getAwardType();
						nominationTypes.add(av.getAwardType());
					}
					awardList.add(av.getAwardName());
					if (nomOpenMsg.length() > 0)
						nomOpenMsg.append(", ");
					nomOpenMsg.append(av.getAwardName());
				}

				if (nomOpenMsg.length() == 0)
					nomMessage.append("Nominations are closed.");
				else
					nomMessage.append("Nominations open for ")
							.append(nomOpenMsg.toString()).append(" awards.");
				awards.put(prevAwardType, awardList);
				session.setAttribute("listOfAwards", awards);
				session.setAttribute("nominationTypes", nominationTypes);
			} else
				nomMessage
						.append("No Active Fiscal Year/Quarter for nominations.");
			model.addAttribute("nomMessage", nomMessage);

			StringBuilder pagesSQL = new StringBuilder();
			pagesSQL.append(
					"select distinct PageCateg.CATEG_NM, Pages.PAGE_DISP, Pages.PAGE_NM from MemberRole, Access, Role, PageCateg, Pages ")
					.append("where Access.ROLE_NM = Role.ROLE_NM ")
					.append("and Role.ROLE_ID = MemberRole.ROLE_ID and PageCateg.pageId = Access.pageId ")
					.append("and PageCateg.pageId = Pages.PAGE_ID and MemberRole.EMPL_ID = '"
							+ session.getAttribute("memberId")
							+ "' order by PageCateg.CATEG_NM, PageCateg.CATEG_NM");
			List<Object[]> l1 = (List<Object[]>) rnrService.getRecords(pagesSQL
					.toString());
			HashMap menues = new HashMap();
			HashMap pages = new HashMap();
			String prevCateg = "";
			for (Object[] obj : l1) {
				if (!((String) obj[0]).equalsIgnoreCase(prevCateg)) {
					if (!prevCateg.equals("")) {
						menues.put(prevCateg, pages);
						pages = null;
						pages = new HashMap();
					}
					prevCateg = (String) obj[0];
				}
				pages.put(obj[2], obj[1]);
			}
			if (pages.size() > 0)
				menues.put(prevCateg, pages);
			session.setAttribute("Menus", menues);

		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("errorMessage",
					"Error occured while processing request<br />" + ex);
			return commonBean.navigate("ERR", session, model, rnrService);
		}
		return commonBean
				.navigate("USERHOME", session, model, rnrService);
	}
}
