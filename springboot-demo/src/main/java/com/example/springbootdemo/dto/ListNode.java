package com.example.springbootdemo.dto;

import com.example.springbootdemo.service.serviceimpl.LiKouTestServiceImpl;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
