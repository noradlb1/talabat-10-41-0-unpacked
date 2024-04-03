package com.instabug.library.sessionprofiler.model.timeline;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends f {

    /* renamed from: b  reason: collision with root package name */
    private float f51866b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f51867c;

    public a(float f11, boolean z11) {
        this.f51866b = f11;
        this.f51867c = z11;
    }

    private static a a(JSONObject jSONObject) throws JSONException {
        a aVar = new a((float) jSONObject.getDouble("v"), jSONObject.getBoolean("plugged"));
        aVar.a(jSONObject.getDouble("t"));
        return aVar;
    }

    public static Queue d(JSONArray jSONArray) throws JSONException {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            concurrentLinkedQueue.add(a(jSONArray.getJSONObject(i11)));
        }
        return concurrentLinkedQueue;
    }

    public JSONObject b() throws JSONException {
        JSONObject c11 = c(Float.valueOf(this.f51866b));
        c11.put("plugged", this.f51867c);
        return c11;
    }
}
