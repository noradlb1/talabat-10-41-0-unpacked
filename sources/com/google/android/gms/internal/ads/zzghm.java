package com.google.android.gms.internal.ads;

import java.security.interfaces.ECPublicKey;

public final class zzghm {
    private final ECPublicKey zza;

    public zzghm(ECPublicKey eCPublicKey) {
        this.zza = eCPublicKey;
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f7 A[Catch:{ IllegalStateException -> 0x032d }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0315  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzghl zza(java.lang.String r18, byte[] r19, byte[] r20, int r21, int r22) throws java.security.GeneralSecurityException {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r21
            java.security.interfaces.ECPublicKey r4 = r1.zza
            java.security.spec.ECParameterSpec r4 = r4.getParams()
            java.security.KeyPair r4 = com.google.android.gms.internal.ads.zzghn.zzb(r4)
            java.security.PublicKey r5 = r4.getPublic()
            java.security.interfaces.ECPublicKey r5 = (java.security.interfaces.ECPublicKey) r5
            java.security.PrivateKey r4 = r4.getPrivate()
            java.security.interfaces.ECPrivateKey r4 = (java.security.interfaces.ECPrivateKey) r4
            java.security.interfaces.ECPublicKey r6 = r1.zza
            java.security.spec.ECParameterSpec r7 = r6.getParams()     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            java.security.spec.ECParameterSpec r8 = r4.getParams()     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            java.security.spec.EllipticCurve r9 = r7.getCurve()     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            java.security.spec.EllipticCurve r10 = r8.getCurve()     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            boolean r9 = r9.equals(r10)     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            if (r9 == 0) goto L_0x0338
            java.security.spec.ECPoint r9 = r7.getGenerator()     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            java.security.spec.ECPoint r10 = r8.getGenerator()     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            boolean r9 = r9.equals(r10)     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            if (r9 == 0) goto L_0x0338
            java.math.BigInteger r9 = r7.getOrder()     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            java.math.BigInteger r10 = r8.getOrder()     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            boolean r9 = r9.equals(r10)     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            if (r9 == 0) goto L_0x0338
            int r7 = r7.getCofactor()     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            int r8 = r8.getCofactor()     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            if (r7 != r8) goto L_0x0338
            java.security.spec.ECPoint r6 = r6.getW()
            java.security.spec.ECParameterSpec r7 = r4.getParams()
            java.security.spec.EllipticCurve r7 = r7.getCurve()
            com.google.android.gms.internal.ads.zzghn.zzc(r6, r7)
            java.security.spec.ECParameterSpec r7 = r4.getParams()
            java.security.spec.ECPublicKeySpec r8 = new java.security.spec.ECPublicKeySpec
            r8.<init>(r6, r7)
            com.google.android.gms.internal.ads.zzghp<com.google.android.gms.internal.ads.zzghs, java.security.KeyFactory> r6 = com.google.android.gms.internal.ads.zzghp.zzg
            java.lang.String r7 = "EC"
            java.lang.Object r6 = r6.zza(r7)
            java.security.KeyFactory r6 = (java.security.KeyFactory) r6
            java.security.PublicKey r6 = r6.generatePublic(r8)
            com.google.android.gms.internal.ads.zzghp<com.google.android.gms.internal.ads.zzghr, javax.crypto.KeyAgreement> r7 = com.google.android.gms.internal.ads.zzghp.zze
            java.lang.String r8 = "ECDH"
            java.lang.Object r7 = r7.zza(r8)
            javax.crypto.KeyAgreement r7 = (javax.crypto.KeyAgreement) r7
            r7.init(r4)
            r8 = 1
            r7.doPhase(r6, r8)     // Catch:{ IllegalStateException -> 0x032d }
            byte[] r6 = r7.generateSecret()     // Catch:{ IllegalStateException -> 0x032d }
            java.security.spec.ECParameterSpec r4 = r4.getParams()     // Catch:{ IllegalStateException -> 0x032d }
            java.security.spec.EllipticCurve r4 = r4.getCurve()     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r7 = new java.math.BigInteger     // Catch:{ IllegalStateException -> 0x032d }
            r7.<init>(r8, r6)     // Catch:{ IllegalStateException -> 0x032d }
            int r9 = r7.signum()     // Catch:{ IllegalStateException -> 0x032d }
            r10 = -1
            if (r9 == r10) goto L_0x0325
            java.math.BigInteger r9 = com.google.android.gms.internal.ads.zzghn.zza(r4)     // Catch:{ IllegalStateException -> 0x032d }
            int r9 = r7.compareTo(r9)     // Catch:{ IllegalStateException -> 0x032d }
            if (r9 >= 0) goto L_0x0325
            java.math.BigInteger r9 = com.google.android.gms.internal.ads.zzghn.zza(r4)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r11 = r4.getA()     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r4 = r4.getB()     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r12 = r7.multiply(r7)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r11 = r12.add(r11)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r7 = r11.multiply(r7)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r4 = r7.add(r4)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r4 = r4.mod(r9)     // Catch:{ IllegalStateException -> 0x032d }
            int r7 = r9.signum()     // Catch:{ IllegalStateException -> 0x032d }
            if (r7 != r8) goto L_0x031d
            java.math.BigInteger r4 = r4.mod(r9)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r7 = java.math.BigInteger.ZERO     // Catch:{ IllegalStateException -> 0x032d }
            boolean r11 = r4.equals(r7)     // Catch:{ IllegalStateException -> 0x032d }
            r12 = 2
            r13 = 0
            if (r11 == 0) goto L_0x00ec
        L_0x00e9:
            r4 = r13
            goto L_0x01f0
        L_0x00ec:
            boolean r7 = r9.testBit(r13)     // Catch:{ IllegalStateException -> 0x032d }
            if (r7 == 0) goto L_0x0108
            boolean r7 = r9.testBit(r8)     // Catch:{ IllegalStateException -> 0x032d }
            if (r7 == 0) goto L_0x0108
            java.math.BigInteger r7 = java.math.BigInteger.ONE     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r7 = r9.add(r7)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r7 = r7.shiftRight(r12)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r7 = r4.modPow(r7, r9)     // Catch:{ IllegalStateException -> 0x032d }
            goto L_0x01d6
        L_0x0108:
            boolean r7 = r9.testBit(r13)     // Catch:{ IllegalStateException -> 0x032d }
            r11 = 0
            if (r7 == 0) goto L_0x01d5
            boolean r7 = r9.testBit(r8)     // Catch:{ IllegalStateException -> 0x032d }
            if (r7 != 0) goto L_0x01d5
            java.math.BigInteger r7 = java.math.BigInteger.ONE     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r11 = r9.subtract(r7)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r11 = r11.shiftRight(r8)     // Catch:{ IllegalStateException -> 0x032d }
            r14 = r13
        L_0x0120:
            java.math.BigInteger r15 = r7.multiply(r7)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r15 = r15.subtract(r4)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r15 = r15.mod(r9)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r12 = java.math.BigInteger.ZERO     // Catch:{ IllegalStateException -> 0x032d }
            boolean r12 = r15.equals(r12)     // Catch:{ IllegalStateException -> 0x032d }
            if (r12 != 0) goto L_0x00e9
            java.math.BigInteger r12 = r15.modPow(r11, r9)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r10 = java.math.BigInteger.ONE     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r13 = r12.add(r10)     // Catch:{ IllegalStateException -> 0x032d }
            boolean r13 = r13.equals(r9)     // Catch:{ IllegalStateException -> 0x032d }
            if (r13 == 0) goto L_0x01a8
            java.math.BigInteger r11 = r9.add(r10)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r11 = r11.shiftRight(r8)     // Catch:{ IllegalStateException -> 0x032d }
            int r12 = r11.bitLength()     // Catch:{ IllegalStateException -> 0x032d }
            int r12 = r12 + -2
            r13 = r7
        L_0x0153:
            if (r12 < 0) goto L_0x01a6
            java.math.BigInteger r14 = r13.multiply(r10)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r13 = r13.multiply(r13)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r10 = r10.multiply(r10)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r10 = r10.mod(r9)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r10 = r10.multiply(r15)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r10 = r13.add(r10)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r10 = r10.mod(r9)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r13 = r14.add(r14)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r13 = r13.mod(r9)     // Catch:{ IllegalStateException -> 0x032d }
            boolean r14 = r11.testBit(r12)     // Catch:{ IllegalStateException -> 0x032d }
            if (r14 == 0) goto L_0x019d
            java.math.BigInteger r14 = r10.multiply(r7)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r8 = r13.multiply(r15)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r8 = r14.add(r8)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r8 = r8.mod(r9)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r13 = r7.multiply(r13)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r10 = r13.add(r10)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r10 = r10.mod(r9)     // Catch:{ IllegalStateException -> 0x032d }
            r13 = r8
            goto L_0x01a2
        L_0x019d:
            r16 = r13
            r13 = r10
            r10 = r16
        L_0x01a2:
            int r12 = r12 + -1
            r8 = 1
            goto L_0x0153
        L_0x01a6:
            r7 = r13
            goto L_0x01d6
        L_0x01a8:
            boolean r8 = r12.equals(r10)     // Catch:{ IllegalStateException -> 0x032d }
            java.lang.String r12 = "p is not prime"
            if (r8 == 0) goto L_0x01cf
            java.math.BigInteger r7 = r7.add(r10)     // Catch:{ IllegalStateException -> 0x032d }
            r8 = 1
            int r14 = r14 + r8
            r8 = 128(0x80, float:1.794E-43)
            if (r14 != r8) goto L_0x01c9
            r8 = 80
            boolean r8 = r9.isProbablePrime(r8)     // Catch:{ IllegalStateException -> 0x032d }
            if (r8 == 0) goto L_0x01c3
            goto L_0x01c9
        L_0x01c3:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException     // Catch:{ IllegalStateException -> 0x032d }
            r0.<init>(r12)     // Catch:{ IllegalStateException -> 0x032d }
            throw r0     // Catch:{ IllegalStateException -> 0x032d }
        L_0x01c9:
            r8 = 1
            r10 = -1
            r12 = 2
            r13 = 0
            goto L_0x0120
        L_0x01cf:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException     // Catch:{ IllegalStateException -> 0x032d }
            r0.<init>(r12)     // Catch:{ IllegalStateException -> 0x032d }
            throw r0     // Catch:{ IllegalStateException -> 0x032d }
        L_0x01d5:
            r7 = r11
        L_0x01d6:
            if (r7 == 0) goto L_0x01ef
            java.math.BigInteger r8 = r7.multiply(r7)     // Catch:{ IllegalStateException -> 0x032d }
            java.math.BigInteger r8 = r8.mod(r9)     // Catch:{ IllegalStateException -> 0x032d }
            int r4 = r8.compareTo(r4)     // Catch:{ IllegalStateException -> 0x032d }
            if (r4 != 0) goto L_0x01e7
            goto L_0x01ef
        L_0x01e7:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ IllegalStateException -> 0x032d }
            java.lang.String r2 = "Could not find a modular square root"
            r0.<init>(r2)     // Catch:{ IllegalStateException -> 0x032d }
            throw r0     // Catch:{ IllegalStateException -> 0x032d }
        L_0x01ef:
            r4 = 0
        L_0x01f0:
            boolean r8 = r7.testBit(r4)     // Catch:{ IllegalStateException -> 0x032d }
            r4 = 1
            if (r8 == r4) goto L_0x01fe
            java.math.BigInteger r4 = r9.subtract(r7)     // Catch:{ IllegalStateException -> 0x032d }
            r4.mod(r9)     // Catch:{ IllegalStateException -> 0x032d }
        L_0x01fe:
            java.security.spec.ECParameterSpec r4 = r5.getParams()
            java.security.spec.EllipticCurve r4 = r4.getCurve()
            java.security.spec.ECPoint r5 = r5.getW()
            com.google.android.gms.internal.ads.zzghn.zzc(r5, r4)
            java.math.BigInteger r4 = com.google.android.gms.internal.ads.zzghn.zza(r4)
            java.math.BigInteger r7 = java.math.BigInteger.ONE
            java.math.BigInteger r4 = r4.subtract(r7)
            int r4 = r4.bitLength()
            int r4 = r4 + 7
            int r4 = r4 / 8
            r7 = -1
            int r7 = r22 + -1
            if (r7 == 0) goto L_0x027e
            r8 = 2
            if (r7 == r8) goto L_0x0249
            r7 = 1
            int r4 = r4 + r7
            byte[] r8 = new byte[r4]
            java.math.BigInteger r9 = r5.getAffineX()
            byte[] r9 = r9.toByteArray()
            int r10 = r9.length
            int r4 = r4 - r10
            r11 = 0
            java.lang.System.arraycopy(r9, r11, r8, r4, r10)
            java.math.BigInteger r4 = r5.getAffineY()
            boolean r4 = r4.testBit(r11)
            if (r7 == r4) goto L_0x0245
            r4 = 2
            goto L_0x0246
        L_0x0245:
            r4 = 3
        L_0x0246:
            r8[r11] = r4
            goto L_0x027a
        L_0x0249:
            int r7 = r4 + r4
            byte[] r8 = new byte[r7]
            java.math.BigInteger r9 = r5.getAffineX()
            byte[] r9 = r9.toByteArray()
            int r10 = r9.length
            if (r10 <= r4) goto L_0x025e
            int r11 = r10 - r4
            byte[] r9 = java.util.Arrays.copyOfRange(r9, r11, r10)
        L_0x025e:
            java.math.BigInteger r5 = r5.getAffineY()
            byte[] r5 = r5.toByteArray()
            int r10 = r5.length
            if (r10 <= r4) goto L_0x026f
            int r11 = r10 - r4
            byte[] r5 = java.util.Arrays.copyOfRange(r5, r11, r10)
        L_0x026f:
            int r10 = r5.length
            int r7 = r7 - r10
            r11 = 0
            java.lang.System.arraycopy(r5, r11, r8, r7, r10)
            int r5 = r9.length
            int r4 = r4 - r5
            java.lang.System.arraycopy(r9, r11, r8, r4, r5)
        L_0x027a:
            r9 = r8
            r4 = 2
            r8 = 1
            goto L_0x02a4
        L_0x027e:
            r11 = 0
            int r7 = r4 + r4
            r8 = 1
            int r7 = r7 + r8
            byte[] r9 = new byte[r7]
            java.math.BigInteger r10 = r5.getAffineX()
            byte[] r10 = r10.toByteArray()
            java.math.BigInteger r5 = r5.getAffineY()
            byte[] r5 = r5.toByteArray()
            int r12 = r5.length
            int r7 = r7 - r12
            java.lang.System.arraycopy(r5, r11, r9, r7, r12)
            int r5 = r10.length
            int r4 = r4 + r8
            int r4 = r4 - r5
            java.lang.System.arraycopy(r10, r11, r9, r4, r5)
            r4 = 4
            r9[r11] = r4
            r4 = 2
        L_0x02a4:
            byte[][] r4 = new byte[r4][]
            r4[r11] = r9
            r4[r8] = r6
            byte[] r4 = com.google.android.gms.internal.ads.zzghc.zzb(r4)
            com.google.android.gms.internal.ads.zzghp<com.google.android.gms.internal.ads.zzghu, javax.crypto.Mac> r5 = com.google.android.gms.internal.ads.zzghp.zzb
            java.lang.Object r5 = r5.zza(r0)
            javax.crypto.Mac r5 = (javax.crypto.Mac) r5
            int r6 = r5.getMacLength()
            int r6 = r6 * 255
            if (r3 > r6) goto L_0x0315
            if (r2 == 0) goto L_0x02cd
            int r6 = r2.length
            if (r6 != 0) goto L_0x02c4
            goto L_0x02cd
        L_0x02c4:
            javax.crypto.spec.SecretKeySpec r6 = new javax.crypto.spec.SecretKeySpec
            r6.<init>(r2, r0)
            r5.init(r6)
            goto L_0x02db
        L_0x02cd:
            javax.crypto.spec.SecretKeySpec r2 = new javax.crypto.spec.SecretKeySpec
            int r6 = r5.getMacLength()
            byte[] r6 = new byte[r6]
            r2.<init>(r6, r0)
            r5.init(r2)
        L_0x02db:
            byte[] r2 = r5.doFinal(r4)
            byte[] r4 = new byte[r3]
            javax.crypto.spec.SecretKeySpec r6 = new javax.crypto.spec.SecretKeySpec
            r6.<init>(r2, r0)
            r5.init(r6)
            r0 = 0
            byte[] r2 = new byte[r0]
            r6 = r0
        L_0x02ed:
            r5.update(r2)
            r2 = r20
            r5.update(r2)
            byte r7 = (byte) r8
            r5.update(r7)
            byte[] r7 = r5.doFinal()
            int r10 = r7.length
            int r11 = r6 + r10
            if (r11 >= r3) goto L_0x030a
            java.lang.System.arraycopy(r7, r0, r4, r6, r10)
            int r8 = r8 + 1
            r2 = r7
            r6 = r11
            goto L_0x02ed
        L_0x030a:
            int r2 = r3 - r6
            java.lang.System.arraycopy(r7, r0, r4, r6, r2)
            com.google.android.gms.internal.ads.zzghl r0 = new com.google.android.gms.internal.ads.zzghl
            r0.<init>(r9, r4)
            return r0
        L_0x0315:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.String r2 = "size too large"
            r0.<init>(r2)
            throw r0
        L_0x031d:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException     // Catch:{ IllegalStateException -> 0x032d }
            java.lang.String r2 = "p must be positive"
            r0.<init>(r2)     // Catch:{ IllegalStateException -> 0x032d }
            throw r0     // Catch:{ IllegalStateException -> 0x032d }
        L_0x0325:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ IllegalStateException -> 0x032d }
            java.lang.String r2 = "shared secret is out of range"
            r0.<init>(r2)     // Catch:{ IllegalStateException -> 0x032d }
            throw r0     // Catch:{ IllegalStateException -> 0x032d }
        L_0x032d:
            r0 = move-exception
            java.security.GeneralSecurityException r2 = new java.security.GeneralSecurityException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        L_0x0338:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            java.lang.String r2 = "invalid public key spec"
            r0.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
            throw r0     // Catch:{ IllegalArgumentException -> 0x0342, NullPointerException -> 0x0340 }
        L_0x0340:
            r0 = move-exception
            goto L_0x0343
        L_0x0342:
            r0 = move-exception
        L_0x0343:
            java.security.GeneralSecurityException r2 = new java.security.GeneralSecurityException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzghm.zza(java.lang.String, byte[], byte[], int, int):com.google.android.gms.internal.ads.zzghl");
    }
}
