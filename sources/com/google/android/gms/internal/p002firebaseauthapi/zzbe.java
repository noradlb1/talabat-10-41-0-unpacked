package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbe  reason: invalid package */
public final class zzbe {
    private final InputStream zza;

    private zzbe(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzbe zzc(byte[] bArr) {
        return new zzbe(new ByteArrayInputStream(bArr));
    }

    public final zzrt zza() throws IOException {
        try {
            return zzrt.zzc(this.zza, zzagn.zza());
        } finally {
            this.zza.close();
        }
    }

    public final zztk zzb() throws IOException {
        try {
            return zztk.zzf(this.zza, zzagn.zza());
        } finally {
            this.zza.close();
        }
    }
}
