package org.craftsmanship.katas.simple.stepDefinitions;

import java.util.Objects;

public class BoolTableValues {
    private boolean value = false;

    public BoolTableValues(boolean value){
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoolTableValues that = (BoolTableValues) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
