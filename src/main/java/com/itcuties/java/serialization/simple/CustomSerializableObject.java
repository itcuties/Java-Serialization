package com.itcuties.java.serialization.simple;

import java.io.Serializable;

/**
 * A custom class that IS serializable.
 * 
 * @author itcuties
 */
public class CustomSerializableObject implements Serializable {
	private static final long serialVersionUID = -1455333437430468800L;

	private String data;

	public CustomSerializableObject(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CustomSerializableObject [data=" + data + "]";
	}
}
