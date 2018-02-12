package designPatterns.creational.builder;

public abstract class ColdDrink implements Item {
	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return new Bottle();
	}
}
