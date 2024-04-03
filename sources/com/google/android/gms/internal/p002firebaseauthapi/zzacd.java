package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.PhoneAuthProvider;
import com.newrelic.agent.android.payload.PayloadController;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacd  reason: invalid package */
public final class zzacd {
    private static final Map zza = new ArrayMap();

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable zzabp zzabp) {
        zze(str, zzabp);
        return new zzacb(onVerificationStateChangedCallbacks, str);
    }

    public static void zzc() {
        zza.clear();
    }

    public static boolean zzd(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, Executor executor) {
        Map map = zza;
        if (map.containsKey(str)) {
            zzacc zzacc = (zzacc) map.get(str);
            if (DefaultClock.getInstance().currentTimeMillis() - zzacc.zzb < PayloadController.PAYLOAD_REQUEUE_PERIOD_MS) {
                zzabp zzabp = zzacc.zza;
                if (zzabp == null) {
                    return true;
                }
                zzabp.zzh(onVerificationStateChangedCallbacks, activity, executor, str);
                return true;
            }
            zze(str, (zzabp) null);
            return false;
        }
        zze(str, (zzabp) null);
        return false;
    }

    private static void zze(String str, @Nullable zzabp zzabp) {
        zza.put(str, new zzacc(zzabp, DefaultClock.getInstance().currentTimeMillis()));
    }
}
