
#226. Invert Binary Tree

#Recurrsive: 

public TreeNode invertTree(TreeNode root){
	if(root == null) return null; 

	TreeNode right = invertTree(root.right); 
	TreeNode left = invertTree(root.left); 

	
	root.right = left; 
	root.left = right; 

	return root;
}


#Time complexity: O(n) go through all nodes once.
#Space complexity: O(h) h, is the high of the tree.


#use Queue

public TreeNode invertTree(TreeNode root){

	Queue<TreeNode> queue = new LinkedList<>(); 

	queue.add(root); 
	while(!queue.isEmpty()){

		TreeNode cur = queue.poll(); 

		TreeNode temp = cur.right; 
		cur.right = cur.left; 
		cur.left = temp; 

		if(cur.right != null) queue.add(cur.right); 
		if(cur.left != null) queue.add(cur.left); 

		return root; 
	}
}

#Time complexity: O(n) go through all nodes once.
#Space complexity: O(n) n, is the nodes of the tree.
