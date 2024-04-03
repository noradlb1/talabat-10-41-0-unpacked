package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;

final class zza extends Lambda implements Function1 {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ Deferred zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zza(TaskCompletionSource taskCompletionSource, Deferred deferred) {
        super(1);
        this.zza = taskCompletionSource;
        this.zzb = deferred;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        Exception exc;
        Throwable th2 = (Throwable) obj;
        if (th2 instanceof CancellationException) {
            this.zza.setException((Exception) th2);
        } else {
            Throwable completionExceptionOrNull = this.zzb.getCompletionExceptionOrNull();
            if (completionExceptionOrNull == null) {
                this.zza.setResult(this.zzb.getCompleted());
            } else {
                TaskCompletionSource taskCompletionSource = this.zza;
                if (completionExceptionOrNull instanceof Exception) {
                    exc = (Exception) completionExceptionOrNull;
                } else {
                    exc = null;
                }
                if (exc == null) {
                    exc = new RuntimeExecutionException(completionExceptionOrNull);
                }
                taskCompletionSource.setException(exc);
            }
        }
        return Unit.INSTANCE;
    }
}
