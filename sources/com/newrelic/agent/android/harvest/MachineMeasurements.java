package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.BaseHarvestable;
import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.metric.Metric;
import com.newrelic.agent.android.metric.MetricStore;
import com.newrelic.com.google.gson.Gson;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import java.util.HashMap;

public class MachineMeasurements extends HarvestableArray {
    private final MetricStore metrics = new MetricStore();

    public void addMetric(String str, double d11) {
        Metric metric = new Metric(str);
        metric.sample(d11);
        addMetric(metric);
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        for (Metric next : this.metrics.getAll()) {
            JsonArray jsonArray2 = new JsonArray();
            HashMap hashMap = new HashMap();
            hashMap.put("name", next.getName());
            hashMap.put("scope", next.getStringScope());
            jsonArray2.add(new Gson().toJsonTree(hashMap, BaseHarvestable.GSON_STRING_MAP_TYPE));
            jsonArray2.add((JsonElement) next.asJsonObject());
            jsonArray.add((JsonElement) jsonArray2);
        }
        return jsonArray;
    }

    public void clear() {
        this.metrics.clear();
    }

    public MetricStore getMetrics() {
        return this.metrics;
    }

    public boolean isEmpty() {
        return this.metrics.isEmpty();
    }

    public void addMetric(Metric metric) {
        this.metrics.add(metric);
    }
}
