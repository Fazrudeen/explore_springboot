package com.samplejava.springboot.controller;

import com.samplejava.springboot.model.UserRequest;
import com.samplejava.springboot.model.Users;
import com.samplejava.springboot.service.SampleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/use_db/v1")
public class DataBaseController {

    private SampleService sampleService;

    public DataBaseController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @PostMapping(path = "/save_user")
    public Users saveDB(@RequestBody UserRequest userRequest) throws Exception {
        return sampleService.saveDB(userRequest);
    }
}
