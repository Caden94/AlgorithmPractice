package designPatterns.creational.singleton;
/*
 * static
 * private constructor
 */
public class Singleton {
	private static Singleton instance = new Singleton();

	private Singleton() {}

	public static Singleton getSingleton() {
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello world!");
	}
}
