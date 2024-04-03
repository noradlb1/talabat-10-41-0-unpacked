package com.nineoldandroids.animation;

public class IntEvaluator implements TypeEvaluator<Integer> {
    public Integer evaluate(float f11, Integer num, Integer num2) {
        int intValue = num.intValue();
        return Integer.valueOf((int) (((float) intValue) + (f11 * ((float) (num2.intValue() - intValue)))));
    }
}
