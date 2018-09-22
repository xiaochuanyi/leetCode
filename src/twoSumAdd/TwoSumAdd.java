package twoSumAdd;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

public class TwoSumAdd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode re = addTwoNumbers(l1,l2);
        while (re != null){
            System.out.println(re.val);
            re = re.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode curr = new ListNode(0);//结果的头节点的上一个节点
        ListNode p = l1, q = l2, node = curr;
        int c = 0;
        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = c + x + y;
            c = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null){
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if(c > 0){
            curr.next = new ListNode(c);
        }
        return node.next;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }