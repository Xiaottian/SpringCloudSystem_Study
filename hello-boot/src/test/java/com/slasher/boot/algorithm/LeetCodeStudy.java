package com.slasher.boot.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 力扣网上算法练习
 */
public class LeetCodeStudy {

    /**
     * 将当前结点初始化为返回列表的哑结点。
     * 将进位 carry 初始化为 00。
     * 将 p 和 q 分别初始化为列表 l1 和 l2 的头部。
     * 遍历列表 l1 和 l2 直至到达它们的尾端。
     * 将 x 设为结点 p 的值。如果 p 已经到达 l1 的末尾，则将其值设置为 0。
     * 将 y 设为结点 q 的值。如果 q 已经到达 l2 的末尾，则将其值设置为 0。
     * 设定 sum = x + y + carrysum=x+y+carry。
     * 更新进位的值，carry = sum / 10carry=sum/10。
     * 创建一个数值为 (sum \bmod 10)(summod10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     * 同时，将 p 和 q 前进到下一个结点。
     * 检查 carry = 1carry=1 是否成立，如果成立，则向返回列表追加一个含有数字 11 的新结点。
     * 返回哑结点的下一个结点。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;//
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    @Test
    public void test1(){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode.val + "--" + listNode.next.val + "--" + listNode.next.next.val);
    }

    //-------------------------------------------------------------------------------

    /**
     * 无重复字符的最长字串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubString(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubString1(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    @Test
    public void test2(){
        int abcccef = lengthOfLongestSubString("abccdcbadf");
        System.out.println(abcccef);
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}