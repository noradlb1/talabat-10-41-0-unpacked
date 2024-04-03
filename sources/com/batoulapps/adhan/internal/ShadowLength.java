package com.batoulapps.adhan.internal;

public enum ShadowLength {
    SINGLE(1.0d),
    DOUBLE(2.0d);
    
    private final double shadowLength;

    private ShadowLength(double d11) {
        this.shadowLength = d11;
    }

    public double getShadowLength() {
        return this.shadowLength;
    }
}
