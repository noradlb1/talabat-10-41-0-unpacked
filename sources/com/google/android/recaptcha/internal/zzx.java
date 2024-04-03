package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzx extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzaa zzb;
    final /* synthetic */ RecaptchaAction zzc;
    final /* synthetic */ long zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzx(zzaa zzaa, RecaptchaAction recaptchaAction, long j11, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzaa;
        this.zzc = recaptchaAction;
        this.zzd = j11;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzx(this.zzb, this.zzc, this.zzd, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzx) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i11 != 0) {
            obj2 = ((Result) obj).m6338unboximpl();
        } else {
            zzdi zzb2 = this.zzb.zzb();
            RecaptchaAction recaptchaAction = this.zzc;
            long j11 = this.zzd;
            this.zza = 1;
            obj2 = zzb2.zzf(recaptchaAction, j11, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Result.m6328boximpl(obj2);
    }
}
