package com.huawei.hms.dtm.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.dtm.core.C0342a;
import com.huawei.hms.dtm.core.safe.SafeIntent;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.utils.HMSPackageManager;
import org.json.JSONException;
import org.json.JSONObject;

public class Fb extends Y {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Object f48298a = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f48299b = "";

    public final class a implements ServiceConnection {
        private a() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            String str2;
            Logger.debug("DTM-Execute", "onServiceConnected");
            C0342a a11 = C0342a.C0065a.a(iBinder);
            if (a11 != null) {
                synchronized (Fb.this.f48298a) {
                    try {
                        String a12 = a11.a();
                        if (!TextUtils.isEmpty(a12)) {
                            JSONObject jSONObject = new JSONObject(a12);
                            String unused = Fb.this.f48299b = jSONObject.optString("grsCountryCode");
                        }
                    } catch (RemoteException unused2) {
                        str = "DTM-Execute";
                        str2 = "grsCountryCode RemoteException";
                    } catch (JSONException unused3) {
                        str = "DTM-Execute";
                        str2 = "grsCountryCode JSONException";
                    }
                }
            }
            return;
            Logger.error(str, str2);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Logger.debug("DTM-Execute", "grsCountryCode onServiceDisconnected");
        }
    }

    private void a(Context context) {
        String str;
        try {
            str = HMSPackageManager.getInstance(context).getHMSPackageName();
        } catch (NoClassDefFoundError e11) {
            Logger.error("DTM-Report", "grsCountryCode Track bindService meet error " + e11.getMessage());
            str = "com.huawei.hwid";
        }
        Logger.debug("DTM-Execute", "grsCountryCode Track bindService# packageName = " + str);
        a aVar = new a();
        SafeIntent safeIntent = new SafeIntent(new Intent("com.huawei.android.hms.CHANNEL_SERVICE"));
        try {
            safeIntent.setPackage(str);
            boolean bindService = context.bindService(safeIntent, aVar, 1);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("grsCountryCode bindService#");
            sb2.append(bindService);
            Logger.debug("DTM-Execute", sb2.toString());
        } catch (IllegalArgumentException e12) {
            Logger.error("DTM-Execute", "grsCountryCode Track bindService meet error " + e12.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.dtm.core.C0435sc<?> a(com.huawei.hms.dtm.core.X r4, java.util.List<com.huawei.hms.dtm.core.C0435sc<?>> r5) throws com.huawei.hms.dtm.core.V {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0071
            android.content.Context r4 = r4.c()
            if (r4 == 0) goto L_0x0069
            java.lang.Object r5 = r3.f48298a
            monitor-enter(r5)
            java.lang.String r0 = ""
            r3.f48299b = r0     // Catch:{ all -> 0x0066 }
            monitor-exit(r5)     // Catch:{ all -> 0x0066 }
            r3.a((android.content.Context) r4)
            java.lang.Object r4 = r3.f48298a
            monitor-enter(r4)
            java.lang.Object r5 = r3.f48298a     // Catch:{ InterruptedException -> 0x0020 }
            r0 = 100
            r5.wait(r0)     // Catch:{ InterruptedException -> 0x0020 }
            goto L_0x003b
        L_0x001e:
            r5 = move-exception
            goto L_0x0064
        L_0x0020:
            r5 = move-exception
            java.lang.String r0 = "DTM-Execute"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x001e }
            r1.<init>()     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "grsCountryCode#"
            r1.append(r2)     // Catch:{ all -> 0x001e }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x001e }
            r1.append(r5)     // Catch:{ all -> 0x001e }
            java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x001e }
            com.huawei.hms.dtm.core.util.Logger.error(r0, r5)     // Catch:{ all -> 0x001e }
        L_0x003b:
            java.lang.String r5 = r3.f48299b     // Catch:{ all -> 0x001e }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x001e }
            if (r5 != 0) goto L_0x004c
            com.huawei.hms.dtm.core.Cc r5 = new com.huawei.hms.dtm.core.Cc     // Catch:{ all -> 0x001e }
            java.lang.String r0 = r3.f48299b     // Catch:{ all -> 0x001e }
            r5.<init>(r0)     // Catch:{ all -> 0x001e }
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            return r5
        L_0x004c:
            java.lang.String r5 = com.huawei.hms.dtm.core.C0421pd.a()     // Catch:{ all -> 0x001e }
            r3.f48299b = r5     // Catch:{ all -> 0x001e }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x001e }
            if (r5 == 0) goto L_0x005b
            com.huawei.hms.dtm.core.Cc r5 = com.huawei.hms.dtm.core.Cc.f48270b     // Catch:{ all -> 0x001e }
            goto L_0x0062
        L_0x005b:
            com.huawei.hms.dtm.core.Cc r5 = new com.huawei.hms.dtm.core.Cc     // Catch:{ all -> 0x001e }
            java.lang.String r0 = r3.f48299b     // Catch:{ all -> 0x001e }
            r5.<init>(r0)     // Catch:{ all -> 0x001e }
        L_0x0062:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            return r5
        L_0x0064:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            throw r5
        L_0x0066:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0066 }
            throw r4
        L_0x0069:
            com.huawei.hms.dtm.core.V r4 = new com.huawei.hms.dtm.core.V
            java.lang.String r5 = "grsCountryCode#appContext null"
            r4.<init>(r5)
            throw r4
        L_0x0071:
            com.huawei.hms.dtm.core.V r4 = new com.huawei.hms.dtm.core.V
            java.lang.String r5 = "grsCountryCode#params error"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.Fb.a(com.huawei.hms.dtm.core.X, java.util.List):com.huawei.hms.dtm.core.sc");
    }

    public String a() {
        return "grsCountryCode";
    }
}
