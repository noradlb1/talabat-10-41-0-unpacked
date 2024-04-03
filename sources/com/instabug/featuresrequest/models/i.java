package com.instabug.featuresrequest.models;

import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public abstract class i implements Cacheable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private h f46567a = h.COMMENT;

    /* renamed from: b  reason: collision with root package name */
    public long f46568b;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.instabug.featuresrequest.models.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: com.instabug.featuresrequest.models.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: com.instabug.featuresrequest.models.g} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.instabug.featuresrequest.models.g} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList a(org.json.JSONArray r5) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
        L_0x0006:
            int r2 = r5.length()
            if (r1 >= r2) goto L_0x0061
            org.json.JSONObject r2 = r5.getJSONObject(r1)
            java.lang.String r3 = "type"
            boolean r2 = r2.has(r3)
            if (r2 == 0) goto L_0x005e
            org.json.JSONObject r2 = r5.getJSONObject(r1)
            java.lang.String r2 = r2.getString(r3)
            java.lang.String r3 = "comment"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0042
            com.instabug.featuresrequest.models.a r2 = new com.instabug.featuresrequest.models.a
            r2.<init>()
            org.json.JSONObject r3 = r5.getJSONObject(r1)
            boolean r4 = r3 instanceof org.json.JSONObject
            if (r4 != 0) goto L_0x003a
            java.lang.String r3 = r3.toString()
            goto L_0x003e
        L_0x003a:
            java.lang.String r3 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r3)
        L_0x003e:
            r2.fromJson(r3)
            goto L_0x005b
        L_0x0042:
            com.instabug.featuresrequest.models.g r2 = new com.instabug.featuresrequest.models.g
            r2.<init>()
            org.json.JSONObject r3 = r5.getJSONObject(r1)
            boolean r4 = r3 instanceof org.json.JSONObject
            if (r4 != 0) goto L_0x0054
            java.lang.String r3 = r3.toString()
            goto L_0x0058
        L_0x0054:
            java.lang.String r3 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r3)
        L_0x0058:
            r2.fromJson(r3)
        L_0x005b:
            r0.add(r2)
        L_0x005e:
            int r1 = r1 + 1
            goto L_0x0006
        L_0x0061:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.featuresrequest.models.i.a(org.json.JSONArray):java.util.ArrayList");
    }

    public static JSONArray a(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            jSONArray.put((Object) arrayList.get(i11) instanceof a ? new JSONObject(((a) arrayList.get(i11)).toJson()) : new JSONObject(((g) arrayList.get(i11)).toJson()));
        }
        return jSONArray;
    }

    public long a() {
        return this.f46568b;
    }

    public void a(long j11) {
        this.f46568b = j11;
    }

    public void a(h hVar) {
        this.f46567a = hVar;
    }

    public h b() {
        return this.f46567a;
    }
}
