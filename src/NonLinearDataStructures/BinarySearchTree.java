package NonLinearDataStructures;

class BinarySearchTree<T extends Comparable<T>> 
{
	TreeNode<T> root;
	
	public BinarySearchTree(T node)
	{
		root = null;
	}
	
	
	//function to insert the node in the node in the binary search tree
	public TreeNode<T> insert(TreeNode<T> root, T element) throws Exception
	{
		//If the tree is empty, return a new node 
		if(root==null)
			return (new TreeNode<T>(element));
		
		
		//If data of the node is less than the data of current node then recur down the left sub tree
		else if( element.compareTo(root.data) < 0 )
			root.left = insert(root.left, element);
		
		
		//If data of the node is greater than the data of current node then recur down the right sub tree
		else if( element.compareTo(root.data)> 0)
			root.right = insert(root.right, element);
		
		//If the data to be inserted already exist then throw the duplicate value found exception
		else 
			throw new Exception("Duplicate Element Found.");
		return root;
	}
	
	//finding the greatest element in the given subtree
	public T findMax(TreeNode<T> root)
	{
		while(root.right!=null)
			root=root.right;
		return root.data;
	}
	
	//deleting a node with the given data
	public TreeNode<T> delete(TreeNode<T> root, T data)
	{
		//if root is null then return null
		if(root==null)
			return null;
		
		//data to be deleted is less than the data of the current node then recur down the left subtree
		else if(data.compareTo(root.data) < 0)
			root.left = delete(root.left, data);
		
		//if data to be deleted is greater than the data of the current node then recur down the right sub tree
		else if(data.compareTo(root.data)> 0)
			root.right = delete(root.right, data);
		
		//data to be deleted is found then we have the following four cases:
		else
		{
			//if it is a leaf node then simply delete it
			if(root.left == null && root.right == null)
				return null;
			
			//if only the left child exist then return the left subtree
			else if(root.right==null)
				return root.left;
			
			//if only the right child exist then return the right subtree
			else if(root.left==null)
				return root.right;
			
			//if the root has both right and left child then find the max value in the left subtree 
			//and delete that maximum value from the left subtree
			else
			{
				root.data = findMax(root.left); //finding the maximum value in the right sub tree 
				root.left = delete(root.left, root.data);
			}
		}
		return root;
	}
	
	//function to print the preorder traversal of the tree
	public void preorder(TreeNode<T> root)
	{

		if (root == null)
			return;

		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	//function to print the inorder traversal of the tree
	public void inorder(TreeNode<T> root)
	{
		if(root==null)
			return ;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	//function to print the postorder traversal of the binary tree
	public void postorder(TreeNode<T> root)
	{
		if(root==null)
			return ;
		inorder(root.left);
		inorder(root.right);
		System.out.print(root.data+" ");
	}
}
