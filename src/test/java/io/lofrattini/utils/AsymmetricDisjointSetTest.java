package io.lofrattini.utils;

import org.junit.Assert;
import org.junit.Test;

public class AsymmetricDisjointSetTest {
	
	@Test
	public void testLoopIsConnected() {
		AsymmetricDisjointSet<Integer> s = new AsymmetricDisjointSet<Integer>();
		Assert.assertTrue("Loops are connected", s.isConnected(1, 1));
	}
	
	@Test
	public void testNullIsNotConnected() {
		AsymmetricDisjointSet<Integer> s = new AsymmetricDisjointSet<Integer>();
		Assert.assertFalse("Nulls are not connected", s.isConnected(null, 1));
		Assert.assertFalse("Nulls are not connected", s.isConnected(1, null));
		Assert.assertFalse("Nulls are not connected", s.isConnected(null, null));
	}
	
	@Test
	public void testDirectConnection() {
		AsymmetricDisjointSet<Integer> s = new AsymmetricDisjointSet<Integer>();
		s.connect(1, 3);
		Assert.assertTrue("LTR connected", s.isConnected(1, 3));
		Assert.assertFalse("RTL is not connected", s.isConnected(3, 1));
	}
	
	@Test
	public void testDirectConnectionWhenMorePaths() {
		AsymmetricDisjointSet<Integer> s = new AsymmetricDisjointSet<Integer>();
		s.connect(1, 2);
		s.connect(1, 3);
		Assert.assertTrue("LTR connected", s.isConnected(1, 2));
		Assert.assertTrue("LTR connected", s.isConnected(1, 3));
	}
	
	@Test
	public void testIndirectConnection() {
		AsymmetricDisjointSet<Integer> s = new AsymmetricDisjointSet<Integer>();
		s.connect(1, 2);
		s.connect(2, 3);
		Assert.assertTrue("LTR indirect connected", s.isConnected(1, 3));
	}

}
