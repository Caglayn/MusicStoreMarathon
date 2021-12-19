package com.caglayan.maraton.utils;

import com.caglayan.maraton.entities.UserEntity;

public class AccountUtil {
    private static AccountUtil instance;

    private UserEntity activeUser;

    private AccountUtil(){
    }

    public static AccountUtil getInstance(){
        if (instance == null){
            instance = new AccountUtil();
        }
        return instance;
    }

    public UserEntity getActiveUser(){
        return this.activeUser;
    }

    public void setActiveUser(UserEntity activeUser){
        this.activeUser = activeUser;
    }
}
