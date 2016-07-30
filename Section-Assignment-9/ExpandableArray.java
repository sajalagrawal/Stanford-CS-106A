/*
 * File:ExpandableArray
 * --------------------
 * This class provides methods for working with an array that expands to
 * include any positive index value supplied by the caller.
 */

public class ExpandableArray{
	
	/**
	 * Creates a new expandable array with no elements.
	 */
	public ExpandableArray(){
		array=new Object[0];
	}
	
	/**
	 * Sets the element at the given index position to the specified 
	 * value. If the internal array is not large enough to contain that 
	 * element, the implementation expands the array to make room.
	 */
	public void set(int index,Object value){
		if(index>=array.length){
			//Create a new array that is large enough
			Object[] newArray=new Object[index+1];
			
			//cppy all the existing elements into new array
			for(int i=0;i<array.length;i++){
				newArray[i]=array[i];
			}
			
			//Keep track of the new array in place of the old array
			array=newArray;
		}
		array[index]=value;
	}
	
	/**
	 * Returns the element at the specified index position, or null if
	 * no such element exists. Note that this method never throws an 
	 * out-of-bounds exception; if the index is outside the bounds of the 
	 * array, the return value is simply null.
	 */
	public Object get(int index){
		if(index>=array.length){
			return null;
		}
		return array[index]; 
	}
	
	/*Private instance variables.*/
	private Object[] array;
}
