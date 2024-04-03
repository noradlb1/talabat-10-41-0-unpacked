package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
public final class zzdi {
    @VisibleForTesting
    private static zzdj zzaib = new zzba();
    static int zzyr;

    public static void setLogLevel(int i11) {
        zzyr = i11;
        zzaib.setLogLevel(i11);
    }

    public static void zza(String str, Throwable th2) {
        zzaib.zza(str, th2);
    }

    public static void zzab(String str) {
        zzaib.zzab(str);
    }

    public static void zzac(String str) {
        zzaib.zzac(str);
    }

    public static void zzav(String str) {
        zzaib.zzav(str);
    }

    public static void zzaw(String str) {
        zzaib.zzaw(str);
    }

    public static void zzax(String str) {
        zzaib.zzax(str);
    }

    public static void zzb(String str, Throwable th2) {
        zzaib.zzb(str, th2);
    }
}
