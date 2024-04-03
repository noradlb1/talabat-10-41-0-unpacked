package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaal;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zze;

final class zzk implements OnCompleteListener {
    final /* synthetic */ PhoneAuthOptions zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ FirebaseAuth zzc;

    public zzk(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zzc = firebaseAuth;
        this.zza = phoneAuthOptions;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        String str;
        String str2;
        boolean z11;
        boolean z12;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            String str3 = "Error while validating application identity: ";
            if (exception != null) {
                str3 = str3.concat(String.valueOf(exception.getMessage()));
            }
            Log.e("FirebaseAuth", str3);
            if (exception instanceof FirebaseAuthMissingActivityForRecaptchaException) {
                FirebaseAuth.zzX((FirebaseAuthMissingActivityForRecaptchaException) exception, this.zza, this.zzb);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            str2 = null;
            str = null;
        } else {
            str2 = ((zze) task.getResult()).zzb();
            str = ((zze) task.getResult()).zza();
        }
        long longValue = this.zza.zzg().longValue();
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zzx = this.zzc.zzab(this.zza.zzh(), this.zza.zze());
        if (TextUtils.isEmpty(str2)) {
            zzx = this.zzc.zzy(this.zza, zzx);
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = zzx;
        zzag zzag = (zzag) Preconditions.checkNotNull(this.zza.zzc());
        if (zzag.zzf()) {
            zzaal zzz = this.zzc.zzf;
            String str4 = (String) Preconditions.checkNotNull(this.zza.zzh());
            String zzG = this.zzc.zzj;
            if (this.zza.zzd() != null) {
                z12 = true;
            } else {
                z12 = false;
            }
            zzz.zzH(zzag, str4, zzG, longValue, z12, this.zza.zzl(), str2, str, this.zzc.zzW(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
            return;
        }
        zzaal zzz2 = this.zzc.zzf;
        PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.zza.zzf());
        String zzG2 = this.zzc.zzj;
        if (this.zza.zzd() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzz2.zzJ(zzag, phoneMultiFactorInfo, zzG2, longValue, z11, this.zza.zzl(), str2, str, this.zzc.zzW(), onVerificationStateChangedCallbacks, this.zza.zzi(), this.zza.zza());
    }
}
