package com.apiexample.users;

import java.util.ArrayList;
import java.util.List;

/**
 * DomainクラスとEntityクラスをマッピングする。
 */
public class UserMapper {
    public static User toDomain(UserEntity userEntity) {
        User user = new User(
                userEntity.getId()
                , userEntity.getUsername()
                , userEntity.getPassword()
                , userEntity.getEmail()
        );
        return user;
    }

    public static List<User> toDomains(List<UserEntity> userEntityList){
        List<User> users = new ArrayList<>();
        userEntityList.stream()
                .forEach(e -> users.add(toDomain(e)));
        return users;
    }

    public static UserEntity toEntity(User user){
        UserEntity userEntity = new UserEntity(
                user.getUserId()
                , user.getUsername()
                , user.getPassword()
                , user.getEmail()
        );

        return userEntity;
    }
}
