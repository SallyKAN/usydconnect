package com.usyd.elec5619.domain;

import javax.persistence.*;

/*comment vote model */
@Entity
@Table(name = "comment_votes",
        uniqueConstraints = @UniqueConstraint(columnNames = {"comment_id", "user_id"}))
public class CommentVote extends Vote  {
	@Id
    @GeneratedValue
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;

    public CommentVote(Users user, short value, Comment comment) {
        super(user, value);
        this.comment = comment;
    }

    public CommentVote() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}

