package nipon.coding.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import nipon.coding.model.TreeNode;

public class BinaryTreeLevelOrderTraverse {
	TreeNode root;

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraverse bst = new BinaryTreeLevelOrderTraverse();
		/*
		 * BST tree example 
		 *     45 
		 *    / \ 
		 *   10  90 
		 *  / \  / 
		 * 7  12 50
		 */
		// insert data into BST
		Integer[] data = { 3,9,20,15,7 };
		//int[] data = { 1 };
		bst.insert(data);
		System.out.println(bst.levelOrder());
		
	}

	public void insert(Integer[] values) {
		for (Integer value : values) {
			if (value != null) {
			root = insertRecursively(root, value);
			}
		}
	}

	private TreeNode insertRecursively(TreeNode node, Integer value) {
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

	
	
	private List<List<Integer>> levelOrder() {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();

		if (root == null) {
			return resultList;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			List<Integer> levelList = new ArrayList<Integer>();
			int num = queue.size();
			for (int i = 0; i < num; i++) {
				TreeNode headNode = queue.poll();
				if (headNode.left != null) {
					queue.add(headNode.left);
				}

				if (headNode.right != null) {
					queue.add(headNode.right);
				}
				levelList.add(headNode.value);
			}
			resultList.add(levelList);

		}
		return resultList;
	}
}
