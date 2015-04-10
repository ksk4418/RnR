package com.cgi.controllers;

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

import com.cgi.service.RNRService;

@Controller
public class CompanyController {
	@SuppressWarnings("rawtypes")
	@Autowired
	public RNRService rnrService;

	@Autowired
	public CommonBean commonBean;

	// City
	@RequestMapping(value = "/CITY.cgi", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {

		return commonBean.navigate("CITY", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/CITY", method = RequestMethod.POST)
	@ResponseBody
	public Map getCity(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"CITY", "cityName");
	}

	// Company
	@RequestMapping(value = "/COMPANY.cgi", method = RequestMethod.GET)
	public String companyHome(Locale locale, Model model, HttpSession session) {

		return commonBean.navigate("COMPANY", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getCompany", method = RequestMethod.POST)
	@ResponseBody
	public Map getCompany(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"COMPANY", "companyName");
	}

	// Continent
	@RequestMapping(value = "/CONTINENT.cgi", method = RequestMethod.GET)
	public String continentHome(Locale locale, Model model, HttpSession session) {

		return commonBean.navigate("CONTINENT", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getContinent", method = RequestMethod.POST)
	@ResponseBody
	public Map getContinent(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"SBU", "continentName");
	}

	// Country
	@RequestMapping(value = "/CTRY.cgi", method = RequestMethod.GET)
	public String countryHome(Locale locale, Model model, HttpSession session) {

		return commonBean.navigate("CTRY", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getCountry", method = RequestMethod.POST)
	@ResponseBody
	public Map getCountry(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService, "BU",
				"countryName");
	}

	// Location
	@RequestMapping(value = "/LOC.cgi", method = RequestMethod.GET)
	public String locationHome(Locale locale, Model model, HttpSession session) {

		return commonBean.navigate("LOC", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getLocation", method = RequestMethod.POST)
	@ResponseBody
	public Map getLocation(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"LOCATION", "locationName");
	}

	// State
	@RequestMapping(value = "/STATE.cgi", method = RequestMethod.GET)
	public String stateHome(Locale locale, Model model, HttpSession session) {

		return commonBean.navigate("STATE", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getState", method = RequestMethod.POST)
	@ResponseBody
	public Map getState(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"STATE", "stateName");
	}

	// SubCity
	@RequestMapping(value = "/SCITY.cgi", method = RequestMethod.GET)
	public String subCityHome(Locale locale, Model model, HttpSession session) {
		return commonBean.navigate("SCITY", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getSubCity", method = RequestMethod.POST)
	@ResponseBody
	public Map getSubCity(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"SUB_CITY", "subCityName");
	}

}
