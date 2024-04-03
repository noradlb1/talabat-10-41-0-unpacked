package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzdf extends ContinuationImpl {
    long zza;
    /* synthetic */ Object zzb;
    final /* synthetic */ zzdi zzc;
    int zzd;
    zzdi zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdf(zzdi zzdi, Continuation continuation) {
        super(continuation);
        this.zzc = zzdi;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        Object zzg = this.zzc.zzg(0, this);
        return zzg == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zzg : Result.m6328boximpl(zzg);
    }
}
