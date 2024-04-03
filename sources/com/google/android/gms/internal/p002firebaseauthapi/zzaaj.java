package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzo;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaj  reason: invalid package */
final class zzaaj extends zzabp {
    private final String zza;
    @Nullable
    private final String zzb;

    public zzaaj(String str, @Nullable String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return "verifyPasswordResetCode";
    }

    public final void zzb() {
        if (new zzo(this.zzq).getOperation() != 0) {
            zzl(new Status(FirebaseError.ERROR_INTERNAL_ERROR));
        } else {
            zzm(this.zzq.zzc());
        }
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzd(this.zza, this.zzb, this.zzf);
    }
}
