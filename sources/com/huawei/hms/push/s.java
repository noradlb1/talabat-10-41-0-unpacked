package com.huawei.hms.push;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;

public class s {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f49785c = {"url", "app", "cosa", "rp"};

    /* renamed from: a  reason: collision with root package name */
    private Context f49786a;

    /* renamed from: b  reason: collision with root package name */
    private m f49787b;

    public s(Context context, m mVar) {
        this.f49786a = context;
        this.f49787b = mVar;
    }

    public static boolean a(String str) {
        for (String equals : f49785c) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00ba, code lost:
        if (com.huawei.hms.push.d.a(r6.f49786a, r6.f49787b.d(), r2).booleanValue() != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x007a, code lost:
        if (r3 != false) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00bf A[Catch:{ Exception -> 0x00e1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c5 A[Catch:{ Exception -> 0x00e1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r6 = this;
            java.lang.String r0 = "run into launchCosaApp"
            java.lang.String r1 = "PushSelfShowLog"
            com.huawei.hms.support.log.HMSLog.i(r1, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1 }
            r0.<init>()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = "enter launchExistApp cosa, appPackageName ="
            r0.append(r2)     // Catch:{ Exception -> 0x00e1 }
            com.huawei.hms.push.m r2 = r6.f49787b     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r2.d()     // Catch:{ Exception -> 0x00e1 }
            r0.append(r2)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = ",and msg.intentUri is "
            r0.append(r2)     // Catch:{ Exception -> 0x00e1 }
            com.huawei.hms.push.m r2 = r6.f49787b     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r2.n()     // Catch:{ Exception -> 0x00e1 }
            r0.append(r2)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00e1 }
            com.huawei.hms.support.log.HMSLog.i(r1, r0)     // Catch:{ Exception -> 0x00e1 }
            android.content.Context r0 = r6.f49786a     // Catch:{ Exception -> 0x00e1 }
            com.huawei.hms.push.m r2 = r6.f49787b     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r2.d()     // Catch:{ Exception -> 0x00e1 }
            android.content.Intent r0 = com.huawei.hms.push.d.b(r0, r2)     // Catch:{ Exception -> 0x00e1 }
            com.huawei.hms.push.m r2 = r6.f49787b     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r2.n()     // Catch:{ Exception -> 0x00e1 }
            r3 = 0
            if (r2 == 0) goto L_0x0097
            com.huawei.hms.push.m r2 = r6.f49787b     // Catch:{ Exception -> 0x007d }
            java.lang.String r2 = r2.n()     // Catch:{ Exception -> 0x007d }
            android.content.Intent r2 = android.content.Intent.parseUri(r2, r3)     // Catch:{ Exception -> 0x007d }
            r4 = 0
            r2.setSelector(r4)     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r4.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = "Intent.parseUri(msg.intentUri, 0), action:"
            r4.append(r5)     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = r2.getAction()     // Catch:{ Exception -> 0x007d }
            r4.append(r5)     // Catch:{ Exception -> 0x007d }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x007d }
            com.huawei.hms.support.log.HMSLog.i(r1, r4)     // Catch:{ Exception -> 0x007d }
            android.content.Context r4 = r6.f49786a     // Catch:{ Exception -> 0x007d }
            com.huawei.hms.push.m r5 = r6.f49787b     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = r5.d()     // Catch:{ Exception -> 0x007d }
            java.lang.Boolean r4 = com.huawei.hms.push.d.a((android.content.Context) r4, (java.lang.String) r5, (android.content.Intent) r2)     // Catch:{ Exception -> 0x007d }
            boolean r3 = r4.booleanValue()     // Catch:{ Exception -> 0x007d }
            if (r3 == 0) goto L_0x00bd
            goto L_0x00bc
        L_0x007d:
            r2 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e1 }
            r4.<init>()     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r5 = "intentUri error."
            r4.append(r5)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00e1 }
            r4.append(r2)     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x00e1 }
            com.huawei.hms.support.log.HMSLog.w(r1, r2)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x00bd
        L_0x0097:
            com.huawei.hms.push.m r2 = r6.f49787b     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x00e1 }
            if (r2 == 0) goto L_0x00bd
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x00e1 }
            com.huawei.hms.push.m r4 = r6.f49787b     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r4 = r4.a()     // Catch:{ Exception -> 0x00e1 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x00e1 }
            android.content.Context r4 = r6.f49786a     // Catch:{ Exception -> 0x00e1 }
            com.huawei.hms.push.m r5 = r6.f49787b     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r5 = r5.d()     // Catch:{ Exception -> 0x00e1 }
            java.lang.Boolean r4 = com.huawei.hms.push.d.a((android.content.Context) r4, (java.lang.String) r5, (android.content.Intent) r2)     // Catch:{ Exception -> 0x00e1 }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x00e1 }
            if (r4 == 0) goto L_0x00bd
        L_0x00bc:
            r0 = r2
        L_0x00bd:
            if (r0 != 0) goto L_0x00c5
            java.lang.String r0 = "launchCosaApp,intent == null"
            com.huawei.hms.support.log.HMSLog.i(r1, r0)     // Catch:{ Exception -> 0x00e1 }
            return
        L_0x00c5:
            com.huawei.hms.push.m r2 = r6.f49787b     // Catch:{ Exception -> 0x00e1 }
            java.lang.String r2 = r2.d()     // Catch:{ Exception -> 0x00e1 }
            r0.setPackage(r2)     // Catch:{ Exception -> 0x00e1 }
            if (r3 == 0) goto L_0x00d6
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r0.addFlags(r2)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x00db
        L_0x00d6:
            r2 = 805437440(0x30020000, float:4.7293724E-10)
            r0.setFlags(r2)     // Catch:{ Exception -> 0x00e1 }
        L_0x00db:
            android.content.Context r2 = r6.f49786a     // Catch:{ Exception -> 0x00e1 }
            r2.startActivity(r0)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x00fa
        L_0x00e1:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "launch Cosa App exception."
            r2.append(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.huawei.hms.support.log.HMSLog.e(r1, r0)
        L_0x00fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.s.b():void");
    }

    public void c() {
        m mVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.f49786a == null || (mVar = this.f49787b) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
        } else if ("app".equals(mVar.i())) {
            a();
        } else if ("cosa".equals(this.f49787b.i())) {
            b();
        } else if ("rp".equals(this.f49787b.i())) {
            HMSLog.w("PushSelfShowLog", this.f49787b.i() + " not support rich message.");
        } else if ("url".equals(this.f49787b.i())) {
            HMSLog.w("PushSelfShowLog", this.f49787b.i() + " not support URL.");
        } else {
            HMSLog.d("PushSelfShowLog", this.f49787b.i() + " is not exist in hShowType");
        }
    }

    private void a() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.f49787b.d());
            if (d.c(this.f49786a, this.f49787b.d())) {
                b();
            }
        } catch (Exception e11) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e11.toString());
        }
    }
}
