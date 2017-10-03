package com.apiexample.users;

import java.util.ArrayList;
import java.util.List;

/**
 * UserドメインクラスとUserFormクラスの変換を行う。
 */
public class UserHelper {
    public static UserForm toForm(User user){
        UserForm userForm = new UserForm(
                user.getUserId()
                , user.getUsername()
                , user.getPassword()
                , user.getEmail()
        );
        return userForm;
    }

    public static List<UserForm> toFormList(List<User> users){
        List<UserForm> userForms = new ArrayList<>();
        users.stream()
                .forEach(u -> userForms.add(toForm(u)));
        return userForms;
    }

    public static User toEntity(UserForm userForm){
        User user = new User(
                userForm.getId()
                , userForm.getUsername()
                , userForm.getPassword()
                , userForm.getMail()
        );
        return user;
    }
}
