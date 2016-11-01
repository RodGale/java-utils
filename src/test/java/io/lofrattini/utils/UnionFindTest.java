package io.lofrattini.utils;
import org.junit.Assert;
import org.junit.Test;

import io.lofrattini.utils.UnionFind;

public class UnionFindTest {

	public UnionFindTest() {
		super();
	}
	
	@Test
	public void testWhenElementsDontExists() {
		UnionFind<Integer> uf = new UnionFind<Integer>();
		Assert.assertFalse(uf.isConnected(1, 2));
		Assert.assertFalse(uf.isConnected(2, 1));
	}
	
	@Test
	public void testWhenElementsExistsButThereIsNoConnection() {
		UnionFind<Integer> uf = new UnionFind<Integer>();
		uf.connect(1, 2);
		uf.connect(3, 4);
		Assert.assertFalse(uf.isConnected(1, 3));
		Assert.assertFalse(uf.isConnected(1, 4));
		Assert.assertFalse(uf.isConnected(2, 3));
		Assert.assertFalse(uf.isConnected(2, 4));
	}
	
	@Test
	public void testWhenSomeNullValues() {
		UnionFind<Integer> uf = new UnionFind<Integer>();
		Assert.assertFalse(uf.isConnected(1, null));
		Assert.assertFalse(uf.isConnected(null, 1));
	}
	
	@Test
	public void testNoExceptionThrownWhenConnectWithNullValues() {
		UnionFind<Integer> uf = new UnionFind<Integer>();
		uf.connect(null, null);
		uf.connect(1, null);
		uf.connect(null, 1);
	}
	
	@Test
	public void testWhenAllValuesAreNull() {
		UnionFind<Integer> uf = new UnionFind<Integer>();
		Assert.assertFalse(uf.isConnected(null, null));
	}
	
	@Test
	public void testWhenDirectConnectionExists() {
		UnionFind<Integer> uf = new UnionFind<Integer>();
		uf.connect(1, 2);
		Assert.assertTrue(uf.isConnected(1, 2));
		Assert.assertTrue(uf.isConnected(2, 1));
	}
	
	@Test
	public void testWhenIndirectConnectionExists() {
		UnionFind<Integer> uf = new UnionFind<Integer>();
		uf.connect(1, 2);
		uf.connect(2, 3);
		uf.connect(2, 4);
		Assert.assertTrue(uf.isConnected(1, 2));
		Assert.assertTrue(uf.isConnected(2, 1));
		Assert.assertTrue(uf.isConnected(1, 4));
		Assert.assertTrue(uf.isConnected(4, 1));
		Assert.assertTrue(uf.isConnected(3, 4));
		Assert.assertTrue(uf.isConnected(4, 3));
	}

}
