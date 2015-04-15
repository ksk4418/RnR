package com.cgi.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import cgi.rnr.common.Constants;
import cgi.rnr.util.Utils;

import com.cgi.service.RNRService;

@Service
public class CommonBean {

	private static final org.slf4j.Logger logger = LoggerFactory
			.getLogger(CommonBean.class);
	
	@SuppressWarnings("rawtypes")
	public String navigate(String pageCode, HttpSession session, Model model,
			RNRService rnrService) {
		if (isSessionExpired(session))
			return "redirect:sessionExpired.cgi";
		try {
			model.addAttribute("pageCode", pageCode);
			return rnrService.getPage(pageCode);
		} catch (Exception ex) {
			logger.info("", ex);
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			try {
				return rnrService.getPage("ERR");
			} catch (Exception e) {
				logger.info("", ex);
			}
		}
		return "commonPages/invalidReq";
	}

	public boolean isSessionExpired(HttpSession session) {
		if (Utils.stringEqual((String) session.getAttribute("sessionId"),
				session.getId()))
			return false;
		return true;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getObjectsForJSON(HttpSession session,
			HttpServletRequest request, RNRService rnrService,
			String tableName, String searchColumnName) {

		if (isSessionExpired(session)) {
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
				recordCount = rnrService.getCount(tableName, (String) null);
			else
				recordCount = rnrService.getCount(tableName, searchColumnName
						+ " like '%" + request.getParameter("searchPhrase")
						+ "%'");

			HashMap<String, Object> hm = new HashMap<String, Object>();
			if (request.getParameter("searchPhrase") == null
					|| request.getParameter("searchPhrase").trim().length() < 1)
				hm.put("rows",
						((List) rnrService.getRequiredRecordsBySQL("from "
								+ tableName, startCurrent, rowCount)));
			else {
				hm.put("rows", ((List) rnrService.getRequiredRecordsBySQL(
						"from " + tableName + " where " + searchColumnName
								+ " like '%"
								+ request.getParameter("searchPhrase")
								+ "%' order by " + orderBy, startCurrent,
						rowCount)));
			}

			hm.put("current", current);
			hm.put("rowCount", rowCount);
			hm.put("total", recordCount);
			return hm;
		} catch (Exception ex) {
			logger.info("", ex);
			HashMap<String, Object> se = new HashMap<String, Object>();
			se.put("rows",
					(new ArrayList<String>()).add("Error occured:" + ex
							+ ", please try again"));
			return se;
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getObjectsForJSON(HttpSession session,
			HttpServletRequest request, RNRService rnrService,
			String tableName, String searchColumnName, String searchDBColName,
			String sql, Class dto, String sqlCount, String searchSQL) {

		if (isSessionExpired(session)) {
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
				recordCount = rnrService.getCount(tableName, (String) null);
			else {
				if (sqlCount == null)
					recordCount = rnrService.getCount(
							tableName,
							searchColumnName + " like '%"
									+ request.getParameter("searchPhrase")
									+ "%'");
				else
					recordCount = rnrService.getCountBySQL(sqlCount.replace(
							"searchRequest",
							request.getParameter("searchPhrase")));
			}
			HashMap<String, Object> hm = new HashMap<String, Object>();
			if (request.getParameter("searchPhrase") == null
					|| request.getParameter("searchPhrase").trim().length() < 1)
				hm.put("rows", ((List) rnrService.getRecordsBySQL(sql, orderBy,
						dto, startCurrent, rowCount)));
			else {
				if (searchSQL == null)
					hm.put("rows", ((List) rnrService.getRecordsBySQL(sql
							+ " where " + searchDBColName + " like '%"
							+ request.getParameter("searchPhrase") + "%'",
							orderBy, dto, startCurrent, rowCount)));
				else
					hm.put("rows", ((List) rnrService.getRecordsBySQL(
							searchSQL.replace("searchRequest",
									request.getParameter("searchPhrase")),
							orderBy, dto, startCurrent, rowCount)));
			}

			hm.put("current", current);
			hm.put("rowCount", rowCount);
			hm.put("total", recordCount);
			return hm;
		} catch (Exception ex) {
			logger.info("", ex);
			HashMap<String, Object> se = new HashMap<String, Object>();
			se.put("rows",
					(new ArrayList<String>()).add("Error occured:" + ex
							+ ", please try again"));
			return se;
		}
	}

	public static String getBeanName(int level) {
		switch (level) {
		case Constants.MEMBER:
			return Constants.MEMBER_COL;
		case Constants.RM:
			return Constants.RM_COL;
		case Constants.PM:
			return Constants.PM_COL;
		case Constants.SPM:
			return Constants.SPM_COL;
		case Constants.ED:
			return Constants.ED_COL;
		case Constants.GH:
			return Constants.GH_COL;
		case Constants.GL:
			return Constants.GL_COL;
		case Constants.SGL:
			return Constants.SGL_COL;
		default:
			return Constants.MEMBER_COL;
		}
	}

	public static String getColumnName(int level) {
		switch (level) {
		case Constants.MEMBER:
			return Constants.MEMBER_COL_NM;
		case Constants.RM:
			return Constants.RM_COL_NM;
		case Constants.PM:
			return Constants.PM_COL_NM;
		case Constants.SPM:
			return Constants.SPM_COL_NM;
		case Constants.ED:
			return Constants.ED_COL_NM;
		case Constants.GH:
			return Constants.GH_COL_NM;
		case Constants.GL:
			return Constants.GL_COL_NM;
		case Constants.SGL:
			return Constants.SGL_COL_NM;
		default:
			return Constants.MEMBER_COL_NM;
		}
	}
}
