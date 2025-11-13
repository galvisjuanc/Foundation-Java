package jcgc.play.platform;

import jcgc.play.content.Content;

import java.time.LocalDateTime;

public class User {

    public String name;
    public String email;
    public LocalDateTime createdDate;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.createdDate = LocalDateTime.now();
    }

    public void watch(Content content) {
        System.out.println(name + " is watching...");
        content.play();
    }

    public String getName() {
        return name;
    }

    public String email() {
        return email;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
