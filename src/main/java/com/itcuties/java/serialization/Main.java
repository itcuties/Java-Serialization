package com.itcuties.java.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.itcuties.java.serialization.simple.CustomNotSerializableObject;
import com.itcuties.java.serialization.simple.CustomSerializableObject;
import com.itcuties.java.serialization.simple.SimpleSerializableClass;
import com.itcuties.java.serialization.simple.SimpleSerializableClassWithError;

/**
 * The class to present serialization issues.
 * 
 * @author itcuties
 */
public class Main {
	
	public static void main(String[] args) {
		//Main.simpleSerialization();
		//System.out.println("==========================================");
		Main.simpleSerializationWithError();
		System.out.println("==========================================");
	}
	
	/**
	 * This method presents how to serialize and deserialize a simple object.
	 */
	private static void simpleSerialization() {
		System.out.println("Running simple serialization.");
		
		//first create an instance of a class and fill it with data
		SimpleSerializableClass dataToSerialize = new SimpleSerializableClass();
		dataToSerialize.setFloatData(1.234f);
		dataToSerialize.setIntData(1234);
		dataToSerialize.setStringData("1234");
		dataToSerialize.setNotSerializableData("This string will not be serialized.");
		dataToSerialize.setCustomSerializableObject(new CustomSerializableObject("Serializable object with custom data."));
		
		Main.serializeAndDeserialize(dataToSerialize, "simple-serialization.dat");
	}
	
	/**
	 * This method presents how to serialize and deserialize a simple object.
	 */
	private static void simpleSerializationWithError() {
		System.out.println("Running simple serialization with error.");
		
		//first create an instance of a class and fill it with data
		SimpleSerializableClassWithError dataToSerialize = new SimpleSerializableClassWithError();
		dataToSerialize.setFloatData(1.234f);
		dataToSerialize.setIntData(1234);
		dataToSerialize.setStringData("1234");
		dataToSerialize.setNotSerializableData("This string will not be serialized.");
		dataToSerialize.setCustomNotSerializableObject(new CustomNotSerializableObject());
		
		Main.serializeAndDeserialize(dataToSerialize, "simple-serialization-with-error.dat");
	}
	
	
	
	/**
	 * An utility method to serialize - deserialize the given instance.
	 * 
	 * @param objectToSerialize
	 *            instance to be serialized-deserialized
	 * @param serializationFileName
	 *            serialization file name
	 * @return deserialized object
	 */
	private static Serializable serializeAndDeserialize(Serializable objectToSerialize, String serializationFileName) {
		System.out.println("Data that will be serialized: " + objectToSerialize);
		
		//open the stream where the data will be put
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(serializationFileName);
			
			//ObjectOutputStream is the stream used to serialize the object
			oos = new ObjectOutputStream(fos);
			
			System.out.println("Serializing the created instance.");
			oos.writeObject(objectToSerialize);
			oos.flush();
			System.out.println("Object is succesfully serialized.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("Now the object will be deserialized.");
		Serializable deserializedInstance = null;
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream(serializationFileName);
			
			//ObjectInputStream is the stream used to deserialize the object
			ois = new ObjectInputStream(fis);
			
			deserializedInstance = (Serializable) ois.readObject();
			System.out.println("Deserialized data: " + deserializedInstance);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return deserializedInstance;
	}
}
