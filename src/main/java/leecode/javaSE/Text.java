package leecode.javaSE;



import java.util.*;
import java.util.stream.Collectors;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/1 15:26
 */
public class Text {
    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, node1);
        Node node3 = new Node(3, node2);
        Node node4 = new Node(4, node3);
        Node node5 = new Node(5, node4);

        System.out.println(node5.toString());
        Node reverse = reverse(node5);
        System.out.println(reverse.toString());

    }

    int[] preorder;
    HashMap<Integer, Integer> hashMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    public TreeNode recur(int root, int left, int right) {
        if (left > right) return null;
        TreeNode treeNode = new TreeNode(preorder[root]);
        int num = hashMap.get(preorder[root]);
        treeNode.left = recur(root + 1, left, num - 1);
        treeNode.right = recur(root + num - left + 1, num + 1, right);
        return treeNode;
    }

    public static Node reverse(Node node) {
        if (node.next == null) return node;
        Node newNode = reverse(node.next);
        Node next = node.next;
        next.next = node;
        node.next = null;
        return newNode;
    }

    public static int test1(int a) {
        try {
            return a;
        } finally {
            a += 2;
            System.out.println(a);
        }
    }


    public void getInt() {
        System.out.println(getJump(44));
    }

    public int getJump(int n) {
        int[] ints = new int[n];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                ints[0] = 1;
            } else if (i == 2) {
                ints[1] = 2;
            } else {
                ints[i - 1] = ints[i - 2] + ints[i - 3];
            }
        }
        return ints[n - 1];
    }

}

class Score<T> {
    String name;
    T score;

    public Score(String name, T score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getScore() {
        return score;
    }

    public void setScore(T score) {
        this.score = score;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "--->" +
                "value=" + value +
                next;
    }
}

class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}


