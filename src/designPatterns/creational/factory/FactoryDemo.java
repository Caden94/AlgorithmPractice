package designPatterns.creational.factory;

public class FactoryDemo {
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape circle = factory.getShape("circle");
		circle.draw();
	}
}
