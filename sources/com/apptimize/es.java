package com.apptimize;

import com.apptimize.bd;
import org.json.JSONException;
import org.json.JSONObject;

public class es extends er<cb> {
    public es(bd.a aVar, au auVar, String str) {
        super(aVar, auVar, str);
    }

    /* renamed from: b */
    public cb a(JSONObject jSONObject) throws Exception {
        return cb.b(jSONObject, this.f42335a);
    }

    public String e() {
        return "META_DATA_145abe7a-ac01-4c7d-bdc7-4811e1967833";
    }

    public JSONObject a(cb cbVar) throws JSONException {
        return cbVar.a();
    }

    public ft<Long> a() {
        return new ft<Long>() {
            /* renamed from: a */
            public Long b() {
                cb cbVar = (cb) es.this.f();
                if (cbVar == null) {
                    return 0L;
                }
                return Long.valueOf((long) cbVar.f());
            }
        };
    }
}
