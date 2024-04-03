package com.huawei.hms.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.analytics.az;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class ch {
    private static void ikl(az azVar, JSONObject jSONObject) {
        try {
            if (!jSONObject.has("disable_evts")) {
                HiLog.d("onlineApi", "Not has disabled events");
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("disable_evts");
            az.lmn lmn = new az.lmn();
            int length = jSONArray.length();
            if (length != 0) {
                if (length > 1000) {
                    HiLog.w("onlineApi", "Get disabled events size is " + length + ". Exceeds limit.");
                    jSONArray = dm.lmn(jSONArray);
                    jSONObject.put("disable_evts", (Object) jSONArray);
                    length = 1000;
                }
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < length; i11++) {
                    arrayList.add(jSONArray.getString(i11));
                }
                if (arrayList.size() > 0) {
                    lmn.lmn = arrayList;
                    azVar.hij = lmn;
                }
            }
        } catch (JSONException unused) {
            HiLog.w("onlineApi", "disabled evts is not json");
        }
    }

    public static void klm(Context context, IConfig iConfig, long j11) {
        if (lmn(context, j11)) {
            lmn(context, iConfig, j11);
        }
    }

    private static void klm(az azVar, JSONObject jSONObject) {
        try {
            if (!jSONObject.has("online_events")) {
                HiLog.d("onlineApi", "Not has online events");
                return;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("online_events");
            int length = jSONArray.length();
            if (length != 0) {
                if (length > 1000) {
                    HiLog.w("onlineApi", "Get online events size is " + length + ". Exceeds limit.");
                    jSONArray = dm.lmn(jSONArray);
                    jSONObject.put("online_events", (Object) jSONArray);
                    length = 1000;
                }
                for (int i11 = 0; i11 < length; i11++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                    az.klm klm = new az.klm();
                    klm.lmn = jSONObject2.getString("event_id");
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("time_ranges");
                    if (jSONArray2.length() != 0) {
                        for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i12);
                            az.ikl ikl = new az.ikl();
                            ikl.lmn = Long.valueOf(jSONObject3.optLong("start"));
                            ikl.klm = Long.valueOf(jSONObject3.optLong(TtmlNode.END));
                            if (klm.klm == null) {
                                klm.klm = new ArrayList();
                            }
                            klm.klm.add(ikl);
                        }
                        if (azVar.klm == null) {
                            azVar.klm = new ArrayList();
                        }
                        azVar.klm.add(klm);
                    }
                }
                if (azVar.klm != null) {
                    azVar.ghi = true;
                }
            }
        } catch (JSONException unused) {
            HiLog.w("onlineApi", "instance events json exception");
        }
    }

    public static synchronized az lmn(Context context) {
        synchronized (ch.class) {
            String klm = dv.klm(context, "global_v2", "instance_event_info", "");
            if (TextUtils.isEmpty(klm)) {
                return null;
            }
            az lmn = lmn(context, klm);
            return lmn;
        }
    }

    public static az lmn(Context context, String str) {
        az azVar = new az();
        try {
            JSONObject jSONObject = new JSONObject(str);
            azVar.lmn = Math.max(1800, jSONObject.getLong("query_interval")) * 1000;
            klm(azVar, jSONObject);
            ikl(azVar, jSONObject);
            if (!lmn(azVar, jSONObject)) {
                dv.lmn(context, "global_v2", "instance_event_info", JSONObjectInstrumentation.toString(jSONObject));
            }
            return azVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static synchronized void lmn(Context context, IConfig iConfig, long j11) {
        synchronized (ch.class) {
            dg.ikl().lmn(new cp(iConfig));
            dv.lmn(context, "latest_upload_time", "instance_event_trigger_time", j11);
        }
    }

    private static boolean lmn(Context context, long j11) {
        return j11 - dv.klm(context, "latest_upload_time", "instance_event_trigger_time") > 1800000;
    }

    private static boolean lmn(az azVar, JSONObject jSONObject) {
        if (!jSONObject.has("timestamp") || !jSONObject.has("region")) {
            long currentTimeMillis = System.currentTimeMillis();
            String lmn = av.lmn().lmn.f47867n.lmn("_openness_config_tag");
            try {
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put("region", (Object) lmn);
            } catch (JSONException unused) {
                HiLog.w("onlineApi", "json put exception");
            }
            azVar.ijk = lmn;
            azVar.ikl = Long.valueOf(currentTimeMillis);
            return false;
        }
        azVar.ikl = Long.valueOf(jSONObject.optLong("timestamp"));
        azVar.ijk = jSONObject.optString("region");
        return true;
    }
}
