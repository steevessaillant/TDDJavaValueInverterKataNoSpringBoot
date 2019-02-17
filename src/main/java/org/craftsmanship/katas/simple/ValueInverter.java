package org.craftsmanship.katas.simple;

import java.awt.Color;

import org.springframework.stereotype.Component;

@Component
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

	public Color invertColor(Color color) {
		if (color == null)
			throw new NullPointerException("Color was null, cannot pass a null value to this method");
		else
			return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
	}

}
