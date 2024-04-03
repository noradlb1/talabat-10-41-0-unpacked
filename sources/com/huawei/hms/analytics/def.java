package com.huawei.hms.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.analytics.c;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.ijk;
import com.huawei.hms.analytics.k;
import com.huawei.hms.analytics.type.HALogConfig;
import com.huawei.hms.analytics.type.HAParamType;
import com.huawei.hms.analytics.type.ReportPolicy;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.visa.checkout.Profile;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class def extends ijk implements bm {
    private k fgh;

    public def(Context context) {
        super(context, "_openness_config_tag");
        this.lmn = this.klm.build(this.hij);
    }

    private void def() {
        if (this.fgh == null) {
            this.fgh = new k(this.ijk);
        }
        try {
            this.fgh.lmn.lmn().addOnFailureListener(new k.lmn()).addOnSuccessListener(new k.klm());
        } catch (Exception unused) {
            HiLog.w("instanceimpl", "observableManager Exception");
        }
    }

    private void def(boolean z11) {
        if (Profile.Country.CN.equals(av.lmn().lmn.f47867n.lmn(this.hij))) {
            av.lmn().lmn.def = z11;
            dv.lmn(this.ijk, "global_v2", "is_restriction_shared", z11);
        }
    }

    private void efg(boolean z11) {
        dv.lmn(this.ijk, "stop_v2_1", "stop_event");
        dt dtVar = new dt("$StopAnalyticsCollection", new Bundle());
        ct ctVar = new ct();
        ctVar.setStopEventReport(true);
        ctVar.klm = z11;
        this.lmn.onStreamEvent("oper", dtVar.ikl, ctVar);
    }

    public final String efg() {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return "";
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#getDataUploadSiteInfo");
        IConfig klm = av.lmn().lmn.f47867n.klm(this.hij);
        if (klm != null) {
            lmn.lmn = "0";
            ck.lmn(lmn);
            return klm.getSite();
        }
        ck.lmn(lmn);
        return "";
    }

    public final void efg(String str) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#setCustomReferrer");
        if (!dl.lmn(str, 256)) {
            HiLog.w("instanceimpl", "Custom referrer check failed");
            ck.lmn(lmn);
            return;
        }
        new cz(this).lmn(new cy(str));
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    public final Task<String> fgh() {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return null;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#getAAID()");
        try {
            Task<String> ikl = dh.lmn().ikl();
            lmn.lmn = "0";
            return ikl;
        } finally {
            ck.lmn(lmn);
        }
    }

    public final void fgh(String str) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#setChannel(String))");
        ax axVar = av.lmn().lmn;
        if (!TextUtils.isEmpty(axVar.ijk)) {
            HiLog.w("instanceimpl", "channel already exists in manifest file");
            ck.lmn(lmn);
        } else if (!TextUtils.isEmpty(axVar.lmn())) {
            HiLog.w("instanceimpl", "duplicate set,channel already exists");
            ck.lmn(lmn);
        } else {
            String lmn2 = dp.lmn(str);
            if (!TextUtils.isEmpty(lmn2)) {
                dv.lmn(this.ijk, "global_v2", "api_channel", lmn2);
                axVar.f47875v = lmn2;
                lmn.lmn = "0";
            }
            ck.lmn(lmn);
        }
    }

    public final void fgh(boolean z11) {
        cj lmn = ck.lmn("HiAnalyticsInstance#setPushTokenCollectionEnabled(boolean))");
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        ax axVar = av.lmn().lmn;
        if (!Profile.Country.CN.equals(axVar.f47867n.lmn(this.hij))) {
            HiLog.w("instanceimpl", "only available in China region");
            ck.lmn(lmn);
            return;
        }
        dv.lmn(this.ijk, "global_v2", "push_token_collection_enable", z11);
        axVar.f47877x = z11;
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    public final void ghi() {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#clearCachedData()");
        try {
            new ijk.lmn().lmn();
            lmn.lmn = "0";
        } catch (Exception e11) {
            HiLog.w("instanceimpl", "reset analytics exception: " + e11.getMessage());
        }
        ck.lmn(lmn);
    }

    public final void ghi(String str) {
        cj lmn = ck.lmn("HiAnalyticsInstance#setPushToken(String)");
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
        } else if (!av.lmn().lmn.f47877x) {
            HiLog.w("instanceimpl", "push token switch is disabled");
            ck.lmn(lmn);
        } else if (!dl.lmn(str, 256)) {
            HiLog.w("instanceimpl", "push token check failed");
            ck.lmn(lmn);
        } else {
            String str2 = av.lmn().lmn.f47868o;
            if (!TextUtils.isEmpty(str2) && !str2.equals(str)) {
                av.lmn().lmn.f47869p = false;
            }
            av.lmn().lmn.f47868o = str;
            lmn.lmn = "0";
            ck.lmn(lmn);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0079, code lost:
        if (r8 == false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ghi(boolean r8) {
        /*
            r7 = this;
            com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r0 = r0.lmn
            boolean r0 = r0.fgh
            java.lang.String r1 = "instanceimpl"
            if (r0 != r8) goto L_0x001a
            java.lang.String r0 = "The collection status is the same. isEnableAnalytics: "
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r8 = r0.concat(r8)
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r8)
            return
        L_0x001a:
            java.lang.String r0 = "HiAnalyticsInstance#setAnalyticsEnabled(boolean)"
            com.huawei.hms.analytics.cj r0 = com.huawei.hms.analytics.ck.lmn((java.lang.String) r0)
            com.huawei.hms.analytics.av r2 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r2 = r2.lmn
            r2.fgh = r8
            android.content.Context r2 = r7.ijk
            java.lang.String r3 = "is_analytics_enabled"
            java.lang.String r4 = "global_v2"
            com.huawei.hms.analytics.dv.lmn((android.content.Context) r2, (java.lang.String) r4, (java.lang.String) r3, (boolean) r8)
            android.content.Context r2 = r7.ijk
            java.lang.String r3 = "is_restriction_enabled"
            boolean r2 = com.huawei.hms.analytics.dv.lmn((android.content.Context) r2, (java.lang.String) r4, (java.lang.String) r3)
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x006f
            if (r8 != 0) goto L_0x005d
            com.huawei.hms.analytics.av r2 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r2 = r2.lmn
            boolean r2 = r2.efg
            if (r2 != 0) goto L_0x005d
            com.huawei.hms.analytics.av r2 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r2 = r2.lmn
            r2.efg = r6
            android.content.Context r2 = r7.ijk
            com.huawei.hms.analytics.dv.lmn((android.content.Context) r2, (java.lang.String) r4, (java.lang.String) r3, (boolean) r6)
        L_0x0056:
            r7.efg((boolean) r5)
            r7.def(r6)
            goto L_0x007c
        L_0x005d:
            if (r8 != 0) goto L_0x007c
            com.huawei.hms.analytics.av r2 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r2 = r2.lmn
            boolean r2 = r2.efg
            if (r2 == 0) goto L_0x007c
            java.lang.String r2 = "The stop event has been reported."
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r2)
            goto L_0x007c
        L_0x006f:
            com.huawei.hms.analytics.av r2 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r2 = r2.lmn
            r3 = r8 ^ 1
            r2.efg = r3
            if (r8 != 0) goto L_0x007c
            goto L_0x0056
        L_0x007c:
            r7.def()
            java.lang.String r2 = "0"
            r0.lmn = r2
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r0)
            java.lang.String r0 = "The collection status is the differ. isEnableAnalytics: "
            java.lang.String r2 = java.lang.String.valueOf(r8)
            java.lang.String r0 = r0.concat(r2)
            com.huawei.hms.analytics.core.log.HiLog.i(r1, r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r1 = "analyticsEnabled"
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            r0.put(r1, r8)
            com.huawei.hms.analytics.bo r8 = com.huawei.hms.analytics.bn.lmn()
            r8.lmn((java.util.Map<java.lang.Object, java.lang.Object>) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.def.ghi(boolean):void");
    }

    public final void hij(String str) {
        String str2;
        String str3;
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#setUserId(String)");
        Context context = this.ijk;
        if (str == null) {
            eb.lmn(context, 0);
        } else {
            if (str.isEmpty()) {
                str2 = HiLog.ErrorCode.PE001;
                str3 = "UserId is empty";
            } else if (str.length() > 256) {
                str2 = HiLog.ErrorCode.PE002;
                str3 = "Length of userId exceeds the limit";
            } else {
                eb.lmn(context, 1);
                String str4 = av.lmn().lmn.bcd;
                if (!TextUtils.isEmpty(str4) && !str4.equals(str)) {
                    this.lmn.setNeedRefreshSession(true);
                }
                av.lmn().lmn.bcd = str;
                lmn.lmn = "0";
                ck.lmn(lmn);
            }
            HiLog.w("UserIdHandler", str2, str3);
        }
        str = "";
        String str42 = av.lmn().lmn.bcd;
        this.lmn.setNeedRefreshSession(true);
        av.lmn().lmn.bcd = str;
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    public final void hij(boolean z11) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        boolean z12 = av.lmn().lmn.efg;
        av.lmn().lmn.efg = z11;
        dv.lmn(this.ijk, "global_v2", "is_restriction_enabled", z11);
        if (z11 == z12) {
            HiLog.w("instanceimpl", "The enabled status is the same. isRestriction: ".concat(String.valueOf(z11)));
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#setRestrictionEnabled(boolean)");
        if (z11) {
            efg(true);
            def(z11);
        }
        def();
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    /* JADX INFO: finally extract failed */
    public final boolean hij() {
        cj lmn = ck.lmn("HiAnalyticsInstance#isRestrictionShared");
        try {
            ax axVar = av.lmn().lmn;
            if (!Profile.Country.CN.equals(axVar.f47867n.lmn(this.hij))) {
                HiLog.w("instanceimpl", "Region is not CN. This api does not take effect");
                lmn.lmn = "0";
                ck.lmn(lmn);
                return true;
            }
            boolean z11 = axVar.def;
            lmn.lmn = "0";
            ck.lmn(lmn);
            return z11;
        } catch (Throwable th2) {
            lmn.lmn = "0";
            ck.lmn(lmn);
            throw th2;
        }
    }

    public final void ijk(long j11) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#setSessionDuration(long)");
        this.lmn.setSessionTimeoutDuration(dl.lmn(AnalyticsAttribute.SESSION_DURATION_ATTRIBUTE, j11));
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    public final void ijk(String str) {
        String str2;
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#pageEnd(String)");
        if (!dl.lmn(str, 256)) {
            HiLog.w("instanceimpl", "pageEnd: pageName check failed");
            ck.lmn(lmn);
            return;
        }
        c lmn2 = c.lmn();
        long currentTimeMillis = System.currentTimeMillis();
        HiLog.d("ActivityStatCommander", "onPageExit " + str + " with time: " + currentTimeMillis);
        c.lmn lmn3 = lmn2.lmn.get(str);
        if (lmn3 == null) {
            str2 = "onPageEnter should be invoked first.";
        } else {
            long j11 = lmn3.ijk;
            long j12 = 0;
            if (j11 == 0) {
                str2 = "timestamp is 0.";
            } else {
                lmn2.hij = lmn3;
                lmn2.ghi = currentTimeMillis;
                Bundle bundle = new Bundle();
                bundle.putString("$CurActivityName", lmn3.lmn);
                bundle.putString("$CurActivityClass", lmn3.klm);
                bundle.putString("$CurActivityId", lmn3.ikl);
                bundle.putString("$PrePageId", lmn2.bcd.getString("$PrevActivityClass", ""));
                bundle.putString("$CurrPageId", lmn3.klm);
                HiLog.d("ActivityStatCommander", "onPageExit duration cal: 1. " + currentTimeMillis + " 2. " + j11);
                bundle.putString(HAParamType.DURATION, String.valueOf(Math.min(currentTimeMillis - j11, 604800000)));
                HiLog.i("ActivityStatCommander", "onPageExit: send ScreenExit event...");
                lmn2.def.lmn("$ExitScreen", new dt("$ExitScreen", bundle), currentTimeMillis);
                if (lmn2.ijk.lmn.equals(str)) {
                    if (lmn2.lmn.size() > 1) {
                        for (Map.Entry next : lmn2.lmn.entrySet()) {
                            String str3 = (String) next.getKey();
                            c.lmn lmn4 = lmn2.lmn.get(str3);
                            if (!str.equals(str3) && lmn4 != null) {
                                long j13 = lmn4.ijk;
                                if (j13 > j12) {
                                    lmn2.ijk = lmn2.lmn.get(next.getKey());
                                    j12 = j13;
                                }
                            }
                        }
                    } else {
                        lmn2.ijk = null;
                    }
                }
                lmn2.lmn.remove(str);
                lmn.lmn = "0";
                ck.lmn(lmn);
            }
        }
        HiLog.w("ActivityStatCommander", str2);
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    public final void ijk(boolean z11) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#setRestrictionShared");
        try {
            ax axVar = av.lmn().lmn;
            if (!Profile.Country.CN.equals(axVar.f47867n.lmn(this.hij))) {
                HiLog.w("instanceimpl", "Region is not CN. This api does not take effect");
            } else if (axVar.efg) {
                HiLog.w("instanceimpl", "Restriction enabled, setRestrictionShared failed");
                lmn.lmn = "0";
                ck.lmn(lmn);
            } else if (z11 == axVar.def) {
                HiLog.w("instanceimpl", "The enabled status is the same.");
                lmn.lmn = "0";
                ck.lmn(lmn);
            } else {
                axVar.def = z11;
                def();
                dv.lmn(this.ijk, "global_v2", "is_restriction_shared", z11);
                lmn.lmn = "0";
                ck.lmn(lmn);
            }
        } finally {
            lmn.lmn = "0";
            ck.lmn(lmn);
        }
    }

    public final boolean ijk() {
        cj lmn = ck.lmn("HiAnalyticsInstance#isRestrictionEnabled");
        lmn.lmn = "0";
        ck.lmn(lmn);
        return av.lmn().lmn.efg;
    }

    public final void ikl(long j11) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#setMinActivitySessions(long)");
        this.lmn.setMinSessionDuration(dl.lmn("minActivitySessions", j11));
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    public final void ikl(String str) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
        } else if (!Profile.Country.CN.equals(av.lmn().lmn.f47867n.lmn(this.hij))) {
            HiLog.w("instanceimpl", "Region is not CN. This api does not take effect");
        } else {
            cj lmn = ck.lmn("HiAnalyticsInstance#setWXAppId");
            if (!dl.lmn(str, 256)) {
                av.lmn().lmn.f47874u = "";
                dv.lmn(this.ijk, "global_v2", "w_app_id", "");
                ck.lmn(lmn);
                return;
            }
            av.lmn().lmn.f47874u = str;
            dv.lmn(this.ijk, "global_v2", "w_app_id", str);
            lmn.lmn = "0";
            ck.lmn(lmn);
        }
    }

    public final void ikl(boolean z11) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#setCollectAdsIdEnabled");
        if (av.lmn().lmn.f47864k != z11) {
            av.lmn().lmn.f47864k = z11;
            dv.lmn(this.ijk, "global_v2", "is_enabled_adsid", z11);
        }
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    public final void klm(String str) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
        } else if (!Profile.Country.CN.equals(av.lmn().lmn.f47867n.lmn(this.hij))) {
            HiLog.w("instanceimpl", "Region is not CN. This api does not take effect");
        } else {
            cj lmn = ck.lmn("HiAnalyticsInstance#setWXOpenId");
            if (!dl.lmn(str, 256)) {
                av.lmn().lmn.f47873t = "";
                ck.lmn(lmn);
                return;
            }
            av.lmn().lmn.f47873t = str;
            lmn.lmn = "0";
            ck.lmn(lmn);
        }
    }

    public final void klm(String str, String str2) {
        c.lmn lmn;
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn2 = ck.lmn("HiAnalyticsInstance#pageStart(String,String)");
        if (!dl.lmn(str, 256) || !dl.lmn(str2, 256)) {
            HiLog.w("instanceimpl", "pageStart: pageName or pageClassOverride check failed");
            ck.lmn(lmn2);
        } else if (c.lmn().ikl.lmn.equals(str)) {
            HiLog.w("instanceimpl", "pageStart: pageName cannot be equals to previous pageName");
            ck.lmn(lmn2);
        } else {
            c lmn3 = c.lmn();
            Bundle bundle = new Bundle();
            long currentTimeMillis = System.currentTimeMillis();
            HiLog.d("ActivityStatCommander", "onScreenEnter with time: ".concat(String.valueOf(currentTimeMillis)));
            c.lmn lmn4 = new c.lmn(str, str2, "", currentTimeMillis);
            lmn3.lmn.put(str, lmn4);
            HiLog.d("ActivityStatCommander", "onPageEnterSend");
            c.lmn lmn5 = lmn3.ijk;
            if (lmn5 == null) {
                bundle.putString("$PrevActivityName", lmn3.ikl.lmn);
                bundle.putString("$PrevActivityClass", lmn3.ikl.klm);
                bundle.putString("$PrevActivityId", lmn3.ikl.ikl);
                lmn3.bcd.putString("$PrevActivityClass", lmn3.ikl.klm);
                lmn = lmn3.ikl;
            } else {
                bundle.putString("$PrevActivityName", lmn5.lmn);
                bundle.putString("$PrevActivityClass", lmn3.ijk.klm);
                bundle.putString("$PrevActivityId", lmn3.ijk.ikl);
                lmn3.bcd.putString("$PrevActivityClass", lmn3.ijk.klm);
                lmn = lmn3.ijk;
            }
            bundle.putString("$PrePageId", lmn.klm);
            bundle.putString("$CurActivityName", lmn4.lmn);
            bundle.putString("$CurActivityClass", lmn4.klm);
            bundle.putString("$CurActivityId", lmn4.ikl);
            lmn3.bcd.putString("$CurActivityClass", lmn4.klm);
            bundle.putString("$CurrPageId", lmn4.klm);
            lmn3.ijk = lmn4;
            lmn3.def.lmn("$EnterScreen", new dt("$EnterScreen", bundle), currentTimeMillis);
            lmn2.lmn = "0";
            ck.lmn(lmn2);
        }
    }

    public final Map<String, String> lmn(boolean z11) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return new HashMap();
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#getUserProfiles(boolean)");
        Map<String, String> lmn2 = super.lmn(z11);
        if (lmn2 == null) {
            try {
                return new HashMap();
            } finally {
                if ("_openness_config_tag".equals(this.hij)) {
                    ck.lmn(lmn);
                }
            }
        } else {
            lmn.lmn = "0";
            if ("_openness_config_tag".equals(this.hij)) {
                ck.lmn(lmn);
            }
            return lmn2;
        }
    }

    public final void lmn(Activity activity, String str, String str2) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#setCurrentActivity(Activity,String,String))");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (activity != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        str2 = activity.getClass().getCanonicalName();
                    }
                    String str3 = str2;
                    if (!dl.lmn(str, 256)) {
                        ck.lmn(lmn);
                        return;
                    } else if (!dl.lmn(str3, 256)) {
                        ck.lmn(lmn);
                        return;
                    } else {
                        c.lmn().lmn(currentTimeMillis);
                        Bundle bundle = new Bundle();
                        c lmn2 = c.lmn();
                        HiLog.d("ActivityStatCommander", "onScreenEnter with time: ".concat(String.valueOf(currentTimeMillis)));
                        lmn2.lmn(new c.lmn(str, str3, String.valueOf(activity.getTaskId()), currentTimeMillis), bundle, currentTimeMillis);
                        lmn.lmn = "0";
                        ck.lmn(lmn);
                        return;
                    }
                }
            }
            HiLog.w("instanceimpl", HiLog.ErrorCode.PE001, " activity is null,or screenName is null");
        } finally {
            ck.lmn(lmn);
        }
    }

    public final void lmn(Intent intent) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#onNewIntent");
        if (intent == null) {
            HiLog.w("instanceimpl", "new intent is null");
            ck.lmn(lmn);
            return;
        }
        j.lmn(this.ijk, new cb(intent.getExtras()));
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    public final void lmn(Bundle bundle) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#addDefaultEventParameters(Bundle)");
        try {
            av.lmn().ikl().lmn(bundle);
            lmn.lmn = "0";
            ck.lmn(lmn);
        } catch (Exception unused) {
            ck.lmn(lmn);
        }
    }

    public final void lmn(HALogConfig hALogConfig, String str) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#writeLog");
        String region = hALogConfig.getRegion();
        String projectId = hALogConfig.getProjectId();
        String logGroupId = hALogConfig.getLogGroupId();
        String logStreamId = hALogConfig.getLogStreamId();
        if (!dl.lmn(region, 128) || !dl.lmn(projectId, 128) || !dl.lmn(logGroupId, 128) || !dl.lmn(logStreamId, 128)) {
            HiLog.e("instanceimpl", "The logConfigure parameter is invalid.");
            ck.lmn(lmn);
            return;
        }
        if (!dl.lmn(str, 4096)) {
            str = str.substring(0, 4096);
        }
        hALogConfig.setTags(dl.lmn(hALogConfig.getTags()));
        dg.ijk().lmn(new cv(hALogConfig, "$WriteLog", str));
        Context context = this.ijk;
        if (!dv.lmn(context, "global_v2", "is_log")) {
            dv.lmn(context, "global_v2", "is_log", true);
        }
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    public final void lmn(String str) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
        } else if (!Profile.Country.CN.equals(av.lmn().lmn.f47867n.lmn(this.hij))) {
            HiLog.w("instanceimpl", "Region is not CN. This api does not take effect");
        } else {
            cj lmn = ck.lmn("HiAnalyticsInstance#setWXUnionId");
            if (!dl.lmn(str, 256)) {
                av.lmn().lmn.f47872s = "";
                ck.lmn(lmn);
                return;
            }
            av.lmn().lmn.f47872s = str;
            lmn.lmn = "0";
            ck.lmn(lmn);
        }
    }

    public final void lmn(String str, Bundle bundle) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#onEvent(String,Bundle)");
        try {
            if (TextUtils.isEmpty(str)) {
                HiLog.w("instanceimpl", HiLog.ErrorCode.PE001, " eventId is empty");
                if ("_openness_config_tag".equals(this.hij)) {
                    lmn.ijk = "";
                    ck.lmn(lmn);
                }
            } else if (dl.lmn(str, ar.lmn)) {
                HiLog.e("instanceimpl", HiLog.ErrorCode.PE004, str + " is reserved.");
                if ("_openness_config_tag".equals(this.hij)) {
                    lmn.ijk = str;
                    ck.lmn(lmn);
                }
            } else if (!dl.lmn(str, bundle)) {
                dt dtVar = new dt(str, true);
                String klm = av.lmn().ikl().klm();
                if (!TextUtils.isEmpty(klm)) {
                    dtVar.ijk = new JSONObject(klm);
                }
                if (bundle == null) {
                    HiLog.w("instanceimpl", "bundle is null");
                    bundle = new Bundle();
                }
                dtVar.ikl(bundle);
                lmn(str, dtVar);
                a.lmn(av.lmn().lmn.f47867n.klm(this.hij).getSite());
                lmn.lmn = "0";
                if ("_openness_config_tag".equals(this.hij)) {
                    lmn.ijk = str;
                    ck.lmn(lmn);
                }
            } else if ("_openness_config_tag".equals(this.hij)) {
                lmn.ijk = str;
                ck.lmn(lmn);
            }
        } catch (JSONException unused) {
            HiLog.w("P_CEvtHandler", "defEvtJson exception");
        } catch (Throwable th2) {
            if ("_openness_config_tag".equals(this.hij)) {
                lmn.ijk = str;
                ck.lmn(lmn);
            }
            throw th2;
        }
    }

    public final void lmn(String str, String str2) {
        if (!av.lmn().lmn.fgh) {
            HiLog.w("instanceimpl", HiLog.ErrorCode.IE006, "The Analytics Kit is disabled");
            return;
        }
        cj lmn = ck.lmn("HiAnalyticsInstance#setUserProfile(String,String)");
        if (!dl.lmn(str, str2)) {
            HiLog.w("instanceimpl", "userProperties check failed");
            ck.lmn(lmn);
            return;
        }
        try {
            av.lmn().klm().lmn(str, (Object) str2);
        } catch (JSONException unused) {
            HiLog.e("instanceimpl", "add userProper json exception");
        }
        lmn.lmn = "0";
        ck.lmn(lmn);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
        if (r6 == false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        if (r1.contains(r2) == false) goto L_0x0053;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lmn(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r0 = r0.lmn
            boolean r0 = r0.fgh
            java.lang.String r1 = "instanceimpl"
            if (r0 != 0) goto L_0x0014
            java.lang.String r5 = "IE-006"
            java.lang.String r6 = "The Analytics Kit is disabled"
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r5, r6)
            return
        L_0x0014:
            java.lang.String r0 = "HiAnalyticsInstance#setPropertyCollection"
            com.huawei.hms.analytics.cj r0 = com.huawei.hms.analytics.ck.lmn((java.lang.String) r0)
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 == 0) goto L_0x0029
            java.lang.String r5 = "property is empty"
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r5)
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r0)
            return
        L_0x0029:
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r2 = r5.toUpperCase(r2)
            java.util.List<java.lang.String> r3 = com.huawei.hms.analytics.ar.ikl
            boolean r3 = r3.contains(r2)
            if (r3 != 0) goto L_0x0044
            java.lang.String r6 = "set property collection failed: "
            java.lang.String r5 = r6.concat(r5)
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r5)
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r0)
            return
        L_0x0044:
            android.content.Context r5 = r4.ijk
            java.util.List r1 = com.huawei.hms.analytics.dq.lmn((android.content.Context) r5)
            if (r1 != 0) goto L_0x0057
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r6 != 0) goto L_0x0064
        L_0x0053:
            r1.add(r2)
            goto L_0x0064
        L_0x0057:
            if (r6 == 0) goto L_0x005d
            r1.remove(r2)
            goto L_0x0064
        L_0x005d:
            boolean r6 = r1.contains(r2)
            if (r6 != 0) goto L_0x0064
            goto L_0x0053
        L_0x0064:
            int r6 = r1.size()
            if (r6 != 0) goto L_0x0070
            java.lang.String r6 = ""
        L_0x006c:
            com.huawei.hms.analytics.dq.lmn(r5, r6)
            goto L_0x009d
        L_0x0070:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0079:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x008e
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            r6.append(r2)
            java.lang.String r2 = "|"
            r6.append(r2)
            goto L_0x0079
        L_0x008e:
            int r1 = r6.length()
            int r1 = r1 + -1
            java.lang.StringBuilder r6 = r6.deleteCharAt(r1)
            java.lang.String r6 = r6.toString()
            goto L_0x006c
        L_0x009d:
            java.lang.String r5 = "0"
            r0.lmn = r5
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.def.lmn(java.lang.String, boolean):void");
    }

    public final void lmn(Set<ReportPolicy> set) {
        cj lmn = ck.lmn("HiAnalyticsInstance#setReportPolicies(Set<ReportPolicy>)");
        try {
            bt.lmn().lmn(set);
            lmn.lmn = "0";
        } catch (Exception unused) {
            HiLog.e("instanceimpl", "decide policy exception");
        } finally {
            ck.lmn(lmn);
        }
    }
}
