package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.agent.android.util.SafeJsonPrimitive;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ThreadInfo extends HarvestableObject {
    protected boolean crashed;
    protected StackTraceElement[] stackTrace;
    protected String state;
    protected long threadId;
    protected String threadName;
    protected int threadPriority;

    public ThreadInfo() {
    }

    public static List<ThreadInfo> extractThreads(Throwable th2) {
        return new ThreadInfo(th2).allThreads();
    }

    private JsonArray getStackAsJson() {
        JsonArray jsonArray = new JsonArray();
        for (StackTraceElement stackTraceElement : this.stackTrace) {
            JsonObject jsonObject = new JsonObject();
            if (stackTraceElement.getFileName() != null) {
                jsonObject.add("fileName", SafeJsonPrimitive.factory(stackTraceElement.getFileName()));
            }
            jsonObject.add(HexAttribute.HEX_ATTR_CLASS_NAME, SafeJsonPrimitive.factory(stackTraceElement.getClassName()));
            jsonObject.add(HexAttribute.HEX_ATTR_METHOD_NAME, SafeJsonPrimitive.factory(stackTraceElement.getMethodName()));
            jsonObject.add("lineNumber", SafeJsonPrimitive.factory((Number) Integer.valueOf(stackTraceElement.getLineNumber())));
            jsonArray.add((JsonElement) jsonObject);
        }
        return jsonArray;
    }

    public static ThreadInfo newFromJson(JsonObject jsonObject) {
        ThreadInfo threadInfo = new ThreadInfo();
        threadInfo.crashed = jsonObject.get("crashed").getAsBoolean();
        threadInfo.state = jsonObject.get("state").getAsString();
        threadInfo.threadId = jsonObject.get("threadNumber").getAsLong();
        threadInfo.threadName = jsonObject.get("threadId").getAsString();
        threadInfo.threadPriority = jsonObject.get("priority").getAsInt();
        threadInfo.stackTrace = threadInfo.stackTraceFromJson(jsonObject.get("stack").getAsJsonArray());
        return threadInfo;
    }

    public List<ThreadInfo> allThreads() {
        ArrayList arrayList = new ArrayList();
        long threadId2 = getThreadId();
        arrayList.add(this);
        for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
            Thread thread = (Thread) next.getKey();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) next.getValue();
            if (thread.getId() != threadId2) {
                arrayList.add(new ThreadInfo(thread, stackTraceElementArr));
            }
        }
        return arrayList;
    }

    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("crashed", SafeJsonPrimitive.factory(Boolean.valueOf(this.crashed)));
        jsonObject.add("state", SafeJsonPrimitive.factory(this.state));
        jsonObject.add("threadNumber", SafeJsonPrimitive.factory((Number) Long.valueOf(this.threadId)));
        jsonObject.add("threadId", SafeJsonPrimitive.factory(this.threadName));
        jsonObject.add("priority", SafeJsonPrimitive.factory((Number) Integer.valueOf(this.threadPriority)));
        jsonObject.add("stack", getStackAsJson());
        return jsonObject;
    }

    public long getThreadId() {
        return this.threadId;
    }

    public List<ThreadInfo> newListFromJson(JsonArray jsonArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            arrayList.add(newFromJson(it.next().getAsJsonObject()));
        }
        return arrayList;
    }

    public StackTraceElement[] stackTraceFromJson(JsonArray jsonArray) {
        String str;
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[jsonArray.size()];
        Iterator<JsonElement> it = jsonArray.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            JsonElement next = it.next();
            if (next.getAsJsonObject().get("fileName") != null) {
                str = next.getAsJsonObject().get("fileName").getAsString();
            } else {
                str = "unknown";
            }
            stackTraceElementArr[i11] = new StackTraceElement(next.getAsJsonObject().get(HexAttribute.HEX_ATTR_CLASS_NAME).getAsString(), next.getAsJsonObject().get(HexAttribute.HEX_ATTR_METHOD_NAME).getAsString(), str, next.getAsJsonObject().get("lineNumber").getAsInt());
            i11++;
        }
        return stackTraceElementArr;
    }

    public ThreadInfo(Throwable th2) {
        this(Thread.currentThread(), th2.getStackTrace());
        this.crashed = true;
    }

    public ThreadInfo(Thread thread, StackTraceElement[] stackTraceElementArr) {
        this.crashed = false;
        this.threadId = thread.getId();
        this.threadName = thread.getName();
        this.threadPriority = thread.getPriority();
        this.state = thread.getState().toString();
        this.stackTrace = stackTraceElementArr;
    }
}
