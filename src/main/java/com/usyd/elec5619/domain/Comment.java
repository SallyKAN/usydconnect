package com.usyd.elec5619.domain;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.hibernate.validator.constraints.NotBlank;

/*comment model */
@Entity
@Table(name = "comments")
public class Comment {
	@javax.persistence.Id
	@GeneratedValue
	private Long Id;
	@Lob
    @Column(nullable = false)
    @NotBlank
	private String commentText;
	
	@Column(nullable = true)
	private LocalDateTime dateTime;
	
	@Column(nullable = true)
	private LocalDateTime modifiedDateTime;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
	private Users user;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
	private Posts post;
	
	@Column(nullable = false)
	private boolean deleted = false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	private Comment parentComment;
	
	@Column(nullable = false)
	private String commentUsername;
	@Column(nullable = false)
	private Integer upVoteCount = 0;
	
	//@OneToMany(mappedBy="parentComment", cascade = CascadeType.ALL)
	//@OrderBy("LocalDateTime")
	//private List<Comment> childrenComments = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "comment")
	private List<CommentVote> commentVote = new ArrayList<>();

	public int commentLevel() {
        Comment comment = this;
        int level = 0;
        while ((comment = comment.getParentComment()) != null)
            level++;
        return level;
    }
	
	public int getRatingSum() {
	        return commentVote.stream().mapToInt(Vote::getValue).sum();
	    }
	public short getUserVoteValue(Long userId) {
        if (userId == null)
            return 0;

        Optional<CommentVote> vote = commentVote.stream().filter(r -> r.getUser().getId().equals(userId)).findFirst();
        return vote .isPresent() ? vote.get().getValue() : 0;
    }
	public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    public String getCommentText() {
        return commentText;
    }
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    public LocalDateTime getLocalDateTime() {
        return dateTime;
    }

    public void setLocalDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public LocalDateTime getModifiedLocalDateTime() {
        return modifiedDateTime;
    }

    public void setModifiedTime(LocalDateTime modifiedDateTime) {
        this.modifiedDateTime = modifiedDateTime;
    }
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }
    //public List<Comment> getChildrenComments() {
       //return childrenComments;
    //}

    //public void setChildrenComments(List<Comment> childrenComments) {
        //this.childrenComments = childrenComments;
   // }
    public void setCommentUsername(String commentUsername){
    	this.commentUsername = commentUsername;
    }
    public String getCommentUsername(){
    	return commentUsername;
    }
    
    public List<CommentVote> getCommentVote() {
        return commentVote;
    }

    public void setCommentRatings(List<CommentVote> commentVote) {
        this.commentVote = commentVote;
    }
    public void setUpVoteCount(Integer upVoteCount){
    	this.upVoteCount = upVoteCount;
    }
    public Integer getUpVoteCount(){
    	return upVoteCount;
    }
    
}
