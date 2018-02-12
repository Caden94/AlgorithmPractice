package designPatterns.structual.composite;

import java.util.*;

public class Employee {
	private String name;
	private String department;
	private int salary;
	private List<Employee> subordinates;

	public Employee(String name, String department, int salary) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.subordinates = new ArrayList<>();
	}

	public void add(Employee employee) {
		if (employee != null)
			subordinates.add(employee);

	}

	public void remove(Employee employee) {
		if (subordinates.contains(employee))
			subordinates.remove(employee);
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}

}
