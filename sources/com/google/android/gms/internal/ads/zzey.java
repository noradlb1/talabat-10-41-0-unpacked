package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;

final class zzey extends BroadcastReceiver {
    final /* synthetic */ zzfb zza;

    public /* synthetic */ zzey(zzfb zzfb, zzex zzex) {
        this.zza = zzfb;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
            r9 = this;
            java.lang.String r11 = "connectivity"
            java.lang.Object r11 = r10.getSystemService(r11)
            android.net.ConnectivityManager r11 = (android.net.ConnectivityManager) r11
            r0 = 29
            r1 = 1
            r2 = 0
            r3 = 5
            if (r11 != 0) goto L_0x0011
        L_0x000f:
            r5 = r2
            goto L_0x004e
        L_0x0011:
            android.net.NetworkInfo r11 = r11.getActiveNetworkInfo()     // Catch:{ SecurityException -> 0x000f }
            if (r11 == 0) goto L_0x004d
            boolean r4 = r11.isConnected()
            if (r4 != 0) goto L_0x001e
            goto L_0x004d
        L_0x001e:
            int r4 = r11.getType()
            r5 = 2
            r6 = 9
            r7 = 6
            r8 = 4
            if (r4 == 0) goto L_0x003a
            if (r4 == r1) goto L_0x004e
            if (r4 == r8) goto L_0x003a
            if (r4 == r3) goto L_0x003a
            if (r4 == r7) goto L_0x0038
            if (r4 == r6) goto L_0x0036
            r5 = 8
            goto L_0x004e
        L_0x0036:
            r5 = 7
            goto L_0x004e
        L_0x0038:
            r5 = r3
            goto L_0x004e
        L_0x003a:
            int r11 = r11.getSubtype()
            switch(r11) {
                case 1: goto L_0x004b;
                case 2: goto L_0x004b;
                case 3: goto L_0x0049;
                case 4: goto L_0x0049;
                case 5: goto L_0x0049;
                case 6: goto L_0x0049;
                case 7: goto L_0x0049;
                case 8: goto L_0x0049;
                case 9: goto L_0x0049;
                case 10: goto L_0x0049;
                case 11: goto L_0x0049;
                case 12: goto L_0x0049;
                case 13: goto L_0x0038;
                case 14: goto L_0x0049;
                case 15: goto L_0x0049;
                case 16: goto L_0x0041;
                case 17: goto L_0x0049;
                case 18: goto L_0x004e;
                case 19: goto L_0x0041;
                case 20: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            r5 = r7
            goto L_0x004e
        L_0x0043:
            int r11 = com.google.android.gms.internal.ads.zzfn.zza
            if (r11 < r0) goto L_0x000f
            r5 = r6
            goto L_0x004e
        L_0x0049:
            r5 = r8
            goto L_0x004e
        L_0x004b:
            r5 = 3
            goto L_0x004e
        L_0x004d:
            r5 = r1
        L_0x004e:
            int r11 = com.google.android.gms.internal.ads.zzfn.zza
            if (r11 < r0) goto L_0x007b
            com.google.android.gms.internal.ads.zzew.zza()
            if (r5 != r3) goto L_0x007b
            java.lang.String r0 = "phone"
            java.lang.Object r10 = r10.getSystemService(r0)     // Catch:{ RuntimeException -> 0x007c }
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10     // Catch:{ RuntimeException -> 0x007c }
            r10.getClass()
            com.google.android.gms.internal.ads.zzfa r0 = new com.google.android.gms.internal.ads.zzfa     // Catch:{ RuntimeException -> 0x007c }
            com.google.android.gms.internal.ads.zzfb r4 = r9.zza     // Catch:{ RuntimeException -> 0x007c }
            r5 = 0
            r0.<init>(r4, r5)     // Catch:{ RuntimeException -> 0x007c }
            r4 = 31
            if (r11 >= r4) goto L_0x0072
            r10.listen(r0, r1)     // Catch:{ RuntimeException -> 0x007c }
            goto L_0x0077
        L_0x0072:
            r11 = 1048576(0x100000, float:1.469368E-39)
            r10.listen(r0, r11)     // Catch:{ RuntimeException -> 0x007c }
        L_0x0077:
            r10.listen(r0, r2)     // Catch:{ RuntimeException -> 0x007c }
            return
        L_0x007b:
            r3 = r5
        L_0x007c:
            com.google.android.gms.internal.ads.zzfb r10 = r9.zza
            com.google.android.gms.internal.ads.zzfb.zzc(r10, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzey.onReceive(android.content.Context, android.content.Intent):void");
    }
}
