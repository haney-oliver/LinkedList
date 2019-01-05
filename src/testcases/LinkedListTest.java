package testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import structures.LinkedList;

/**
 *  Test cases to test structures.LinkedList.java
 *
 *  @author Oliver Haney
 *  @version 1.0   12 November 2018
 */
public class LinkedListTest {
	
	LinkedList<String> list = new LinkedList<String>();
	
	@Before 
	public void setUpList() {
		list.addFirst("0");
		list.addLast("1");
		list.addLast("2");
		list.addLast("3");
	}
	
	/**
	 * Tests appropriate size of list
	 */
	@Test
	public void testSize() {
		assertTrue(list.size() == 4);
	}
	
	/**
	 * Tests getFirst() method
	 */
	@Test
	public void testGetFirst() {
		assertTrue(list.getFirst().equals("0"));
	}
	
	/**
	 * Tests getLast() method
	 */
	@Test
	public void testGetLast() {
		assertTrue(list.getLast().equals("3"));
	}
	
	/**
	 * Tests size() and getFirst() after
	 * addFirst()
	 */
	@Test
	public void testAddFirst() {
		list.addFirst("5");
		assertTrue(list.getFirst().equals("5"));
		assertTrue(list.size() == 5);
	}
	
	/**
	 * Tests size() and getLast() after
	 * addLast()
	 */
	@Test
	public void testAddLast() {
		list.addLast("4");
		assertTrue(list.getLast().equals("4"));
		assertTrue(list.size() == 5);
	}
	
	/**
	 * Tests getFirst() and size() after
	 * insertBefore() first
	 */
	@Test
	public void testInsertBeforeFirst() {
		assertTrue(list.insertBefore("-1","0"));
		assertTrue(list.getFirst().equals("-1"));
		assertTrue(list.size() == 5);
	}
	
	/**
	 * Tests getLast() and size() after
	 * insertBefore() null (end of list)
	 * but after last stored element
	 */
	@Test
	public void testInsertBeforeNull() {
		assertTrue(list.insertBefore("4", null));
		assertTrue(list.getLast().equals("4"));
		assertTrue(list.size() == 5);
	}
	
	/**
	 * Tests size() and contains() after 
	 * insertBefore() somewhere in the middle
	 */
	@Test
	public void testInsertBeforeMiddle() {
		assertTrue(list.insertBefore("2.5", "3"));
		assertTrue(list.contains("2.5"));
		assertTrue(list.size() == 5);
	}
	
	/**
	 * Tests size() and getFirst() after
	 * setFirst()
	 */
	@Test
	public void testSetFirst() {
		list.setFirst("-1");
		assertTrue(list.getFirst().equals("-1"));
		assertTrue(list.size() == 4);
	}
	
	/**
	 * Tests contains()
	 * (whether or not list contains specified datum)
	 */
	@Test
	public void testContains() {
		assertTrue(list.contains("2"));
	}
	
	/**
	 * Tests contains() for the first stored element
	 */
	@Test
	public void testContainsForFirst() {
		assertTrue(list.contains("0"));
	}
	
	/**
	 * Tests contains() for the last stored element
	 */
	@Test
	public void testContainsForLast() {
		assertTrue(list.contains("3"));
	}
	
	/**
	 * Tests indexOf() to return index of specified element
	 */
	@Test
	public void testIndexOf() {
		assertTrue(list.indexOf("2") == 2);
	}
	
	/**
	 * Tests indexOf() for first stored element
	 */
	@Test
	public void testIndexOfFirst() {
		assertTrue(list.indexOf("0") == 0);
	}
	
	/**
	 * Tests indexOf() for last stored element
	 */
	@Test
	public void testIndexOfLast() {
		assertTrue(list.indexOf("3") == 3);
	}
	
	/**
	 * Tests size(), contains() after
	 * remove() first stored element 
	 */
	@Test
	public void testSizeAfterRemoval() {
		assertTrue(list.remove("2"));
		assertFalse(list.contains("2"));
		assertTrue(list.size() == 3);
	}
	
	/**
	 * Tests remove() for nonexistent element
	 */
	@Test
	public void testBadRemoval() {
		assertFalse(list.remove("-1"));
		assertTrue(list.size() == 4);
	}
	
	/**
	 * Tests size(), contains(), and getLast() after
	 * removeFirst()
	 */
	@Test
	public void testRemoveFirst() {
		assertTrue(list.removeFirst() == "0");
		assertTrue(list.getFirst() == "1");
		assertFalse(list.contains("0"));
		assertTrue(list.size() == 3);
	}
	
	/**
	 * Tests size(), conatins(), and getLast() after
	 * removeLast()
	 */
	@Test
	public void testRemoveLast() {
		assertTrue(list.removeLast() == "3");
		assertTrue(list.getLast() == "2");
		assertFalse(list.contains("3"));
		assertTrue(list.size() == 3);
	}
	
}
