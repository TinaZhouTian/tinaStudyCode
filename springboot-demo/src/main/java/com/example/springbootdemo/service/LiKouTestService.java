package com.example.springbootdemo.service;

import com.example.springbootdemo.dto.ListNode;
import com.example.springbootdemo.service.serviceimpl.LiKouTestServiceImpl;

public interface LiKouTestService {
    int lengthOfLastWord(String s);

    int[] plusOne(int[] digits);

    String addBinary(String a, String b);

    ListNode deleteDuplicates(ListNode head);

    void merge(int[] nums1, int m, int[] nums2, int n);
}
