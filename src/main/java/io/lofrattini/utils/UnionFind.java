package io.lofrattini.utils;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A template implementation of the Union-Find set data structure.
 * {@link https://en.wikipedia.org/wiki/Disjoint-set_data_structure}
 * @author Lorenzo Frattini
 *
 * @param <T> the generic item type
 */
public class UnionFind<T> {
	
	private Map<T, Set<T>> itemMap = new HashMap<T, Set<T>>();
	
	public UnionFind() {
		super();
	}
	
	/**
	 * Tells if there is a connection, either direct or indirect, between two items in the data structure
	 * @param a the first item
	 * @param b the second item
	 * @return true if there is a connection, false otherwise
	 */
	public boolean isConnected(T a, T b) {
		if (a!=null && b!=null) {
			Set<T> aSet = itemMap.getOrDefault(a, new HashSet<T>(Arrays.asList(a)));
			return aSet.contains(a) && aSet.contains(b);
		} else {
			return false;
		}
	}
	
	/**
	 * Create a links between two elements. 
	 * If the elements don't exist yet they are added to the data structure
	 * @param a the first element 
	 * @param b the second element
	 */
	public void connect(T a, T b) {
		if (a!=null && b!=null) {
			Set<T> aSet = itemMap.getOrDefault(a, new HashSet<T>(Arrays.asList(a)));
			Set<T> bSet = itemMap.getOrDefault(b, new HashSet<T>(Arrays.asList(b)));
			aSet.addAll(bSet);
			itemMap.put(a, aSet);
			itemMap.put(b, aSet);
		}
	}

}
