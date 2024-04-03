package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final class zzani implements Callable {
    private final zzams zza;
    private final zzaiz zzb;

    public zzani(zzams zzams, zzaiz zzaiz) {
        this.zza = zzams;
        this.zzb = zzaiz;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (this.zza.zzl() != null) {
            this.zza.zzl().get();
        }
        zzajp zzc = this.zza.zzc();
        if (zzc == null) {
            return null;
        }
        try {
            synchronized (this.zzb) {
                zzaiz zzaiz = this.zzb;
                byte[] zzar = zzc.zzar();
                zzaiz.zzag(zzar, 0, zzar.length, zzgjx.zza());
            }
            return null;
        } catch (zzgkx | NullPointerException unused) {
            return null;
        }
    }
}
