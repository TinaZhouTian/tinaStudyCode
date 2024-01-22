package com.example.springbootdemo.controller;

import com.example.springbootdemo.dto.TreeNode;
import com.example.springbootdemo.service.LiKouTest2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("LiKouTest2")
public class LiKouTest2Controller {

    @Autowired
    private LiKouTest2Service liKouTest2Service;

    @PostMapping("/test1")
    public TreeNode sortedArrayToBST(int[] nums) {
        return liKouTest2Service.sortedArrayToBST(nums);
    }

    @PostMapping("/test2")
    public boolean isBalanced(TreeNode root) {
        return liKouTest2Service.isBalanced(root);
    }

}
