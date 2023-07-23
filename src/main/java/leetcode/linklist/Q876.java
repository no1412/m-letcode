package leetcode.linklist;

/**
 * 876. 链表的中间结点
 *
 *给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[3,4,5]
 * 解释：链表只有一个中间结点，值为 3 。
 * 示例 2：
 *
 *
 * 输入：head = [1,2,3,4,5,6]
 * 输出：[4,5,6]
 * 解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
 *
 * 提示：
 *
 * 链表的结点数范围是 [1, 100]
 * 1 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/middle-of-the-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q876 {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        // 快指针每次走2步，慢指针每次走1步
        while (null != slow && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 慢指针指向中点，偶数情况时为后面的那个节点
        return slow;
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
        l1.next.val = 4;
        l1.next.next = new ListNode();
        l1.next.next.val = 5;
        l1.next.next.next = new ListNode();
        l1.next.next.next.val = 7;
        l1.next.next.next.next = new ListNode();
        l1.next.next.next.next.val = 6;

        ListNode listNode = middleNode(l1);
        System.out.println(listNode);
        System.out.println(l1);
    }
}

