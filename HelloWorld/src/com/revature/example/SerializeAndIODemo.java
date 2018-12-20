package com.revature.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.transport.Car;

public class SerializeAndIODemo {

	public static void main(String[] args) {
		String filename = "src/serializedThings.txt";
		/*List<Car> carList = new ArrayList<Car>();
		carList.add(new Car(2021, "spaceship", "Tesla", 50));
		carList.add(new Car(1997, "Fiesta", "Ford", 500));
		carList.add(new Car(2007, "Fancy", "Cadillac", 50));
		System.out.println(carList.get(0).compareTo(carList.get(2)));
		System.out.println("Cars before sort: ");
		for (Car c : carList) {
			System.out.println(c);
		}
		
		serializeToFile(filename, carList); */
		System.out.println(deserializeFromFile(filename));

	}

	// serialize an object and write it to a file
	static void serializeToFile(String filename, Object o) {
		try {
			// use a FileOutputStream to write serialized object to file
			FileOutputStream fileOut = new FileOutputStream(filename);
			// use ObjectOutputStream to serialize the object
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o); // what actually does the serialization
			// close the stream
			out.close();
			fileOut.close();
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static Object deserializeFromFile(String filename) {
		Object o = null;
		try {
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			o = in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return o;
	}

}
