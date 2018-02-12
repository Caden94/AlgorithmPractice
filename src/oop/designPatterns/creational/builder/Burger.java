package designPatterns.creational.builder;

public abstract class Burger implements Item {
	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return new Wrapper();
	}
}
