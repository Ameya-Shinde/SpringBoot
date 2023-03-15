package com.geekster.blogger.Util;




public class CurrentUser {


    public static int currentUser;


    public static int setCurrentUser(int userId) {
        currentUser = userId;
        return currentUser;
    }
}
