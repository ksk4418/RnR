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
public class ProjectsController {
	@SuppressWarnings("rawtypes")
	@Autowired
	public RNRService rnrService;

	@Autowired
	public CommonBean commonBean;

	// Project
	@RequestMapping(value = "/PROJECT.cgi", method = RequestMethod.GET)
	public String Home(Locale locale, Model model, HttpSession session) {
		return commonBean.navigate("PROJECT", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getProject", method = RequestMethod.POST)
	@ResponseBody
	public Map getProject(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"PROJECT", "projectName");
	}

	// Vertical
	@RequestMapping(value = "/VERTICAL.cgi", method = RequestMethod.GET)
	public String verticalHome(Locale locale, Model model, HttpSession session) {
		return commonBean.navigate("VERTICAL", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getVertical", method = RequestMethod.POST)
	@ResponseBody
	public Map getVertical(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"VERTICAL", "verticalName");
	}

}
