package com.google.firebase.auth.internal;

import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.google.android.gms.internal.p002firebaseauthapi.zzadn;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import java.security.MessageDigest;

final class zzb implements Continuation {
    final /* synthetic */ String zza;
    final /* synthetic */ IntegrityManager zzb;
    final /* synthetic */ zzf zzc;

    public zzb(zzf zzf, String str, IntegrityManager integrityManager) {
        this.zzc = zzf;
        this.zza = str;
        this.zzb = integrityManager;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (task.isSuccessful()) {
            this.zzc.zzc = ((zzadn) task.getResult()).zzb();
            return this.zzb.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(((zzadn) task.getResult()).zzb())).setNonce(new String(Base64.encode(MessageDigest.getInstance(Constants.SHA256).digest(this.zza.getBytes("UTF-8")), 11))).build());
        }
        Log.e(zzf.zza, "Problem retrieving Play Integrity producer project:  ".concat(String.valueOf(task.getException().getMessage())));
        return Tasks.forException(task.getException());
    }
}
