package com.juborajsarker.firebasetest;

/**
 * Created by jubor on 11/5/2017.
 */

public class Civil {

    String userName;
    String name;
    String id;
    String age;
    String university;


    public Civil() {
    }

    public Civil(String userName, String name, String id, String age, String university) {
        this.userName = userName;
        this.name = name;
        this.id = id;
        this.age = age;
        this.university = university;
    }


    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getUniversity() {
        return university;
    }
}



