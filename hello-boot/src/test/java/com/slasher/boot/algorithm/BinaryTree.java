package com.slasher.boot.algorithm;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTree {
    public static void main(String[] args) {
        int nn[] = {1,2,3,7,5};
        int[] ints = Solution.twoSum(nn, 8);
        System.out.println(Arrays.toString(ints));
    }

}
class Solution{
    /**
     * 由于哈希查找的时间复杂度为 O(1)，所以可以利用哈希容器 map 降低时间复杂度
     * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
     * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
     * 如果最终都没有结果则抛出异常
     * 时间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{ map.get(target - nums[i]),i};
            }
            map.put(nums[i],i );
        }
        throw new IllegalArgumentException("No two sum solution");

    }
}
