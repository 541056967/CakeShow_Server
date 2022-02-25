package com.wonderland.server.controller;

import com.wonderland.server.CakeShowApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    TestModel testModel = (TestModel) CakeShowApplication.context.getBean(TestModel.class);

    @RequestMapping("/hello")
    public String getHello(){
        return testModel.message();
    }
}
