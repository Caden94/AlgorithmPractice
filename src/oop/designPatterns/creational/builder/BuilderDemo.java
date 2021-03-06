package designPatterns.creational.builder;

public class BuilderDemo {
	public static void main(String[] args) {
		MealBuilder builder = new MealBuilder();
		Meal vegMeal = builder.prepareVegMeal();
		vegMeal.showItems();
		System.out.println(vegMeal.getCost());
	}
}
