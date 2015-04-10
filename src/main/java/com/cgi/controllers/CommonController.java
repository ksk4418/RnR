package com.cgi.controllers;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cgi.rnr.common.FY;
import cgi.rnr.common.Frequency;
import cgi.rnr.common.Quarter;
import cgi.rnr.common.QuarterView;
import cgi.rnr.common.RefTablesSQLCont;

import com.cgi.service.RNRService;

@Controller
public class CommonController {
	@SuppressWarnings("rawtypes")
	@Autowired
	public RNRService rnrService;
	
	@Autowired
	public CommonBean commonBean;

	@RequestMapping(value = "/FREQ.cgi", method = RequestMethod.GET)
	public String frequency(Locale locale, Model model, HttpSession session) {
		return commonBean.navigate("FREQ", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getFrequency", method = RequestMethod.POST)
	@ResponseBody public Map getFrequency(Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session,
				request, rnrService, "Frequency", "frequencyName");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateFrequency.cgi", method = RequestMethod.POST)
	public String insertUpdateFrequency(Locale locale, Model model,
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
				Frequency frequency = new Frequency();
				frequency.setFrequencyDays(Integer.parseInt((request
						.getParameter("frequencyDays"))));
				frequency.setFrequencyDesc(request
						.getParameter("frequencyDesc"));
				frequency.setFrequencyName(request
						.getParameter("frequencyName"));
				frequency.setLastUpdateDate(new Date());
				frequency
						.setLastUpdateUID((String) session.getAttribute("UID"));
				frequency.setRowVersionNumber(1);

				if (frequency.getFrequencyName() == null
						|| frequency.getFrequencyName().trim().length() == 0) {
					model.addAttribute("responseText",
							"Error: Frequency Name is mandatory fields");
					return "commonPages/ajaxCallResponse";
				}

				if (rnrService.getObjectsByColumn("frequencyName",
						frequency.getFrequencyName(), Frequency.class).size() == 0) {
					rnrService.insert(frequency);
					model.addAttribute("responseText", "Frequency '"
							+ frequency.getFrequencyName()
							+ "' added successfully");
				} else
					model.addAttribute("responseText", "Error: Frequency '"
							+ frequency.getFrequencyName() + "' already exists");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				Frequency frequency = new Frequency();
				frequency.setFrequencyDays(Integer.parseInt((request
						.getParameter("frequencyDays"))));
				frequency.setFrequencyDesc(request
						.getParameter("frequencyDesc"));
				frequency.setFrequencyName(request
						.getParameter("frequencyName"));
				frequency.setLastUpdateDate(new Date());
				frequency
						.setLastUpdateUID((String) session.getAttribute("UID"));
				frequency.setRowVersionNumber(1);
				frequency.setId(Long.parseLong(request.getParameter("id")
						.toString().trim()));
				rnrService.update(frequency);
				model.addAttribute("responseText",
						"Frequency '" + frequency.getFrequencyName()
								+ "' updated successfully");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				Frequency frequency = new Frequency();
				frequency.setFrequencyDays(Integer.parseInt((request
						.getParameter("frequencyDays"))));
				frequency.setFrequencyDesc(request
						.getParameter("frequencyDesc"));
				frequency.setFrequencyName(request
						.getParameter("frequencyName"));
				frequency.setLastUpdateDate(new Date());
				frequency
						.setLastUpdateUID((String) session.getAttribute("UID"));
				frequency.setRowVersionNumber(1);
				frequency.setId(Long.parseLong(request.getParameter("id")
						.toString().trim()));
				rnrService.delete(frequency);
				model.addAttribute("responseText",
						"Frequency '" + frequency.getFrequencyName()
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

	// FY
	@RequestMapping(value = "/FY.cgi", method = RequestMethod.GET)
	public String fYhome(Locale locale, Model model, HttpSession session) {
		return commonBean.navigate("FY", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getFY", method = RequestMethod.POST)
	@ResponseBody public Map getFY(Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, 
				request, rnrService, "FY", "FY");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateFY.cgi", method = RequestMethod.POST)
	public String insertUpdateFY(Locale locale, Model model,
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
				FY fy = new FY();
				fy.setFY(request.getParameter("fy"));
				fy.setCloseFl(request.getParameter("close").equalsIgnoreCase(
						"true") ? 'Y' : 'N');
				fy.setOpenFl(request.getParameter("open").equalsIgnoreCase(
						"true") ? 'Y' : 'N');
				fy.setLastUpdateDate(new Date());
				fy.setLastUpdateUID((String) session.getAttribute("UID"));
				fy.setRowVersionNumber(1);

				if (fy.getFY() == null || fy.getFY().trim().length() == 0) {
					model.addAttribute("responseText",
							"Error: Frequency Name is mandatory fields");
					return "commonPages/ajaxCallResponse";
				}

				if (rnrService.getObjectsByColumn("FY", fy.getFY(), FY.class)
						.size() == 0) {
					if(fy.getOpenFl() == 'Y' && fy.getCloseFl() == 'N') {
						rnrService.runUpdateOrDelete("update FY set close_FL = 'Y' where OPEN_FL = 'Y' and CLOSE_FL = 'N'");
						
					}
					rnrService.insert(fy);
					model.addAttribute("responseText",
							"Fiscal year '" + fy.getFY()
									+ "' added successfully");
				} else
					model.addAttribute("responseText", "Error: Fiscal year '"
							+ fy.getFY() + "' already exists");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				FY fy = new FY();
				fy.setFY(request.getParameter("fy"));
				fy.setCloseFl(request.getParameter("close").equalsIgnoreCase(
						"true") ? 'Y' : 'N');
				fy.setOpenFl(request.getParameter("open").equalsIgnoreCase(
						"true") ? 'Y' : 'N');
				fy.setId(Long.parseLong(request.getParameter("id").toString()
						.trim()));
				fy.setLastUpdateDate(new Date());
				fy.setLastUpdateUID((String) session.getAttribute("UID"));
				fy.setRowVersionNumber(1);
				if(fy.getOpenFl() == 'Y' && fy.getCloseFl() == 'N') {
					rnrService.runUpdateOrDelete("update FY set close_FL = 'Y' where OPEN_FL = 'Y' and CLOSE_FL = 'N' and FY_ID <> " + fy.getId());
					
				}
				rnrService.update(fy);
				model.addAttribute("responseText", "Fisacl year '" + fy.getFY()
						+ "' updated successfully");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				FY fy = new FY();
				fy.setFY(request.getParameter("fy"));
				fy.setCloseFl(request.getParameter("close").equalsIgnoreCase(
						"true") ? 'Y' : 'N');
				fy.setOpenFl(request.getParameter("open").equalsIgnoreCase(
						"true") ? 'Y' : 'N');
				fy.setId(Long.parseLong(request.getParameter("id").toString()
						.trim()));
				fy.setLastUpdateDate(new Date());
				fy.setLastUpdateUID((String) session.getAttribute("UID"));
				fy.setRowVersionNumber(1);
				rnrService.delete(fy);
				model.addAttribute("responseText", "Fiscal year '" + fy.getFY()
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

	// Hierarchy
	@RequestMapping(value = "/HIERARCHY.cgi", method = RequestMethod.GET)
	public String hierarchyHome(Locale locale, Model model, HttpSession session) {

		return commonBean.navigate("HIERARCHY", session, model,
				rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getHierarchy", method = RequestMethod.POST)
	@ResponseBody public Map getHierarchy(Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, 
				request, rnrService, "Hierarchy", "name");
	}

	// NominationPhase
	@RequestMapping(value = "/NOMPHASE.cgi", method = RequestMethod.GET)
	public String nominationPhaseHome(Locale locale, Model model,
			HttpSession session) {

		return commonBean
				.navigate("NOMPHASE", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getNominationPhase", method = RequestMethod.POST)
	@ResponseBody public Map getNominationPhase(Model model,
			HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, 
				request, rnrService, "NominationPhase", "name");
	}

	// Quarter
	@RequestMapping(value = "/QTR.cgi", method = RequestMethod.GET)
	public String quarterHome(Locale locale, Model model, HttpSession session) {

		return commonBean.navigate("QTR", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getQuarter", method = RequestMethod.POST)
	@ResponseBody public Map getQuarter(Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request,
				rnrService, "Quarter", "name", "NAME",
				RefTablesSQLCont.QUARTER.toString(), QuarterView.class, null, null);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateQuarter.cgi", method = RequestMethod.POST)
	public String insertUpdateQuarter(Locale locale, Model model,
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
				Quarter quarter = new Quarter();
				quarter.setOpenFl(request.getParameter("open")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				quarter.setCloseFl(request.getParameter("close")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				quarter.setFY(request.getParameter("fy"));
				quarter.setQtr(request.getParameter("qtr"));
				quarter.setName(request.getParameter("quarterName"));
				quarter.setLastUpdateDate(new Date());
				quarter.setLastUpdateUID((String) session.getAttribute("UID"));
				quarter.setRowVersionNumber(1);

				if (quarter.getFY() == null
						|| quarter.getFY().trim().length() == 0
						|| quarter.getQtr() == null
						|| quarter.getQtr().trim().length() == 0) {
					model.addAttribute("responseText",
							"Error: Quarter and fiscal year are mandatory fields");
					return "commonPages/ajaxCallResponse";
				}

				if (rnrService.getObjectsByColumn(new String[] { "FY", "qtr" },
						new Object[] { quarter.getFY(), quarter.getQtr() },
						Quarter.class).size() == 0) {
					if(quarter.getOpenFl() == 'Y' && quarter.getCloseFl() == 'N') {
						rnrService.runUpdateOrDelete("update Quarter set close_FL = 'Y' where OPEN_FL = 'Y' and CLOSE_FL = 'N'");
						
					}
					rnrService.insert(quarter);
					model.addAttribute("responseText",
							"Quarter added successfully");
				} else
					model.addAttribute("responseText",
							"Error: Quarter & FY already exists");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				Quarter quarter = new Quarter();
				quarter.setOpenFl(request.getParameter("open")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				quarter.setCloseFl(request.getParameter("close")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				quarter.setFY(request.getParameter("fy"));
				quarter.setQtr(request.getParameter("qtr"));
				quarter.setName(request.getParameter("quarterName"));
				quarter.setLastUpdateDate(new Date());
				quarter.setLastUpdateUID((String) session.getAttribute("UID"));
				quarter.setRowVersionNumber(1);
				quarter.setId(Long.parseLong(request.getParameter("id")
						.toString().trim()));
				if(quarter.getOpenFl() == 'Y' && quarter.getCloseFl() == 'N') {
					rnrService.runUpdateOrDelete("update Quarter set close_FL = 'Y' where OPEN_FL = 'Y' and CLOSE_FL = 'N' and qtr_id <> " + quarter.getId());
					
				}
				rnrService.update(quarter);
				model.addAttribute("responseText",
						"Quarter updated successfully");
				return "commonPages/ajaxCallResponse";
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				Quarter quarter = new Quarter();
				quarter.setOpenFl(request.getParameter("open")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				quarter.setCloseFl(request.getParameter("close")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				quarter.setFY(request.getParameter("fy"));
				quarter.setQtr(request.getParameter("qtr"));
				quarter.setName(request.getParameter("quarterName"));
				quarter.setLastUpdateDate(new Date());
				quarter.setLastUpdateUID((String) session.getAttribute("UID"));
				quarter.setRowVersionNumber(1);
				quarter.setId(Long.parseLong(request.getParameter("id")
						.toString().trim()));
				rnrService.delete(quarter);
				model.addAttribute("responseText",
						"Quarter deleted successfully");
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
