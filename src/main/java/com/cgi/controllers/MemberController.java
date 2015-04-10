package com.cgi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cgi.service.RNRService;

@Controller
public class MemberController {

	@SuppressWarnings("rawtypes")
	@Autowired
	public RNRService rnrService;

	@Autowired
	public CommonBean commonBean;
}
