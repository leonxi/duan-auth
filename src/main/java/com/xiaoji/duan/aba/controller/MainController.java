package com.xiaoji.duan.aba.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class MainController {

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse response) {
		
        String host = req.getHeader("x-forwarded-host");

		if (host == null) {
			host = req.getHeader("host");
		}
		
		String scheme = req.getHeader("x-forwarded-proto");
		
		if (scheme == null) {
			scheme = req.getScheme();
		}
		
    	Cookie authorized_userCookie = new Cookie("authorized_user", "");
    	authorized_userCookie.setPath("/");
    	authorized_userCookie.setMaxAge(-1);
    	response.addCookie(authorized_userCookie);

    	Cookie authorized_openidCookie = new Cookie("authorized_openid", "");
    	authorized_openidCookie.setPath("/");
    	authorized_openidCookie.setMaxAge(-1);
    	response.addCookie(authorized_openidCookie);
    	
    	try {
			response.sendRedirect(scheme + "://" + host);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return "logout";
	}
}
