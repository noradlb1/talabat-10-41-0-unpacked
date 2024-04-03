package com.huawei.hms.analytics;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.framework.config.DeviceAttributeCollector;
import com.huawei.hms.analytics.framework.config.EvtHeaderAttributeCollector;
import com.huawei.hms.analytics.framework.config.ICollectorConfig;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.framework.config.RomAttributeCollector;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class bu implements ICollectorConfig {
    private IConfig ijk;
    private ax ikl = av.lmn().lmn;
    private bz klm;
    private String lmn;

    public bu(String str) {
        this.lmn = str;
    }

    private boolean ikl() {
        String str;
        ax axVar = this.ikl;
        boolean z11 = true;
        if (axVar.def) {
            return true;
        }
        abc abc = axVar.f47855b;
        if (abc != null) {
            try {
                String lmn2 = abc.lmn();
                if (TextUtils.isEmpty(lmn2) || "true".equals(lmn2)) {
                    z11 = false;
                }
                return z11;
            } catch (Exception unused) {
                str = "syncDataSharingStatus error";
            }
        } else {
            str = "IHiAnalyticsService is null";
            HiLog.w("OpennessCollectSettings", str);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0056 A[Catch:{ JSONException -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<org.json.JSONObject> klm() {
        /*
            r9 = this;
            com.huawei.hms.analytics.ax r0 = r9.ikl
            android.content.Context r0 = r0.ghi
            java.lang.String r1 = "camp_evt"
            java.lang.String r2 = ""
            java.lang.String r3 = "global_v2"
            java.lang.String r0 = com.huawei.hms.analytics.dv.klm((android.content.Context) r0, (java.lang.String) r3, (java.lang.String) r1, (java.lang.String) r2)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L_0x0016
            return r2
        L_0x0016:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch:{ JSONException -> 0x005d }
            r1.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x005d }
            int r0 = r1.length()     // Catch:{ JSONException -> 0x005d }
            if (r0 != 0) goto L_0x0022
            return r2
        L_0x0022:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ JSONException -> 0x005d }
            r3.<init>()     // Catch:{ JSONException -> 0x005d }
            r4 = 0
            r5 = r4
        L_0x0029:
            if (r5 >= r0) goto L_0x005c
            org.json.JSONObject r6 = r1.getJSONObject(r5)     // Catch:{ JSONException -> 0x005d }
            java.lang.String r7 = "t"
            java.lang.Object r7 = r6.remove(r7)     // Catch:{ JSONException -> 0x005d }
            boolean r7 = com.huawei.hms.analytics.dl.klm(r7)     // Catch:{ JSONException -> 0x005d }
            if (r7 == 0) goto L_0x003d
        L_0x003b:
            r6 = r2
            goto L_0x0054
        L_0x003d:
            com.huawei.hms.analytics.dt r7 = new com.huawei.hms.analytics.dt     // Catch:{ JSONException -> 0x005d }
            java.lang.String r8 = "$CampaignPushClick"
            r7.<init>((java.lang.String) r8, (org.json.JSONObject) r6)     // Catch:{ JSONException -> 0x005d }
            java.util.ArrayList<org.json.JSONObject> r6 = r7.ikl     // Catch:{ JSONException -> 0x005d }
            int r7 = r6.size()     // Catch:{ JSONException -> 0x005d }
            r8 = 1
            if (r7 == r8) goto L_0x004e
            goto L_0x003b
        L_0x004e:
            java.lang.Object r6 = r6.get(r4)     // Catch:{ JSONException -> 0x005d }
            org.json.JSONObject r6 = (org.json.JSONObject) r6     // Catch:{ JSONException -> 0x005d }
        L_0x0054:
            if (r6 == 0) goto L_0x0059
            r3.add(r6)     // Catch:{ JSONException -> 0x005d }
        L_0x0059:
            int r5 = r5 + 1
            goto L_0x0029
        L_0x005c:
            return r3
        L_0x005d:
            java.lang.String r0 = "OpennessCollectSettings"
            java.lang.String r1 = "Camp event is error from sp"
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.bu.klm():java.util.List");
    }

    private JSONArray klm(String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = new JSONArray(str);
            int length = jSONArray2.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i11);
                if (dl.klm(jSONObject.getString("t"))) {
                    HiLog.i("OpennessCollectSettings", "CampInfo has expired");
                } else {
                    jSONArray.put((Object) jSONObject);
                }
            }
            if (jSONArray.length() < length) {
                dv.lmn(this.ikl.ghi, "global_v2", "camp_info", JSONArrayInstrumentation.toString(jSONArray));
            }
            return jSONArray;
        } catch (JSONException unused) {
            dv.lmn(this.ikl.ghi, "global_v2", "camp_info");
            return null;
        }
    }

    private int lmn(String str) {
        int klm2 = dv.klm(this.ikl.ghi, "global_v2", "is_new_user", -1);
        if (klm2 == 0) {
            return klm2;
        }
        try {
            if (!dl.lmn(Long.parseLong(str), System.currentTimeMillis())) {
                return 1;
            }
            dv.lmn(this.ikl.ghi, "global_v2", "is_new_user", 0);
            return 0;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private String lmn() {
        JSONArray klm2;
        String klm3 = dv.klm(this.ikl.ghi, "global_v2", "camp_info", "");
        if (TextUtils.isEmpty(klm3) || (klm2 = klm(klm3)) == null) {
            return "";
        }
        int length = klm2.length();
        int i11 = 0;
        while (i11 < length) {
            try {
                klm2.getJSONObject(i11).remove("t");
                i11++;
            } catch (JSONException unused) {
                return "";
            }
        }
        return JSONArrayInstrumentation.toString(klm2);
    }

    public final String getAppId() {
        return this.ikl.f47867n.klm;
    }

    public final List<JSONObject> getCustomEventJson(long j11) {
        Bundle bundle;
        dt dtVar;
        ArrayList<JSONObject> arrayList = null;
        if (!"_openness_config_tag".equals(this.lmn)) {
            return null;
        }
        if (Profile.Country.CN.equals(this.ikl.f47867n.lmn(this.lmn)) && !dp.ghi(this.ikl.ghi)) {
            if (!av.lmn().lmn.f47869p) {
                if (!this.ikl.f47877x) {
                    HiLog.i("OpennessCollectSettings", "it is not allowed to collect push token");
                } else {
                    cq cqVar = new cq(this.lmn);
                    bd lmn2 = cq.lmn();
                    if (lmn2 == null) {
                        HiLog.i("pshTken", "The manufacturer does not support push token collection");
                        bundle = null;
                    } else {
                        bundle = lmn2.lmn(lmn2.lmn());
                    }
                    if (bundle == null) {
                        HiLog.i("pshTken", "all push token is empty");
                        dtVar = null;
                    } else {
                        dtVar = new dt("$AppPushToken", bundle);
                    }
                    if (dtVar != null) {
                        av.lmn().lmn.f47869p = true;
                        bl blVar = cqVar.lmn;
                        if (blVar != null) {
                            blVar.lmn("$AppPushToken", dtVar.lmn, j11);
                        }
                        arrayList = dtVar.ikl;
                    }
                }
            }
            List<JSONObject> klm2 = klm();
            if (klm2 == null) {
                return arrayList;
            }
            if (arrayList == null) {
                return klm2;
            }
            arrayList.addAll(klm2);
        }
        return arrayList;
    }

    public final DeviceAttributeCollector getDeviceAttribute(String str) {
        bv bvVar = new bv();
        bvVar.lmn = dh.lmn().klm();
        ax axVar = this.ikl;
        bvVar.klm = axVar.f47861h;
        bvVar.hij = axVar.f47862i;
        bvVar.ikl = axVar.bcd;
        if (("_openness_config_tag".equals(this.lmn) || aq.fgh.contains(this.lmn)) && Profile.Country.CN.equals(this.ijk.getSite())) {
            ax axVar2 = this.ikl;
            bvVar.ghi = axVar2.f47872s;
            bvVar.fgh = axVar2.f47873t;
        }
        bvVar.ijk = av.lmn().klm().klm();
        return bvVar;
    }

    public final EvtHeaderAttributeCollector getEvtCustomHeader(String str, JSONObject jSONObject) {
        return new bw(jSONObject, this.ijk, this.lmn);
    }

    public final Map<String, String> getHttpHeader(String str) {
        HashMap hashMap = new HashMap();
        if (dp.ghi(this.ikl.ghi)) {
            hashMap.put("x-hasdk-realtime", "true");
        }
        hashMap.put("x-hasdk-productid", this.ikl.f47867n.ikl);
        hashMap.put("x-hasdk-resourceid", this.ikl.f47867n.ijk);
        hashMap.put("x-hasdk-token", this.ikl.hij);
        hashMap.put("x-hasdk-clientid", this.ikl.f47867n.ghi);
        Map<String, String> map = av.lmn().lmn(this.lmn).klm;
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public final RomAttributeCollector getRomAttribute(String str) {
        if (this.klm == null) {
            this.klm = new bz();
            ax axVar = this.ikl;
            String str2 = axVar.lmn;
            if (TextUtils.isEmpty(str2)) {
                str2 = dp.klm();
                axVar.lmn = str2;
            }
            String str3 = Build.MANUFACTURER;
            String str4 = "unknown";
            if (str3 == null) {
                str3 = str4;
            }
            Point def = dp.def(axVar.ghi);
            int i11 = def.y;
            int i12 = def.x;
            bz bzVar = this.klm;
            bzVar.f47880b = str3;
            bzVar.f47881c = i11;
            bzVar.f47882d = i12;
            bzVar.lmn = dp.ikl();
            bz bzVar2 = this.klm;
            bzVar2.hij = axVar.klm;
            bzVar2.klm = str2;
            bzVar2.def = "hianalytics";
            bzVar2.cde = "Android";
            bzVar2.ghi = "6.9.0.302";
            String str5 = Build.MODEL;
            if (str5 != null) {
                str4 = str5;
            }
            bzVar2.ikl = str4;
            bzVar2.bcd = dp.fgh();
            this.klm.abc = dp.ijk();
            this.klm.ijk = axVar.ghi.getPackageName();
            this.klm.f47883e = ("HUAWEI".equals(str3) || "HONOR".equals(str3)) ? dp.lmn(axVar.ghi) : dp.klm(axVar.ghi);
        }
        String efg = dp.efg(this.ikl.ghi);
        String klm2 = dp.klm(this.ikl.ghi, this.ijk.getSite());
        bz bzVar3 = this.klm;
        ax axVar2 = this.ikl;
        bzVar3.f47884f = axVar2.efg;
        bzVar3.f47879a = efg;
        bzVar3.fgh = klm2;
        bzVar3.f47886h = axVar2.f47860g;
        bzVar3.f47887i = axVar2.f47863j;
        bzVar3.f47897s = dp.c(axVar2.ghi);
        if (Profile.Country.CN.equals(this.ijk.getSite())) {
            this.klm.f47885g = Boolean.valueOf(ikl());
        } else {
            this.klm.f47885g = null;
        }
        Context context = this.ikl.ghi;
        if (context != null) {
            this.klm.f47888j = dp.a(context);
            this.klm.f47889k = dp.hij();
            this.klm.f47890l = dp.ghi();
            ActivityManager activityManager = (ActivityManager) this.ikl.ghi.getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                this.klm.f47891m = dp.lmn(memoryInfo.totalMem);
                this.klm.f47892n = dp.lmn(memoryInfo.availMem);
            }
            this.klm.f47893o = dp.bcd(this.ikl.ghi);
            this.klm.f47894p = dp.abc(this.ikl.ghi);
            this.klm.f47895q = dp.b(this.ikl.ghi);
        }
        String klm3 = dv.klm(this.ikl.ghi, "global_v2", "firstRunTime", "");
        bz bzVar4 = this.klm;
        bzVar4.f47896r = klm3;
        bzVar4.B = dv.klm(this.ikl.ghi, "global_v2", "sig_flg", 0);
        this.klm.f47904z = lmn(klm3);
        this.klm.A = dp.fgh(this.ikl.ghi);
        this.klm.f47898t = dp.d(this.ikl.ghi);
        String str6 = this.ikl.ijk;
        if (TextUtils.isEmpty(str6)) {
            this.klm.efg = this.ikl.lmn();
        } else {
            this.klm.efg = str6;
        }
        if (Profile.Country.CN.equals(this.ijk.getSite())) {
            this.klm.f47899u = Integer.valueOf(dp.e(this.ikl.ghi));
            this.klm.f47902x = Boolean.valueOf(dp.h(this.ikl.ghi));
            this.klm.f47901w = Boolean.valueOf(dp.g(this.ikl.ghi));
            this.klm.f47900v = Integer.valueOf(dp.f(this.ikl.ghi));
            this.klm.f47903y = lmn();
        } else {
            bz bzVar5 = this.klm;
            bzVar5.f47899u = null;
            bzVar5.f47902x = null;
            bzVar5.f47901w = null;
            bzVar5.f47900v = null;
            bzVar5.f47903y = null;
        }
        return this.klm;
    }

    public final IConfig getServiceConfig() {
        return this.ikl.f47867n.klm(this.lmn);
    }

    public final List<String> getServiceTagsByElbHeader(String str) {
        ArrayList arrayList = new ArrayList();
        if (!"_openness_config_tag".equals(this.lmn) && !"APMS".equals(this.lmn)) {
            Map<String, b> lmn2 = b.lmn();
            if (lmn2.size() == 0) {
                return arrayList;
            }
            for (Map.Entry next : lmn2.entrySet()) {
                String str2 = (String) next.getKey();
                b bVar = (b) next.getValue();
                String str3 = av.lmn().lmn(this.lmn).klm.get("ha-sdk-service");
                if ((str3 == null ? false : str3.equals(av.lmn().lmn(str2).klm.get("ha-sdk-service"))) && str.equals(bVar.lmn)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public final Event getSpecialEvent(String str) {
        if (!"_openness_config_tag".equals(this.lmn)) {
            return null;
        }
        String klm2 = dv.klm(this.ikl.ghi, "stop_v2_1", "stop_event", "");
        if (TextUtils.isEmpty(klm2)) {
            return null;
        }
        try {
            dv.lmn(this.ikl.ghi, "stop_v2_1", new String[0]);
            JSONObject jSONObject = new JSONObject(klm2);
            Event event = new Event();
            event.formJson(jSONObject);
            return event;
        } catch (JSONException unused) {
            HiLog.w("OpennessCollectSettings", "event form json exception");
            return null;
        }
    }

    public final void handlerThrowable(Throwable th2) {
        dr.lmn(th2);
    }

    public final boolean isDebugModel() {
        return dp.ghi(this.ikl.ghi);
    }

    public final boolean isEnableSession(String str) {
        return true;
    }

    public final void serviceListener(boolean z11, IConfig iConfig) {
        if ("_openness_config_tag".equals(this.lmn)) {
            o oVar = av.lmn().lmn.f47854a;
            if (oVar == null) {
                o oVar2 = new o(cde.lmn().lmn(this.lmn));
                av.lmn().lmn.f47854a = oVar2;
                oVar = oVar2;
            }
            if (z11) {
                oVar.lmn();
            }
            oVar.lmn(iConfig);
        }
    }

    public final void setIConfig(IConfig iConfig) {
        this.ijk = iConfig;
    }

    public final void syncOaid() {
        aj.lmn(this.ikl.ghi, this.ijk);
    }
}
