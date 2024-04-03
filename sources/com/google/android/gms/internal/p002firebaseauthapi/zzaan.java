package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.PhoneAuthCredential;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaan  reason: invalid package */
public class zzaan {
    private final zzaam zza;
    private final Logger zzb;

    public zzaan(zzaam zzaam, Logger logger) {
        this.zza = (zzaam) Preconditions.checkNotNull(zzaam);
        this.zzb = (Logger) Preconditions.checkNotNull(logger);
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending auto retrieval timeout response.", e11, new Object[0]);
        }
    }

    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending send verification code response.", e11, new Object[0]);
        }
    }

    public final void zzc(zzacs zzacs) {
        try {
            this.zza.zzc(zzacs);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending create auth uri response.", e11, new Object[0]);
        }
    }

    public final void zzd() {
        try {
            this.zza.zzd();
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending delete account response.", e11, new Object[0]);
        }
    }

    public final void zze(zzwu zzwu) {
        try {
            this.zza.zze(zzwu);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending failure result with credential", e11, new Object[0]);
        }
    }

    public final void zzf(zzwv zzwv) {
        try {
            this.zza.zzf(zzwv);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending failure result for mfa", e11, new Object[0]);
        }
    }

    public final void zzg(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzg(status, phoneAuthCredential);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending failure result.", e11, new Object[0]);
        }
    }

    public void zzh(Status status) {
        try {
            this.zza.zzh(status);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending failure result.", e11, new Object[0]);
        }
    }

    public final void zzi(zzadn zzadn) {
        try {
            this.zza.zzi(zzadn);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending Play Integrity Producer project response.", e11, new Object[0]);
        }
    }

    public final void zzj(zzadq zzadq) {
        try {
            this.zza.zzj(zzadq);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending get recaptcha config response.", e11, new Object[0]);
        }
    }

    public final void zzk(zzadr zzadr, zzadi zzadi) {
        try {
            this.zza.zzk(zzadr, zzadi);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending get token and account info user response", e11, new Object[0]);
        }
    }

    public final void zzl(@Nullable zzaea zzaea) {
        try {
            this.zza.zzl(zzaea);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending password reset response.", e11, new Object[0]);
        }
    }

    public final void zzm() {
        try {
            this.zza.zzm();
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending email verification response.", e11, new Object[0]);
        }
    }

    public final void zzn(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending set account info response.", e11, new Object[0]);
        }
    }

    public final void zzo() {
        try {
            this.zza.zzo();
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when setting FirebaseUI Version", e11, new Object[0]);
        }
    }

    public final void zzp(zzaei zzaei) {
        try {
            this.zza.zzp(zzaei);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending start mfa enrollment response.", e11, new Object[0]);
        }
    }

    public final void zzq(zzadr zzadr) {
        try {
            this.zza.zzq(zzadr);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending token result.", e11, new Object[0]);
        }
    }

    public final void zzr(PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzr(phoneAuthCredential);
        } catch (RemoteException e11) {
            this.zzb.e("RemoteException when sending verification completed response.", e11, new Object[0]);
        }
    }

    public zzaan(zzaan zzaan) {
        this(zzaan.zza, zzaan.zzb);
    }
}
