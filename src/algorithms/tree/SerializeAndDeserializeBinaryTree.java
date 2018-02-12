package algorithmsAndDataStructures.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lujianyu on 7/11/17.
 */
public class SerializeAndDeserializeBinaryTree {
    // BFS
    // "[1,2,3,null,null,4,5]"
    // "1,2,3,#,#,4,5"
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // corner case
        if (root == null) {
            return "";
        }
        // BFS
        // Deque<TreeNode> queue = new ArrayDeque<>(); -> can't put null value in the deque
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#,");
                continue;
            }
            sb.append(node.val + ",");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        sb.deleteCharAt(sb.length() - 1);
        // return
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // corner case
        if (data == null || data.length() == 0) {
            return null;
        }
        // BFS
        String[] nums = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nums[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (i < nums.length && !queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (++i < nums.length) {
                node.left = nums[i].equals("#") ? null : new TreeNode(Integer.parseInt(nums[i]));
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (++i < nums.length) {
                node.right = nums[i].equals("#") ? null : new TreeNode(Integer.parseInt(nums[i]));
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        // return
        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
