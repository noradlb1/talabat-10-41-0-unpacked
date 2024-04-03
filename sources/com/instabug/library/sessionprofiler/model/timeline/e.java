package com.instabug.library.sessionprofiler.model.timeline;

import androidx.annotation.VisibleForTesting;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import com.visa.checkout.PurchaseInfo;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class e implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private Queue f51873a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    private Queue f51874b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    private Queue f51875c = new ConcurrentLinkedQueue();

    /* renamed from: d  reason: collision with root package name */
    private Queue f51876d = new ConcurrentLinkedQueue();

    /* renamed from: e  reason: collision with root package name */
    private Queue f51877e = new ConcurrentLinkedQueue();

    /* renamed from: f  reason: collision with root package name */
    private final long f51878f = DeviceStateProvider.getTotalStorage();

    public void a(float f11, boolean z11) {
        this.f51873a.add(new a(f11, z11));
    }

    public void b(c cVar) {
        this.f51877e.add(cVar);
    }

    public e c() {
        return a(1.0f);
    }

    public void a(b bVar) {
        this.f51874b.add(bVar);
    }

    public JSONObject b() {
        a((Collection) this.f51873a, 30.0f);
        a((Collection) this.f51874b, 30.0f);
        a((Collection) this.f51875c, 30.0f);
        a((Collection) this.f51876d, 120.0f);
        a((Collection) this.f51877e, 120.0f);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", 1).put("platform", (Object) "Android").put("battery", (Object) a((Collection) this.f51873a)).put("orientation", (Object) a((Collection) this.f51875c)).put("battery", (Object) a((Collection) this.f51873a)).put("connectivity", (Object) a((Collection) this.f51874b)).put("memory", (Object) a((Collection) this.f51876d)).put("storage", (Object) a((Collection) this.f51877e).put(PurchaseInfo.TOTAL, a()));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public void a(c cVar) {
        this.f51876d.add(cVar);
    }

    public long a() {
        return this.f51878f;
    }

    public void a(d dVar) {
        this.f51875c.add(dVar);
    }

    public e a(float f11) {
        try {
            float f12 = 30.0f * f11;
            b(this.f51873a, Math.round(f12));
            b(this.f51874b, Math.round(f12));
            b(this.f51875c, Math.round(f12));
            float f13 = f11 * 120.0f;
            b(this.f51876d, Math.round(f13));
            b(this.f51877e, Math.round(f13));
        } catch (OutOfMemoryError e11) {
            InstabugCore.reportError(e11, "OOM while trimming session profiler timeline");
            InstabugSDKLogger.e("IBG-Core", "OOM while trimming session profiler timeline", e11);
        }
        return this;
    }

    @VisibleForTesting
    public static void a(Collection collection, float f11) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        if (collection instanceof ConcurrentLinkedQueue) {
            concurrentLinkedQueue = (ConcurrentLinkedQueue) collection;
        } else {
            concurrentLinkedQueue = new ConcurrentLinkedQueue(collection);
        }
        Iterator it = concurrentLinkedQueue.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            f fVar = (f) it.next();
            double round = ((double) Math.round(((double) ((long) ((((float) i11) / f11) * 60000.0f))) / 10.0d)) / 100.0d;
            if (fVar != null) {
                fVar.a(round);
            }
            i11++;
        }
    }

    private JSONObject a(Collection collection) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeline", (Object) f.a(collection));
        return jSONObject;
    }

    @VisibleForTesting
    public static Queue b(Queue queue, int i11) {
        while (queue.size() > i11) {
            queue.poll();
        }
        return queue;
    }

    public static e a(JSONObject jSONObject) {
        e eVar = new e();
        try {
            eVar.f51873a = a.d(jSONObject.getJSONObject("battery").getJSONArray("timeline"));
            eVar.f51874b = b.d(jSONObject.getJSONObject("connectivity").getJSONArray("timeline"));
            eVar.f51875c = d.d(jSONObject.getJSONObject("orientation").getJSONArray("timeline"));
            eVar.f51876d = c.d(jSONObject.getJSONObject("memory").getJSONArray("timeline"));
            eVar.f51877e = c.d(jSONObject.getJSONObject("storage").getJSONArray("timeline"));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return eVar;
    }
}
