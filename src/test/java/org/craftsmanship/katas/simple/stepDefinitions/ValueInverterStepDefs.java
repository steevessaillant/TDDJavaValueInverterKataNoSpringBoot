package org.craftsmanship.katas.simple.stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.ThrowableAssertAlternative;
import org.craftsmanship.katas.simple.ValueInverter;
import org.junit.Assert;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(
        classes = ValueInverter.class)
public class ValueInverterStepDefs extends StepsDefsTestBase {

    @Autowired
    private ValueInverter sut;
    private List<BoolTableValues> actualBoolTableValues;
    private List<BoolTableValues> expectedBoolTableValues;
    private List<FloatTableValues> actualFloatTableValues;
    private List<FloatTableValues> expectedFloatTableValues;
    private ThrowableAssertAlternative<NullPointerException> trownNullPointerException;


    @Given("^I start the system$")
    public void i_start_the_system() throws Throwable {
        Assert.assertNotNull(sut);
    }


    @When("^I pass$")
    public void i_pass(DataTable actual) throws Throwable {
        this.actualBoolTableValues = actual.asList(BoolTableValues.class);
        this.expectedBoolTableValues = new ArrayList<>();
        this.actualBoolTableValues.forEach(x -> expectedBoolTableValues
                .add(new BoolTableValues(this.sut.invertValue(x.getValue()))));
    }

    @Then("^I should obtain$")
    public void i_should_obtain(DataTable expected) throws Throwable {
        assertThat(this.expectedBoolTableValues
                .equals(expected.asList(BoolTableValues.class))).isTrue();
    }


    @Then("^I should obtain inverted floats$")
    public void iShouldObtainInvertedFloats(DataTable expected) {
        assertThat(this.expectedFloatTableValues
                .equals(expected.asList(FloatTableValues.class))).isTrue();
    }

    @When("^I pass null$")
    public void iPassNull() {
       this.trownNullPointerException =  assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy ( ( ) -> sut.invertValue ( null ));

    }

    @Then("^I should obtain \"([^\"]*)\"     |$")
    public void iShouldObtain(String errorMessage) throws Throwable {
        this.trownNullPointerException.withMessage(errorMessage);
    }

    @When("^I pass floats$")
    public void iPassFloats(DataTable actual) {
        this.actualFloatTableValues = actual.asList(FloatTableValues.class);
        this.expectedFloatTableValues = new ArrayList<>();
        this.actualFloatTableValues.forEach(x -> expectedFloatTableValues
                .add(new FloatTableValues(this.sut.invertValue(x.getValue()))));
    }
}
