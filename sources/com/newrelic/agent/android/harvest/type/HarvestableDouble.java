package com.newrelic.agent.android.harvest.type;

import com.newrelic.com.google.gson.JsonPrimitive;

public class HarvestableDouble extends HarvestableValue {
    private double value;

    public HarvestableDouble() {
    }

    public JsonPrimitive asJsonPrimitive() {
        return new JsonPrimitive((Number) Double.valueOf(this.value));
    }

    public HarvestableDouble(double d11) {
        this();
        this.value = d11;
    }
}
