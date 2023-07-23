package leetcode.linklist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并 K 个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        ListNode headNode = new ListNode(-1), p = headNode;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));

        for (ListNode listNode : lists) {
            if (null != listNode) {
                priorityQueue.add(listNode);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            if (null == poll) {
                continue;
            }

            // 将节点加到返回队列中
            p.next = new ListNode();
            p.next.val = poll.val;

            // 将下个节点加到优先队列中
            if (null != poll.next) {
                priorityQueue.add(poll.next);
            }
            p = p.next;
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

        System.out.println(mergeKLists(new ListNode[]{l1, l2}));
        System.out.println(l1);
        System.out.println(l2);;
    }
}

