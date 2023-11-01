package org.perscholas.springboot.controller;

import org.perscholas.springboot.database.entity.User;
import org.springframework.stereotype.Controller;

@Controller
public class SlashController {

    public void index() {
        User user = new User();

        user.setId(1);
        user.setUsername("eric@webworkbench.net");

    }

}
