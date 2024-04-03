package com.apptimize;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class dw {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42197a = "dw";

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Double> f42198b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private long f42199c = 0;

    private dw() {
    }

    public static dw a() {
        return new dw();
    }

    public synchronized JSONObject b() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("metrics", (Object) new JSONObject((Map<?, ?>) this.f42198b));
        jSONObject.put("experimentRunCount", this.f42199c);
        return jSONObject;
    }

    public synchronized void c() {
        this.f42199c++;
    }

    public synchronized void d() {
        this.f42199c = 1;
    }

    public static dw a(JSONObject jSONObject) throws JSONException {
        dw dwVar = new dw();
        dwVar.f42199c = jSONObject.getLong("experimentRunCount");
        JSONObject jSONObject2 = jSONObject.getJSONObject("metrics");
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            dwVar.f42198b.put(next, Double.valueOf(jSONObject2.getDouble(next)));
        }
        return dwVar;
    }

    public synchronized void b(String str, double d11) {
        if (this.f42199c == 0) {
            bo.f(f42197a, "Test run count is 0; not incrementing metric.");
            return;
        }
        bo.i(f42197a, "Incrementing metric.");
        this.f42198b.put(str, Double.valueOf(d11));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.lang.String r5, double r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.f42199c     // Catch:{ all -> 0x003d }
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0012
            java.lang.String r5 = f42197a     // Catch:{ all -> 0x003d }
            java.lang.String r6 = "Test run count is 0; not incrementing metric."
            com.apptimize.bo.f(r5, r6)     // Catch:{ all -> 0x003d }
            monitor-exit(r4)
            return
        L_0x0012:
            java.lang.String r0 = f42197a     // Catch:{ all -> 0x003d }
            java.lang.String r1 = "Incrementing metric."
            com.apptimize.bo.i(r0, r1)     // Catch:{ all -> 0x003d }
            java.util.HashMap<java.lang.String, java.lang.Double> r0 = r4.f42198b     // Catch:{ all -> 0x003d }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x003d }
            java.lang.Double r0 = (java.lang.Double) r0     // Catch:{ all -> 0x003d }
            if (r0 != 0) goto L_0x002d
            java.util.HashMap<java.lang.String, java.lang.Double> r0 = r4.f42198b     // Catch:{ all -> 0x003d }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x003d }
            r0.put(r5, r6)     // Catch:{ all -> 0x003d }
            goto L_0x003b
        L_0x002d:
            java.util.HashMap<java.lang.String, java.lang.Double> r1 = r4.f42198b     // Catch:{ all -> 0x003d }
            double r2 = r0.doubleValue()     // Catch:{ all -> 0x003d }
            double r6 = r6 + r2
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ all -> 0x003d }
            r1.put(r5, r6)     // Catch:{ all -> 0x003d }
        L_0x003b:
            monitor-exit(r4)
            return
        L_0x003d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.dw.a(java.lang.String, double):void");
    }
}
