package io.lofrattini.utils;

import org.junit.Assert;
import org.junit.Test;

public class VertexTest {
	
	@Test
	public void testLoopIsConnected() {
		Vertex<Integer> a = new Vertex<Integer>(1);
		Assert.assertTrue("Loops are connected", a.isConnected(a));
	}
	
	@Test
	public void testNullIsNotConnected() {
		Vertex<Integer> s = new Vertex<Integer>(1);
		Assert.assertFalse("Nulls are not connected", s.isConnected(null));
	}
	
	@Test
	public void testDirectConnection() {
		Vertex<Integer> a = new Vertex<Integer>(1);
		Vertex<Integer> b = new Vertex<Integer>(2);
		a.connect(b);
		Assert.assertTrue("LTR connected", a.isConnected(b));
		Assert.assertFalse("RTL is not connected", b.isConnected(a));
	}
	
	@Test
	public void testDirectConnectionWhenMorePaths() {
		Vertex<Integer> s1 = new Vertex<Integer>(1);
		Vertex<Integer> s2 = new Vertex<Integer>(2);
		Vertex<Integer> s3 = new Vertex<Integer>(3);
		s1.connect(s2);
		s1.connect(s3);
		Assert.assertTrue("LTR connected", s1.isConnected(s2));
		Assert.assertTrue("LTR connected", s1.isConnected(s3));
	}
	
	@Test
	public void testConnectionIsAbsent() {
		Vertex<Integer> s1 = new Vertex<Integer>(1);
		Vertex<Integer> s2 = new Vertex<Integer>(2);
		Vertex<Integer> s3 = new Vertex<Integer>(3);
		Vertex<Integer> s4 = new Vertex<Integer>(3);
		s1.connect(s2);
		s3.connect(s4);
		Assert.assertFalse("Unexpected connection", s1.isConnected(s4));
	}
	
	@Test
	public void testIndirectConnection() {
		Vertex<Integer> n1 = new Vertex<Integer>(1);
		Vertex<Integer> n2 = new Vertex<Integer>(2);
		Vertex<Integer> n3 = new Vertex<Integer>(3);
		Vertex<Integer> n4 = new Vertex<Integer>(4);
		n1.connect(n2);
		n2.connect(n3);
		n3.connect(n4);
		Assert.assertTrue("LTR indirect connected", n1.isConnected(n4));
	}

}
