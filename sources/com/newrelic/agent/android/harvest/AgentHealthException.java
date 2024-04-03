package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class AgentHealthException extends HarvestableArray {
    private final AtomicLong count;
    private String exceptionClass;
    private Map<String, String> extras;
    private String message;
    private StackTraceElement[] stackTrace;
    private String threadName;

    public AgentHealthException(Exception exc) {
        this(exc, Thread.currentThread().getName());
    }

    private JsonObject extrasToJson() {
        JsonObject jsonObject = new JsonObject();
        Map<String, String> map = this.extras;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                jsonObject.add((String) next.getKey(), SafeJsonPrimitive.factory((String) next.getValue()));
            }
        }
        return jsonObject;
    }

    private JsonArray stackTraceToJson() {
        JsonArray jsonArray = new JsonArray();
        for (StackTraceElement stackTraceElement : this.stackTrace) {
            jsonArray.add((JsonElement) SafeJsonPrimitive.factory(stackTraceElement.toString()));
        }
        return jsonArray;
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(this.exceptionClass));
        String str = this.message;
        if (str == null) {
            str = "";
        }
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(str));
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory(this.threadName));
        jsonArray.add((JsonElement) stackTraceToJson());
        jsonArray.add((JsonElement) SafeJsonPrimitive.factory((Number) Long.valueOf(this.count.get())));
        jsonArray.add((JsonElement) extrasToJson());
        return jsonArray;
    }

    public long getCount() {
        return this.count.get();
    }

    public String getExceptionClass() {
        return this.exceptionClass;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public String getMessage() {
        return this.message;
    }

    public String getSourceClass() {
        return this.stackTrace[0].getClassName();
    }

    public String getSourceMethod() {
        return this.stackTrace[0].getMethodName();
    }

    public StackTraceElement[] getStackTrace() {
        return this.stackTrace;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public void increment() {
        this.count.getAndIncrement();
    }

    public AgentHealthException(Exception exc, String str) {
        this(exc.getClass().getName(), exc.getMessage(), str, exc.getStackTrace());
    }

    public void increment(long j11) {
        this.count.getAndAdd(j11);
    }

    public AgentHealthException(String str, String str2, String str3, StackTraceElement[] stackTraceElementArr) {
        this(str, str2, str3, stackTraceElementArr, (Map<String, String>) null);
    }

    public AgentHealthException(String str, String str2, String str3, StackTraceElement[] stackTraceElementArr, Map<String, String> map) {
        this.count = new AtomicLong(1);
        this.exceptionClass = str;
        this.message = str2;
        this.threadName = str3;
        this.stackTrace = stackTraceElementArr;
        this.extras = map;
    }
}
