package com.instabug.library.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class UserAttributes implements Cacheable, Serializable {
    private long ttl;
    @Nullable
    private HashMap<String, String> userAttributesMap;

    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        this.ttl = jSONObject.getLong(RemoteMessageConst.TTL);
        JSONObject jSONObject2 = jSONObject.getJSONObject("user_attributes");
        Iterator<String> keys = jSONObject2.keys();
        this.userAttributesMap = new HashMap<>();
        while (keys.hasNext()) {
            String next = keys.next();
            this.userAttributesMap.put(next, jSONObject2.optString(next));
        }
    }

    @Nullable
    public String get(@NonNull String str) {
        HashMap<String, String> hashMap = this.userAttributesMap;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(str);
    }

    @Nullable
    public HashMap<String, String> getMap() {
        return this.userAttributesMap;
    }

    public long getTtl() {
        return this.ttl;
    }

    @NonNull
    public String keysAsStringJsonArray() {
        JSONArray jSONArray = new JSONArray();
        HashMap<String, String> hashMap = this.userAttributesMap;
        if (hashMap != null) {
            for (String put : hashMap.keySet()) {
                jSONArray.put((Object) put);
            }
        }
        return JSONArrayInstrumentation.toString(jSONArray);
    }

    public UserAttributes put(@NonNull String str, String str2) {
        if (this.userAttributesMap == null) {
            this.userAttributesMap = new HashMap<>();
        }
        this.userAttributesMap.put(str, str2);
        return this;
    }

    public void putMap(@Nullable HashMap<String, String> hashMap) {
        this.userAttributesMap = hashMap;
    }

    public void remove(@NonNull String str) {
        HashMap<String, String> hashMap = this.userAttributesMap;
        if (hashMap != null) {
            hashMap.remove(str);
        }
    }

    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        HashMap<String, String> hashMap = this.userAttributesMap;
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                jSONObject2.put((String) next.getKey(), next.getValue());
            }
        }
        JSONObject put = jSONObject.put(RemoteMessageConst.TTL, this.ttl).put("user_attributes", (Object) jSONObject2);
        if (!(put instanceof JSONObject)) {
            return put.toString();
        }
        return JSONObjectInstrumentation.toString(put);
    }

    @NonNull
    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            HashMap<String, String> hashMap = this.userAttributesMap;
            if (hashMap != null) {
                for (Map.Entry next : hashMap.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            }
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-Core", "Error while parsing user attributes", e11);
            return "{}";
        }
    }
}
