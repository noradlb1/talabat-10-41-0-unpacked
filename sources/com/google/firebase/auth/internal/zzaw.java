package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaap;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import java.lang.ref.WeakReference;

final class zzaw extends BroadcastReceiver {
    final /* synthetic */ zzax zza;
    private final WeakReference zzb;
    private final TaskCompletionSource zzc;

    public zzaw(zzax zzax, Activity activity, TaskCompletionSource taskCompletionSource) {
        this.zza = zzax;
        this.zzb = new WeakReference(activity);
        this.zzc = taskCompletionSource;
    }

    public final void onReceive(Context context, Intent intent) {
        if (((Activity) this.zzb.get()) == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.zzc.setException(zzaap.zza(new Status((int) FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.zze(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
                this.zzc.setResult(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
                zzax.zze(context);
                return;
            }
            TaskCompletionSource taskCompletionSource = this.zzc;
            taskCompletionSource.setException(zzaap.zza(zzai.zza("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
        } else if (zzby.zzc(intent)) {
            this.zzc.setException(zzaap.zza(zzby.zza(intent)));
            zzax.zze(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.zzc.setException(zzaap.zza(zzai.zza("WEB_CONTEXT_CANCELED")));
            zzax.zze(context);
        }
    }
}
