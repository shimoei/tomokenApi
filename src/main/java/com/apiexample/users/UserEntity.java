package com.apiexample.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 */
@Entity
@Data
@Table(name="User")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    // ユーザID
    @Id
    private int id;

    // ユーザ名
    private String username;

    // パスワード
    private String password;

    // メールアドレス
    private String email;

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        //引数のobjetのnullチェック、型チェックを行う。
        if (object == null || !(object instanceof UserEntity)) {
            return false;
        }

        UserEntity o = (UserEntity) object;

        if (this.id == o.getId()
                && this.username.equals(o.getUsername())
                && this.password.equals(o.getPassword())
                && this.email.equals(o.getEmail()))
        {
            return true;
        }else {
            return false;
        }
    }
}
