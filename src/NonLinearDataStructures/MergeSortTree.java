package NonLinearDataStructures;

import java.util.ArrayList;

//Merge Sort Tree uses merge sort and the concept of Segment Tree
abstract public class MergeSortTree<T extends Comparable<T>>
{
	
	ArrayList<T>[] mergeSortTree;    //declaring a dynamic array of ArrayList
	public MergeSortTree(T[] arr)
	{ 
		
		build(arr, 0, arr.length, 0);
	}
	
	void build(T[] arr, int start, int end, int node)
	{
		if(start==end)
		{
			mergeSortTree[node]= new ArrayList<T>();
			mergeSortTree[node].add(arr[start]);
			return ;
		}
		
		int mid = getMid(start, end);
		build(arr, start, mid, 2*node+1);
		build(arr, mid+1, end, 2*node+2);
		//merging two sorted ArrayList
		mergeSortTree[node] = operation(mergeSortTree[2*node+1], mergeSortTree[2*node+2]);
	}
	
	
	private int getMid(int start, int end)
	{
		return start + (end-start)/2;
	}
	
	//merging two sorted ArrayList and return the obtained ArrayList to the calling function
	private ArrayList<T> operation(ArrayList <T> left, ArrayList <T> right) 
	{
		ArrayList <T> merged=new ArrayList<T>();
		int l,r;
		l=0;r=0;
		while(l<left.size() && r<right.size())
		{
			merged.add(left.get(l).compareTo(right.get(r))<0?left.get(l++):right.get(r++));
		}
		while(r<right.size())
			merged.add(right.get(r++));
		while(l<left.size())
			merged.add(left.get(l++));
		return merged;
}

}
