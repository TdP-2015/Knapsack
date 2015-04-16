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

import bean.Item;

public class Knapsack {
	private Set<Item> items;
	private int totWeight, totValue;
	private int capacity;

	public Boolean isValid() {
		if(totWeight > capacity)
			return false;
		return true;
	}
	
	public int getTotWeight() {
		return totWeight;
	}

	public int getTotValue() {
		return totValue;
	}

	public Knapsack() {
		items = new HashSet<Item>();
		totWeight = totValue = 0;
		capacity = 420;
	}
	
	public void addItem(Item i) {
		if(!items.add(i)) {
			throw new RuntimeException();
		}
		totWeight += i.getWeight();
		totValue += i.getValue();
	}
	public void removeItem(Item i) {
		if(!items.remove(i)) {
			throw new RuntimeException();
		}
		totWeight -= i.getWeight();
		totValue -= i.getValue();
	}

	public Set<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Knapsack [items=" + items + ", totWeight=" + totWeight
				+ ", totValue=" + totValue + "]";
	}	
}
