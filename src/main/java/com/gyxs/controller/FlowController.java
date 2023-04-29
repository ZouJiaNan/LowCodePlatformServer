package com.gyxs.controller;

import com.gyxs.service.FlowService;
import com.gyxs.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class FlowController {

    @Autowired
    FlowService flowService;

    @GetMapping("/start")
    public void start(@RequestParam("data") String data) {
        System.out.println(data);
        TestService.test(data);
//        flowService.start(data);
    }
}
