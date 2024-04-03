package com.huawei.hms.dtm.core.report;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.dtm.core.safe.SafeBroadcastReceiver;
import com.huawei.hms.dtm.core.safe.SafeIntent;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;

public class NetworkReceiver extends SafeBroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final a f48556a;

    public NetworkReceiver(a aVar) {
        this.f48556a = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r3 = ((android.net.ConnectivityManager) r3).getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "connectivity"
            r1 = 0
            java.lang.Object r3 = r3.getSystemService(r0)     // Catch:{ all -> 0x0025 }
            boolean r0 = r3 instanceof android.net.ConnectivityManager     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x000c
            return r1
        L_0x000c:
            android.net.ConnectivityManager r3 = (android.net.ConnectivityManager) r3     // Catch:{ all -> 0x0025 }
            android.net.NetworkInfo r3 = r3.getActiveNetworkInfo()     // Catch:{ all -> 0x0025 }
            if (r3 == 0) goto L_0x0024
            boolean r0 = r3.isConnected()     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0024
            android.net.NetworkInfo$State r3 = r3.getState()     // Catch:{ all -> 0x0025 }
            android.net.NetworkInfo$State r0 = android.net.NetworkInfo.State.CONNECTED     // Catch:{ all -> 0x0025 }
            if (r3 != r0) goto L_0x0024
            r3 = 1
            return r3
        L_0x0024:
            return r1
        L_0x0025:
            java.lang.String r3 = "DTM-Report"
            java.lang.String r0 = "network connected exception!"
            com.huawei.hms.dtm.core.util.Logger.error(r3, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.report.NetworkReceiver.a(android.content.Context):boolean");
    }

    public void onReceiveMsg(Context context, Intent intent) {
        if (ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION.equals(new SafeIntent(intent).getAction())) {
            this.f48556a.b(a(context));
        }
    }
}
