package com.google.android.libraries.places.internal;

import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeUnit;

public final class zzu {
    public static final /* synthetic */ int zza = 0;
    private static final long zzb = TimeUnit.MINUTES.toMicros(1);
    @Nullable
    private final WifiManager zzc;
    private final zza zzd;

    public zzu(@Nullable WifiManager wifiManager, zza zza2) {
        this.zzc = wifiManager;
        this.zzd = zza2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        if (r11.contains("_optout") == false) goto L_0x0064;
     */
    @androidx.annotation.RequiresPermission(allOf = {"android.permission.ACCESS_WIFI_STATE", "android.permission.ACCESS_FINE_LOCATION"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.libraries.places.internal.zzge<com.google.android.libraries.places.internal.zzs> zza() {
        /*
            r14 = this;
            android.net.wifi.WifiManager r0 = r14.zzc
            if (r0 == 0) goto L_0x00a1
            boolean r0 = r0.isWifiEnabled()
            if (r0 != 0) goto L_0x000c
            goto L_0x00a1
        L_0x000c:
            android.net.wifi.WifiManager r0 = r14.zzc
            java.util.List r0 = r0.getScanResults()
            if (r0 == 0) goto L_0x009c
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x001c
            goto L_0x009c
        L_0x001c:
            com.google.android.libraries.places.internal.zzt r1 = com.google.android.libraries.places.internal.zzt.zza
            com.google.android.libraries.places.internal.zzgo r1 = com.google.android.libraries.places.internal.zzgo.zza(r1)
            com.google.android.libraries.places.internal.zzge r0 = com.google.android.libraries.places.internal.zzge.zzp(r1, r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.net.wifi.WifiManager r2 = r14.zzc
            android.net.wifi.WifiInfo r2 = r2.getConnectionInfo()
            int r3 = r0.size()
            r4 = 0
            r5 = r4
        L_0x0037:
            if (r5 >= r3) goto L_0x0097
            java.lang.Object r6 = r0.get(r5)
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            if (r6 == 0) goto L_0x0094
            java.lang.String r7 = r6.SSID
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 == 0) goto L_0x004a
            goto L_0x0094
        L_0x004a:
            com.google.android.libraries.places.internal.zza r7 = r14.zzd
            long r7 = r7.zza()
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 * r9
            long r9 = r6.timestamp
            long r7 = r7 - r9
            long r9 = zzb
            java.lang.String r11 = r6.SSID
            if (r11 == 0) goto L_0x008c
            r12 = 95
            int r12 = r11.indexOf(r12)
            if (r12 >= 0) goto L_0x0066
        L_0x0064:
            r13 = r4
            goto L_0x007d
        L_0x0066:
            java.util.Locale r12 = java.util.Locale.ENGLISH
            java.lang.String r11 = r11.toLowerCase(r12)
            java.lang.String r12 = "_nomap"
            boolean r12 = r11.contains(r12)
            r13 = 1
            if (r12 != 0) goto L_0x007d
            java.lang.String r12 = "_optout"
            boolean r11 = r11.contains(r12)
            if (r11 == 0) goto L_0x0064
        L_0x007d:
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 > 0) goto L_0x0094
            if (r13 != 0) goto L_0x0094
            com.google.android.libraries.places.internal.zzs r7 = new com.google.android.libraries.places.internal.zzs
            r7.<init>(r2, r6)
            r1.add(r7)
            goto L_0x0094
        L_0x008c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Null SSID."
            r0.<init>(r1)
            throw r0
        L_0x0094:
            int r5 = r5 + 1
            goto L_0x0037
        L_0x0097:
            com.google.android.libraries.places.internal.zzge r0 = com.google.android.libraries.places.internal.zzge.zzk(r1)
            return r0
        L_0x009c:
            com.google.android.libraries.places.internal.zzge r0 = com.google.android.libraries.places.internal.zzge.zzm()
            return r0
        L_0x00a1:
            com.google.android.libraries.places.internal.zzge r0 = com.google.android.libraries.places.internal.zzge.zzm()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzu.zza():com.google.android.libraries.places.internal.zzge");
    }
}
