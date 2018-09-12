package NonLinearDataStructures;

import java.util.Arrays;

/*Link for introduction to invertible function: 
 * https://www.mathsisfun.com/sets/function-inverse.html*/
abstract class FenwickTree<T> 
{
	private T fenTree[];
	private final int SIZE ;   //Size of the Fenwick Tree
	private final T IDEMPOTENT_VALUE;   
	
	
	//constructor for FenwickTree
	//concept behind IDOMPOTENT_VALUE : we are using it for reversing the type of operation we performed
	@SuppressWarnings("unchecked")
	public FenwickTree(T arr[],T IDEMPOTENT_VALUE)
	{
		SIZE = arr.length+1;
		this.IDEMPOTENT_VALUE=IDEMPOTENT_VALUE;
		fenTree = (T[])new Object[SIZE];
		for(int i=0;i<SIZE;i++)
			fenTree[i]=IDEMPOTENT_VALUE;
		
		buildBIT(arr);
	}
	
	//function to build the Fenwick Tree
	private void buildBIT(T arr[])
	{
		for(int i = 0; i < arr.length; i++)
		
            pointUpdate(arr[i], i);       //calling update function
	}
	

	
	//function to get sum of a given range 
	public T getResult(int left, int right)
	{
		
		return processInverse(getResult(right) , getResult(left-1));
	}
	
	

	//
	public T getResult( int right)
	{
		
		return get(right) ;
	}
	
	
	//function to get sum of prefix 
	private  T get(int index)
	{
		T result = IDEMPOTENT_VALUE;
		
		index=index+1;
		
		while(index>0)
		{
			result=process(result,fenTree[index]);
			 index -= index & (-index);
		}
		return result ;
	}
	
	
	//function to update a Fenwick fenTree node
	//here the type of the update is delta update
	public void pointUpdate(T delta, int index)
	{
		index = index+1;
		while(index<SIZE)
		{
			fenTree[index] = process(fenTree[index], delta);
			
			index+=index & (-index);
		}
	}
	
	//
	public void rangeUpdate(int startIndex, int endIndex, T delta) 
	{
		for(int i=startIndex;i<endIndex;i++)
			pointUpdate(delta, i);
	}
	
	//Operation to be performed
	public abstract T process(T value1, T value2);
	
	//function for reversing the performed operation
	public abstract T processInverse(T resultRight, T resultLeft);


	public String toString()
	{
		return Arrays.toString(fenTree);
	}


	
}
