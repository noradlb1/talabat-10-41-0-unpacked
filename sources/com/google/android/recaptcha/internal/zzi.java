package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;

public final class zzi implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    @NotNull
    public final String toString() {
        String padEnd$default = StringsKt__StringsKt.padEnd$default(String.valueOf(this.zzb / ((long) this.zza)), 10, 0, 2, (Object) null);
        String padEnd$default2 = StringsKt__StringsKt.padEnd$default(String.valueOf(this.zzc), 10, 0, 2, (Object) null);
        String padEnd$default3 = StringsKt__StringsKt.padEnd$default(String.valueOf(this.zzb), 10, 0, 2, (Object) null);
        String padEnd$default4 = StringsKt__StringsKt.padEnd$default(String.valueOf(this.zza), 5, 0, 2, (Object) null);
        return "avgExecutionTime: " + padEnd$default + " us| maxExecutionTime: " + padEnd$default2 + " us| totalTime: " + padEnd$default3 + " us| #Usages: " + padEnd$default4;
    }

    /* renamed from: zza */
    public final int compareTo(@NotNull zzi zzi) {
        return ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(this.zzb), Long.valueOf(zzi.zzb));
    }

    public final int zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final void zze(long j11) {
        this.zzc = j11;
    }

    public final void zzf(long j11) {
        this.zzb = j11;
    }

    public final void zzg(int i11) {
        this.zza = i11;
    }
}
