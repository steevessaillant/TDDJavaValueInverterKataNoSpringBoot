package org.craftsmanship.katas.simple;

public class ValueInverter {

	public boolean invertValue(boolean value) {
		return !value;
	}

	public float invertValue(Float value) {
		if (value == null)
			throw new NullPointerException("Value was null, cannot pass a null value to this method");
		else
			return -value.floatValue();
	}

}
