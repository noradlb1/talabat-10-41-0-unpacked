package com.huawei.agconnect.config.impl;

import android.util.Log;
import com.huawei.agconnect.config.ConfigReader;
import com.huawei.wearengine.common.Constants;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class i implements ConfigReader {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f47513a;

    public i(InputStream inputStream, String str) {
        this.f47513a = a(inputStream);
        a(str);
    }

    private JSONObject a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(Utils.toString(inputStream, "UTF-8"));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:5|6|7|8|9|(2:11|26)(2:12|(4:14|(4:17|(2:19|24)(1:23)|21|15)|22|28)(1:27))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0020 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d A[Catch:{ JSONException -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[Catch:{ JSONException -> 0x006c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "app_id"
            org.json.JSONObject r6 = r5.b(r6)     // Catch:{ JSONException -> 0x006c }
            if (r6 != 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = "/configuration_version"
            java.lang.String r2 = ""
            java.lang.String r1 = r5.getString(r1, r2)     // Catch:{ JSONException -> 0x006c }
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ JSONException -> 0x006c }
            java.lang.String r3 = "0.0"
            r2.<init>(r3)     // Catch:{ JSONException -> 0x006c }
            double r3 = java.lang.Double.parseDouble(r1)     // Catch:{ NumberFormatException -> 0x0020 }
            java.math.BigDecimal r2 = java.math.BigDecimal.valueOf(r3)     // Catch:{ NumberFormatException -> 0x0020 }
        L_0x0020:
            java.math.BigDecimal r1 = new java.math.BigDecimal     // Catch:{ JSONException -> 0x006c }
            java.lang.String r3 = "2.0"
            r1.<init>(r3)     // Catch:{ JSONException -> 0x006c }
            int r1 = r2.compareTo(r1)     // Catch:{ JSONException -> 0x006c }
            if (r1 != 0) goto L_0x003d
            org.json.JSONObject r1 = r5.f47513a     // Catch:{ JSONException -> 0x006c }
            java.lang.String r2 = "client"
            org.json.JSONObject r1 = r1.getJSONObject(r2)     // Catch:{ JSONException -> 0x006c }
            java.lang.String r6 = r6.getString(r0)     // Catch:{ JSONException -> 0x006c }
            r1.put((java.lang.String) r0, (java.lang.Object) r6)     // Catch:{ JSONException -> 0x006c }
            goto L_0x006c
        L_0x003d:
            java.math.BigDecimal r0 = new java.math.BigDecimal     // Catch:{ JSONException -> 0x006c }
            java.lang.String r1 = "3.0"
            r0.<init>(r1)     // Catch:{ JSONException -> 0x006c }
            int r0 = r2.compareTo(r0)     // Catch:{ JSONException -> 0x006c }
            if (r0 < 0) goto L_0x006c
            java.util.Iterator r0 = r6.keys()     // Catch:{ JSONException -> 0x006c }
        L_0x004e:
            boolean r1 = r0.hasNext()     // Catch:{ JSONException -> 0x006c }
            if (r1 == 0) goto L_0x006c
            java.lang.Object r1 = r0.next()     // Catch:{ JSONException -> 0x006c }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ JSONException -> 0x006c }
            java.lang.String r2 = "package_name"
            boolean r2 = r2.equals(r1)     // Catch:{ JSONException -> 0x006c }
            if (r2 != 0) goto L_0x004e
            java.lang.Object r2 = r6.get(r1)     // Catch:{ JSONException -> 0x006c }
            org.json.JSONObject r3 = r5.f47513a     // Catch:{ JSONException -> 0x006c }
            r5.a(r1, r2, r3)     // Catch:{ JSONException -> 0x006c }
            goto L_0x004e
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.config.impl.i.a(java.lang.String):void");
    }

    private void a(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str != null && obj != null && jSONObject != null) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj;
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    a(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
                }
                return;
            }
            jSONObject.put(str, obj);
        }
    }

    private JSONObject b(String str) throws JSONException {
        JSONArray jSONArray = this.f47513a.getJSONArray("appInfos");
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            if (jSONObject.getString(Constants.PACKAGE_NAME).equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    public String getString(String str, String str2) {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] split = str.split("/");
        try {
            JSONObject jSONObject = this.f47513a;
            for (int i11 = 1; i11 < split.length; i11++) {
                if (i11 == split.length - 1) {
                    return jSONObject.get(split[i11]).toString();
                }
                jSONObject = jSONObject.getJSONObject(split[i11]);
            }
        } catch (JSONException unused) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        return str2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("InputStreamReader{config=");
        JSONObject jSONObject = this.f47513a;
        sb2.append((!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)).hashCode());
        sb2.append(AbstractJsonLexerKt.END_OBJ);
        return sb2.toString();
    }
}
