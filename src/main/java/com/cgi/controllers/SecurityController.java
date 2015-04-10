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
				role.setId(Long.parseLong(request.getParameter("id").toString()
						.trim()));
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
						|| page.getPageName().trim().length() == 0) {
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
				page.setId(Long.parseLong(request.getParameter("id").toString()
						.trim()));
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
				access.setPageId(Long.parseLong(request.getParameter("pageId")));
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
				access.setPageId(Long.parseLong(request.getParameter("pageId")));
				access.setLastUpdateDate(new Date());
				access.setLastUpdateUID((String) session.getAttribute("UID"));
				access.setRowVersionNumber(1);
				access.setId(Long.parseLong(request.getParameter("id")));

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
				pageCateg.setPageId(Long.parseLong(request
						.getParameter("pageName")));
				pageCateg.setLastUpdateDate(new Date());
				pageCateg
						.setLastUpdateUID((String) session.getAttribute("UID"));
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
				pageCateg.setPageId(Long.parseLong(request
						.getParameter("pageName")));
				pageCateg.setLastUpdateDate(new Date());
				pageCateg
						.setLastUpdateUID((String) session.getAttribute("UID"));
				pageCateg.setRowVersionNumber(1);
				pageCateg.setId(Long.parseLong(request.getParameter("id")));

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
				memberRole.setRoleId(Long.parseLong(request
						.getParameter("roleId")));
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
				memberRole.setRoleId(Long.parseLong(request
						.getParameter("roleId")));
				memberRole.setLastUpdateDate(new Date());
				memberRole.setLastUpdateUID((String) session
						.getAttribute("UID"));
				memberRole.setRowVersionNumber(1);
				memberRole.setId(Long.parseLong(request.getParameter("id")));

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

}
