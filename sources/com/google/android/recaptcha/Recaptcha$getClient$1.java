package com.google.android.recaptcha;

import android.app.Application;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Recaptcha$getClient$1 extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ Recaptcha zzb;
    int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recaptcha$getClient$1(Recaptcha recaptcha, Continuation continuation) {
        super(continuation);
        this.zzb = recaptcha;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object r72 = this.zzb.m9339getClientBWLJW6A((Application) null, (String) null, 0, this);
        return r72 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r72 : Result.m6328boximpl(r72);
    }
}
