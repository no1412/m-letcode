package leetcode.linklist;

import java.util.Arrays;
import java.util.List;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode headNode = new ListNode(-1), p = headNode;
        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = new ListNode();
                p.next.val = p2.val;
                p2 = p2.next;
            } else {
                p.next = new ListNode();
                p.next.val = p1.val;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return headNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 1;
        l1.next = new ListNode();
        l1.next.val = 3;
        l1.next.next = new ListNode();
        l1.next.next.val = 5;

        ListNode l2 = new ListNode();
        l2.val = 4;
        l2.next = new ListNode();
        l2.next.val = 5;
        l2.next.next = new ListNode();
        l2.next.next.val = 7;
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);
        System.out.println(l1);
        System.out.println(l2);
    }
}

