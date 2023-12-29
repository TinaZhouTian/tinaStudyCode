package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.LiKouTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("LiKouTest")
public class LiKouTestController {

    @Autowired
    private LiKouTestService liKouTestService;

    @PostMapping("/test1")
    public int lengthOfLastWord(String s) {
        return liKouTestService.lengthOfLastWord(s);
    }

    @PostMapping("/test2")
    public int[] plusOne(int[] digits) {
        return liKouTestService.plusOne(digits);
    }

    @PostMapping("/test3")
    public String addBinary(String a, String b) {
        return liKouTestService.addBinary(a, b);
    }
}
