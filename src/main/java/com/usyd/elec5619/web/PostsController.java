package com.usyd.elec5619.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usyd.elec5619.dao.*;
import com.usyd.elec5619.domain.*;
import com.usyd.elec5619.service.AlreadyVotedException;
import com.usyd.elec5619.service.CommentService;
import com.usyd.elec5619.service.PostService;
import com.usyd.elec5619.service.UserService;

@Controller
@Transactional
public class PostsController {
	   @Autowired
	    private SessionFactory sessionFactory;
	    @Autowired
	    private UsersDao usersDao;
	    @Autowired
	    private PostService postService;
	    @Autowired
	    private UserService userService;
	    @Autowired
	    private CommentService commentService;
	    @Autowired
	    private PostVoteDao postVoteDao;
	    @Autowired
	    private CommentVoteDao commentVoteDao;
	    @Autowired
	    private TagDao tagDao;
	    @Autowired
	    private PostDao postDao;
	    
     // @RequestMapping(value="/posts/view/{id}", method=GET)	
	  //public String posts(@PathVariable("id") Long id, Model model) {
    	//  Posts post = postService.findById(id);
          //model.addAttribute("post", post);
          //return "posts/view";
		  //}
	    @RequestMapping(value = "/posts/create", method = RequestMethod.GET)
	    public String showCreatePostForm(HttpServletRequest request,RedirectAttributes redirect,Model model) {
	    	if(request.getSession().getAttribute("username") != null){
	    	    List<Tag> allTags = tagDao.findAll();
	    	    model.addAttribute("allTags",allTags);
	    		return "editpost";
	    	}else{
		    return "redirect:/users/login";
		    }
	    }
	    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
	    public String showCreatePostForm(@RequestParam("tags")String tags,
	    		Posts post,
	    		HttpServletRequest request,RedirectAttributes redirect, Model model) {
	    	post.getTags().clear();
	    	String[] strTags = Arrays.stream((tags).split(",")).map(String::trim).toArray(String[]::new); 
	    	for(String tag: strTags){
	    		Tag newTag = tagDao.getTagByTagname(tag) ;
	    		if(newTag ==null){
	    			newTag = new Tag(tag);
	    			   }
	    		
	    	   post.getTags().add(newTag);
	    	}
	    	
	    	tagDao.flush();
	    	/*Tag newSelectedTag = tagDao.getTagByTagname(selectedTag);
	    	post.getTags().add(newSelectedTag);*/
	    	Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));
	    	post.setUser(user);
	    	post.setPostUsername(user.getUsername());
	        postService.saveNewPost(post);
	        
	        return "redirect:/";
	    
	       
	    }
	    @RequestMapping(value = "/posts/view/{id}/edit", method = RequestMethod.GET)
	    public String showEditPostForm(Posts editPost,
	    		@PathVariable("id") Long id,
	    		HttpServletRequest request,RedirectAttributes redirect,Model model){
	 
	  /*  @RequestMapping(value = "/posts/tags/add", method = RequestMethod.POST)
	    public String tagsAdd(@RequestParam("selectedTags")String selectedTags,
	    		HttpServletRequest request,RedirectAttributes redirect, Model model) {
	    		
	    	   model.addAttribute("selectedTags",selectedTags);
	    	   return "redirect:posts/create";
	    }
	    */
	    	Posts post = postService.getPostById(id);
	 
	    	model.addAttribute("post",post);
	   
	    
	    	return "updatepost";
	    }
	    @RequestMapping(value = "/posts/view/{id}/edit", method = RequestMethod.POST)
	    public String EditPostForm(Posts editPost,
	    		@PathVariable("id") Long id,
	    		HttpServletRequest request,RedirectAttributes redirect,Model model){
	 
	  /*  @RequestMapping(value = "/posts/tags/add", method = RequestMethod.POST)
	    public String tagsAdd(@RequestParam("selectedTags")String selectedTags,
	    		HttpServletRequest request,RedirectAttributes redirect, Model model) {
	    		
	    	   model.addAttribute("selectedTags",selectedTags);
	    	   return "redirect:posts/create";
	    }
	    */
	    	Posts post = postService.getPostById(id);

	    	model.addAttribute("post",post);
	    
	    	post.setTitle(editPost.getTitle());
	    	post.setMessage(editPost.getMessage());
	    
	    	postService.updatePost(post);
	    	return "redirect:/posts/view/{id}";
	    }
	    @RequestMapping(value = "/posts/view/{id}",method = RequestMethod.GET)
	    public String postView(@PathVariable("id") Long id, Model model,HttpServletRequest request) {
	  
	    	Posts post = postService.getPostById(id);
	    	List<Comment> comments = commentService.listCommentByPostId(id);
	    	Collection<Tag> tags = (postService.getPostById(id)).getTags();
	    	Integer commentCount = post.getComments().size();
	    	List<PostVote> postVote = postVoteDao.getUpVote(id);
	    	
	    	Integer upVoteCount = postVote.size();
	    	
	    	Date date = post.getTime();
	    	post.setCommentCount(commentCount);
	    	post.setUpVoteCount(upVoteCount);
	    	/*post.setviewCount((Integer)request.getAttribute("hitCounter"));*/
	    	if (comments != null) {
	    		model.addAttribute("comments", comments);
	        }
	        model.addAttribute("post", post);
	        model.addAttribute("date",date);
	        model.addAttribute("tags",tags);
	        model.addAttribute("commentCount",commentCount);
	        model.addAttribute("upVoteCount",upVoteCount);
	     
	    
	
	        return "view";
	    }
	   /* @RequestMapping(value = "/posts/view/{id}",method = RequestMethod.POST)
	    public String intoPostView(@PathVariable("id") Long id, ModelMap model) {
	    	Posts post = postService.getPostById(id);
	    	List<Comment> comments = commentService.listCommentByPostId(id);
	    	Collection<Tag> tags = (postService.getPostById(id)).getTags();
	    	List<PostVote> postVote = postVoteDao.getVote(id);
	    	
	    	if (comments != null) {
	    		model.addAttribute("comments", comments);
	        }
	        model.addAttribute("post", post);
	        model.addAttribute("tags",tags);
	        model.addAttribute("postVote",postVote);
	
	        return "posts/view";
	    }
	   */
	    
	    @RequestMapping(value = "/posts/view/{id}/delete")
	    public  String deletePost(@PathVariable("id") Long id,RedirectAttributes redirect) {
	        postService.deletePost(id);
	        return "redirect:/";
	    }
	    
	    @RequestMapping(value = "/posts/view/{id}/like")
	    public String like(@PathVariable("id") Long id,PostVote postVote,HttpServletRequest request,
	    		RedirectAttributes redirect)throws AlreadyVotedException {
	    	if(request.getSession().getAttribute("username") != null){
	    	Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));
	    	Posts post = postService.getPostById(id);
	    	if (postVoteDao.getUserVote(id, user.getId())!= null ){
	    		throw new AlreadyVotedException("cannot vote more than once");
	    	}
			postVote.setValue(Vote.UPVOTE_VALUE);
			postVote.setUser(user);
			postVote.setPost(post);
			postVoteDao.addPostVote(postVote);
	        return "redirect:/posts/view/{id}";
	        }else{
			    return "redirect:/users/login";
			    }
	    }

	     
	    @RequestMapping(value = "/posts/view/{id}/dislike", method = RequestMethod.GET)
	    public String dislike(@PathVariable("id") Long id,PostVote postVote,HttpServletRequest request,
	    		RedirectAttributes redirect) {
	    	if(request.getSession().getAttribute("username") != null){
	    	Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));
	    	Posts post = postService.getPostById(id);
		
			postVote.setValue(Vote.DOWNVOTE_VALUE);
			postVote.setUser(user);
			postVote.setPost(post);
			postVoteDao.addPostVote(postVote);
	    	

	        return "redirect:/posts/view/{id}";}
	    	else{
			    return "redirect:/users/login";
			    }
	    	
	}
	  
        @RequestMapping(value = "/posts/{tags.name}",method = RequestMethod.GET)
	    public String processTaggedPosts(@PathVariable("tags.name")String name, HttpServletRequest request,
	    		RedirectAttributes redirect,Model model){
	    	Tag tag = tagDao.getTagByTagname(name);
	    	List<Posts> post = postService.findPostsByTag(tag);
	    	model.addAttribute("post",post);
	    	return "tagged";
        	}
      
        @RequestMapping(value = "/searchPost", method = RequestMethod.GET)
	    public String processSerachPosts(@RequestParam("searchTerm")String searchTerm,Model model){
        	
        	List<Posts> searchPostsByTitle = postDao.getPostsByTitle(searchTerm);
        	List<Posts> searchPostsByUser = postDao.getPostsByUsername(searchTerm);
        	List<Posts> searchPosts = new ArrayList<>();
        	searchPosts.addAll(searchPostsByUser);
        	
        	searchPosts.addAll(searchPostsByTitle);
        	model.addAttribute("searchPosts",searchPosts);
        	model.addAttribute("searchTerm",searchTerm);
	    	return "searchPost";
        	}
 
   }
