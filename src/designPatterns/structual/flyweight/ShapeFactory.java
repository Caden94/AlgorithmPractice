package designPatterns.structual.flyweight;

import java.util.*;

public class ShapeFactory {
	private static HashMap<String, Shape> shapeMap = new HashMap<>();

	public static Shape getCircle(String color) {
		Shape shape = shapeMap.get(color);
		if (shape == null) {
			shape = new Circle(color);
			shapeMap.put(color, shape);
			System.out.println("Creating circle of color : " + color);
		}
		return shape;
	}
}
