package designPatterns.creational.singleton;

public class SingletonDemo {
	public static void main(String[] args) {
		Singleton instance = Singleton.getSingleton();
		Singleton instance2 = Singleton.getSingleton();
		System.out.println(instance == instance2);
	}
}
