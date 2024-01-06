package linkedlist;

/**
 * 2807. 在链表中插入最大公约数
 *
 * @author tenji
 * @date 2024-01-06
 */
public class InsertGreatestCommonDivisors2807 {

    public static void main(String[] args) {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        // 输入：head = [18,6,10,3]
        // 输出：[18,6,6,2,10,1,3]
        System.out.println(new InsertGreatestCommonDivisors2807().insertGreatestCommonDivisorsOptimized(head));

    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        /*
        1、定义两个指针 front 和 end，分别指向相邻两个结点
        2、在两个结点之间插入最大公约数之后，移动两个指针到下一个相邻的两个结点
        3、front 移动到链表最后一个节点之后，返回 head
         */

        // 只有一个节点
        if (head.next == null) {
            return head;
        }

        ListNode front = head;
        ListNode end = head.next;

        while (front.next != null) {
            ListNode tmp = new ListNode(getCommonDivisors(front.val, end.val));
            front.next = tmp;
            tmp.next = end;

            // 移动指针
            front = end;
            end = end.next;
        }

        return head;
    }

    public ListNode insertGreatestCommonDivisorsOptimized(ListNode head) {
        /*
        1、在两个结点之间插入最大公约数节点
        2、指针向后移动两个结点
         */

        // 只有一个节点
        if (head.next == null) {
            return head;
        }

        ListNode front = head;
        while (front.next != null) {
            ListNode tmp = new ListNode(getCommonDivisors(front.val, front.next.val));
            tmp.next = front.next;
            front.next = tmp;

            // 移动指针
            front = front.next.next;
        }

        return head;
    }

    private int getCommonDivisors(int a, int b) {
        // 欧几里得算法计算最大公约数
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
