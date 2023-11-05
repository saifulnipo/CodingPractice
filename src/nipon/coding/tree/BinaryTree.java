package nipon.coding.tree;

import nipon.coding.model.Node;

public class BinaryTree {
	Node root;

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
		bst.insert(45);
		bst.insert(10);
		bst.insert(7);
		bst.insert(12);
		bst.insert(90);
		bst.insert(50);
		// print the BST
//		System.out.println("BST in order traverse (Left-Root-Right):");
//		bst.inOrderTraverse();
//		System.out.println("\nBST pre order traverse (Root-Left-Right):");
//		bst.preOrderTraverse();
		System.out.println("\nBST post order traverse (Left-Right-Root):");
		bst.postOrderTraverse();
	}

	public void insert(int value) {
		root = insertRecursively(root, value);
	}

	private Node insertRecursively(Node node, int value) {
		if (node == null) {
			node = new Node(value);
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

	public void inOrderTraverse() {
		inOrderRecursive(root);
	}

	public void preOrderTraverse() {
		preOrderRecursive(root);
	}

	public void postOrderTraverse() {
		postOrderRecursive(root);
	}

	private void postOrderRecursive(Node node) {
		if (node != null) {
			postOrderRecursive(node.left);
			postOrderRecursive(node.right);
			visit(node.value);
		}
	}

	private void preOrderRecursive(Node node) {
		if (node != null) {
			visit(node.value);
			preOrderRecursive(node.left);
			preOrderRecursive(node.right);
		}
	}

	private void inOrderRecursive(Node node) {
		if (node != null) {
			inOrderRecursive(node.left);
			visit(node.value);
			inOrderRecursive(node.right);
		}
	}

	private void visit(int value) {
		System.out.print(value + " ");
	}
}
