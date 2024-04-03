package com.instabug.library.sessionprofiler.model.timeline;

import com.visa.checkout.PurchaseInfo;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends f {

    /* renamed from: b  reason: collision with root package name */
    private long f51870b;

    /* renamed from: c  reason: collision with root package name */
    private long f51871c;

    public c(long j11) {
        this.f51870b = j11;
    }

    public static Queue d(JSONArray jSONArray) throws JSONException {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            concurrentLinkedQueue.add(a(jSONArray.getJSONObject(i11)));
        }
        return concurrentLinkedQueue;
    }

    public void a(long j11) {
        this.f51871c = j11;
    }

    public JSONObject b() throws JSONException {
        JSONObject c11 = c(Long.valueOf(this.f51870b));
        long j11 = this.f51871c;
        if (j11 > 0) {
            c11.put(PurchaseInfo.TOTAL, j11);
        }
        return c11;
    }

    private static c a(JSONObject jSONObject) throws JSONException {
        c cVar = new c(jSONObject.getLong("v"));
        if (jSONObject.has(PurchaseInfo.TOTAL)) {
            cVar.a(jSONObject.getLong(PurchaseInfo.TOTAL));
        }
        cVar.a(jSONObject.getDouble("t"));
        return cVar;
    }

    public c(long j11, long j12) {
        this.f51870b = j11;
        this.f51871c = j12;
    }
}
