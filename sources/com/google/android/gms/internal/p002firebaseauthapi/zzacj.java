package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import com.adjust.sdk.Constants;
import com.google.android.exoplayer2.C;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.auth.PhoneAuthCredential;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacj  reason: invalid package */
final class zzacj {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("FirebaseAuth", "SmsRetrieverHelper");
    private final Context zzb;
    private final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final HashMap zzd = new HashMap();

    public zzacj(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzb = context;
        this.zzc = scheduledExecutorService;
    }

    public static /* bridge */ /* synthetic */ void zzd(zzacj zzacj, String str) {
        zzaci zzaci = (zzaci) zzacj.zzd.get(str);
        if (zzaci != null && !zzac.zzd(zzaci.zzd) && !zzac.zzd(zzaci.zze) && !zzaci.zzb.isEmpty()) {
            for (zzaan zzr : zzaci.zzb) {
                zzr.zzr(PhoneAuthCredential.zzc(zzaci.zzd, zzaci.zze));
            }
            zzaci.zzh = true;
        }
    }

    private static String zzl(String str, String str2) {
        String str3 = str + " " + str2;
        try {
            MessageDigest instance = MessageDigest.getInstance(Constants.SHA256);
            instance.update(str3.getBytes(zzk.zzc));
            String substring = Base64.encodeToString(Arrays.copyOf(instance.digest(), 9), 3).substring(0, 11);
            zza.d("Package: " + str + " -- Hash: " + substring, new Object[0]);
            return substring;
        } catch (NoSuchAlgorithmException e11) {
            zza.e("NoSuchAlgorithm: ".concat(String.valueOf(e11.getMessage())), new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public final void zzm(String str) {
        zzaci zzaci = (zzaci) this.zzd.get(str);
        if (zzaci != null && !zzaci.zzh && !zzac.zzd(zzaci.zzd)) {
            zza.w("Timed out waiting for SMS.", new Object[0]);
            for (zzaan zza2 : zzaci.zzb) {
                zza2.zza(zzaci.zzd);
            }
            zzaci.zzi = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzn */
    public final void zzg(String str) {
        zzaci zzaci = (zzaci) this.zzd.get(str);
        if (zzaci != null) {
            if (!zzaci.zzi) {
                zzm(str);
            }
            zzi(str);
        }
    }

    public final String zzb() {
        Signature[] signatureArr;
        try {
            String packageName = this.zzb.getPackageName();
            if (Build.VERSION.SDK_INT < 28) {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, 64).signatures;
            } else {
                signatureArr = Wrappers.packageManager(this.zzb).getPackageInfo(packageName, C.BUFFER_FLAG_FIRST_SAMPLE).signingInfo.getApkContentsSigners();
            }
            String zzl = zzl(packageName, signatureArr[0].toCharsString());
            if (zzl != null) {
                return zzl;
            }
            zza.e("Hash generation failed.", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            zza.e("Unable to find package to obtain hash.", new Object[0]);
            return null;
        }
    }

    public final void zzh(zzaan zzaan, String str) {
        zzaci zzaci = (zzaci) this.zzd.get(str);
        if (zzaci != null) {
            zzaci.zzb.add(zzaan);
            if (zzaci.zzg) {
                zzaan.zzb(zzaci.zzd);
            }
            if (zzaci.zzh) {
                zzaan.zzr(PhoneAuthCredential.zzc(zzaci.zzd, zzaci.zze));
            }
            if (zzaci.zzi) {
                zzaan.zza(zzaci.zzd);
            }
        }
    }

    public final void zzi(String str) {
        zzaci zzaci = (zzaci) this.zzd.get(str);
        if (zzaci != null) {
            ScheduledFuture scheduledFuture = zzaci.zzf;
            if (scheduledFuture != null && !scheduledFuture.isDone()) {
                zzaci.zzf.cancel(false);
            }
            zzaci.zzb.clear();
            this.zzd.remove(str);
        }
    }

    public final void zzj(String str, zzaan zzaan, long j11, boolean z11) {
        this.zzd.put(str, new zzaci(j11, z11));
        zzh(zzaan, str);
        zzaci zzaci = (zzaci) this.zzd.get(str);
        long j12 = zzaci.zza;
        if (j12 <= 0) {
            zza.w("Timeout of 0 specified; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzaci.zzf = this.zzc.schedule(new zzace(this, str), j12, TimeUnit.SECONDS);
        if (!zzaci.zzc) {
            zza.w("SMS auto-retrieval unavailable; SmsRetriever will not start.", new Object[0]);
            return;
        }
        zzach zzach = new zzach(this, str);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
        zzb.zza(this.zzb.getApplicationContext(), zzach, intentFilter);
        SmsRetriever.getClient(this.zzb).startSmsRetriever().addOnFailureListener(new zzacf(this));
    }

    public final boolean zzk(String str) {
        return this.zzd.get(str) != null;
    }
}
