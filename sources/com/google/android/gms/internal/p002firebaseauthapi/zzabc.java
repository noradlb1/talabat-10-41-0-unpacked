package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabc  reason: invalid package */
final class zzabc extends zzabv implements zzacm {
    @VisibleForTesting
    zzabd zza;
    private zzaaw zzb;
    private zzaax zzc;
    private zzaca zzd;
    private final zzabb zze;
    private final FirebaseApp zzf;
    private final String zzg;

    @VisibleForTesting
    public zzabc(FirebaseApp firebaseApp, zzabb zzabb, zzaca zzaca, zzaaw zzaaw, zzaax zzaax) {
        this.zzf = firebaseApp;
        String apiKey = firebaseApp.getOptions().getApiKey();
        this.zzg = apiKey;
        this.zze = (zzabb) Preconditions.checkNotNull(zzabb);
        zzy((zzaca) null, (zzaaw) null, (zzaax) null);
        zzacn.zze(apiKey, this);
    }

    @NonNull
    private final zzabd zzx() {
        if (this.zza == null) {
            FirebaseApp firebaseApp = this.zzf;
            this.zza = new zzabd(firebaseApp.getApplicationContext(), firebaseApp, this.zze.zzb());
        }
        return this.zza;
    }

    private final void zzy(zzaca zzaca, zzaaw zzaaw, zzaax zzaax) {
        this.zzd = null;
        this.zzb = null;
        this.zzc = null;
        String zza2 = zzack.zza("firebear.secureToken");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zzacn.zzd(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: ".concat(String.valueOf(zza2)));
        }
        if (this.zzd == null) {
            this.zzd = new zzaca(zza2, zzx());
        }
        String zza3 = zzack.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza3)) {
            zza3 = zzacn.zzb(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: ".concat(String.valueOf(zza3)));
        }
        if (this.zzb == null) {
            this.zzb = new zzaaw(zza3, zzx());
        }
        String zza4 = zzack.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(zza4)) {
            zza4 = zzacn.zzc(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: ".concat(String.valueOf(zza4)));
        }
        if (this.zzc == null) {
            this.zzc = new zzaax(zza4, zzx());
        }
    }

    public final void zza(zzacr zzacr, zzabu zzabu) {
        Preconditions.checkNotNull(zzacr);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/createAuthUri", this.zzg), zzacr, zzabu, zzacs.class, zzaaw.zzb);
    }

    public final void zzb(zzact zzact, zzabu zzabu) {
        Preconditions.checkNotNull(zzact);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/deleteAccount", this.zzg), zzact, zzabu, Void.class, zzaaw.zzb);
    }

    public final void zzc(zzacu zzacu, zzabu zzabu) {
        Preconditions.checkNotNull(zzacu);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/emailLinkSignin", this.zzg), zzacu, zzabu, zzacv.class, zzaaw.zzb);
    }

    public final void zzd(zzacw zzacw, zzabu zzabu) {
        Preconditions.checkNotNull(zzacw);
        Preconditions.checkNotNull(zzabu);
        zzaax zzaax = this.zzc;
        zzabx.zzb(zzaax.zza("/accounts/mfaEnrollment:finalize", this.zzg), zzacw, zzabu, zzacx.class, zzaax.zzb);
    }

    public final void zze(zzacy zzacy, zzabu zzabu) {
        Preconditions.checkNotNull(zzacy);
        Preconditions.checkNotNull(zzabu);
        zzaax zzaax = this.zzc;
        zzabx.zzb(zzaax.zza("/accounts/mfaSignIn:finalize", this.zzg), zzacy, zzabu, zzacz.class, zzaax.zzb);
    }

    public final void zzf(zzadf zzadf, zzabu zzabu) {
        Preconditions.checkNotNull(zzadf);
        Preconditions.checkNotNull(zzabu);
        zzaca zzaca = this.zzd;
        zzabx.zzb(zzaca.zza("/token", this.zzg), zzadf, zzabu, zzadr.class, zzaca.zzb);
    }

    public final void zzg(zzadg zzadg, zzabu zzabu) {
        Preconditions.checkNotNull(zzadg);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/getAccountInfo", this.zzg), zzadg, zzabu, zzadh.class, zzaaw.zzb);
    }

    public final void zzh(zzadk zzadk, zzabu zzabu) {
        Preconditions.checkNotNull(zzadk);
        Preconditions.checkNotNull(zzabu);
        if (zzadk.zzb() != null) {
            zzx().zzc(zzadk.zzb().zze());
        }
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/getOobConfirmationCode", this.zzg), zzadk, zzabu, zzadl.class, zzaaw.zzb);
    }

    public final void zzi(zzadm zzadm, zzabu zzabu) {
        Preconditions.checkNotNull(zzadm);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zza(zzaaw.zza("/getRecaptchaParam", this.zzg), zzabu, zzadn.class, zzaaw.zzb);
    }

    public final void zzj(zzadp zzadp, zzabu zzabu) {
        Preconditions.checkNotNull(zzadp);
        Preconditions.checkNotNull(zzabu);
        zzaax zzaax = this.zzc;
        String zza2 = zzaax.zza("/recaptchaConfig", this.zzg);
        String zzc2 = zzadp.zzc();
        String zzd2 = zzadp.zzd();
        zzabx.zza(zza2 + "&clientType=" + zzc2 + "&version=" + zzd2, zzabu, zzadq.class, zzaax.zzb);
    }

    public final void zzk() {
        zzy((zzaca) null, (zzaaw) null, (zzaax) null);
    }

    public final void zzl(zzadz zzadz, zzabu zzabu) {
        Preconditions.checkNotNull(zzadz);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/resetPassword", this.zzg), zzadz, zzabu, zzaea.class, zzaaw.zzb);
    }

    public final void zzm(zzaeb zzaeb, zzabu zzabu) {
        Preconditions.checkNotNull(zzaeb);
        Preconditions.checkNotNull(zzabu);
        if (!TextUtils.isEmpty(zzaeb.zzc())) {
            zzx().zzc(zzaeb.zzc());
        }
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/sendVerificationCode", this.zzg), zzaeb, zzabu, zzaec.class, zzaaw.zzb);
    }

    public final void zzn(zzaed zzaed, zzabu zzabu) {
        Preconditions.checkNotNull(zzaed);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/setAccountInfo", this.zzg), zzaed, zzabu, zzaee.class, zzaaw.zzb);
    }

    public final void zzo(@Nullable String str, zzabu zzabu) {
        Preconditions.checkNotNull(zzabu);
        zzx().zzb(str);
        ((zzyg) zzabu).zza.zzo();
    }

    public final void zzp(zzaef zzaef, zzabu zzabu) {
        Preconditions.checkNotNull(zzaef);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/signupNewUser", this.zzg), zzaef, zzabu, zzaeg.class, zzaaw.zzb);
    }

    public final void zzq(zzaeh zzaeh, zzabu zzabu) {
        Preconditions.checkNotNull(zzaeh);
        Preconditions.checkNotNull(zzabu);
        if (zzaeh instanceof zzael) {
            zzael zzael = (zzael) zzaeh;
            if (!TextUtils.isEmpty(zzael.zzc())) {
                zzx().zzc(zzael.zzc());
            }
        }
        zzaax zzaax = this.zzc;
        zzabx.zzb(zzaax.zza("/accounts/mfaEnrollment:start", this.zzg), zzaeh, zzabu, zzaei.class, zzaax.zzb);
    }

    public final void zzr(zzaej zzaej, zzabu zzabu) {
        Preconditions.checkNotNull(zzaej);
        Preconditions.checkNotNull(zzabu);
        if (!TextUtils.isEmpty(zzaej.zzc())) {
            zzx().zzc(zzaej.zzc());
        }
        zzaax zzaax = this.zzc;
        zzabx.zzb(zzaax.zza("/accounts/mfaSignIn:start", this.zzg), zzaej, zzabu, zzaek.class, zzaax.zzb);
    }

    public final void zzs(zzaes zzaes, zzabu zzabu) {
        Preconditions.checkNotNull(zzaes);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/verifyAssertion", this.zzg), zzaes, zzabu, zzaeu.class, zzaaw.zzb);
    }

    public final void zzt(zzaev zzaev, zzabu zzabu) {
        Preconditions.checkNotNull(zzaev);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/verifyCustomToken", this.zzg), zzaev, zzabu, zzaew.class, zzaaw.zzb);
    }

    public final void zzu(zzaex zzaex, zzabu zzabu) {
        Preconditions.checkNotNull(zzaex);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/verifyPassword", this.zzg), zzaex, zzabu, zzaey.class, zzaaw.zzb);
    }

    public final void zzv(zzaez zzaez, zzabu zzabu) {
        Preconditions.checkNotNull(zzaez);
        Preconditions.checkNotNull(zzabu);
        zzaaw zzaaw = this.zzb;
        zzabx.zzb(zzaaw.zza("/verifyPhoneNumber", this.zzg), zzaez, zzabu, zzafa.class, zzaaw.zzb);
    }

    public final void zzw(zzafb zzafb, zzabu zzabu) {
        Preconditions.checkNotNull(zzafb);
        Preconditions.checkNotNull(zzabu);
        zzaax zzaax = this.zzc;
        zzabx.zzb(zzaax.zza("/accounts/mfaEnrollment:withdraw", this.zzg), zzafb, zzabu, zzafc.class, zzaax.zzb);
    }
}
