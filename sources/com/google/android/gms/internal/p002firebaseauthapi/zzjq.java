package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjq  reason: invalid package */
public final class zzjq {
    /* access modifiers changed from: private */
    public Context zza = null;
    /* access modifiers changed from: private */
    public String zzb = null;
    /* access modifiers changed from: private */
    public String zzc = null;
    private String zzd = null;
    /* access modifiers changed from: private */
    public zzbd zze = null;
    private zzbu zzf = null;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzbz zzg;

    @Nullable
    private final zzbd zzj() throws GeneralSecurityException {
        if (!zzjs.zzd()) {
            Log.w(zzjs.zzc, "Android Keystore requires at least Android M");
            return null;
        }
        zzju zzju = new zzju();
        try {
            boolean zzc2 = zzju.zzc(this.zzd);
            try {
                return zzju.zza(this.zzd);
            } catch (GeneralSecurityException | ProviderException e11) {
                if (zzc2) {
                    Log.w(zzjs.zzc, "cannot use Android Keystore, it'll be disabled", e11);
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", new Object[]{this.zzd}), e11);
            }
        } catch (GeneralSecurityException | ProviderException e12) {
            Log.w(zzjs.zzc, "cannot use Android Keystore, it'll be disabled", e12);
            return null;
        }
    }

    private final zzbz zzk(byte[] bArr) throws GeneralSecurityException, IOException {
        try {
            this.zze = new zzju().zza(this.zzd);
            try {
                return zzbz.zzf(zzby.zzh(zzbe.zzc(bArr), this.zze));
            } catch (IOException | GeneralSecurityException e11) {
                try {
                    return zzl(bArr);
                } catch (IOException unused) {
                    throw e11;
                }
            }
        } catch (GeneralSecurityException | ProviderException e12) {
            try {
                zzbz zzl = zzl(bArr);
                Log.w(zzjs.zzc, "cannot use Android Keystore, it'll be disabled", e12);
                return zzl;
            } catch (IOException unused2) {
                throw e12;
            }
        }
    }

    private static final zzbz zzl(byte[] bArr) throws GeneralSecurityException, IOException {
        return zzbz.zzf(zzbg.zzb(zzbe.zzc(bArr)));
    }

    public final zzjq zzd(zztc zztc) {
        String zzg2 = zztc.zzg();
        byte[] zzq = zztc.zzf().zzq();
        zzud zze2 = zztc.zze();
        int i11 = zzjs.zza;
        zzud zzud = zzud.UNKNOWN_PREFIX;
        int ordinal = zze2.ordinal();
        int i12 = 1;
        if (ordinal != 1) {
            i12 = 2;
            if (ordinal != 2) {
                i12 = 3;
                if (ordinal != 3) {
                    i12 = 4;
                    if (ordinal != 4) {
                        throw new IllegalArgumentException("Unknown output prefix type");
                    }
                }
            }
        }
        this.zzf = zzbu.zzc(zzg2, zzq, i12);
        return this;
    }

    public final zzjq zze(String str) {
        if (str.startsWith(AndroidKeystoreKmsClient.PREFIX)) {
            this.zzd = str;
            return this;
        }
        throw new IllegalArgumentException("key URI must start with android-keystore://");
    }

    public final zzjq zzf(Context context, String str, String str2) throws IOException {
        if (context != null) {
            this.zza = context;
            this.zzb = "GenericIdpKeyset";
            this.zzc = str2;
            return this;
        }
        throw new IllegalArgumentException("need an Android context");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:56|57|58) */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f9, code lost:
        throw new java.io.CharConversionException(java.lang.String.format("can't read keyset; the pref value %s is not a valid hex string", new java.lang.Object[]{r2}));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00e9 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.p002firebaseauthapi.zzjs zzg() throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            java.lang.String r0 = r11.zzb     // Catch:{ all -> 0x010d }
            if (r0 == 0) goto L_0x0105
            java.lang.Object r0 = com.google.android.gms.internal.p002firebaseauthapi.zzjs.zzb     // Catch:{ all -> 0x010d }
            monitor-enter(r0)     // Catch:{ all -> 0x010d }
            android.content.Context r1 = r11.zza     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = r11.zzb     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = r11.zzc     // Catch:{ all -> 0x0102 }
            if (r2 == 0) goto L_0x00fa
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x0102 }
            r4 = 0
            if (r3 != 0) goto L_0x001e
            android.content.SharedPreferences r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r1)     // Catch:{ all -> 0x0102 }
            goto L_0x0022
        L_0x001e:
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r3, r4)     // Catch:{ all -> 0x0102 }
        L_0x0022:
            r3 = 0
            java.lang.String r1 = r1.getString(r2, r3)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            if (r1 != 0) goto L_0x002b
            r6 = r3
            goto L_0x006a
        L_0x002b:
            int r5 = r1.length()     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            int r5 = r5 % 2
            if (r5 != 0) goto L_0x00e1
            int r5 = r1.length()     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            int r5 = r5 / 2
            byte[] r6 = new byte[r5]     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            r7 = r4
        L_0x003c:
            if (r7 >= r5) goto L_0x006a
            int r8 = r7 + r7
            char r9 = r1.charAt(r8)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            r10 = 16
            int r9 = java.lang.Character.digit(r9, r10)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            int r8 = r8 + 1
            char r8 = r1.charAt(r8)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            int r8 = java.lang.Character.digit(r8, r10)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            r10 = -1
            if (r9 == r10) goto L_0x0062
            if (r8 == r10) goto L_0x0062
            int r9 = r9 * 16
            int r9 = r9 + r8
            byte r8 = (byte) r9     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            r6[r7] = r8     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            int r7 = r7 + 1
            goto L_0x003c
        L_0x0062:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            java.lang.String r3 = "input is not hexadecimal"
            r1.<init>(r3)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            throw r1     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
        L_0x006a:
            if (r6 != 0) goto L_0x00c1
            java.lang.String r1 = r11.zzd     // Catch:{ all -> 0x0102 }
            if (r1 == 0) goto L_0x0076
            com.google.android.gms.internal.firebase-auth-api.zzbd r1 = r11.zzj()     // Catch:{ all -> 0x0102 }
            r11.zze = r1     // Catch:{ all -> 0x0102 }
        L_0x0076:
            com.google.android.gms.internal.firebase-auth-api.zzbu r1 = r11.zzf     // Catch:{ all -> 0x0102 }
            if (r1 == 0) goto L_0x00b9
            com.google.android.gms.internal.firebase-auth-api.zzbz r1 = com.google.android.gms.internal.p002firebaseauthapi.zzbz.zze()     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.firebase-auth-api.zzbu r2 = r11.zzf     // Catch:{ all -> 0x0102 }
            r1.zzc(r2)     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.firebase-auth-api.zzby r2 = r1.zzb()     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.firebase-auth-api.zztp r2 = r2.zzd()     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.firebase-auth-api.zzto r2 = r2.zzb(r4)     // Catch:{ all -> 0x0102 }
            int r2 = r2.zza()     // Catch:{ all -> 0x0102 }
            r1.zzd(r2)     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.firebase-auth-api.zzjv r2 = new com.google.android.gms.internal.firebase-auth-api.zzjv     // Catch:{ all -> 0x0102 }
            android.content.Context r4 = r11.zza     // Catch:{ all -> 0x0102 }
            java.lang.String r5 = r11.zzb     // Catch:{ all -> 0x0102 }
            java.lang.String r6 = r11.zzc     // Catch:{ all -> 0x0102 }
            r2.<init>(r4, r5, r6)     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.firebase-auth-api.zzbd r4 = r11.zze     // Catch:{ all -> 0x0102 }
            if (r4 == 0) goto L_0x00af
            com.google.android.gms.internal.firebase-auth-api.zzby r4 = r1.zzb()     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.firebase-auth-api.zzbd r5 = r11.zze     // Catch:{ all -> 0x0102 }
            r4.zzf(r2, r5)     // Catch:{ all -> 0x0102 }
            goto L_0x00b6
        L_0x00af:
            com.google.android.gms.internal.firebase-auth-api.zzby r4 = r1.zzb()     // Catch:{ all -> 0x0102 }
            com.google.android.gms.internal.p002firebaseauthapi.zzbg.zza(r4, r2)     // Catch:{ all -> 0x0102 }
        L_0x00b6:
            r11.zzg = r1     // Catch:{ all -> 0x0102 }
            goto L_0x00d9
        L_0x00b9:
            java.security.GeneralSecurityException r1 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = "cannot read or generate keyset"
            r1.<init>(r2)     // Catch:{ all -> 0x0102 }
            throw r1     // Catch:{ all -> 0x0102 }
        L_0x00c1:
            java.lang.String r1 = r11.zzd     // Catch:{ all -> 0x0102 }
            if (r1 == 0) goto L_0x00d3
            boolean r1 = com.google.android.gms.internal.p002firebaseauthapi.zzjs.zzd()     // Catch:{ all -> 0x0102 }
            if (r1 != 0) goto L_0x00cc
            goto L_0x00d3
        L_0x00cc:
            com.google.android.gms.internal.firebase-auth-api.zzbz r1 = r11.zzk(r6)     // Catch:{ all -> 0x0102 }
            r11.zzg = r1     // Catch:{ all -> 0x0102 }
            goto L_0x00d9
        L_0x00d3:
            com.google.android.gms.internal.firebase-auth-api.zzbz r1 = zzl(r6)     // Catch:{ all -> 0x0102 }
            r11.zzg = r1     // Catch:{ all -> 0x0102 }
        L_0x00d9:
            com.google.android.gms.internal.firebase-auth-api.zzjs r1 = new com.google.android.gms.internal.firebase-auth-api.zzjs     // Catch:{ all -> 0x0102 }
            r1.<init>(r11, r3)     // Catch:{ all -> 0x0102 }
            monitor-exit(r0)     // Catch:{ all -> 0x0102 }
            monitor-exit(r11)
            return r1
        L_0x00e1:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            java.lang.String r3 = "Expected a string of even length"
            r1.<init>(r3)     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
            throw r1     // Catch:{ ClassCastException | IllegalArgumentException -> 0x00e9 }
        L_0x00e9:
            java.io.CharConversionException r1 = new java.io.CharConversionException     // Catch:{ all -> 0x0102 }
            java.lang.String r3 = "can't read keyset; the pref value %s is not a valid hex string"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0102 }
            r5[r4] = r2     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = java.lang.String.format(r3, r5)     // Catch:{ all -> 0x0102 }
            r1.<init>(r2)     // Catch:{ all -> 0x0102 }
            throw r1     // Catch:{ all -> 0x0102 }
        L_0x00fa:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0102 }
            java.lang.String r2 = "keysetName cannot be null"
            r1.<init>(r2)     // Catch:{ all -> 0x0102 }
            throw r1     // Catch:{ all -> 0x0102 }
        L_0x0102:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0102 }
            throw r1     // Catch:{ all -> 0x010d }
        L_0x0105:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x010d }
            java.lang.String r1 = "keysetName cannot be null"
            r0.<init>(r1)     // Catch:{ all -> 0x010d }
            throw r0     // Catch:{ all -> 0x010d }
        L_0x010d:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzjq.zzg():com.google.android.gms.internal.firebase-auth-api.zzjs");
    }
}
