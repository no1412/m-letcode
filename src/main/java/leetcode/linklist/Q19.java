package leetcode.linklist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 19. 删除链表的倒数第 N 个结点
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = new ListNode(-1);
        p1.next = head;

        // 获取倒数第n + 1个节点
        ListNode lastNode = findLastNode(p1, n + 1);
        lastNode.next = lastNode.next.next;

        return p1.next;
    }

    /**
     * 获取倒数第几个节点
     *
     * @param head 节点
     * @param n    倒数节点数
     * @return 返回倒数第n个节点
     */
    public static ListNode findLastNode(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        // p1先走 n 步
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        // p1走到末尾时，p2 走了length - n 步数，即为倒数第n个节点
        while (null != p1) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
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

        System.out.println(removeNthFromEnd(l1, 3));
        System.out.println(l1);
    }
}

