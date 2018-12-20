package com.revature.example;

import java.util.Arrays;
import java.lang.reflect.Field;
import com.revature.vacation.Kayak;


public class GenericsAndReflection {


	public static void main(String[] args) {
		/*Car c = new Car (2300, "Fury Roadster", "Mad Max", 1000);
		Object[] emptyCars = replicate(c,3);
		try {
			((Car) emptyCars[2]).move();
			System.out.println(emptyCars);
			} catch (MaintenanceException m) {
				m.printStackTrace();
			}
	*/
		funWithReflections();
	}

	// fills an array of specified size with objects of the same type as passed in to the method
	// or does it??????
	static Object[] replicate (Object o, int size) {
		Object[] replicants = new Object[size];
		for (int i = 0; i < size; i++) {
			replicants[i] = new Object();
		}
		return replicants;
	}
	
	static <T> Object[] replicateWithGenerics(T t, int size) {
		Object[] replicants = new Object[size];
		for (int i = 0; i < size; i++) {
			try {
				replicants[i] = (t.getClass()).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		return replicants;
	}
	
	// time to use the reflection API!
	
	/*
	 * allows us to perform a runtime check on a variable's type and do so much more. 
	 * inspect classes at runtime as well (PRIMARY UTILITY)
	 */
	 
	static void funWithReflections() {
		// first thing: Get a class object by its fully qualified name. 
		try {
			Class<?> clazz = Class.forName("com.revature.vacation.Kayak");
			System.out.println(clazz.getSimpleName());
			
			// get the fields of Kayak
			Field[] fields = clazz.getDeclaredFields();
			System.out.println(Arrays.toString(fields));
			
			// new instance of kayak
			Kayak k = (Kayak) clazz.newInstance();
			Field numSeats = clazz.getDeclaredField("numSeats");
			numSeats.setAccessible(true);
			numSeats.set(k, 5);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} 
	}
}
