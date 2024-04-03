package com.nineoldandroids.animation;

public class FloatEvaluator implements TypeEvaluator<Number> {
    public Float evaluate(float f11, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f11 * (number2.floatValue() - floatValue)));
    }
}
