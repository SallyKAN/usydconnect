package com.usyd.elec5619.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.usyd.elec5619.domain.Posts;
import com.usyd.elec5619.service.PostService;
import org.springframework.http.HttpHeaders;
@RestController
public class RESTfulController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "/posts/rest", method = RequestMethod.GET,produces = "application/json")
    public  ResponseEntity<List<Posts>> posts() {
	    HttpHeaders headers = new HttpHeaders();
        List<Posts> posts = postService.findAll();
        return new ResponseEntity<List<Posts>>(posts, headers, HttpStatus.OK);}
       
        @RequestMapping(value = "/posts/rest/{id}", method = RequestMethod.GET)
        public Posts getPost(@PathVariable("id") long id) {
        	
            Posts post = postService.getPostById(id);
            Posts post_return = new Posts();
            
            return post;
        
      }
}








