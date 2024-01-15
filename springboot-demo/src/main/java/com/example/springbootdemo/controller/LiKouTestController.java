package com.example.springbootdemo.controller;

import com.example.springbootdemo.service.LiKouTestService;
import com.example.springbootdemo.service.serviceimpl.LiKouTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/test4")
    public LiKouTestServiceImpl.ListNode deleteDuplicates(LiKouTestServiceImpl.ListNode head) {
        return liKouTestService.deleteDuplicates(head);
    }

    @PostMapping("/test5")
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        liKouTestService.merge(nums1, m, nums2, n);
    }

}
