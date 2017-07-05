package designPatterns.creational.builder;

import java.util.*;

public class Meal {
	private ArrayList<Item> items;

	public Meal() {
		// TODO Auto-generated constructor stub
		this.items = new ArrayList<>();
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public float getCost() {
		float cost = 0.0f;
		for (Item item : items)
			cost += item.price();
		return cost;
	}

	public void showItems() {
		for (Item item : items) {
			System.out.println(item.name());
			System.out.println(item.packing().pack());
		}
			
			
	}
}
