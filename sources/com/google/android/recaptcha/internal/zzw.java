package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzw extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaa zzb;
    int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzw(zzaa zzaa, Continuation continuation) {
        super(continuation);
        this.zzb = zzaa;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object r42 = this.zzb.m9342execute0E7RQCE((RecaptchaAction) null, 0, this);
        return r42 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r42 : Result.m6328boximpl(r42);
    }
}
