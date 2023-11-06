package nipon.coding.tree;

import java.util.LinkedList;
import java.util.Queue;
import nipon.coding.model.TreeNode;

public class BinaryTree {
	TreeNode root;

	public static void main(String[] args) {
		BinaryTree bst = new BinaryTree();
		/*
		 * BST tree example 
		 *     45 
		 *    / \ 
		 *   10  90 
		 *  / \  / 
		 * 7  12 50
		 */
		// insert data into BST
		int[] data = { 45, 10, 7, 12, 90, 50 };
		bst.insert(data);
		// print the BST
		System.out.println("BST in order Traversal (Left-Root-Right):");
		bst.inOrderTraversal();
		System.out.println("\nBST pre order Traversal (Root-Left-Right):");
		bst.preOrderTraversal();
		System.out.println("\nBST post order Traversal (Left-Right-Root):");
		bst.postOrderTraversal();
		System.out.println("\nBST level Order Traversal:");
		bst.levelOrderTraversal();
	}

	public void insert(int[] values) {
		for (int value : values) {
			root = insertRecursively(root, value);
		}
	}

	private TreeNode insertRecursively(TreeNode node, int value) {
		if (node == null) {
			node = new TreeNode(value);
			return node;
		}

		if (value < node.value) {
			node.left = insertRecursively(node.left, value);
		}

		if (value > node.value) {
			node.right = insertRecursively(node.right, value);
		}

		return node;
	}

	public void inOrderTraversal() {
		inOrderRecursive(root);
	}

	public void preOrderTraversal() {
		preOrderRecursive(root);
	}

	public void postOrderTraversal() {
		postOrderRecursive(root);
	}

	public void levelOrderTraversal() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode headNode = queue.poll();
			visit(headNode);

			if (headNode.left != null) {
				queue.add(headNode.left);
			}

			if (headNode.right != null) {
				queue.add(headNode.right);
			}
		}
	}

	private void postOrderRecursive(TreeNode node) {
		if (node != null) {
			postOrderRecursive(node.left);
			postOrderRecursive(node.right);
			visit(node);
		}
	}

	private void preOrderRecursive(TreeNode node) {
		if (node != null) {
			visit(node);
			preOrderRecursive(node.left);
			preOrderRecursive(node.right);
		}
	}

	private void inOrderRecursive(TreeNode node) {
		if (node != null) {
			inOrderRecursive(node.left);
			visit(node);
			inOrderRecursive(node.right);
		}
	}

	private void visit(TreeNode node) {
		System.out.print(node.value + " ");
	}
}
