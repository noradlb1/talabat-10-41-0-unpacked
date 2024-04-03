package com.google.android.gms.internal.ads;

import android.os.Trace;

public final class zzfl {
    public static void zza(String str) {
        if (zzfn.zza >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void zzb() {
        if (zzfn.zza >= 18) {
            Trace.endSection();
        }
    }
}
