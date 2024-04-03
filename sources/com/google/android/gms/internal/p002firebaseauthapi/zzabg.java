package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.annotation.MainThread;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabg  reason: invalid package */
final class zzabg extends LifecycleCallback {
    private final List zza;

    private zzabg(LifecycleFragment lifecycleFragment, List list) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("PhoneAuthActivityStopCallback", this);
        this.zza = list;
    }

    public static void zza(Activity activity, List list) {
        LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
        if (((zzabg) fragment.getCallbackOrNull("PhoneAuthActivityStopCallback", zzabg.class)) == null) {
            new zzabg(fragment, list);
        }
    }

    @MainThread
    public final void onStop() {
        synchronized (this.zza) {
            this.zza.clear();
        }
    }
}
