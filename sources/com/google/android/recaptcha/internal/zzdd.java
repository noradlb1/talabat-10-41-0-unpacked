package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzdd extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzdi zzb;
    int zzc;
    zzdi zzd;
    String zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdd(zzdi zzdi, Continuation continuation) {
        super(continuation);
        this.zzb = zzdi;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzf = this.zzb.zzf((RecaptchaAction) null, 0, this);
        return zzf == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? zzf : Result.m6328boximpl(zzf);
    }
}
