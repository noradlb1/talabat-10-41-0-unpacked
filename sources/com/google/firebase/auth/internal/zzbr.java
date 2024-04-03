package com.google.firebase.auth.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.internal.p002firebaseauthapi.zzadq;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import java.util.HashMap;
import java.util.Map;

public final class zzbr {
    final Map zza = new HashMap();
    final FirebaseApp zzb;
    final FirebaseAuth zzc;
    final zzbm zzd;
    /* access modifiers changed from: private */
    @Nullable
    public zzadq zze;

    public zzbr(FirebaseApp firebaseApp, FirebaseAuth firebaseAuth) {
        zzbn zzbn = new zzbn();
        this.zzb = firebaseApp;
        this.zzc = firebaseAuth;
        this.zzd = zzbn;
    }

    public static void zzd() throws zzbs {
    }

    @Nullable
    private final Task zzf(String str) {
        return (Task) this.zza.get(str);
    }

    private static String zzg(@Nullable String str) {
        return zzac.zzd(str) ? "*" : str;
    }

    public final Task zza(@Nullable String str, Boolean bool, RecaptchaAction recaptchaAction) {
        try {
            zzd();
            String zzg = zzg(str);
            Task zzf = zzf(zzg);
            if (bool.booleanValue() || zzf == null) {
                zzf = zzb(zzg, bool);
            }
            return zzf.continueWithTask(new zzbq(this, recaptchaAction));
        } catch (zzbs e11) {
            return Tasks.forException(e11);
        }
    }

    public final Task zzb(@Nullable String str, Boolean bool) {
        Task zzf;
        try {
            zzd();
            String zzg = zzg(str);
            if (bool.booleanValue() || (zzf = zzf(zzg)) == null) {
                return this.zzc.zze("RECAPTCHA_ENTERPRISE").continueWithTask(new zzbp(this, zzg));
            }
            return zzf;
        } catch (zzbs e11) {
            return Tasks.forException(e11);
        }
    }

    public final boolean zze() {
        zzadq zzadq = this.zze;
        return zzadq != null && zzadq.zzc();
    }
}
