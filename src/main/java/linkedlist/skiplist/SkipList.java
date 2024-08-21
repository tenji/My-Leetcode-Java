package linkedlist.skiplist;

/**
 * 跳表实现
 *
 * @author tenji
 * @date 2024-08-22
 */
public class SkipList {

    private Node head = new Node();  // 带头链表
    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;

    public void insert(int value) {

    }

    private static class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }
}
