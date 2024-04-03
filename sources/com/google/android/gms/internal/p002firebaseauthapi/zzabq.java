package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabq  reason: invalid package */
public final /* synthetic */ class zzabq implements Runnable {
    public final /* synthetic */ zzabs zza;
    public final /* synthetic */ zzabr zzb;
    public final /* synthetic */ TaskCompletionSource zzc;

    public /* synthetic */ zzabq(zzabs zzabs, zzabr zzabr, TaskCompletionSource taskCompletionSource) {
        this.zza = zzabs;
        this.zzb = zzabr;
        this.zzc = taskCompletionSource;
    }

    public final void run() {
        this.zzb.zzc(this.zzc, this.zza.zza);
    }
}
