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

package bean;

public class Item {
	private double value;
	private double weight;
	public double getValue() {
		return value;
	}
	public void setValue(double val) {
		this.value = val;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Item(double value, double weight) {
		super();
		this.value = value;
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Item [value=" + value + ", weight=" + weight + "]";
	}
	
}
