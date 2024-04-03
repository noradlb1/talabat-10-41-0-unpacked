package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzaid extends zzgpc {
    private static final zzgpj zza = zzgpj.zzb(zzaid.class);

    public zzaid(zzgpd zzgpd, zzaic zzaic) throws IOException {
        zzf(zzgpd, zzgpd.zzc(), zzaic);
    }

    public final void close() throws IOException {
    }

    public final String toString() {
        String obj = this.zzd.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 7);
        sb2.append("model(");
        sb2.append(obj);
        sb2.append(")");
        return sb2.toString();
    }
}
