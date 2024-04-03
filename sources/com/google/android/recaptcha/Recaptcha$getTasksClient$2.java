package com.google.android.recaptcha;

import android.app.Application;
import android.webkit.WebView;
import com.google.android.recaptcha.internal.zzaa;
import com.google.android.recaptcha.internal.zzq;
import com.google.android.recaptcha.internal.zzv;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Recaptcha$getTasksClient$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super zzaa>, Object> {
    int zza;
    final /* synthetic */ Application zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recaptcha$getTasksClient$2(Application application, String str, long j11, Continuation continuation) {
        super(2, continuation);
        this.zzb = application;
        this.zzc = str;
        this.zzd = j11;
    }

    @NotNull
    public final Continuation create(@Nullable Object obj, @NotNull Continuation continuation) {
        return new Recaptcha$getTasksClient$2(this.zzb, this.zzc, this.zzd, continuation);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((Recaptcha$getTasksClient$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.zza;
        ResultKt.throwOnFailure(obj);
        if (i11 == 0) {
            zzv zzv = zzaa.zza;
            Application application = this.zzb;
            String str = this.zzc;
            long j11 = this.zzd;
            this.zza = 1;
            obj = zzv.zza(application, str, j11, new zzq("https://www.recaptcha.net/recaptcha/api3"), (WebView) null, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }
}
