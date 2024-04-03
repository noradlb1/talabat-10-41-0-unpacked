package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneMultiFactorInfo;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaa  reason: invalid package */
final class zzaaa extends zzabp {
    private final zzws zza;

    public zzaaa(PhoneMultiFactorInfo phoneMultiFactorInfo, String str, @Nullable String str2, long j11, boolean z11, boolean z12, @Nullable String str3, @Nullable String str4, boolean z13) {
        super(8);
        Preconditions.checkNotNull(phoneMultiFactorInfo);
        Preconditions.checkNotEmpty(str);
        this.zza = new zzws(phoneMultiFactorInfo, str, str2, j11, z11, z12, str3, str4, z13);
    }

    public final String zza() {
        return "startMfaSignInWithPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzC(this.zza, this.zzf);
    }
}
