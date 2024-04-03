package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class AgentHealthExceptions extends HarvestableObject {
    private static final JsonArray keyArray = new JsonArray();
    private final Map<String, AgentHealthException> agentHealthExceptions = new ConcurrentHashMap();

    public AgentHealthExceptions() {
        JsonArray jsonArray = keyArray;
        jsonArray.add((JsonElement) new JsonPrimitive("ExceptionClass"));
        jsonArray.add((JsonElement) new JsonPrimitive("Message"));
        jsonArray.add((JsonElement) new JsonPrimitive("ThreadName"));
        jsonArray.add((JsonElement) new JsonPrimitive("CallStack"));
        jsonArray.add((JsonElement) new JsonPrimitive("Count"));
        jsonArray.add((JsonElement) new JsonPrimitive("Extras"));
    }

    public void add(AgentHealthException agentHealthException) {
        String key = getKey(agentHealthException);
        synchronized (this.agentHealthExceptions) {
            AgentHealthException agentHealthException2 = this.agentHealthExceptions.get(key);
            if (agentHealthException2 == null) {
                this.agentHealthExceptions.put(key, agentHealthException);
            } else {
                agentHealthException2.increment();
            }
        }
    }

    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for (AgentHealthException asJsonArray : this.agentHealthExceptions.values()) {
            jsonArray.add((JsonElement) asJsonArray.asJsonArray());
        }
        jsonObject.add("Type", new JsonPrimitive("AgentErrors"));
        jsonObject.add("Keys", keyArray);
        jsonObject.add("Data", jsonArray);
        return jsonObject;
    }

    public void clear() {
        synchronized (this.agentHealthExceptions) {
            this.agentHealthExceptions.clear();
        }
    }

    public Map<String, AgentHealthException> getAgentHealthExceptions() {
        return this.agentHealthExceptions;
    }

    public final String getKey(AgentHealthException agentHealthException) {
        String name2 = getClass().getName();
        if (agentHealthException == null) {
            return name2;
        }
        String exceptionClass = agentHealthException.getExceptionClass();
        String stackTraceElement = agentHealthException.getStackTrace()[0].toString();
        return exceptionClass + stackTraceElement;
    }

    public boolean isEmpty() {
        return this.agentHealthExceptions.isEmpty();
    }
}
