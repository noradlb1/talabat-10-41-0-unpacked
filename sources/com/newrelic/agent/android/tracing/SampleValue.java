package com.newrelic.agent.android.tracing;

public class SampleValue {
    private boolean isDouble;
    private Double value = Double.valueOf(0.0d);

    public SampleValue(double d11) {
        setValue(d11);
    }

    public Double asDouble() {
        return this.value;
    }

    public Long asLong() {
        return Long.valueOf(this.value.longValue());
    }

    public Number getValue() {
        if (this.isDouble) {
            return asDouble();
        }
        return asLong();
    }

    public boolean isDouble() {
        return this.isDouble;
    }

    public void setDouble(boolean z11) {
        this.isDouble = z11;
    }

    public void setValue(double d11) {
        this.value = Double.valueOf(d11);
        this.isDouble = true;
    }

    public void setValue(long j11) {
        this.value = Double.valueOf((double) j11);
        this.isDouble = false;
    }

    public SampleValue(long j11) {
        setValue(j11);
    }
}
