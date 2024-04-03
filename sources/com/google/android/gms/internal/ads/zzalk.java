package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

final class zzalk implements zzfoc {
    final /* synthetic */ zzfmc zza;

    public zzalk(zzalm zzalm, zzfmc zzfmc) {
        this.zza = zzfmc;
    }

    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
