package com.google.android.recaptcha.internal;

import android.app.Application;
import android.webkit.WebView;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzu extends ContinuationImpl {
    Object zza;
    Object zzb;
    Object zzc;
    long zzd;
    /* synthetic */ Object zze;
    final /* synthetic */ zzv zzf;
    int zzg;
    zzq zzh;
    zzdi zzi;
    Mutex zzj;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzu(zzv zzv, Continuation continuation) {
        super(continuation);
        this.zzf = zzv;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.zze = obj;
        this.zzg |= Integer.MIN_VALUE;
        return this.zzf.zza((Application) null, (String) null, 0, (zzq) null, (WebView) null, this);
    }
}
