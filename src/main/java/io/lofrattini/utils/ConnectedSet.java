package io.lofrattini.utils;

/**
 * An interface for set of items that can be mutually connected either directly or indirectly.
 * @author Lorenzo Frattini
 *
 * @param <T> the type of item in the set
 */
public interface ConnectedSet<T> {
	
	/**
	 * Create a links between two elements. 
	 * If the elements don't exist yet they are added to the data structure
	 * @param a the first element 
	 * @param b the second element
	 */
	public void connect(T a, T b);
	
	/**
	 * Tells if there is a connection, either direct or indirect, between two items in the data structure
	 * @param a the first item
	 * @param b the second item
	 * @return true if there is a connection, false otherwise
	 */
	public boolean isConnected(T a, T b);

}
