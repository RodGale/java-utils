package io.lofrattini.utils;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Generic vertex/node for a directed graph data structure
 * @author Lorenzo Frattini
 *
 * @param <T> the type of node (the information stored in the graph)
 */
public class Vertex<T> implements Comparable<Vertex<T>> {
	
	private T value;
	private Set<Vertex<T>> adjacentVertices;
	
	public Vertex(T value) {
		this.value = value;
		this.adjacentVertices = new HashSet<Vertex<T>>();
	}
	
	public void connect(Vertex<T> node) {
		if (this!=node) {
			adjacentVertices.add(node);
		}
	}
	
	public Set<Vertex<T>> getAdjacentVertices() {
		return adjacentVertices;
	}
	
	public T getValue() {
		return value;
	}
	
	protected Integer getRank() {
		return (adjacentVertices!=null) ? adjacentVertices.size() : 0;
	}
	
	public boolean isConnected(Vertex<T> other) {
		if (other==null) {
			return false;
		} else if (this == other) {
			return true;
		} else if (adjacentVertices.contains(other)) {
			return true;
		} else {
			PriorityQueue<Vertex<T>> queue = new PriorityQueue<Vertex<T>>(adjacentVertices);
			Set<Vertex<T>> visited = new HashSet<Vertex<T>>();
			while(!queue.isEmpty()) {
				Vertex<T> current = queue.poll();
				visited.add(current);
				for (Vertex<T> n : current.getAdjacentVertices()) {
					if (!visited.contains(n)) {
						queue.add(n);
					}
				}
				if (current.isConnected(other)) {
					return true;
				}
			}
			return false;
		}
	}

	@Override
	public int compareTo(Vertex<T> other) {
		/* natural ordering of vertices is by rank, so that priority queue, 
		 * processes highly-connected vertices first */
		return getRank().compareTo(other.getRank());
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	public Set<Vertex<T>> getConnected() {
		PriorityQueue<Vertex<T>> queue = new PriorityQueue<Vertex<T>>(adjacentVertices);
		Set<Vertex<T>> visited = new HashSet<Vertex<T>>();
		while(!queue.isEmpty()) {
			Vertex<T> current = queue.poll();
			visited.add(current);
			for (Vertex<T> n : current.getAdjacentVertices()) {
				if (!visited.contains(n)) {
					queue.add(n);
				}
			}
		}
		return visited;
	}
	
}
