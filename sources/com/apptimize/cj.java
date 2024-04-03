package com.apptimize;

import com.adjust.sdk.Constants;
import com.apptimize.dp;
import com.apptimize.j;
import com.facebook.AuthenticationTokenClaims;
import com.newrelic.agent.android.payload.PayloadController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cj implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static final Integer f41652a = 100;

    /* renamed from: b  reason: collision with root package name */
    private static final String f41653b = "cj";

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, dp.k[]> f41654c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Long f41655d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Long f41656e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Long f41657f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Long f41658g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final List<String> f41659h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final List<String> f41660i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final List<String> f41661j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final List<String> f41662k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final Map<String, String> f41663l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final List<String> f41664m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final List<String> f41665n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final Integer f41666o;

    /* renamed from: p  reason: collision with root package name */
    private final String f41667p;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Long f41668a;

        /* renamed from: b  reason: collision with root package name */
        private Long f41669b;

        /* renamed from: c  reason: collision with root package name */
        private Long f41670c;

        /* renamed from: d  reason: collision with root package name */
        private Long f41671d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f41672e;

        /* renamed from: f  reason: collision with root package name */
        private List<String> f41673f;

        /* renamed from: g  reason: collision with root package name */
        private List<String> f41674g;

        /* renamed from: h  reason: collision with root package name */
        private List<String> f41675h;

        /* renamed from: i  reason: collision with root package name */
        private List<String> f41676i;

        /* renamed from: j  reason: collision with root package name */
        private Map<String, String> f41677j;

        /* renamed from: k  reason: collision with root package name */
        private List<String> f41678k;

        /* renamed from: l  reason: collision with root package name */
        private List<String> f41679l;

        public a(cj cjVar) {
            this.f41668a = cjVar.f41655d;
            this.f41669b = cjVar.f41656e;
            this.f41670c = cjVar.f41657f;
            this.f41671d = cjVar.f41658g;
            this.f41672e = cjVar.f41666o;
            this.f41673f = cjVar.f41659h;
            this.f41674g = cjVar.f41660i;
            this.f41675h = cjVar.f41661j;
            this.f41676i = cjVar.f41662k;
            this.f41677j = cjVar.f41663l;
            this.f41678k = cjVar.f41664m;
            this.f41679l = cjVar.f41665n;
        }

        public static a a() {
            return new a(cj.a());
        }

        public cj b() {
            return new cj(this.f41668a, this.f41669b, this.f41670c, this.f41671d, this.f41672e, this.f41673f, this.f41674g, this.f41675h, this.f41676i, this.f41677j, this.f41678k, this.f41679l);
        }

        public a a(cj cjVar) {
            if (cjVar == null) {
                return this;
            }
            if (cjVar.f41655d != null) {
                this.f41668a = cjVar.f41655d;
            }
            if (cjVar.f41656e != null) {
                this.f41669b = cjVar.f41656e;
            }
            if (cjVar.f41657f != null) {
                this.f41670c = cjVar.f41657f;
            }
            if (cjVar.f41658g != null) {
                this.f41671d = cjVar.f41658g;
            }
            if (cjVar.f41666o != null) {
                this.f41672e = cjVar.f41666o;
            }
            if (cjVar.f41659h != null) {
                this.f41673f = cjVar.f41659h;
            }
            if (cjVar.f41660i != null) {
                this.f41674g = cjVar.f41660i;
            }
            if (cjVar.f41661j != null) {
                this.f41675h = cjVar.f41661j;
            }
            if (cjVar.f41662k != null) {
                this.f41676i = cjVar.f41662k;
            }
            if (cjVar.f41663l != null) {
                this.f41677j = cjVar.f41663l;
            }
            if (cjVar.f41664m != null) {
                this.f41678k = cjVar.f41664m;
            }
            if (cjVar.f41665n != null) {
                this.f41679l = cjVar.f41665n;
            }
            return this;
        }

        public a a(String str) {
            if (str != null) {
                HashMap hashMap = new HashMap(this.f41677j);
                hashMap.put("groupsApiUrl", str);
                this.f41677j = hashMap;
            }
            return this;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f41654c = hashMap;
        hashMap.put("amplitude", new dp.k[]{dp.k.Amplitude});
        hashMap.put("firebase", new dp.k[]{dp.k.Firebase});
        hashMap.put("flurry", new dp.k[]{dp.k.Flurry});
        hashMap.put(Constants.REFERRER_API_GOOGLE, new dp.k[]{dp.k.GoogleAnalyticsV3, dp.k.GoogleAnalyticsV4});
        hashMap.put("localytics", new dp.k[]{dp.k.Localytics});
        hashMap.put("mixpanel", new dp.k[]{dp.k.Mixpanel});
        hashMap.put("omniture", new dp.k[]{dp.k.OmnitureV2, dp.k.OmnitureV3, dp.k.OmnitureV4});
    }

    public cj(Long l11, Long l12, Long l13, Long l14, Integer num, List<String> list, List<String> list2, List<String> list3, List<String> list4, Map<String, String> map, List<String> list5, List<String> list6) {
        this.f41655d = l11;
        this.f41656e = l12;
        this.f41657f = l13;
        this.f41658g = l14;
        this.f41666o = num;
        this.f41659h = a(list);
        this.f41660i = a(list2);
        this.f41661j = a(list3);
        this.f41662k = a(list4);
        this.f41663l = a(map);
        this.f41667p = fd.a(list, list2, list3, list4);
        this.f41664m = a(list5);
        this.f41665n = a(list6);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cj)) {
            return false;
        }
        cj cjVar = (cj) obj;
        if (!fx.a((Object) this.f41655d, (Object) cjVar.d()) || !fx.a((Object) this.f41656e, (Object) cjVar.e()) || !fx.a((Object) this.f41657f, (Object) cjVar.f()) || !fx.a((Object) this.f41658g, (Object) cjVar.g()) || !ey.a((Object) this.f41659h, (Object) cjVar.i()) || !ey.a((Object) this.f41661j, (Object) cjVar.k()) || !ey.a((Object) this.f41662k, (Object) cjVar.l()) || !ey.a((Object) this.f41663l, (Object) cjVar.m())) {
            return false;
        }
        return true;
    }

    public Map<String, String> m() {
        return this.f41663l;
    }

    public List<String> n() {
        return this.f41665n;
    }

    public String o() {
        return this.f41667p;
    }

    public boolean p() {
        return o().equals(a().o());
    }

    public Set<dp.k> q() {
        HashSet hashSet = new HashSet();
        hashSet.add(dp.k.Apptimize);
        List<String> list = this.f41664m;
        if (list == null) {
            for (dp.k[] asList : f41654c.values()) {
                hashSet.addAll(Arrays.asList(asList));
            }
        } else {
            for (String next : list) {
                dp.k[] kVarArr = f41654c.get(next);
                if (kVarArr == null) {
                    String str = f41653b;
                    bo.e(str, "Unsupported integration key: " + next);
                } else {
                    hashSet.addAll(Arrays.asList(kVarArr));
                }
            }
        }
        return hashSet;
    }

    public String toString() {
        return "SdkParameters{foregroundPeriodMs=" + this.f41655d + ", backgroundPeriodMs=" + this.f41656e + ", minPostPeriodMs=" + this.f41657f + ", maxPostPeriodMs=" + this.f41658g + ", deleteChunkSize=" + this.f41666o + ", lowLatencyUrls=" + this.f41659h + ", lowLatencyBackgroundUrls=" + this.f41660i + ", highLatencyUrls=" + this.f41661j + ", developerBuildUrls=" + this.f41662k + ", callServerUrls=" + this.f41663l + ", integrationsEnabled=" + this.f41664m + ", exportsEnabled=" + this.f41665n + ", urlsHash='" + this.f41667p + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    private static List<String> a(List<String> list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static cj b() {
        j.c cVar = j.c.LOW_LATENCY_METADATA;
        j.a aVar = j.a.PROD;
        return new cj((Long) null, (Long) null, (Long) null, (Long) null, (Integer) null, Collections.unmodifiableList(Collections.singletonList(j.a(cVar, aVar))), Collections.unmodifiableList(Collections.singletonList(j.a(j.c.LOW_LATENCY_BACKGROUND_METADATA, aVar))), Collections.unmodifiableList(Collections.singletonList(j.a(j.c.HIGH_LATENCY_METADATA, aVar))), Collections.unmodifiableList(Collections.singletonList(j.a(j.c.DEVELOPER_METADATA, aVar))), Collections.unmodifiableMap(Collections.singletonMap("groupsApiUrl", j.a(j.c.PILOT_GROUPS, aVar))), (List<String>) null, (List<String>) null);
    }

    public JSONObject c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Long l11 = this.f41655d;
        if (l11 != null) {
            jSONObject.put("foregroundPeriodMs", (Object) l11);
        }
        Long l12 = this.f41656e;
        if (l12 != null) {
            jSONObject.put("backgroundPeriodMs", (Object) l12);
        }
        Long l13 = this.f41657f;
        if (l13 != null) {
            jSONObject.put("minPostFrequencyMs", (Object) l13);
        }
        Long l14 = this.f41658g;
        if (l14 != null) {
            jSONObject.put("maxPostFrequencyMs", (Object) l14);
        }
        if (this.f41659h != null) {
            JSONArray jSONArray = new JSONArray();
            for (String put : this.f41659h) {
                jSONArray.put((Object) put);
            }
            jSONObject.put("androidLowLatencyUrls", (Object) jSONArray);
        }
        if (this.f41660i != null) {
            JSONArray jSONArray2 = new JSONArray();
            for (String put2 : this.f41660i) {
                jSONArray2.put((Object) put2);
            }
            jSONObject.put("androidLowLatencyBackgroundUrls", (Object) jSONArray2);
        }
        if (this.f41661j != null) {
            JSONArray jSONArray3 = new JSONArray();
            for (String put3 : this.f41661j) {
                jSONArray3.put((Object) put3);
            }
            jSONObject.put("androidHighLatencyUrls", (Object) jSONArray3);
        }
        if (this.f41662k != null) {
            JSONArray jSONArray4 = new JSONArray();
            for (String put4 : this.f41662k) {
                jSONArray4.put((Object) put4);
            }
            jSONObject.put("androidDeveloperBuildUrls", (Object) jSONArray4);
        }
        if (this.f41663l != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry next : this.f41663l.entrySet()) {
                jSONObject2.put((String) next.getKey(), next.getValue());
            }
            jSONObject.put("callServerUrls", (Object) jSONObject2);
        }
        List<String> list = this.f41664m;
        if (list != null) {
            jSONObject.put("integrationsEnabled", (Object) new JSONArray((Collection<?>) list));
        }
        List<String> list2 = this.f41665n;
        if (list2 != null) {
            jSONObject.put("exportsEnabled", (Object) new JSONArray((Collection<?>) list2));
        }
        return jSONObject;
    }

    public Long d() {
        return this.f41655d;
    }

    public Long e() {
        return this.f41656e;
    }

    public Long f() {
        return this.f41657f;
    }

    public Long g() {
        return this.f41658g;
    }

    public Integer h() {
        Integer num = this.f41666o;
        if (num != null) {
            return num;
        }
        return f41652a;
    }

    public List<String> i() {
        return this.f41659h;
    }

    public List<String> j() {
        return this.f41660i;
    }

    public List<String> k() {
        return this.f41661j;
    }

    public List<String> l() {
        return this.f41662k;
    }

    private static Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static cj a() {
        Long valueOf = Long.valueOf(AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED);
        Long valueOf2 = Long.valueOf(PayloadController.PAYLOAD_REQUEUE_PERIOD_MS);
        Integer num = f41652a;
        j.c cVar = j.c.LOW_LATENCY_METADATA;
        j.a aVar = j.a.PROD;
        return new cj(valueOf, 86400000L, valueOf2, 7200000L, num, Collections.unmodifiableList(Collections.singletonList(j.a(cVar, aVar))), Collections.unmodifiableList(Collections.singletonList(j.a(j.c.LOW_LATENCY_BACKGROUND_METADATA, aVar))), Collections.unmodifiableList(Collections.singletonList(j.a(j.c.HIGH_LATENCY_METADATA, aVar))), Collections.unmodifiableList(Collections.singletonList(j.a(j.c.DEVELOPER_METADATA, aVar))), Collections.unmodifiableMap(Collections.singletonMap("groupsApiUrl", j.a(j.c.PILOT_GROUPS, aVar))), new ArrayList(), (List<String>) null);
    }

    private static Map<String, String> b(JSONObject jSONObject, String str) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject != null) {
            return fh.b(optJSONObject);
        }
        return null;
    }

    public static cj a(JSONObject jSONObject) throws JSONException, ca {
        JSONObject jSONObject2 = jSONObject;
        Long valueOf = Long.valueOf(jSONObject2.optLong("foregroundPeriodMs"));
        Long l11 = valueOf.longValue() == 0 ? null : valueOf;
        Long valueOf2 = Long.valueOf(jSONObject2.optLong("backgroundPeriodMs"));
        Long l12 = valueOf2.longValue() == 0 ? null : valueOf2;
        Long valueOf3 = Long.valueOf(jSONObject2.optLong("minPostFrequencyMs"));
        Long l13 = valueOf3.longValue() == 0 ? null : valueOf3;
        Long valueOf4 = Long.valueOf(jSONObject2.optLong("maxPostFrequencyMs"));
        Long l14 = valueOf4.longValue() == 0 ? null : valueOf4;
        Integer valueOf5 = Integer.valueOf(jSONObject2.optInt("eventsDeleteChunkSize"));
        return new cj(l11, l12, l13, l14, ((long) valueOf5.intValue()) == 0 ? null : valueOf5, a(jSONObject2, "androidLowLatencyUrls"), a(jSONObject2, "androidLowLatencyBackgroundUrls"), a(jSONObject2, "androidHighLatencyUrls"), a(jSONObject2, "androidDeveloperBuildUrls"), b(jSONObject2, "callServerUrls"), a(jSONObject2, "integrationsEnabled"), a(jSONObject2, "exportsEnabled"));
    }

    private static List<String> a(JSONObject jSONObject, String str) throws JSONException, ca {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
            String string = optJSONArray.getString(i11);
            if (string == null || "".equals(string)) {
                throw new ca("Meta data URL invalid");
            }
            arrayList.add(string);
        }
        return arrayList;
    }
}
