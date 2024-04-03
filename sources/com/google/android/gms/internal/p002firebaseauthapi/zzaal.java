package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzan;
import com.google.firebase.auth.internal.zzbc;
import com.google.firebase.auth.internal.zzbx;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzt;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaal  reason: invalid package */
public final class zzaal extends zzabs {
    public zzaal(FirebaseApp firebaseApp, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzaao(firebaseApp, scheduledExecutorService);
        this.zzb = executor;
    }

    @VisibleForTesting
    @NonNull
    public static zzx zzS(FirebaseApp firebaseApp, zzadi zzadi) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzadi);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzt(zzadi, "firebase"));
        List zzr = zzadi.zzr();
        if (zzr != null && !zzr.isEmpty()) {
            for (int i11 = 0; i11 < zzr.size(); i11++) {
                arrayList.add(new zzt((zzadw) zzr.get(i11)));
            }
        }
        zzx zzx = new zzx(firebaseApp, arrayList);
        zzx.zzr(new zzz(zzadi.zzb(), zzadi.zza()));
        zzx.zzq(zzadi.zzt());
        zzx.zzp(zzadi.zzd());
        zzx.zzi(zzbc.zzb(zzadi.zzq()));
        return zzx;
    }

    @NonNull
    public final Task zzA(@Nullable String str) {
        return zzU(new zzzr(str));
    }

    public final Task zzB(FirebaseApp firebaseApp, zzg zzg, @Nullable String str) {
        zzzs zzzs = new zzzs(str);
        zzzs.zzf(firebaseApp);
        zzzs.zzd(zzg);
        return zzU(zzzs);
    }

    public final Task zzC(FirebaseApp firebaseApp, AuthCredential authCredential, @Nullable String str, zzg zzg) {
        zzzt zzzt = new zzzt(authCredential, str);
        zzzt.zzf(firebaseApp);
        zzzt.zzd(zzg);
        return zzU(zzzt);
    }

    public final Task zzD(FirebaseApp firebaseApp, String str, @Nullable String str2, zzg zzg) {
        zzzu zzzu = new zzzu(str, str2);
        zzzu.zzf(firebaseApp);
        zzzu.zzd(zzg);
        return zzU(zzzu);
    }

    public final Task zzE(FirebaseApp firebaseApp, String str, String str2, @Nullable String str3, @Nullable String str4, zzg zzg) {
        zzzv zzzv = new zzzv(str, str2, str3, str4);
        zzzv.zzf(firebaseApp);
        zzzv.zzd(zzg);
        return zzU(zzzv);
    }

    public final Task zzF(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, @Nullable String str, zzg zzg) {
        zzzw zzzw = new zzzw(emailAuthCredential, str);
        zzzw.zzf(firebaseApp);
        zzzw.zzd(zzg);
        return zzU(zzzw);
    }

    public final Task zzG(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzg zzg) {
        zzacd.zzc();
        zzzx zzzx = new zzzx(phoneAuthCredential, str);
        zzzx.zzf(firebaseApp);
        zzzx.zzd(zzg);
        return zzU(zzzx);
    }

    public final Task zzH(zzag zzag, String str, @Nullable String str2, long j11, boolean z11, boolean z12, @Nullable String str3, @Nullable String str4, boolean z13, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, @Nullable Activity activity) {
        zzzy zzzy = new zzzy(zzag, str, str2, j11, z11, z12, str3, str4, z13);
        String str5 = str;
        zzzy.zzh(onVerificationStateChangedCallbacks, activity, executor, str);
        return zzU(zzzy);
    }

    public final Task zzI(zzag zzag, @Nullable String str) {
        return zzU(new zzzz(zzag, str));
    }

    public final Task zzJ(zzag zzag, PhoneMultiFactorInfo phoneMultiFactorInfo, @Nullable String str, long j11, boolean z11, boolean z12, @Nullable String str2, @Nullable String str3, boolean z13, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, @Nullable Activity activity) {
        zzaaa zzaaa = new zzaaa(phoneMultiFactorInfo, Preconditions.checkNotEmpty(zzag.zze()), str, j11, z11, z12, str2, str3, z13);
        Activity activity2 = activity;
        zzaaa.zzh(onVerificationStateChangedCallbacks, activity2, executor, phoneMultiFactorInfo.getUid());
        return zzU(zzaaa);
    }

    public final Task zzK(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, @Nullable String str2, zzbx zzbx) {
        zzaab zzaab = new zzaab(firebaseUser.zzf(), str, str2);
        zzaab.zzf(firebaseApp);
        zzaab.zzg(firebaseUser);
        zzaab.zzd(zzbx);
        zzaab.zze(zzbx);
        return zzU(zzaab);
    }

    public final Task zzL(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbx) {
        char c11;
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbx);
        List zzg = firebaseUser.zzg();
        if ((zzg != null && !zzg.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzaap.zza(new Status((int) FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        if (str.hashCode() == 1216985755 && str.equals("password")) {
            c11 = 0;
        } else {
            c11 = 65535;
        }
        if (c11 != 0) {
            zzaad zzaad = new zzaad(str);
            zzaad.zzf(firebaseApp);
            zzaad.zzg(firebaseUser);
            zzaad.zzd(zzbx);
            zzaad.zze(zzbx);
            return zzU(zzaad);
        }
        zzaac zzaac = new zzaac();
        zzaac.zzf(firebaseApp);
        zzaac.zzg(firebaseUser);
        zzaac.zzd(zzbx);
        zzaac.zze(zzbx);
        return zzU(zzaac);
    }

    public final Task zzM(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbx) {
        zzaae zzaae = new zzaae(str);
        zzaae.zzf(firebaseApp);
        zzaae.zzg(firebaseUser);
        zzaae.zzd(zzbx);
        zzaae.zze(zzbx);
        return zzU(zzaae);
    }

    public final Task zzN(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbx) {
        zzaaf zzaaf = new zzaaf(str);
        zzaaf.zzf(firebaseApp);
        zzaaf.zzg(firebaseUser);
        zzaaf.zzd(zzbx);
        zzaaf.zze(zzbx);
        return zzU(zzaaf);
    }

    public final Task zzO(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzbx zzbx) {
        zzacd.zzc();
        zzaag zzaag = new zzaag(phoneAuthCredential);
        zzaag.zzf(firebaseApp);
        zzaag.zzg(firebaseUser);
        zzaag.zzd(zzbx);
        zzaag.zze(zzbx);
        return zzU(zzaag);
    }

    public final Task zzP(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzbx zzbx) {
        zzaah zzaah = new zzaah(userProfileChangeRequest);
        zzaah.zzf(firebaseApp);
        zzaah.zzg(firebaseUser);
        zzaah.zzd(zzbx);
        zzaah.zze(zzbx);
        return zzU(zzaah);
    }

    public final Task zzQ(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zzg(7);
        return zzU(new zzaai(str, str2, actionCodeSettings));
    }

    public final Task zzR(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzaaj zzaaj = new zzaaj(str, str2);
        zzaaj.zzf(firebaseApp);
        return zzU(zzaaj);
    }

    public final void zzT(FirebaseApp firebaseApp, zzaeb zzaeb, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, Executor executor) {
        zzaak zzaak = new zzaak(zzaeb);
        zzaak.zzf(firebaseApp);
        zzaak.zzh(onVerificationStateChangedCallbacks, activity, executor, zzaeb.zzd());
        zzU(zzaak);
    }

    public final Task zza(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzyr zzyr = new zzyr(str, str2);
        zzyr.zzf(firebaseApp);
        return zzU(zzyr);
    }

    public final Task zzb(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzys zzys = new zzys(str, str2);
        zzys.zzf(firebaseApp);
        return zzU(zzys);
    }

    public final Task zzc(FirebaseApp firebaseApp, String str, String str2, @Nullable String str3) {
        zzyt zzyt = new zzyt(str, str2, str3);
        zzyt.zzf(firebaseApp);
        return zzU(zzyt);
    }

    public final Task zzd(FirebaseApp firebaseApp, String str, String str2, String str3, @Nullable String str4, zzg zzg) {
        zzyu zzyu = new zzyu(str, str2, str3, str4);
        zzyu.zzf(firebaseApp);
        zzyu.zzd(zzg);
        return zzU(zzyu);
    }

    @NonNull
    public final Task zze(FirebaseUser firebaseUser, zzan zzan) {
        zzyv zzyv = new zzyv();
        zzyv.zzg(firebaseUser);
        zzyv.zzd(zzan);
        zzyv.zze(zzan);
        return zzU(zzyv);
    }

    public final Task zzf(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzyw zzyw = new zzyw(str, str2);
        zzyw.zzf(firebaseApp);
        return zzU(zzyw);
    }

    public final Task zzg(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, @Nullable String str, zzg zzg) {
        zzacd.zzc();
        zzyx zzyx = new zzyx(phoneMultiFactorAssertion, firebaseUser.zzf(), str, (String) null);
        zzyx.zzf(firebaseApp);
        zzyx.zzd(zzg);
        return zzU(zzyx);
    }

    public final Task zzh(FirebaseApp firebaseApp, TotpMultiFactorAssertion totpMultiFactorAssertion, FirebaseUser firebaseUser, @Nullable String str, @Nullable String str2, zzg zzg) {
        zzyx zzyx = new zzyx(totpMultiFactorAssertion, firebaseUser.zzf(), str, str2);
        zzyx.zzf(firebaseApp);
        zzyx.zzd(zzg);
        return zzU(zzyx);
    }

    public final Task zzi(FirebaseApp firebaseApp, @Nullable FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzg zzg) {
        zzacd.zzc();
        zzyy zzyy = new zzyy(phoneMultiFactorAssertion, str, (String) null);
        zzyy.zzf(firebaseApp);
        zzyy.zzd(zzg);
        if (firebaseUser != null) {
            zzyy.zzg(firebaseUser);
        }
        return zzU(zzyy);
    }

    public final Task zzj(FirebaseApp firebaseApp, @Nullable FirebaseUser firebaseUser, TotpMultiFactorAssertion totpMultiFactorAssertion, String str, @Nullable String str2, zzg zzg) {
        zzyy zzyy = new zzyy(totpMultiFactorAssertion, str, str2);
        zzyy.zzf(firebaseApp);
        zzyy.zzd(zzg);
        if (firebaseUser != null) {
            zzyy.zzg(firebaseUser);
        }
        return zzU(zzyy);
    }

    public final Task zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbx) {
        zzyz zzyz = new zzyz(str);
        zzyz.zzf(firebaseApp);
        zzyz.zzg(firebaseUser);
        zzyz.zzd(zzbx);
        zzyz.zze(zzbx);
        return zzU(zzyz);
    }

    public final Task zzl() {
        return zzU(new zzza());
    }

    public final Task zzm(@Nullable String str, String str2) {
        return zzU(new zzzb(str, "RECAPTCHA_ENTERPRISE"));
    }

    public final Task zzn(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, zzbx zzbx) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbx);
        List zzg = firebaseUser.zzg();
        if (zzg != null && zzg.contains(authCredential.getProvider())) {
            return Tasks.forException(zzaap.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzg()) {
                zzzc zzzc = new zzzc(emailAuthCredential);
                zzzc.zzf(firebaseApp);
                zzzc.zzg(firebaseUser);
                zzzc.zzd(zzbx);
                zzzc.zze(zzbx);
                return zzU(zzzc);
            }
            zzzf zzzf = new zzzf(emailAuthCredential);
            zzzf.zzf(firebaseApp);
            zzzf.zzg(firebaseUser);
            zzzf.zzd(zzbx);
            zzzf.zze(zzbx);
            return zzU(zzzf);
        } else if (authCredential instanceof PhoneAuthCredential) {
            zzacd.zzc();
            zzze zzze = new zzze((PhoneAuthCredential) authCredential);
            zzze.zzf(firebaseApp);
            zzze.zzg(firebaseUser);
            zzze.zzd(zzbx);
            zzze.zze(zzbx);
            return zzU(zzze);
        } else {
            Preconditions.checkNotNull(firebaseApp);
            Preconditions.checkNotNull(authCredential);
            Preconditions.checkNotNull(firebaseUser);
            Preconditions.checkNotNull(zzbx);
            zzzd zzzd = new zzzd(authCredential);
            zzzd.zzf(firebaseApp);
            zzzd.zzg(firebaseUser);
            zzzd.zzd(zzbx);
            zzzd.zze(zzbx);
            return zzU(zzzd);
        }
    }

    public final Task zzo(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, @Nullable String str, zzbx zzbx) {
        zzzg zzzg = new zzzg(authCredential, str);
        zzzg.zzf(firebaseApp);
        zzzg.zzg(firebaseUser);
        zzzg.zzd(zzbx);
        zzzg.zze(zzbx);
        return zzU(zzzg);
    }

    public final Task zzp(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, @Nullable String str, zzbx zzbx) {
        zzzh zzzh = new zzzh(authCredential, str);
        zzzh.zzf(firebaseApp);
        zzzh.zzg(firebaseUser);
        zzzh.zzd(zzbx);
        zzzh.zze(zzbx);
        return zzU(zzzh);
    }

    public final Task zzq(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, @Nullable String str, zzbx zzbx) {
        zzzi zzzi = new zzzi(emailAuthCredential, str);
        zzzi.zzf(firebaseApp);
        zzzi.zzg(firebaseUser);
        zzzi.zzd(zzbx);
        zzzi.zze(zzbx);
        return zzU(zzzi);
    }

    public final Task zzr(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, @Nullable String str, zzbx zzbx) {
        zzzj zzzj = new zzzj(emailAuthCredential, str);
        zzzj.zzf(firebaseApp);
        zzzj.zzg(firebaseUser);
        zzzj.zzd(zzbx);
        zzzj.zze(zzbx);
        return zzU(zzzj);
    }

    public final Task zzs(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, @Nullable String str3, @Nullable String str4, zzbx zzbx) {
        zzzk zzzk = new zzzk(str, str2, str3, str4);
        zzzk.zzf(firebaseApp);
        zzzk.zzg(firebaseUser);
        zzzk.zzd(zzbx);
        zzzk.zze(zzbx);
        return zzU(zzzk);
    }

    public final Task zzt(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, @Nullable String str3, @Nullable String str4, zzbx zzbx) {
        zzzl zzzl = new zzzl(str, str2, str3, str4);
        zzzl.zzf(firebaseApp);
        zzzl.zzg(firebaseUser);
        zzzl.zzd(zzbx);
        zzzl.zze(zzbx);
        return zzU(zzzl);
    }

    public final Task zzu(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzbx zzbx) {
        zzacd.zzc();
        zzzm zzzm = new zzzm(phoneAuthCredential, str);
        zzzm.zzf(firebaseApp);
        zzzm.zzg(firebaseUser);
        zzzm.zzd(zzbx);
        zzzm.zze(zzbx);
        return zzU(zzzm);
    }

    public final Task zzv(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzbx zzbx) {
        zzacd.zzc();
        zzzn zzzn = new zzzn(phoneAuthCredential, str);
        zzzn.zzf(firebaseApp);
        zzzn.zzg(firebaseUser);
        zzzn.zzd(zzbx);
        zzzn.zze(zzbx);
        return zzU(zzzn);
    }

    @NonNull
    public final Task zzw(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzbx zzbx) {
        zzzo zzzo = new zzzo();
        zzzo.zzf(firebaseApp);
        zzzo.zzg(firebaseUser);
        zzzo.zzd(zzbx);
        zzzo.zze(zzbx);
        return zzU(zzzo);
    }

    public final Task zzx(FirebaseApp firebaseApp, @Nullable ActionCodeSettings actionCodeSettings, String str) {
        zzzp zzzp = new zzzp(str, actionCodeSettings);
        zzzp.zzf(firebaseApp);
        return zzU(zzzp);
    }

    public final Task zzy(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, @Nullable String str2, @Nullable String str3) {
        actionCodeSettings.zzg(1);
        zzzq zzzq = new zzzq(str, actionCodeSettings, str2, str3, "sendPasswordResetEmail");
        zzzq.zzf(firebaseApp);
        return zzU(zzzq);
    }

    public final Task zzz(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, @Nullable String str2, @Nullable String str3) {
        actionCodeSettings.zzg(6);
        zzzq zzzq = new zzzq(str, actionCodeSettings, str2, str3, "sendSignInLinkToEmail");
        zzzq.zzf(firebaseApp);
        return zzU(zzzq);
    }
}
