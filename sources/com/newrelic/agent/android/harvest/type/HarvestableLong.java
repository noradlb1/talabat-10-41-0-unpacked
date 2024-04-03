package com.newrelic.agent.android.harvest.type;

import com.newrelic.com.google.gson.JsonPrimitive;

public class HarvestableLong extends HarvestableValue {
    private long value;

    public HarvestableLong() {
    }

    public JsonPrimitive asJsonPrimitive() {
        return new JsonPrimitive((Number) Long.valueOf(this.value));
    }

    public HarvestableLong(long j11) {
        this();
        this.value = j11;
    }
}
