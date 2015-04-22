package com.cgi.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cgi.rnr.awards.Award;
import cgi.rnr.awards.AwardCriteria;
import cgi.rnr.awards.AwardCriteriaView;
import cgi.rnr.awards.AwardElig;
import cgi.rnr.awards.AwardEligView;
import cgi.rnr.awards.AwardGroup;
import cgi.rnr.awards.AwardGroupExt;
import cgi.rnr.awards.AwardGroupExtView;
import cgi.rnr.awards.AwardGroupView;
import cgi.rnr.awards.AwardView;
import cgi.rnr.common.Constants;
import cgi.rnr.common.FY;
import cgi.rnr.common.Frequency;
import cgi.rnr.common.QuarterView;
import cgi.rnr.common.RefTablesSQLCont;
import cgi.rnr.company.City;
import cgi.rnr.company.Company;
import cgi.rnr.company.Continent;
import cgi.rnr.company.Country;
import cgi.rnr.company.Location;
import cgi.rnr.company.State;
import cgi.rnr.company.SubCity;
import cgi.rnr.projects.Project;
import cgi.rnr.projects.Vertical;

import com.cgi.service.RNRService;

@Controller
public class AwardsController {

	@SuppressWarnings("rawtypes")
	@Autowired
	public RNRService rnrService;

	@Autowired
	public CommonBean commonBean;

