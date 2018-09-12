package LinearDataStructures;

import java.util.ArrayList;


public class Stack<T extends Object>
{
	private ArrayList<T> list;
	private int top;
	
	
	//when initialsize is not given
	public Stack()
	{
		list = new ArrayList<T>();
		top=-1;
	}
	
	//when initialsize is given
	public Stack(int initialSize)
	{
		list = new ArrayList<T>(initialSize);
		top=-1;
	}
	
	//add the element at the top of the stack
	public T push(T item)
	{
		top++;
		list.add(item);
		return item;
	}
	
	
	//delete the element at the top of the stack
	public T pop()
	{
		T item = list.remove(top);
		top++;
		return item ;
	}
	
	
	//returns the element present at the top of the stack
	public T peek()
	{
		T item = list.get(top);
		return item ;
	}
	
	
	
	//return the size of the stack
	public int size()
	{
		return top;
	}
	//This function return the middle element of the Stack 
	/*in case of even number it return element at the index stack.size() -1;
	 */
	public T getMiddle()
	{
		if(top%2!=0)
			return list.get(top/2);
		else
			return list.get(top/2-1);
	}
	

}
