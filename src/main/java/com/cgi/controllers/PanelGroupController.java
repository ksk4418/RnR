package com.cgi.controllers;

import java.util.Date;
import java.util.List;
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

import com.cgi.panel.Panel;
import com.cgi.panel.PanelMembers;
import com.cgi.panel.PanelMembersView;
import com.cgi.service.RNRService;

@Controller
public class PanelGroupController {
	@SuppressWarnings("rawtypes")
	@Autowired
	public RNRService rnrService;

	@Autowired
	public CommonBean commonBean;

	// Panel
	@RequestMapping(value = "/PANEL.cgi", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		return commonBean.navigate("PANEL", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getPanel", method = RequestMethod.POST)
	@ResponseBody
	public Map getPanel(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"Panel", "panelName");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdatePanel.cgi", method = RequestMethod.POST)
	public String insertPanel(Locale locale, Model model, HttpSession session,
			HttpServletRequest request) {
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
				Panel panel = new Panel();

				panel.setAutoGenerate(request.getParameter("autoGenerate")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				panel.setMinExpRequired(Integer.parseInt(request
						.getParameter("minExpRequired")));
				panel.setPanelDescription(request
						.getParameter("panelDescription"));
				panel.setPanelName(request.getParameter("panelName"));
				panel.setTitleGroup(Integer.parseInt(request
						.getParameter("titleGroup")));
				panel.setTreshold(Integer.parseInt(request
						.getParameter("treshold")));

				panel.setLastUpdateDate(new Date());
				panel.setLastUpdateUID((String) session.getAttribute("UID"));
				panel.setRowVersionNumber(1);

				if (panel.getPanelName() == null || panel.getTreshold() == 0
						|| panel.getPanelName().trim().length() == 0) {
					model.addAttribute("responseText",
							"Error: Panel name and threshold are mandatory fields");
					return "commonPages/ajaxCallResponse";
				}
				if (rnrService.getObjectsByColumn("panelName",
						panel.getPanelName(), Panel.class).size() == 0) {
					rnrService.insert(panel);
					model.addAttribute("responseText",
							"Panel Group '" + panel.getPanelName()
									+ "' added successfully");
				} else
					model.addAttribute("responseText", "Error: Panel Group '"
							+ panel.getPanelName() + "' already exists");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				Panel panel = new Panel();

				panel.setAutoGenerate(request.getParameter("autoGenerate")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				panel.setMinExpRequired(Integer.parseInt(request
						.getParameter("minExpRequired")));
				panel.setPanelDescription(request
						.getParameter("panelDescription"));
				panel.setPanelName(request.getParameter("panelName"));
				panel.setTitleGroup(Integer.parseInt(request
						.getParameter("titleGroup")));
				panel.setTreshold(Integer.parseInt(request
						.getParameter("treshold")));

				panel.setLastUpdateDate(new Date());
				panel.setLastUpdateUID((String) session.getAttribute("UID"));
				panel.setRowVersionNumber(1);

				panel.setPanelId(Integer.parseInt(request.getParameter("id")));

				rnrService.update(panel);
				model.addAttribute("responseText",
						"Panel Group '" + panel.getPanelName()
								+ "' updated successfully");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				Panel panel = new Panel();

				panel.setAutoGenerate(request.getParameter("autoGenerate")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				panel.setMinExpRequired(Integer.parseInt(request
						.getParameter("minExpRequired")));
				panel.setPanelDescription(request
						.getParameter("panelDescription"));
				panel.setPanelName(request.getParameter("panelName"));
				panel.setTitleGroup(Integer.parseInt(request
						.getParameter("titleGroup")));
				panel.setTreshold(Integer.parseInt(request
						.getParameter("treshold")));

				panel.setLastUpdateDate(new Date());
				panel.setLastUpdateUID((String) session.getAttribute("UID"));
				panel.setRowVersionNumber(1);

				panel.setPanelId(Integer.parseInt(request.getParameter("id")));

				rnrService.delete(panel);
				model.addAttribute("responseText",
						"Panel Group '" + panel.getPanelName()
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

	// PanelMembers
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/PANELMEM.cgi", method = RequestMethod.GET)
	public String panelMembersHome(Locale locale, Model model,
			HttpSession session) {
		try {
			model.addAttribute("Panel",
					(List<Panel>) rnrService.getRecordsByTable("Panel"));
			model.addAttribute("Member", (List<Panel>) rnrService
					.getResultsBySQL("from Member where vertical = '"
							+ session.getAttribute("vertical")
							+ "' order by employeeName"));
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return "commonPages/ajaxCallResponse";
		}
		return commonBean.navigate("PANELMEM", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getPanelMembers", method = RequestMethod.POST)
	@ResponseBody
	public Map getPanelMembers(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"PanelMembers", "memberUID", "MEMBER_UID",
				RefTablesSQLCont.PANEL_MEMBERS.toString(),
				PanelMembersView.class, null, null);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdatePanelMembers.cgi", method = RequestMethod.POST)
	public String insertPanelMember(Locale locale, Model model,
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

				PanelMembers panelMembers = new PanelMembers();

				panelMembers.setMemberUID((request.getParameter("memberUID"))
						.substring(0, request.getParameter("memberUID")
								.lastIndexOf("@")));
				panelMembers.setPanelId(Long.parseLong(request
						.getParameter("panelId")));

				panelMembers.setLastUpdateDate(new Date());
				panelMembers.setLastUpdateUID((String) session
						.getAttribute("UID"));
				panelMembers.setRowVersionNumber(1);

				if (rnrService.getObjectsByColumn(
						new String[] { "panelId", "memberUID" },
						new Object[] { panelMembers.getPanelId(),
								panelMembers.getMemberUID() },
						PanelMembers.class).size() == 0) {
					rnrService.insert(panelMembers);
					model.addAttribute("responseText", "Panel member '"
							+ panelMembers.getMemberUID()
							+ "' added successfully");
				} else
					model.addAttribute("responseText", "Error: Panel member '"
							+ panelMembers.getMemberUID() + "' already exists");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				PanelMembers panelMembers = new PanelMembers();

				panelMembers.setMemberUID((request.getParameter("memberUID"))
						.substring(0, request.getParameter("memberUID")
								.lastIndexOf("@")));
				panelMembers.setPanelId(Long.parseLong(request
						.getParameter("panelId")));

				panelMembers.setLastUpdateDate(new Date());
				panelMembers.setLastUpdateUID((String) session
						.getAttribute("UID"));
				panelMembers.setRowVersionNumber(1);

				panelMembers.setPanelMemberId(Integer.parseInt(request
						.getParameter("id")));

				rnrService.update(panelMembers);
				model.addAttribute("responseText", "Panel member '"
						+ panelMembers.getMemberUID()
						+ "' updated successfully");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				PanelMembers panelMembers = new PanelMembers();

				panelMembers.setMemberUID((request.getParameter("memberUID"))
						.substring(0, request.getParameter("memberUID")
								.lastIndexOf("@")));
				panelMembers.setPanelId(Long.parseLong(request
						.getParameter("panelId")));

				panelMembers.setLastUpdateDate(new Date());
				panelMembers.setLastUpdateUID((String) session
						.getAttribute("UID"));
				panelMembers.setRowVersionNumber(1);

				panelMembers.setPanelMemberId(Integer.parseInt(request
						.getParameter("id")));

				rnrService.delete(panelMembers);
				model.addAttribute("responseText", "Panel Member '"
						+ panelMembers.getMemberUID()
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
