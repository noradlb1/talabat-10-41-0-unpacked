package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzav extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzbh zzb;
    final /* synthetic */ List zzc;
    final /* synthetic */ zzay zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzav(zzbh zzbh, List list, zzay zzay, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzbh;
        this.zzc = list;
        this.zzd = zzay;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        zzav zzav = new zzav(this.zzb, this.zzc, this.zzd, continuation);
        zzav.zze = obj;
        return zzav;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzav) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i11 == 0) {
            CoroutineScope coroutineScope = (CoroutineScope) this.zze;
            zzdt zzb2 = zzdt.zzb();
            while (true) {
                zzbh zzbh = this.zzb;
                if (zzbh.zzb() < 0 || zzbh.zzb() >= this.zzc.size() || !CoroutineScopeKt.isActive(coroutineScope)) {
                    zzb2.zzf();
                    Boxing.boxLong(zzb2.zza(TimeUnit.MICROSECONDS));
                } else {
                    try {
                        this.zzd.zzj((zznm) this.zzc.get(this.zzb.zzb()), this.zzb);
                    } catch (Exception e11) {
                        zzay zzay = this.zzd;
                        zzbh zzbh2 = this.zzb;
                        this.zza = 1;
                        if (zzay.zzi(e11, zzbh2, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            zzb2.zzf();
            Boxing.boxLong(zzb2.zza(TimeUnit.MICROSECONDS));
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
