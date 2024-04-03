package com.google.android.gms.internal.p002firebaseauthapi;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.KeyAgreement;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvb  reason: invalid package */
public final class zzvb {
    public static int zza(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (zzjy.zza(ellipticCurve).subtract(BigInteger.ONE).bitLength() + 7) / 8;
    }

    public static BigInteger zzb(BigInteger bigInteger, boolean z11, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger bigInteger2;
        BigInteger zza = zzjy.zza(ellipticCurve);
        BigInteger mod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(zza);
        if (zza.signum() == 1) {
            BigInteger mod2 = mod.mod(zza);
            BigInteger bigInteger3 = BigInteger.ZERO;
            if (!mod2.equals(bigInteger3)) {
                if (!zza.testBit(0) || !zza.testBit(1)) {
                    if (zza.testBit(0) && !zza.testBit(1)) {
                        bigInteger3 = BigInteger.ONE;
                        BigInteger shiftRight = zza.subtract(bigInteger3).shiftRight(1);
                        int i11 = 0;
                        while (true) {
                            BigInteger mod3 = bigInteger3.multiply(bigInteger3).subtract(mod2).mod(zza);
                            if (mod3.equals(BigInteger.ZERO)) {
                                break;
                            }
                            BigInteger modPow = mod3.modPow(shiftRight, zza);
                            BigInteger bigInteger4 = BigInteger.ONE;
                            if (modPow.add(bigInteger4).equals(zza)) {
                                BigInteger shiftRight2 = zza.add(bigInteger4).shiftRight(1);
                                BigInteger bigInteger5 = bigInteger3;
                                for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                                    BigInteger multiply = bigInteger5.multiply(bigInteger4);
                                    bigInteger5 = bigInteger5.multiply(bigInteger5).add(bigInteger4.multiply(bigInteger4).mod(zza).multiply(mod3)).mod(zza);
                                    BigInteger mod4 = multiply.add(multiply).mod(zza);
                                    if (shiftRight2.testBit(bitLength)) {
                                        BigInteger mod5 = bigInteger5.multiply(bigInteger3).add(mod4.multiply(mod3)).mod(zza);
                                        bigInteger4 = bigInteger3.multiply(mod4).add(bigInteger5).mod(zza);
                                        bigInteger5 = mod5;
                                    } else {
                                        bigInteger4 = mod4;
                                    }
                                }
                                bigInteger2 = bigInteger5;
                            } else if (modPow.equals(bigInteger4)) {
                                bigInteger3 = bigInteger3.add(bigInteger4);
                                i11++;
                                if (i11 == 128 && !zza.isProbablePrime(80)) {
                                    throw new InvalidAlgorithmParameterException("p is not prime");
                                }
                            } else {
                                throw new InvalidAlgorithmParameterException("p is not prime");
                            }
                        }
                    } else {
                        bigInteger2 = null;
                    }
                } else {
                    bigInteger2 = mod2.modPow(zza.add(BigInteger.ONE).shiftRight(2), zza);
                }
                if (bigInteger3 != null && bigInteger3.multiply(bigInteger3).mod(zza).compareTo(mod2) != 0) {
                    throw new GeneralSecurityException("Could not find a modular square root");
                }
            }
            if (z11 != bigInteger3.testBit(0)) {
                return zza.subtract(bigInteger3).mod(zza);
            }
            return bigInteger3;
        }
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    public static KeyPair zzc(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = (KeyPairGenerator) zzvk.zzf.zza("EC");
        keyPairGenerator.initialize(eCParameterSpec);
        return keyPairGenerator.generateKeyPair();
    }

    public static void zzd(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        zze(eCPublicKey, eCPrivateKey);
        zzjy.zzb(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    public static void zze(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        try {
            ECParameterSpec params = eCPublicKey.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            ECParameterSpec eCParameterSpec = zzjy.zza;
            if (!params.getCurve().equals(params2.getCurve()) || !params.getGenerator().equals(params2.getGenerator()) || !params.getOrder().equals(params2.getOrder()) || params.getCofactor() != params2.getCofactor()) {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e11) {
            throw new GeneralSecurityException(e11);
        }
    }

    public static byte[] zzf(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        zze(eCPublicKey, eCPrivateKey);
        ECPoint w11 = eCPublicKey.getW();
        zzjy.zzb(w11, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = ((KeyFactory) zzvk.zzg.zza("EC")).generatePublic(new ECPublicKeySpec(w11, eCPrivateKey.getParams()));
        KeyAgreement keyAgreement = (KeyAgreement) zzvk.zze.zza("ECDH");
        keyAgreement.init(eCPrivateKey);
        try {
            keyAgreement.doPhase(generatePublic, true);
            byte[] generateSecret = keyAgreement.generateSecret();
            EllipticCurve curve = eCPrivateKey.getParams().getCurve();
            BigInteger bigInteger = new BigInteger(1, generateSecret);
            if (bigInteger.signum() == -1 || bigInteger.compareTo(zzjy.zza(curve)) >= 0) {
                throw new GeneralSecurityException("shared secret is out of range");
            }
            zzb(bigInteger, true, curve);
            return generateSecret;
        } catch (IllegalStateException e11) {
            throw new GeneralSecurityException(e11);
        }
    }

    public static ECPrivateKey zzg(int i11, byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) ((KeyFactory) zzvk.zzg.zza("EC")).generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArr), zzi(i11)));
    }

    public static ECPublicKey zzh(ECParameterSpec eCParameterSpec, int i11, byte[] bArr) throws GeneralSecurityException {
        ECPoint eCPoint;
        EllipticCurve curve = eCParameterSpec.getCurve();
        int zza = zza(curve);
        int i12 = i11 - 1;
        boolean z11 = false;
        if (i12 == 0) {
            int length = bArr.length;
            if (length != zza + zza + 1) {
                throw new GeneralSecurityException("invalid point size");
            } else if (bArr[0] == 4) {
                int i13 = zza + 1;
                eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i13)), new BigInteger(1, Arrays.copyOfRange(bArr, i13, length)));
                zzjy.zzb(eCPoint, curve);
            } else {
                throw new GeneralSecurityException("invalid point format");
            }
        } else if (i12 != 1) {
            int length2 = bArr.length;
            if (length2 == zza + zza) {
                eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, zza)), new BigInteger(1, Arrays.copyOfRange(bArr, zza, length2)));
                zzjy.zzb(eCPoint, curve);
            } else {
                throw new GeneralSecurityException("invalid point size");
            }
        } else {
            BigInteger zza2 = zzjy.zza(curve);
            int length3 = bArr.length;
            if (length3 == zza + 1) {
                byte b11 = bArr[0];
                if (b11 != 2) {
                    if (b11 == 3) {
                        z11 = true;
                    } else {
                        throw new GeneralSecurityException("invalid format");
                    }
                }
                BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, length3));
                if (bigInteger.signum() == -1 || bigInteger.compareTo(zza2) >= 0) {
                    throw new GeneralSecurityException("x is out of range");
                }
                eCPoint = new ECPoint(bigInteger, zzb(bigInteger, z11, curve));
            } else {
                throw new GeneralSecurityException("compressed point has wrong length");
            }
        }
        return (ECPublicKey) ((KeyFactory) zzvk.zzg.zza("EC")).generatePublic(new ECPublicKeySpec(eCPoint, eCParameterSpec));
    }

    public static ECParameterSpec zzi(int i11) throws NoSuchAlgorithmException {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return zzjy.zza;
        }
        if (i12 != 1) {
            return zzjy.zzc;
        }
        return zzjy.zzb;
    }
}
