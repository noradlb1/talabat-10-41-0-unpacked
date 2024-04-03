package com.google.android.gms.internal.ads;

import android.os.StrictMode;

public final class zzbll {
    /* JADX INFO: finally extract failed */
    public static <T> T zza(zzfqs<T> zzfqs) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            T zza = zzfqs.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza;
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(threadPolicy);
            throw th2;
        }
    }
}
