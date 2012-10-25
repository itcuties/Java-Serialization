package com.itcuties.java.serialization.simple;

import java.io.Serializable;

/**
 * This class will demonstrate that using non-serializable field inside the serializable class will cause
 * java.io.NotSerializableException to be raised.
 * 
 * @author itcuties
 */
public class SimpleSerializableClassWithError implements Serializable {
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
	
	/** The 'transient' keyword will cause the field to be ommited during serialization/deserialization. */
	private transient String notSerializableData;
	
	/** Using non-transient field that is not serializable will cause serialization error. */
	private CustomNotSerializableObject customNotSerializableObject;

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
	
	public CustomNotSerializableObject getCustomNotSerializableObject() {
		return customNotSerializableObject;
	}
	
	public void setCustomNotSerializableObject(CustomNotSerializableObject customSerializableObject) {
		this.customNotSerializableObject = customSerializableObject;
	}

	@Override
	public String toString() {
		return "SimpleSerializableClass [intData=" + intData + ", floatData="
				+ floatData + ", stringData=" + stringData
				+ ", notSerializableData=" + notSerializableData
				+ ", customNotSerializableObject=" + customNotSerializableObject
				+ "]";
	}
}
