package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;

public class ActivitySighting extends HarvestableArray {
    private long durationMs = 0;

    /* renamed from: name  reason: collision with root package name */
    private String f52780name;
    private final long timestampMs;

    public ActivitySighting(long j11, String str) {
        this.timestampMs = j11;
        this.f52780name = str;
    }

    public static ActivitySighting newFromJson(JsonArray jsonArray) {
        return new ActivitySighting(jsonArray.get(0).getAsLong(), jsonArray.get(1).getAsString());
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        synchronized (this) {
            jsonArray.add((JsonElement) SafeJsonPrimitive.factory(this.f52780name));
            jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(this.timestampMs)));
            jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(this.durationMs)));
        }
        return jsonArray;
    }

    public JsonArray asJsonArrayWithoutDuration() {
        JsonArray jsonArray = new JsonArray();
        synchronized (this) {
            jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(this.timestampMs)));
            jsonArray.add((JsonElement) SafeJsonPrimitive.factory(this.f52780name));
        }
        return jsonArray;
    }

    public void end(long j11) {
        synchronized (this) {
            this.durationMs = j11 - this.timestampMs;
        }
    }

    public long getDuration() {
        return this.durationMs;
    }

    public String getName() {
        return this.f52780name;
    }

    public long getTimestampMs() {
        return this.timestampMs;
    }

    public void setName(String str) {
        synchronized (this) {
            this.f52780name = str;
        }
    }
}
