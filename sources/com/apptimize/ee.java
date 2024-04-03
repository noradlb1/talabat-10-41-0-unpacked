package com.apptimize;

import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ee {

    /* renamed from: a  reason: collision with root package name */
    private static final String f42248a = "ee";

    /* renamed from: b  reason: collision with root package name */
    private final Map<Long, el> f42249b;

    /* renamed from: c  reason: collision with root package name */
    private final List<el> f42250c;

    /* renamed from: d  reason: collision with root package name */
    private final long f42251d;

    public ee() {
        this.f42249b = Collections.unmodifiableMap(new HashMap());
        this.f42250c = Collections.unmodifiableList(new ArrayList());
        this.f42251d = 1;
    }

    private static Map<Long, el> b(JSONObject jSONObject, au auVar) throws JSONException {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject2 = jSONObject.getJSONObject("activeAbVariantData");
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Long valueOf = Long.valueOf(Long.parseLong(next));
                el a11 = el.a(jSONObject2.getJSONObject(next), auVar);
                if (valueOf.equals(Long.valueOf(a11.f42303a.j()))) {
                    hashMap.put(Long.valueOf(Long.parseLong(next)), a11);
                } else {
                    throw new JSONException("variant ID did not match the map key");
                }
            } catch (NumberFormatException unused) {
                throw new JSONException("Could not parse variant ID to Long: " + next);
            }
        }
        return hashMap;
    }

    private static List<el> c(JSONObject jSONObject, au auVar) throws JSONException {
        el elVar;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("metricsNotYetPosted");
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            try {
                elVar = el.a(jSONArray.getJSONObject(i11), auVar);
            } catch (JSONException unused) {
                bo.a(f42248a, "Converting metricsNotYetPosted from VariationData to VariantData.");
                elVar = null;
            }
            if (elVar == null) {
                elVar = bm.a(bl.a(jSONArray.getJSONObject(i11)));
            }
            if (elVar != null) {
                arrayList.add(elVar);
            }
        }
        return arrayList;
    }

    private synchronized JSONObject e() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry next : this.f42249b.entrySet()) {
            jSONObject.put(String.valueOf(next.getKey()), (Object) ((el) next.getValue()).a());
        }
        return jSONObject;
    }

    private synchronized JSONArray f() throws JSONException {
        JSONArray jSONArray;
        jSONArray = new JSONArray();
        for (el a11 : this.f42250c) {
            jSONArray.put((Object) a11.a());
        }
        return jSONArray;
    }

    public Map<Long, el> a() {
        return this.f42249b;
    }

    public long d() {
        return this.f42251d;
    }

    public static ee a(JSONObject jSONObject, au auVar) throws JSONException {
        return new ee(b(jSONObject, auVar), c(jSONObject, auVar), jSONObject.getLong("sequenceNumber"));
    }

    public ee(Map<Long, el> map, List<el> list, long j11) {
        this.f42249b = Collections.unmodifiableMap(new HashMap(map));
        this.f42250c = Collections.unmodifiableList(new ArrayList(list));
        this.f42251d = j11;
        if (map == null || list == null) {
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(com.apptimize.ee r3) {
        /*
            java.lang.Class<com.apptimize.ee> r0 = com.apptimize.ee.class
            monitor-enter(r0)
            r1 = 0
            if (r3 != 0) goto L_0x0008
            monitor-exit(r0)
            return r1
        L_0x0008:
            org.json.JSONObject r3 = r3.b()     // Catch:{ JSONException -> 0x001e, all -> 0x001b }
            boolean r2 = r3 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x001e, all -> 0x001b }
            if (r2 != 0) goto L_0x0015
            java.lang.String r3 = r3.toString()     // Catch:{ JSONException -> 0x001e, all -> 0x001b }
            goto L_0x0019
        L_0x0015:
            java.lang.String r3 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r3)     // Catch:{ JSONException -> 0x001e, all -> 0x001b }
        L_0x0019:
            monitor-exit(r0)
            return r3
        L_0x001b:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x001e:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ee.a(com.apptimize.ee):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.apptimize.ee a(java.lang.String r2, com.apptimize.au r3) {
        /*
            java.lang.Class<com.apptimize.ee> r0 = com.apptimize.ee.class
            monitor-enter(r0)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0011, all -> 0x000e }
            r1.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x0011, all -> 0x000e }
            com.apptimize.ee r2 = a((org.json.JSONObject) r1, (com.apptimize.au) r3)     // Catch:{ JSONException -> 0x0011, all -> 0x000e }
            monitor-exit(r0)
            return r2
        L_0x000e:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x0011:
            monitor-exit(r0)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ee.a(java.lang.String, com.apptimize.au):com.apptimize.ee");
    }

    public List<el> c() {
        return this.f42250c;
    }

    public synchronized JSONObject b() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("activeAbVariantData", (Object) e());
        jSONObject.put("metricsNotYetPosted", (Object) f());
        jSONObject.put("sequenceNumber", this.f42251d);
        return jSONObject;
    }
}
