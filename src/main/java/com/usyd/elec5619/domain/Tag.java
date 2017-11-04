package com.usyd.elec5619.domain;


import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.Collection;

/* tag model */
@Transactional
@Entity
@Table(name = "tags")

public class Tag {
	@Id
    @GeneratedValue
    private Long Id;

    @Column(length = 30, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tags",cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Posts> posts = new ArrayList<>();

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Posts> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Posts> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }
}

