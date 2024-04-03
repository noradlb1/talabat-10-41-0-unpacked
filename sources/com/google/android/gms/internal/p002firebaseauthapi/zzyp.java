package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyp  reason: invalid package */
public final class zzyp {
    /* access modifiers changed from: private */
    public final zzabv zza;

    public zzyp(zzabv zzabv) {
        this.zza = (zzabv) Preconditions.checkNotNull(zzabv);
    }

    private final void zzO(String str, zzabu zzabu) {
        Preconditions.checkNotNull(zzabu);
        Preconditions.checkNotEmpty(str);
        zzadr zzd = zzadr.zzd(str);
        if (zzd.zzj()) {
            zzabu.zzb(zzd);
            return;
        }
        this.zza.zzf(new zzadf(zzd.zzf()), new zzyo(this, zzabu));
    }

    /* access modifiers changed from: private */
    public final void zzP(zzacu zzacu, zzaan zzaan) {
        Preconditions.checkNotNull(zzacu);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzc(zzacu, new zzwz(this, zzaan));
    }

    /* access modifiers changed from: private */
    public final void zzQ(zzadr zzadr, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable zze zze, zzaan zzaan, zzabt zzabt) {
        Preconditions.checkNotNull(zzadr);
        Preconditions.checkNotNull(zzabt);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzg(new zzadg(zzadr.zze()), new zzxc(this, zzabt, str2, str, bool, zze, zzaan, zzadr));
    }

    private final void zzR(zzadk zzadk, zzaan zzaan) {
        Preconditions.checkNotNull(zzadk);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzh(zzadk, new zzyh(this, zzaan));
    }

    public static /* bridge */ /* synthetic */ void zzd(zzyp zzyp, zzaeu zzaeu, zzaan zzaan, zzabt zzabt) {
        Status status;
        if (zzaeu.zzp()) {
            zze zzc = zzaeu.zzc();
            String zzd = zzaeu.zzd();
            String zzk = zzaeu.zzk();
            if (zzaeu.zzn()) {
                status = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            } else {
                status = zzai.zza(zzaeu.zze());
            }
            zzaan.zze(new zzwu(status, zzc, zzd, zzk));
            return;
        }
        zzyp.zzQ(new zzadr(zzaeu.zzj(), zzaeu.zzf(), Long.valueOf(zzaeu.zzb()), "Bearer"), zzaeu.zzi(), zzaeu.zzh(), Boolean.valueOf(zzaeu.zzo()), zzaeu.zzc(), zzaan, zzabt);
    }

    public static /* bridge */ /* synthetic */ void zze(zzyp zzyp, zzaan zzaan, zzadr zzadr, zzaed zzaed, zzabt zzabt) {
        Preconditions.checkNotNull(zzaan);
        Preconditions.checkNotNull(zzadr);
        Preconditions.checkNotNull(zzaed);
        Preconditions.checkNotNull(zzabt);
        zzyp.zza.zzg(new zzadg(zzadr.zze()), new zzxa(zzyp, zzabt, zzaan, zzadr, zzaed));
    }

    public static /* bridge */ /* synthetic */ void zzf(zzyp zzyp, zzaan zzaan, zzadr zzadr, zzadi zzadi, zzaed zzaed, zzabt zzabt) {
        Preconditions.checkNotNull(zzaan);
        Preconditions.checkNotNull(zzadr);
        Preconditions.checkNotNull(zzadi);
        Preconditions.checkNotNull(zzaed);
        Preconditions.checkNotNull(zzabt);
        zzyp.zza.zzn(zzaed, new zzxb(zzyp, zzaed, zzadi, zzaan, zzadr, zzabt));
    }

    public final void zzA(@Nullable String str, zzaan zzaan) {
        Preconditions.checkNotNull(zzaan);
        this.zza.zzo(str, new zzyg(this, zzaan));
    }

    public final void zzB(@Nullable String str, zzaan zzaan) {
        Preconditions.checkNotNull(zzaan);
        this.zza.zzp(new zzaef(str), new zzyj(this, zzaan));
    }

    public final void zzC(zzaes zzaes, zzaan zzaan) {
        Preconditions.checkNotNull(zzaes);
        Preconditions.checkNotNull(zzaan);
        zzaes.zzd(true);
        this.zza.zzs(zzaes, new zzyi(this, zzaan));
    }

    public final void zzD(zzaev zzaev, zzaan zzaan) {
        Preconditions.checkNotNull(zzaev);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzt(zzaev, new zzxv(this, zzaan));
    }

    public final void zzE(String str, String str2, @Nullable String str3, @Nullable String str4, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzu(new zzaex(str, str2, str3, str4), new zzwx(this, zzaan));
    }

