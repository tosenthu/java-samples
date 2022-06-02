package com.senthu.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

// Deep Immutable
// Lock and synchronized
public class MyClass {

	private static class Department {
		private Integer id;

		public Integer getId() {
			return this.id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	}

	private final static class Employee extends Object implements Cloneable {
		private String name;
		private Integer id;
		private Department d;

		private Employee() {

		}

		public Employee(Integer id, String name) {

			this();
			this.setId(id);
			this.setName(name);

			synchronized (name) {
			}
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			return this;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Employee)) {
				return false;
			}
			Employee otherEmployee = (Employee) obj;
			return this.getId().equals(otherEmployee.getId()) && this.getName().equals(otherEmployee.getName());
		}

		public Integer getId() {
			return this.id;
		}

		public String getName() {
			return this.name;
		}

		@Override
		public int hashCode() {
			return this.getId().hashCode() + this.getName().hashCode();
		}

		private void setId(Integer id) {
			this.id = id;
		}

		private void setName(String name) {
			this.name = name;
		}
	}

	public static void main(String[] args) {

		Employee e1 = new MyClass.Employee(1, "Senthil");
		Employee e2 = new MyClass.Employee(2, "Kumar");
		Employee e3 = new MyClass.Employee(1, "Senthil");

		HashMap<Employee, String> map = new HashMap<MyClass.Employee, String>();
		map.put(e1, e1.getName());
		map.put(e2, e2.getName());
		map.put(e3, "sample");
		String s = "sample";
		String s1 = "sample";

		if (s == s1) {
			System.out.println("zero Same");
		}

		String s2 = "sample";

		if (s == s2) {
			System.out.println("one Same");
		}

		if (s1 == s2) {
			System.out.println("two Same");
		}

//		System.out.println(map.get(e1));
//		System.out.println(map.get(e2));
//		System.out.println(map.get(e3));

		List<Employee> list = new ArrayList<MyClass.Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);

		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				if (o1 == null) {
					return 1;
				}
				if (o2 == null) {
					return -1;
				}
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

}
