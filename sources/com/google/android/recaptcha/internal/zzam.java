package com.google.android.recaptcha.internal;

import java.util.Timer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzam extends SuspendLambda implements Function2 {
    final /* synthetic */ zzao zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzam(zzao zzao, Continuation continuation) {
        super(2, continuation);
        this.zza = zzao;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzam(this.zza, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzam) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzao zzao = this.zza;
        synchronized (zzaj.class) {
            if (zzao.zze.zzb() == 0) {
                Timer zzb = zzao.zzb;
                if (zzb != null) {
                    zzb.cancel();
                }
                zzao.zzb = null;
            }
            zzao.zzg();
        }
        return Unit.INSTANCE;
    }
}
