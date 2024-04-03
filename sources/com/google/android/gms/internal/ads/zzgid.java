package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.util.Arrays;
import javax.crypto.Mac;

public final class zzgid implements zzgbq {
    private final ThreadLocal<Mac> zza;
    /* access modifiers changed from: private */
    public final String zzb;
    /* access modifiers changed from: private */
    public final Key zzc;
    private final int zzd;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzgid(java.lang.String r6, java.security.Key r7) throws java.security.GeneralSecurityException {
        /*
            r5 = this;
            r5.<init>()
            com.google.android.gms.internal.ads.zzgic r0 = new com.google.android.gms.internal.ads.zzgic
            r0.<init>(r5)
            r5.zza = r0
            r1 = 2
            boolean r2 = com.google.android.gms.internal.ads.zzgak.zza(r1)
            if (r2 == 0) goto L_0x009c
            r5.zzb = r6
            r5.zzc = r7
            byte[] r7 = r7.getEncoded()
            int r7 = r7.length
            r2 = 16
            if (r7 < r2) goto L_0x0094
            int r7 = r6.hashCode()
            r2 = 4
            r3 = 3
            r4 = 1
            switch(r7) {
                case -1823053428: goto L_0x0051;
                case 392315023: goto L_0x0047;
                case 392315118: goto L_0x003d;
                case 392316170: goto L_0x0033;
                case 392317873: goto L_0x0029;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x005b
        L_0x0029:
            java.lang.String r7 = "HMACSHA512"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x005b
            r7 = r2
            goto L_0x005c
        L_0x0033:
            java.lang.String r7 = "HMACSHA384"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x005b
            r7 = r3
            goto L_0x005c
        L_0x003d:
            java.lang.String r7 = "HMACSHA256"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x005b
            r7 = r1
            goto L_0x005c
        L_0x0047:
            java.lang.String r7 = "HMACSHA224"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x005b
            r7 = r4
            goto L_0x005c
        L_0x0051:
            java.lang.String r7 = "HMACSHA1"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x005b
            r7 = 0
            goto L_0x005c
        L_0x005b:
            r7 = -1
        L_0x005c:
            if (r7 == 0) goto L_0x008c
            if (r7 == r4) goto L_0x0089
            if (r7 == r1) goto L_0x0086
            if (r7 == r3) goto L_0x0083
            if (r7 == r2) goto L_0x007e
            java.security.NoSuchAlgorithmException r7 = new java.security.NoSuchAlgorithmException
            int r0 = r6.length()
            java.lang.String r1 = "unknown Hmac algorithm: "
            if (r0 == 0) goto L_0x0075
            java.lang.String r6 = r1.concat(r6)
            goto L_0x007a
        L_0x0075:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1)
        L_0x007a:
            r7.<init>(r6)
            throw r7
        L_0x007e:
            r6 = 64
            r5.zzd = r6
            goto L_0x0090
        L_0x0083:
            r6 = 48
            goto L_0x008e
        L_0x0086:
            r6 = 32
            goto L_0x008e
        L_0x0089:
            r6 = 28
            goto L_0x008e
        L_0x008c:
            r6 = 20
        L_0x008e:
            r5.zzd = r6
        L_0x0090:
            r0.get()
            return
        L_0x0094:
            java.security.InvalidAlgorithmParameterException r6 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r7 = "key size too small, need at least 16 bytes"
            r6.<init>(r7)
            throw r6
        L_0x009c:
            java.security.GeneralSecurityException r6 = new java.security.GeneralSecurityException
            java.lang.String r7 = "Can not use HMAC in FIPS-mode, as BoringCrypto module is not available."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgid.<init>(java.lang.String, java.security.Key):void");
    }

    public final byte[] zza(byte[] bArr, int i11) throws GeneralSecurityException {
        if (i11 <= this.zzd) {
            this.zza.get().update(bArr);
            return Arrays.copyOf(this.zza.get().doFinal(), i11);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}
