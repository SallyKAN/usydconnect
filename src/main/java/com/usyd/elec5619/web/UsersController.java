package com.usyd.elec5619.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usyd.elec5619.dao.UsersDao;
import com.usyd.elec5619.domain.LoginForm;
import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.domain.Users;
import com.usyd.elec5619.service.PostService;
import com.usyd.elec5619.service.UserService;
import com.usyd.elec5619.domain.UserReturn;


/* User Controller, handles all the mapping for all functionality relating to the user models. 
   This includes registering, logging in and out, viewing profiles, editing profiles, and searching for users*/


@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Autowired
    private UsersDao usersDao;
    
    @Autowired
    private PostService postService;
    
    @Autowired
    private UserService userService;
    
    //Mapping for registering an account. The GET method requests the registerForm view when the "/register" link is taken
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public String showRegistrationForm() {
		  return "registerForm";
	  }

	  // The POST method for the register function; here, a new user will be added into the database if a user with the given username
	  // does not already exist
	  @RequestMapping(value="/register", method=POST)
	  public String processRegistration(Users user, HttpServletRequest request) {
		  
				  String username = user.getUsername();
				  if (!userService.usernameExists(username)) {
					  userService.addUser(user);
					  request.setAttribute("username", username);
					  return "redirect:/";
				  }else {
	                    request.setAttribute("Msg", "This username has been taken!");
	                    return "registerForm";
			  }
				  
		  }
	  
	 /* The mapping for the logging in, similarly a GET and a POST method to retrieve the login view, and set the user passed to the 
	  * map as the session user respectively.
	  */
	  @RequestMapping(value="/login", method=GET)
	  public String login(){
		  return "login";
	  }
	  @RequestMapping(value="/login", method=POST)	
	  public String processLogin(Users loginUser, HttpServletRequest request,RedirectAttributes redirect) {
		  Users user = userService.getUserByUsername(loginUser.getUsername());
		  if (user == null)
		  {
			  request.setAttribute("LoginErrorMessage", "Cannot FindUser");
			  return "login";
			  
		  }
	      String password = user.getPassword();
	      if(loginUser.getPassword().equals(password)){
	    	 request.getSession().setAttribute("username", user.getUsername());
	    	 request.removeAttribute("LoginErrorMessage");
	    	 return "redirect:/";
	      }else{
	    	  request.setAttribute("LoginErrorMessage", "Cannot FindUser");
	    	  return "login";
	      }
	  }
	  
	  // Logging out, remove the logging in user as the session user.
	  @RequestMapping(value = "/loginOut")
	    public String loginOut(HttpServletRequest request) {
	        request.getSession().removeAttribute("username");
	        return "redirect:/";
	    }
	  
	  /* Display the users profile page*/
	  @RequestMapping(value = "/profile/{username}",method=GET )
	  public String profile(@PathVariable("username")String username, HttpServletRequest request, Model model){
		  Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));
		 List<Posts> posts = postService.getPostsByUsername(username);
		 model.addAttribute("user", user);
		 model.addAttribute("posts", posts);
	        return "profile";
	    }
	  
	  @RequestMapping(value = "/friends",method=GET )
	  public String friends(HttpServletRequest request, Model model){
		  Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));
		 model.addAttribute("user", user);
		 Collection<Users> friends = user.getFriends();
	
		 model.addAttribute("friends", friends);
	        return "friends";
	    }
	  
	  
	  /* Settings function to allow a user to change their details for their profile. Currently unfinished on this implementation*/
	  @RequestMapping(value = "/settings", method=GET)
	  public String showSettings() {
		  return "settings";
	  }
	  
	  @RequestMapping(value = "/settings", method=POST)
	  public String processSettings(HttpServletRequest request, Users profile) {
		  
		  Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));

					if(profile.getFaculty() != null) {
						  user.setFaculty(profile.getFaculty());
					  }
					else {
						user.setFaculty(user.getFaculty());
					}
					  if(profile.getGender() != null) {
						  user.setGender(profile.getGender());
					  }
					  else {
							user.setGender(user.getGender());
						}
					  if(profile.getYear() != null) {
						  user.setYear(profile.getYear());  
					  }
					  else {
						  user.setYear(user.getYear());
					  }
					  if(profile.getName() != null) {
						  user.setName(profile.getName());
					  }
					  else {
						  user.setName(user.getName());
					  }
					  if(profile.getNationality() != null) {
						  user.setNationality(profile.getNationality());
					  }
					  else {
						  user.setNationality(user.getNationality());
					  }
					  if(profile.getMajor() != null) {
						  user.setMajor(profile.getMajor());
					  }
					  else {
						  user.setMajor(user.getMajor());
					  }
					  if(profile.getDegree() != null) {
						  user.setDegree(profile.getDegree());
					  }
					  else {
						  user.setDegree(user.getDegree());
					  }

					  userService.saveUser(user);
					  
					
				return "redirect:/";
	  }
	  
	  /* Controller to handle the uploading of images, also incomplete in this implementation. (We were able to upload images to the server but not*/
	  /* correctly display them. We had to get the correct path to properly output the image from the server onto any client */
	  @RequestMapping(value = "/uploadImage", method=GET)
	  public String showUploadImage() {
		  return "uploadImage";
	  }
	  
	  @RequestMapping(value = "/uploadImage", method=POST)
	  public String processUploadImage(HttpServletRequest request, HttpServletResponse response, Users profile) {
		  
		  Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));

		  MultipartFile userImage = profile.getUserImage();
		  
		  String imageName = profile.getImageName();
		  if (!userImage.isEmpty()) {
				try {
					byte[] bytes = userImage.getBytes();

					// Creating the directory to store file
					//String rootPath = System.getProperty("catalina.home");
					String rootPath = request.getSession().getServletContext().getRealPath("/");
					File dir = new File(rootPath + "/WEB-INF/resources/images" );
					if (!dir.exists())
						dir.mkdirs();

					// Create the file on server
					
					// c:/tomcat 7/image/aaa.jpg
					String location = dir.getAbsolutePath() // you define the saving path here
							+ File.separator + imageName;
					File serverFile = new File(location);
					BufferedOutputStream stream = new BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					
					  user.setImageName(profile.getImageName()); 
					  user.setPath(location);// here you should save the saving path to the user
					  
					  userService.saveUser(user);
					
					return "redirect:/";
				} catch (Exception e) {
					return "You failed to upload " + imageName + " => " + e.getMessage();
				}
			} else {
				return "You failed to upload " + imageName
						+ " because the file was empty.";
			}
	  }
  
	  /* Search for users by username, the username of the desiered user is entered into the function, and a model of that user corresponding to 
	   * the given username is generated, and their profile page is returned.
	   */
	  
	  @RequestMapping(value="/search", method=GET)
	  public String showSearch() {
	  		return "search";
	   }
	  
	  
	  @RequestMapping(value="/search", method=POST)
	  public String Search(HttpServletRequest request, String username, Model model) {
		  Users user, profile;
		  if(userService.getUserByUsername(username) != null) {
			 profile =  userService.getUserByUsername((String)request.getSession().getAttribute("username"));
			 user = userService.getUserByUsername(username);
			 List<Posts> posts = postService.getPostsByUsername(username);
			  model.addAttribute("user", user);
			  model.addAttribute("profile", profile);
			  model.addAttribute("posts", posts);
			  return "profile";
		  }
		  else {
			  return "search";
		  }
	   }
	  
	  @RequestMapping(value="/viewFriend/{username}", method=GET)
	  public String viewFriend(HttpServletRequest request, @PathVariable("username") String username, Model model) {
		  Users user, profile;
		  if(userService.getUserByUsername(username) != null) {
			 profile =  userService.getUserByUsername((String)request.getSession().getAttribute("username"));
			 user = userService.getUserByUsername(username);
			 List<Posts> posts = postService.getPostsByUsername(username);
			  model.addAttribute("user", user);
			  model.addAttribute("profile", profile);
			  model.addAttribute("posts", posts);
			  return "profile";
		  }
		  else {
			  return "redirect:/";
		  }
	   }
	  
	  @RequestMapping(value = "/addFriend/{username}")
	  public String getFriendForm(HttpServletRequest request, @PathVariable("username") String username) {
		  Users profile = userService.getUserByUsername(username);
		  Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));
		  //user.getFriends().clear();
		  user.getFriends().add(profile);
		  userService.saveUser(user);
		  return "redirect:/";
	  }
	  
	  
	  @RequestMapping(value = "/delete", method = GET)
	  public String deleteForm() {
		  return "delete";
	  }
	  
	  @RequestMapping(value = "/delete", method = POST)
	  public String deleteUser(String username, HttpServletRequest request) {
		  //Users user = userService.getUserByUsername(username);
		  userService.removeUser(username);
		  return "redirect:/";
	  }
	 
	  /* User information REST API. Returned the information of the specified user */
		  @RequestMapping(value= "UserInfo", method = GET)
		  public @ResponseBody Users uxrest(HttpServletRequest request)
		  {
			  String name = request.getParameter("name");
			  Users user = userService.getUserByUsername(name);
			  Users user_return = new Users();
			  user_return .setId(user.getId());
			  return user_return;
			  
			  
			  //return "Hi";
		  }
		  
	  }

	      
 
	 