	private static final org.slf4j.Logger logger = LoggerFactory
			.getLogger(AwardsController.class);

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/Constants.AWARD.cgi", method = RequestMethod.GET)
	public String awardConfig(Model model, HttpSession session) {
		try {
			model.addAttribute("Frequency", (List<Frequency>) rnrService
					.getRecordsByTable(Frequency.class.getName()));
		} catch (Exception ex) {
			logger.error(Constants.ERR, ex);
			model.addAttribute(Constants.ERRMSG, Constants.ERR + ex);
			return Constants.ERRPG;
		}
		return commonBean.navigate(Constants.AWARD, session, model, rnrService);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AWARDELIG.cgi", method = RequestMethod.GET)
	public String awardEligConfig(Model model, HttpSession session) {
		try {
			model.addAttribute(Constants.AWARD, (List<Award>) rnrService
					.getRecordsByTable(Award.class.getName()));
		} catch (Exception ex) {
			logger.error(Constants.ERR, ex);
			model.addAttribute(Constants.ERRMSG, Constants.ERR + ex);
			return Constants.ERRPG;
		}
		return commonBean.navigate("AWARDELIG", session, model, rnrService);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AWARDGRP.cgi", method = RequestMethod.GET)
	public String awardGroupConfig(Model model, HttpSession session) {
		try {
			model.addAttribute(Constants.AWARD, (List<Award>) rnrService
					.getRecordsByTable(Award.class.getName()));
		} catch (Exception ex) {
			logger.error(Constants.ERR, ex);
			model.addAttribute(Constants.ERRMSG, Constants.ERR + ex);
			return Constants.ERRPG;
		}
		return commonBean.navigate("AWARDGRP", session, model, rnrService);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AWARDGRPEXT.cgi", method = RequestMethod.GET)
	public String awardGroupExtConfig(Model model, HttpSession session) {
		try {
			model.addAttribute(
					"AwardGroup",
					(List<AwardGroup>) rnrService
							.getRecordsBySQL(
									"select distinct AwardGroup.GRP_NM as awardGroupName from AwardGroup",
									AwardGroup.class));
			model.addAttribute(
					"Quarter",
					(List<QuarterView>) rnrService
							.getRecordsBySQL(
									"select distinct q.QTR_ID as id, q.fy as fy, q.qtr as qtr, q.name as name, q.open_FL as OpenFl, q.close_fl as closeFl, concat(q.fy, '/QTR-', q.qtr) as quarterName from Quarter q",
									QuarterView.class));
			model.addAttribute(
					"FY",
					(List<FY>) rnrService
							.getResultsBySQL("select distinct id, FY, openFl, closeFl from FY"));
		} catch (Exception ex) {
			logger.error(Constants.ERR, ex);
			model.addAttribute(Constants.ERRMSG, Constants.ERR + ex);
			return Constants.ERRPG;
		}
		return commonBean.navigate("AWARDGRPEXT", session, model, rnrService);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AWARDCRITERIA.cgi", method = RequestMethod.GET)
	public String awardCriteriaConfig(Model model, HttpSession session) {
		try {
			model.addAttribute(Constants.AWARD, (List<Award>) rnrService
					.getRecordsByTable(Award.class.getName()));
			model.addAttribute("Vertical", (List<Vertical>) rnrService
					.getRecordsByTable(Vertical.class.getName()));
			model.addAttribute("Project", (List<Project>) rnrService
					.getRecordsByTable(Project.class.getName()));
			model.addAttribute("Company", (List<Company>) rnrService
					.getRecordsByTable(Company.class.getName()));
			model.addAttribute("Continent", (List<Continent>) rnrService
					.getRecordsByTable(Continent.class.getName()));
			model.addAttribute("Country", (List<Country>) rnrService
					.getRecordsByTable(Country.class.getName()));
			model.addAttribute("State", (List<State>) rnrService
					.getRecordsByTable(State.class.getName()));
			model.addAttribute("Location", (List<Location>) rnrService
					.getRecordsByTable(Location.class.getName()));
			model.addAttribute("City", (List<City>) rnrService
					.getRecordsByTable(City.class.getName()));
			model.addAttribute("SubCity", (List<SubCity>) rnrService
					.getRecordsByTable(SubCity.class.getName()));
		} catch (Exception ex) {
			logger.error(Constants.ERR, ex);
			model.addAttribute(Constants.ERRMSG, Constants.ERR + ex);
			return Constants.ERRPG;
		}
		return commonBean.navigate("AWARDCRITERIA", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getAwards", method = RequestMethod.POST)
	@ResponseBody
	public Map getAwards(HttpSession session, HttpServletRequest request) {

		return commonBean
				.getObjectsForJSON(session, request, rnrService,
						Constants.AWARD, Constants.AWARDNM, "AWARD_NM",
						RefTablesSQLCont.AWARDS.toString(), AwardView.class,
						null, null);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getAwardGroup", method = RequestMethod.POST)
	@ResponseBody
	public Map getAwardGroup(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"AwardGroup", Constants.AWARDGRPNM, "GRP_NM",
				RefTablesSQLCont.AWARDSGRP.toString(), AwardGroupView.class,
				null, null);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getAwardGroupExt", method = RequestMethod.POST)
	@ResponseBody
	public Map getAwardGroupExt(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"AwardGroupExt", Constants.AWARDGRPNM, "GRP_NM",
				RefTablesSQLCont.AWARDSGRPEXT.toString(),
				AwardGroupExtView.class, null, null);

	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getAwardCriteria", method = RequestMethod.POST)
	@ResponseBody
	public Map getAwardCriteria(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"AwardCriteria", Constants.CRITERIANM, "CRITERIA_NM",
				RefTablesSQLCont.AWARDCRITERIA.toString(),
				AwardCriteriaView.class, null, null);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getAwardEligibility", method = RequestMethod.POST)
	@ResponseBody
	public Map getAwardEligibility(HttpSession session,
			HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"AwardElig", Constants.AWARDNM, "AWARD_NM",
				RefTablesSQLCont.AWARDELIG.toString(), AwardEligView.class,
				RefTablesSQLCont.AWARDELIG_COUNT.toString(),
				RefTablesSQLCont.AWARDELIG.toString()
						+ RefTablesSQLCont.AWARDELIG_SEARCH.toString());

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateAward.cgi", method = RequestMethod.POST)
	public String insertAward(Model model, HttpSession session,
			HttpServletRequest request) {
		if (session.getAttribute(Constants.SESSIONID) == null
				|| !session.getAttribute(Constants.SESSIONID).toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute(Constants.RESPONSETEXT, Constants.SESSIONEXP);
			return Constants.AJAXRESP;
		}
		try {
			if (request.getParameter(Constants.ACTION) == null) {
				model.addAttribute(Constants.RESPONSETEXT,
						Constants.INVALIDREQUEST);
				return Constants.AJAXRESP;
			}
			if ("1".equalsIgnoreCase(request.getParameter(Constants.ACTION))) { // Action
				// Add
				Award award = new Award();
				award.setActiveFl("true".equalsIgnoreCase(request
						.getParameter(Constants.ACTVFL)) ? 'Y' : 'N');
				award.setAwardDesc(request.getParameter(Constants.AWARDDESC));
				award.setAwardName(request.getParameter(Constants.AWARDNM));
				award.setFrequencyId(request.getParameter("frequency").isEmpty()? 0 : 
							Integer.parseInt(request.getParameter("frequency")));
				award.setLastUpdateDate(new Date());
				award.setLastUpdateUID((String) session.getAttribute("UID"));
				award.setRowVersionNumber(1);
				award.setAwardType(request.getParameter("awardTypeId").isEmpty()? 0 : 
							Integer.parseInt(request.getParameter("awardTypeId")));
				award.setMinimumRole(request.getParameter("minRoleId").isEmpty()? 0 : 
							Integer.parseInt(request.getParameter("minRoleId")));

				if (award.getAwardName() == null || award.getAwardType() == 0
						|| award.getAwardName().trim().length() == 0) {
					model.addAttribute(Constants.RESPONSETEXT,
							"Error: Award name and type are mandatory fields");
					return Constants.AJAXRESP;
				}
				if (rnrService.getObjectsByColumn(Constants.AWARDNM,
						award.getAwardName(), Award.class).isEmpty()) {
					rnrService.insert(award);
					model.addAttribute(Constants.RESPONSETEXT, "Award '"
							+ award.getAwardName() + "' added successfully");
				} else
					model.addAttribute(Constants.RESPONSETEXT, "Error: Award '"
							+ award.getAwardName() + "' already exists");
				return Constants.AJAXRESP;
			} else if ("2".equalsIgnoreCase(request
					.getParameter(Constants.ACTION))) { // action
				// Edit
				Award award = new Award();
				award.setActiveFl("true".equalsIgnoreCase(request
						.getParameter(Constants.ACTVFL)) ? 'Y' : 'N');
				award.setId(request.getParameter("id").toString().trim().isEmpty()? 0L : 
							Long.parseLong(request.getParameter("id").toString().trim()));
				award.setAwardDesc(request.getParameter(Constants.AWARDDESC));
				award.setAwardName(request.getParameter(Constants.AWARDNM));
				award.setFrequencyId(request.getParameter("frequency").isEmpty()? 0 : 
							Integer.parseInt(request.getParameter("frequency")));
				award.setLastUpdateDate(new Date());
				award.setLastUpdateUID((String) session.getAttribute("UID"));
				award.setRowVersionNumber(1);
				award.setAwardType(request.getParameter("awardTypeId").isEmpty()? 0 : 
							Integer.parseInt(request.getParameter("awardTypeId")));
				award.setMinimumRole(request.getParameter("minRoleId").isEmpty()? 0 : 
							Integer.parseInt(request.getParameter("minRoleId")));

				rnrService.update(award);
				model.addAttribute(Constants.RESPONSETEXT,
						"Award '" + award.getAwardName()
								+ "' updated successfully");
				return Constants.AJAXRESP;
			} else if ("3".equalsIgnoreCase(request
					.getParameter(Constants.ACTION))) { // Action
				// Delete
				Award award = new Award();
				award.setActiveFl("true".equalsIgnoreCase(request
						.getParameter(Constants.ACTVFL)) ? 'Y' : 'N');
				award.setId(Long.parseLong(request.getParameter("id").toString().trim()));
				award.setAwardDesc(request.getParameter(Constants.AWARDDESC));
				award.setAwardName(request.getParameter(Constants.AWARDNM));
				award.setFrequencyId(Integer.parseInt(request
						.getParameter("frequency")));
				award.setLastUpdateDate(new Date());
				award.setLastUpdateUID((String) session.getAttribute("UID"));
				award.setRowVersionNumber(1);
				award.setAwardType(Integer.parseInt(request
						.getParameter("awardTypeId")));
				award.setMinimumRole(Integer.parseInt(request
						.getParameter("minRoleId")));
				rnrService.delete(award);
				model.addAttribute(Constants.RESPONSETEXT,
						"Award '" + award.getAwardName()
								+ "' deleted successfully");
				return Constants.AJAXRESP;
			}
		} catch (Exception ex) {
			logger.error(Constants.ERR, ex);
			model.addAttribute(Constants.RESPONSETEXT,
					"An error occured, try again. :" + ex.toString());
			return Constants.AJAXRESP;
		}
		model.addAttribute(Constants.RESPONSETEXT, "Error occured, try again");
		return Constants.AJAXRESP;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateAwardGroup.cgi", method = RequestMethod.POST)
	public String insertUpdateAwardGroup(Model model, HttpSession session,
			HttpServletRequest request) {
		if (session.getAttribute(Constants.SESSIONID) == null
				|| !session.getAttribute(Constants.SESSIONID).toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute(Constants.RESPONSETEXT, Constants.SESSIONEXP);
			return Constants.AJAXRESP;
		}
		try {
			if (request.getParameter(Constants.ACTION) == null) {
				model.addAttribute(Constants.RESPONSETEXT,
						Constants.INVALIDREQUEST);
				return Constants.AJAXRESP;
			}
			if ("1".equalsIgnoreCase(request.getParameter(Constants.ACTION))) { // Action
				// Add
				AwardGroup awardGroup = new AwardGroup();
				awardGroup.setAwardGroupDesc(request
						.getParameter("awardGroupDesc"));
				awardGroup.setAwardGroupName(request
						.getParameter(Constants.AWARDGRPNM));
				awardGroup.setAwardId(request.getParameter("awardId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("awardId")));
				awardGroup.setLastUpdateDate(new Date());
				awardGroup.setLastUpdateUID((String) session
						.getAttribute("UID"));
				awardGroup.setRowVersionNumber(1);

				if (awardGroup.getAwardGroupName() == null
						|| awardGroup.getAwardId() == 0
						|| awardGroup.getAwardGroupName().trim().length() == 0) {
					model.addAttribute(Constants.RESPONSETEXT,
							"Error: Award Group name and type are mandatory fields");
					return Constants.AJAXRESP;
				}
				if (rnrService.getObjectsByColumn(
						new String[] { Constants.AWARDGRPNM, "awardId" },
						new Object[] { awardGroup.getAwardGroupName(),
								awardGroup.getAwardId() }, AwardGroup.class)
						.isEmpty()) {
					rnrService.insert(awardGroup);
					model.addAttribute(Constants.RESPONSETEXT,
							"Award Group added successfully");
				} else
					model.addAttribute(Constants.RESPONSETEXT,
							"Error: Award Group already exists");
				return Constants.AJAXRESP;
			} else if ("2".equalsIgnoreCase(request
					.getParameter(Constants.ACTION))) { // action
				// Edit
				AwardGroup awardGroup = new AwardGroup();
				awardGroup.setAwardGroupDesc(request
						.getParameter("awardGroupDesc"));
				awardGroup.setAwardGroupName(request
						.getParameter(Constants.AWARDGRPNM));
				awardGroup.setAwardId(request.getParameter("awardId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("awardId")));
				awardGroup.setLastUpdateDate(new Date());
				awardGroup.setLastUpdateUID((String) session
						.getAttribute("UID"));
				awardGroup.setRowVersionNumber(1);
				awardGroup.setId(request.getParameter("id").trim().isEmpty()? 0L : 
							Long.parseLong(request.getParameter("id").trim()));
				rnrService.update(awardGroup);
				model.addAttribute(Constants.RESPONSETEXT,
						"Award Group updated successfully");
				return Constants.AJAXRESP;
			} else if ("3".equalsIgnoreCase(request
					.getParameter(Constants.ACTION))) { // Action
				// Delete
				AwardGroup awardGroup = new AwardGroup();
				awardGroup.setAwardGroupDesc(request
						.getParameter("awardGroupDesc"));
				awardGroup.setAwardGroupName(request
						.getParameter(Constants.AWARDGRPNM));
				awardGroup.setAwardId(Long.parseLong(request
						.getParameter("awardId")));
				awardGroup.setLastUpdateDate(new Date());
				awardGroup.setLastUpdateUID((String) session
						.getAttribute("UID"));
				awardGroup.setRowVersionNumber(1);
				awardGroup.setId(Long.parseLong(request.getParameter("id")
						.trim()));
				rnrService.delete(awardGroup);
				model.addAttribute(Constants.RESPONSETEXT,
						"Award Group deleted successfully");
				return Constants.AJAXRESP;
			}
		} catch (Exception ex) {
			logger.error(Constants.ERR, ex);
			model.addAttribute(Constants.RESPONSETEXT,
					"An error occured, try again. :" + ex.toString());
			return Constants.AJAXRESP;
		}
		model.addAttribute(Constants.RESPONSETEXT, "Error occured, try again");
		return Constants.AJAXRESP;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateAwardElig.cgi", method = RequestMethod.POST)
	public String insertUpdateAwardElig(Model model, HttpSession session,
			HttpServletRequest request) {
		if (session.getAttribute(Constants.SESSIONID) == null
				|| !session.getAttribute(Constants.SESSIONID).toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute(Constants.RESPONSETEXT, Constants.SESSIONEXP);
			return Constants.AJAXRESP;
		}
	
		try {
			if (request.getParameter(Constants.ACTION) == null) {
				model.addAttribute(Constants.RESPONSETEXT,
						Constants.INVALIDREQUEST);
				return Constants.AJAXRESP;
			}
			if ("1".equalsIgnoreCase(request.getParameter(Constants.ACTION))) { // Action
				// Add
				AwardElig award = new AwardElig();
				award.setAwardId(request.getParameter("awardId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("awardId")));
				award.setDescription(request.getParameter(Constants.AWARDDESC));
				award.setTitleGroup(request.getParameter("titleGroup").isEmpty()? 0 : 
							Integer.parseInt(request.getParameter("titleGroup")));
				award.setLastUpdateDate(new Date());
				award.setLastUpdateUID((String) session.getAttribute("UID"));
				award.setRowVersionNumber(1);

				if (award.getTitleGroup() == 0 || award.getAwardId() == 0) {
					model.addAttribute(Constants.RESPONSETEXT,
							"Error: Award eligibility and award type are mandatory fields");
					return Constants.AJAXRESP;
				}
				if (rnrService.getObjectsByColumn(
						new String[] { "awardId", "titleGroup" },
						new Object[] { award.getAwardId(),
								award.getTitleGroup() }, AwardElig.class)
						.isEmpty()) {
					rnrService.insert(award);
					model.addAttribute(Constants.RESPONSETEXT,
							"Award Eligibility added successfully");
				} else
					model.addAttribute(Constants.RESPONSETEXT,
							"Error: Award Eligibility already exists");
				return Constants.AJAXRESP;
			} else if ("2".equalsIgnoreCase(request
					.getParameter(Constants.ACTION))) { // action
				// Edit
				AwardElig award = new AwardElig();
				award.setAwardId(request.getParameter("awardId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("awardId")));
				award.setDescription(request.getParameter(Constants.AWARDDESC));
				award.setTitleGroup(request.getParameter("titleGroup").isEmpty()? 0 : 
							Integer.parseInt(request.getParameter("titleGroup")));
				award.setLastUpdateDate(new Date());
				award.setLastUpdateUID((String) session.getAttribute("UID"));
				award.setRowVersionNumber(1);
				award.setId(request.getParameter("id").trim().isEmpty()? 0 : 
					Integer.parseInt(request.getParameter("id").trim()));
				rnrService.update(award);
				model.addAttribute(Constants.RESPONSETEXT,
						"Award Eligibility updated successfully");
				return Constants.AJAXRESP;
			} else if ("3".equalsIgnoreCase(request
					.getParameter(Constants.ACTION))) { // Action
				// Delete
				AwardElig award = new AwardElig();
				award.setAwardId(Long.parseLong(request.getParameter("awardId")));
				award.setDescription(request.getParameter(Constants.AWARDDESC));
				award.setTitleGroup(Integer.parseInt(request
						.getParameter("titleGroup")));
				award.setLastUpdateDate(new Date());
				award.setLastUpdateUID((String) session.getAttribute("UID"));
				award.setRowVersionNumber(1);
				award.setId(Integer.parseInt(request.getParameter("id").trim()));
				rnrService.delete(award);
				model.addAttribute(Constants.RESPONSETEXT,
						"Award Eligibility deleted successfully");
				return Constants.AJAXRESP;
			}
		} catch (Exception ex) {
			logger.error(Constants.ERR, ex);
			model.addAttribute(Constants.RESPONSETEXT,
					"An error occured, try again. :" + ex.toString());
			return Constants.AJAXRESP;
		}
		model.addAttribute(Constants.RESPONSETEXT, "Error occured, try again");
		return Constants.AJAXRESP;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateAwardCriteria.cgi", method = RequestMethod.POST)
	public String insertUpdateAwardCriteria(Model model, HttpSession session,
			HttpServletRequest request) {
		if (session.getAttribute(Constants.SESSIONID) == null
				|| !session.getAttribute(Constants.SESSIONID).toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute(Constants.RESPONSETEXT, Constants.SESSIONEXP);
			return Constants.AJAXRESP;
		}
		try {
			if (request.getParameter(Constants.ACTION) == null) {
				model.addAttribute(Constants.RESPONSETEXT,
						Constants.INVALIDREQUEST);
				return Constants.AJAXRESP;
			}
			if ("1".equalsIgnoreCase(request.getParameter(Constants.ACTION))) { // Action
				// Add
				AwardCriteria awardCriteria = new AwardCriteria();
				awardCriteria.setActiveFl("true".equalsIgnoreCase(request
						.getParameter(Constants.ACTVFL)) ? 'Y' : 'N');
				awardCriteria.setAwardCriteriaDesc(request
						.getParameter("awardCriteriaDesc"));
				
				awardCriteria.setAwardCriteriaName(request
						.getParameter(Constants.CRITERIANM));
				
				awardCriteria.setAwardId(request.getParameter("awardId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("awardId")));
				
				awardCriteria.setCityId(request.getParameter("cityId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("cityId")));
				
				awardCriteria.setCompanyId(request.getParameter("companyId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("companyId")));
				
				awardCriteria.setContinentId(request.getParameter("continentId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("continentId")));
				
				awardCriteria.setCountryId(request.getParameter("countryId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("countryId")));
				
				awardCriteria.setLocationId(request.getParameter("locationId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("locationId")));
				
				awardCriteria.setProjectId(request.getParameter("projectId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("projectId")));
				
				awardCriteria.setStateId(request.getParameter("stateId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("stateId")));
				
				awardCriteria.setSubCityId(request.getParameter("subCityId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("subCityId")));
				
				awardCriteria.setVerticalId(request.getParameter("verticalId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("verticalId")));
				
				awardCriteria.setQuotaAlinedToRole(request.getParameter("quotaAlinedToRole").isEmpty()? 0 : 
					Integer.parseInt(request.getParameter("quotaAlinedToRole")));
				
				awardCriteria.setQuotaPercentage(request.getParameter("quotaPercentage").isEmpty()? 0.0f : 
					Float.parseFloat(request.getParameter("quotaPercentage")));
				
				
				awardCriteria.setQuotaQuantity(Integer
						.parseInt(request.getParameter("quotaQuantity").trim()
								.length() == 0 ? "0" : request
								.getParameter("quotaQuantity")));
				
				awardCriteria.setLastUpdateDate(new Date());
				
				awardCriteria.setLastUpdateUID((String) session
						.getAttribute("UID"));
				
				awardCriteria.setRowVersionNumber(1);
				

				if (awardCriteria.getAwardCriteriaName() == null
						|| awardCriteria.getAwardCriteriaName().trim().length() == 0
						|| awardCriteria.getAwardId() == 0) {
					model.addAttribute(Constants.RESPONSETEXT,
							"Error: Award Criteria name and award ID are mandatory fields");
					return Constants.AJAXRESP;
				}
				if (rnrService.getObjectsByColumn(
						new String[] { Constants.CRITERIANM, "awardId" },
						new Object[] { awardCriteria.getAwardCriteriaName(),
								awardCriteria.getAwardId() },
						AwardCriteria.class).isEmpty()) {
					rnrService.insert(awardCriteria);
					model.addAttribute(Constants.RESPONSETEXT,
							"Award Criteria added successfully");
				} else
					model.addAttribute(
							Constants.RESPONSETEXT,
							"Error: Award Criteria '"
									+ awardCriteria.getAwardCriteriaName()
									+ "' already exists");
				return Constants.AJAXRESP;
			} else if ("2".equalsIgnoreCase(request
					.getParameter(Constants.ACTION))) { // action
				// Edit
				AwardCriteria awardCriteria = new AwardCriteria();
				awardCriteria.setActiveFl("true".equalsIgnoreCase(request
						.getParameter(Constants.ACTVFL)) ? 'Y' : 'N');
				awardCriteria.setAwardCriteriaDesc(request
						.getParameter("awardCriteriaDesc"));
				awardCriteria.setAwardCriteriaName(request
						.getParameter(Constants.CRITERIANM));
				awardCriteria.setAwardId(request.getParameter("awardId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("awardId")));
		
		awardCriteria.setCityId(request.getParameter("cityId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("cityId")));
		
		awardCriteria.setCompanyId(request.getParameter("companyId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("companyId")));
		
		awardCriteria.setContinentId(request.getParameter("continentId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("continentId")));
		
		awardCriteria.setCountryId(request.getParameter("countryId").isEmpty()? 0L : 
			Long.parseLong(request.getParameter("countryId")));
		
		awardCriteria.setLocationId(request.getParameter("locationId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("locationId")));
		
		awardCriteria.setProjectId(request.getParameter("projectId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("projectId")));
		
		awardCriteria.setStateId(request.getParameter("stateId").isEmpty()? 0L : 
					Long.parseLong(request.getParameter("stateId")));
		
		awardCriteria.setSubCityId(request.getParameter("subCityId").isEmpty()? 0L : 
			Long.parseLong(request.getParameter("subCityId")));
		
		awardCriteria.setVerticalId(request.getParameter("verticalId").isEmpty()? 0L : 
			Long.parseLong(request.getParameter("verticalId")));
		
		awardCriteria.setQuotaAlinedToRole(request.getParameter("quotaAlinedToRole").isEmpty()? 0 : 
			Integer.parseInt(request.getParameter("quotaAlinedToRole")));
		
				awardCriteria.setQuotaPercentage(request.getParameter("quotaPercentage").isEmpty()? 0.0f : 
					Float.parseFloat(request.getParameter("quotaPercentage")));
				
				awardCriteria.setQuotaQuantity(request.getParameter("quotaQuantity").isEmpty()? 0 : 
							Integer.parseInt(request.getParameter("quotaQuantity")));
				
				awardCriteria.setId(request.getParameter("id").trim().isEmpty()? 0L : 
					Long.parseLong(request.getParameter("id").trim()));

				awardCriteria.setLastUpdateDate(new Date());
				awardCriteria.setLastUpdateUID((String) session
						.getAttribute("UID"));
				awardCriteria.setRowVersionNumber(1);
				rnrService.update(awardCriteria);
				model.addAttribute(Constants.RESPONSETEXT,
						"Award Criteria updated successfully");
				return Constants.AJAXRESP;
			} else if ("3".equalsIgnoreCase(request
					.getParameter(Constants.ACTION))) { // Action
				// Delete
				AwardCriteria awardCriteria = new AwardCriteria();
				awardCriteria.setActiveFl("true".equalsIgnoreCase(request
						.getParameter(Constants.ACTVFL)) ? 'Y' : 'N');
				awardCriteria.setAwardCriteriaDesc(request
						.getParameter("awardCriteriaDesc"));
				awardCriteria.setAwardCriteriaName(request
						.getParameter(Constants.CRITERIANM));
				awardCriteria.setAwardId(Long.parseLong(request
						.getParameter("awardId")));
				awardCriteria.setCityId(Long.parseLong(request
						.getParameter("cityId")));
				awardCriteria.setCompanyId(Long.parseLong(request
						.getParameter("companyId")));
				awardCriteria.setContinentId(Long.parseLong(request
						.getParameter("continentId")));
				awardCriteria.setCountryId(Long.parseLong(request
						.getParameter("countryId")));
				awardCriteria.setLocationId(Long.parseLong(request
						.getParameter("locationId")));
				awardCriteria.setProjectId(Long.parseLong(request
						.getParameter("projectId")));
				awardCriteria.setStateId(Long.parseLong(request
						.getParameter("stateId")));
				awardCriteria.setSubCityId(Long.parseLong(request
						.getParameter("subCityId")));
				awardCriteria.setVerticalId(Long.parseLong(request
						.getParameter("verticalId")));
				awardCriteria.setQuotaAlinedToRole(Integer.parseInt(request
						.getParameter("quotaAlinedToRole")));
				awardCriteria.setQuotaPercentage(request.getParameter("quotaPercentage").isEmpty()? 0.0f : Float.parseFloat(request.getParameter("quotaPercentage")));
				awardCriteria.setQuotaQuantity(Integer.parseInt(request
						.getParameter("quotaQuantity")));
				awardCriteria.setId(Long.parseLong(request.getParameter("id")));

				awardCriteria.setLastUpdateDate(new Date());
				awardCriteria.setLastUpdateUID((String) session
						.getAttribute("UID"));
				awardCriteria.setRowVersionNumber(1);
				rnrService.delete(awardCriteria);
				model.addAttribute(Constants.RESPONSETEXT,
						"Award Criteria deleted successfully");
				return Constants.AJAXRESP;
			}
		} catch (Exception ex) {
			logger.error(Constants.ERR, ex);
			model.addAttribute(Constants.RESPONSETEXT,
					"An error occured, try again. :" + ex.toString());
			return Constants.AJAXRESP;
		}
		model.addAttribute(Constants.RESPONSETEXT, "Error occured, try again");
		return Constants.AJAXRESP;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateAwardGroupExt.cgi", method = RequestMethod.POST)
	public String insertUpdateAwardGroupExt(Model model, HttpSession session,
			HttpServletRequest request) {
		if (session.getAttribute(Constants.SESSIONID) == null
				|| !session.getAttribute(Constants.SESSIONID).toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute(Constants.RESPONSETEXT, Constants.SESSIONEXP);
			return Constants.AJAXRESP;
		}
		try {
			if (request.getParameter(Constants.ACTION) == null) {
				model.addAttribute(Constants.RESPONSETEXT,
						Constants.INVALIDREQUEST);
				return Constants.AJAXRESP;
			}
			if ("1".equalsIgnoreCase(request.getParameter(Constants.ACTION))) { // Action
				// Add
				AwardGroupExt awardGroupExt = new AwardGroupExt();
				awardGroupExt.setAwardGroupExtName(request
						.getParameter("awardGroupExtName"));
				System.out.println("set award group ext name");
				awardGroupExt.setAwardGroupName(request
						.getParameter("awardGroupId"));
				System.out.println("set award group name");
				awardGroupExt.setCloseNominations("true"
						.equalsIgnoreCase(request
								.getParameter("closeNominations")) ? 'Y' : 'N');
				System.out.println("set close nominaiton");
				awardGroupExt.setClosePanelGroupReviews("true"
						.equalsIgnoreCase(request
								.getParameter("closePanelGroupReviews")) ? 'Y'
						: 'N');
				System.out.println("set close panel group reviews");
				awardGroupExt.setDisplayMessage(request
						.getParameter("dispMessage"));
				System.out.println("setdisplay message");
				awardGroupExt.setFy(request.getParameter("fy"));
				System.out.println("set fy");
				awardGroupExt.setOpenForNominations("true"
						.equalsIgnoreCase(request
								.getParameter("openForNominations")) ? 'Y'
						: 'N');
				System.out.println("set open for nomination");
				awardGroupExt.setOpenPanelGroupReviews("true"
						.equalsIgnoreCase(request
								.getParameter("openPanelGroupReviews")) ? 'Y'
						: 'N');
				System.out.println("set open panel group reviews");
				awardGroupExt.setPublish("true".equalsIgnoreCase(request
						.getParameter("publish")) ? 'Y' : 'N');
				System.out.println("setpublish");
				awardGroupExt.setQtrId(request.getParameter("qtrId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("qtrId")));
				System.out.println("set quarter id");
				awardGroupExt.setLastUpdateDate(new Date());
				System.out.println("set last update date");
				awardGroupExt.setLastUpdateUID((String) session
						.getAttribute("UID"));
				System.out.println("set last update uid");
				awardGroupExt.setRowVersionNumber(1);
				System.out.println("set row inversion number");

				if (awardGroupExt.getAwardGroupName() == null
						|| awardGroupExt.getQtrId() == 0
						|| awardGroupExt.getFy() == null || awardGroupExt.getFy().trim().length()==0) {
					model.addAttribute(Constants.RESPONSETEXT,
							"Error: Award Group ID, Quarter and FY are mandatory fields");
					return Constants.AJAXRESP;
				}
				if (rnrService
						.getObjectsByColumn(
								new String[] { Constants.AWARDGRPNM, "qtrId",
										"fy" },
								new Object[] {
										awardGroupExt.getAwardGroupName(),
										awardGroupExt.getQtrId(),
										awardGroupExt.getFy() },
								AwardGroupExt.class).isEmpty()) {
					rnrService.insert(awardGroupExt);
					model.addAttribute(Constants.RESPONSETEXT,
							"Award Group Ext added successfully");
				} else
					model.addAttribute(Constants.RESPONSETEXT,
							"Error: Award Group Ext already exists");
				return Constants.AJAXRESP;
			} else if ("2".equalsIgnoreCase(request
					.getParameter(Constants.ACTION))) { // action
				// Edit
				AwardGroupExt awardGroupExt = new AwardGroupExt();
				awardGroupExt.setAwardGroupExtName(request
						.getParameter("awardGroupExtName"));
				awardGroupExt.setAwardGroupName(request
						.getParameter("awardGroupId"));
				awardGroupExt.setCloseNominations("true"
						.equalsIgnoreCase(request
								.getParameter("closeNominations")) ? 'Y' : 'N');
				awardGroupExt.setClosePanelGroupReviews("true"
						.equalsIgnoreCase(request
								.getParameter("closePanelGroupReviews")) ? 'Y'
						: 'N');
				awardGroupExt.setDisplayMessage(request
						.getParameter("dispMessage"));
				awardGroupExt.setFy(request.getParameter("fy"));
				awardGroupExt.setOpenForNominations("true"
						.equalsIgnoreCase(request
								.getParameter("openForNominations")) ? 'Y'
						: 'N');
				awardGroupExt.setOpenPanelGroupReviews("true"
						.equalsIgnoreCase(request
								.getParameter("openPanelGroupReviews")) ? 'Y'
						: 'N');
				awardGroupExt.setPublish("true".equalsIgnoreCase(request
						.getParameter("publish")) ? 'Y' : 'N');
				awardGroupExt.setQtrId(request.getParameter("qtrId").isEmpty()? 0L : 
							Long.parseLong(request.getParameter("qtrId")));
				awardGroupExt.setLastUpdateDate(new Date());
				awardGroupExt.setLastUpdateUID((String) session
						.getAttribute("UID"));
				awardGroupExt.setRowVersionNumber(1);
				awardGroupExt.setId(request.getParameter("id").trim().isEmpty()? 0L : 
							Long.parseLong(request.getParameter("id").trim()));
				rnrService.update(awardGroupExt);
				model.addAttribute(Constants.RESPONSETEXT,
						"Award Group Ext updated successfully");
				return Constants.AJAXRESP;
			} else if ("3".equalsIgnoreCase(request
					.getParameter(Constants.ACTION))) { // Action
				// Delete
				AwardGroupExt awardGroupExt = new AwardGroupExt();
				awardGroupExt.setAwardGroupExtName(request
						.getParameter("awardGroupExtName"));
				awardGroupExt.setAwardGroupName(request
						.getParameter("awardGroupId"));
				awardGroupExt.setCloseNominations("true"
						.equalsIgnoreCase(request
								.getParameter("closeNominations")) ? 'Y' : 'N');
				awardGroupExt.setClosePanelGroupReviews("true"
						.equalsIgnoreCase(request
								.getParameter("closePanelGroupReviews")) ? 'Y'
						: 'N');
				awardGroupExt.setDisplayMessage(request
						.getParameter("dispMessage"));
				awardGroupExt.setFy(request.getParameter("fy"));
				awardGroupExt.setOpenForNominations("true"
						.equalsIgnoreCase(request
								.getParameter("openForNominations")) ? 'Y'
						: 'N');
				awardGroupExt.setOpenPanelGroupReviews("true"
						.equalsIgnoreCase(request
								.getParameter("openPanelGroupReviews")) ? 'Y'
						: 'N');
				awardGroupExt.setPublish("true".equalsIgnoreCase(request
						.getParameter("publish")) ? 'Y' : 'N');
				awardGroupExt.setQtrId(Long.parseLong(request
						.getParameter("qtrId")));
				awardGroupExt.setLastUpdateDate(new Date());
				awardGroupExt.setLastUpdateUID((String) session
						.getAttribute("UID"));
				awardGroupExt.setRowVersionNumber(1);
				awardGroupExt.setId(Long.parseLong(request.getParameter("id")
						.trim()));
				rnrService.delete(awardGroupExt);
				model.addAttribute(Constants.RESPONSETEXT,
						"Award Group Ext deleted successfully");
				return Constants.AJAXRESP;
			}
		} catch (Exception ex) {
			logger.error(Constants.ERR, ex);
			model.addAttribute(Constants.RESPONSETEXT,
					"An error occured, try again. :" + ex.toString());
			return Constants.AJAXRESP;
		}
		model.addAttribute(Constants.RESPONSETEXT, "Error occured, try again");
		return Constants.AJAXRESP;
	}

}
