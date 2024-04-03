package com.huawei.agconnect.https.connector;

import android.content.Context;

public class a implements Connector {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f47648a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static a f47649b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f47650c;

    private a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f47650c = applicationContext != null ? applicationContext : context;
    }

    public static a a(Context context) {
        a aVar;
        synchronized (f47648a) {
            if (f47649b == null) {
                f47649b = new a(context);
            }
            aVar = f47649b;
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = (r0 = (android.net.ConnectivityManager) r0.getSystemService("connectivity")).getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasActiveNetwork() {
        /*
            r2 = this;
            android.content.Context r0 = r2.f47650c
            if (r0 == 0) goto L_0x001c
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            if (r0 == 0) goto L_0x001c
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.isConnected()
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.https.connector.a.hasActiveNetwork():boolean");
    }

    public void logger(String str, String str2) {
    }
}