    public final void zzF(EmailAuthCredential emailAuthCredential, @Nullable String str, zzaan zzaan) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzaan);
        if (emailAuthCredential.zzh()) {
            zzO(emailAuthCredential.zzc(), new zzwy(this, emailAuthCredential, str, zzaan));
        } else {
            zzP(new zzacu(emailAuthCredential, (String) null, str), zzaan);
        }
    }

    public final void zzG(zzaez zzaez, zzaan zzaan) {
        Preconditions.checkNotNull(zzaez);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzv(zzaez, new zzxj(this, zzaan));
    }

    public final void zzH(zzaeh zzaeh, zzaan zzaan) {
        Preconditions.checkNotNull(zzaeh);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzq(zzaeh, new zzxu(this, zzaeh, zzaan));
    }

    public final void zzI(zzaej zzaej, zzaan zzaan) {
        Preconditions.checkNotNull(zzaej);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzr(zzaej, new zzxz(this, zzaan));
    }

    public final void zzJ(String str, String str2, @Nullable String str3, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaan);
        zzO(str, new zzxt(this, str2, str3, zzaan));
    }

    public final void zzK(String str, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaan);
        zzO(str, new zzxp(this, zzaan));
    }

    public final void zzL(String str, String str2, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaan);
        zzO(str2, new zzxr(this, str, zzaan));
    }

    public final void zzM(String str, UserProfileChangeRequest userProfileChangeRequest, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzaan);
        zzO(str, new zzyk(this, userProfileChangeRequest, zzaan));
    }

    public final void zzN(zzadk zzadk, zzaan zzaan) {
        zzR(zzadk, zzaan);
    }

    public final void zzg(String str, @Nullable String str2, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaan);
        zzaed zzaed = new zzaed();
        zzaed.zzf(str);
        zzaed.zzi(str2);
        this.zza.zzn(zzaed, new zzyn(this, zzaan));
    }

    public final void zzh(String str, String str2, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaan);
        zzO(str, new zzyl(this, str2, zzaan));
    }

    public final void zzi(String str, String str2, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaan);
        zzO(str, new zzym(this, str2, zzaan));
    }

    public final void zzj(String str, @Nullable String str2, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzl(new zzadz(str, (String) null, str2), new zzxf(this, zzaan));
    }

    public final void zzk(String str, String str2, @Nullable String str3, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzl(new zzadz(str, str2, str3), new zzxh(this, zzaan));
    }

    public final void zzl(String str, String str2, @Nullable String str3, @Nullable String str4, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzp(new zzaef(str, str2, (String) null, str3, str4), new zzww(this, zzaan));
    }

    public final void zzm(String str, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaan);
        zzO(str, new zzyf(this, zzaan));
    }

    public final void zzn(zzacw zzacw, String str, zzaan zzaan) {
        Preconditions.checkNotNull(zzacw);
        Preconditions.checkNotNull(zzaan);
        zzO(str, new zzxx(this, zzacw, zzaan));
    }

    public final void zzo(zzacy zzacy, zzaan zzaan) {
        Preconditions.checkNotNull(zzacy);
        Preconditions.checkNotNull(zzaan);
        this.zza.zze(zzacy, new zzxy(this, zzaan));
    }

    public final void zzp(String str, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzf(new zzadf(str), new zzxg(this, zzaan));
    }

    public final void zzq(zzadm zzadm, zzaan zzaan) {
        Preconditions.checkNotNull(zzadm);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzi(zzadm, new zzyb(this, zzaan));
    }

    public final void zzr(String str, @Nullable String str2, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaan);
        this.zza.zza(new zzacr(str, str2), new zzxd(this, zzaan));
    }

    public final void zzs(zzadp zzadp, zzaan zzaan) {
        Preconditions.checkNotNull(zzadp);
        Preconditions.checkNotNull(zzaan);
        this.zza.zzj(zzadp, new zzya(this, zzaan));
    }

    public final void zzt(String str, String str2, String str3, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaan);
        zzO(str3, new zzxk(this, str, str2, zzaan));
    }

    public final void zzu(String str, zzaes zzaes, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaes);
        Preconditions.checkNotNull(zzaan);
        zzO(str, new zzxo(this, zzaes, zzaan));
    }

    public final void zzv(String str, zzaez zzaez, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaez);
        Preconditions.checkNotNull(zzaan);
        zzO(str, new zzxm(this, zzaez, zzaan));
    }

    public final void zzw(String str, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaan);
        zzO(str, new zzyd(this, zzaan));
    }

    public final void zzx(String str, @Nullable ActionCodeSettings actionCodeSettings, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaan);
        zzadk zzadk = new zzadk(4);
        zzadk.zzh(str);
        if (actionCodeSettings != null) {
            zzadk.zzd(actionCodeSettings);
        }
        zzR(zzadk, zzaan);
    }

    public final void zzy(String str, ActionCodeSettings actionCodeSettings, @Nullable String str2, @Nullable String str3, zzaan zzaan) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaan);
        zzadk zzadk = new zzadk(actionCodeSettings.zza());
        zzadk.zzf(str);
        zzadk.zzd(actionCodeSettings);
        zzadk.zzg(str2);
        zzadk.zze(str3);
        this.zza.zzh(zzadk, new zzxe(this, zzaan));
    }

    public final void zzz(zzaeb zzaeb, zzaan zzaan) {
        Preconditions.checkNotEmpty(zzaeb.zzd());
        Preconditions.checkNotNull(zzaan);
        this.zza.zzm(zzaeb, new zzxi(this, zzaan));
    }
}
