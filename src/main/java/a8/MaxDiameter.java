package a8;

public class MaxDiameter {
    public int getMaxDiameter(Node root) {
        return find(root).diameter;
    }

    private Pair find(Node root) {
        if (root == null) {
            return new Pair();
        }
        Pair left = find(root.left);
        Pair right = find(root.right);
        Pair pair = new Pair();
        pair.height = Math.max(left.height, right.height) + 1;
        pair.diameter = Math.max(left.height + right.height, Math.max(left.diameter, right.diameter));
        return pair;
    }
}

class Pair {
    int height;
    int diameter;
}