package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaao  reason: invalid package */
public final class zzaao {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzyp zzb;
    private final zzacj zzc;

    public zzaao(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        Preconditions.checkNotNull(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzb = new zzyp(new zzabc(firebaseApp, zzabb.zza(), (zzaca) null, (zzaaw) null, (zzaax) null));
        this.zzc = new zzacj(applicationContext, scheduledExecutorService);
    }

    private static boolean zzJ(long j11, boolean z11) {
        if (j11 > 0 && z11) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }

    public final void zzA(zzwr zzwr, zzaam zzaam) {
        Preconditions.checkNotNull(zzaam);
        Preconditions.checkNotNull(zzwr);
        this.zzb.zzG(zzabz.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzwr.zza())), new zzaan(zzaam, zza));
    }

    public final void zzB(String str, String str2, @Nullable String str3, long j11, boolean z11, boolean z12, @Nullable String str4, @Nullable String str5, boolean z13, zzaam zzaam) {
        String str6 = str2;
        String str7 = str;
        Preconditions.checkNotEmpty(str, "idToken should not be empty.");
        Preconditions.checkNotNull(zzaam);
        zzaan zzaan = new zzaan(zzaam, zza);
        if (this.zzc.zzk(str2)) {
            if (z11) {
                this.zzc.zzi(str2);
            } else {
                this.zzc.zzh(zzaan, str2);
                return;
            }
        }
        zzael zzb2 = zzael.zzb(str, str2, str3, str4, str5, (String) null);
        long j12 = j11;
        if (zzJ(j11, z13)) {
            zzb2.zzd(new zzaco(this.zzc.zzb()));
        }
        this.zzc.zzj(str2, zzaan, j11, z13);
        this.zzb.zzH(zzb2, new zzacg(this.zzc, zzaan, str2));
    }

    public final void zzC(zzws zzws, zzaam zzaam) {
        Preconditions.checkNotNull(zzws);
        Preconditions.checkNotNull(zzaam);
        String phoneNumber = zzws.zzb().getPhoneNumber();
        zzaan zzaan = new zzaan(zzaam, zza);
        if (this.zzc.zzk(phoneNumber)) {
            if (zzws.zzg()) {
                this.zzc.zzi(phoneNumber);
            } else {
                this.zzc.zzh(zzaan, phoneNumber);
                return;
            }
        }
        long zza2 = zzws.zza();
        boolean zzh = zzws.zzh();
        zzaej zzb2 = zzaej.zzb(zzws.zzd(), zzws.zzb().getUid(), zzws.zzb().getPhoneNumber(), zzws.zzc(), zzws.zzf(), zzws.zze());
        if (zzJ(zza2, zzh)) {
            zzb2.zzd(new zzaco(this.zzc.zzb()));
        }
        this.zzc.zzj(phoneNumber, zzaan, zza2, zzh);
        this.zzb.zzI(zzb2, new zzacg(this.zzc, zzaan, phoneNumber));
    }

    public final void zzD(zzaen zzaen, zzaam zzaam) {
        this.zzb.zzH(zzaen, new zzaan((zzaam) Preconditions.checkNotNull(zzaam), zza));
    }

    public final void zzE(String str, String str2, @Nullable String str3, zzaam zzaam) {
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotEmpty(str2, "uid should not be empty.");
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzJ(str, str2, str3, new zzaan(zzaam, zza));
    }

    public final void zzF(String str, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzK(str, new zzaan(zzaam, zza));
    }

    public final void zzG(String str, String str2, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzL(str, str2, new zzaan(zzaam, zza));
    }

    public final void zzH(String str, UserProfileChangeRequest userProfileChangeRequest, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzM(str, userProfileChangeRequest, new zzaan(zzaam, zza));
    }

    public final void zzI(zzwt zzwt, zzaam zzaam) {
        Preconditions.checkNotNull(zzwt);
        this.zzb.zzN(zzadk.zzc(zzwt.zza(), zzwt.zzb(), zzwt.zzc()), new zzaan(zzaam, zza));
    }

    public final void zza(String str, @Nullable String str2, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzg(str, str2, new zzaan(zzaam, zza));
    }

    public final void zzb(String str, String str2, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzh(str, str2, new zzaan(zzaam, zza));
    }

    public final void zzc(String str, String str2, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzi(str, str2, new zzaan(zzaam, zza));
    }

    public final void zzd(String str, @Nullable String str2, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzj(str, str2, new zzaan(zzaam, zza));
    }

    public final void zze(zzwi zzwi, zzaam zzaam) {
        Preconditions.checkNotNull(zzwi);
        Preconditions.checkNotEmpty(zzwi.zza());
        Preconditions.checkNotEmpty(zzwi.zzb());
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzk(zzwi.zza(), zzwi.zzb(), zzwi.zzc(), new zzaan(zzaam, zza));
    }

    public final void zzf(String str, String str2, @Nullable String str3, @Nullable String str4, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzl(str, str2, str3, str4, new zzaan(zzaam, zza));
    }

    public final void zzg(String str, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzm(str, new zzaan(zzaam, zza));
    }

    public final void zzh(MultiFactorAssertion multiFactorAssertion, String str, @Nullable String str2, @Nullable String str3, zzaam zzaam) {
        zzacw zzacw;
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotNull(zzaam);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            zzacw = zzada.zzc(str, (String) Preconditions.checkNotNull(zza2.zzg()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2, str3);
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            zzacw = zzadc.zzc(str, Preconditions.checkNotEmpty(str2), Preconditions.checkNotEmpty(((TotpSecret) Preconditions.checkNotNull(totpMultiFactorAssertion.zza())).getSessionInfo()), Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zzn(zzacw, str, new zzaan(zzaam, zza));
    }

    public final void zzi(String str, MultiFactorAssertion multiFactorAssertion, @Nullable String str2, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzaam);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zzo(zzadb.zzb(str, (String) Preconditions.checkNotNull(zza2.zzg()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2), new zzaan(zzaam, zza));
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            this.zzb.zzo(zzadd.zzb(str, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str2, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzb())), new zzaan(zzaam, zza));
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zzj(String str, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzp(str, new zzaan(zzaam, zza));
    }

    public final void zzk(zzwj zzwj, zzaam zzaam) {
        Preconditions.checkNotNull(zzwj);
        this.zzb.zzq(zzadm.zzb(), new zzaan(zzaam, zza));
    }

    public final void zzl(String str, @Nullable String str2, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        this.zzb.zzr(str, str2, new zzaan(zzaam, zza));
    }

    public final void zzm(zzwk zzwk, zzaam zzaam) {
        Preconditions.checkNotNull(zzwk);
        this.zzb.zzs(zzadp.zzb(zzwk.zzb(), zzwk.zza()), new zzaan(zzaam, zza));
    }

    public final void zzn(String str, String str2, String str3, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzt(str, str2, str3, new zzaan(zzaam, zza));
    }

    public final void zzo(String str, zzaes zzaes, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaes);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzu(str, zzaes, new zzaan(zzaam, zza));
    }

    public final void zzp(zzwl zzwl, zzaam zzaam) {
        Preconditions.checkNotNull(zzaam);
        Preconditions.checkNotNull(zzwl);
        this.zzb.zzv(Preconditions.checkNotEmpty(zzwl.zzb()), zzabz.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzwl.zza())), new zzaan(zzaam, zza));
    }

    public final void zzq(String str, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzw(str, new zzaan(zzaam, zza));
    }

    public final void zzr(@NonNull zzwm zzwm, zzaam zzaam) {
        Preconditions.checkNotNull(zzwm);
        Preconditions.checkNotEmpty(zzwm.zzb());
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzx(zzwm.zzb(), zzwm.zza(), new zzaan(zzaam, zza));
    }

    public final void zzs(@NonNull zzwn zzwn, zzaam zzaam) {
        Preconditions.checkNotNull(zzwn);
        Preconditions.checkNotEmpty(zzwn.zzc());
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzy(zzwn.zzc(), zzwn.zza(), zzwn.zzd(), zzwn.zzb(), new zzaan(zzaam, zza));
    }

    public final void zzt(zzwo zzwo, zzaam zzaam) {
        Preconditions.checkNotNull(zzaam);
        Preconditions.checkNotNull(zzwo);
        zzaeb zzaeb = (zzaeb) Preconditions.checkNotNull(zzwo.zza());
        String zzd = zzaeb.zzd();
        zzaan zzaan = new zzaan(zzaam, zza);
        if (this.zzc.zzk(zzd)) {
            if (zzaeb.zzf()) {
                this.zzc.zzi(zzd);
            } else {
                this.zzc.zzh(zzaan, zzd);
                return;
            }
        }
        long zzb2 = zzaeb.zzb();
        boolean zzg = zzaeb.zzg();
        if (zzJ(zzb2, zzg)) {
            zzaeb.zze(new zzaco(this.zzc.zzb()));
        }
        this.zzc.zzj(zzd, zzaan, zzb2, zzg);
        this.zzb.zzz(zzaeb, new zzacg(this.zzc, zzaan, zzd));
    }

    public final void zzu(zzwp zzwp, zzaam zzaam) {
        Preconditions.checkNotNull(zzwp);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzA(zzwp.zza(), new zzaan(zzaam, zza));
    }

    public final void zzv(@Nullable String str, zzaam zzaam) {
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzB(str, new zzaan(zzaam, zza));
    }

    public final void zzw(zzaes zzaes, zzaam zzaam) {
        Preconditions.checkNotNull(zzaes);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzC(zzaes, new zzaan(zzaam, zza));
    }

    public final void zzx(zzaev zzaev, zzaam zzaam) {
        Preconditions.checkNotNull(zzaev);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzD(zzaev, new zzaan(zzaam, zza));
    }

    public final void zzy(String str, String str2, @Nullable String str3, @Nullable String str4, zzaam zzaam) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaam);
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzE(str, str2, str3, str4, new zzaan(zzaam, zza));
    }

    public final void zzz(zzwq zzwq, zzaam zzaam) {
        Preconditions.checkNotNull(zzwq);
        Preconditions.checkNotNull(zzwq.zza());
        Preconditions.checkNotNull(zzaam);
        this.zzb.zzF(zzwq.zza(), zzwq.zzb(), new zzaan(zzaam, zza));
    }
}
