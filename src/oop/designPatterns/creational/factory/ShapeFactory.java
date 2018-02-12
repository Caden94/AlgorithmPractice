package designPatterns.creational.factory;

public class ShapeFactory {
	public ShapeFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Shape getShape(String shapeType) {
		if (shapeType == null)
			return null;
		if (shapeType.equalsIgnoreCase("CIRCLE"))
			return new Circle();
		if (shapeType.equalsIgnoreCase("SQUARE"))
			return new Square();
		if (shapeType.equalsIgnoreCase("RECTANGLE"))
			return new Rectangle();
		return null;
	}
}
