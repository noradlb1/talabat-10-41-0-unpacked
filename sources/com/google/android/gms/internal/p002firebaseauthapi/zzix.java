package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzix  reason: invalid package */
final class zzix {
    private final String zza;

    public zzix(String str) {
        this.zza = str;
    }

    private final byte[] zzf(byte[] bArr, byte[] bArr2, int i11) throws GeneralSecurityException {
        Mac mac = (Mac) zzvk.zzb.zza(this.zza);
        if (i11 <= mac.getMacLength() * 255) {
            byte[] bArr3 = new byte[i11];
            mac.init(new SecretKeySpec(bArr, this.zza));
            byte[] bArr4 = new byte[0];
            int i12 = 1;
            int i13 = 0;
            while (true) {
                mac.update(bArr4);
                mac.update(bArr2);
                mac.update((byte) i12);
                bArr4 = mac.doFinal();
                int length = bArr4.length;
                int i14 = i13 + length;
                if (i14 < i11) {
                    System.arraycopy(bArr4, 0, bArr3, i13, length);
                    i12++;
                    i13 = i14;
                } else {
                    System.arraycopy(bArr4, 0, bArr3, i13, i11 - i13);
                    return bArr3;
                }
            }
        } else {
            throw new GeneralSecurityException("size too large");
        }
    }

    private final byte[] zzg(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Mac mac = (Mac) zzvk.zzb.zza(this.zza);
        if (bArr2 == null || bArr2.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], this.zza));
        } else {
            mac.init(new SecretKeySpec(bArr2, this.zza));
        }
        return mac.doFinal(bArr);
    }

    public final int zza() throws GeneralSecurityException {
        return Mac.getInstance(this.zza).getMacLength();
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, String str2, byte[] bArr4, int i11) throws GeneralSecurityException {
        return zzf(zzg(zzjk.zze("eae_prk", bArr2, bArr4), (byte[]) null), zzjk.zzf("shared_secret", bArr3, bArr4, i11), i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzc() throws java.security.GeneralSecurityException {
        /*
            r5 = this;
            java.lang.String r0 = r5.zza
            int r1 = r0.hashCode()
            r2 = 984523022(0x3aaea10e, float:0.0013323145)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x002c
            r2 = 984524074(0x3aaea52a, float:0.0013324369)
            if (r1 == r2) goto L_0x0022
            r2 = 984525777(0x3aaeabd1, float:0.0013326352)
            if (r1 == r2) goto L_0x0018
            goto L_0x0036
        L_0x0018:
            java.lang.String r1 = "HmacSha512"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = r3
            goto L_0x0037
        L_0x0022:
            java.lang.String r1 = "HmacSha384"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = r4
            goto L_0x0037
        L_0x002c:
            java.lang.String r1 = "HmacSha256"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0036
            r0 = 0
            goto L_0x0037
        L_0x0036:
            r0 = -1
        L_0x0037:
            if (r0 == 0) goto L_0x004b
            if (r0 == r4) goto L_0x0048
            if (r0 != r3) goto L_0x0040
            byte[] r0 = com.google.android.gms.internal.p002firebaseauthapi.zzjk.zzh
            return r0
        L_0x0040:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.String r1 = "Could not determine HPKE KDF ID"
            r0.<init>(r1)
            throw r0
        L_0x0048:
            byte[] r0 = com.google.android.gms.internal.p002firebaseauthapi.zzjk.zzg
            return r0
        L_0x004b:
            byte[] r0 = com.google.android.gms.internal.p002firebaseauthapi.zzjk.zzf
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzix.zzc():byte[]");
    }

    public final byte[] zzd(byte[] bArr, byte[] bArr2, String str, byte[] bArr3, int i11) throws GeneralSecurityException {
        return zzf(bArr, zzjk.zzf(str, bArr2, bArr3, i11), i11);
    }

    public final byte[] zze(byte[] bArr, byte[] bArr2, String str, byte[] bArr3) throws GeneralSecurityException {
        return zzg(zzjk.zze(str, bArr2, bArr3), bArr);
    }
}
