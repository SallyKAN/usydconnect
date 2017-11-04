package com.usyd.elec5619.domain;


import javax.persistence.*;

/* post vote model */
@Entity
@Table(name = "post_votes",
    uniqueConstraints = @UniqueConstraint(columnNames = {"post_id", "user_id"}))
public class PostVote extends Vote{
	@Id
    @GeneratedValue
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Posts post;

    public PostVote(Users user, short value, Posts post) {
        super(user,value);
        this.post = post;
    }

    public PostVote() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }
}

