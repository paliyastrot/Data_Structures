package NonLinearDataStructures;

abstract class SegmentTree<T>
{
	private T tree [] ;
	
	@SuppressWarnings("unchecked")
	public SegmentTree(T arr[])
	{
		int ELEMENT = arr.length;

		int HEIGHT =(int)(Math.ceil(Math.log(ELEMENT)/Math.log(2)));

		int SIZE = 2*(int)Math.pow(2, HEIGHT)-1;

		tree=(T[])new Object[SIZE];
		
		buildTree(arr, 0, ELEMENT, 0);

	}
	
	
	//function to create a Segment Tree
	private void buildTree(T arr[], int start, int end , int nodeIndex)
	{
		//base case
		if(start == end)
		{
			tree[nodeIndex] = arr[start];
			return ;
		}
		
		
		///finding the middle element
		int mid = getMiddle(start, end);
		
		//recurring down the left half
		buildTree(arr, start,  mid , 2*nodeIndex+1);
		
		//recurring down the right half
		buildTree(arr, mid+1,  end, 2*nodeIndex+2);
		tree[nodeIndex] = operation
				(tree[getLeft(nodeIndex)], tree[getRight(nodeIndex)]);
		
	}
	
	
	//function to perform the given query
	public T query(Integer querystart, Integer queryend, Integer start, Integer end, Integer node)
	{
		//outside the given range
		if(start>queryend || end<querystart)
			return null;
		
		//completely inside the given range
		if(start>=querystart && end<=queryend)
			return tree[node];
		
		//finding the middle index
		int mid = (start + end)/2;
		
		//recurring down the left half
		T left = query(querystart, queryend, start, mid, getLeft(node));
		
		//recurring down the right half
		T right = query(querystart, queryend, mid+1, end, getRight(node));
		
		//returning the final output
		return operation(left, right);		
		
	}
	
	
	//obtaining the left child of the Segment Tree
	private int getLeft(int nodeIndex)
	{
		return 2*nodeIndex+1;
	}
	
	
	//obtaining the right child of the Segment Tree 
	private int getRight(int nodeIndex)
	{
		return 2*nodeIndex+2;
	}
	
	private int getMiddle(int start, int end)
	{
		return start + (end-start)/2;
	}
	//Function to perform the given operation
	abstract T operation(T left, T right);

}
