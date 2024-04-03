package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzy extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzaa zzb;
    int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzy(zzaa zzaa, Continuation continuation) {
        super(continuation);
        this.zzb = zzaa;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object r22 = this.zzb.m9343executegIAlus((RecaptchaAction) null, this);
        return r22 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r22 : Result.m6328boximpl(r22);
    }
}
