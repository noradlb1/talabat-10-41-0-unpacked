package com.google.firebase.auth.internal;

import android.net.Uri;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzbg implements Continuation {
    public final /* synthetic */ Uri zza;

    public /* synthetic */ zzbg(Uri uri) {
        this.zza = uri;
    }

    public final Object then(Task task) {
        return RecaptchaActivity.zzg(this.zza, task);
    }
}
