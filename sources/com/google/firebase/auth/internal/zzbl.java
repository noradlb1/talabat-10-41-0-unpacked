package com.google.firebase.auth.internal;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public abstract class zzbl {
    public static /* synthetic */ Task zzc(RecaptchaAction recaptchaAction, FirebaseAuth firebaseAuth, String str, Continuation continuation, Task task) throws Exception {
        if (task.isSuccessful()) {
            return Tasks.forResult(task.getResult());
        }
        Exception exc = (Exception) Preconditions.checkNotNull(task.getException());
        int i11 = zzaap.zzb;
        if (!(exc instanceof FirebaseAuthException) || !((FirebaseAuthException) exc).getErrorCode().endsWith("MISSING_RECAPTCHA_TOKEN")) {
            String valueOf = String.valueOf(recaptchaAction);
            String message = exc.getMessage();
            Log.e("RecaptchaCallWrapper", "Initial task failed for action " + valueOf + "with exception - " + message);
            return Tasks.forException(exc);
        }
        if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
            Log.i("RecaptchaCallWrapper", "Falling back to recaptcha enterprise flow for action ".concat(String.valueOf(recaptchaAction)));
        }
        if (firebaseAuth.zzB() == null) {
            firebaseAuth.zzP(new zzbr(firebaseAuth.getApp(), firebaseAuth));
        }
        return zzd(firebaseAuth.zzB(), recaptchaAction, str, continuation);
    }

    private static Task zzd(zzbr zzbr, RecaptchaAction recaptchaAction, @Nullable String str, Continuation continuation) {
        Task zza = zzbr.zza(str, Boolean.FALSE, recaptchaAction);
        return zza.continueWithTask(continuation).continueWithTask(new zzbk(str, zzbr, recaptchaAction, continuation));
    }

    public abstract Task zza(@Nullable String str);

    public final Task zzb(FirebaseAuth firebaseAuth, @Nullable String str, RecaptchaAction recaptchaAction) {
        zzbi zzbi = new zzbi(this);
        zzbr zzB = firebaseAuth.zzB();
        if (zzB == null || !zzB.zze()) {
            return zza((String) null).continueWithTask(new zzbj(recaptchaAction, firebaseAuth, str, zzbi));
        }
        return zzd(zzB, recaptchaAction, str, zzbi);
    }
}
