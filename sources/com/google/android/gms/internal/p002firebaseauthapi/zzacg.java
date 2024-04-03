package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacg  reason: invalid package */
final class zzacg extends zzaan {
    final /* synthetic */ zzacj zza;
    private final String zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzacg(zzacj zzacj, zzaan zzaan, String str) {
        super(zzaan);
        this.zza = zzacj;
        this.zzb = str;
    }

    public final void zzb(String str) {
        zzacj.zza.d("onCodeSent", new Object[0]);
        zzaci zzaci = (zzaci) this.zza.zzd.get(this.zzb);
        if (zzaci != null) {
            for (zzaan zzb2 : zzaci.zzb) {
                zzb2.zzb(str);
            }
            zzaci.zzg = true;
            zzaci.zzd = str;
            if (zzaci.zza <= 0) {
                this.zza.zzg(this.zzb);
            } else if (!zzaci.zzc) {
                this.zza.zzm(this.zzb);
            } else if (!zzac.zzd(zzaci.zze)) {
                zzacj.zzd(this.zza, this.zzb);
            }
        }
    }

    public final void zzh(Status status) {
        Logger zza2 = zzacj.zza;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(status.getStatusCode());
        String statusMessage = status.getStatusMessage();
        zza2.e("SMS verification code request failed: " + statusCodeString + " " + statusMessage, new Object[0]);
        zzaci zzaci = (zzaci) this.zza.zzd.get(this.zzb);
        if (zzaci != null) {
            for (zzaan zzh : zzaci.zzb) {
                zzh.zzh(status);
            }
            this.zza.zzi(this.zzb);
        }
    }
}
