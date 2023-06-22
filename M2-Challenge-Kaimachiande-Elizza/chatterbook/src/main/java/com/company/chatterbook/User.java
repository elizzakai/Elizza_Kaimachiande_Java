package com.company.chatterbook;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<ChatterPost> chatterPosts = new ArrayList<ChatterPost>();

    public User(String n, List<ChatterPost> chats) {
        name = n;
        chats = chatterPosts;
    }

    public User(String n) {
        name = n;
    }

    public void setChatterPosts(List<ChatterPost> chatterPosts) {
        this.chatterPosts = (chatterPosts == null) ? new ArrayList<>() : new ArrayList<ChatterPost>(chatterPosts);
    }

    //cite stackoverflow:https://stackoverflow.com/questions/23983415/private-list-with-getter-setter-vs-public-list

    public List<ChatterPost> getChatterPosts(){
        return chatterPosts;
    }
    public String getName() {return name;}
    public String toString() {
        String s = "Name: " + name + ", " + "ChatterPosts: " + chatterPosts.toString();
        return s;
    }


    public User() {}
}
