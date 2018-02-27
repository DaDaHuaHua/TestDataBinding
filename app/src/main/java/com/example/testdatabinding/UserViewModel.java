package com.example.testdatabinding;

import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableMap;

/**
 * <p> Created by 宋华 on 2018/2/26.
 */
public class UserViewModel extends User {
    public String name = "song";
    public int age = 10;
    public ObservableBoolean visible = new ObservableBoolean();
    public String nickName;
    public ObservableArrayMap<String ,String > childs = new ObservableArrayMap<>();

    public UserViewModel(String name, int age, String id ,boolean visible) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.visible.set(visible);
        childs.put("song","hua");
        childs.put("gao","yafei");
        childs.put("zhang","libin");

    }

    public UserViewModel(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
