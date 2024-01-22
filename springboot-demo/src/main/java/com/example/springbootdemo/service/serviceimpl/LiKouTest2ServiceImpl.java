package com.example.springbootdemo.service.serviceimpl;


import com.example.springbootdemo.dto.TreeNode;
import com.example.springbootdemo.service.LiKouTest2Service;
import org.springframework.stereotype.Service;

@Service
public class LiKouTest2ServiceImpl implements LiKouTest2Service {

    //算法相关
    //二叉树

    //给你一个整数数组nums,其中元素已经按升序排列，请你将其转换为一颗高度平衡二叉搜索树。
    //高度平衡二叉树是一颗满足（每个结点的左右两个子树的高度差绝对值不超过1）的二叉树
    @Override
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        // 以升序数组的中间元素作为根节点 root。
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归的构建 root 的左子树与右子树。
        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);
        return root;
    }

    //给定一个二叉树，判断它是否是高度平衡的二叉树
    @Override
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


}
