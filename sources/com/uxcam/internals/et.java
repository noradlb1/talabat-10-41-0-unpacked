package com.uxcam.internals;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class et {
    /* JADX WARNING: Can't wrap try/catch for region: R(8:11|12|13|14|15|16|17|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0048 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List a(android.content.Context r8) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.uxcam.internals.eq r1 = new com.uxcam.internals.eq
            r1.<init>(r8)
            android.content.SharedPreferences r8 = r1.f13291a
            if (r8 != 0) goto L_0x0011
            java.lang.String r8 = ""
            goto L_0x0018
        L_0x0011:
            r1 = 0
            java.lang.String r2 = "push_notification_data"
            java.lang.String r8 = r8.getString(r2, r1)
        L_0x0018:
            if (r8 == 0) goto L_0x005e
            boolean r1 = r8.isEmpty()
            if (r1 == 0) goto L_0x0021
            goto L_0x005e
        L_0x0021:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x005a }
            r1.<init>((java.lang.String) r8)     // Catch:{ JSONException -> 0x005a }
            r8 = 0
        L_0x0027:
            int r2 = r1.length()     // Catch:{ JSONException -> 0x005a }
            if (r8 >= r2) goto L_0x005e
            org.json.JSONObject r2 = r1.getJSONObject(r8)     // Catch:{ JSONException -> 0x005a }
            com.uxcam.internals.es r3 = new com.uxcam.internals.es     // Catch:{ JSONException -> 0x0048 }
            java.lang.String r4 = "timeStamp"
            long r4 = r2.getLong(r4)     // Catch:{ JSONException -> 0x0048 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0048 }
            java.lang.String r7 = "uxCamData"
            java.lang.String r2 = r2.getString(r7)     // Catch:{ JSONException -> 0x0048 }
            r6.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x0048 }
            r3.<init>(r4, r6)     // Catch:{ JSONException -> 0x0048 }
            goto L_0x0054
        L_0x0048:
            com.uxcam.internals.es r3 = new com.uxcam.internals.es     // Catch:{ JSONException -> 0x005a }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005a }
            r2.<init>()     // Catch:{ JSONException -> 0x005a }
            r4 = 0
            r3.<init>(r4, r2)     // Catch:{ JSONException -> 0x005a }
        L_0x0054:
            r0.add(r3)     // Catch:{ JSONException -> 0x005a }
            int r8 = r8 + 1
            goto L_0x0027
        L_0x005a:
            r8 = move-exception
            r8.getMessage()
        L_0x005e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.et.a(android.content.Context):java.util.List");
    }

    public static JSONArray a(List list) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                es esVar = (es) it.next();
                esVar.getClass();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timeStamp", esVar.f13292a);
                jSONObject.put("uxCamData", (Object) esVar.f13293b);
                jSONObject.put("timeLine", (double) esVar.f13294c);
                jSONArray.put((Object) jSONObject);
            }
        } catch (JSONException e11) {
            e11.getMessage();
        }
        return jSONArray;
    }

    public static JSONArray a(Context context, double d11) {
        List<es> a11 = a(context);
        ArrayList arrayList = new ArrayList();
        for (es esVar : a11) {
            esVar.f13294c = (float) ((((double) esVar.f13292a) - (((double) System.currentTimeMillis()) - (d11 * 1000.0d))) / 1000.0d);
            arrayList.add(esVar);
        }
        SharedPreferences sharedPreferences = new eq(context).f13291a;
        if (sharedPreferences != null) {
            sharedPreferences.edit().remove("push_notification_data").apply();
        }
        return a((List) arrayList);
    }
}
