import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pshetye on 10/2/16.
 */
public class BTree {

    private Leaf mRoot;

    public static void main(String [] args) {
        int size = 11;
        BTree tree = new BTree();
        while (size > 0) {
            int random = (int )(Math.random() * 50 + 1);
            tree.mRoot = tree.insertInBst(tree.mRoot, random);
            System.out.println(size + " - " + random);
            size--;
        }
        tree.printBTree();
        System.out.println("\nis valid tree : " + tree.validateBtree(tree.mRoot));
    }

    private Leaf insertInBst(Leaf root, int val) {
        if (root == null) {
            root = new Leaf();
            root.setVal(val);
            return root;
        }
        if (val > root.getVal()) {
            root.setRight(insertInBst(root.getRight(), val));
        } else {
            root.setLeft(insertInBst(root.getLeft(), val));
        }
        return root;
    }

    private void printBTree() {
        Queue<Leaf> queue = new LinkedList<>();
        queue.add(mRoot);
        while (!queue.isEmpty()) {
            Leaf currLeaf = queue.remove();
            if (currLeaf != null) {
                System.out.print(currLeaf.getVal() + " - ");
                queue.add(currLeaf.getLeft());
                queue.add(currLeaf.getRight());
            }
        }
    }

    private boolean validateBtree(Leaf root) {
        if (root == null) {
            return true;
        } else if (root.getLeft() != null && root.getRight() != null) {
            return validateBtree(root.getLeft()) && validateBtree(root.getRight());
        } else {
            return false;
        }
    }

    private static class Leaf {
        private int val;
        private Leaf left;
        private Leaf right;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Leaf getLeft() {
            return left;
        }

        public void setLeft(Leaf left) {
            this.left = left;
        }

        public Leaf getRight() {
            return right;
        }

        public void setRight(Leaf right) {
            this.right = right;
        }
    }
}
