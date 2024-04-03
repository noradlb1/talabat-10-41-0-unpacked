package com.huawei.hms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import com.huawei.hms.analytics.core.log.HiLog;

public final class q {
    public p ikl;
    public ServiceConnection klm;
    public Context lmn;

    public final class lmn implements ServiceConnection {
        private lmn() {
        }

        public /* synthetic */ lmn(q qVar, byte b11) {
            this();
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0048 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
            /*
                r3 = this;
                java.lang.String r4 = "onServiceConnected"
                java.lang.String r0 = "PpsServiceCommander"
                com.huawei.hms.analytics.core.log.HiLog.i(r0, r4)
                com.huawei.hms.analytics.lmn r4 = com.huawei.hms.analytics.lmn.C0063lmn.lmn(r5)     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                if (r4 != 0) goto L_0x001e
                com.huawei.hms.analytics.q r4 = com.huawei.hms.analytics.q.this     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                com.huawei.hms.analytics.p r4 = r4.ikl     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                java.lang.String r5 = "pps service is null"
                java.lang.String r1 = "006"
            L_0x0015:
                r4.lmn(r5, r1)     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
            L_0x0018:
                com.huawei.hms.analytics.q r4 = com.huawei.hms.analytics.q.this
                r4.lmn()
                return
            L_0x001e:
                java.lang.String r4 = r4.lmn()     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                if (r5 == 0) goto L_0x0031
                com.huawei.hms.analytics.q r4 = com.huawei.hms.analytics.q.this     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                com.huawei.hms.analytics.p r4 = r4.ikl     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                java.lang.String r5 = "channelInfo is empty"
                java.lang.String r1 = "007"
                goto L_0x0015
            L_0x0031:
                com.huawei.hms.analytics.q r5 = com.huawei.hms.analytics.q.this     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                com.huawei.hms.analytics.p r5 = r5.ikl     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                r1.<init>((java.lang.String) r4)     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                java.lang.String r4 = "channelInfo"
                java.lang.String r2 = ""
                java.lang.String r4 = r1.optString(r4, r2)     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                r5.lmn(r4)     // Catch:{ RemoteException -> 0x0054, JSONException -> 0x0048 }
                goto L_0x0018
            L_0x0046:
                r4 = move-exception
                goto L_0x0068
            L_0x0048:
                com.huawei.hms.analytics.q r4 = com.huawei.hms.analytics.q.this     // Catch:{ all -> 0x0046 }
                com.huawei.hms.analytics.p r4 = r4.ikl     // Catch:{ all -> 0x0046 }
                java.lang.String r5 = "parseChannelJson: json exception"
                java.lang.String r0 = "102"
                r4.lmn(r5, r0)     // Catch:{ all -> 0x0046 }
                goto L_0x0018
            L_0x0054:
                r4 = move-exception
                java.lang.String r5 = "getChannelInfo Exception"
                com.huawei.hms.analytics.core.log.HiLog.e(r0, r5)     // Catch:{ all -> 0x0046 }
                com.huawei.hms.analytics.q r5 = com.huawei.hms.analytics.q.this     // Catch:{ all -> 0x0046 }
                com.huawei.hms.analytics.p r5 = r5.ikl     // Catch:{ all -> 0x0046 }
                java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0046 }
                java.lang.String r0 = "998"
                r5.lmn(r4, r0)     // Catch:{ all -> 0x0046 }
                goto L_0x0018
            L_0x0068:
                com.huawei.hms.analytics.q r5 = com.huawei.hms.analytics.q.this
                r5.lmn()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.q.lmn.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            HiLog.i("PpsServiceCommander", "onServiceDisconnected");
            q.this.ikl.lmn("onServiceDisconnected", "008");
        }
    }

    public q(Context context, p pVar) {
        this.lmn = context;
        this.ikl = pVar;
    }

    public final void lmn() {
        ServiceConnection serviceConnection;
        HiLog.i("PpsServiceCommander", "ads unBindService..");
        Context context = this.lmn;
        if (context != null && (serviceConnection = this.klm) != null) {
            context.unbindService(serviceConnection);
        }
    }
}
