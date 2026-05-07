package interfaces;


public interface IContainer<T> {

	/**
	 * Add the object in the parameter, if the container is full throw "fullContainerException", if object is not valid throw "IllegalArgumentException"
	 * @param
	 */
	public void addElement(T obj);

	/**
	 * Remove the object in the parameter, if object is not valid or is not on the container throw "IllegalArgumentException"
	 * @param
	 */
	public void removeElement(T obj);

	/**
	 * Returns the element in the specified position of the container, if the index is not valid throw "IllegalArgumentException"
	 * @param idx
	 * @return
	 */
	public T getElement(int idx);

	/**
	 * Returns if the element is on the array, if the object is not valid (of the specified type) throw "IllegalArgumentException"
	 * @param obj
	 * @return
	 */
	public boolean isElement(T obj);


}
