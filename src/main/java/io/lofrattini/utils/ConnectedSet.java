package io.lofrattini.utils;

public interface ConnectedSet<T> {
	
	public void connect(T a, T b);
	public boolean isConnected(T a, T b);

}
