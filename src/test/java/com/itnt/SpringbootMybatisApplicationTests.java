package com.itnt;

import com.itnt.dao.UserDao;
import com.itnt.pojo.User;
import com.itnt.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {
    @Autowired
private UserService userService;
    @Test
    void getAll() {
        List<User> userList=userService.getAll();
        System.out.println(userList);
    }

}
