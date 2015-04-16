import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bean.*;
import dao.*;

public class Main {
	final int Capacity = 200;
	long timeStart;
	List<Item> items;
	Knapsack knap;
	Knapsack bestKnap;
	double bestVW;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m = new Main();
		m.run();
	}

	private void run() {
		class ItemComparator implements Comparator<Item> {
			public int compare(Item i1, Item i2) {
				Double v1 = 1.0 * i1.getValue() / i1.getWeight();
				Double v2 = 1.0 * i2.getValue() / i2.getWeight();
				return v2.compareTo(v1);
			}
		}

		KanpsackDAO dao = new KanpsackDAO();
		items = dao.getItems();
		Collections.sort(items, new ItemComparator());
		bestVW = 1.0 * items.get(0).getValue()/items.get(0).getWeight();
		
		for (Item i : items)
			System.out.println(i);
		knap = new Knapsack(Capacity);
		bestKnap = new Knapsack(Capacity);
		timeStart = System.nanoTime();
		_recursiveSolver(0);
		System.out.println("Trascorso: " + (System.nanoTime() - timeStart)
				/ 1e9);
		System.out.println(bestKnap);
	}

	private void _recursiveSolver(int s) {
		if(s == items.size()) {
			if(knap.getWeight() <= knap.getCapacity() && knap.getValue() > bestKnap.getValue()) {
				System.out.println("Nuovo ottimo @ " + (System.nanoTime()-timeStart)/1e9 + ": " + knap);
				bestKnap = new Knapsack(Capacity);
				for(Item i : knap.getItems())
					bestKnap.add(i);
			}
			return;
		} 
		// 40s
		if(knap.getWeight() > knap.getCapacity())
			return;
		if( knap.getValue() + (knap.getCapacity()-knap.getWeight())*bestVW < bestKnap.getValue() )
			return;
		
		Item i = items.get(s);
		knap.add(i);
		_recursiveSolver(s+1);
		knap.remove(i);
		_recursiveSolver(s+1);
	}
}
