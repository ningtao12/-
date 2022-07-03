package com.itnt.controller;
import com.itnt.pojo.User;
import com.itnt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag=userService.save(user);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag=userService.delete(id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
    @PutMapping
    public Result update(@RequestBody User user) {
        boolean flag= userService.update(user);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User u = userService.getById(id);
        Integer code=u!=null?Code.GET_OK:Code.GET_ERR;
        String msg=u!=null?"":"同步数据失败，请刷新后重试";
        return new Result(code,u,msg);
    }
    @GetMapping
    public Result getAll() {
        List<User> all = userService.getAll();
        Integer code=all!=null?Code.GET_OK:Code.GET_ERR;
        String msg=all!=null?"":"同步数据失败，请刷新后重试";
        return new Result(code,all,msg);
    }
}
