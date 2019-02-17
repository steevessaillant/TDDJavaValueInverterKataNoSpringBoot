package org.craftsmanship.katas.simple;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.awt.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class ValueInverterTest extends TestBase {

	@Autowired
	private ValueInverter sut;

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
	
	@Test
	public void invertColorShouldThrowNullPointerExceptionWhenPassedNullAndDisplayMessage() {
		assertThatExceptionOfType(NullPointerException.class)
				.isThrownBy ( ( ) -> {
					sut.invertColor ( null );
				} )
				.withMessage ( "Color was null, cannot pass a null value to this method" );
	}

	@Test 
	public void invertColorShouldReturnBLACKWhenPassedWHITE(){
		assertThat(sut.invertColor(Color.BLACK)).isEqualTo(Color.WHITE);
	}
	
	@Test 
	public void invertColorShouldReturnWHITEWhenPassedBLACK(){
		assertThat(sut.invertColor(Color.WHITE)).isEqualTo(Color.BLACK);
	}
	
	
	@Test 
	public void invertColorShouldReturnCYANWhenPassedRED(){
		assertThat(sut.invertColor(Color.RED)).isEqualTo(Color.CYAN);
	}
	
	@Test 
	public void invertColorShouldReturnMAGENTAWhenPassedGREEN(){
		assertThat(sut.invertColor(Color.GREEN)).isEqualTo(Color.MAGENTA);
	}
	
	@Test 
	public void invertColorShouldReturnYELLOWWhenPassedBLUE(){
		assertThat(sut.invertColor(Color.BLUE)).isEqualTo(Color.YELLOW);
	}


}