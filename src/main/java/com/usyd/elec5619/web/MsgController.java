package com.usyd.elec5619.web;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;
import com.usyd.elec5619.websocket.*;
import com.usyd.elec5619.dao.UsersDao;
import com.usyd.elec5619.domain.*;
import com.usyd.elec5619.service.*;


import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/msg")
public class MsgController {

	@Resource
	MyWebSocketHandler handler;

	
	@Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private UsersDao usersDao;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    
	
	@RequestMapping(value = "turntotalked", method = RequestMethod.GET)
	public ModelAndView doLogin_(HttpServletRequest request) {
		
		Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));
		request.getSession().setAttribute("uid", user.getId());
		request.getSession().setAttribute("name",user.getUsername());
		return new ModelAndView("talk");
	}
	
	

	// Turn to the Talk page
	@RequestMapping(value = "talk", method = RequestMethod.GET)
	public ModelAndView talk() {
		
		return new ModelAndView("talk");
	}

	// Turn to the broadcast page
	@RequestMapping(value = "broadcast", method = RequestMethod.GET)
	public ModelAndView broadcast() {
		return new ModelAndView("broadcast");
	}

	// BroadCase
	@ResponseBody
	@RequestMapping(value = "broadcast", method = RequestMethod.POST)
	public void broadcast(String text) throws IOException {
		Message msg = new Message();
		msg.setDate(new Date());
		msg.setFrom(-1L);
		msg.setFromName("System Broadcast");
		msg.setTo(0L);
		msg.setText(text);
		handler.broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg)));
	}

}