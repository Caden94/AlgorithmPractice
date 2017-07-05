package tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by lujianyu on 4/30/17.
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Tree {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeLinkNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                /*
                 * Poll & Offer
                 */
                TreeLinkNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                /*
                 * Execute
                 */
                if (i + 1 >= size) {
                    continue;
                }
                node.next = queue.peek();
            }
        }
    }
}
