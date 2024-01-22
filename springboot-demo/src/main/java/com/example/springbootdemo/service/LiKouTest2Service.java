package com.example.springbootdemo.service;


import com.example.springbootdemo.dto.TreeNode;

public interface LiKouTest2Service {

    TreeNode sortedArrayToBST(int[] nums);

    //给定一个二叉树，判断它是否是高度平衡的二叉树
    boolean isBalanced(TreeNode root);
}
