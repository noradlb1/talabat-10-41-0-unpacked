package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestableArray;
import com.newrelic.com.google.gson.JsonArray;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonPrimitive;

public class DataToken extends HarvestableArray {
    private int accountId;
    private int agentId;

    public DataToken() {
        clear();
    }

    public int[] asIntArray() {
        return new int[]{this.accountId, this.agentId};
    }

    public JsonArray asJsonArray() {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add((JsonElement) new JsonPrimitive((Number) Integer.valueOf(this.accountId)));
        jsonArray.add((JsonElement) new JsonPrimitive((Number) Integer.valueOf(this.agentId)));
        return jsonArray;
    }

    public void clear() {
        this.accountId = 0;
        this.agentId = 0;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public int getAgentId() {
        return this.agentId;
    }

    public boolean isValid() {
        return this.accountId > 0 && this.agentId > 0;
    }

    public void setAccountId(int i11) {
        this.accountId = i11;
    }

    public void setAgentId(int i11) {
        this.agentId = i11;
    }

    public String toString() {
        int i11 = this.accountId;
        int i12 = this.agentId;
        return "DataToken{accountId=" + i11 + ", agentId=" + i12 + "}";
    }

    public DataToken(int i11, int i12) {
        this.accountId = i11;
        this.agentId = i12;
    }
}
