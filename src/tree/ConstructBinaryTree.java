package tree;

/**
 * Created by lujianyu on 4/30/17.
 */
public class ConstructBinaryTree {
    /*
     * Construct Binary Tree from Inorder and Postorder Traversal
     */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree1(int[] inorder, int i_start, int i_end, int[] postorder, int p_start, int p_end) {
        if (p_start > p_end || i_start > i_end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[p_end]);
        int i = i_start;
        for (; i <= i_end; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        root.left = buildTree1(inorder, i_start, i - 1, postorder, p_start, p_end - i_end + i - 1);
        root.right = buildTree1(inorder, i + 1, i_end, postorder, p_end - i_end + i, p_end - 1);
        return root;
    }

    /*
     * Construct Binary Tree from Preorder and Inorder Traversal
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start > p_end || i_start > i_end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        int i = i_start;
        for (; i <= i_end; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }
        root.left = buildTree(preorder, p_start + 1, p_start + i - i_start, inorder, i_start, i - 1);
        root.right = buildTree(preorder, p_start + i - i_start + 1, p_end, inorder, i + 1, i_end);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
