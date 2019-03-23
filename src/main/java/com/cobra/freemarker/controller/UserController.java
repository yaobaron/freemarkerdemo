package com.cobra.freemarker.controller;

import com.cobra.freemarker.service.StaticService;
import com.cobra.freemarker.service.UserService;
import com.cobra.freemarker.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: Baron
 * @Description:
 * @Date: Created in 2019/3/23 22:25
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StaticService staticService;

    @GetMapping("/list")
    public ModelAndView index(ModelAndView modelAndView, Map<String, Object> map) {
        Collection<User> users = userService.findAllUsers();
        map.put("users",users);
        return new ModelAndView("list",map);
    }

    @GetMapping("/{userId}")
    public ModelAndView detail(@PathVariable("userId")Integer userId, Map<String, Object> map) {
        User user = userService.findById(userId);
        map.put("user", user);
        return new ModelAndView("detail",map);
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("add");
    }

    @PostMapping("/save")
    public ModelAndView save(User user) {
        userService.add(user);
        staticService.createIndexHtml();
        return new ModelAndView("success");
    }

}
