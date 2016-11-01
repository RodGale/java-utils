package io.lofrattini.utils;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {
	
	private Set<T> inset = new HashSet<T>();
	private Set<T> outset = new HashSet<T>();
	
	public void addIncoming(T node) {
		inset.add(node);
	}
	
	public void addOutgoing(T node) {
		outset.add(node);
	}


}
