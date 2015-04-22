package com.cgi.controllers;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cgi.rnr.common.RefTablesSQLCont;
import cgi.rnr.workflow.WorkFlow;
import cgi.rnr.workflow.WorkFlowLevels;
import cgi.rnr.workflow.WorkFlowLevelsView;

import com.cgi.service.RNRService;

@Controller
public class WorkFlowController {

	@SuppressWarnings("rawtypes")
	@Autowired
	public RNRService rnrService;

	@Autowired
	public CommonBean commonBean;

	// WorkFlow
	@RequestMapping(value = "/WKFLOW.cgi", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		return commonBean.navigate("WKFLOW", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getWorkFlow", method = RequestMethod.POST)
	@ResponseBody
	public Map getWorkFlow( HttpSession session,
			 HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session,  request,
				rnrService, "WorkFlow", "workFlowName");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateWorkFlow.cgi", method = RequestMethod.POST)
	public String insertWorkFlow(Locale locale, Model model,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute("responseText", "Session Expired");
			return "commonPages/ajaxCallResponse";
		}
		try {
			if (request.getParameter("action") == null) {
				model.addAttribute("responseText", "Invalid Request");
				return "commonPages/ajaxCallResponse";
			}
			if (request.getParameter("action").equalsIgnoreCase("1")) { // Action
																		// Add
				WorkFlow wf = new WorkFlow();
				wf.setActiveFl(request.getParameter("activeFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				wf.setWorkFlowDesc(request.getParameter("workFlowDesc"));
				wf.setWorkFlowName(request.getParameter("workFlowName"));

				wf.setLastUpdateDate(new Date());
				wf.setLastUpdateUID((String) session.getAttribute("UID"));
				wf.setRowVersionNumber(1);

				if (wf.getWorkFlowName() == null
						|| wf.getWorkFlowName().trim().length() == 0) {
					model.addAttribute("responseText",
							"Error: Worflow name is mandatory field");
					return "commonPages/ajaxCallResponse";
				}
				if (rnrService.getObjectsByColumn("workFlowName",
						wf.getWorkFlowName(), WorkFlow.class).size() == 0) {
					rnrService.insert(wf);
					model.addAttribute("responseText",
							"Worflow '" + wf.getWorkFlowName()
									+ "' added successfully");
				} else
					model.addAttribute("responseText",
							"Error: Workflow '" + wf.getWorkFlowName()
									+ "' already exists");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				WorkFlow wf = new WorkFlow();
				wf.setActiveFl(request.getParameter("activeFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				wf.setWorkFlowDesc(request.getParameter("workFlowDesc"));
				wf.setWorkFlowName(request.getParameter("workFlowName"));

				wf.setLastUpdateDate(new Date());
				wf.setLastUpdateUID((String) session.getAttribute("UID"));
				wf.setRowVersionNumber(1);
				wf.setId(request.getParameter("id").toString().trim().isEmpty()? 0L :
							Long.parseLong(request.getParameter("id").toString().trim()));

				rnrService.update(wf);
				model.addAttribute("responseText",
						"Workflow '" + wf.getWorkFlowName()
								+ "' updated successfully");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				WorkFlow wf = new WorkFlow();
				wf.setActiveFl(request.getParameter("activeFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				wf.setWorkFlowDesc(request.getParameter("workFlowDesc"));
				wf.setWorkFlowName(request.getParameter("workFlowName"));

				wf.setLastUpdateDate(new Date());
				wf.setLastUpdateUID((String) session.getAttribute("UID"));
				wf.setRowVersionNumber(1);
				wf.setId(Long.parseLong(request.getParameter("id").toString()
						.trim()));
				rnrService.delete(wf);
				model.addAttribute("responseText",
						"Workflow '" + wf.getWorkFlowName()
								+ "' deleted successfully");
				return "commonPages/ajaxCallResponse";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return "commonPages/ajaxCallResponse";
		}
		model.addAttribute("responseText", "Error occured, try again");
		return "commonPages/ajaxCallResponse";
	}

	// WorkFlowLevels
	@RequestMapping(value = "/WKFLOWLVL.cgi", method = RequestMethod.GET)
	public String workFlowLevelsHome(Locale locale, Model model,
			HttpSession session) {
		try {
			model.addAttribute("Panel", rnrService.getRecordsByTable("Panel"));
			model.addAttribute("WorkFlow",
					rnrService.getRecordsByTable("WorkFlow"));
			model.addAttribute("AwardCriteria",
					rnrService.getRecordsByTable("AwardCriteria"));
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			try {
				return rnrService.getPage("ERR");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return commonBean.navigate("WKFLOWLVL", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getWorkFlowLevels", method = RequestMethod.POST)
	@ResponseBody
	public Map getWorkFlowLevels(HttpSession session,
			HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"WorkFlowLevels", "workFlowLevelName", "LEVEL_NM",
				RefTablesSQLCont.WRKFLOWLVL.toString(),
				WorkFlowLevelsView.class, null, null);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateWorkflowLVL.cgi", method = RequestMethod.POST)
	public String insertWorkFlowLevel(Locale locale, Model model,
			HttpSession session, HttpServletRequest request) {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute("responseText", "Session Expired");
			return "commonPages/ajaxCallResponse";
		}
		try {
			if (request.getParameter("action") == null) {
				model.addAttribute("responseText", "Invalid Request");
				return "commonPages/ajaxCallResponse";
			}
			if (request.getParameter("action").equalsIgnoreCase("1")) { // Action
																		// Add
				WorkFlowLevels wfl = new WorkFlowLevels();

				wfl.setWorkFlowLevelName(request
						.getParameter("workFlowLevelName"));
				wfl.setWorkFlowId(request.getParameter("workFlowId").isEmpty()? 0L :
							Long.parseLong(request.getParameter("workFlowId")));
				wfl.setAwardCriteriaId(request.getParameter("awardCriteriaId").isEmpty()? 0L :
							Long.parseLong(request.getParameter("awardCriteriaId")));
				wfl.setLastUpdateDate(new Date());
				wfl.setLastUpdateUID((String) session.getAttribute("UID"));
				wfl.setRowVersionNumber(1);

				wfl.setEnableFl1(request.getParameter("Enable1")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				wfl.setMemberLevel1(request.getParameter("memRole1").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole1")));
				
				wfl.setPanelId1(request.getParameter("panelId1").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId1")));
				
				wfl.setEmailFlag1(request.getParameter("emailFlag1")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl2(request.getParameter("Enable2")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel2(request.getParameter("memRole2").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole2")));
				
				wfl.setPanelId2(request.getParameter("panelId2").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId2")));
				
				wfl.setEmailFlag2(request.getParameter("emailFlag2")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl3(request.getParameter("Enable3")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel3(request.getParameter("memRole3").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole3")));
				
				wfl.setPanelId3(request.getParameter("panelId3").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId3")));
				
				wfl.setEmailFlag3(request.getParameter("emailFlag3")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl4(request.getParameter("Enable4")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel4(request.getParameter("memRole4").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole4")));
				
				wfl.setPanelId4(request.getParameter("panelId4").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId4")));
				
				wfl.setEmailFlag4(request.getParameter("emailFlag4")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl5(request.getParameter("Enable5")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel5(request.getParameter("memRole5").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole5")));
				
				wfl.setPanelId5(request.getParameter("panelId5").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId5")));
				
				wfl.setEmailFlag5(request.getParameter("emailFlag5")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl6(request.getParameter("Enable6")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel6(request.getParameter("memRole6").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole6")));
				
				wfl.setPanelId6(request.getParameter("panelId6").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId6")));
				
				wfl.setEmailFlag6(request.getParameter("emailFlag6")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				if (wfl.getWorkFlowLevelName() == null
						|| wfl.getWorkFlowLevelName().trim().length() == 0
						|| wfl.getWorkFlowId() == 0
						| wfl.getAwardCriteriaId() == 0) {
					model.addAttribute("responseText",
							"Error: Worflow Level name, WorkFlow and Award Criteia are mandatory field");
					return "commonPages/ajaxCallResponse";
				}
				if (rnrService.getObjectsByColumn(
						new String[] { "workFlowId", "awardCriteriaId" },
						new Object[] { wfl.getWorkFlowId(),
								wfl.getAwardCriteriaId() },
						WorkFlowLevels.class).size() == 0) {
					rnrService.insert(wfl);
					model.addAttribute("responseText",
							"Worflow level '" + wfl.getWorkFlowLevelName()
									+ "' added successfully");
				} else
					model.addAttribute("responseText", "Error: Workflow '"
							+ wfl.getWorkFlowLevelName() + "' already exists");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				WorkFlowLevels wfl = new WorkFlowLevels();

				wfl.setWorkFlowLevelName(request
						.getParameter("workFlowLevelName"));
				
				wfl.setWorkFlowId(request.getParameter("workFlowId").isEmpty()? 0L :
							Long.parseLong(request.getParameter("workFlowId")));
				
				wfl.setAwardCriteriaId(request.getParameter("awardCriteriaId").isEmpty()? 0L :
							Long.parseLong(request.getParameter("awardCriteriaId")));
				
				wfl.setLastUpdateDate(new Date());
				
				wfl.setLastUpdateUID((String) session.getAttribute("UID"));
				
				wfl.setRowVersionNumber(1);

				wfl.setEnableFl1(request.getParameter("Enable1")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel1(request.getParameter("memRole1").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole1")));
				
				wfl.setPanelId1(request.getParameter("panelId1").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId1")));
				
				wfl.setEmailFlag1(request.getParameter("emailFlag1")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl2(request.getParameter("Enable2")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel2(request.getParameter("memRole2").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole2")));
				
				wfl.setPanelId2(request.getParameter("panelId2").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId2")));
				
				wfl.setEmailFlag2(request.getParameter("emailFlag2")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl3(request.getParameter("Enable3")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel3(request.getParameter("memRole3").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole3")));
				
				wfl.setPanelId3(request.getParameter("panelId3").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId3")));
				
				wfl.setEmailFlag3(request.getParameter("emailFlag3")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl4(request.getParameter("Enable4")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel4(request.getParameter("memRole4").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole4")));
				
				wfl.setPanelId4(request.getParameter("panelId4").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId4")));
				
				wfl.setEmailFlag4(request.getParameter("emailFlag4")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl5(request.getParameter("Enable5")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel5(request.getParameter("memRole5").isEmpty()? 0:
							Integer.parseInt(request.getParameter("memRole5")));
				
				wfl.setPanelId5(request.getParameter("panelId5").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId5")));
				
				wfl.setEmailFlag5(request.getParameter("emailFlag5")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl6(request.getParameter("Enable6")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				
				wfl.setMemberLevel6(request.getParameter("memRole6").isEmpty()? 0 :
							Integer.parseInt(request.getParameter("memRole6")));
				
				wfl.setPanelId6(request.getParameter("panelId6").isEmpty()? 0L :
					Long.parseLong(request.getParameter("panelId6")));
				
				wfl.setEmailFlag6(request.getParameter("emailFlag6")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setWorkFlowLevelsId(request.getParameter("id").toString().trim().isEmpty()? 0L :
							Long.parseLong(request.getParameter("id").toString().trim()));

				rnrService.update(wfl);
				
				model.addAttribute("responseText", "Workflow level name '"
						+ wfl.getWorkFlowLevelName() + "' updated successfully");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				WorkFlowLevels wfl = new WorkFlowLevels();

				wfl.setWorkFlowLevelName(request
						.getParameter("workFlowLevelName"));
				wfl.setWorkFlowId(Long.parseLong(request
						.getParameter("workFlowId")));
				wfl.setAwardCriteriaId(Long.parseLong(request
						.getParameter("awardCriteriaId")));
				wfl.setLastUpdateDate(new Date());
				wfl.setLastUpdateUID((String) session.getAttribute("UID"));
				wfl.setRowVersionNumber(1);

				wfl.setEnableFl1(request.getParameter("Enable1")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				wfl.setMemberLevel1(Integer.parseInt(request
						.getParameter("memRole1")));
				wfl.setPanelId1(Long.parseLong(request.getParameter("panelId1")));
				wfl.setEmailFlag1(request.getParameter("emailFlag1")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl2(request.getParameter("Enable2")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				wfl.setMemberLevel2(Integer.parseInt(request
						.getParameter("memRole2")));
				wfl.setPanelId2(Long.parseLong(request.getParameter("panelId2")));
				wfl.setEmailFlag2(request.getParameter("emailFlag2")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl3(request.getParameter("Enable3")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				wfl.setMemberLevel3(Integer.parseInt(request
						.getParameter("memRole3")));
				wfl.setPanelId3(Long.parseLong(request.getParameter("panelId3")));
				wfl.setEmailFlag3(request.getParameter("emailFlag3")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl4(request.getParameter("Enable4")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				wfl.setMemberLevel4(Integer.parseInt(request
						.getParameter("memRole4")));
				wfl.setPanelId4(Long.parseLong(request.getParameter("panelId4")));
				wfl.setEmailFlag4(request.getParameter("emailFlag4")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl5(request.getParameter("Enable5")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				wfl.setMemberLevel5(Integer.parseInt(request
						.getParameter("memRole5")));
				wfl.setPanelId5(Long.parseLong(request.getParameter("panelId5")));
				wfl.setEmailFlag5(request.getParameter("emailFlag5")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setEnableFl6(request.getParameter("Enable6")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				wfl.setMemberLevel6(Integer.parseInt(request
						.getParameter("memRole6")));
				wfl.setPanelId6(Long.parseLong(request.getParameter("panelId6")));
				wfl.setEmailFlag6(request.getParameter("emailFlag6")
						.equalsIgnoreCase("true") ? 'Y' : 'N');

				wfl.setWorkFlowLevelsId(Long.parseLong(request
						.getParameter("id").toString().trim()));
				rnrService.delete(wfl);
				model.addAttribute("responseText",
						"Workflow level '" + wfl.getWorkFlowLevelName()
								+ "' deleted successfully");
				return "commonPages/ajaxCallResponse";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return "commonPages/ajaxCallResponse";
		}
		model.addAttribute("responseText", "Error occured, try again");
		return "commonPages/ajaxCallResponse";
	}
}
