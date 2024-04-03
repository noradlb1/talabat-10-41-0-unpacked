package com.apptimize;

import com.apptimize.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class el {

    /* renamed from: a  reason: collision with root package name */
    public final cm f42303a;

    /* renamed from: b  reason: collision with root package name */
    public final dw f42304b;

    public el(cm cmVar, dw dwVar) {
        this.f42303a = cmVar;
        this.f42304b = dwVar;
        if (cmVar == null || dwVar == null) {
            throw null;
        }
    }

    public static el a(cm cmVar) {
        return new el(cmVar, dw.a());
    }

    public void b() {
        boolean z11 = true;
        for (bt btVar : this.f42303a.i()) {
            if (!(btVar instanceof bt.k)) {
                z11 = false;
            }
        }
        if (z11) {
            this.f42304b.d();
        } else {
            this.f42304b.c();
        }
    }

    public static el a(cm cmVar, el elVar) {
        if (cmVar.j() == elVar.f42303a.j()) {
            return new el(cmVar, elVar.f42304b);
        }
        throw new IllegalStateException("Variant IDs don't match.");
    }

    public static el a(JSONObject jSONObject, au auVar) throws JSONException {
        return new el(cm.a(jSONObject.getJSONObject("selectedVariant"), auVar), dw.a(jSONObject.getJSONObject("metrics")));
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("selectedVariant", (Object) this.f42303a.d());
        jSONObject.put("metrics", (Object) this.f42304b.b());
        return jSONObject;
    }
}
