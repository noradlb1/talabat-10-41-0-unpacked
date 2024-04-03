package com.google.crypto.tink.subtle;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.KeyAgreement;
import org.apache.commons.compress.archivers.tar.TarConstants;

public final class EllipticCurves {

    /* renamed from: com.google.crypto.tink.subtle.EllipticCurves$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        static {
            /*
                com.google.crypto.tink.subtle.EllipticCurves$CurveType[] r0 = com.google.crypto.tink.subtle.EllipticCurves.CurveType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType = r0
                r1 = 1
                com.google.crypto.tink.subtle.EllipticCurves$CurveType r2 = com.google.crypto.tink.subtle.EllipticCurves.CurveType.NIST_P256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.subtle.EllipticCurves$CurveType r3 = com.google.crypto.tink.subtle.EllipticCurves.CurveType.NIST_P384     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.subtle.EllipticCurves$CurveType r4 = com.google.crypto.tink.subtle.EllipticCurves.CurveType.NIST_P521     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.google.crypto.tink.subtle.EllipticCurves$PointFormatType[] r3 = com.google.crypto.tink.subtle.EllipticCurves.PointFormatType.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType = r3
                com.google.crypto.tink.subtle.EllipticCurves$PointFormatType r4 = com.google.crypto.tink.subtle.EllipticCurves.PointFormatType.UNCOMPRESSED     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.crypto.tink.subtle.EllipticCurves$PointFormatType r3 = com.google.crypto.tink.subtle.EllipticCurves.PointFormatType.DO_NOT_USE_CRUNCHY_UNCOMPRESSED     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType     // Catch:{ NoSuchFieldError -> 0x004d }
                com.google.crypto.tink.subtle.EllipticCurves$PointFormatType r1 = com.google.crypto.tink.subtle.EllipticCurves.PointFormatType.COMPRESSED     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.EllipticCurves.AnonymousClass1.<clinit>():void");
        }
    }

    public enum CurveType {
        NIST_P256,
        NIST_P384,
        NIST_P521
    }

    public enum EcdsaEncoding {
        IEEE_P1363,
        DER
    }

    public enum PointFormatType {
        UNCOMPRESSED,
        COMPRESSED,
        DO_NOT_USE_CRUNCHY_UNCOMPRESSED
    }

    private EllipticCurves() {
    }

    public static void checkPointOnCurve(ECPoint eCPoint, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger modulus = getModulus(ellipticCurve);
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        if (affineX == null || affineY == null) {
            throw new GeneralSecurityException("point is at infinity");
        } else if (affineX.signum() == -1 || affineX.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        } else if (affineY.signum() == -1 || affineY.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("y is out of range");
        } else if (!affineY.multiply(affineY).mod(modulus).equals(affineX.multiply(affineX).add(ellipticCurve.getA()).multiply(affineX).add(ellipticCurve.getB()).mod(modulus))) {
            throw new GeneralSecurityException("Point is not on curve");
        }
    }

    public static void checkPublicKey(ECPublicKey eCPublicKey) throws GeneralSecurityException {
        checkPointOnCurve(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
    }

    public static byte[] computeSharedSecret(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey) throws GeneralSecurityException {
        validatePublicKeySpec(eCPublicKey, eCPrivateKey);
        return computeSharedSecret(eCPrivateKey, eCPublicKey.getW());
    }

    @Deprecated
    public static ECPoint ecPointDecode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return pointDecode(ellipticCurve, pointFormatType, bArr);
    }

    public static byte[] ecdsaDer2Ieee(byte[] bArr, int i11) throws GeneralSecurityException {
        int i12;
        byte b11;
        if (isValidDerEncoding(bArr)) {
            byte[] bArr2 = new byte[i11];
            byte b12 = 1;
            if ((bArr[1] & 255) >= 128) {
                i12 = 3;
            } else {
                i12 = 2;
            }
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            byte b13 = bArr[i13];
            if (bArr[i14] == 0) {
                b11 = 1;
            } else {
                b11 = 0;
            }
            System.arraycopy(bArr, i14 + b11, bArr2, ((i11 / 2) - b13) + b11, b13 - b11);
            int i15 = i14 + b13 + 1;
            int i16 = i15 + 1;
            byte b14 = bArr[i15];
            if (bArr[i16] != 0) {
                b12 = 0;
            }
            System.arraycopy(bArr, i16 + b12, bArr2, (i11 - b14) + b12, b14 - b12);
            return bArr2;
        }
        throw new GeneralSecurityException("Invalid DER encoding");
    }

    public static byte[] ecdsaIeee2Der(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        int i11;
        if (bArr.length % 2 != 0 || bArr.length == 0 || bArr.length > 132) {
            throw new GeneralSecurityException("Invalid IEEE_P1363 encoding");
        }
        byte[] minimalSignedNumber = toMinimalSignedNumber(Arrays.copyOf(bArr, bArr.length / 2));
        byte[] minimalSignedNumber2 = toMinimalSignedNumber(Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length));
        int length = minimalSignedNumber.length + 2 + 1 + 1 + minimalSignedNumber2.length;
        if (length >= 128) {
            bArr2 = new byte[(length + 3)];
            bArr2[0] = TarConstants.LF_NORMAL;
            bArr2[1] = -127;
            bArr2[2] = (byte) length;
            i11 = 3;
        } else {
            bArr2 = new byte[(length + 2)];
            bArr2[0] = TarConstants.LF_NORMAL;
            bArr2[1] = (byte) length;
            i11 = 2;
        }
        int i12 = i11 + 1;
        bArr2[i11] = 2;
        int i13 = i12 + 1;
        bArr2[i12] = (byte) minimalSignedNumber.length;
        System.arraycopy(minimalSignedNumber, 0, bArr2, i13, minimalSignedNumber.length);
        int length2 = i13 + minimalSignedNumber.length;
        int i14 = length2 + 1;
        bArr2[length2] = 2;
        bArr2[i14] = (byte) minimalSignedNumber2.length;
        System.arraycopy(minimalSignedNumber2, 0, bArr2, i14 + 1, minimalSignedNumber2.length);
        return bArr2;
    }

    public static int encodingSizeInBytes(EllipticCurve ellipticCurve, PointFormatType pointFormatType) throws GeneralSecurityException {
        int fieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int i11 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[pointFormatType.ordinal()];
        if (i11 == 1) {
            return (fieldSizeInBytes * 2) + 1;
        }
        if (i11 == 2) {
            return fieldSizeInBytes * 2;
        }
        if (i11 == 3) {
            return fieldSizeInBytes + 1;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static int fieldSizeInBits(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return getModulus(ellipticCurve).subtract(BigInteger.ONE).bitLength();
    }

    public static int fieldSizeInBytes(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        return (fieldSizeInBits(ellipticCurve) + 7) / 8;
    }

    public static KeyPair generateKeyPair(CurveType curveType) throws GeneralSecurityException {
        return generateKeyPair(getCurveSpec(curveType));
    }

    public static ECParameterSpec getCurveSpec(CurveType curveType) throws NoSuchAlgorithmException {
        int i11 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType[curveType.ordinal()];
        if (i11 == 1) {
            return getNistP256Params();
        }
        if (i11 == 2) {
            return getNistP384Params();
        }
        if (i11 == 3) {
            return getNistP521Params();
        }
        throw new NoSuchAlgorithmException("curve not implemented:" + curveType);
    }

    public static ECPrivateKey getEcPrivateKey(byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(bArr));
    }

    public static ECPublicKey getEcPublicKey(byte[] bArr) throws GeneralSecurityException {
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new X509EncodedKeySpec(bArr));
    }

    public static BigInteger getModulus(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        ECField field = ellipticCurve.getField();
        if (field instanceof ECFieldFp) {
            return ((ECFieldFp) field).getP();
        }
        throw new GeneralSecurityException("Only curves over prime order fields are supported");
    }

    private static ECParameterSpec getNistCurveSpec(String str, String str2, String str3, String str4, String str5) {
        BigInteger bigInteger = new BigInteger(str);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger(ExifInterface.GPS_MEASUREMENT_3D)), new BigInteger(str3, 16)), new ECPoint(new BigInteger(str4, 16), new BigInteger(str5, 16)), new BigInteger(str2), 1);
    }

    public static ECParameterSpec getNistP256Params() {
        return getNistCurveSpec("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
    }

    public static ECParameterSpec getNistP384Params() {
        return getNistCurveSpec("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
    }

    public static ECParameterSpec getNistP521Params() {
        return getNistCurveSpec("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
    }

    public static BigInteger getY(BigInteger bigInteger, boolean z11, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger modulus = getModulus(ellipticCurve);
        BigInteger a11 = ellipticCurve.getA();
        BigInteger modSqrt = modSqrt(bigInteger.multiply(bigInteger).add(a11).multiply(bigInteger).add(ellipticCurve.getB()).mod(modulus), modulus);
        if (z11 != modSqrt.testBit(0)) {
            return modulus.subtract(modSqrt).mod(modulus);
        }
        return modSqrt;
    }

    public static boolean isNistEcParameterSpec(ECParameterSpec eCParameterSpec) {
        if (isSameEcParameterSpec(eCParameterSpec, getNistP256Params()) || isSameEcParameterSpec(eCParameterSpec, getNistP384Params()) || isSameEcParameterSpec(eCParameterSpec, getNistP521Params())) {
            return true;
        }
        return false;
    }

    public static boolean isSameEcParameterSpec(ECParameterSpec eCParameterSpec, ECParameterSpec eCParameterSpec2) {
        if (!eCParameterSpec.getCurve().equals(eCParameterSpec2.getCurve()) || !eCParameterSpec.getGenerator().equals(eCParameterSpec2.getGenerator()) || !eCParameterSpec.getOrder().equals(eCParameterSpec2.getOrder()) || eCParameterSpec.getCofactor() != eCParameterSpec2.getCofactor()) {
            return false;
        }
        return true;
    }

    public static boolean isValidDerEncoding(byte[] bArr) {
        int i11;
        if (bArr.length < 8 || bArr[0] != 48) {
            return false;
        }
        byte b11 = bArr[1] & 255;
        if (b11 == 129) {
            b11 = bArr[2] & 255;
            if (b11 < 128) {
                return false;
            }
            i11 = 2;
        } else if (b11 == 128 || b11 > 129) {
            return false;
        } else {
            i11 = 1;
        }
        if (b11 != (bArr.length - 1) - i11) {
            return false;
        }
        int i12 = i11 + 1;
        if (bArr[i12] != 2) {
            return false;
        }
        int i13 = i12 + 1;
        byte b12 = bArr[i13] & 255;
        int i14 = i13 + 1 + b12 + 1;
        if (i14 >= bArr.length || b12 == 0) {
            return false;
        }
        int i15 = i11 + 3;
        byte b13 = bArr[i15];
        if ((b13 & 255) >= 128) {
            return false;
        }
        if ((b12 > 1 && b13 == 0 && (bArr[i11 + 4] & 255) < 128) || bArr[i15 + b12] != 2) {
            return false;
        }
        byte b14 = bArr[i14] & 255;
        if (i14 + 1 + b14 != bArr.length || b14 == 0) {
            return false;
        }
        byte b15 = bArr[i11 + 5 + b12];
        if ((b15 & 255) >= 128) {
            return false;
        }
        if (b14 <= 1 || b15 != 0 || (bArr[i11 + 6 + b12] & 255) >= 128) {
            return true;
        }
        return false;
    }

    public static BigInteger modSqrt(BigInteger bigInteger, BigInteger bigInteger2) throws GeneralSecurityException {
        BigInteger bigInteger3;
        if (bigInteger2.signum() == 1) {
            BigInteger mod = bigInteger.mod(bigInteger2);
            BigInteger bigInteger4 = BigInteger.ZERO;
            if (mod.equals(bigInteger4)) {
                return bigInteger4;
            }
            int i11 = 0;
            if (bigInteger2.testBit(0) && bigInteger2.testBit(1)) {
                bigInteger3 = mod.modPow(bigInteger2.add(BigInteger.ONE).shiftRight(2), bigInteger2);
            } else if (!bigInteger2.testBit(0) || bigInteger2.testBit(1)) {
                bigInteger3 = null;
            } else {
                BigInteger bigInteger5 = BigInteger.ONE;
                BigInteger shiftRight = bigInteger2.subtract(bigInteger5).shiftRight(1);
                while (true) {
                    BigInteger mod2 = bigInteger5.multiply(bigInteger5).subtract(mod).mod(bigInteger2);
                    if (mod2.equals(BigInteger.ZERO)) {
                        return bigInteger5;
                    }
                    BigInteger modPow = mod2.modPow(shiftRight, bigInteger2);
                    BigInteger bigInteger6 = BigInteger.ONE;
                    if (modPow.add(bigInteger6).equals(bigInteger2)) {
                        BigInteger shiftRight2 = bigInteger2.add(bigInteger6).shiftRight(1);
                        BigInteger bigInteger7 = bigInteger5;
                        for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                            BigInteger multiply = bigInteger7.multiply(bigInteger6);
                            bigInteger7 = bigInteger7.multiply(bigInteger7).add(bigInteger6.multiply(bigInteger6).mod(bigInteger2).multiply(mod2)).mod(bigInteger2);
                            BigInteger mod3 = multiply.add(multiply).mod(bigInteger2);
                            if (shiftRight2.testBit(bitLength)) {
                                BigInteger mod4 = bigInteger7.multiply(bigInteger5).add(mod3.multiply(mod2)).mod(bigInteger2);
                                bigInteger6 = bigInteger5.multiply(mod3).add(bigInteger7).mod(bigInteger2);
                                bigInteger7 = mod4;
                            } else {
                                bigInteger6 = mod3;
                            }
                        }
                        bigInteger3 = bigInteger7;
                    } else if (modPow.equals(bigInteger6)) {
                        bigInteger5 = bigInteger5.add(bigInteger6);
                        i11++;
                        if (i11 == 128 && !bigInteger2.isProbablePrime(80)) {
                            throw new InvalidAlgorithmParameterException("p is not prime");
                        }
                    } else {
                        throw new InvalidAlgorithmParameterException("p is not prime");
                    }
                }
            }
            if (bigInteger3 == null || bigInteger3.multiply(bigInteger3).mod(bigInteger2).compareTo(mod) == 0) {
                return bigInteger3;
            }
            throw new GeneralSecurityException("Could not find a modular square root");
        }
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    public static ECPoint pointDecode(CurveType curveType, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return pointDecode(getCurveSpec(curveType).getCurve(), pointFormatType, bArr);
    }

    public static byte[] pointEncode(CurveType curveType, PointFormatType pointFormatType, ECPoint eCPoint) throws GeneralSecurityException {
        return pointEncode(getCurveSpec(curveType).getCurve(), pointFormatType, eCPoint);
    }

    private static byte[] toMinimalSignedNumber(byte[] bArr) {
        int i11 = 0;
        int i12 = 0;
        while (i12 < bArr.length && bArr[i12] == 0) {
            i12++;
        }
        if (i12 == bArr.length) {
            i12 = bArr.length - 1;
        }
        if ((bArr[i12] & 128) == 128) {
            i11 = 1;
        }
        byte[] bArr2 = new byte[((bArr.length - i12) + i11)];
        System.arraycopy(bArr, i12, bArr2, i11, bArr.length - i12);
        return bArr2;
    }

    public static void validatePublicKey(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        validatePublicKeySpec(eCPublicKey, eCPrivateKey);
        checkPointOnCurve(eCPublicKey.getW(), eCPrivateKey.getParams().getCurve());
    }

    public static void validatePublicKeySpec(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        try {
            if (!isSameEcParameterSpec(eCPublicKey.getParams(), eCPrivateKey.getParams())) {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e11) {
            throw new GeneralSecurityException(e11);
        }
    }

    private static void validateSharedSecret(byte[] bArr, ECPrivateKey eCPrivateKey) throws GeneralSecurityException {
        EllipticCurve curve = eCPrivateKey.getParams().getCurve();
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.signum() == -1 || bigInteger.compareTo(getModulus(curve)) >= 0) {
            throw new GeneralSecurityException("shared secret is out of range");
        }
        getY(bigInteger, true, curve);
    }

    public static KeyPair generateKeyPair(ECParameterSpec eCParameterSpec) throws GeneralSecurityException {
        KeyPairGenerator instance = EngineFactory.KEY_PAIR_GENERATOR.getInstance("EC");
        instance.initialize(eCParameterSpec);
        return instance.generateKeyPair();
    }

    public static ECPoint pointDecode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        int fieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int i11 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[pointFormatType.ordinal()];
        boolean z11 = false;
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    BigInteger modulus = getModulus(ellipticCurve);
                    if (bArr.length == fieldSizeInBytes + 1) {
                        byte b11 = bArr[0];
                        if (b11 != 2) {
                            if (b11 == 3) {
                                z11 = true;
                            } else {
                                throw new GeneralSecurityException("invalid format");
                            }
                        }
                        BigInteger bigInteger = new BigInteger(1, Arrays.copyOfRange(bArr, 1, bArr.length));
                        if (bigInteger.signum() != -1 && bigInteger.compareTo(modulus) < 0) {
                            return new ECPoint(bigInteger, getY(bigInteger, z11, ellipticCurve));
                        }
                        throw new GeneralSecurityException("x is out of range");
                    }
                    throw new GeneralSecurityException("compressed point has wrong length");
                }
                throw new GeneralSecurityException("invalid format:" + pointFormatType);
            } else if (bArr.length == fieldSizeInBytes * 2) {
                ECPoint eCPoint = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 0, fieldSizeInBytes)), new BigInteger(1, Arrays.copyOfRange(bArr, fieldSizeInBytes, bArr.length)));
                checkPointOnCurve(eCPoint, ellipticCurve);
                return eCPoint;
            } else {
                throw new GeneralSecurityException("invalid point size");
            }
        } else if (bArr.length != (fieldSizeInBytes * 2) + 1) {
            throw new GeneralSecurityException("invalid point size");
        } else if (bArr[0] == 4) {
            int i12 = fieldSizeInBytes + 1;
            ECPoint eCPoint2 = new ECPoint(new BigInteger(1, Arrays.copyOfRange(bArr, 1, i12)), new BigInteger(1, Arrays.copyOfRange(bArr, i12, bArr.length)));
            checkPointOnCurve(eCPoint2, ellipticCurve);
            return eCPoint2;
        } else {
            throw new GeneralSecurityException("invalid point format");
        }
    }

    public static byte[] pointEncode(EllipticCurve ellipticCurve, PointFormatType pointFormatType, ECPoint eCPoint) throws GeneralSecurityException {
        checkPointOnCurve(eCPoint, ellipticCurve);
        int fieldSizeInBytes = fieldSizeInBytes(ellipticCurve);
        int i11 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$PointFormatType[pointFormatType.ordinal()];
        if (i11 != 1) {
            int i12 = 2;
            if (i11 == 2) {
                int i13 = fieldSizeInBytes * 2;
                byte[] bArr = new byte[i13];
                byte[] byteArray = eCPoint.getAffineX().toByteArray();
                if (byteArray.length > fieldSizeInBytes) {
                    byteArray = Arrays.copyOfRange(byteArray, byteArray.length - fieldSizeInBytes, byteArray.length);
                }
                byte[] byteArray2 = eCPoint.getAffineY().toByteArray();
                if (byteArray2.length > fieldSizeInBytes) {
                    byteArray2 = Arrays.copyOfRange(byteArray2, byteArray2.length - fieldSizeInBytes, byteArray2.length);
                }
                System.arraycopy(byteArray2, 0, bArr, i13 - byteArray2.length, byteArray2.length);
                System.arraycopy(byteArray, 0, bArr, fieldSizeInBytes - byteArray.length, byteArray.length);
                return bArr;
            } else if (i11 == 3) {
                int i14 = fieldSizeInBytes + 1;
                byte[] bArr2 = new byte[i14];
                byte[] byteArray3 = eCPoint.getAffineX().toByteArray();
                System.arraycopy(byteArray3, 0, bArr2, i14 - byteArray3.length, byteArray3.length);
                if (eCPoint.getAffineY().testBit(0)) {
                    i12 = 3;
                }
                bArr2[0] = (byte) i12;
                return bArr2;
            } else {
                throw new GeneralSecurityException("invalid format:" + pointFormatType);
            }
        } else {
            int i15 = (fieldSizeInBytes * 2) + 1;
            byte[] bArr3 = new byte[i15];
            byte[] byteArray4 = eCPoint.getAffineX().toByteArray();
            byte[] byteArray5 = eCPoint.getAffineY().toByteArray();
            System.arraycopy(byteArray5, 0, bArr3, i15 - byteArray5.length, byteArray5.length);
            System.arraycopy(byteArray4, 0, bArr3, (fieldSizeInBytes + 1) - byteArray4.length, byteArray4.length);
            bArr3[0] = 4;
            return bArr3;
        }
    }

    public static byte[] computeSharedSecret(ECPrivateKey eCPrivateKey, ECPoint eCPoint) throws GeneralSecurityException {
        checkPointOnCurve(eCPoint, eCPrivateKey.getParams().getCurve());
        PublicKey generatePublic = EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, eCPrivateKey.getParams()));
        KeyAgreement instance = EngineFactory.KEY_AGREEMENT.getInstance("ECDH");
        instance.init(eCPrivateKey);
        try {
            instance.doPhase(generatePublic, true);
            byte[] generateSecret = instance.generateSecret();
            validateSharedSecret(generateSecret, eCPrivateKey);
            return generateSecret;
        } catch (IllegalStateException e11) {
            throw new GeneralSecurityException(e11);
        }
    }

    public static ECPrivateKey getEcPrivateKey(CurveType curveType, byte[] bArr) throws GeneralSecurityException {
        return (ECPrivateKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, bArr), getCurveSpec(curveType)));
    }

    public static ECPublicKey getEcPublicKey(CurveType curveType, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return getEcPublicKey(getCurveSpec(curveType), pointFormatType, bArr);
    }

    public static ECPublicKey getEcPublicKey(ECParameterSpec eCParameterSpec, PointFormatType pointFormatType, byte[] bArr) throws GeneralSecurityException {
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(pointDecode(eCParameterSpec.getCurve(), pointFormatType, bArr), eCParameterSpec));
    }

    public static ECPublicKey getEcPublicKey(CurveType curveType, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ECParameterSpec curveSpec = getCurveSpec(curveType);
        ECPoint eCPoint = new ECPoint(new BigInteger(1, bArr), new BigInteger(1, bArr2));
        checkPointOnCurve(eCPoint, curveSpec.getCurve());
        return (ECPublicKey) EngineFactory.KEY_FACTORY.getInstance("EC").generatePublic(new ECPublicKeySpec(eCPoint, curveSpec));
    }
}
