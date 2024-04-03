package com.google.android.recaptcha.internal;

import android.os.Build;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzdh extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzdi zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdh(zzdi zzdi, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzdi;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzdh(this.zzb, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzdh) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i11 == 0) {
            zzt zzt = zzt.zza;
            String zza2 = zzt.zza(this.zzb.zze);
            String zzj = this.zzb.zzd;
            String packageName = this.zzb.zze.getPackageName();
            String zzi = this.zzb.zzh;
            int i12 = Build.VERSION.SDK_INT;
            String encode = URLEncoder.encode(zzj, "UTF-8");
            String encode2 = URLEncoder.encode(packageName, "UTF-8");
            String encode3 = URLEncoder.encode(zza2, "UTF-8");
            String encode4 = URLEncoder.encode("18.2.1", "UTF-8");
            String encode5 = URLEncoder.encode(zzi, "UTF-8");
            byte[] bytes = ("k=" + encode + "&pk=" + encode2 + "&mst=" + encode3 + "&msv=" + encode4 + "&msi=" + encode5 + "&mov=" + i12).getBytes(Charset.forName("UTF-8"));
            zzai zzai = zzai.zza;
            zzai.zzc(new zzaf(zzln.INIT_NATIVE, this.zzb.zzg, this.zzb.zzh, this.zzb.zzh, (String) null), this.zzb.zze, this.zzb.zzf);
            zzai.zzb(new zzaf(zzln.INIT_NETWORK, this.zzb.zzg, this.zzb.zzh, this.zzb.zzh, (String) null), this.zzb.zzd, new zzr());
            Job unused = BuildersKt__Builders_commonKt.launch$default(zzp.zza(), (CoroutineContext) null, (CoroutineStart) null, new zzdg(this.zzb, zza2, (Continuation) null), 3, (Object) null);
            this.zzb.zzn.zzd();
            this.zzb.zzn.zze();
            zzdi zzdi = this.zzb;
            zzdi.zzb().postUrl(zzdi.zzf.zza(), bytes);
            Boxing.boxInt(this.zzb.zzm().hashCode());
            CompletableDeferred zzm = this.zzb.zzm();
            this.zza = 1;
            if (zzm.await(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Result.m6328boximpl(Result.m6329constructorimpl(Unit.INSTANCE));
    }
}
