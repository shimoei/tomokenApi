package com.apiexample.users;

import com.apiexample.TomokenApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TomokenApi.class})
@SpringApplicationConfiguration(classes = JacksonAutoConfiguration.class)
public class UsersControllerTest {

    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UsersController usersController;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(usersController).build();


        // DBセットアップ
        userRepository.deleteAll();

        UserEntity userEntity1 = new UserEntity(1, "user1", "password", "user1@test");
        userRepository.save(userEntity1);
        UserEntity userEntity2 = new UserEntity(2, "user2", "password", "user2@test");
        userRepository.save(userEntity2);
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void gettest() throws Exception {

        //想定結果
        int id = 1;
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("id", 1);
        map.put("username", "user1");
        map.put("password", "password");
        map.put("mail", "user1@test");
        String expect = mapper.writeValueAsString(map);

        //結果
        ResultActions resultActions = mvc.perform(get("/api/users/1"));

        //想定と結果を比較
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().json(expect));
    }

    @Test
    public void getAll() throws Exception {

        //想定結果
        List<Map<String, Object>> maps = new ArrayList<>();
        Map<String, Object> map1 = new LinkedHashMap<>();
        map1.put("id", 1);
        map1.put("username", "user1");
        map1.put("password", "password");
        map1.put("mail", "user1@test");
        maps.add(map1);

        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("id", 2);
        map2.put("username", "user2");
        map2.put("password", "password");
        map2.put("mail", "user2@test");
        maps.add(map2);

        String expect = mapper.writeValueAsString(maps);

        //結果
        ResultActions resultActions = mvc.perform(get("/api/users/all"));

        //想定と結果を比較
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().json(expect));
    }

    @Test
    public void updateUserTest() throws Exception {
        //更新前の状態を確認
        UserEntity beforeActual = userRepository.findById(1);
        UserEntity beforeExpect = new UserEntity(1, "user1", "password", "user1@test");
        Assert.assertEquals(beforeExpect, beforeActual);

        // 送信フォーム作成
        UserForm userForm = new UserForm(
                1
                , "updateUserName"
                ,"updatedPass"
                , "updatedMail"
        );
        String jsonStr = mapper.writeValueAsString(userForm);

        // 想定結果
        String expect = mapper.writeValueAsString(userForm);

        //結果
        ResultActions resultActions = mvc.perform(
                put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonStr)
        );

        // 想定と結果を比較する。
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().json(expect));

        //更新後の状態を確認
        UserEntity afterActual = userRepository.findById(1);
        UserEntity afterExpect = new UserEntity(1, "updateUserName", "updatedPass", "updatedMail");
        Assert.assertEquals(afterExpect, afterActual);
    }
}