package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzax extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzbh zzb;
    final /* synthetic */ zzay zzc;
    final /* synthetic */ String zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzax(zzbh zzbh, zzay zzay, String str, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzbh;
        this.zzc = zzay;
        this.zzd = str;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzax(this.zzb, this.zzc, this.zzd, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzax) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.zza;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            this.zzb.zza = new zzm();
            zzni zzg = zzni.zzg(zzek.zzh().zzj(this.zzd));
            zzdt zzb2 = zzdt.zzb();
            zzna zzb3 = this.zzc.zzg(zzg.zzi(), zzg.zzj());
            zzb2.zzf();
            long zza2 = zzb2.zza(TimeUnit.MICROSECONDS);
            zzj zzj = zzj.zza;
            zzj.zza(zzl.zzm.zza(), zza2);
            zzay zzay = this.zzc;
            List zzi = zzb3.zzi();
            zzbh zzbh = this.zzb;
            this.zza = 1;
            if (zzay.zzh(zzi, zzbh, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 != 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e11) {
                zzay zzay2 = this.zzc;
                zzbh zzbh2 = this.zzb;
                this.zza = 2;
                if (zzay2.zzi(e11, zzbh2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
