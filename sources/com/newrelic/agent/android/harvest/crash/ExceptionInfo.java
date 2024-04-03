package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.agentdata.HexAttribute;
import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;

public class ExceptionInfo extends HarvestableObject {
    private String className;
    private String message;

    public ExceptionInfo() {
    }

    public static ExceptionInfo newFromJson(JsonObject jsonObject) {
        String str;
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        String str2 = "";
        if (jsonObject.has("name")) {
            str = jsonObject.get("name").getAsString();
        } else {
            str = str2;
        }
        exceptionInfo.className = str;
        if (jsonObject.has(HexAttribute.HEX_ATTR_CAUSE)) {
            str2 = jsonObject.get(HexAttribute.HEX_ATTR_CAUSE).getAsString();
        }
        exceptionInfo.message = str2;
        return exceptionInfo;
    }

    public JsonObject asJsonObject() {
        JsonObject jsonObject = new JsonObject();
        String str = this.className;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        jsonObject.add("name", new JsonPrimitive(str));
        String str3 = this.message;
        if (str3 != null) {
            str2 = str3;
        }
        jsonObject.add(HexAttribute.HEX_ATTR_CAUSE, new JsonPrimitive(str2));
        return jsonObject;
    }

    public String getClassName() {
        return this.className;
    }

    public String getMessage() {
        return this.message;
    }

    public ExceptionInfo(Throwable th2) {
        this.className = th2.getClass().getName();
        if (th2.getMessage() != null) {
            this.message = th2.getMessage();
        } else {
            this.message = "";
        }
    }
}
