package com.cgi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cgi.rnr.awards.Award;
import cgi.rnr.common.Constants;
import cgi.rnr.workflow.WorkflowLevelView;

import com.cgi.member.Member;
import com.cgi.nomination.Nomination;
import com.cgi.nomination.NominationForm;
import com.cgi.nomination.NominationPanel;
import com.cgi.panel.PanelMembers;
import com.cgi.service.RNRService;

@Controller
public class NominatonController {

	@SuppressWarnings("rawtypes")
	@Autowired
	private RNRService rnrService;
	
	@Autowired
	public CommonBean commonBean;
	
	public final String AWARDID = "awardId";

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/nominateTeam1.cgi", method = RequestMethod.GET)
	public String nominationTeam1Get(Model model,
			ServletRequest request, HttpSession session) {
		model.addAttribute(AWARDID, request.getParameter(AWARDID));
		try {
			List<Member> list = (List<Member>) rnrService
					.getResultsBySQL("from Member where projectDescription ='"
							+ request.getParameter("team") + "'");
			model.addAttribute("member", list.get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return "error";
		}
		return commonBean.navigate(
				"NOM"
						+ ((String) request.getParameter(AWARDID))
								.toUpperCase(), session, model, rnrService);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/nominate.cgi", method = RequestMethod.GET)
	public String nominationGet(Locale locale, Model model,
			ServletRequest request, HttpSession session) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		try {
			if (request.getParameter("aType") != null
					&& request.getParameter("aType").equalsIgnoreCase("2")) { // Team
				List<Member> list = (List<Member>) rnrService
						.getObjectsByMemberNameorId(null,
								(String) session.getAttribute("memberId"));
				model.addAttribute("member", list.get(0));

				StringBuffer member = new StringBuffer();
				member.append("select distinct projectDescription from Member where ");
				switch ((Integer) session.getAttribute("memberLevel")) {
				case Constants.MEMBER:
					member.append(" ").append(Constants.MEMBER_COL)
							.append(" = '")
							.append(session.getAttribute("memberName"))
							.append("'");
					break;
				case Constants.RM:
					member.append(" ").append(Constants.RM_COL).append(" = '")
							.append(session.getAttribute("memberName"))
							.append("'");
					break;
				case Constants.PM:
					member.append(" ").append(Constants.PM_COL).append(" = '")
							.append(session.getAttribute("memberName"))
							.append("'");
					break;
				case Constants.SPM:
					member.append(" ").append(Constants.SPM_COL).append(" = '")
							.append(session.getAttribute("memberName"))
							.append("'");
					break;
				case Constants.ED:
					member.append(" ").append(Constants.ED_COL).append(" = '")
							.append(session.getAttribute("memberName"))
							.append("'");
					break;
				case Constants.GH:
					member.append(" ").append(Constants.GH_COL).append(" = '")
							.append(session.getAttribute("memberName"))
							.append("'");
					break;
				case Constants.GL:
					member.append(" ").append(Constants.GL_COL).append(" = '")
							.append(session.getAttribute("memberName"))
							.append("'");
					break;
				case Constants.SGL:
					member.append(" ").append(Constants.SGL_COL).append(" = '")
							.append(session.getAttribute("memberName"))
							.append("'");
					break;
				}
				model.addAttribute("teams", (List<String>) rnrService
						.getResultsBySQL(member.toString()));
				model.addAttribute(AWARDID, request.getParameter(AWARDID));
				return commonBean.navigate("NOMTEAMFSTEP2", session,
						model, rnrService);
			} else if (request.getParameter("aType") != null
					&& request.getParameter("aType").equalsIgnoreCase("1")) { // Individual
				model.addAttribute(AWARDID, request.getParameter(AWARDID));
				model.addAttribute("aType", request.getParameter("aType"));
				return commonBean.navigate("NOMINFSTEP2", session, model,
						rnrService);
			} else {

				List<Member> list = (List<Member>) rnrService
						.getObjectsByMemberNameorId(null,
								(String) request.getParameter("emplId"));
				model.addAttribute("member", list.get(0));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return commonBean.navigate("ERR", session, model, rnrService);
		}
		model.addAttribute(AWARDID, request.getParameter(AWARDID));
		return commonBean.navigate(
				"NOM"
						+ ((String) request.getParameter(AWARDID))
								.toUpperCase(), session, model, rnrService);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/nominate.cgi", method = RequestMethod.POST)
	public String nominationPost(Locale locale, Model model,
			ServletRequest request, HttpSession session) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		try {
			if (request.getParameter("aType") != null
					&& request.getParameter("aType").equalsIgnoreCase("2")) {
				List<Member> list = (List<Member>) rnrService
						.getObjectsByMemberNameorId(null,
								(String) session.getAttribute("memberId"));
				model.addAttribute("member", list.get(0));
			} else {
				List<Member> list = (List<Member>) rnrService
						.getObjectsByMemberNameorId(null,
								(String) request.getParameter("emplId"));
				model.addAttribute("member", list.get(0));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return commonBean.navigate("ERR", session, model, rnrService);
		}
		model.addAttribute(AWARDID, request.getParameter(AWARDID));
		return commonBean.navigate(
				"NOM"
						+ ((String) request.getParameter(AWARDID))
								.toUpperCase(), session, model, rnrService);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/nominationConfirmation.cgi", method = RequestMethod.POST)
	public String nominationConfirmationPage(Locale locale, Model model,
			ServletRequest request, HttpSession session) throws Exception {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		int i = 1;
		try {
			List l = rnrService
					.getRecords("select sequence_next_hi_value from UNID where unidKey = 'nominationId'");
			Integer maxNominationId = 1;
			if (l.size() > 0)
				maxNominationId = ((Integer)l.get(0));

			List listAward = rnrService
					.getResultsBySQL("select id from Award where awardName='"
							+ request.getParameter(AWARDID) + "'");

			List<WorkflowLevelView> workflowLevel1 = (List<WorkflowLevelView>) rnrService
					.getRecordsBySQL(
							"select wl.MEM_LVL1 as memberLevel, wl.PANEL_ID1 as panelId, wl.EMAIL_FL1 as emailFl from workflowlevels wl, workflow w, "
									+ " awardcriteria ac where w.WORKFLOW_ID = wl.WORKFLOW_ID and ac.AWARD_CRITERIA_ID = wl.AWARD_CRITERIA_ID and "
									+ "ac.AWARD_ID = "
									+ (long) listAward.get(0)
									+ " and wl.ENABLED1 = 'Y'",
							WorkflowLevelView.class);

			ArrayList<NominationPanel> np = new ArrayList<NominationPanel>();

			if (workflowLevel1.size() > 0) {
				if (workflowLevel1.get(0).getMemberLevel() == 1) {
					List<PanelMembers> panelMembers = (List<PanelMembers>) rnrService
							.getResultsBySQL("from PanelMembers where panelId="
									+ workflowLevel1.get(0).getPanelId());
					for (PanelMembers panelMember : panelMembers) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(1);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(panelMember.getPanelId());
						nomPanel.setPanelGroupMemberId(panelMember
								.getMemberUID());
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}

				} else {
					List<Member> member = (List<Member>) rnrService
							.getResultsBySQL("from Member m1 where m1.employeeName in (select m."
									+ CommonBean.getBeanName(workflowLevel1
											.get(0).getMemberLevel())
									+ " from Member m where m.employeeId = '"
									+ request.getParameter("emplId") + "')");

					if (member.size() > 0) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(1);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(0);
						nomPanel.setPanelGroupMemberId(member.get(0).getMemberEmail().substring(0, member.get(0).getMemberEmail().indexOf('@')));
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}
				}
			}

			List<WorkflowLevelView> workflowLevel2 = (List<WorkflowLevelView>) rnrService
					.getRecordsBySQL(
							"select wl.MEM_LVL2 as memberLevel, wl.PANEL_ID2 as panelId, wl.EMAIL_FL2 as emailFl from workflowlevels wl, workflow w, "
									+ " awardcriteria ac where w.WORKFLOW_ID = wl.WORKFLOW_ID and ac.AWARD_CRITERIA_ID = wl.AWARD_CRITERIA_ID and "
									+ "ac.AWARD_ID = "
									+ (long) listAward.get(0)
									+ " and wl.ENABLED2 = 'Y'",
							WorkflowLevelView.class);

			if (workflowLevel1.size() > 0) {
				if (workflowLevel2.get(0).getMemberLevel() == 1) {
					List<PanelMembers> panelMembers = (List<PanelMembers>) rnrService
							.getResultsBySQL("from PanelMembers where panelId="
									+ workflowLevel2.get(0).getPanelId());
					for (PanelMembers panelMember : panelMembers) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(2);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(panelMember.getPanelId());
						nomPanel.setPanelGroupMemberId(panelMember
								.getMemberUID());
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}

				} else {
					List<Member> member = (List<Member>) rnrService
							.getResultsBySQL("from Member m1 where m1.employeeName in (select m."
									+ CommonBean.getBeanName(workflowLevel2
											.get(0).getMemberLevel())
									+ " from Member m where m.employeeId = '"
									+ request.getParameter("emplId") + "')");
					if (member.size() > 0) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(2);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(0);
						nomPanel.setPanelGroupMemberId(member.get(0).getMemberEmail().substring(0, member.get(0).getMemberEmail().indexOf('@')));
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}
				}
			}

			List<WorkflowLevelView> workflowLevel3 = (List<WorkflowLevelView>) rnrService
					.getRecordsBySQL(
							"select wl.MEM_LVL3 as memberLevel, wl.PANEL_ID3 as panelId, wl.EMAIL_FL3 as emailFl from workflowlevels wl, workflow w, "
									+ " awardcriteria ac where w.WORKFLOW_ID = wl.WORKFLOW_ID and ac.AWARD_CRITERIA_ID = wl.AWARD_CRITERIA_ID and "
									+ "ac.AWARD_ID = "
									+ (long) listAward.get(0)
									+ " and wl.ENABLED3 = 'Y'",
							WorkflowLevelView.class);

			if (workflowLevel3.size() > 0) {
				if (workflowLevel3.get(0).getMemberLevel() == 1) {
					List<PanelMembers> panelMembers = (List<PanelMembers>) rnrService
							.getResultsBySQL("from PanelMembers where panelId="
									+ workflowLevel3.get(0).getPanelId());
					for (PanelMembers panelMember : panelMembers) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(3);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(panelMember.getPanelId());
						nomPanel.setPanelGroupMemberId(panelMember
								.getMemberUID());
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}

				} else {
					System.err.println("level 3=" + CommonBean.getBeanName(workflowLevel3.get(0).getMemberLevel()));
					System.err.println("level 3==" + workflowLevel3.get(0).getMemberLevel());
					List<Member> member = (List<Member>) rnrService
							.getResultsBySQL("from Member m1 where m1.employeeName in (select m."
									+ CommonBean.getBeanName(workflowLevel3
											.get(0).getMemberLevel())
									+ " from Member m where m.employeeId = '"
									+ request.getParameter("emplId") + "')");
					if (member.size() > 0) {

						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(3);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(0);
						nomPanel.setPanelGroupMemberId(member.get(0).getMemberEmail().substring(0, member.get(0).getMemberEmail().indexOf('@')));
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}
				}
			}

			List<WorkflowLevelView> workflowLevel4 = (List<WorkflowLevelView>) rnrService
					.getRecordsBySQL(
							"select wl.MEM_LVL4 as memberLevel, wl.PANEL_ID4 as panelId, wl.EMAIL_FL4 as emailFl from workflowlevels wl, workflow w, "
									+ " awardcriteria ac where w.WORKFLOW_ID = wl.WORKFLOW_ID and ac.AWARD_CRITERIA_ID = wl.AWARD_CRITERIA_ID and "
									+ "ac.AWARD_ID = "
									+ (long) listAward.get(0)
									+ " and wl.ENABLED4 = 'Y'",
							WorkflowLevelView.class);

			if (workflowLevel4.size() > 0) {
				if (workflowLevel4.get(0).getMemberLevel() == 1) {
					List<PanelMembers> panelMembers = (List<PanelMembers>) rnrService
							.getResultsBySQL("from PanelMembers where panelId="
									+ workflowLevel4.get(0).getPanelId());
					for (PanelMembers panelMember : panelMembers) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(4);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(panelMember.getPanelId());
						nomPanel.setPanelGroupMemberId(panelMember
								.getMemberUID());
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}

				} else {
					List<Member> member = (List<Member>) rnrService
							.getResultsBySQL("from Member m1 where m1.employeeName in (select m."
									+ CommonBean.getBeanName(workflowLevel4
											.get(0).getMemberLevel())
									+ " from Member m where m.employeeId = '"
									+ request.getParameter("emplId") + "')");
					if (member.size() > 0) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(4);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(0);
						nomPanel.setPanelGroupMemberId(member.get(0).getMemberEmail().substring(0, member.get(0).getMemberEmail().indexOf('@')));
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}
				}
			}

			List<WorkflowLevelView> workflowLevel5 = (List<WorkflowLevelView>) rnrService
					.getRecordsBySQL(
							"select wl.MEM_LVL5 as memberLevel, wl.PANEL_ID5 as panelId, wl.EMAIL_FL5 as emailFl from workflowlevels wl, workflow w, "
									+ " awardcriteria ac where w.WORKFLOW_ID = wl.WORKFLOW_ID and ac.AWARD_CRITERIA_ID = wl.AWARD_CRITERIA_ID and "
									+ "ac.AWARD_ID = "
									+ (long) listAward.get(0)
									+ " and wl.ENABLED5 = 'Y'",
							WorkflowLevelView.class);

			if (workflowLevel5.size() > 0) {
				if (workflowLevel5.get(0).getMemberLevel() == 1) {
					List<PanelMembers> panelMembers = (List<PanelMembers>) rnrService
							.getResultsBySQL("from PanelMembers where panelId="
									+ workflowLevel5.get(0).getPanelId());
					for (PanelMembers panelMember : panelMembers) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(5);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(panelMember.getPanelId());
						nomPanel.setPanelGroupMemberId(panelMember
								.getMemberUID());
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}

				} else {
					List<Member> member = (List<Member>) rnrService
							.getResultsBySQL("from Member m1 where m1.employeeName in (select m."
									+ CommonBean.getBeanName(workflowLevel5
											.get(0).getMemberLevel())
									+ " from Member m where m.employeeId = '"
									+ request.getParameter("emplId") + "')");

					if (member.size() > 0) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(5);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(0);
						nomPanel.setPanelGroupMemberId(member.get(0).getMemberEmail().substring(0, member.get(0).getMemberEmail().indexOf('@')));
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}
				}
			}

			List<WorkflowLevelView> workflowLevel6 = (List<WorkflowLevelView>) rnrService
					.getRecordsBySQL(
							"select wl.MEM_LVL6 as memberLevel, wl.PANEL_ID6 as panelId, wl.EMAIL_FL6 as emailFl from workflowlevels wl, workflow w, "
									+ " awardcriteria ac where w.WORKFLOW_ID = wl.WORKFLOW_ID and ac.AWARD_CRITERIA_ID = wl.AWARD_CRITERIA_ID and "
									+ "ac.AWARD_ID = "
									+ (long) listAward.get(0)
									+ " and wl.ENABLED6 = 'Y'",
							WorkflowLevelView.class);

			if (workflowLevel6.size() > 0) {
				if (workflowLevel6.get(0).getMemberLevel() == 1) {
					List<PanelMembers> panelMembers = (List<PanelMembers>) rnrService
							.getResultsBySQL("from PanelMembers where panelId="
									+ workflowLevel6.get(0).getPanelId());
					for (PanelMembers panelMember : panelMembers) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(6);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(panelMember.getPanelId());
						nomPanel.setPanelGroupMemberId(panelMember
								.getMemberUID());
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}

				} else {
					List<Member> member = (List<Member>) rnrService
							.getResultsBySQL("from Member m1 where m1.employeeName in (select m."
									+ CommonBean.getBeanName(workflowLevel6
											.get(0).getMemberLevel())
									+ " from Member m where m.employeeId = '"
									+ request.getParameter("emplId") + "')");
					if (member.size() > 0) {
						NominationPanel nomPanel = new NominationPanel();
						nomPanel.setLevel(6);
						nomPanel.setNominationId(maxNominationId);
						nomPanel.setNominationPanelId(0);
						nomPanel.setPanelGroupMemberId(member.get(0).getMemberEmail().substring(0, member.get(0).getMemberEmail().indexOf('@')));
						nomPanel.setRowVersionNo(1);
						np.add(nomPanel);
					}
				}
			}
			
			Nomination nom = new Nomination();
			nom.setAwardId((long) listAward.get(0));
			nom.setCitation(request.getParameter("citation"));
			nom.setEmployeeId(request.getParameter("emplId"));
			nom.setProjectName(request.getParameter("projectDesc"));
			nom.setNominationPhase(1);
			nom.setFY(Integer.parseInt((String) request.getParameter("FY")));
			nom.setQuarter(Integer.parseInt((String) request
					.getParameter("QTR")));
			nom.setNominationPhase(1);
			nom.setNominatedBy((String) session.getAttribute("memberId"));

			ArrayList<NominationForm> list = new ArrayList<NominationForm>();

			while (request.getParameter("nomText1Line" + i) != null) {
				NominationForm nominationForm = new NominationForm();
				nominationForm.setInputText1(request
						.getParameter("nomText1Line" + i));
				nominationForm.setInputText2(request
						.getParameter("nomText2Line" + i));
				nominationForm.setScore(0.0);
				nominationForm.setNominationId(maxNominationId);
				list.add(nominationForm);
				i++;
			}
			rnrService.addNominationForm(nom, list, np);

		} catch (Exception ex) {
			ex.printStackTrace();
			return "redirect:homeDashBoard.cgi?nom=2";
		}
		return "redirect:homeDashBoard.cgi?nom=1";
	}

	@RequestMapping(value = "/nominatationWizard.cgi", method = RequestMethod.GET)
	public String nominationSearch(Locale locale, Model model,
			HttpSession session) {
		return commonBean.navigate("NOTSUPPORTED", session, model,
				rnrService);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/Individual.cgi", method = RequestMethod.GET)
	public String individualNominationSearch(Locale locale, Model model,
			HttpSession session) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		if (session.getAttribute("listOfAwards") != null
				&& ((Map) session.getAttribute("listOfAwards")).size() > 0)
			model.addAttribute("awards", (List) ((Map<String, List>) session
					.getAttribute("listOfAwards")).get("Individual"));
		return commonBean.navigate("NOMINFSTEP1", session, model,
				rnrService);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/Team.cgi", method = RequestMethod.GET)
	public String teamNominationSearch(Locale locale, Model model,
			HttpSession session) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		if (session.getAttribute("listOfAwards") != null
				&& ((Map) session.getAttribute("listOfAwards")).size() > 0)
			model.addAttribute("listOfAwardsModel",
					(List) ((Map<String, List>) session
							.getAttribute("listOfAwards")).get("Team"));
		return commonBean.navigate("NOMTEAMFSTEP1", session, model,
				rnrService);
	}

	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/nominateWizard.cgi", method = RequestMethod.GET)
	public String nominationSearch(@RequestParam String emplId, Locale locale,
			Model model, HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";

		try {
			List<Member> list = (List<Member>) rnrService
					.getObjectsByMemberNameorId(null, emplId);
			Member member = list.get(0);
			model.addAttribute("emplId", emplId);
			model.addAttribute("emplName", member.getEmployeeName());
			model.addAttribute("member", ((List<Member>) rnrService
					.getObjectsByMemberNameorId(null,
							(String) request.getParameter("emplId"))).get(0));

		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return commonBean.navigate("ERR", session, model, rnrService);
		}
		model.addAttribute(AWARDID, request.getParameter(AWARDID));
		return commonBean.navigate(
				"NOM"
						+ ((String) request.getParameter(AWARDID))
								.toUpperCase(), session, model, rnrService);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/nominationSearch.cgi", method = RequestMethod.POST)
	public String searchEmployeePost(@RequestParam String emplId,
			@RequestParam String emplName, Locale locale, Model model,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		try {

			StringBuffer memberSql = new StringBuffer();
			memberSql.append("from Member where vertical = '")
					.append((String) session.getAttribute("vertical"))
					.append("' and ").append(" employeeName like '%")
					.append(emplName == null ? "" : emplName).append("%'")
					.append(" and ").append(" employeeId like '%")
					.append(emplId == null ? "" : emplId).append("%'");

			List<Award> listAward = (List<Award>) rnrService
					.getResultsBySQL("from Award where awardName='"
							+ request.getParameter(AWARDID) + "'");
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

			model.addAttribute("searchMemberDeatils", (List<Member>) rnrService
					.getResultsBySQL(memberSql.toString()));
			model.addAttribute("aType", request.getParameter("aType"));
			model.addAttribute(AWARDID, request.getParameter(AWARDID));
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return commonBean.navigate("ERR", session, model, rnrService);
		}
		return commonBean.navigate("NOMSEARCHRES", session, model,
				rnrService);
	}

	@RequestMapping(value = "/nominationSearch.cgi", method = RequestMethod.GET)
	public String searchEmployeeGet(Locale locale, Model model,
			HttpSession session) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		return commonBean.navigate("NOTSUPPORTED", session, model,
				rnrService);
	}

	@RequestMapping(value = "/awardGuidelines.cgi", method = RequestMethod.GET)
	public String nsr1(ServletRequest request, Locale locale, Model model,
			HttpSession session) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		model.addAttribute("emplId", request.getParameter("emplId"));
		model.addAttribute(AWARDID, request.getParameter(AWARDID));
		return commonBean.navigate(
				"GUIDE" + request.getParameter(AWARDID).toUpperCase(),
				session, model, rnrService);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/viewNomination.cgi", method = RequestMethod.GET)
	public String viewNominationGet(Locale locale, Model model,
			ServletRequest request, HttpSession session) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		String awardName = "";
		try {
			int id;
			if (request.getParameter("id") != null) {
				id = Integer.parseInt(request.getParameter("id"));
			} else if (request.getParameter("iid") != null) {
				model.addAttribute("userDashboard", "yes");
				id = Integer.parseInt(request.getParameter("iid"));
			} else {
				return "redirect:userDashboard.cgi";
			}
			List nom = rnrService
					.getResultsBySQL("select award.awardName, nom.citation from Nomination nom, Award award where nom.awardId = award.id and nom.id="
							+ id);
			model.addAttribute("citation", ((Object[]) nom.get(0))[1]);
			model.addAttribute("nominationId", id);
			awardName = (String) ((Object[]) nom.get(0))[0];

			List nomForm = rnrService
					.getResultsBySQL("select inputText1, inputText2 from NominationForm where nominationId="
							+ id);
			int i = 1;
			for (Object l : nomForm) {
				Object[] obj = (Object[]) l;
				model.addAttribute("nomText1Line" + i, obj[0]);
				model.addAttribute("nomText2Line" + i++, obj[1]);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return commonBean.navigate("ERR", session, model, rnrService);
		}
		return commonBean.navigate("VIEW" + awardName.toUpperCase(),
				session, model, rnrService);
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/voteNomination.cgi", method = RequestMethod.GET)
	public String voteNominationGet(Locale locale, Model model,
			ServletRequest request, HttpSession session) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		String awardName = "";
		try {
			int id;
			if (request.getParameter("id") != null) {
				id = Integer.parseInt(request.getParameter("id"));
			} else if (request.getParameter("iid") != null) {
				model.addAttribute("userDashboard", "yes");
				id = Integer.parseInt(request.getParameter("iid"));
			} else {
				return "redirect:userDashboard.cgi";
			}
			List nom = rnrService
					.getResultsBySQL("select award.awardName, nom.citation from Nomination nom, Award award where nom.awardId = award.id and nom.id="
							+ id);
			model.addAttribute("citation", ((Object[]) nom.get(0))[1]);
			model.addAttribute("nominationId", id);
			awardName = (String) ((Object[]) nom.get(0))[0];

			List nomForm = rnrService
					.getResultsBySQL("select inputText1, inputText2 from NominationForm where nominationId="
							+ id);
			int i = 1;
			for (Object l : nomForm) {
				Object[] obj = (Object[]) l;
				model.addAttribute("nomText1Line" + i, obj[0]);
				model.addAttribute("nomText2Line" + i++, obj[1]);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return commonBean.navigate("ERR", session, model, rnrService);
		}
		return commonBean.navigate("VOTE" + awardName.toUpperCase(),
				session, model, rnrService);
	}

	@RequestMapping(value = "/viewNomination.cgi", method = RequestMethod.POST)
	public String viewNominationPost(Locale locale, Model model,
			ServletRequest request, HttpSession session) {
		return commonBean.navigate("NOTSUPPORTED", session, model,
				rnrService);
	}
}
