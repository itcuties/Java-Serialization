package com.itcuties.java.serialization.simple;

import java.io.Serializable;

/**
 * This class will demonstrate most basic serialization in java.
 * It shows that every primitive can be serialized. As well as every object that implements Serializable interface.
 * Fields with the keyword <b>transient</b> will be omitted during serialization.
 * Custom classes must implement the Serializable interface.
 * 
 * @author itcuties
 */
public class SimpleSerializableClass implements Serializable {
	/** This is generated serial version UID. Any number will do. This is used to point the serialization mechanism that
	 * the class has changed. If you change the number and try to deserialize previously serialized data you will get an error.*/
	private static final long serialVersionUID = 2304865599345677437L;

	/**
	 * Below are some fields that will hold the data used by the class.
	 * Any primitive and String instance can be serialized.
	 */
	private int intData;
	private float floatData;
	private String stringData;
	
	/** Final fields are serialized just like normal fields. */
	private final String finalData = "final data";
	
	/** Static fields are not serialized because they are connected with a class and not an instance of the object. */
	private static String staticData;
	
	/** The 'transient' keyword will cause the field to be ommited during serialization/deserialization. */
	private transient String notSerializableData;
	
	/** Custom classes can be serialized unless they also implement the serializable interface. */
	private CustomSerializableObject customSerializableObject;

	/**
	 * The constructor is NOT called when the object is deserialized.
	 * That is why serialization is one of the four ways to instantiate an object.
	 */
	public SimpleSerializableClass() {
		System.out.println(SimpleSerializableClass.class.getName() + ".constructor");
		staticData = "static-data";
	}
	
	public int getIntData() {
		return intData;
	}

	public void setIntData(int intData) {
		this.intData = intData;
	}

	public float getFloatData() {
		return floatData;
	}

	public void setFloatData(float floatData) {
		this.floatData = floatData;
	}

	public String getStringData() {
		return stringData;
	}

	public void setStringData(String stringData) {
		this.stringData = stringData;
	}
	
	public String getNotSerializableData() {
		return notSerializableData;
	}
	
	public void setNotSerializableData(String notSerializableData) {
		this.notSerializableData = notSerializableData;
	}
	
	public CustomSerializableObject getCustomSerializableObject() {
		return customSerializableObject;
	}
	
	public void setCustomSerializableObject(CustomSerializableObject customSerializableObject) {
		this.customSerializableObject = customSerializableObject;
	}

	@Override
	public String toString() {
		return "SimpleSerializableClass [intData=" + intData + ", floatData="
				+ floatData + ", stringData=" + stringData + ", finalData="
				+ finalData + ", notSerializableData=" + notSerializableData
				+ ", customSerializableObject=" + customSerializableObject + "]";
	}
}
