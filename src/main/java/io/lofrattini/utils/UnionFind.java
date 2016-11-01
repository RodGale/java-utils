package io.lofrattini.utils;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnionFind<T> {
	
	private Map<T, Set<T>> itemMap = new HashMap<T, Set<T>>();
	
	public UnionFind() {
		super();
	}
	
	public boolean isConnected(T a, T b) {
		if (a!=null && b!=null) {
			Set<T> aSet = itemMap.getOrDefault(a, new HashSet<T>(Arrays.asList(a)));
			return aSet.contains(a) && aSet.contains(b);
		} else {
			return false;
		}
	}
	
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
