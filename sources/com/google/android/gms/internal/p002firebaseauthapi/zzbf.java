package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbf  reason: invalid package */
public final class zzbf implements zzca {
    private final OutputStream zza;

    private zzbf(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzca zza(OutputStream outputStream) {
        return new zzbf(outputStream);
    }

    public final void zzb(zzrt zzrt) throws IOException {
        throw null;
    }

    public final void zzc(zztk zztk) throws IOException {
        try {
            zztk.zzp(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
