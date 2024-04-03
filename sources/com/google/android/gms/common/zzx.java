package com.google.android.gms.common;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
class zzx {
    private static final zzx zze = new zzx(true, 3, 1, (String) null, (Throwable) null);
    final boolean zza;
    @Nullable
    final String zzb;
    @Nullable
    final Throwable zzc;
    final int zzd;

    private zzx(boolean z11, int i11, int i12, @Nullable String str, @Nullable Throwable th2) {
        this.zza = z11;
        this.zzd = i11;
        this.zzb = str;
        this.zzc = th2;
    }

    public /* synthetic */ zzx(boolean z11, int i11, int i12, String str, Throwable th2, zzw zzw) {
        this(false, 1, 5, (String) null, (Throwable) null);
    }

    @Deprecated
    public static zzx zzb() {
        return zze;
    }

    public static zzx zzc(@NonNull String str) {
        return new zzx(false, 1, 5, str, (Throwable) null);
    }

    public static zzx zzd(@NonNull String str, @NonNull Throwable th2) {
        return new zzx(false, 1, 5, str, th2);
    }

    public static zzx zzf(int i11) {
        return new zzx(true, i11, 1, (String) null, (Throwable) null);
    }

    public static zzx zzg(int i11, int i12, @NonNull String str, @Nullable Throwable th2) {
        return new zzx(false, i11, i12, str, th2);
    }

    @Nullable
    public String zza() {
        return this.zzb;
    }

    public final void zze() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.zzc != null) {
                zza();
            } else {
                zza();
            }
        }
    }
}
