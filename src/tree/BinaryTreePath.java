package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lujianyu on 4/30/17.
 */
public class BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        // Get Paths
        List<String> paths = new ArrayList<>();
        if (root == null) { return paths; }
        search(root, new ArrayList<>(), paths);
        return paths;
    }

    private void search(TreeNode root, List<Integer> path, List<String> paths) {
        /*
         * Exit
         */
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path.add(root.val);
            paths.add(convertToString(path));
            path.remove(path.size() - 1);
            return;
        }
        /*
         * Back Tracking
         */
        path.add(root.val);
        search(root.left, path, paths);
        search(root.right, path, paths);
        path.remove(path.size() - 1);
    }

    private String convertToString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        int size = path.size();
        for (int i = 0; i < size; i++) {
            sb.append(path.get(i));
            if (i != size - 1) {
                sb.append("->");
            }
        }
        return sb.toString();
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
