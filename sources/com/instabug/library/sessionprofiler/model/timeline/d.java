package com.instabug.library.sessionprofiler.model.timeline;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends f {

    /* renamed from: b  reason: collision with root package name */
    private String f51872b;

    public d(String str) {
        this.f51872b = str;
    }

    private static d a(JSONObject jSONObject) throws JSONException {
        d dVar = new d(jSONObject.getString("v"));
        dVar.a(jSONObject.getDouble("t"));
        return dVar;
    }

    public static Queue d(JSONArray jSONArray) throws JSONException {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            concurrentLinkedQueue.add(a(jSONArray.getJSONObject(i11)));
        }
        return concurrentLinkedQueue;
    }

    public JSONObject b() throws JSONException {
        return c(this.f51872b);
    }
}
