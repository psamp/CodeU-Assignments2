package com.psamp.arraylistsize;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListSize {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>(5);
		System.out.println("New empty list with capacity of 5. Size: " + list.size());
		
		list.add(1);
		list.add(2);
		
		System.out.println("List now has items. Size: " + list.size());
		list.clear();
		System.out.println("List has been cleared of items. Size: " + list.size());
		
	}

}
