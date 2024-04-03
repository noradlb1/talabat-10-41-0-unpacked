package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzag;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzy  reason: invalid package */
final class zzzy extends zzabp {
    private final boolean zzC;
    private final boolean zzD;
    @Nullable
    private final String zzE;
    @Nullable
    private final String zzF;
    private final boolean zzG;
    private final String zza;
    private final String zzb;
    @Nullable
    private final String zzc;
    private final long zzd;

    public zzzy(zzag zzag, String str, @Nullable String str2, long j11, boolean z11, boolean z12, @Nullable String str3, @Nullable String str4, boolean z13) {
        super(8);
        Preconditions.checkNotNull(zzag);
        Preconditions.checkNotEmpty(str);
        this.zza = Preconditions.checkNotEmpty(zzag.zzd());
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j11;
        this.zzC = z11;
        this.zzD = z12;
        this.zzE = str3;
        this.zzF = str4;
        this.zzG = z13;
    }

    public final String zza() {
        return "startMfaEnrollment";
    }

    public final void zzb() {
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzB(this.zza, this.zzb, this.zzc, this.zzd, this.zzC, this.zzD, this.zzE, this.zzF, this.zzG, this.zzf);
    }
}
