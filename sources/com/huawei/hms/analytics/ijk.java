package com.huawei.hms.analytics;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.analytics.az;
import com.huawei.hms.analytics.bg;
import com.huawei.hms.analytics.c;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.framework.HAFrameworkInstance;
import com.huawei.hms.analytics.framework.config.ICollectorConfig;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.framework.config.RomAttributeCollector;
import com.instabug.library.model.State;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.wallet.features.UrlConstantsKt;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

@Instrumented
public abstract class ijk implements bl {
    public final ICollectorConfig ghi;
    public String hij;
    public Context ijk;
    bn ikl;
    protected HAFrameworkInstance.Builder klm;
    protected HAFrameworkInstance lmn;

    public class lmn {
        public lmn() {
        }

        public final void lmn() {
            ijk.this.lmn.clearCacheData("oper");
            ijk.this.ikl();
            dh.lmn().ikl(ijk.this.ijk);
            try {
                dh.lmn();
                dh.ijk();
            } catch (Exception unused) {
                HiLog.e("createInstance", "bindService error");
            }
            av.lmn().ikl().hij();
            av.lmn().klm().hij();
            ax axVar = av.lmn().lmn;
            axVar.bcd = "";
            axVar.f47858e = "";
            axVar.f47857d = "";
            axVar.cde = "";
            axVar.f47860g = "";
            axVar.f47874u = "";
            axVar.f47873t = "";
            axVar.f47872s = "";
            axVar.f47868o = "";
            axVar.f47869p = false;
            axVar.f47875v = "";
            axVar.f47876w = 0;
            axVar.f47870q = 0;
            dv.lmn(ijk.this.ijk, "global_v2", State.KEY_PUSH_TOKEN, "ab_info", "w_app_id", "api_channel", "camp_info", "is_new_user", "sig_flg", "is_cs_refr_run");
            ijk.this.lmn.setNeedRefreshSession(true);
            c lmn2 = c.lmn();
            lmn2.lmn.clear();
            lmn2.ikl.lmn();
            c.lmn lmn3 = lmn2.ijk;
            if (lmn3 != null) {
                lmn3.lmn();
            }
            lmn2.ghi = 0;
            lmn2.hij = null;
            lmn2.cde.clear();
            lmn2.bcd.clear();
            ijk.this.ikl("clearCachedData");
        }
    }

    public ijk(Context context, String str) {
        this.ijk = context;
        av.lmn().lmn.ghi = context;
        this.hij = str;
        this.ikl = bn.lmn(context);
        bu buVar = new bu(str);
        this.ghi = buVar;
        HAFrameworkInstance.Builder builder = new HAFrameworkInstance.Builder();
        this.klm = builder;
        builder.setStorageHandler(bh.lmn(context)).setStoragePolicy(new by(str)).setCollectorConfig(buVar).setMandatoryParameters(new bx());
    }

    private boolean ghi(String str) {
        az hij2 = hij();
        if (hij2 == null || !hij2.ghi) {
            return false;
        }
        List<az.klm> list = hij2.klm;
        if (list == null) {
            HiLog.d("createInstance", "camp stream evts is empty");
            return false;
        }
        for (az.klm next : list) {
            if (str.equals(next.lmn)) {
                if (lmn(System.currentTimeMillis(), next.klm)) {
                    return true;
                }
            }
        }
        return false;
    }

    private az hij() {
        IConfig klm2 = av.lmn().lmn.f47867n.klm(this.hij);
        if (klm2 == null) {
            return null;
        }
        az azVar = av.lmn().lmn.f47871r;
        long currentTimeMillis = System.currentTimeMillis();
        if (azVar == null) {
            azVar = ch.lmn(this.ijk);
            if (azVar == null) {
                ch.klm(this.ijk, klm2, currentTimeMillis);
                return null;
            }
            av.lmn().lmn.f47871r = azVar;
        }
        String site = klm2.getSite();
        if (!(!TextUtils.isEmpty(site) && site.equals(azVar.ijk))) {
            return null;
        }
        ch.klm(this.ijk, klm2, currentTimeMillis);
        return azVar;
    }

    private boolean hij(String str) {
        az hij2;
        az.lmn lmn2;
        if (!"_openness_config_tag".equals(this.hij) || (hij2 = hij()) == null || (lmn2 = hij2.hij) == null) {
            return false;
        }
        return lmn2.lmn.contains(str);
    }

