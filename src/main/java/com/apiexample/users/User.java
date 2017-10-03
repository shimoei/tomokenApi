package com.apiexample.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ユーザのドメインクラス
 */
@AllArgsConstructor
public class User {
    // ユーザID
    @Getter
    private int userId;

    // ユーザ名
    @Getter
    private String username;

    // パスワード
    @Getter
    private String password;

    // メールアドレス
    @Getter
    private String email;

}
