package io.lofrattini.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Directed graph data structure for generic objects.
 * In this data structure connections are directed/asymmetric and transitive.
 * @author Lorenzo Frattini
 *
 * @param <T> the type to be stored in the graph
 */
public class DirectedGraph<T> implements ConnectedSet<T> {
	
	private Map<T, Vertex<T>> verticesMap = new HashMap<T, Vertex<T>>();

	public DirectedGraph() {
		super();
	}
	
	private Vertex<T> getVertex(T item) {
		Vertex<T> vertex = verticesMap.getOrDefault(item, new Vertex<T>(item));
		verticesMap.put(item, vertex);
		return vertex;
	}
	
	public void add(T item) {
		if (!verticesMap.containsKey(item)) {
			verticesMap.put(item, new Vertex<T>(item));
		}
	}
	
	public void connect(T a, T b) {
		Vertex<T> va = getVertex(a);
		Vertex<T> vb = getVertex(b);
		va.connect(vb);
	}
	
	public boolean isConnected(T a, T b) {
		if (a!=null && b!=null) {
			Vertex<T> va = getVertex(a);
			Vertex<T> vb = getVertex(b);
			return va.isConnected(vb);
		}
		return false;
	}
	
	@Override
	public Set<T> getConnectedSet(T a) {
		Vertex<T> va = getVertex(a);
		Set<T> connectedValues = new HashSet<T>();
		for (Vertex<T> vertex : va.getConnected()) {
			connectedValues.add(vertex.getValue());
		}
		return connectedValues;
	}


}
