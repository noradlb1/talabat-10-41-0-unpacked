package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.TotpSecret;
import java.util.Locale;

public final class zzbw implements TotpSecret {
    final String zza;
    final FirebaseAuth zzb;
    private final String zzc;
    private final String zzd;
    private final int zze;
    private final int zzf;
    private final long zzg;

    public zzbw(String str, String str2, int i11, int i12, long j11, String str3, FirebaseAuth firebaseAuth) {
        Preconditions.checkNotEmpty(str3, "sessionInfo cannot be empty.");
        Preconditions.checkNotNull(firebaseAuth, "firebaseAuth cannot be null.");
        this.zzc = Preconditions.checkNotEmpty(str, "sharedSecretKey cannot be empty. This is required to generate QR code URL.");
        this.zzd = Preconditions.checkNotEmpty(str2, "hashAlgorithm cannot be empty.");
        this.zze = i11;
        this.zzf = i12;
        this.zzg = j11;
        this.zza = str3;
        this.zzb = firebaseAuth;
    }

    private final void zza(String str) {
        this.zzb.getApp().getApplicationContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
    }

    private static final void zzb(String str, Activity activity) {
        Preconditions.checkNotNull(activity, "Activity cannot be null.");
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(268435456));
    }

    public final String generateQrCodeUrl() {
        String checkNotEmpty = Preconditions.checkNotEmpty(((FirebaseUser) Preconditions.checkNotNull(this.zzb.getCurrentUser(), "Current user cannot be null, since user is required to be logged in to enroll for TOTP MFA.")).getEmail(), "Email cannot be empty, since verified email is required to use MFA.");
        String name2 = this.zzb.getApp().getName();
        Preconditions.checkNotEmpty(checkNotEmpty, "accountName cannot be empty.");
        Preconditions.checkNotEmpty(name2, "issuer cannot be empty.");
        return String.format((Locale) null, "otpauth://totp/%s:%s?secret=%s&issuer=%s&algorithm=%s&digits=%d", new Object[]{name2, checkNotEmpty, this.zzc, name2, this.zzd, Integer.valueOf(this.zze)});
    }

    public final int getCodeIntervalSeconds() {
        return this.zzf;
    }

    public final int getCodeLength() {
        return this.zze;
    }

    public final long getEnrollmentCompletionDeadline() {
        return this.zzg;
    }

    public final String getHashAlgorithm() {
        return this.zzd;
    }

    public final String getSessionInfo() {
        return this.zza;
    }

    public final String getSharedSecretKey() {
        return this.zzc;
    }

    public final void openInOtpApp(String str) {
        Preconditions.checkNotEmpty(str, "qrCodeUrl cannot be empty.");
        try {
            zza(str);
        } catch (ActivityNotFoundException unused) {
            zza("https://play.google.com/store/search?q=otpauth&c=apps");
        }
    }

    public final void openInOtpApp(String str, String str2, Activity activity) {
        Preconditions.checkNotEmpty(str, "QrCodeUrl cannot be empty.");
        Preconditions.checkNotEmpty(str2, "FallbackUrl cannot be empty.");
        Preconditions.checkNotNull(activity, "Activity cannot be null.");
        try {
            zzb(str, activity);
        } catch (ActivityNotFoundException unused) {
            zzb(str2, activity);
        }
    }

    public final String generateQrCodeUrl(String str, String str2) {
        Preconditions.checkNotEmpty(str, "accountName cannot be empty.");
        Preconditions.checkNotEmpty(str2, "issuer cannot be empty.");
        return String.format((Locale) null, "otpauth://totp/%s:%s?secret=%s&issuer=%s&algorithm=%s&digits=%d", new Object[]{str2, str, this.zzc, str2, this.zzd, Integer.valueOf(this.zze)});
    }
}
