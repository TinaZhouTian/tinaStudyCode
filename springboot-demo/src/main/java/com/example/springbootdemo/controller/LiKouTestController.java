package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.LiKouTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("LiKouTest")
public class LiKouTestController {

    @Autowired
    private LiKouTestService liKouTestService;

    @PatchMapping("/test1")
    public int lengthOfLastWord(String s) {
        return liKouTestService.lengthOfLastWord(s);
    }

}
