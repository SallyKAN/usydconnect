package com.usyd.elec5619.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usyd.elec5619.dao.CommentDao;
import com.usyd.elec5619.dao.CommentVoteDao;
import com.usyd.elec5619.domain.Comment;
import com.usyd.elec5619.domain.CommentVote;
import com.usyd.elec5619.domain.PostVote;
import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.domain.Users;
import com.usyd.elec5619.domain.Vote;
import com.usyd.elec5619.service.CommentService;
import com.usyd.elec5619.service.PostService;
import com.usyd.elec5619.service.UserService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


/* controller for comments */

@Controller
@Transactional
public class CommentController {
	@Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentVoteDao commentVoteDao;



	@RequestMapping(value = "/posts/view/{id}/comments/create", method =RequestMethod.POST)
    public String createComments(@PathVariable("id") Long id,Comment comment,HttpServletRequest request,RedirectAttributes redirect) {
		if(request.getSession().getAttribute("username") != null){
		Posts post = postService.getPostById(id);
		Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));
		comment.setUser(user);
		comment.setPost(post);
		comment.setCommentUsername(user.getUsername());
		
		commentService.addComment(comment);
        return "redirect:/posts/view/{id}";
		}else
			return "redirect:/users/login";
	}
	@RequestMapping(value = "/posts/view/{id}/comments/{commentId}/like")
    public String commentsLike(@PathVariable("id") Long id,@PathVariable("commentId") Long commentId,
    	CommentVote commentVote, HttpServletRequest request,RedirectAttributes redirect) {
		if(request.getSession().getAttribute("username") != null){
		Comment comment = commentService.getCommentById(commentId);
		commentVote.setValue(Vote.UPVOTE_VALUE);
		Users user = userService.getUserByUsername((String)request.getSession().getAttribute("username"));
		commentVote.setUser(user);
		commentVote.setComment(comment);
		commentVoteDao.addCommentVote(commentVote);
		List<CommentVote> commentUpVote = commentVoteDao.getUpVote(commentId);
		Integer commentUpVoteCount = commentUpVote.size();
		comment.setUpVoteCount(commentUpVoteCount);
        return "redirect:/posts/view/{id}";
		}else
			return "redirect:/users/login";
	}
	@RequestMapping(value = "/posts/view/{id}/comments/{commentId}/delete")
    public String commentsDelete(@PathVariable("commentId") Long commentId,
             HttpServletRequest request,RedirectAttributes redirect) {
	      {
	          commentService.deleteCommentById(commentId);
               return "redirect:/posts/view/{id}";
	      }
	}
	
}








