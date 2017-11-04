package com.usyd.elec5619.domain;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vote {
	public static final short UPVOTE_VALUE = 1;
    public static final short DOWNVOTE_VALUE = -1;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    protected Users user;
    
    protected short value;
    
    public Vote(Users user, short value) {
        this.user = user;
        this.value = value;
    }
    public Vote() {

    }
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }
}

