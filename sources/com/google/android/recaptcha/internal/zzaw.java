package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzaw extends SuspendLambda implements Function2 {
    final /* synthetic */ Exception zza;
    final /* synthetic */ zzbh zzb;
    final /* synthetic */ zzay zzc;
    private /* synthetic */ Object zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaw(Exception exc, zzbh zzbh, zzay zzay, Continuation continuation) {
        super(2, continuation);
        this.zza = exc;
        this.zzb = zzbh;
        this.zzc = zzay;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        zzaw zzaw = new zzaw(this.zza, this.zzb, this.zzc, continuation);
        zzaw.zzd = obj;
        return zzaw;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzaw) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        zznb zznb;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.zzd;
        Exception exc = this.zza;
        if (exc instanceof zzs) {
            zznb = ((zzs) exc).zza();
            zznb.zzd(this.zzb.zzb());
        } else {
            zznb = zznc.zzf();
            zznb.zzd(this.zzb.zzb());
            zznb.zzp(2);
            zznb.zze(2);
        }
        zznc zznc = (zznc) zznb.zzj();
        zznc.zzk();
        zznc.zzj();
        Reflection.getOrCreateKotlinClass(this.zza.getClass()).getSimpleName();
        this.zza.getMessage();
        zzbh zzbh = this.zzb;
        zzm zzc2 = zzbh.zzc();
        zzm zzm = zzbh.zza;
        if (zzm == null) {
            zzm = null;
        }
        zzlx zza2 = zzar.zza(zzc2, zzm);
        String zzf = this.zzb.zzf();
        if (zzf.length() == 0) {
            zzf = "recaptcha.m.Main.rge";
        }
        if (CoroutineScopeKt.isActive(coroutineScope)) {
            zzay zzay = this.zzc;
            zzek zzh = zzek.zzh();
            byte[] zzd2 = zznc.zzd();
            zzek zzh2 = zzek.zzh();
            byte[] zzd3 = zza2.zzd();
            zzay.zzb.zzb(zzf, (String[]) Arrays.copyOf(new String[]{zzh.zzi(zzd2, 0, zzd2.length), zzh2.zzi(zzd3, 0, zzd3.length)}, 2));
        }
        return Unit.INSTANCE;
    }
}
