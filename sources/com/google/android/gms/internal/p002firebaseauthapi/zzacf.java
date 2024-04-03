package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacf  reason: invalid package */
final class zzacf implements OnFailureListener {
    public zzacf(zzacj zzacj) {
    }

    public final void onFailure(@NonNull Exception exc) {
        zzacj.zza.e("SmsRetrieverClient failed to start: ".concat(String.valueOf(exc.getMessage())), new Object[0]);
    }
}
