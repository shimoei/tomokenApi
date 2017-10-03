package com.apiexample.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    /**
     * IDをもとにJobEntityを取得する。
     *
     * @param id id
     * @return JobEntity
     */
    UserEntity findById(int id);

    /**
     * ユーザ名をもとにユーザを取得する。
     *
     * @param username
     * @return
     */
    List<UserEntity> findByUsername(String username);
}
