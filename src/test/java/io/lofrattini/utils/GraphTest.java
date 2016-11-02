package io.lofrattini.utils;
import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

	@Test
	public void testWhenElementsDontExists() {
		ConnectedSet<Integer> uf = new Graph<Integer>();
		Assert.assertFalse("No connection expected", uf.isConnected(1, 2));
		Assert.assertFalse("No connection expected", uf.isConnected(2, 1));
	}
	
	@Test
	public void testWhenElementsExistsButThereIsNoConnection() {
		ConnectedSet<Integer> uf = new Graph<Integer>();
		uf.connect(1, 2);
		uf.connect(3, 4);
		Assert.assertFalse("No connection expected", uf.isConnected(1, 3));
		Assert.assertFalse("No connection expected", uf.isConnected(1, 4));
		Assert.assertFalse("No connection expected", uf.isConnected(2, 3));
		Assert.assertFalse("No connection expected", uf.isConnected(2, 4));
	}
	
	@Test
	public void testWhenSomeNullValues() {
		ConnectedSet<Integer> uf = new Graph<Integer>();
		Assert.assertFalse("No connection expected with null values", uf.isConnected(1, null));
		Assert.assertFalse("No connection expected with null values", uf.isConnected(null, 1));
	}
	
	@Test
	public void testNoExceptionThrownWhenConnectWithNullValues() {
		ConnectedSet<Integer> uf = new Graph<Integer>();
		uf.connect(null, null);
		uf.connect(1, null);
		uf.connect(null, 1);
	}
	
	@Test
	public void testWhenAllValuesAreNull() {
		ConnectedSet<Integer> uf = new Graph<Integer>();
		Assert.assertFalse("No connection expected with null values", uf.isConnected(null, null));
	}
	
	@Test
	public void testWhenDirectConnectionExists() {
		ConnectedSet<Integer> uf = new Graph<Integer>();
		uf.connect(1, 2);
		Assert.assertTrue("Connection expected", uf.isConnected(1, 2));
		Assert.assertFalse("Connection must not be symmetric", uf.isConnected(2, 1));
	}
	
	@Test
	public void testWhenLoop() {
		ConnectedSet<Integer> uf = new Graph<Integer>();
		Integer x = 10;
		Assert.assertTrue("An element is always connected to itself", uf.isConnected(x, x));
	}
	
	@Test
	public void testWhenIndirectConnectionExists() {
		ConnectedSet<Integer> uf = new Graph<Integer>();
		uf.connect(1, 2);
		uf.connect(2, 3);
		uf.connect(2, 4);
		Assert.assertTrue("Connection expected", uf.isConnected(1, 2));
		Assert.assertTrue("Connection expected", uf.isConnected(1, 3));
		Assert.assertTrue("Connection expected", uf.isConnected(1, 4));
		Assert.assertFalse("Connection not expected", uf.isConnected(3, 4));
	}
	
}
