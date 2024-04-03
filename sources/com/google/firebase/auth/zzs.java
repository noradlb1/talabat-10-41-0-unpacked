package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaei;
import com.google.android.gms.internal.p002firebaseauthapi.zzaeo;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.internal.zzbw;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

final class zzs implements Continuation {
    final /* synthetic */ FirebaseAuth zza;

    public zzs(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException((Exception) Preconditions.checkNotNull(task.getException()));
        }
        zzaei zzaei = (zzaei) task.getResult();
        if (zzaei instanceof zzaeo) {
            zzaeo zzaeo = (zzaeo) zzaei;
            return Tasks.forResult(new zzbw(Preconditions.checkNotEmpty(zzaeo.zzi()), Preconditions.checkNotEmpty(zzaeo.zzh()), zzaeo.zze(), zzaeo.zzd(), zzaeo.zzf(), Preconditions.checkNotEmpty(zzaeo.zzc()), this.zza));
        }
        String name2 = zzaei.getClass().getName();
        throw new IllegalArgumentException("Response should be an instance of StartTotpMfaEnrollmentResponse but was " + name2 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
    }
}
