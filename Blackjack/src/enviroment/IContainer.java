package enviroment;

public interface IContainer {

	/**
	 * Add the object in the parameter, if the container is full throw "fullContainerException", if object is not valid throw "IllegalArgumentException"
	 * @param obj
	 */
	public void addElement(Object obj);
	
	/**
	 * Remove the object in the parameter, if object is not valid or is not on the container throw "IllegalArgumentException"
	 * @param obj
	 */
	public void removeElement(Object obj);
	
	/**
	 * Returns the element in the specified position of the container, if the index is not valid throw "IllegalArgumentException"
	 * @param idx
	 * @return 
	 */
	public Object getElement(int idx);
	
	/**
	 * Returns if the element is on the array, if the object is not valid (of the specified type) throw "IllegalArgumentException"
	 * @param obj
	 * @return
	 */
	public boolean isElement(Object obj);
	
	
}
