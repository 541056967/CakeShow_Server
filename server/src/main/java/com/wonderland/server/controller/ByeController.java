package com.wonderland.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByeController {

    @RequestMapping("/bye")
    public String getBye(){
        return "byebye!";
    }
}
