package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzaj;
import java.util.List;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyw  reason: invalid package */
final class zzyw extends zzabp {
    private final String zza;
    @Nullable
    private final String zzb;

    public zzyw(String str, @Nullable String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public final void zzb() {
        List list;
        if (this.zzp.zzb() == null) {
            list = zzam.zzi();
        } else {
            list = (List) Preconditions.checkNotNull(this.zzp.zzb());
        }
        zzm(new zzaj(list));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzl(this.zza, this.zzb, this.zzf);
    }
}
