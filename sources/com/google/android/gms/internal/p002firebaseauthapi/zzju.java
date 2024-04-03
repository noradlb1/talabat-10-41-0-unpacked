package com.google.android.gms.internal.p002firebaseauthapi;

import android.security.keystore.KeyGenParameterSpec;
import androidx.annotation.RequiresApi;
import com.google.android.gms.stats.CodePackage;
import com.google.crypto.tink.integration.android.AndroidKeystoreKmsClient;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;
import javax.crypto.KeyGenerator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzju  reason: invalid package */
public final class zzju implements zzcb {
    private static final Object zza = new Object();
    private static final String zzb = "zzju";
    @GuardedBy("this")
    private KeyStore zzc;

    @RequiresApi(23)
    public zzju() throws GeneralSecurityException {
        try {
            KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
            instance.load((KeyStore.LoadStoreParameter) null);
            this.zzc = instance;
        } catch (IOException | GeneralSecurityException e11) {
            throw new IllegalStateException(e11);
        }
    }

    @RequiresApi(23)
    public static boolean zzc(String str) throws GeneralSecurityException {
        zzju zzju = new zzju();
        synchronized (zza) {
            if (zzju.zzd(str)) {
                return false;
            }
            String zza2 = zzwc.zza(AndroidKeystoreKmsClient.PREFIX, str);
            KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            instance.init(new KeyGenParameterSpec.Builder(zza2, 3).setKeySize(256).setBlockModes(new String[]{CodePackage.GCM}).setEncryptionPaddings(new String[]{"NoPadding"}).build());
            instance.generateKey();
            return true;
        }
    }

    public final synchronized zzbd zza(String str) throws GeneralSecurityException {
        zzjt zzjt;
        zzjt = new zzjt(zzwc.zza(AndroidKeystoreKmsClient.PREFIX, str), this.zzc);
        byte[] zza2 = zzwa.zza(10);
        byte[] bArr = new byte[0];
        if (!Arrays.equals(zza2, zzjt.zza(zzjt.zzb(zza2, bArr), bArr))) {
            throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
        }
        return zzjt;
    }

    @RequiresApi(23)
    public final synchronized boolean zzb(String str) {
        if (str.toLowerCase(Locale.US).startsWith(AndroidKeystoreKmsClient.PREFIX)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:8|9|(12:10|11|12|13|14|15|17|18|19|20|21|22)) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        java.lang.Thread.sleep((long) ((int) (java.lang.Math.random() * 40.0d)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0 = java.security.KeyStore.getInstance("AndroidKeyStore");
        r4.zzc = r0;
        r0.load((java.security.KeyStore.LoadStoreParameter) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        return r4.zzc.containsAlias(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003c, code lost:
        throw new java.security.GeneralSecurityException(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        android.util.Log.w(zzb, "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzd(java.lang.String r5) throws java.security.GeneralSecurityException {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "android-keystore://"
            java.lang.String r5 = com.google.android.gms.internal.p002firebaseauthapi.zzwc.zza(r0, r5)     // Catch:{ all -> 0x003d }
            java.security.KeyStore r0 = r4.zzc     // Catch:{ NullPointerException -> 0x000f }
            boolean r5 = r0.containsAlias(r5)     // Catch:{ NullPointerException -> 0x000f }
            monitor-exit(r4)
            return r5
        L_0x000f:
            java.lang.String r0 = zzb     // Catch:{ all -> 0x003d }
            java.lang.String r1 = "Keystore is temporarily unavailable, wait, reinitialize Keystore and try again."
            android.util.Log.w(r0, r1)     // Catch:{ all -> 0x003d }
            double r0 = java.lang.Math.random()     // Catch:{ IOException -> 0x0036 }
            r2 = 4630826316843712512(0x4044000000000000, double:40.0)
            double r0 = r0 * r2
            int r0 = (int) r0
            long r0 = (long) r0
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0022 }
        L_0x0022:
            java.lang.String r0 = "AndroidKeyStore"
            java.security.KeyStore r0 = java.security.KeyStore.getInstance(r0)     // Catch:{ IOException -> 0x0036 }
            r4.zzc = r0     // Catch:{ IOException -> 0x0036 }
            r1 = 0
            r0.load(r1)     // Catch:{ IOException -> 0x0036 }
            java.security.KeyStore r0 = r4.zzc     // Catch:{ all -> 0x003d }
            boolean r5 = r0.containsAlias(r5)     // Catch:{ all -> 0x003d }
            monitor-exit(r4)
            return r5
        L_0x0036:
            r5 = move-exception
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ all -> 0x003d }
            r0.<init>(r5)     // Catch:{ all -> 0x003d }
            throw r0     // Catch:{ all -> 0x003d }
        L_0x003d:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzju.zzd(java.lang.String):boolean");
    }
}
