package stack.monotonicstack;

import linkedlist.ListNode;

import java.util.*;

/**
 * 2487. 从链表中移除节点
 *
 * @author tenji
 * @date 2024-01-04
 */
public class RemoveNodesFromLinkedList2487 {

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        // 输入：head = [5,2,13,3,8]
        // 输出：[13,8]

        System.out.println(new RemoveNodesFromLinkedList2487().removeNodes(head));
    }

    public ListNode removeNodes(ListNode head) {
        /*
        1、遍历 head 链表，得到数组 array1
        2、使用单调栈，得到数组中每一个元素的下一个更大的元素，没有下一个更大元素的记为 -1，得到数组 array2
        3、遍历数组 array2，根据元素为 -1 的索引值，从 array1 中得到原始值，并生成新的链表然后返回
         */

        ListNode node = head;
        List<Integer> valList = new ArrayList<>();
        while (node != null) {
            valList.add(node.val);
            node = node.next;
        }

        // 存放下一个更大的元素
        int[] tmp = new int[valList.size()];
        Deque<Integer> stack = new LinkedList<>();
        // 倒着往栈里放
        for (int i = tmp.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= valList.get(i)) {
                stack.pop();
            }

            tmp[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(valList.get(i));
        }

        // 头结点
        ListNode res = new ListNode(-1);
        node = res;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == -1) {
                node.next = new ListNode(valList.get(i));
                node = node.next;
            }
        }

        return res.next;
    }
}
