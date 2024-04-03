package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class zzeu {
    @NonNull
    public final String zza;
    @NonNull
    public final String zzb;
    public final long zzc;
    @NonNull
    public final Bundle zzd;

    public zzeu(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j11) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = bundle;
        this.zzc = j11;
    }

    public static zzeu zzb(zzau zzau) {
        return new zzeu(zzau.zza, zzau.zzc, zzau.zzb.zzc(), zzau.zzd);
    }

    public final String toString() {
        String str = this.zzb;
        String str2 = this.zza;
        String obj = this.zzd.toString();
        return "origin=" + str + ",name=" + str2 + ",params=" + obj;
    }

    public final zzau zza() {
        return new zzau(this.zza, new zzas(new Bundle(this.zzd)), this.zzb, this.zzc);
    }
}
