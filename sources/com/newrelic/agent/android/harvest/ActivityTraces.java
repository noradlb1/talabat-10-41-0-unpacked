package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collection;

public class ActivityTraces extends HarvestableArray {
    private final Collection<ActivityTrace> activityTraces = new ArrayList();

    public synchronized void add(ActivityTrace activityTrace) {
        this.activityTraces.add(activityTrace);
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        for (ActivityTrace asJson : this.activityTraces) {
            jsonArray.add(asJson.asJson());
        }
        return jsonArray;
    }

    public void clear() {
        this.activityTraces.clear();
    }

    public int count() {
        return this.activityTraces.size();
    }

    public Collection<ActivityTrace> getActivityTraces() {
        return this.activityTraces;
    }

    public synchronized void remove(ActivityTrace activityTrace) {
        this.activityTraces.remove(activityTrace);
    }
}
