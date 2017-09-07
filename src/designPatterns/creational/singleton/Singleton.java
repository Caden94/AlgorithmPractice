package designPatterns.creational.singleton;
/*
 * static
 * private constructor
 */
public class Singleton {
	// static object
	private static Singleton instance = new Singleton();
	// private constructor
	private Singleton() {}
	// get instance method
	public static Singleton getSingleton() {
		return instance;
	}
	// test method
	public void showMessage() {
		System.out.println("Hello world!");
	}
}
