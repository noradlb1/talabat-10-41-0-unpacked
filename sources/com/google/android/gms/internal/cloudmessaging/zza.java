package com.google.android.gms.internal.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public final class zza {
    public static final int zza;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r0.charAt(0) <= 'Z') goto L_0x0029;
     */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            r2 = 33554432(0x2000000, float:9.403955E-38)
            if (r0 < r1) goto L_0x0009
            goto L_0x0029
        L_0x0009:
            r1 = 30
            r3 = 0
            if (r0 < r1) goto L_0x0028
            java.lang.String r0 = android.os.Build.VERSION.CODENAME
            int r1 = r0.length()
            r4 = 1
            if (r1 != r4) goto L_0x0028
            char r1 = r0.charAt(r3)
            r4 = 83
            if (r1 < r4) goto L_0x0028
            char r0 = r0.charAt(r3)
            r1 = 90
            if (r0 > r1) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r2 = r3
        L_0x0029:
            zza = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cloudmessaging.zza.<clinit>():void");
    }

    public static PendingIntent zza(Context context, int i11, Intent intent, int i12) {
        return PendingIntent.getBroadcast(context, 0, intent, i12);
    }
}
