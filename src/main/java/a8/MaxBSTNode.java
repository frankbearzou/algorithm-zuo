package a8;

public class MaxBSTNode {
    public Node maxBSTNode(Node root) {
        return find(root).node;
    }

    private Pairs find(Node root) {
        if (root == null) {
            return null;
        }
        Pairs left = find(root.left);
        Pairs right = find(root.right);
        Pairs pairs = new Pairs();

        if (left == null && right == null) {
            pairs.leftMaxValue = root.value;
            pairs.rightMinValue = root.value;
            pairs.count = 1;
            pairs.isBST = true;
            pairs.node = root;
        } else if (left == null && right != null) {
            pairs.leftMaxValue = root.value;
            pairs.rightMinValue = Math.min(root.value, right.rightMinValue);
            pairs.isBST = right.isBST && root.value < right.rightMinValue;
            pairs.count = right.count + (pairs.isBST ? 1 : 0);
            pairs.node = pairs.isBST ? root : right.node;
        } else if (left != null && right == null) {
            pairs.leftMaxValue = Math.max(root.value, left.leftMaxValue);
            pairs.rightMinValue = root.value;
            pairs.isBST = left.isBST && root.value > left.leftMaxValue;
            pairs.count = left.count + (pairs.isBST ? 1 : 0);
            pairs.node = pairs.isBST ? root : left.node;
        } else if (left != null && right != null) {
            pairs.leftMaxValue = Math.max(root.value, left.leftMaxValue);
            pairs.rightMinValue = Math.min(root.value, right.rightMinValue);
            pairs.isBST = left.isBST && right.isBST && root.value > left.leftMaxValue && root.value < right.rightMinValue;
            pairs.count = pairs.isBST ? left.count + right.count + 1 : Math.max(left.count, right.count);
            pairs.node = pairs.isBST ? root : (left.count > right.count ? left.node : right.node);
        }

        return pairs;
    }
}

class Pairs {
    int leftMaxValue;
    int rightMinValue;
    int count;
    boolean isBST;
    Node node;
}