package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;

public class Sample extends HarvestableArray {
    private SampleValue sampleValue;
    private long timestamp;
    private SampleType type;

    public enum SampleType {
        MEMORY,
        CPU
    }

    public Sample(SampleType sampleType) {
        setSampleType(sampleType);
        setTimestamp(System.currentTimeMillis());
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(this.timestamp)));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(this.sampleValue.getValue()));
        return jsonArray;
    }

    public SampleType getSampleType() {
        return this.type;
    }

    public SampleValue getSampleValue() {
        return this.sampleValue;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public Number getValue() {
        return this.sampleValue.getValue();
    }

    public void setSampleType(SampleType sampleType) {
        this.type = sampleType;
    }

    public void setSampleValue(SampleValue sampleValue2) {
        this.sampleValue = sampleValue2;
    }

    public void setTimestamp(long j11) {
        this.timestamp = j11;
    }

    public void setSampleValue(double d11) {
        this.sampleValue = new SampleValue(d11);
    }

    public void setSampleValue(long j11) {
        this.sampleValue = new SampleValue(j11);
    }

    public Sample(long j11) {
        setTimestamp(j11);
    }

    public Sample(long j11, SampleValue sampleValue2) {
        setTimestamp(j11);
        setSampleValue(sampleValue2);
    }
}
