package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Ed25519;
import java.lang.reflect.Array;
import java.math.BigInteger;

final class Ed25519Constants {
    static final Ed25519.CachedXYT[] B2 = new Ed25519.CachedXYT[8];
    static final Ed25519.CachedXYT[][] B_TABLE = ((Ed25519.CachedXYT[][]) Array.newInstance(Ed25519.CachedXYT.class, new int[]{32, 8}));
    static final long[] D;
    static final long[] D2;
    private static final BigInteger D2_BI;
    private static final BigInteger D_BI;
    private static final BigInteger P_BI;
    static final long[] SQRTM1;
    private static final BigInteger SQRTM1_BI;

    public static class Point {
        /* access modifiers changed from: private */

        /* renamed from: x  reason: collision with root package name */
        public BigInteger f47314x;
        /* access modifiers changed from: private */

        /* renamed from: y  reason: collision with root package name */
        public BigInteger f47315y;

        private Point() {
        }
    }

    static {
        BigInteger subtract = BigInteger.valueOf(2).pow(255).subtract(BigInteger.valueOf(19));
        P_BI = subtract;
        BigInteger mod = BigInteger.valueOf(-121665).multiply(BigInteger.valueOf(121666).modInverse(subtract)).mod(subtract);
        D_BI = mod;
        BigInteger mod2 = BigInteger.valueOf(2).multiply(mod).mod(subtract);
        D2_BI = mod2;
        BigInteger modPow = BigInteger.valueOf(2).modPow(subtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4)), subtract);
        SQRTM1_BI = modPow;
        Point point = new Point();
        BigInteger unused = point.f47315y = BigInteger.valueOf(4).multiply(BigInteger.valueOf(5).modInverse(subtract)).mod(subtract);
        BigInteger unused2 = point.f47314x = recoverX(point.f47315y);
        D = Field25519.expand(toLittleEndian(mod));
        D2 = Field25519.expand(toLittleEndian(mod2));
        SQRTM1 = Field25519.expand(toLittleEndian(modPow));
        Point point2 = point;
        for (int i11 = 0; i11 < 32; i11++) {
            Point point3 = point2;
            for (int i12 = 0; i12 < 8; i12++) {
                B_TABLE[i11][i12] = getCachedXYT(point3);
                point3 = edwards(point3, point2);
            }
            for (int i13 = 0; i13 < 8; i13++) {
                point2 = edwards(point2, point2);
            }
        }
        Point edwards = edwards(point, point);
        for (int i14 = 0; i14 < 8; i14++) {
            B2[i14] = getCachedXYT(point);
            point = edwards(point, edwards);
        }
    }

    private Ed25519Constants() {
    }

    private static Point edwards(Point point, Point point2) {
        Point point3 = new Point();
        BigInteger multiply = D_BI.multiply(point.f47314x.multiply(point2.f47314x).multiply(point.f47315y).multiply(point2.f47315y));
        BigInteger bigInteger = P_BI;
        BigInteger mod = multiply.mod(bigInteger);
        BigInteger add = point.f47314x.multiply(point2.f47315y).add(point2.f47314x.multiply(point.f47315y));
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger unused = point3.f47314x = add.multiply(bigInteger2.add(mod).modInverse(bigInteger)).mod(bigInteger);
        BigInteger unused2 = point3.f47315y = point.f47315y.multiply(point2.f47315y).add(point.f47314x.multiply(point2.f47314x)).multiply(bigInteger2.subtract(mod).modInverse(bigInteger)).mod(bigInteger);
        return point3;
    }

    private static Ed25519.CachedXYT getCachedXYT(Point point) {
        BigInteger add = point.f47315y.add(point.f47314x);
        BigInteger bigInteger = P_BI;
        return new Ed25519.CachedXYT(Field25519.expand(toLittleEndian(add.mod(bigInteger))), Field25519.expand(toLittleEndian(point.f47315y.subtract(point.f47314x).mod(bigInteger))), Field25519.expand(toLittleEndian(D2_BI.multiply(point.f47314x).multiply(point.f47315y).mod(bigInteger))));
    }

    private static BigInteger recoverX(BigInteger bigInteger) {
        BigInteger pow = bigInteger.pow(2);
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger subtract = pow.subtract(bigInteger2);
        BigInteger add = D_BI.multiply(bigInteger.pow(2)).add(bigInteger2);
        BigInteger bigInteger3 = P_BI;
        BigInteger multiply = subtract.multiply(add.modInverse(bigInteger3));
        BigInteger modPow = multiply.modPow(bigInteger3.add(BigInteger.valueOf(3)).divide(BigInteger.valueOf(8)), bigInteger3);
        if (!modPow.pow(2).subtract(multiply).mod(bigInteger3).equals(BigInteger.ZERO)) {
            modPow = modPow.multiply(SQRTM1_BI).mod(bigInteger3);
        }
        if (modPow.testBit(0)) {
            return bigInteger3.subtract(modPow);
        }
        return modPow;
    }

    private static byte[] toLittleEndian(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i11 = 0; i11 < 16; i11++) {
            byte b11 = bArr[i11];
            int i12 = (32 - i11) - 1;
            bArr[i11] = bArr[i12];
            bArr[i12] = b11;
        }
        return bArr;
    }
}
