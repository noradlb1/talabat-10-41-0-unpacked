package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaap;
import com.google.android.gms.internal.p002firebaseauthapi.zzabb;
import com.google.android.gms.internal.p002firebaseauthapi.zzacn;
import com.google.android.gms.internal.p002firebaseauthapi.zzadn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException;

public final class zzf {
    /* access modifiers changed from: private */
    public static final String zza = "zzf";
    private static final zzf zzb = new zzf();
    /* access modifiers changed from: private */
    public String zzc;

    private zzf() {
    }

    public static zzf zzb() {
        return zzb;
    }

    private final void zzf(FirebaseAuth firebaseAuth, zzbz zzbz, Activity activity, TaskCompletionSource taskCompletionSource) {
        Task task;
        if (activity == null) {
            taskCompletionSource.setException(new FirebaseAuthMissingActivityForRecaptchaException());
            return;
        }
        zzbz.zzg(firebaseAuth.getApp().getApplicationContext(), firebaseAuth);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        if (!zzax.zza().zzg(activity, taskCompletionSource2)) {
            task = Tasks.forException(zzaap.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        } else {
            Intent intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            intent.setClass(activity, RecaptchaActivity.class);
            intent.setPackage(activity.getPackageName());
            intent.putExtra("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.getApp().getOptions().getApiKey());
            if (!TextUtils.isEmpty(firebaseAuth.getTenantId())) {
                intent.putExtra("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            }
            intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", zzabb.zza().zzb());
            intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", firebaseAuth.getApp().getName());
            activity.startActivity(intent);
            task = taskCompletionSource2.getTask();
        }
        task.addOnSuccessListener(new zzd(this, taskCompletionSource)).addOnFailureListener(new zzc(this, taskCompletionSource));
    }

    public final Task zza(FirebaseAuth firebaseAuth, @Nullable String str, @Nullable Activity activity, boolean z11, boolean z12) {
        Task task;
        zzw zzw = (zzw) firebaseAuth.getFirebaseAuthSettings();
        zzbz zzc2 = zzbz.zzc();
        if (zzacn.zzg(firebaseAuth.getApp()) || zzw.zze()) {
            return Tasks.forResult(new zze((String) null, (String) null));
        }
        String str2 = zza;
        boolean zzc3 = zzw.zzc();
        Log.i(str2, "ForceRecaptchaFlow from phoneAuthOptions = " + z12 + ", ForceRecaptchaFlow from firebaseSettings = " + zzc3);
        boolean zzc4 = z12 | zzw.zzc();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task zzb2 = zzc2.zzb();
        if (zzb2 != null) {
            if (zzb2.isSuccessful()) {
                return Tasks.forResult(new zze((String) zzb2.getResult(), (String) null));
            }
            Log.e(str2, "Error in previous reCAPTCHA flow: ".concat(String.valueOf(zzb2.getException().getMessage())));
            Log.e(str2, "Continuing with application verification as normal");
        }
        if (!z11 || zzc4) {
            zzf(firebaseAuth, zzc2, activity, taskCompletionSource);
        } else {
            IntegrityManager create = IntegrityManagerFactory.create(firebaseAuth.getApp().getApplicationContext());
            if (!TextUtils.isEmpty(this.zzc)) {
                task = Tasks.forResult(new zzadn(this.zzc));
            } else {
                task = firebaseAuth.zzd();
            }
            task.continueWithTask(firebaseAuth.zzM(), new zzb(this, str, create)).addOnCompleteListener(new zza(this, taskCompletionSource, firebaseAuth, zzc2, activity));
        }
        return taskCompletionSource.getTask();
    }

    public final /* synthetic */ void zze(TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzbz zzbz, Activity activity, Task task) {
        String str;
        if (!task.isSuccessful() || task.getResult() == null || TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            if (task.getException() == null) {
                str = "";
            } else {
                str = task.getException().getMessage();
            }
            Log.e(zza, "Play Integrity Token fetch failed, falling back to Recaptcha".concat(String.valueOf(str)));
            zzf(firebaseAuth, zzbz, activity, taskCompletionSource);
            return;
        }
        taskCompletionSource.setResult(new zze((String) null, ((IntegrityTokenResponse) task.getResult()).token()));
    }
}
