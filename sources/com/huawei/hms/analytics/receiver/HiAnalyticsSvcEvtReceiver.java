package com.huawei.hms.analytics.receiver;

import android.content.BroadcastReceiver;
import android.content.Intent;
import com.huawei.hms.analytics.core.log.HiLog;

public class HiAnalyticsSvcEvtReceiver extends BroadcastReceiver {
    private static boolean lmn(Intent intent) {
        if (intent == null) {
            HiLog.w("HiAnalyticsSvcEvtAccepter", "intent is null");
            return true;
        } else if (intent instanceof SafeIntent) {
            HiLog.i("HiAnalyticsSvcEvtAccepter", "safe intent");
            return ((SafeIntent) intent).lmn();
        } else {
            try {
                intent.getStringExtra("ANYTHING");
                return false;
            } catch (Throwable unused) {
                return true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ae, code lost:
        if ("$ObtainAdAward".equals(r11) != false) goto L_0x00b0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c0 A[Catch:{ all -> 0x0167 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            r9 = this;
            java.lang.String r0 = "onReceive is running"
            java.lang.String r1 = "HiAnalyticsSvcEvtAccepter"
            com.huawei.hms.analytics.core.log.HiLog.i(r1, r0)
            com.huawei.hms.analytics.ea r0 = com.huawei.hms.analytics.ea.lmn()     // Catch:{ all -> 0x0167 }
            boolean r0 = r0.lmn(r10)     // Catch:{ all -> 0x0167 }
            r2 = 1
            if (r0 != 0) goto L_0x0013
            goto L_0x0036
        L_0x0013:
            com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()     // Catch:{ all -> 0x0167 }
            com.huawei.hms.analytics.ax r0 = r0.lmn     // Catch:{ all -> 0x0167 }
            boolean r0 = r0.fgh     // Catch:{ all -> 0x0167 }
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = "isAnalyticsEnabled is false"
        L_0x001f:
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r0)     // Catch:{ all -> 0x0167 }
            goto L_0x0036
        L_0x0023:
            boolean r0 = com.huawei.hms.analytics.be.lmn()     // Catch:{ all -> 0x0167 }
            if (r0 != 0) goto L_0x002c
            java.lang.String r0 = "openness init failed"
            goto L_0x001f
        L_0x002c:
            boolean r0 = lmn(r11)     // Catch:{ all -> 0x0167 }
            if (r0 == 0) goto L_0x0035
            java.lang.String r0 = "hasIntentBomb"
            goto L_0x001f
        L_0x0035:
            r2 = 0
        L_0x0036:
            if (r2 == 0) goto L_0x0039
            return
        L_0x0039:
            java.lang.String r0 = "SvcEvtReceiverHolder"
            if (r10 == 0) goto L_0x0161
            if (r11 != 0) goto L_0x0041
            goto L_0x0161
        L_0x0041:
            com.huawei.hms.analytics.av r10 = com.huawei.hms.analytics.av.lmn()     // Catch:{ all -> 0x0167 }
            com.huawei.hms.analytics.ax r10 = r10.lmn     // Catch:{ all -> 0x0167 }
            android.content.Context r10 = r10.ghi     // Catch:{ all -> 0x0167 }
            if (r10 != 0) goto L_0x0051
            java.lang.String r10 = "Check whether the SDK is initialized."
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r10)     // Catch:{ all -> 0x0167 }
            return
        L_0x0051:
            com.huawei.hms.analytics.receiver.SafeIntent r10 = new com.huawei.hms.analytics.receiver.SafeIntent     // Catch:{ all -> 0x0167 }
            r10.<init>(r11)     // Catch:{ all -> 0x0167 }
            android.os.Bundle r11 = r10.getExtras()     // Catch:{ all -> 0x0167 }
            com.huawei.hms.analytics.cb r2 = new com.huawei.hms.analytics.cb     // Catch:{ all -> 0x0167 }
            r2.<init>(r11)     // Catch:{ all -> 0x0167 }
            java.lang.String r10 = r10.getAction()     // Catch:{ all -> 0x0167 }
            java.lang.String r11 = "com.huawei.hms.analytics.pps.event"
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x0167 }
            if (r10 == 0) goto L_0x015b
            java.lang.String r10 = "onReceive : event is ads"
            com.huawei.hms.analytics.core.log.HiLog.i(r0, r10)     // Catch:{ all -> 0x0167 }
            java.lang.String r10 = "SvcEvtReceiverHandler#handlerADSEvt(Bundle)"
            java.lang.String r11 = "event_detail"
            android.os.Bundle r11 = r2.lmn(r11)     // Catch:{ all -> 0x0167 }
            com.huawei.hms.analytics.cb r2 = new com.huawei.hms.analytics.cb     // Catch:{ all -> 0x0167 }
            r2.<init>(r11)     // Catch:{ all -> 0x0167 }
            java.lang.String r11 = "event_type"
            java.lang.String r11 = r2.klm(r11)     // Catch:{ all -> 0x0167 }
            boolean r3 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0167 }
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x008d
        L_0x008b:
            r11 = r4
            goto L_0x00b0
        L_0x008d:
            java.lang.String r3 = "$RequestAd"
            boolean r3 = r3.equals(r11)     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x0096
            goto L_0x00b0
        L_0x0096:
            java.lang.String r3 = "$DisplayAd"
            boolean r3 = r3.equals(r11)     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x009f
            goto L_0x00b0
        L_0x009f:
            java.lang.String r3 = "$ClickAd"
            boolean r3 = r3.equals(r11)     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x00a8
            goto L_0x00b0
        L_0x00a8:
            java.lang.String r3 = "$ObtainAdAward"
            boolean r3 = r3.equals(r11)     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x008b
        L_0x00b0:
            java.lang.String r3 = "package_name"
            java.lang.String r3 = r2.klm(r3)     // Catch:{ all -> 0x0167 }
            com.huawei.hms.analytics.cj r10 = com.huawei.hms.analytics.ck.lmn((java.lang.String) r10)     // Catch:{ all -> 0x0167 }
            boolean r5 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0167 }
            if (r5 != 0) goto L_0x0150
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0167 }
            if (r5 == 0) goto L_0x00c8
            goto L_0x0150
        L_0x00c8:
            com.huawei.hms.analytics.av r5 = com.huawei.hms.analytics.av.lmn()     // Catch:{ all -> 0x0167 }
            com.huawei.hms.analytics.ax r5 = r5.lmn     // Catch:{ all -> 0x0167 }
            android.content.Context r5 = r5.ghi     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ all -> 0x0167 }
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0167 }
            if (r3 == 0) goto L_0x0145
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x0167 }
            r3.<init>()     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = "slot_id"
            java.lang.String r5 = r2.klm(r5)     // Catch:{ all -> 0x0167 }
            java.lang.String r6 = "activity_name"
            java.lang.String r6 = r2.klm(r6)     // Catch:{ all -> 0x0167 }
            java.lang.String r7 = "sub_type"
            java.lang.String r2 = r2.klm(r7)     // Catch:{ all -> 0x0167 }
            java.lang.String r7 = "$MaterialSlot"
            boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0167 }
            if (r8 != 0) goto L_0x00fa
            goto L_0x00fb
        L_0x00fa:
            r5 = r4
        L_0x00fb:
            r3.putString(r7, r5)     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = "$CurActivityName"
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0167 }
            if (r7 != 0) goto L_0x0107
            goto L_0x0108
        L_0x0107:
            r6 = r4
        L_0x0108:
            r3.putString(r5, r6)     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = "$EvtType"
            java.lang.String r6 = "Supplier"
            r3.putString(r5, r6)     // Catch:{ all -> 0x0167 }
            java.lang.String r5 = "$AdReqType"
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0167 }
            if (r6 != 0) goto L_0x011b
            r4 = r2
        L_0x011b:
            r3.putString(r5, r4)     // Catch:{ all -> 0x0167 }
            java.lang.String r2 = "start onEvent"
            com.huawei.hms.analytics.core.log.HiLog.i(r0, r2)     // Catch:{ all -> 0x0167 }
            com.huawei.hms.analytics.cde r0 = com.huawei.hms.analytics.cde.lmn()     // Catch:{ all -> 0x0167 }
            java.lang.String r2 = "_openness_config_tag"
            com.huawei.hms.analytics.bl r0 = r0.lmn((java.lang.String) r2)     // Catch:{ all -> 0x0167 }
            if (r0 == 0) goto L_0x013b
            com.huawei.hms.analytics.dt r2 = new com.huawei.hms.analytics.dt     // Catch:{ all -> 0x0167 }
            r2.<init>((java.lang.String) r11, (android.os.Bundle) r3)     // Catch:{ all -> 0x0167 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0167 }
            r0.lmn((java.lang.String) r11, (com.huawei.hms.analytics.dt) r2, (long) r3)     // Catch:{ all -> 0x0167 }
        L_0x013b:
            r10.ijk = r11     // Catch:{ all -> 0x0167 }
            java.lang.String r11 = "0"
            r10.lmn = r11     // Catch:{ all -> 0x0167 }
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r10)     // Catch:{ all -> 0x0167 }
            return
        L_0x0145:
            java.lang.String r2 = "3rd package names are not equal"
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r2)     // Catch:{ all -> 0x0167 }
            r10.ijk = r11     // Catch:{ all -> 0x0167 }
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r10)     // Catch:{ all -> 0x0167 }
            return
        L_0x0150:
            java.lang.String r2 = "event_type or package_name is empty"
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r2)     // Catch:{ all -> 0x0167 }
            r10.ijk = r11     // Catch:{ all -> 0x0167 }
            com.huawei.hms.analytics.ck.lmn((com.huawei.hms.analytics.cj) r10)     // Catch:{ all -> 0x0167 }
            return
        L_0x015b:
            java.lang.String r10 = "onReceive : event is not ads"
            com.huawei.hms.analytics.core.log.HiLog.w(r0, r10)     // Catch:{ all -> 0x0167 }
            return
        L_0x0161:
            java.lang.String r10 = "context or intent is null"
            com.huawei.hms.analytics.core.log.HiLog.e(r0, r10)     // Catch:{ all -> 0x0167 }
            return
        L_0x0167:
            r10 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "SvcEvtReceiver onReceive error."
            r11.<init>(r0)
            java.lang.String r0 = r10.getMessage()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r11)
            com.huawei.hms.analytics.dr.lmn(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.receiver.HiAnalyticsSvcEvtReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
