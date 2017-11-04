package com.usyd.elec5619.web;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usyd.elec5619.dao.PostDao;
import com.usyd.elec5619.dao.TagDao;
import com.usyd.elec5619.dao.UsersDao;
import com.usyd.elec5619.domain.*;
import com.usyd.elec5619.service.PostService;
import com.usyd.elec5619.service.UserService;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;


@Controller
@Transactional
public class HomeController {
	  
  @Autowired
  private PostService postService;
  @Autowired
  private UserService userService;
  @Autowired
  private UsersDao userDao;
  @Autowired
  private TagDao tagDao;
  @Autowired
  private PostDao postDao;
 
  @RequestMapping(value="/",method = RequestMethod.GET)	
  public String home(Model model) {
	  List<Posts> posts = postService.findAll();
	  List<Posts> timePosts  = postService.findAll();
	  timePosts.sort(Comparator.comparing( Posts::getTime));
	  Collections.reverse(timePosts);
	  List<Posts> topPosts = postDao.findTopPosts();
	  model.addAttribute("topPosts", topPosts);
	  List<Tag> tags = tagDao.findAll();
	  model.addAttribute("posts", timePosts);
	  model.addAttribute("timePosts", timePosts);
	  model.addAttribute("topPosts", topPosts);
	  model.addAttribute("tags", tags);	  
	  return "home";
    	}
  @RequestMapping(value="/",method = RequestMethod.POST)	
  public String INTOhome(Model model) {
	  List<Posts> posts = postService.findAll();
	  model.addAttribute("posts", posts);
	  return "home";
    	}
   @RequestMapping(value="/sort",method = RequestMethod.GET)
   public String sorthome(@RequestParam("value")String value,Model model) {
		 
	      
		  List<Tag> tags = tagDao.findAll();
		  if(value == "newest"){
			  List<Posts> posts = postService.findAll();
			  model.addAttribute("posts", posts);
		  }
		  else{
			  List<Posts> posts = postDao.findTopPosts();
			  model.addAttribute("posts", posts);
			  }
		  
		
		  model.addAttribute("tags", tags);	  
		  return "home";
	    	}
   
}