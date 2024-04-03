package com.apptimize;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class dn {

    /* renamed from: a  reason: collision with root package name */
    private Map<Long, Long> f41851a;

    /* renamed from: b  reason: collision with root package name */
    private Map<Long, Long> f41852b;

    public dn() {
        this.f41851a = Collections.EMPTY_MAP;
        this.f41852b = new HashMap();
    }

    public static dn a(JSONObject jSONObject) throws JSONException {
        return new dn(a("enrollmentDates", jSONObject), a("variantFirstRunDates", jSONObject));
    }

    public synchronized Map<Long, Long> b() {
        return this.f41851a;
    }

    public synchronized Map<Long, Long> c() {
        return Collections.unmodifiableMap(this.f41852b);
    }

    private dn(Map<Long, Long> map, Map<Long, Long> map2) {
        this.f41851a = Collections.unmodifiableMap(new HashMap(map));
        this.f41852b = new HashMap(map2);
    }

    private static Map<Long, Long> a(String str, JSONObject jSONObject) throws JSONException {
        Map<String, Long> a11 = fh.a(str, jSONObject, Long.class);
        HashMap hashMap = new HashMap();
        for (Map.Entry next : a11.entrySet()) {
            String str2 = (String) next.getKey();
            try {
                hashMap.put(Long.valueOf(Long.parseLong(str2)), next.getValue());
            } catch (NumberFormatException unused) {
                throw new JSONException("Could not parse variant ID to Long: " + str2);
            }
        }
        return hashMap;
    }

    public synchronized JSONObject a() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("enrollmentDates", (Object) a(this.f41851a));
        jSONObject.put("variantFirstRunDates", (Object) a(this.f41852b));
        return jSONObject;
    }

    private synchronized JSONObject a(Map<Long, Long> map) {
        HashMap hashMap;
        hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            hashMap.put(String.valueOf(next.getKey()), next.getValue());
        }
        return new JSONObject((Map<?, ?>) hashMap);
    }

    public synchronized boolean a(Set<Long> set, long j11) {
        boolean z11;
        boolean z12;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (set != null) {
            for (Long next : set) {
                if (this.f41851a.containsKey(next)) {
                    hashMap.put(next, this.f41851a.get(next));
                } else {
                    hashMap.put(next, Long.valueOf(j11));
                }
                if (this.f41852b.containsKey(next)) {
                    hashMap2.put(next, this.f41852b.get(next));
                }
            }
        }
        z11 = true;
        if (!this.f41851a.equals(hashMap)) {
            this.f41851a = Collections.unmodifiableMap(hashMap);
            z12 = true;
        } else {
            z12 = false;
        }
        if (!this.f41852b.equals(hashMap2)) {
            this.f41852b = hashMap2;
        } else {
            z11 = z12;
        }
        return z11;
    }

    public synchronized boolean a(long j11, long j12, long j13) {
        if (this.f41852b.containsKey(Long.valueOf(j11))) {
            return false;
        }
        this.f41852b.put(Long.valueOf(j11), Long.valueOf(j13));
        return true;
    }

    public synchronized boolean a(long j11) {
        return this.f41852b.containsKey(Long.valueOf(j11));
    }
}
