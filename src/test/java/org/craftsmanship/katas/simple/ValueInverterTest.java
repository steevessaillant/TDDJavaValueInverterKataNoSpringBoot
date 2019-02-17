package org.craftsmanship.katas.simple;

import org.junit.Test;

import java.awt.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class ValueInverterTest{

	private ValueInverter sut = new ValueInverter();

	@Test
	public void invertValueShouldReturnFalseWhenPassedTrue() {
		assertThat(sut.invertValue(true)).isEqualTo(false);
	}

	@Test
	public void invertValueShouldReturnTrueWhenPassedFalse() {
		assertThat(sut.invertValue(false)).isEqualTo(true);
	}

	@Test
	public void invertValueShouldThrowNullPointerExceptionWhenPassedNullAndDisplayMessage() {
		assertThatExceptionOfType(NullPointerException.class)
				.isThrownBy ( ( ) -> {
					sut.invertValue ( null );
				} )
		 	.withMessage("Value was null, cannot pass a null value to this method");
	}

	
	@Test
	public void invertValueShouldReturnMinusOneWhenPassedOne() {
		assertThat(sut.invertValue(1.1F)).isEqualTo(-1.1F);
	}

	@Test
	public void invertValueShouldReturnOneWhenPassedMinusOne() {
		assertThat(sut.invertValue(-1.1F)).isEqualTo(1.1F);
	}


}