package com.irish.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irish.dto.User;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User user) {
        // 仅测试验证过程，省略其他的逻辑
        return user;
    }
    
    
    @GetMapping("/{name}/detail")
    public User getUserByName(
                    @NotNull 
                    @Size(min = 1, max = 5, message = "用户名格式有误")
                    @PathVariable String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    @GetMapping("/getName/detail")
    public User getUserByNameParam(
                    @NotNull 
                    @Size(min = 1, max = 4, message = "用户名格式有误") 
                    @RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        return user;
    }
}