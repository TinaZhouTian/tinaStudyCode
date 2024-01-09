package com.example.springbootdemo.service;

import com.example.springbootdemo.service.serviceimpl.LiKouTestServiceImpl;

public interface LiKouTestService {
    int lengthOfLastWord(String s);

    int[] plusOne(int[] digits);

    String addBinary(String a, String b);

    LiKouTestServiceImpl.ListNode deleteDuplicates(LiKouTestServiceImpl.ListNode head);
}
