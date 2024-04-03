package com.instabug.apm.networking.mapping.uitrace;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.facebook.appevents.UserDataStore;
import com.instabug.apm.cache.model.i;
import com.instabug.apm.cache.model.j;
import com.instabug.apm.networking.mapping.uiloading.a;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
public class b implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final a f45536a;

    public b(@NonNull a aVar) {
        this.f45536a = aVar;
    }

    public JSONArray a(List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((Object) a((j) it.next()));
        }
        return jSONArray;
    }

    public JSONObject a(j jVar) {
        a aVar;
        JSONObject a11;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("n", (Object) jVar.g());
        jSONObject.put("dmus", jVar.c());
        long e11 = jVar.e();
        long m11 = jVar.m();
        if (!(e11 == -1 || m11 == -1)) {
            jSONObject.put("ldd", e11);
            jSONObject.put("sdd", m11);
        }
        jSONObject.put("ud", jVar.t());
        jSONObject.put(UserDataStore.STATE, jVar.n());
        jSONObject.put("rr", jVar.j());
        if (jVar.a() != -1) {
            jSONObject.put("bl", jVar.a());
        }
        if (jVar.b() != null) {
            jSONObject.put("cn", (Object) jVar.b());
        }
        if (jVar.k() != null) {
            jSONObject.put("snt", (Object) jVar.k());
        }
        if (jVar.h() != null) {
            jSONObject.put("o", (Object) jVar.h());
        }
        if (jVar.f() != null) {
            jSONObject.put("mn", (Object) jVar.f());
        }
        if (jVar.i() != null) {
            jSONObject.put("pws", (Object) jVar.i());
        }
        i p11 = jVar.p();
        if (!(p11 == null || (aVar = this.f45536a) == null || (a11 = aVar.a(p11)) == null)) {
            jSONObject.put("sl", (Object) a11);
        }
        return jSONObject;
    }
}
