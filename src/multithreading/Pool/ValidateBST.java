package multithreading.Pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RecursiveTask;

/**
 * Created by lujianyu on 7/22/17.
 */
public class ValidateBST {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }


    public class ForkJoinTraversalTask extends RecursiveTask<Boolean> {
        TreeNode root;
        long minVal;
        long maxVal;
        int height;

        public ForkJoinTraversalTask(TreeNode root, int height, long minVal, long maxVal) {
            this.root = root;
            this.height = height;
            this.maxVal = maxVal;
            this.minVal = minVal;
        }

        public Boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null) { return true;}
            if (root.val >= maxVal || root.val <= minVal) { return false;}
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
        }

        @Override
        public Boolean compute() {
            if (height <= 3) {
                return isValidBST(root, this.minVal, this.maxVal);
            }
            ForkJoinTraversalTask left = new ForkJoinTraversalTask(root.left, height - 1, minVal, root.val);
            ForkJoinTraversalTask right = new ForkJoinTraversalTask(root.right, height - 1, root.val, maxVal);
            left.fork();
            right.fork();

            return left.join() && right.join();
        }
    }
}
