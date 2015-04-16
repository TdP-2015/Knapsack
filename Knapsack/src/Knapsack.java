////////////////////////////////////////////////////////////////////////////////
//             //                                                             //
//   #####     // Knapsack -- a simple example                                //
//  ######     // (!) 2015 Giovanni Squillero <giovanni.squillero@polito.it>  //
//  ###   \    //                                                             //
//   ##G  c\   //                                                             //
//   #     _\  //                                                             //
//   |   _/    //                                                             //
//   |  _/     //                                                             //
//             // 03FYZ - Tecniche di programmazione 2014-15                  //
////////////////////////////////////////////////////////////////////////////////

import java.util.HashSet;
import java.util.Set;

import bean.*;

public class Knapsack {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Knapsack [actualWeight="
				+ actualWeight + ", actualValue=" + actualValue + ", items="
				+ items + "]";
	}

	/**
	 * @return the items
	 */
	public Set<Item> getItems() {
		return items;
	}

	private int capacity;
	private Set<Item> items;
	private int actualWeight, actualValue;

	public Knapsack(int cap) {
		capacity = cap;
		items = new HashSet<Item>();
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	public void add(Item i) {
		if (!items.add(i)) {
			throw new RuntimeException();
		}
		actualWeight += i.getWeight();
		actualValue += i.getValue();
	}

	public void remove(Item i) {
		if (!items.remove(i)) {
			throw new RuntimeException();
		}
		actualWeight -= i.getWeight();
		actualValue -= i.getValue();
	}

	public int getWeight() {
		return actualWeight;
	}

	public int getValue() {
		return actualValue;
	}
}
