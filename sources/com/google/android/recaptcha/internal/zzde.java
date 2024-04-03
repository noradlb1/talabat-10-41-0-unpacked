package com.google.android.recaptcha.internal;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.recaptcha.RecaptchaAction;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class zzde extends SuspendLambda implements Function2 {
    Object zza;
    Object zzb;
    Object zzc;
    int zzd;
    final /* synthetic */ RecaptchaAction zze;
    final /* synthetic */ zzdi zzf;
    final /* synthetic */ String zzg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzde(RecaptchaAction recaptchaAction, zzdi zzdi, String str, Continuation continuation) {
        super(2, continuation);
        this.zze = recaptchaAction;
        this.zzf = zzdi;
        this.zzg = str;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new zzde(this.zze, this.zzf, this.zzg, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzde) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.zzd;
        ResultKt.throwOnFailure(obj);
        if (i11 == 0) {
            zzdi zzdi = this.zzf;
            String str = this.zzg;
            RecaptchaAction recaptchaAction = this.zze;
            this.zza = zzdi;
            this.zzb = str;
            this.zzc = recaptchaAction;
            this.zzd = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            zzdi.zzk.put(str, cancellableContinuationImpl);
            zzmr zzf2 = zzms.zzf();
            zzf2.zze(str);
            zzf2.zzd(recaptchaAction.getAction());
            byte[] zzd2 = ((zzms) zzf2.zzj()).zzd();
            String zzi = zzek.zzh().zzi(zzd2, 0, zzd2.length);
            zzai zzai = zzai.zza;
            zzai.zzc(new zzaf(zzln.EXECUTE_NATIVE, zzdi.zzg, zzdi.zzh, str, (String) null), zzdi.zze, zzdi.zzf);
            WebView zzb2 = zzdi.zzb();
            zzb2.evaluateJavascript("recaptcha.m.Main.execute(\"" + zzi + "\")", (ValueCallback) null);
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
