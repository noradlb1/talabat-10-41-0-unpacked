package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a {
    public c(Context context, boolean z11) {
        this.f48866d = z11;
        if (a("grs_sdk_global_route_config.json", context) == 0) {
            this.f48865c = true;
        }
    }

    private List<b> a(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                b bVar = new b();
                bVar.b(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.c(jSONObject2.getString("name"));
                bVar.a(jSONObject2.getString("description"));
                if (jSONObject2.has("countriesOrAreas")) {
                    jSONArray = jSONObject2.getJSONArray("countriesOrAreas");
                } else if (jSONObject2.has("countries")) {
                    jSONArray = jSONObject2.getJSONArray("countries");
                } else {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                    jSONArray = null;
                }
                HashSet hashSet = new HashSet(16);
                if (jSONArray != null) {
                    if (jSONArray.length() != 0) {
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            hashSet.add((String) jSONArray.get(i11));
                        }
                        bVar.a((Set<String>) hashSet);
                        arrayList.add(bVar);
                    }
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e11) {
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return new ArrayList();
        }
    }

    public List<b> a(JSONArray jSONArray, JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0) ? new ArrayList() : a(jSONObject);
    }

    public int b(String str) {
        this.f48863a = new a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(MimeTypes.BASE_TYPE_APPLICATION);
            String string = jSONObject.getString("name");
            long j11 = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            this.f48863a.b(string);
            this.f48863a.a(j11);
            return (jSONArray == null || jSONArray.length() == 0) ? -1 : 0;
        } catch (JSONException e11) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return -1;
        }
    }

    public int c(String str) {
        JSONObject jSONObject;
        this.f48864b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("countryOrAreaGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryOrAreaGroups");
            } else if (jSONObject2.has("countryGroups")) {
                jSONObject = jSONObject2.getJSONObject("countryGroups");
            } else {
                Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONObject = null;
            }
            if (jSONObject == null) {
                return -1;
            }
            if (jSONObject.length() != 0) {
                this.f48864b.addAll(a(jSONObject));
            }
            return 0;
        } catch (JSONException e11) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e11.getMessage()));
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2 A[Catch:{ JSONException -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010c A[Catch:{ JSONException -> 0x0120 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int f(java.lang.String r21) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = "countryGroup"
            java.lang.String r2 = "countryOrAreaGroup"
            java.lang.String r3 = "countryGroups"
            java.lang.String r4 = "countryOrAreaGroups"
            java.lang.String r5 = "LocalManagerV1"
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0120 }
            r8 = r21
            r7.<init>((java.lang.String) r8)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r8 = "services"
            org.json.JSONObject r7 = r7.getJSONObject(r8)     // Catch:{ JSONException -> 0x0120 }
            java.util.Iterator r8 = r7.keys()     // Catch:{ JSONException -> 0x0120 }
        L_0x001d:
            boolean r9 = r8.hasNext()     // Catch:{ JSONException -> 0x0120 }
            if (r9 == 0) goto L_0x011e
            java.lang.Object r9 = r8.next()     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ JSONException -> 0x0120 }
            com.huawei.hms.framework.network.grs.local.model.c r10 = new com.huawei.hms.framework.network.grs.local.model.c     // Catch:{ JSONException -> 0x0120 }
            r10.<init>()     // Catch:{ JSONException -> 0x0120 }
            r10.b(r9)     // Catch:{ JSONException -> 0x0120 }
            java.util.Set<java.lang.String> r11 = r1.f48867e     // Catch:{ JSONException -> 0x0120 }
            boolean r11 = r11.contains(r9)     // Catch:{ JSONException -> 0x0120 }
            if (r11 != 0) goto L_0x001d
            java.util.Set<java.lang.String> r11 = r1.f48867e     // Catch:{ JSONException -> 0x0120 }
            r11.add(r9)     // Catch:{ JSONException -> 0x0120 }
            boolean r11 = r1.f48866d     // Catch:{ JSONException -> 0x0120 }
            if (r11 == 0) goto L_0x001d
            org.json.JSONObject r11 = r7.getJSONObject(r9)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r12 = "routeBy"
            java.lang.String r12 = r11.getString(r12)     // Catch:{ JSONException -> 0x0120 }
            r10.c(r12)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r12 = "servings"
            org.json.JSONArray r12 = r11.getJSONArray(r12)     // Catch:{ JSONException -> 0x0120 }
            r13 = 0
        L_0x0056:
            int r14 = r12.length()     // Catch:{ JSONException -> 0x0120 }
            if (r13 >= r14) goto L_0x00e1
            java.lang.Object r14 = r12.get(r13)     // Catch:{ JSONException -> 0x0120 }
            org.json.JSONObject r14 = (org.json.JSONObject) r14     // Catch:{ JSONException -> 0x0120 }
            com.huawei.hms.framework.network.grs.local.model.d r15 = new com.huawei.hms.framework.network.grs.local.model.d     // Catch:{ JSONException -> 0x0120 }
            r15.<init>()     // Catch:{ JSONException -> 0x0120 }
            boolean r16 = r14.has(r2)     // Catch:{ JSONException -> 0x0120 }
            if (r16 == 0) goto L_0x0072
            java.lang.String r16 = r14.getString(r2)     // Catch:{ JSONException -> 0x0120 }
            goto L_0x007c
        L_0x0072:
            boolean r16 = r14.has(r0)     // Catch:{ JSONException -> 0x0120 }
            if (r16 == 0) goto L_0x007f
            java.lang.String r16 = r14.getString(r0)     // Catch:{ JSONException -> 0x0120 }
        L_0x007c:
            r6 = r16
            goto L_0x0086
        L_0x007f:
            java.lang.String r6 = "maybe this service routeBy is unconditional."
            com.huawei.hms.framework.common.Logger.v(r5, r6)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r6 = "no-country"
        L_0x0086:
            r15.a((java.lang.String) r6)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r6 = "addresses"
            org.json.JSONObject r6 = r14.getJSONObject(r6)     // Catch:{ JSONException -> 0x0120 }
            j$.util.concurrent.ConcurrentHashMap r14 = new j$.util.concurrent.ConcurrentHashMap     // Catch:{ JSONException -> 0x0120 }
            r17 = r0
            r0 = 16
            r14.<init>((int) r0)     // Catch:{ JSONException -> 0x0120 }
            java.util.Iterator r0 = r6.keys()     // Catch:{ JSONException -> 0x0120 }
        L_0x009c:
            boolean r18 = r0.hasNext()     // Catch:{ JSONException -> 0x0120 }
            if (r18 == 0) goto L_0x00cd
            java.lang.Object r18 = r0.next()     // Catch:{ JSONException -> 0x0120 }
            r21 = r0
            r0 = r18
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r18 = r6.getString(r0)     // Catch:{ JSONException -> 0x0120 }
            boolean r19 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0120 }
            if (r19 != 0) goto L_0x00ca
            boolean r18 = android.text.TextUtils.isEmpty(r18)     // Catch:{ JSONException -> 0x0120 }
            if (r18 != 0) goto L_0x00ca
            r18 = r2
            java.lang.String r2 = r6.getString(r0)     // Catch:{ JSONException -> 0x0120 }
            r14.put(r0, r2)     // Catch:{ JSONException -> 0x0120 }
            r0 = r21
            r2 = r18
            goto L_0x009c
        L_0x00ca:
            r0 = r21
            goto L_0x009c
        L_0x00cd:
            r18 = r2
            r15.a((java.util.Map<java.lang.String, java.lang.String>) r14)     // Catch:{ JSONException -> 0x0120 }
            java.lang.String r0 = r15.b()     // Catch:{ JSONException -> 0x0120 }
            r10.a(r0, r15)     // Catch:{ JSONException -> 0x0120 }
            int r13 = r13 + 1
            r0 = r17
            r2 = r18
            goto L_0x0056
        L_0x00e1:
            r17 = r0
            r18 = r2
            boolean r0 = r11.has(r4)     // Catch:{ JSONException -> 0x0120 }
            r2 = 0
            if (r0 == 0) goto L_0x00f1
            org.json.JSONObject r0 = r11.getJSONObject(r4)     // Catch:{ JSONException -> 0x0120 }
            goto L_0x00fb
        L_0x00f1:
            boolean r0 = r11.has(r3)     // Catch:{ JSONException -> 0x0120 }
            if (r0 == 0) goto L_0x0100
            org.json.JSONObject r0 = r11.getJSONObject(r3)     // Catch:{ JSONException -> 0x0120 }
        L_0x00fb:
            java.util.List r2 = r1.a(r2, r0)     // Catch:{ JSONException -> 0x0120 }
            goto L_0x0105
        L_0x0100:
            java.lang.String r0 = "service use default countryOrAreaGroup"
            com.huawei.hms.framework.common.Logger.v(r5, r0)     // Catch:{ JSONException -> 0x0120 }
        L_0x0105:
            r10.a((java.util.List<com.huawei.hms.framework.network.grs.local.model.b>) r2)     // Catch:{ JSONException -> 0x0120 }
            com.huawei.hms.framework.network.grs.local.model.a r0 = r1.f48863a     // Catch:{ JSONException -> 0x0120 }
            if (r0 != 0) goto L_0x0113
            com.huawei.hms.framework.network.grs.local.model.a r0 = new com.huawei.hms.framework.network.grs.local.model.a     // Catch:{ JSONException -> 0x0120 }
            r0.<init>()     // Catch:{ JSONException -> 0x0120 }
            r1.f48863a = r0     // Catch:{ JSONException -> 0x0120 }
        L_0x0113:
            com.huawei.hms.framework.network.grs.local.model.a r0 = r1.f48863a     // Catch:{ JSONException -> 0x0120 }
            r0.a(r9, r10)     // Catch:{ JSONException -> 0x0120 }
            r0 = r17
            r2 = r18
            goto L_0x001d
        L_0x011e:
            r2 = 0
            return r2
        L_0x0120:
            r0 = move-exception
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r0)
            r3 = 0
            r2[r3] = r0
            java.lang.String r0 = "parse 1.0 services failed maybe because of json style.please check! %s"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r5, (java.lang.String) r0, (java.lang.Object[]) r2)
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.f.c.f(java.lang.String):int");
    }
}
