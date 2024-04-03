package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.internal.zzao;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabm  reason: invalid package */
final class zzabm implements zzaam {
    final /* synthetic */ zzabp zza;

    public zzabm(zzabp zzabp) {
        this.zza = zzabp;
    }

    private final void zzs(zzabn zzabn) {
        this.zza.zzm.execute(new zzabl(this, zzabn));
    }

    private final void zzt(Status status, AuthCredential authCredential, @Nullable String str, @Nullable String str2) {
        zzabp.zzk(this.zza, status);
        zzabp zzabp = this.zza;
        zzabp.zzt = authCredential;
        zzabp.zzu = str;
        zzabp.zzv = str2;
        zzao zzao = zzabp.zzj;
        if (zzao != null) {
            zzao.zzb(status);
        }
        this.zza.zzl(status);
    }

    public final void zza(String str) throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str2 = "Unexpected response type " + i11;
        if (i11 == 8) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str2);
        zzabp zzabp = this.zza;
        zzabp.zzs = str;
        zzabp.zza = true;
        zzs(new zzabj(this, str));
    }

    public final void zzb(String str) throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str2 = "Unexpected response type " + i11;
        if (i11 == 8) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str2);
        this.zza.zzs = str;
        zzs(new zzabh(this, str));
    }

    public final void zzc(zzacs zzacs) throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str = "Unexpected response type " + i11;
        if (i11 == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str);
        zzabp zzabp = this.zza;
        zzabp.zzp = zzacs;
        zzabp.zzj(zzabp);
    }

    public final void zzd() throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str = "Unexpected response type " + i11;
        if (i11 == 5) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str);
        zzabp.zzj(this.zza);
    }

    public final void zze(zzwu zzwu) {
        zzt(zzwu.zza(), zzwu.zzb(), zzwu.zzc(), zzwu.zzd());
    }

    public final void zzf(zzwv zzwv) {
        zzabp zzabp = this.zza;
        zzabp.zzw = zzwv;
        zzabp.zzl(zzai.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    public final void zzg(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str = "Unexpected response type " + i11;
        if (i11 == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str);
        zzt(status, phoneAuthCredential, (String) null, (String) null);
    }

    public final void zzh(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzabp zzabp = this.zza;
        if (zzabp.zze == 8) {
            zzabp.zza = true;
            zzs(new zzabk(this, status));
            return;
        }
        zzabp.zzk(zzabp, status);
        this.zza.zzl(status);
    }

    public final void zzi(zzadn zzadn) throws RemoteException {
        zzabp zzabp = this.zza;
        zzabp.zzy = zzadn;
        zzabp.zzj(zzabp);
    }

    public final void zzj(zzadq zzadq) throws RemoteException {
        zzabp zzabp = this.zza;
        zzabp.zzx = zzadq;
        zzabp.zzj(zzabp);
    }

    public final void zzk(zzadr zzadr, zzadi zzadi) throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str = "Unexpected response type: " + i11;
        if (i11 == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str);
        zzabp zzabp = this.zza;
        zzabp.zzn = zzadr;
        zzabp.zzo = zzadi;
        zzabp.zzj(zzabp);
    }

    public final void zzl(@Nullable zzaea zzaea) throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str = "Unexpected response type " + i11;
        if (i11 == 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str);
        zzabp zzabp = this.zza;
        zzabp.zzq = zzaea;
        zzabp.zzj(zzabp);
    }

    public final void zzm() throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str = "Unexpected response type " + i11;
        if (i11 == 6) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str);
        zzabp.zzj(this.zza);
    }

    public final void zzn(String str) throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str2 = "Unexpected response type " + i11;
        if (i11 == 7) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str2);
        zzabp zzabp = this.zza;
        zzabp.zzr = str;
        zzabp.zzj(zzabp);
    }

    public final void zzo() throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str = "Unexpected response type " + i11;
        if (i11 == 9) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str);
        zzabp.zzj(this.zza);
    }

    public final void zzp(zzaei zzaei) throws RemoteException {
        zzabp zzabp = this.zza;
        zzabp.zzz = zzaei;
        zzabp.zzj(zzabp);
    }

    public final void zzq(zzadr zzadr) throws RemoteException {
        int i11 = this.zza.zze;
        String str = "Unexpected response type: " + i11;
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        Preconditions.checkState(z11, str);
        zzabp zzabp = this.zza;
        zzabp.zzn = zzadr;
        zzabp.zzj(zzabp);
    }

    public final void zzr(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z11;
        int i11 = this.zza.zze;
        String str = "Unexpected response type " + i11;
        if (i11 == 8) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, str);
        this.zza.zza = true;
        zzs(new zzabi(this, phoneAuthCredential));
    }
}
