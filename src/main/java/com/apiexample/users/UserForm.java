package com.apiexample.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * ユーザフォーム
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserForm {
    // ユーザID
    @NotNull
    int id;

    //ユーザ名
    @NotNull
    @Size(min = 1, max = 20)
    String username;

    // パスワード
    @NotNull
    @Size(min = 1, max = 20)
    String password;

    // メール
    @NotNull
    @Size(min = 1, max = 20)
    String mail;
}
