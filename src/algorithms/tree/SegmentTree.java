package algorithmsAndDataStructures.tree;

/**
 * Created by lujianyu on 7/4/17.
 */
public class SegmentTree {

    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null) { return Integer.MIN_VALUE;}
        // in case of input out of range situation
        if (root.start >= start && root.end <= end) { return root.max;}
        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start > mid) {
            return query(root.right, start, end);
        } else {
            // to do
            return Math.max(query(root.left, start, mid), query(root.right, mid + 1, end));
        }
    }

    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if (root == null) { return;}
        if (root.start == root.end && root.start == index) {
            root.max = value;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (index <= mid) {
            modify(root.left, index, value);
        } else {
            modify(root.right, index, value);
        }
        // to do
        root.max = Math.max(root.left.max, root.right.max);
    }

    public SegmentTreeNode build(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int start = 0, end = A.length - 1;
        return buildTree(A, start, end);
    }

    private SegmentTreeNode buildTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);
            return node;
        }
        int mid = start + (end - start) / 2;
        SegmentTreeNode left = buildTree(A, start, mid);
        SegmentTreeNode right = buildTree(A, mid + 1, end);
        // to do
        SegmentTreeNode root = new SegmentTreeNode(start, end, Math.max(left.max, right.max));
        root.left = left;
        root.right = right;
        return root;
    }

    private class SegmentTreeNode {
        // to do
        public int start, end, max;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }
}
