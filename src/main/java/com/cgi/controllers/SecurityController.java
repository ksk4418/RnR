package com.cgi.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import cgi.rnr.common.RefTablesSQLCont;
import cgi.rnr.security.Access;
import cgi.rnr.security.AccessView;
import cgi.rnr.security.MemberRole;
import cgi.rnr.security.MemberRoleView;
import cgi.rnr.security.PageCateg;
import cgi.rnr.security.PageCategView;
import cgi.rnr.security.Pages;
import cgi.rnr.security.Role;

import com.cgi.member.Member;
import com.cgi.service.RNRService;

@Controller
public class SecurityController {

	@SuppressWarnings("rawtypes")
	@Autowired
	public RNRService rnrService;

	@Autowired
	public CommonBean commonBean;

	@RequestMapping(value = "/ROLE.cgi", method = RequestMethod.GET)
	public String rolesConfig(Locale locale, Model model, HttpSession session) {
		return commonBean.navigate("ROLE", session, model, rnrService);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/MROLE.cgi", method = RequestMethod.GET)
	public String memebrRoleConfig(Locale locale, Model model,
			HttpSession session) {
		try {
			model.addAttribute("Role",
					(List<Role>) rnrService.getRecordsByTable("Role"));
			model.addAttribute("Member", (List<Member>) rnrService
					.getResultsBySQL("from Member where vertical = '"
							+ session.getAttribute("vertical")
							+ "' order by employeeName asc"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return commonBean.navigate("MROLE", session, model, rnrService);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/PGCATEG.cgi", method = RequestMethod.GET)
	public String pageCategConfig(Locale locale, Model model,
			HttpSession session) {
		try {
			model.addAttribute("Pages",
					(List<Pages>) rnrService.getRecordsByTable("Pages"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return commonBean.navigate("PGCATEG", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getRoles", method = RequestMethod.POST)
	@ResponseBody
	public Map getRoles(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"Role", "roleName");
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getPageCateg", method = RequestMethod.POST)
	@ResponseBody
	public Map getPageCateg(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"PageCateg", "categoryName", "CATEG_NM",
				RefTablesSQLCont.PAGE_CATEG.toString(), PageCategView.class,
				null, null);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getMemberRole", method = RequestMethod.POST)
	@ResponseBody
	public Map getMemberRole(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"MemberRole", "employeeId", "EMPL_ID",
				RefTablesSQLCont.MEM_ROLE.toString(), MemberRoleView.class,
				null, null);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateRole.cgi", method = RequestMethod.POST)
	public String insertRole(Locale locale, Model model, HttpSession session,
			HttpServletRequest request) throws Exception {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute("responseText", "Session Expired");
			return rnrService.getPage("RESAJAX");
		}
		try {
			if (request.getParameter("action") == null) {
				model.addAttribute("responseText", "Invalid Request");
				return rnrService.getPage("RESAJAX");
			}
			if (request.getParameter("action").equalsIgnoreCase("1")) { // Action
																		// Add
				Role role = new Role();
				role.setActiveFl(request.getParameter("activeFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				role.setRoleName(request.getParameter("roleName"));

				role.setLastUpdateDate(new Date());
				role.setLastUpdateUID((String) session.getAttribute("UID"));
				role.setRowVersionNumber(1);

				if (role.getRoleName() == null
						|| role.getRoleName().trim().length() == 0) {
					model.addAttribute("responseText",
							"Error: Role name is mandatory field");
					return rnrService.getPage("RESAJAX");
				}
				if (rnrService.getObjectsByColumn("roleName",
						role.getRoleName(), Role.class).size() == 0) {
					rnrService.insert(role);
					model.addAttribute("responseText",
							"Role '" + role.getRoleName()
									+ "' added successfully");
				} else
					model.addAttribute("responseText",
							"Error: Role '" + role.getRoleName()
									+ "' already exists");
				return rnrService.getPage("RESAJAX");
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				Role role = new Role();
				role.setActiveFl(request.getParameter("activeFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				role.setId(request.getParameter("id").toString().trim().isEmpty()? 0L :
							Long.parseLong(request.getParameter("id").toString().trim()));
				role.setRoleName(request.getParameter("roleName"));

				role.setLastUpdateDate(new Date());
				role.setLastUpdateUID((String) session.getAttribute("UID"));
				role.setRowVersionNumber(1);

				rnrService.update(role);
				model.addAttribute("responseText",
						"Role '" + role.getRoleName()
								+ "' updated successfully");
				return rnrService.getPage("RESAJAX");
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				Role role = new Role();
				role.setActiveFl(request.getParameter("activeFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				role.setId(Long.parseLong(request.getParameter("id").toString()
						.trim()));
				role.setLastUpdateDate(new Date());
				role.setLastUpdateUID((String) session.getAttribute("UID"));
				role.setRowVersionNumber(1);

				rnrService.delete(role);
				model.addAttribute("responseText",
						"Role '" + role.getRoleName()
								+ "' deleted successfully");
				return rnrService.getPage("RESAJAX");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return rnrService.getPage("RESAJAX");
		}
		model.addAttribute("responseText", "Error occured, try again");
		return rnrService.getPage("RESAJAX");
	}

	@RequestMapping(value = "/PAGE.cgi", method = RequestMethod.GET)
	public String pagesConfig(Locale locale, Model model, HttpSession session) {
		return commonBean.navigate("PAGE", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getPages", method = RequestMethod.POST)
	@ResponseBody
	public Map getPages(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"Pages", "pageName");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdatePage.cgi", method = RequestMethod.POST)
	public String insertPage(Locale locale, Model model, HttpSession session,
			HttpServletRequest request) throws Exception {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute("responseText", "Session Expired");
			return rnrService.getPage("RESAJAX");
		}
		try {
			if (request.getParameter("action") == null) {
				model.addAttribute("responseText", "Invalid Request");
				return rnrService.getPage("RESAJAX");
			}
			if (request.getParameter("action").equalsIgnoreCase("1")) { // Action
																		// Add
				Pages page = new Pages();
				page.setActiveFl(request.getParameter("activeFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				page.setPageName(request.getParameter("pageName"));
				page.setPath(request.getParameter("path"));
				page.setPageDisplayName(request.getParameter("pageDisplayName"));

				page.setLastUpdateDate(new Date());
				page.setLastUpdateUID((String) session.getAttribute("UID"));
				page.setRowVersionNumber(1);

				if (page.getPageName() == null
						|| page.getPageName().trim().length() == 0 || page.getPath()==null || page.getPath().trim().length()==0) {
					model.addAttribute("responseText",
							"Error: Page name & path are are mandatory field");
					return rnrService.getPage("RESAJAX");
				}
				if (rnrService.getObjectsByColumn(
						new String[] { "pageName", "path" },
						new Object[] { page.getPageName(), page.getPath() },
						Pages.class).size() == 0) {
					rnrService.insert(page);
					model.addAttribute("responseText",
							"Page '" + page.getPageName()
									+ "' added successfully");
				} else
					model.addAttribute("responseText",
							"Error: Role '" + page.getPageName()
									+ "' already exists");
				return rnrService.getPage("RESAJAX");
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				Pages page = new Pages();
				page.setActiveFl(request.getParameter("activeFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				page.setId(request.getParameter("id").toString().trim().isEmpty()? 0L :
							Long.parseLong(request.getParameter("id").toString().trim()));
				page.setPageName(request.getParameter("pageName"));
				page.setPath(request.getParameter("path"));
				page.setPageDisplayName(request.getParameter("pageDisplayName"));

				page.setLastUpdateDate(new Date());
				page.setLastUpdateUID((String) session.getAttribute("UID"));
				page.setRowVersionNumber(1);

				rnrService.update(page);
				model.addAttribute("responseText",
						"Role '" + page.getPageName()
								+ "' updated successfully");
				return rnrService.getPage("RESAJAX");
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				Pages page = new Pages();
				page.setActiveFl(request.getParameter("activeFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				page.setId(Long.parseLong(request.getParameter("id").toString()
						.trim()));
				page.setPageName(request.getParameter("pageName"));
				page.setPath(request.getParameter("path"));
				page.setPageDisplayName(request.getParameter("pageDisplayName"));

				page.setLastUpdateDate(new Date());
				page.setLastUpdateUID((String) session.getAttribute("UID"));
				page.setRowVersionNumber(1);

				rnrService.delete(page);
				model.addAttribute("responseText",
						"Role '" + page.getPageName()
								+ "' deleted successfully");
				return rnrService.getPage("RESAJAX");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return rnrService.getPage("RESAJAX");
		}
		model.addAttribute("responseText", "Error occured, try again");
		return rnrService.getPage("RESAJAX");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/PGACCESS.cgi", method = RequestMethod.GET)
	public String accessConfig(Locale locale, Model model, HttpSession session)
			throws Exception {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId()))
			return "redirect:sessionExpired.cgi";
		try {
			model.addAttribute("Pages", (List<Pages>) rnrService
					.getResultsBySQL("from Pages order by pageName"));
			model.addAttribute("Roles", (List<Role>) rnrService
					.getResultsBySQL("from Role order by roleName"));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return commonBean.navigate("PGACCESS", session, model, rnrService);
	}

	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value = "/getAccess", method = RequestMethod.POST)
	@ResponseBody
	public Map getAccess(HttpSession session, HttpServletRequest request) {

		return commonBean.getObjectsForJSON(session, request, rnrService,
				"Access", "accessName", "ROLE_NM",
				RefTablesSQLCont.ACCESS.toString(), AccessView.class, null,
				null);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateAccess.cgi", method = RequestMethod.POST)
	public String insertAccess(Locale locale, Model model, HttpSession session,
			HttpServletRequest request) throws Exception {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute("responseText", "Session Expired");
			return rnrService.getPage("RESAJAX");
		}
		try {
			if (request.getParameter("action") == null) {
				model.addAttribute("responseText", "Invalid Request");
				return rnrService.getPage("RESAJAX");
			}
			if (request.getParameter("action").equalsIgnoreCase("1")) { // Action
																		// Add
				Access access = new Access();
				access.setInsertFl(request.getParameter("insertFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				access.setUpdateFl(request.getParameter("updateFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				access.setDeleteFl(request.getParameter("deleteFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				access.setAccessName(request.getParameter("accessName"));
				access.setPageId(request.getParameter("pageId").isEmpty()? 0L :
					Long.parseLong(request.getParameter("pageId")));
				access.setLastUpdateDate(new Date());
				access.setLastUpdateUID((String) session.getAttribute("UID"));
				access.setRowVersionNumber(1);

				if (access.getAccessName() == null
						|| access.getAccessName().trim().length() == 0
						|| access.getPageId() == 0) {
					model.addAttribute("responseText",
							"Error: Role name and Page Name are mandatory fields");
					return rnrService.getPage("RESAJAX");
				}
				if (rnrService.getObjectsByColumn(
						new String[] { "accessName", "pageId" },
						new Object[] { access.getAccessName(),
								access.getPageId() }, Access.class).size() == 0) {
					rnrService.insert(access);
					model.addAttribute("responseText",
							"Page Access '" + access.getAccessName()
									+ "' added successfully");
				} else
					model.addAttribute("responseText", "Error: Page access '"
							+ access.getAccessName() + "' already exists");
				return rnrService.getPage("RESAJAX");
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				Access access = new Access();
				access.setInsertFl(request.getParameter("insertFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				access.setUpdateFl(request.getParameter("updateFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				access.setDeleteFl(request.getParameter("deleteFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				access.setAccessName(request.getParameter("accessName"));
				access.setPageId(request.getParameter("pageId").isEmpty()? 0L :
					Long.parseLong(request.getParameter("pageId")));
				access.setLastUpdateDate(new Date());
				access.setLastUpdateUID((String) session.getAttribute("UID"));
				access.setRowVersionNumber(1);
				access.setId(request.getParameter("id").isEmpty()? 0L :
					Long.parseLong(request.getParameter("id")));

				rnrService.update(access);
				model.addAttribute("responseText",
						"Page Access '" + access.getAccessName()
								+ "' updated successfully");
				return rnrService.getPage("RESAJAX");
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				Access access = new Access();
				access.setInsertFl(request.getParameter("insertFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				access.setUpdateFl(request.getParameter("updateFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				access.setDeleteFl(request.getParameter("deleteFl")
						.equalsIgnoreCase("true") ? 'Y' : 'N');
				access.setAccessName(request.getParameter("accessName"));
				access.setPageId(Long.parseLong(request.getParameter("pageId")));
				access.setLastUpdateDate(new Date());
				access.setLastUpdateUID((String) session.getAttribute("UID"));
				access.setRowVersionNumber(1);
				access.setId(Long.parseLong(request.getParameter("id")));

				rnrService.delete(access);
				model.addAttribute("responseText",
						"Page Access '" + access.getAccessName()
								+ "' deleted successfully");
				return rnrService.getPage("RESAJAX");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return rnrService.getPage("RESAJAX");
		}
		model.addAttribute("responseText", "Error occured, try again");
		return rnrService.getPage("RESAJAX");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdatePageCateg.cgi", method = RequestMethod.POST)
	public String insertUpdatePageCateg(Locale locale, Model model,
			HttpSession session, HttpServletRequest request) throws Exception {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute("responseText", "Session Expired");
			return rnrService.getPage("RESAJAX");
		}
		try {
			if (request.getParameter("action") == null) {
				model.addAttribute("responseText", "Invalid Request");
				return rnrService.getPage("RESAJAX");
			}
			if (request.getParameter("action").equalsIgnoreCase("1")) { // Action
																		// Add
				PageCateg pageCateg = new PageCateg();
				pageCateg.setCategoryName(request.getParameter("categoryName"));
				pageCateg.setPageId(request.getParameter("pageName").isEmpty()? 0L :
							Long.parseLong(request.getParameter("pageName")));
				pageCateg.setLastUpdateDate(new Date());
				pageCateg.setLastUpdateUID((String) session.getAttribute("UID"));
				pageCateg.setRowVersionNumber(1);

				if (pageCateg.getCategoryName() == null
						|| pageCateg.getCategoryName().trim().length() == 0
						|| pageCateg.getPageId() == 0) {
					model.addAttribute("responseText",
							"Error: Page Category name and Page Name are mandatory fields");
					return rnrService.getPage("RESAJAX");
				}
				if (rnrService.getObjectsByColumn(
						new String[] { "categoryName", "pageId" },
						new Object[] { pageCateg.getCategoryName(),
								pageCateg.getPageId() }, PageCateg.class)
						.size() == 0) {
					rnrService.insert(pageCateg);
					model.addAttribute("responseText", "Page Category '"
							+ pageCateg.getCategoryName()
							+ "' added successfully");
				} else
					model.addAttribute("responseText",
							"Error: Page category conmination already exists");
				return rnrService.getPage("RESAJAX");
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				PageCateg pageCateg = new PageCateg();
				pageCateg.setCategoryName(request.getParameter("categoryName"));
				pageCateg.setPageId(request.getParameter("pageName").isEmpty()? 0L :
							Long.parseLong(request.getParameter("pageName")));
				pageCateg.setLastUpdateDate(new Date());
				pageCateg.setLastUpdateUID((String) session.getAttribute("UID"));
				pageCateg.setRowVersionNumber(1);
				pageCateg.setId(request.getParameter("id").isEmpty()? 0L :
					Long.parseLong(request.getParameter("id")));

				rnrService.update(pageCateg);
				model.addAttribute("responseText",
						"Page Category updated successfully");
				return rnrService.getPage("RESAJAX");
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				PageCateg pageCateg = new PageCateg();
				pageCateg.setCategoryName(request.getParameter("categoryName"));
				pageCateg.setPageId(Long.parseLong(request
						.getParameter("pageName")));
				pageCateg.setLastUpdateDate(new Date());
				pageCateg
						.setLastUpdateUID((String) session.getAttribute("UID"));
				pageCateg.setRowVersionNumber(1);
				pageCateg.setId(Long.parseLong(request.getParameter("id")));

				rnrService.delete(pageCateg);
				model.addAttribute("responseText",
						"Page Category deleted successfully");
				return rnrService.getPage("RESAJAX");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return rnrService.getPage("RESAJAX");
		}
		model.addAttribute("responseText", "Error occured, try again");
		return rnrService.getPage("RESAJAX");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insertUpdateMemberRole.cgi", method = RequestMethod.POST)
	public String insertUpdateMemberRole(Locale locale, Model model,
			HttpSession session, HttpServletRequest request) throws Exception {
		if (session.getAttribute("sessionId") == null
				|| !session.getAttribute("sessionId").toString()
						.equalsIgnoreCase(session.getId())) {
			model.addAttribute("responseText", "Session Expired");
			return rnrService.getPage("RESAJAX");
		}
		try {
			if (request.getParameter("action") == null) {
				model.addAttribute("responseText", "Invalid Request");
				return rnrService.getPage("RESAJAX");
			}
			if (request.getParameter("action").equalsIgnoreCase("1")) { // Action
																		// Add
				MemberRole memberRole = new MemberRole();
				memberRole.setEmployeeId(request.getParameter("memberId"));
				memberRole.setRoleId(request.getParameter("roleId").isEmpty()? 0L :
							Long.parseLong(request.getParameter("roleId")));
				memberRole.setLastUpdateDate(new Date());
				memberRole.setLastUpdateUID((String) session
						.getAttribute("UID"));
				memberRole.setRowVersionNumber(1);

				if (memberRole.getEmployeeId() == null
						|| memberRole.getRoleId() == 0) {
					model.addAttribute("responseText",
							"Error: Role ID and Memebr Name are mandatory fields");
					return rnrService.getPage("RESAJAX");
				}
				if (rnrService.getObjectsByColumn(
						new String[] { "employeeId", "roleId" },
						new Object[] { memberRole.getEmployeeId(),
								memberRole.getRoleId() }, MemberRole.class)
						.size() == 0) {
					rnrService.insert(memberRole);
					model.addAttribute("responseText",
							"Member Role added successfully");
				} else
					model.addAttribute("responseText",
							"Error: Member Role already exists");
				return rnrService.getPage("RESAJAX");
			} else if (request.getParameter("action").equalsIgnoreCase("2")) { // action
																				// Edit
				MemberRole memberRole = new MemberRole();
				memberRole.setEmployeeId(request.getParameter("memberId"));
				memberRole.setRoleId(request.getParameter("roleId").isEmpty()? 0L :
							Long.parseLong(request.getParameter("roleId")));
				memberRole.setLastUpdateDate(new Date());
				memberRole.setLastUpdateUID((String) session
						.getAttribute("UID"));
				memberRole.setRowVersionNumber(1);
				memberRole.setId(request.getParameter("id").isEmpty()? 0L :
					Long.parseLong(request.getParameter("id")));

				rnrService.update(memberRole);
				model.addAttribute("responseText",
						"Member Role updated successfully");
				return rnrService.getPage("RESAJAX");
			} else if (request.getParameter("action").equalsIgnoreCase("3")) { // Action
																				// Delete
				MemberRole memberRole = new MemberRole();
				memberRole.setEmployeeId(request.getParameter("memberId"));
				memberRole.setRoleId(Long.parseLong(request
						.getParameter("roleId")));
				memberRole.setLastUpdateDate(new Date());
				memberRole.setLastUpdateUID((String) session
						.getAttribute("UID"));
				memberRole.setRowVersionNumber(1);
				memberRole.setId(Long.parseLong(request.getParameter("id")));

				rnrService.delete(memberRole);
				model.addAttribute("responseText",
						"Member Role deleted successfully");
				return rnrService.getPage("RESAJAX");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			model.addAttribute("responseText", "An error occured, try again. :"
					+ ex.toString());
			return rnrService.getPage("RESAJAX");
		}
		model.addAttribute("responseText", "Error occured, try again");
		return rnrService.getPage("RESAJAX");
	}
	
	//gives list when page load first time
	@RequestMapping(value = "/ReportGWT.cgi", method = RequestMethod.GET)
	public String ReportGWT(Locale locale, Model model, HttpSession session) {
		return "gwt/ReportGWT";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getPageLoad", method = RequestMethod.POST)
	public @ResponseBody Map getPageLoad(Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			HashMap hm = new HashMap();
			hm.put("rows",
					(List) rnrService
							.getResultsBySQL("select distinct m.vertical from Member m"));
			hm.put("tbleName", "vertical");
			return hm;
		} catch (Exception erx) {
			erx.printStackTrace();
		}
		return new CommonBean().getObjectsForJSON(session, request, rnrService, "Member", "employeeName");
	}
  //gives list frequency
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getPageLoadFrequency", method = RequestMethod.POST)
	public @ResponseBody Map getFrequency(Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			HashMap hm = new HashMap();
			hm.put("rows",
					(List) rnrService
							.getResultsBySQL("select distinct f.frequencyName from Frequency f"));
			hm.put("tbleName", "frequency");
			return hm;
		} catch (Exception erx) {
			erx.printStackTrace();
		}
		return new CommonBean().getObjectsForJSON(session, request, rnrService, "FY", "FY");
	}
	//gives list of from year
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getPageLoadYear", method = RequestMethod.POST)
	public @ResponseBody Map getPageLoadYear(Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest request) {
		try {
			HashMap hm = new HashMap();
			hm.put("rows",
					(List) rnrService
							.getResultsBySQL("select distinct fy.FY from FY fy order by fy.FY asc"));
			hm.put("tbleName", "fromFY");
			return hm;
		} catch (Exception erx) {
			erx.printStackTrace();
		}
		return new CommonBean().getObjectsForJSON(session, request, rnrService, "FY", "FY");
	}
	//gives list of to year
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@RequestMapping(value = "/getToYear", method = RequestMethod.POST)
		public @ResponseBody Map getToYear(Model model, HttpSession session,
				HttpServletResponse response, HttpServletRequest request) {
			String year=request.getParameter("year");
			try {
				HashMap hm = new HashMap();
				hm.put("rows",
						(List) rnrService
								.getResultsBySQL("select distinct fy.FY from FY fy where fy.FY>='"+year+"' order by fy.FY asc"));
				hm.put("tbleName", "toFY");
				return hm;
			} catch (Exception erx) {
				erx.printStackTrace();
			}
			return new CommonBean().getObjectsForJSON(session, request, rnrService, "FY", "FY");
		}
		
	//gives list of pyramids based on vertical selection 
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@RequestMapping(value = "/getPyramid", method = RequestMethod.POST)
		public @ResponseBody Map getPyramid(Model model, HttpSession session,
				HttpServletResponse response, HttpServletRequest request) {

			try {
				HashMap hm = new HashMap();
				hm.put("rows",
						(List) rnrService
								.getResultsBySQL("select distinct m.pyramidAccount from Member m where m.vertical='"+request.getParameter("vertical")+"'"));
				hm.put("tbleName", "pyramid");
				return hm;
			} catch (Exception erx) {
				erx.printStackTrace();
			}
			return new CommonBean().getObjectsForJSON(session, request, rnrService, "Member", "employeeName");
		}	
		
	//gives list of project based on pyrmaid selection
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@RequestMapping(value = "/getProjectDesc", method = RequestMethod.POST)
		public @ResponseBody Map getProjectDesc(Model model,
				HttpSession session, HttpServletResponse response,
				HttpServletRequest request) {
			try {
				HashMap hm = new HashMap();
				hm.put("rows",
						(List) rnrService
								.getResultsBySQL("select distinct m.projectDescription from Member m where m.pyramidAccount='"+request.getParameter("pyramid")+"'"));
				hm.put("tbleName", "project");
				return hm;
			} catch (Exception erx) {
				erx.printStackTrace();
			}
			return new CommonBean().getObjectsForJSON(session, request, rnrService, "Member", "employeeName");
		}
		
	//gives list for quarter
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getFiguresForQuarterly", method = RequestMethod.POST)
	public @ResponseBody Map getFiguresForQuarterly(Model model,
			HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {

		String proj=request.getParameter("project");
		String quart=request.getParameter("quarter");
		String fYear=request.getParameter("fromYear");
		String tYear=request.getParameter("toYear");
		String freq=request.getParameter("frequency");
		String pyra=request.getParameter("pyramid");

		try {
			List projectList= rnrService.getResultsBySQL("select distinct m.projectDescription from Member m where m.pyramidAccount='"+pyra+"'");
			List list= rnrService.getResultsBySQL("select distinct awd.awardName from Award awd where awd.frequencyId='"+freq+"'");
			HashMap hm = new HashMap();
			hm.put("names",(List)rnrService.getResultsBySQL("select distinct awd.awardName from Award awd where awd.frequencyId='"+freq+"'"));
			int noOfAwards=0;
			for(Object name:list){
				if(proj.equalsIgnoreCase("All")){
					int value=0;
					int nom=0;
					int awd=0;

					for(Object projectName:projectList){
						hm.put("nom"+value, (List)rnrService.getResultsBySQL("select count(*)from Nomination n where n.projectName='"+projectName+"'and n.quarter='"+quart+"'and n.FY between '"+fYear+"'and '"+tYear+"' and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
						hm.put("awd"+value, (List)rnrService.getResultsBySQL("select count(*)from Nomination n where n.nominationPhase=5 and n.projectName='"+projectName+"'and n.quarter='"+quart+"'and n.FY between '"+fYear+"'and '"+tYear+"' and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));

						nom=nom+Integer.parseInt(hm.get("nom"+value).toString().replaceAll("\\[", "").replaceAll("\\]",""));
						awd=awd+Integer.parseInt(hm.get("awd"+value).toString().replaceAll("\\[", "").replaceAll("\\]",""));
						value++;
					}
					List nomination=new ArrayList();
					List awarded=new ArrayList();
					nomination.add(nom);
					awarded.add(awd);

					hm.put("rows", (List)rnrService.getResultsBySQL("select count(*) from Member m where m.pyramidAccount='"+pyra+"'"));
					hm.put(name,nomination);
					hm.put(name+"_awd",awarded);
				}else{
					hm.put("rows", (List)rnrService.getResultsBySQL("select count(*)from Member m where m.projectDescription='"+proj+"'"));

					hm.put(name,
							(List) rnrService
									.getResultsBySQL("select count(*) from Nomination n where n.projectName='"+proj+"'and n.quarter='"+quart+"'and n.FY between '"+fYear+"'and '"+tYear+"' and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
					hm.put(name+"_awd",
							(List) rnrService
									.getResultsBySQL("select count(*) from Nomination n where n.nominationPhase=5 and n.projectName='"+proj+"'and n.quarter='"+quart+"'and n.FY between '"+fYear+"'and '"+tYear+"' and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
				}

			noOfAwards++;
			}
			hm.put("No_Awards", noOfAwards);
			hm.put("tbleName", "Quarterly");

			return hm;
		} catch (Exception erx) {
			erx.printStackTrace();
		}
		return new CommonBean().getObjectsForJSON(session, request, rnrService, "Nomination", "projectName");
	}

	//gives figures in case of half yearly
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getFiguresForHalfYearly", method = RequestMethod.POST)
	public @ResponseBody Map getFiguresForHalfYearly(Model model,
			HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		String proj=request.getParameter("project");
		String fYear=request.getParameter("fromYear");
		String tYear=request.getParameter("toYear");
		String freq=request.getParameter("frequency");
		String pyra=request.getParameter("pyramid");

		try {
			List projectList= rnrService.getResultsBySQL("select distinct m.projectDescription from Member m where m.pyramidAccount='"+pyra+"'");
			List list= rnrService.getResultsBySQL("select distinct awd.awardName from Award awd where awd.frequencyId='"+freq+"'");
			HashMap hm = new HashMap();
			hm.put("rows", (List)rnrService.getResultsBySQL("select count(*)from Member m where m.projectDescription='"+proj+"'"));
			hm.put("names",(List)rnrService.getResultsBySQL("select distinct awd.awardName from Award awd where awd.frequencyId='"+freq+"'"));
			int noOfAwards=0;
			for(Object name:list){
				if(proj.equalsIgnoreCase("All")){
					int value=0;
					int nom=0;
					int awd=0;
					for(Object projectName:projectList){

						hm.put("nom"+value, (List)rnrService.getResultsBySQL("select count(*)from Nomination n where n.projectName='"+projectName+"'and n.FY between '"+fYear+"'and '"+tYear+"' n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
						hm.put("awd"+value, (List)rnrService.getResultsBySQL("select count(*)from Nomination n where n.nominationPhase=5 and n.projectName='"+projectName+"'and n.FY between '"+fYear+"'and '"+tYear+"' and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
						nom=nom+Integer.parseInt(hm.get("nom"+value).toString().replaceAll("\\[", "").replaceAll("\\]",""));
						awd=awd+Integer.parseInt(hm.get("awd"+value).toString().replaceAll("\\[", "").replaceAll("\\]",""));
						value++;
					}
					List nomination=new ArrayList();
					List awarded=new ArrayList();
					nomination.add(nom);
					awarded.add(awd);

					hm.put("rows", (List)rnrService.getResultsBySQL("select count(*) from Member m where m.pyramidAccount='"+pyra+"'"));
					hm.put(name,nomination);
					hm.put(name+"_awd",awarded);
				}else{
					hm.put(name,
							(List) rnrService
									.getResultsBySQL("select count(*) from Nomination n where n.projectName='"+proj+"'and n.FY between '"+fYear+"'and '"+tYear+"' and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
					hm.put(name+"_awd",
							(List) rnrService
									.getResultsBySQL("select count(*) from Nomination n where n.nominationPhase=5 and n.projectName='"+proj+"'and n.FY between '"+fYear+"'and '"+tYear+"' and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
				}

			noOfAwards++;
			}
			hm.put("No_Awards", noOfAwards);
			hm.put("tbleName", "HalfYearly");

			return hm;
		} catch (Exception erx) {
			erx.printStackTrace();
		}
		return new CommonBean().getObjectsForJSON(session, request, rnrService, "Nomination", "projectName");
	}

	//gives list for annually
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/getFiguresForAnnually", method = RequestMethod.POST)
	public @ResponseBody Map getFiguresForAnnually(Model model,
			HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		String proj=request.getParameter("project");
		String fYear=request.getParameter("fromYear");
		String tYear=request.getParameter("toYear");
		String freq=request.getParameter("frequency");
		String pyra=request.getParameter("pyramid");

		try {
			List projectList= rnrService.getResultsBySQL("select distinct m.projectDescription from Member m where m.pyramidAccount='"+pyra+"'");
			List list= rnrService.getResultsBySQL("select distinct awd.awardName from Award awd where awd.frequencyId='"+freq+"'");
			HashMap hm = new HashMap();
			hm.put("names",(List)rnrService.getResultsBySQL("select distinct awd.awardName from Award awd where awd.frequencyId='"+freq+"'"));
			int noOfAwards=0;
			for(Object name:list){
				if(proj.equalsIgnoreCase("All")){
					int value=0;
					int nom=0;
					int awd=0;
					for(Object projectName:projectList){

						hm.put("nom"+value, (List)rnrService.getResultsBySQL("select count(*)from Nomination n where n.projectName='"+projectName+"'and n.FY between '"+fYear+"'and '"+tYear+"' and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
						hm.put("awd"+value, (List)rnrService.getResultsBySQL("select count(*)from Nomination n where n.nominationPhase=5 and n.projectName='"+projectName+"'and n.FY between '"+fYear+"'and '"+tYear+"' and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
						nom=nom+Integer.parseInt(hm.get("nom"+value).toString().replaceAll("\\[", "").replaceAll("\\]",""));
						awd=awd+Integer.parseInt(hm.get("awd"+value).toString().replaceAll("\\[", "").replaceAll("\\]",""));
						value++;
					}
					List nomination=new ArrayList();
					List awarded=new ArrayList();
					nomination.add(nom);
					awarded.add(awd);

					hm.put("rows", (List)rnrService.getResultsBySQL("select count(*) from Member m where m.pyramidAccount='"+pyra+"'"));
					hm.put(name,nomination);
					hm.put(name+"_awd",awarded);
				}else{
					hm.put("rows", (List)rnrService.getResultsBySQL("select count(*)from Member m where m.projectDescription='"+proj+"'"));

					hm.put(name,
							(List) rnrService
									.getResultsBySQL("select count(*) from Nomination n where n.projectName='"+proj+"'and n.FY between '"+fYear+"'and '"+tYear+"'and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
					hm.put(name+"_awd",
							(List) rnrService
									.getResultsBySQL("select count(*) from Nomination n where n.projectName='"+proj+"'and n.nominationPhase=5 and n.FY between '"+fYear+"'and '"+tYear+"'and n.awardId in (select a.id from Award a where a.awardName='"+name+"'and a.frequencyId='"+freq+"')"));
				}

			noOfAwards++;
			}

			hm.put("No_Awards", noOfAwards);
			hm.put("tbleName", "Annually");

			return hm;
		} catch (Exception erx) {
			erx.printStackTrace();
		}
		return new CommonBean().getObjectsForJSON(session, request, rnrService, "Nomination", "projectName");
	}
	//for reporting purpose

}
