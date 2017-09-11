package com.jia.users;

import com.jia.users.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @RequestMapping("/login")
    public User login(User user){
        return user;
    }
}
