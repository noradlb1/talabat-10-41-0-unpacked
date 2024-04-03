package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zze;

final class zzj implements OnCompleteListener {
    final /* synthetic */ PhoneAuthOptions zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ FirebaseAuth zzc;

    public zzj(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.zzc = firebaseAuth;
        this.zza = phoneAuthOptions;
        this.zzb = str;
    }

    public final void onComplete(Task task) {
        String str;
        String str2;
        String str3;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception instanceof FirebaseAuthMissingActivityForRecaptchaException) {
                FirebaseAuth.zzX((FirebaseAuthMissingActivityForRecaptchaException) exception, this.zza, this.zzb);
                return;
            }
            if (task.getException() != null) {
                str3 = task.getException().getMessage();
            } else {
                str3 = "";
            }
            Log.e("FirebaseAuth", "Error while validating application identity: ".concat(String.valueOf(str3)));
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            str = null;
            str2 = null;
        } else {
            String zzb2 = ((zze) task.getResult()).zzb();
            str2 = ((zze) task.getResult()).zza();
            str = zzb2;
        }
        this.zzc.zzV(this.zza, str, str2);
    }
}
