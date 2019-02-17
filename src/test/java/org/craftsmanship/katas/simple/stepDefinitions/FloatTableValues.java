package org.craftsmanship.katas.simple.stepDefinitions;

import java.util.Objects;

public class FloatTableValues {
    private float value;

    public FloatTableValues(float value){
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FloatTableValues that = (FloatTableValues) o;
        return Float.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
