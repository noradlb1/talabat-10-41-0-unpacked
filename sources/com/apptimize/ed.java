package com.apptimize;

import com.apptimize.Apptimize;
import com.apptimize.bt;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ed {

    /* renamed from: a  reason: collision with root package name */
    public static final String f42236a = "ed";

    /* renamed from: b  reason: collision with root package name */
    private final cc f42237b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, bt.f> f42238c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, bt.f> f42239d;

    /* renamed from: e  reason: collision with root package name */
    private final List<dc> f42240e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Long> f42241f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<Long> f42242g;

    /* renamed from: h  reason: collision with root package name */
    private final Set<String> f42243h;

    /* renamed from: i  reason: collision with root package name */
    private final String f42244i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f42245j;

    /* renamed from: k  reason: collision with root package name */
    private final int f42246k;

    /* renamed from: l  reason: collision with root package name */
    private final Map<String, Long> f42247l;

    public interface a {
        void a(cm cmVar);

        void a(cm cmVar, Apptimize.UnenrollmentReason unenrollmentReason);
    }

    public ed(cc ccVar, Map<String, bt.f> map, Map<String, bt.f> map2, Map<String, Long> map3, Set<Long> set, Set<Long> set2, Set<String> set3, List<dc> list, String str, boolean z11, int i11) {
        this.f42237b = ccVar;
        this.f42238c = Collections.unmodifiableMap(new HashMap(map));
        this.f42239d = Collections.unmodifiableMap(new HashMap(map2));
        this.f42247l = Collections.unmodifiableMap(new HashMap(map3));
        this.f42241f = Collections.unmodifiableSet(new HashSet(set));
        this.f42242g = new HashSet(set2);
        this.f42243h = Collections.unmodifiableSet(new HashSet(set3));
        List<dc> unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.f42240e = unmodifiableList;
        this.f42244i = str;
        this.f42245j = z11;
        br.a("new ProcessedMetaData", unmodifiableList);
        if (ccVar == null || map == null || map2 == null || map3 == null || set == null || set3 == null) {
            throw null;
        }
        this.f42246k = i11;
    }

    private synchronized JSONObject n() throws JSONException {
        if (this.f42238c == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : this.f42238c.entrySet()) {
            jSONObject.put((String) next.getKey(), (Object) ((bt.f) next.getValue()).d());
        }
        return jSONObject;
    }

    private synchronized JSONObject o() throws JSONException {
        if (this.f42239d == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : this.f42239d.entrySet()) {
            jSONObject.put((String) next.getKey(), (Object) ((bt.f) next.getValue()).d());
        }
        return jSONObject;
    }

    private synchronized JSONArray p() throws JSONException {
        if (this.f42240e == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (dc a11 : this.f42240e) {
            jSONArray.put((Object) a11.a());
        }
        return jSONArray;
    }

    private synchronized JSONArray q() throws JSONException {
        if (this.f42241f == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Long put : this.f42241f) {
            jSONArray.put((Object) put);
        }
        return jSONArray;
    }

    private synchronized JSONArray r() throws JSONException {
        if (this.f42242g == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Long put : this.f42242g) {
            jSONArray.put((Object) put);
        }
        return jSONArray;
    }

    private synchronized JSONArray s() throws JSONException {
        if (this.f42243h == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : this.f42243h) {
            jSONArray.put((Object) put);
        }
        return jSONArray;
    }

    private synchronized JSONObject t() throws JSONException {
        if (this.f42247l == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : this.f42247l.entrySet()) {
            jSONObject.put((String) next.getKey(), next.getValue());
        }
        return jSONObject;
    }

    public ed a(cc ccVar) {
        int i11 = this.f42246k;
        if (!(ccVar == null || ccVar.f() == null)) {
            i11 = ccVar.f().f();
        }
        return new ed(ccVar, this.f42238c, this.f42239d, this.f42247l, this.f42241f, this.f42242g, this.f42243h, this.f42240e, this.f42244i, this.f42245j, i11);
    }

    public int b() {
        return this.f42246k;
    }

    public cc c() {
        return this.f42237b;
    }

    public Map<String, bt.f> d() {
        return this.f42238c;
    }

    public Map<String, bt.f> e() {
        return this.f42239d;
    }

    public Set<String> f() {
        return this.f42243h;
    }

    public Map<String, Long> g() {
        return this.f42247l;
    }

    public String h() {
        return this.f42244i;
    }

    public Set<Long> i() {
        return this.f42241f;
    }

    public Set<Long> j() {
        return this.f42242g;
    }

    public cb k() {
        cc c11 = c();
        if (c11 == null) {
            return null;
        }
        by f11 = c11.f();
        if (!(f11 instanceof cb)) {
            return null;
        }
        return (cb) f11;
    }

    public Set<String> l() {
        HashSet hashSet = new HashSet();
        cb k11 = k();
        if (k11 == null) {
            return hashSet;
        }
        Collection<bt.f> values = e().values();
        for (bx next : k11.i()) {
            if (next.f() != null) {
                Iterator<? extends bt> it = next.f().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (values.contains((bt) it.next())) {
                            hashSet.add(next.j());
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return hashSet;
    }

    public boolean m() {
        return this.f42245j;
    }

    private static cc b(JSONObject jSONObject, au auVar) throws JSONException, ca {
        return cc.a(jSONObject, auVar);
    }

    private static Map<String, bt.f> c(JSONObject jSONObject, au auVar) throws JSONException {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (bt.f) bt.a(jSONObject.getJSONObject(next), auVar));
            }
        }
        return hashMap;
    }

    private static Set<String> b(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                hashSet.add(jSONArray.getString(i11));
            }
        }
        return hashSet;
    }

    public ed a(by byVar) {
        cc ccVar = this.f42237b;
        if (ccVar != null) {
            ccVar = ccVar.a(byVar);
        }
        return new ed(ccVar, this.f42238c, this.f42239d, this.f42247l, this.f42241f, this.f42242g, this.f42243h, this.f42240e, this.f42244i, this.f42245j, this.f42246k);
    }

    public List<dc> a() {
        br.a("getWysiwygStyles");
        return this.f42240e;
    }

    public static void a(ed edVar, ed edVar2, a aVar) {
        if (aVar != null) {
            HashSet hashSet = new HashSet();
            if (edVar != null) {
                hashSet.addAll(edVar.i());
            }
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            if (edVar2 != null) {
                hashSet2.addAll(edVar2.i());
                cb k11 = edVar2.k();
                if (k11 != null) {
                    for (cm g11 : k11.k()) {
                        hashSet4.add(g11.g());
                    }
                }
            }
            List<cm> a11 = edVar != null ? edVar.a((Set<Long>) hashSet) : new ArrayList<>();
            Set l11 = edVar2 != null ? edVar2.l() : new HashSet();
            List<cm> a12 = edVar2 != null ? edVar2.a((Set<Long>) hashSet2) : new ArrayList<>();
            new HashSet(hashSet).removeAll(hashSet2);
            for (cm g12 : a12) {
                hashSet3.add(g12.g());
            }
            HashSet hashSet5 = new HashSet();
            HashSet hashSet6 = new HashSet();
            for (cm cmVar : a11) {
                hashSet6.add(cmVar.g());
                if (l11.contains(cmVar.f())) {
                    aVar.a(cmVar, Apptimize.UnenrollmentReason.EXPERIMENT_WINNER_SELECTED);
                } else if (!hashSet4.contains(cmVar.g())) {
                    aVar.a(cmVar, Apptimize.UnenrollmentReason.EXPERIMENT_STOPPED);
                } else if (!hashSet3.contains(cmVar.g())) {
                    aVar.a(cmVar, Apptimize.UnenrollmentReason.OTHER);
                } else if (!hashSet2.contains(Long.valueOf(cmVar.j()))) {
                    aVar.a(cmVar, Apptimize.UnenrollmentReason.VARIANT_CHANGED);
                    hashSet5.add(cmVar.g());
                }
            }
            HashSet hashSet7 = new HashSet();
            for (cm g13 : a11) {
                hashSet7.add(g13.g());
            }
            for (cm cmVar2 : a12) {
                if (!hashSet7.contains(cmVar2.g()) || hashSet5.contains(cmVar2.g())) {
                    aVar.a(cmVar2);
                }
            }
        }
    }

    public List<cm> a(Set<Long> set) {
        cb k11;
        ArrayList arrayList = new ArrayList();
        if (set == null || (k11 = k()) == null) {
            return arrayList;
        }
        for (Long longValue : set) {
            cm a11 = k11.a(longValue.longValue());
            if (a11 != null) {
                arrayList.add(a11);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(com.apptimize.ed r2, boolean r3) {
        /*
            java.lang.Class<com.apptimize.ed> r0 = com.apptimize.ed.class
            monitor-enter(r0)
            r1 = 0
            if (r2 != 0) goto L_0x0008
            monitor-exit(r0)
            return r1
        L_0x0008:
            org.json.JSONObject r2 = r2.a((boolean) r3)     // Catch:{ JSONException -> 0x001e, all -> 0x001b }
            boolean r3 = r2 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x001e, all -> 0x001b }
            if (r3 != 0) goto L_0x0015
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x001e, all -> 0x001b }
            goto L_0x0019
        L_0x0015:
            java.lang.String r2 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r2)     // Catch:{ JSONException -> 0x001e, all -> 0x001b }
        L_0x0019:
            monitor-exit(r0)
            return r2
        L_0x001b:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L_0x001e:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.ed.a(com.apptimize.ed, boolean):java.lang.String");
    }

    public static synchronized ed a(String str, au auVar) {
        ed a11;
        synchronized (ed.class) {
            try {
                a11 = a(new JSONObject(str), auVar);
            } catch (ca | JSONException e11) {
                String str2 = f42236a;
                bo.k(str2, "Failed to parse from json " + e11.getMessage());
                bo.k(str2, "input: " + str);
                return null;
            }
        }
        return a11;
    }

    public synchronized JSONObject a(boolean z11) throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("metaMetaData", (Object) this.f42237b.a(z11));
        jSONObject.put("activeAbAlterations", (Object) n());
        jSONObject.put("hotfixes", (Object) o());
        jSONObject.put("wysiwygStyles", (Object) p());
        jSONObject.put("activeVariants", (Object) q());
        jSONObject.put("variantsForced", (Object) r());
        jSONObject.put("applicableExperimentNames", (Object) s());
        jSONObject.put("userId", (Object) this.f42244i);
        jSONObject.put("isWysiwyg", this.f42245j);
        jSONObject.put("alterationKeyToVariant", (Object) t());
        jSONObject.put("sequenceNumber", this.f42246k);
        return jSONObject;
    }

    public static ed a(JSONObject jSONObject, au auVar) throws JSONException, ca {
        if (jSONObject == null) {
            bo.k(f42236a, "no json object is provided");
            return null;
        }
        cc b11 = b(jSONObject.optJSONObject("metaMetaData"), auVar);
        Map<String, bt.f> c11 = c(jSONObject.optJSONObject("activeAbAlterations"), auVar);
        Map<String, bt.f> c12 = c(jSONObject.optJSONObject("hotfixes"), auVar);
        List<dc> a11 = a(jSONObject.optJSONArray("wysiwygStyles"), auVar);
        return new ed(b11, c11, c12, a(jSONObject.optJSONObject("alterationKeyToVariant")), a(jSONObject.optJSONArray("activeVariants")), a(jSONObject.optJSONArray("variantsForced")), b(jSONObject.optJSONArray("applicableExperimentNames")), a11, jSONObject.optString("userId", (String) null), jSONObject.optBoolean("isWysiwyg", false), jSONObject.optInt("sequenceNumber"));
    }

    private static List<dc> a(JSONArray jSONArray, au auVar) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(dc.a(jSONArray.getJSONObject(i11)));
            }
        }
        return arrayList;
    }

    private static Set<Long> a(JSONArray jSONArray) throws JSONException {
        HashSet hashSet = new HashSet();
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                hashSet.add(Long.valueOf(jSONArray.getLong(i11)));
            }
        }
        return hashSet;
    }

    private static Map<String, Long> a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, Long.valueOf(jSONObject.optLong(next)));
            }
        }
        return hashMap;
    }
}
