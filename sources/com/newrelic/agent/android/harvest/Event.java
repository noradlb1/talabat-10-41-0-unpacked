package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.BaseHarvestable;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonPrimitive;
import java.util.HashMap;
import java.util.Map;

public class Event extends HarvestableArray {
    private long eventName;
    private Map<String, String> params = new HashMap();
    private long timestamp;

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add((JsonElement) new JsonPrimitive((Number) Long.valueOf(this.timestamp)));
        jsonArray.add((JsonElement) new JsonPrimitive((Number) Long.valueOf(this.eventName)));
        jsonArray.add(new Gson().toJsonTree(this.params, BaseHarvestable.GSON_STRING_MAP_TYPE));
        return jsonArray;
    }

    public long getEventName() {
        return this.eventName;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setEventName(long j11) {
        this.eventName = j11;
    }

    public void setParams(Map<String, String> map) {
        this.params = map;
    }

    public void setTimestamp(long j11) {
        this.timestamp = j11;
    }
}
