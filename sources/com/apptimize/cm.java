package com.apptimize;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.apptimize.bt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cm implements bu, bw, cs {

    /* renamed from: a  reason: collision with root package name */
    private bv f41688a;

    /* renamed from: b  reason: collision with root package name */
    private cf f41689b;

    /* renamed from: c  reason: collision with root package name */
    private final long f41690c;

    /* renamed from: d  reason: collision with root package name */
    private List<bt> f41691d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f41692e;

    /* renamed from: f  reason: collision with root package name */
    private final int f41693f;

    /* renamed from: g  reason: collision with root package name */
    private final int f41694g;

    /* renamed from: h  reason: collision with root package name */
    private final String f41695h;

    /* renamed from: i  reason: collision with root package name */
    private final ApptimizeTestType f41696i;

    /* renamed from: j  reason: collision with root package name */
    private final String f41697j;

    /* renamed from: k  reason: collision with root package name */
    private final Long f41698k;

    /* renamed from: l  reason: collision with root package name */
    private final List<cs> f41699l;

    public cm(bv bvVar, cf cfVar, long j11, Long l11, String str, ApptimizeTestType apptimizeTestType, String str2, List<bt> list, Long l12, int i11, int i12) {
        this.f41688a = bvVar;
        this.f41689b = cfVar;
        this.f41690c = j11;
        this.f41692e = l11;
        this.f41695h = str;
        this.f41696i = apptimizeTestType;
        this.f41697j = str2;
        this.f41691d = list;
        this.f41698k = l12;
        this.f41694g = i11;
        this.f41693f = i12;
        for (bt next : list) {
            if (next instanceof bt.k) {
                for (df a11 : ((bt.k) next).g().f41755a) {
                    a11.a(Long.valueOf(j11));
                }
            }
        }
        this.f41699l = Collections.unmodifiableList(new ArrayList(i()));
    }

    public static cm a(JSONObject jSONObject, au auVar) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        au auVar2 = auVar;
        bv a11 = bv.a(jSONObject, auVar);
        cf a12 = cf.a(jSONObject, auVar);
        long j11 = jSONObject2.getLong(RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID);
        int optInt = jSONObject2.optInt("cycle", -1);
        int optInt2 = jSONObject2.optInt(TypedValues.CycleType.S_WAVE_PHASE, -1);
        Long valueOf = Long.valueOf(jSONObject2.optLong(RemoteConfigConstants.ExperimentDescriptionFieldKey.EXPERIMENT_ID, -1));
        if (valueOf.longValue() == -1) {
            valueOf = null;
        }
        String optString = jSONObject2.optString("experimentName");
        if (optString == null || "".equals(optString)) {
            optString = "Unknown experiment name";
        }
        ApptimizeTestType ParseName = ApptimizeTestType.ParseName(jSONObject2.optString("experimentType"));
        String optString2 = jSONObject2.optString("variantName");
        if (optString2 == null || "".equals(optString2)) {
            optString2 = "Unknown variant name";
        }
        ArrayList arrayList = new ArrayList();
        a(arrayList, jSONObject2, "alterations", auVar2);
        a(arrayList, jSONObject2, "alterations2", auVar2);
        Long valueOf2 = Long.valueOf(jSONObject2.optLong("startTime", -1));
        return new cm(a11, a12, j11, valueOf, optString, ParseName, optString2, arrayList, valueOf2.longValue() == -1 ? null : valueOf2, optInt, optInt2);
    }

    public List<az> b() {
        return this.f41688a.a();
    }

    public List<az> c() {
        return this.f41689b.a();
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.f41688a.a(jSONObject);
        this.f41689b.a(jSONObject);
        jSONObject.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.VARIANT_ID, this.f41690c);
        jSONObject.put("cycle", this.f41694g);
        jSONObject.put(TypedValues.CycleType.S_WAVE_PHASE, this.f41693f);
        Long l11 = this.f41692e;
        if (l11 != null) {
            jSONObject.put(RemoteConfigConstants.ExperimentDescriptionFieldKey.EXPERIMENT_ID, (Object) l11);
        }
        if (!this.f41695h.equals("Unknown experiment name")) {
            jSONObject.put("experimentName", (Object) this.f41695h);
        }
        ApptimizeTestType apptimizeTestType = this.f41696i;
        if (!(apptimizeTestType == null || apptimizeTestType.getTypeName() == null)) {
            jSONObject.put("experimentType", (Object) this.f41696i.getTypeName());
        }
        if (!this.f41697j.equals("Unknown variant name")) {
            jSONObject.put("variantName", (Object) this.f41697j);
        }
        if (!this.f41691d.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (bt d11 : this.f41691d) {
                jSONArray.put((Object) d11.d());
            }
            jSONObject.put("alterations", (Object) jSONArray);
        }
        Long l12 = this.f41698k;
        if (l12 != null) {
            jSONObject.put("startTime", (Object) l12);
        }
        return jSONObject;
    }

    public List<cs> e() {
        return this.f41699l;
    }

    public String f() {
        return this.f41695h;
    }

    public Long g() {
        return this.f41692e;
    }

    public ApptimizeTestType h() {
        return this.f41696i;
    }

    public List<bt> i() {
        return this.f41691d;
    }

    public long j() {
        return this.f41690c;
    }

    public int k() {
        return this.f41694g;
    }

    public int l() {
        return this.f41693f;
    }

    public String m() {
        return this.f41697j;
    }

    public Long n() {
        return this.f41698k;
    }

    public JSONArray b(bb bbVar) throws JSONException {
        return az.a((Collection<az>) az.b(b(), bbVar), bbVar);
    }

    private static void a(List<bt> list, JSONObject jSONObject, String str, au auVar) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            for (int i11 = 0; i11 != optJSONArray.length(); i11++) {
                list.add(bt.a(optJSONArray.getJSONObject(i11), auVar));
            }
        }
    }

    public Long a() {
        return Long.valueOf(this.f41690c);
    }

    public JSONArray a(bb bbVar) throws JSONException {
        return az.a((Collection<az>) az.a(b(), bbVar), bbVar);
    }

    public boolean a(co coVar) {
        return coVar.a(this);
    }
}
