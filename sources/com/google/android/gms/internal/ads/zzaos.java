package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzaos extends Exception {
    private zzaos(int i11, String str, Throwable th2, int i12) {
        super((String) null, th2);
    }

    public static zzaos zza(Exception exc, int i11) {
        return new zzaos(1, (String) null, exc, i11);
    }

    public static zzaos zzb(IOException iOException) {
        return new zzaos(0, (String) null, iOException, -1);
    }

    public static zzaos zzc(RuntimeException runtimeException) {
        return new zzaos(2, (String) null, runtimeException, -1);
    }
}
