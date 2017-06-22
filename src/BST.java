import java.util.*;

public class BST {
	
	Node TreeRoot;
	static int [] values = {45,24,52,40,78,54,62,85,75,90,32,23,18,26};
	int maxHeight;

	public static void main(String[] args) {
		BST b = new BST();
		for (int i : values) {
			b.TreeRoot = b.addLeaf(b.TreeRoot, i, null);
		}
		int parentIndent = (int) Math.pow(2,b.getHeight(b.TreeRoot)-1);
		b.setIndent(b.TreeRoot,parentIndent);
		int height = b.getHeight(b.TreeRoot);
		int width = b.getMaxWidth(b.TreeRoot);
		System.out.println("Tree Height = " + height);
		System.out.println("Tree Width = " + width);
		System.out.print("InOrder Print : ");
		b.sortPrint(b.TreeRoot);
		System.out.println("\n\n");
		System.out.print("    BFS Print : ");
		b.bfsPrint(b.TreeRoot);
		System.out.println("\n\n");
		System.out.print("    DFS Print : ");
		b.dfsPrint(b.TreeRoot);
		System.out.println("\n\n");
//		b.prettyPrintTree(b.TreeRoot);
		System.out.println("\n\n");
		b.prettyPrintTree2(b.TreeRoot);
		System.out.println("\n\n");
		System.out.println("Is it even a Binary Tree : " + b.isTreeBST(b.TreeRoot));
	}
	
	public Node addLeaf(Node root, int value, Boolean isLeft) {
		if (root == null) {
			root = new Node();
			root.setValue(value);
			root.isLeft = isLeft;
			return root;
		}
		
		if (root.getValue() < value) {
			root.setRight(addLeaf(root.getRight(), value, false));
		} else {
			root.setLeft(addLeaf(root.getLeft(), value, true));
		}
		return root;
	}

	public void prettyPrintTree(Node root) {
	    Queue<Node> q = new LinkedList<Node>();
	    q.add(root);
	    q.add(null);     // null serves as a depth marker
	    
	    while (!q.isEmpty()) {
	        Node curr = q.remove();
	        String indentTxt="";
	        if (curr != null) {
		        for(int i=0;i<curr.indent;i++) {
		        	indentTxt+=" ";
		        }
	            System.out.println(indentTxt + curr.getValue());
	            if (curr.left != null)      q.add(curr.left);
	            if (curr.right != null)     q.add(curr.right);
	        }
	        else {
	            if (q.isEmpty())      break;
	            q.add(null);
	        }
	    }
	}

	public void prettyPrintTree2(Node root) {
		HashMap<Integer, Integer> heightMap = new HashMap<>();
	    Queue<Node> q = new LinkedList<Node>();
	    q.add(root);
	    q.add(null);     // null serves as a depth marker
	    
	    int parentHeight = getHeight(root);
	    while (!q.isEmpty()) {
	        Node curr = q.remove();
	        int indent=0;
	        String indentTxt="";
	        if (curr != null) {
	        	if (heightMap.containsKey(parentHeight)) {
	        		indent = curr.indent - heightMap.get(parentHeight);
	        	} else {
	        		indent = curr.indent;
	        	}
        		heightMap.put(parentHeight, curr.indent+String.valueOf(curr.getValue()).length());
		        for(int i=0;i<indent;i++) {
		        	indentTxt+=" ";
		        }
	            System.out.print(indentTxt + curr.getValue());
	            if (curr.left != null)      q.add(curr.left);
	            if (curr.right != null)     q.add(curr.right);
	        }
	        else {
	        	parentHeight--;
	        	System.out.println("\n");
	            if (q.isEmpty())      break;
	            q.add(null);
	        }
	    }
	}
	
	public void printTree(Node root, int height) {
	    Queue<Node> q = new LinkedList<Node>();
	    q.add(root);
	    q.add(null);     // null serves as a depth marker

	    for (int i=0;i<height-1;i++) System.out.print("\t");
	    
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
	            height--;
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
	
	public void bfsPrint(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node curr = q.remove();
			if (curr != null) {
				System.out.print(curr.getValue() + " ");
				q.add(curr.getLeft());
				q.add(curr.getRight());
			}
		}
	}
	
	public void dfsPrint(Node root) {
		if (root == null) return;
		
		System.out.print(root.getValue() + " ");
		dfsPrint(root.getLeft());
		dfsPrint(root.getRight());
	}

	public class Node {
		Node left;
		Node right;
		int value;
		
		public int indent;
		public Boolean isLeft;
		
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

	private void setIndent(Node root, int parentIndent) {
		if (root == null) return;
		int offset = getHeight(root);
		if (root.isLeft == null) {
			root.indent = parentIndent;
		} else if (root.isLeft) {
			root.indent = parentIndent - offset -1;
		} else {
			root.indent = parentIndent + offset +1;
		}
		setIndent(root.left, root.indent);
		setIndent(root.right, root.indent);
	}
	
	private boolean isTreeBST(Node root) {
		if (root == null) return true;
		
		if (root.getLeft() != null &&
				root.getValue() < root.getLeft().getValue()) {
			return false;
		}
		
		if (root.getRight() != null &&
				root.getValue() > root.getRight().getValue()) {
			return false;
		}
		
		if(!isTreeBST(root.getLeft()) ||
				!isTreeBST(root.getRight())) {
			return false;
		}
		
		return true;
	}

	public static boolean validateBST(Node root) {
		return validateBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean validateBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.getValue() <= min || root.getValue() >= max) {
			return false;
		}
		// left subtree must be < root.val && right subtree must be > root.val
		return validateBST(root.left, min, root.getValue()) && validateBST(root.right, root.getValue(), max);
	}
}
