package simple;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q86 {
    public static ListNode partition(ListNode head, int x) {
        ListNode gHead = new ListNode(-1);
        ListNode lHead = new ListNode(-1);

        ListNode p = head, g1 = gHead, l1 = lHead;

        while (null != p) {
            if (p.val < x) {
                g1.next = new ListNode();
                g1.next.val = p.val;
                g1 = g1.next;
            } else {
                l1.next = new ListNode();
                l1.next.val = p.val;
                l1 = l1.next;
            }
            p = p.next;
        }

        g1.next = lHead.next;

        return gHead.next;
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

        ListNode listNode = partition(l1, 6);
        System.out.println(listNode);
        System.out.println(l1);
    }
}

