package io.lofrattini.utils;
import org.junit.Assert;
import org.junit.Test;

public class DirectedGraphTest {

	@Test
	public void testWhenElementsDontExists() {
		ConnectedSet<Integer> set = new DirectedGraph<Integer>();
		Assert.assertFalse("No connection expected", set.isConnected(1, 2));
		Assert.assertFalse("No connection expected", set.isConnected(2, 1));
	}
	
	@Test
	public void testWhenElementsExistsButThereIsNoConnection() {
		ConnectedSet<Integer> set = new DirectedGraph<Integer>();
		set.connect(1, 2);
		set.connect(3, 4);
		Assert.assertFalse("No connection expected", set.isConnected(1, 3));
		Assert.assertFalse("No connection expected", set.isConnected(1, 4));
		Assert.assertFalse("No connection expected", set.isConnected(2, 3));
		Assert.assertFalse("No connection expected", set.isConnected(2, 4));
	}
	
	@Test
	public void testWhenSomeNullValues() {
		ConnectedSet<Integer> set = new DirectedGraph<Integer>();
		Assert.assertFalse("No connection expected with null values", set.isConnected(1, null));
		Assert.assertFalse("No connection expected with null values", set.isConnected(null, 1));
	}
	
	@Test
	public void testNoExceptionThrownWhenConnectWithNullValues() {
		ConnectedSet<Integer> set = new DirectedGraph<Integer>();
		set.connect(null, null);
		set.connect(1, null);
		set.connect(null, 1);
	}
	
	@Test
	public void testWhenAllValuesAreNull() {
		ConnectedSet<Integer> set = new DirectedGraph<Integer>();
		Assert.assertFalse("No connection expected with null values", set.isConnected(null, null));
	}
	
	@Test
	public void testWhenDirectConnectionExists() {
		ConnectedSet<Integer> set = new DirectedGraph<Integer>();
		set.connect(1, 2);
		Assert.assertTrue("Connection expected", set.isConnected(1, 2));
		Assert.assertFalse("Connection must not be symmetric", set.isConnected(2, 1));
	}
	
	@Test
	public void testWhenLoop() {
		ConnectedSet<Integer> set = new DirectedGraph<Integer>();
		Integer x = 10;
		Assert.assertTrue("An element is always connected to itself", set.isConnected(x, x));
	}
	
	@Test
	public void testWhenIndirectConnectionExists() {
		ConnectedSet<Integer> set = new DirectedGraph<Integer>();
		set.connect(1, 2);
		set.connect(2, 3);
		set.connect(2, 4);
		Assert.assertTrue("Connection expected", set.isConnected(1, 2));
		Assert.assertTrue("Connection expected", set.isConnected(1, 3));
		Assert.assertTrue("Connection expected", set.isConnected(1, 4));
		Assert.assertFalse("Connection not expected", set.isConnected(3, 4));
	}
	
	@Test
	public void testIndirectLoops() {
		ConnectedSet<Integer> set = new DirectedGraph<Integer>();
		set.connect(1, 2);
		set.connect(2, 3);
		set.connect(3, 1);
		Assert.assertTrue("Connection expected", set.isConnected(1, 2));
		Assert.assertTrue("Connection expected", set.isConnected(1, 3));
		Assert.assertTrue("Connection expected", set.isConnected(3, 2));
	}
	
	@Test
	public void testReachability() {
		ConnectedSet<Integer> set = new DirectedGraph<Integer>();
		set.connect(1, 2);
		set.connect(2, 3);
		set.connect(2, 4);
		set.connect(2, 5);
		set.connect(4, 6);
		
		// Reachable nodes from 1
		Assert.assertTrue("Node should be reachable", set.getConnectedSet(1).contains(2));
		Assert.assertTrue("Node should be reachable", set.getConnectedSet(1).contains(3));
		Assert.assertTrue("Node should be reachable", set.getConnectedSet(1).contains(4));
		Assert.assertTrue("Node should be reachable", set.getConnectedSet(1).contains(5));
		Assert.assertTrue("Node should be reachable", set.getConnectedSet(1).contains(6));
		Assert.assertFalse("Node itself should not be in reachable set", set.getConnectedSet(1).contains(1));
		
		// Reachable nodes from 4
		Assert.assertTrue("Node should be reachable", set.getConnectedSet(4).contains(6));
		Assert.assertFalse("Node should not be reachable", set.getConnectedSet(4).contains(1));
		Assert.assertFalse("Node should not be reachable", set.getConnectedSet(4).contains(2));
		Assert.assertFalse("Node should not be reachable", set.getConnectedSet(4).contains(3));
		Assert.assertFalse("Node should not be reachable", set.getConnectedSet(4).contains(5));

	}
	
}