    private boolean ijk() {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("createInstance", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return false;
        } else if (!klm(this.hij)) {
            return false;
        } else {
            return dv.lmn(this.ijk, "global_v2", "is_log");
        }
    }

    private boolean ijk(String str) {
        if (("_openness_config_tag".equals(this.hij) || aq.fgh.contains(this.hij)) && Profile.Country.CN.equals(av.lmn().lmn.f47867n.klm(this.hij).getSite())) {
            return ghi(str);
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void ikl(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        dv.lmn(this.ijk, "global_v2", "firstRunTime", String.valueOf(currentTimeMillis));
        Bundle bundle = new Bundle();
        bundle.putString("$StartType", "");
        bundle.putString("$OccurredType", str);
        ikl("$LaunchApp", new dt("$LaunchApp", bundle), System.currentTimeMillis());
        bundle.clear();
        bundle.putString("$StartType", "");
        bundle.putString("$OccurredType", str);
        bundle.putString("$InstallChannel", "");
        ikl("$AppFirstOpen", new dt("$AppFirstOpen", bundle), currentTimeMillis);
    }

    private void ikl(String str, dt dtVar, long j11) {
        lmn(str, dtVar.lmn, j11);
        if (dp.ghi(this.ijk)) {
            this.lmn.onStreamEvent("oper", dtVar.ikl, new ct(), j11);
        } else if (ijk(str)) {
            ct ctVar = new ct();
            ctVar.lmn = true;
            this.lmn.onStreamEvent("oper", dtVar.ikl, ctVar, j11);
        } else {
            this.lmn.onEventRecord("oper", dtVar.ikl, j11);
        }
    }

    private void ikl(List<JSONObject> list) {
        this.lmn.onEvent("oper", list, new ct());
    }

    private static boolean klm(String str) {
        if (be.lmn(str)) {
            return true;
        }
        HiLog.e("createInstance", "Stop report! Instance init failed: ".concat(String.valueOf(str)));
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean klm(java.lang.String r3, com.huawei.hms.analytics.dt r4) {
        /*
            r2 = this;
            java.lang.String r0 = "_openness_config_tag"
            java.lang.String r1 = r2.hij
            boolean r0 = r0.equals(r1)
            r1 = 1
            if (r0 != 0) goto L_0x001d
            int r3 = r3.length()
            r0 = 256(0x100, float:3.59E-43)
            if (r3 <= r0) goto L_0x0024
            java.lang.String r3 = "PE-002"
            java.lang.String r4 = " Length of eventId exceeds the limit. Max Length is 256."
            java.lang.String r0 = "instanceimpl"
        L_0x0019:
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r3, r4)
            return r1
        L_0x001d:
            boolean r3 = lmn((java.lang.String) r3)
            if (r3 != 0) goto L_0x0024
            return r1
        L_0x0024:
            android.os.Bundle r3 = r4.klm
            boolean r3 = r4.klm((android.os.Bundle) r3)
            if (r3 != 0) goto L_0x0033
            java.lang.String r3 = "PE-006"
            java.lang.String r4 = "bundle params is invalid."
            java.lang.String r0 = "createInstance"
            goto L_0x0019
        L_0x0033:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.ijk.klm(java.lang.String, com.huawei.hms.analytics.dt):boolean");
    }

    private static boolean lmn(long j11, List<az.ikl> list) {
        if (list == null) {
            return false;
        }
        for (az.ikl next : list) {
            if (next != null && j11 > next.lmn.longValue() && j11 < next.klm.longValue()) {
                return true;
            }
        }
        return false;
    }

    private static boolean lmn(String str) {
        String str2;
        String str3;
        if (str.length() > 256) {
            str2 = HiLog.ErrorCode.PE002;
            str3 = " Length of eventId exceeds the limit. Max Length is 256.";
        } else if (dl.lmn(UrlConstantsKt.WALLET_EVENT_ID, str, aq.klm)) {
            return true;
        } else {
            str2 = HiLog.ErrorCode.PE006;
            str3 = " eventId pattern error";
        }
        HiLog.w("instanceimpl", str2, str3);
        return false;
    }

    public final void ikl() {
        if (dv.lmn(this.ijk, "global_v2", "is_log")) {
            try {
                bi.lmn().ikl();
            } catch (bg.lmn unused) {
                HiLog.e("createInstance", "log db init failed");
            }
        }
    }

    public final void klm() {
        if (ijk()) {
            dg.ijk().lmn(new cw(av.lmn().lmn.f47867n.klm(this.hij), false));
        }
    }

    public final void klm(long j11) {
        this.lmn.onBackground(j11);
    }

    public final void klm(IConfig iConfig) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("createInstance", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            try {
                bh.lmn(this.ijk).deleteByTag(this.hij);
            } catch (bg.lmn unused) {
                HiLog.e("createInstance", "delete db exception");
            }
            if (av.lmn().lmn.f47854a != null) {
                av.lmn().lmn.f47854a.lmn();
                return;
            }
            return;
        }
        this.lmn.onReport(iConfig, "oper", new ct());
    }

    public final void klm(String str, dt dtVar, long j11) {
        bn.klm().lmn(this.hij, "oper", str, dtVar.lmn);
        bn.lmn().lmn(str, dtVar.lmn);
        ct ctVar = new ct();
        ctVar.lmn = true;
        this.lmn.onStreamEvent("oper", dtVar.ikl, ctVar, j11);
    }

    public final void klm(List<Event> list) {
        this.lmn.onEvent(list, new ct());
    }

    public final void klm(boolean z11) {
        av.lmn().lmn.f47876w = 0;
        this.lmn.clearCacheData("oper");
        ikl();
        dv.lmn(this.ijk, "global_v2", "is_new_user");
        this.lmn.setNeedRefreshSession(true);
        if (z11) {
            ikl("aaidReset");
        }
        try {
            dh.lmn();
            dh.ijk();
        } catch (Exception unused) {
            HiLog.e("createInstance", "bindService error");
        }
    }

    public Map<String, String> lmn(boolean z11) {
        HashMap hashMap = new HashMap();
        if (!z11) {
            return dm.klm(av.lmn().klm().lmn());
        }
        try {
            RomAttributeCollector romAttribute = this.ghi.getRomAttribute("oper");
            return romAttribute != null ? dm.lmn(romAttribute.doCollector()) : hashMap;
        } catch (Throwable th2) {
            HiLog.w("createInstance", "get rom attribute exception");
            dr.lmn(th2);
            return hashMap;
        }
    }

    public final void lmn() {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("createInstance", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
        } else if (klm(this.hij)) {
            this.lmn.onReport("oper", new ct());
        }
    }

    public final void lmn(long j11) {
        this.lmn.onForeground(j11);
    }

    public final void lmn(IConfig iConfig) {
        if (ijk()) {
            dg.ijk().lmn(new cw(iConfig, true));
        }
    }

    public final void lmn(IConfig iConfig, List<Event> list) {
        this.lmn.onReport(iConfig, "oper", list, new ct());
    }

    public final void lmn(IConfig iConfig, Map<String, dt> map) {
        Set<Map.Entry<String, dt>> entrySet = map.entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : entrySet) {
            String str = (String) next.getKey();
            dt dtVar = (dt) next.getValue();
            bn.klm().lmn(this.hij, "oper", str, dtVar.lmn);
            bn.lmn().lmn(str, dtVar.lmn);
            arrayList.addAll(dtVar.ikl);
        }
        ct ctVar = new ct();
        ctVar.klm = false;
        this.lmn.onReport(iConfig, "oper", arrayList, ctVar);
    }

    public final void lmn(String str, Bundle bundle, long j11) {
        if (dp.ghi(this.ijk)) {
            bn.klm().lmn(this.hij, "oper", str, bundle, j11);
        } else {
            bn.klm().lmn(this.hij, "oper", str, bundle);
        }
        bn.lmn().lmn(str, bundle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        if (r8 == false) goto L_0x00b1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lmn(java.lang.String r13, com.huawei.hms.analytics.dt r14) {
        /*
            r12 = this;
            java.lang.String r0 = "varid"
            java.lang.String r1 = "abtaskId"
            android.os.Bundle r2 = r14.klm
            java.lang.String r3 = "$JoinABTask"
            boolean r3 = r3.equals(r13)
            r4 = 1
            if (r3 == 0) goto L_0x00b1
            java.lang.String r3 = "is joinABTask event"
            java.lang.String r5 = "ABTskIdHolder"
            com.huawei.hms.analytics.core.log.HiLog.d(r5, r3)
            java.lang.String r3 = "$ABTaskId"
            java.lang.String r3 = r2.getString(r3)
            java.lang.String r6 = "$ABVarId"
            java.lang.String r2 = r2.getString(r6)
            r6 = 256(0x100, float:3.59E-43)
            boolean r7 = com.huawei.hms.analytics.dl.lmn((java.lang.String) r3, (int) r6)
            if (r7 == 0) goto L_0x00b1
            boolean r6 = com.huawei.hms.analytics.dl.lmn((java.lang.String) r2, (int) r6)
            if (r6 == 0) goto L_0x00b1
            org.json.JSONArray r6 = com.huawei.hms.analytics.ba.lmn()
            int r7 = r6.length()     // Catch:{ JSONException -> 0x0061 }
            r8 = 0
            r9 = r8
        L_0x003a:
            if (r9 >= r7) goto L_0x005d
            org.json.JSONObject r10 = r6.getJSONObject(r9)     // Catch:{ JSONException -> 0x0061 }
            java.lang.String r11 = r10.getString(r1)     // Catch:{ JSONException -> 0x0061 }
            boolean r11 = r3.equals(r11)     // Catch:{ JSONException -> 0x0061 }
            if (r11 == 0) goto L_0x005a
            java.lang.String r10 = r10.getString(r0)     // Catch:{ JSONException -> 0x0061 }
            boolean r10 = r2.equals(r10)     // Catch:{ JSONException -> 0x0061 }
            if (r10 == 0) goto L_0x005a
            java.lang.String r7 = "Duplicate AB attributes exist in the cache."
            com.huawei.hms.analytics.core.log.HiLog.w(r5, r7)     // Catch:{ JSONException -> 0x0061 }
            goto L_0x005e
        L_0x005a:
            int r9 = r9 + 1
            goto L_0x003a
        L_0x005d:
            r8 = r4
        L_0x005e:
            if (r8 != 0) goto L_0x0066
            goto L_0x00b1
        L_0x0061:
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>()
        L_0x0066:
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r3 = r3.trim()     // Catch:{ JSONException -> 0x00ac }
            r7.put((java.lang.String) r1, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x00ac }
            java.lang.String r1 = r2.trim()     // Catch:{ JSONException -> 0x00ac }
            r7.put((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x00ac }
            int r0 = r6.length()     // Catch:{ JSONException -> 0x00ac }
            r1 = 25
            if (r0 < r1) goto L_0x008d
            org.json.JSONArray r0 = com.huawei.hms.analytics.ba.lmn(r6)     // Catch:{ JSONException -> 0x00ac }
            r0.put((java.lang.Object) r7)     // Catch:{ JSONException -> 0x00ac }
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x00ac }
            goto L_0x0094
        L_0x008d:
            r6.put((java.lang.Object) r7)     // Catch:{ JSONException -> 0x00ac }
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation.toString(r6)     // Catch:{ JSONException -> 0x00ac }
        L_0x0094:
            com.huawei.hms.analytics.av r1 = com.huawei.hms.analytics.av.lmn()     // Catch:{ JSONException -> 0x00ac }
            com.huawei.hms.analytics.ax r1 = r1.lmn     // Catch:{ JSONException -> 0x00ac }
            r1.f47860g = r0     // Catch:{ JSONException -> 0x00ac }
            com.huawei.hms.analytics.av r1 = com.huawei.hms.analytics.av.lmn()     // Catch:{ JSONException -> 0x00ac }
            com.huawei.hms.analytics.ax r1 = r1.lmn     // Catch:{ JSONException -> 0x00ac }
            android.content.Context r1 = r1.ghi     // Catch:{ JSONException -> 0x00ac }
            java.lang.String r2 = "global_v2"
            java.lang.String r3 = "ab_info"
            com.huawei.hms.analytics.dv.lmn((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r0)     // Catch:{ JSONException -> 0x00ac }
            goto L_0x00b1
        L_0x00ac:
            java.lang.String r0 = "put abtaskid json exception"
            com.huawei.hms.analytics.core.log.HiLog.w(r5, r0)
        L_0x00b1:
            boolean r0 = r12.hij(r13)
            if (r0 == 0) goto L_0x00c7
            java.lang.String r13 = java.lang.String.valueOf(r13)
            java.lang.String r14 = "The event is disabled : "
            java.lang.String r13 = r14.concat(r13)
            java.lang.String r14 = "createInstance"
            com.huawei.hms.analytics.core.log.HiLog.w(r14, r13)
            return
        L_0x00c7:
            android.content.Context r0 = r12.ijk
            boolean r0 = com.huawei.hms.analytics.dp.ghi(r0)
            if (r0 == 0) goto L_0x0103
            long r10 = java.lang.System.currentTimeMillis()
            com.huawei.hms.analytics.bo r5 = com.huawei.hms.analytics.bn.lmn()
            java.lang.String r6 = r12.hij
            java.lang.String r7 = "oper"
            android.os.Bundle r9 = r14.klm
            r8 = r13
            boolean r0 = r5.lmn(r6, r7, r8, r9, r10)
            if (r0 != 0) goto L_0x0102
            boolean r0 = r12.klm(r13, r14)
            if (r0 == 0) goto L_0x00eb
            return
        L_0x00eb:
            com.huawei.hms.analytics.bq r1 = com.huawei.hms.analytics.bn.klm()
            java.lang.String r2 = r12.hij
            java.lang.String r3 = "oper"
            android.os.Bundle r5 = r14.lmn
            long r6 = java.lang.System.currentTimeMillis()
            r4 = r13
            r1.lmn(r2, r3, r4, r5, r6)
            java.util.ArrayList<org.json.JSONObject> r13 = r14.ikl
            r12.lmn((java.util.List<org.json.JSONObject>) r13)
        L_0x0102:
            return
        L_0x0103:
            com.huawei.hms.analytics.bo r0 = com.huawei.hms.analytics.bn.lmn()
            java.lang.String r1 = r12.hij
            android.os.Bundle r2 = r14.klm
            java.lang.String r3 = "oper"
            boolean r0 = r0.lmn(r1, r3, r13, r2)
            if (r0 != 0) goto L_0x013f
            boolean r0 = r12.klm(r13, r14)
            if (r0 == 0) goto L_0x011a
            return
        L_0x011a:
            com.huawei.hms.analytics.bq r0 = com.huawei.hms.analytics.bn.klm()
            java.lang.String r1 = r12.hij
            android.os.Bundle r2 = r14.lmn
            r0.lmn(r1, r3, r13, r2)
            boolean r13 = r12.ijk(r13)
            if (r13 == 0) goto L_0x013a
            com.huawei.hms.analytics.ct r13 = new com.huawei.hms.analytics.ct
            r13.<init>()
            r13.lmn = r4
            com.huawei.hms.analytics.framework.HAFrameworkInstance r0 = r12.lmn
            java.util.ArrayList<org.json.JSONObject> r14 = r14.ikl
            r0.onStreamEvent(r3, r14, r13)
            return
        L_0x013a:
            java.util.ArrayList<org.json.JSONObject> r13 = r14.ikl
            r12.ikl((java.util.List<org.json.JSONObject>) r13)
        L_0x013f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.ijk.lmn(java.lang.String, com.huawei.hms.analytics.dt):void");
    }

    public final void lmn(String str, dt dtVar, long j11) {
        if (hij(str)) {
            HiLog.w("createInstance", "The event is disabled : ".concat(String.valueOf(str)));
        } else if (dp.ghi(this.ijk)) {
            long j12 = j11;
            bn.klm().lmn(this.hij, "oper", str, dtVar.lmn, j12);
            bn.lmn().lmn(str, dtVar.lmn);
            this.lmn.onStreamEvent("oper", dtVar.ikl, new ct(), j12);
        } else {
            bn.klm().lmn(this.hij, "oper", str, dtVar.lmn);
            bn.lmn().lmn(str, dtVar.lmn);
            if (ijk(str)) {
                ct ctVar = new ct();
                ctVar.lmn = true;
                this.lmn.onStreamEvent("oper", dtVar.ikl, ctVar, j11);
                return;
            }
            this.lmn.onEvent("oper", dtVar.ikl, new ct(), j11);
        }
    }

    public final void lmn(String str, List<JSONObject> list) {
        if (ijk(str)) {
            lmn(list);
        } else {
            ikl(list);
        }
    }

    public final void lmn(List<JSONObject> list) {
        this.lmn.onStreamEvent("oper", list, new ct());
    }
}
