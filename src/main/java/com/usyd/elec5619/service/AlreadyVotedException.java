package com.usyd.elec5619.service;

public class AlreadyVotedException extends Exception {

    public AlreadyVotedException(String message) {
        super(message);
    }
}
