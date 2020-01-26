package nipon.coding.practice;

/**
 * Problem: https://leetcode.com/problems/add-two-numbers/
 *
 * @author saiful.nipo
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        int[] a = new int[]{2, 4, 3};
        int[] b = new int[]{5, 6, 4};
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.prepareTestData(a);
        ListNode l2 = addTwoNumbers.prepareTestData(b);
        ListNode l3 = addTwoNumbers.addTwoNumbers(l1, l2);
        addTwoNumbers.print(l3);
    }

    private ListNode prepareTestData(int[] data) {
        ListNode head = new ListNode(0);
        for (int i : data) {
            ListNode next = new ListNode(i);
            next.next = head;
            head = next;
        }
        return head;
    }

    private void print(ListNode list) {
        System.out.println("\n");
        while (list.next != null) {
            System.out.print(list.val + "->");
            list = list.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode current = head;

        int carry = 0;
        while (l1 != null || l2 != null) {

            int l1Value = (l1 != null) ? l1.val : 0;
            int l2Value = (l2 != null) ? l2.val : 0;
            int sum = carry + l1Value + l2Value;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return head.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

}
