package com.instabug.apm.networking.mapping.networklog;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apptimize.c;
import com.facebook.appevents.UserDataStore;
import com.instabug.apm.cache.model.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements a {
    private String a(@NonNull String str) {
        return str.replaceAll("\\[", "").replaceAll("]", "");
    }

    @Nullable
    private JSONObject a(a aVar) {
        String d11 = aVar.d();
        int c11 = aVar.c();
        if (d11 == null && c11 <= 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (d11 != null) {
            jSONObject.put("e", (Object) d11);
        }
        if (c11 > 0) {
            jSONObject.put(c.f41585a, c11);
        }
        return jSONObject;
    }

    @Nullable
    private JSONObject b(a aVar) {
        String f11 = aVar.f();
        if (f11 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("m", (Object) f11);
        return jSONObject;
    }

    @Nullable
    private JSONObject c(a aVar) {
        if (aVar.j() <= 0 && aVar.k() == null && aVar.l() == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (aVar.j() > 0) {
            jSONObject.put("ps", aVar.j());
        }
        String l11 = aVar.l();
        if (l11 != null) {
            jSONObject.put("h", (Object) a(l11));
        }
        String k11 = aVar.k();
        if (k11 != null) {
            jSONObject.put(UserDataStore.CITY, (Object) a(k11));
        }
        return jSONObject;
    }

    @Nullable
    private JSONObject d(a aVar) {
        if (aVar.m() <= 0 && aVar.o() == null && aVar.p() == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        if (aVar.m() > 0) {
            jSONObject.put("ps", aVar.m());
        }
        String p11 = aVar.p();
        if (p11 != null) {
            jSONObject.put("h", (Object) a(p11));
        }
        String o11 = aVar.o();
        if (o11 != null) {
            jSONObject.put(UserDataStore.CITY, (Object) a(o11));
        }
        return jSONObject;
    }

    public JSONArray a(@NonNull List list) {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            JSONObject jSONObject = new JSONObject();
            if (aVar.h() != null) {
                jSONObject.put("m", (Object) aVar.h().toLowerCase());
            }
            if (aVar.t() != null) {
                jSONObject.put("u", (Object) aVar.t());
            }
            if (!TextUtils.isEmpty(aVar.i())) {
                jSONObject.put("ra", (Object) aVar.i());
            }
            if (!TextUtils.isEmpty(aVar.b())) {
                jSONObject.put("ca", (Object) aVar.b());
            }
            int n11 = aVar.n();
            JSONObject b11 = b(aVar);
            boolean z11 = b11 != null;
            if (b11 != null) {
                jSONObject.put("grpc", (Object) b11);
            }
            JSONObject a11 = a(aVar);
            if (a11 != null) {
                jSONObject.put("cse", (Object) a11);
            } else if (n11 >= 0 && (z11 || n11 > 0)) {
                jSONObject.put("sc", n11);
            }
            JSONObject c11 = c(aVar);
            if (c11 != null) {
                jSONObject.put("rq", (Object) c11);
            }
            JSONObject d11 = d(aVar);
            if (d11 != null) {
                jSONObject.put("rs", (Object) d11);
            }
            if (aVar.s() > 0) {
                jSONObject.put("rt", aVar.s());
            }
            jSONObject.put("bg", aVar.u());
            if (aVar.r() != null) {
                jSONObject.put(UserDataStore.STATE, (Object) aVar.r());
            }
            if (aVar.a() != null) {
                jSONObject.put("att", (Object) new JSONObject((Map<?, ?>) aVar.a()));
            }
            String e11 = aVar.e();
            if (e11 != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("qn", (Object) e11);
                jSONObject.put("gql", (Object) jSONObject2);
            }
            String q11 = aVar.q();
            if (q11 != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("e", (Object) q11);
                jSONObject.put("sse", (Object) jSONObject3);
            }
            jSONArray.put((Object) jSONObject);
        }
        return jSONArray;
    }
}
