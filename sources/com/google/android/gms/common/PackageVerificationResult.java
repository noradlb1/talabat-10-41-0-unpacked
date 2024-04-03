package com.google.android.gms.common;

import androidx.annotation.NonNull;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public class PackageVerificationResult {
    private final String zza;
    private final boolean zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private final Throwable zzd;

    private PackageVerificationResult(String str, int i11, boolean z11, @Nullable String str2, @Nullable Throwable th2) {
        this.zza = str;
        this.zzb = z11;
        this.zzc = str2;
        this.zzd = th2;
    }

    @NonNull
    public static PackageVerificationResult zza(@NonNull String str, @NonNull String str2, @Nullable Throwable th2) {
        return new PackageVerificationResult(str, 1, false, str2, th2);
    }

    @NonNull
    public static PackageVerificationResult zzd(@NonNull String str, int i11) {
        return new PackageVerificationResult(str, i11, true, (String) null, (Throwable) null);
    }

    public final void zzb() {
        if (!this.zzb) {
            String valueOf = String.valueOf(this.zzc);
            Throwable th2 = this.zzd;
            String concat = "PackageVerificationRslt: ".concat(valueOf);
            if (th2 != null) {
                throw new SecurityException(concat, th2);
            }
            throw new SecurityException(concat);
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
