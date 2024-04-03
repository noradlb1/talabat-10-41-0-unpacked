package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collection;

public class Events extends HarvestableArray {
    private final Collection<Event> events = new ArrayList();

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        for (Event asJson : this.events) {
            jsonArray.add(asJson.asJson());
        }
        return jsonArray;
    }
}
