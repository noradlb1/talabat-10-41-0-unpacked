package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgz  reason: invalid package */
public final class zzgz {
    private static final ThreadLocal zza = new zzgy();
    private final SecretKey zzb;
    private final boolean zzc;

    public zzgz(byte[] bArr, boolean z11) throws GeneralSecurityException {
        if (zzhj.zza(2)) {
            zzwc.zzb(bArr.length);
            this.zzb = new SecretKeySpec(bArr, "AES");
            this.zzc = z11;
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        if (r10.equals("The Android Project") != false) goto L_0x003f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zza(byte[] r8, byte[] r9, byte[] r10) throws java.security.GeneralSecurityException {
        /*
            r7 = this;
            int r10 = r8.length
            r0 = 12
            if (r10 != r0) goto L_0x0086
            boolean r10 = r7.zzc
            r1 = 1
            if (r1 == r10) goto L_0x000d
            r2 = 16
            goto L_0x000f
        L_0x000d:
            r2 = 28
        L_0x000f:
            int r3 = r9.length
            if (r3 < r2) goto L_0x007e
            r2 = 0
            if (r10 == 0) goto L_0x002c
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.wrap(r8)
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r9, r2, r0)
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x0024
            goto L_0x002c
        L_0x0024:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.String r9 = "iv does not match prepended iv"
            r8.<init>(r9)
            throw r8
        L_0x002c:
            java.lang.String r10 = "java.vendor"
            java.lang.String r10 = java.lang.System.getProperty(r10)
            java.lang.String r4 = "The Android Project"
            if (r10 == r4) goto L_0x003f
            r5 = 0
            if (r10 == 0) goto L_0x0045
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x0045
        L_0x003f:
            int r10 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
        L_0x0045:
            if (r5 == 0) goto L_0x0055
            int r10 = r5.intValue()
            r4 = 19
            if (r10 > r4) goto L_0x0055
            javax.crypto.spec.IvParameterSpec r10 = new javax.crypto.spec.IvParameterSpec
            r10.<init>(r8, r2, r0)
            goto L_0x005c
        L_0x0055:
            javax.crypto.spec.GCMParameterSpec r10 = new javax.crypto.spec.GCMParameterSpec
            r4 = 128(0x80, float:1.794E-43)
            r10.<init>(r4, r8, r2, r0)
        L_0x005c:
            java.lang.ThreadLocal r8 = zza
            java.lang.Object r4 = r8.get()
            javax.crypto.Cipher r4 = (javax.crypto.Cipher) r4
            r5 = 2
            javax.crypto.SecretKey r6 = r7.zzb
            r4.init(r5, r6, r10)
            boolean r10 = r7.zzc
            if (r1 == r10) goto L_0x006f
            r0 = r2
        L_0x006f:
            if (r10 == 0) goto L_0x0073
            int r3 = r3 + -12
        L_0x0073:
            java.lang.Object r8 = r8.get()
            javax.crypto.Cipher r8 = (javax.crypto.Cipher) r8
            byte[] r8 = r8.doFinal(r9, r0, r3)
            return r8
        L_0x007e:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.String r9 = "ciphertext too short"
            r8.<init>(r9)
            throw r8
        L_0x0086:
            java.security.GeneralSecurityException r8 = new java.security.GeneralSecurityException
            java.lang.String r9 = "iv is wrong size"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzgz.zza(byte[], byte[], byte[]):byte[]");
    }
}
