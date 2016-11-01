package io.lofrattini.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AsymmetricDisjointSet<T> {
	
	private Map<T, Set<T>> iMap = new HashMap<T, Set<T>>();
	private Map<T, Set<T>> oMap = new HashMap<T, Set<T>>();

	public void connect(T from, T to) {
		if (from!=null && to!=null && !from.equals(to)) {
			Set<T> fromOutbound = oMap.getOrDefault(from, new HashSet<T>());
			Set<T> toInbound = iMap.getOrDefault(to, new HashSet<T>());
			
			// create outgoing arc
			fromOutbound.add(to);
			oMap.put(from, fromOutbound);
			
			// create incoming arc
			toInbound.add(from);
			iMap.put(to, toInbound);
			
		}
	}
	
	public boolean isConnected(T a, T b) {
		if (a!=null && b!=null) {
			Set<T> outgoing = oMap.getOrDefault(a, new HashSet<T>(Arrays.asList(a)));
			return outgoing.contains(b);
		} else {
			return false;
		}
	}

}
