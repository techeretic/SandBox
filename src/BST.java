import java.util.*;

public class BST {
	
	Node TreeRoot;
	static int [] values = {45,24,52,40,78,54,62,85,75,90,32,23,18,26}; 

	public static void main(String[] args) {
		BST b = new BST();
		for (int i : values) {
			b.TreeRoot = b.addLeaf(b.TreeRoot, i);
		}

		int height = b.getHeight(b.TreeRoot);
		int width = b.getMaxWidth(b.TreeRoot);
		System.out.println("Tree Height = " + height);
		System.out.println("Tree Width = " + width);
		b.sortPrint(b.TreeRoot);
		System.out.println("\n\n");
		b.printTree(b.TreeRoot, height);
		System.out.println("\n\n");
	}
	
	public Node addLeaf(Node root, int value) {
		if (root == null) {
			root = new Node();
			root.setValue(value);
			return root;
		}
		
		if (root.getValue() < value) {
			root.setRight(addLeaf(root.getRight(), value));
		} else {
			root.setLeft(addLeaf(root.getLeft(), value));
		}
		return root;
	}

	public void printTree(Node root, int height) {
	    Queue<Node> q = new LinkedList<Node>();
	    q.add(root);
	    q.add(null);     // null serves as a depth marker

	    for (int i=0;i<height;i++) System.out.print("\t");
	    
	    int level = 1;
	    while (!q.isEmpty()) {
	        Node curr = q.remove();
	        if (curr != null) {
	            System.out.print(curr.getValue() + "\t\t");
	            if (curr.left != null)      q.add(curr.left);
	            if (curr.right != null)     q.add(curr.right);
	        }
	        else {
	            System.out.println();     // print new line
	            height++;
	            for (int i=0;i<height-1;i++) System.out.print("\t");
	            if (q.isEmpty())      break;
	            q.add(null);
	        }
	    }
	}
	
	public void sortPrint(Node root) {
		if (root == null) {
			return;
		}
		
		sortPrint(root.getLeft());
		System.out.print(root.getValue() + " ");
		sortPrint(root.getRight());
	}
	
	public class Node {
		Node left;
		Node right;
		int value;
		
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}		
	}

	public int getHeight(Node root) {
		if (root == null)
			return 0;
		
		if (root.left == null && root.right == null) {
			return 1;
		} else {
			return (Math.max(getHeight(root.left),getHeight(root.right)) + 1);
		}
	}

	public int getMaxWidth(Node root) {
		int maxWidth = 0;
		int width;
		int h = getHeight(root);
		int i;

		for (i = 1; i <= h; i++) {
			width = getWidth(root, i);
			System.out.println("W(" + width + ") for H(" + i + ")");
			if (width > maxWidth)
				maxWidth = width;
		}

		return maxWidth;
	}

	private int getWidth(Node root, int level) {

		if (root == null)
			return 0;

		if (level == 1)
			return 1;

		else if (level > 1)
			return getWidth(root.left, level - 1)
					+ getWidth(root.right, level - 1);
		
		else return 1;
	}
}
