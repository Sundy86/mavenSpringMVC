package com.sc.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
//	private Car car;
//	
//	private List<Car> carlsit;
//	private Set<Car> setlist;
//	
//	private Map<Object, Object> maptest;
//	
//	
//	public Map<Object, Object> getMaptest() {
//		return maptest;
//	}
//	public void setMaptest(Map<Object, Object> maptest) {
//		this.maptest = maptest;
//	}
//	public Set<Car> getSetlist() {
//		return setlist;
//	}
//	public void setSetlist(Set<Car> setlist) {
//		this.setlist = setlist;
//	}
//	public List<Car> getCarlsit() {
//		return carlsit;
//	}
//	public void setCarlsit(List<Car> carlsit) {
//		this.carlsit = carlsit;
//	}
//	public Car getCar() {
//		return car;
//	}
//	public void setCar(Car car) {
//		this.car = car;
//	}

//	
//	
//	@Override
//	public String toString() {
//		return "User [name=" + name + ", age=" + age + "]";
//	}ss
	public static void main(String[] args) {
		User usero = new User();
		
		try {
			Class clz= Class.forName("com.sc.test.User"); //����
			User user = (User) clz.newInstance();
			user.setAge(12);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
