package com.google.crypto.tink.subtle;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import org.apache.commons.compress.archivers.tar.TarConstants;

final class Ed25519 {
    private static final CachedXYT CACHED_NEUTRAL = new CachedXYT(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] GROUP_ORDER = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, TarConstants.LF_PAX_EXTENDED_HEADER_UC, -42, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.DLE};
    private static final PartialXYZT NEUTRAL = new PartialXYZT(new XYZ(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SECRET_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;

    public static class CachedXYT {
        final long[] t2d;
        final long[] yMinusX;
        final long[] yPlusX;

        public CachedXYT() {
            this(new long[10], new long[10], new long[10]);
        }

        public void copyConditional(CachedXYT cachedXYT, int i11) {
            Curve25519.copyConditional(this.yPlusX, cachedXYT.yPlusX, i11);
            Curve25519.copyConditional(this.yMinusX, cachedXYT.yMinusX, i11);
            Curve25519.copyConditional(this.t2d, cachedXYT.t2d, i11);
        }

        public void multByZ(long[] jArr, long[] jArr2) {
            System.arraycopy(jArr2, 0, jArr, 0, 10);
        }

        public CachedXYT(long[] jArr, long[] jArr2, long[] jArr3) {
            this.yPlusX = jArr;
            this.yMinusX = jArr2;
            this.t2d = jArr3;
        }

        public CachedXYT(CachedXYT cachedXYT) {
            this.yPlusX = Arrays.copyOf(cachedXYT.yPlusX, 10);
            this.yMinusX = Arrays.copyOf(cachedXYT.yMinusX, 10);
            this.t2d = Arrays.copyOf(cachedXYT.t2d, 10);
        }
    }

    public static class CachedXYZT extends CachedXYT {

        /* renamed from: z  reason: collision with root package name */
        private final long[] f47308z;

        public CachedXYZT() {
            this(new long[10], new long[10], new long[10], new long[10]);
        }

        public void multByZ(long[] jArr, long[] jArr2) {
            Field25519.mult(jArr, jArr2, this.f47308z);
        }

        public CachedXYZT(XYZT xyzt) {
            this();
            long[] jArr = this.yPlusX;
            XYZ xyz = xyzt.xyz;
            Field25519.sum(jArr, xyz.f47311y, xyz.f47310x);
            long[] jArr2 = this.yMinusX;
            XYZ xyz2 = xyzt.xyz;
            Field25519.sub(jArr2, xyz2.f47311y, xyz2.f47310x);
            System.arraycopy(xyzt.xyz.f47312z, 0, this.f47308z, 0, 10);
            Field25519.mult(this.t2d, xyzt.f47313t, Ed25519Constants.D2);
        }

        public CachedXYZT(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4) {
            super(jArr, jArr2, jArr4);
            this.f47308z = jArr3;
        }
    }

    public static class PartialXYZT {

        /* renamed from: t  reason: collision with root package name */
        final long[] f47309t;
        final XYZ xyz;

        public PartialXYZT() {
            this(new XYZ(), new long[10]);
        }

        public PartialXYZT(XYZ xyz2, long[] jArr) {
            this.xyz = xyz2;
            this.f47309t = jArr;
        }

        public PartialXYZT(PartialXYZT partialXYZT) {
            this.xyz = new XYZ(partialXYZT.xyz);
            this.f47309t = Arrays.copyOf(partialXYZT.f47309t, 10);
        }
    }

    public static class XYZ {

        /* renamed from: x  reason: collision with root package name */
        final long[] f47310x;

        /* renamed from: y  reason: collision with root package name */
        final long[] f47311y;

        /* renamed from: z  reason: collision with root package name */
        final long[] f47312z;

        public XYZ() {
            this(new long[10], new long[10], new long[10]);
        }

        public static XYZ fromPartialXYZT(XYZ xyz, PartialXYZT partialXYZT) {
            Field25519.mult(xyz.f47310x, partialXYZT.xyz.f47310x, partialXYZT.f47309t);
            long[] jArr = xyz.f47311y;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr, xyz2.f47311y, xyz2.f47312z);
            Field25519.mult(xyz.f47312z, partialXYZT.xyz.f47312z, partialXYZT.f47309t);
            return xyz;
        }

        public boolean isOnCurve() {
            long[] jArr = new long[10];
            Field25519.square(jArr, this.f47310x);
            long[] jArr2 = new long[10];
            Field25519.square(jArr2, this.f47311y);
            long[] jArr3 = new long[10];
            Field25519.square(jArr3, this.f47312z);
            long[] jArr4 = new long[10];
            Field25519.square(jArr4, jArr3);
            long[] jArr5 = new long[10];
            Field25519.sub(jArr5, jArr2, jArr);
            Field25519.mult(jArr5, jArr5, jArr3);
            long[] jArr6 = new long[10];
            Field25519.mult(jArr6, jArr, jArr2);
            Field25519.mult(jArr6, jArr6, Ed25519Constants.D);
            Field25519.sum(jArr6, jArr4);
            Field25519.reduce(jArr6, jArr6);
            return Bytes.equal(Field25519.contract(jArr5), Field25519.contract(jArr6));
        }

        public byte[] toBytes() {
            long[] jArr = new long[10];
            long[] jArr2 = new long[10];
            long[] jArr3 = new long[10];
            Field25519.inverse(jArr, this.f47312z);
            Field25519.mult(jArr2, this.f47310x, jArr);
            Field25519.mult(jArr3, this.f47311y, jArr);
            byte[] contract = Field25519.contract(jArr3);
            contract[31] = (byte) ((Ed25519.getLsb(jArr2) << 7) ^ contract[31]);
            return contract;
        }

        public XYZ(long[] jArr, long[] jArr2, long[] jArr3) {
            this.f47310x = jArr;
            this.f47311y = jArr2;
            this.f47312z = jArr3;
        }

        public XYZ(XYZ xyz) {
            this.f47310x = Arrays.copyOf(xyz.f47310x, 10);
            this.f47311y = Arrays.copyOf(xyz.f47311y, 10);
            this.f47312z = Arrays.copyOf(xyz.f47312z, 10);
        }

        public XYZ(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }
    }

    public static class XYZT {

        /* renamed from: t  reason: collision with root package name */
        final long[] f47313t;
        final XYZ xyz;

        public XYZT() {
            this(new XYZ(), new long[10]);
        }

        /* access modifiers changed from: private */
        public static XYZT fromBytesNegateVarTime(byte[] bArr) throws GeneralSecurityException {
            long[] jArr = new long[10];
            long[] expand = Field25519.expand(bArr);
            long[] jArr2 = new long[10];
            jArr2[0] = 1;
            long[] jArr3 = new long[10];
            long[] jArr4 = new long[10];
            long[] jArr5 = new long[10];
            long[] jArr6 = new long[10];
            long[] jArr7 = new long[10];
            Field25519.square(jArr4, expand);
            Field25519.mult(jArr5, jArr4, Ed25519Constants.D);
            Field25519.sub(jArr4, jArr4, jArr2);
            Field25519.sum(jArr5, jArr5, jArr2);
            long[] jArr8 = new long[10];
            Field25519.square(jArr8, jArr5);
            Field25519.mult(jArr8, jArr8, jArr5);
            Field25519.square(jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr5);
            Field25519.mult(jArr, jArr, jArr4);
            Ed25519.pow2252m3(jArr, jArr);
            Field25519.mult(jArr, jArr, jArr8);
            Field25519.mult(jArr, jArr, jArr4);
            Field25519.square(jArr6, jArr);
            Field25519.mult(jArr6, jArr6, jArr5);
            Field25519.sub(jArr7, jArr6, jArr4);
            if (Ed25519.isNonZeroVarTime(jArr7)) {
                Field25519.sum(jArr7, jArr6, jArr4);
                if (!Ed25519.isNonZeroVarTime(jArr7)) {
                    Field25519.mult(jArr, jArr, Ed25519Constants.SQRTM1);
                } else {
                    throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                }
            }
            if (Ed25519.isNonZeroVarTime(jArr) || ((bArr[31] & 255) >> 7) == 0) {
                if (Ed25519.getLsb(jArr) == ((bArr[31] & 255) >> 7)) {
                    Ed25519.neg(jArr, jArr);
                }
                Field25519.mult(jArr3, jArr, expand);
                return new XYZT(new XYZ(jArr, expand, jArr2), jArr3);
            }
            throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
        }

        /* access modifiers changed from: private */
        public static XYZT fromPartialXYZT(XYZT xyzt, PartialXYZT partialXYZT) {
            Field25519.mult(xyzt.xyz.f47310x, partialXYZT.xyz.f47310x, partialXYZT.f47309t);
            long[] jArr = xyzt.xyz.f47311y;
            XYZ xyz2 = partialXYZT.xyz;
            Field25519.mult(jArr, xyz2.f47311y, xyz2.f47312z);
            Field25519.mult(xyzt.xyz.f47312z, partialXYZT.xyz.f47312z, partialXYZT.f47309t);
            long[] jArr2 = xyzt.f47313t;
            XYZ xyz3 = partialXYZT.xyz;
            Field25519.mult(jArr2, xyz3.f47310x, xyz3.f47311y);
            return xyzt;
        }

        public XYZT(XYZ xyz2, long[] jArr) {
            this.xyz = xyz2;
            this.f47313t = jArr;
        }

        public XYZT(PartialXYZT partialXYZT) {
            this();
            fromPartialXYZT(this, partialXYZT);
        }
    }

    private Ed25519() {
    }

    private static void add(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.f47310x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.f47311y, xyz.f47310x);
        long[] jArr3 = partialXYZT.xyz.f47311y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.f47311y, xyz2.f47310x);
        long[] jArr4 = partialXYZT.xyz.f47311y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yMinusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.f47312z, xyz3.f47310x, cachedXYT.yPlusX);
        Field25519.mult(partialXYZT.f47309t, xyzt.f47313t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.f47310x, xyzt.xyz.f47312z);
        long[] jArr5 = partialXYZT.xyz.f47310x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.f47310x, xyz4.f47312z, xyz4.f47311y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.f47311y;
        Field25519.sum(jArr6, xyz5.f47312z, jArr6);
        Field25519.sum(partialXYZT.xyz.f47312z, jArr, partialXYZT.f47309t);
        long[] jArr7 = partialXYZT.f47309t;
        Field25519.sub(jArr7, jArr, jArr7);
    }

    private static XYZ doubleScalarMultVarTime(byte[] bArr, XYZT xyzt, byte[] bArr2) {
        CachedXYZT[] cachedXYZTArr = new CachedXYZT[8];
        cachedXYZTArr[0] = new CachedXYZT(xyzt);
        PartialXYZT partialXYZT = new PartialXYZT();
        doubleXYZT(partialXYZT, xyzt);
        XYZT xyzt2 = new XYZT(partialXYZT);
        for (int i11 = 1; i11 < 8; i11++) {
            add(partialXYZT, xyzt2, cachedXYZTArr[i11 - 1]);
            cachedXYZTArr[i11] = new CachedXYZT(new XYZT(partialXYZT));
        }
        byte[] slide = slide(bArr);
        byte[] slide2 = slide(bArr2);
        PartialXYZT partialXYZT2 = new PartialXYZT(NEUTRAL);
        XYZT xyzt3 = new XYZT();
        int i12 = 255;
        while (i12 >= 0 && slide[i12] == 0 && slide2[i12] == 0) {
            i12--;
        }
        while (i12 >= 0) {
            doubleXYZ(partialXYZT2, new XYZ(partialXYZT2));
            byte b11 = slide[i12];
            if (b11 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[slide[i12] / 2]);
            } else if (b11 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), cachedXYZTArr[(-slide[i12]) / 2]);
            }
            byte b12 = slide2[i12];
            if (b12 > 0) {
                add(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[slide2[i12] / 2]);
            } else if (b12 < 0) {
                sub(partialXYZT2, XYZT.fromPartialXYZT(xyzt3, partialXYZT2), Ed25519Constants.B2[(-slide2[i12]) / 2]);
            }
            i12--;
        }
        return new XYZ(partialXYZT2);
    }

    private static void doubleXYZ(PartialXYZT partialXYZT, XYZ xyz) {
        long[] jArr = new long[10];
        Field25519.square(partialXYZT.xyz.f47310x, xyz.f47310x);
        Field25519.square(partialXYZT.xyz.f47312z, xyz.f47311y);
        Field25519.square(partialXYZT.f47309t, xyz.f47312z);
        long[] jArr2 = partialXYZT.f47309t;
        Field25519.sum(jArr2, jArr2, jArr2);
        Field25519.sum(partialXYZT.xyz.f47311y, xyz.f47310x, xyz.f47311y);
        Field25519.square(jArr, partialXYZT.xyz.f47311y);
        XYZ xyz2 = partialXYZT.xyz;
        Field25519.sum(xyz2.f47311y, xyz2.f47312z, xyz2.f47310x);
        XYZ xyz3 = partialXYZT.xyz;
        long[] jArr3 = xyz3.f47312z;
        Field25519.sub(jArr3, jArr3, xyz3.f47310x);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.f47310x, jArr, xyz4.f47311y);
        long[] jArr4 = partialXYZT.f47309t;
        Field25519.sub(jArr4, jArr4, partialXYZT.xyz.f47312z);
    }

    private static void doubleXYZT(PartialXYZT partialXYZT, XYZT xyzt) {
        doubleXYZ(partialXYZT, xyzt.xyz);
    }

    private static int eq(int i11, int i12) {
        int i13 = (~(i11 ^ i12)) & 255;
        int i14 = i13 & (i13 << 4);
        int i15 = i14 & (i14 << 2);
        return ((i15 & (i15 << 1)) >> 7) & 1;
    }

    public static byte[] getHashedScalar(byte[] bArr) throws GeneralSecurityException {
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        instance.update(bArr, 0, 32);
        byte[] digest = instance.digest();
        digest[0] = (byte) (digest[0] & 248);
        byte b11 = (byte) (digest[31] & Byte.MAX_VALUE);
        digest[31] = b11;
        digest[31] = (byte) (b11 | SignedBytes.MAX_POWER_OF_TWO);
        return digest;
    }

    /* access modifiers changed from: private */
    public static int getLsb(long[] jArr) {
        return Field25519.contract(jArr)[0] & 1;
    }

    /* access modifiers changed from: private */
    public static boolean isNonZeroVarTime(long[] jArr) {
        long[] jArr2 = new long[(jArr.length + 1)];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        Field25519.reduceCoefficients(jArr2);
        for (byte b11 : Field25519.contract(jArr2)) {
            if (b11 != 0) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSmallerThanGroupOrder(byte[] bArr) {
        int i11 = 31;
        while (i11 >= 0) {
            byte b11 = bArr[i11] & 255;
            byte b12 = GROUP_ORDER[i11] & 255;
            if (b11 == b12) {
                i11--;
            } else if (b11 < b12) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private static long load3(byte[] bArr, int i11) {
        return (((long) (bArr[i11 + 2] & 255)) << 16) | (((long) bArr[i11]) & 255) | (((long) (bArr[i11 + 1] & 255)) << 8);
    }

    private static long load4(byte[] bArr, int i11) {
        return (((long) (bArr[i11 + 3] & 255)) << 24) | load3(bArr, i11);
    }

    private static void mulAdd(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = bArr2;
        byte[] bArr6 = bArr3;
        byte[] bArr7 = bArr4;
        long load3 = load3(bArr5, 0) & TarConstants.MAXID;
        long load4 = (load4(bArr5, 2) >> 5) & TarConstants.MAXID;
        long load32 = (load3(bArr5, 5) >> 2) & TarConstants.MAXID;
        long load42 = (load4(bArr5, 7) >> 7) & TarConstants.MAXID;
        long load43 = (load4(bArr5, 10) >> 4) & TarConstants.MAXID;
        long load33 = (load3(bArr5, 13) >> 1) & TarConstants.MAXID;
        long load44 = (load4(bArr5, 15) >> 6) & TarConstants.MAXID;
        long load34 = (load3(bArr5, 18) >> 3) & TarConstants.MAXID;
        long load35 = load3(bArr5, 21) & TarConstants.MAXID;
        long load45 = (load4(bArr5, 23) >> 5) & TarConstants.MAXID;
        long load36 = (load3(bArr5, 26) >> 2) & TarConstants.MAXID;
        long load46 = load4(bArr5, 28) >> 7;
        long load37 = load3(bArr6, 0) & TarConstants.MAXID;
        long load47 = (load4(bArr6, 2) >> 5) & TarConstants.MAXID;
        long load38 = (load3(bArr6, 5) >> 2) & TarConstants.MAXID;
        long load48 = (load4(bArr6, 7) >> 7) & TarConstants.MAXID;
        long load49 = (load4(bArr6, 10) >> 4) & TarConstants.MAXID;
        long load39 = (load3(bArr6, 13) >> 1) & TarConstants.MAXID;
        long load410 = (load4(bArr6, 15) >> 6) & TarConstants.MAXID;
        long load310 = (load3(bArr6, 18) >> 3) & TarConstants.MAXID;
        long load311 = load3(bArr6, 21) & TarConstants.MAXID;
        long load411 = (load4(bArr6, 23) >> 5) & TarConstants.MAXID;
        long load312 = (load3(bArr6, 26) >> 2) & TarConstants.MAXID;
        long load412 = load4(bArr6, 28) >> 7;
        long load313 = load3(bArr7, 0) & TarConstants.MAXID;
        long load413 = (load4(bArr7, 2) >> 5) & TarConstants.MAXID;
        long load314 = (load3(bArr7, 5) >> 2) & TarConstants.MAXID;
        long load414 = (load4(bArr7, 7) >> 7) & TarConstants.MAXID;
        long load415 = (load4(bArr7, 10) >> 4) & TarConstants.MAXID;
        long load315 = (load3(bArr7, 13) >> 1) & TarConstants.MAXID;
        long load416 = (load4(bArr7, 15) >> 6) & TarConstants.MAXID;
        long load316 = (load3(bArr7, 18) >> 3) & TarConstants.MAXID;
        long load317 = load3(bArr7, 21) & TarConstants.MAXID;
        long load417 = (load4(bArr7, 23) >> 5) & TarConstants.MAXID;
        long j11 = load313 + (load3 * load37);
        long j12 = load413 + (load3 * load47) + (load4 * load37);
        long j13 = load314 + (load3 * load38) + (load4 * load47) + (load32 * load37);
        long j14 = load414 + (load3 * load48) + (load4 * load38) + (load32 * load47) + (load42 * load37);
        long j15 = load415 + (load3 * load49) + (load4 * load48) + (load32 * load38) + (load42 * load47) + (load43 * load37);
        long j16 = load315 + (load3 * load39) + (load4 * load49) + (load32 * load48) + (load42 * load38) + (load43 * load47) + (load33 * load37);
        long j17 = load416 + (load3 * load410) + (load4 * load39) + (load32 * load49) + (load42 * load48) + (load43 * load38) + (load33 * load47) + (load44 * load37);
        long j18 = load316 + (load3 * load310) + (load4 * load410) + (load32 * load39) + (load42 * load49) + (load43 * load48) + (load33 * load38) + (load44 * load47) + (load34 * load37);
        long j19 = load317 + (load3 * load311) + (load4 * load310) + (load32 * load410) + (load42 * load39) + (load43 * load49) + (load33 * load48) + (load44 * load38) + (load34 * load47) + (load35 * load37);
        long j21 = load417 + (load3 * load411) + (load4 * load311) + (load32 * load310) + (load42 * load410) + (load43 * load39) + (load33 * load49) + (load44 * load48) + (load34 * load38) + (load35 * load47) + (load45 * load37);
        long load318 = ((load3(bArr7, 26) >> 2) & TarConstants.MAXID) + (load3 * load312) + (load4 * load411) + (load32 * load311) + (load42 * load310) + (load43 * load410) + (load33 * load39) + (load44 * load49) + (load34 * load48) + (load35 * load38) + (load45 * load47) + (load36 * load37);
        long j22 = (load4 * load412) + (load32 * load312) + (load42 * load411) + (load43 * load311) + (load33 * load310) + (load44 * load410) + (load34 * load39) + (load35 * load49) + (load45 * load48) + (load36 * load38) + (load47 * load46);
        long j23 = (load42 * load412) + (load43 * load312) + (load33 * load411) + (load44 * load311) + (load34 * load310) + (load35 * load410) + (load45 * load39) + (load36 * load49) + (load48 * load46);
        long j24 = (load33 * load412) + (load44 * load312) + (load34 * load411) + (load35 * load311) + (load45 * load310) + (load36 * load410) + (load39 * load46);
        long j25 = (load34 * load412) + (load35 * load312) + (load45 * load411) + (load36 * load311) + (load310 * load46);
        long j26 = (load45 * load412) + (load36 * load312) + (load411 * load46);
        long j27 = load46 * load412;
        long j28 = (j11 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j29 = j12 + j28;
        long j31 = j11 - (j28 << 21);
        long j32 = (j13 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j33 = j14 + j32;
        long j34 = j13 - (j32 << 21);
        long j35 = (j15 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j36 = j16 + j35;
        long j37 = j15 - (j35 << 21);
        long j38 = (j17 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j39 = j18 + j38;
        long j41 = j17 - (j38 << 21);
        long j42 = (j19 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j43 = j21 + j42;
        long j44 = j19 - (j42 << 21);
        long j45 = (load318 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long load418 = (load4(bArr7, 28) >> 7) + (load3 * load412) + (load4 * load312) + (load32 * load411) + (load42 * load311) + (load43 * load310) + (load33 * load410) + (load44 * load39) + (load34 * load49) + (load35 * load48) + (load45 * load38) + (load36 * load47) + (load37 * load46) + j45;
        long j46 = load318 - (j45 << 21);
        long j47 = (j22 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j48 = (load32 * load412) + (load42 * load312) + (load43 * load411) + (load33 * load311) + (load44 * load310) + (load34 * load410) + (load35 * load39) + (load45 * load49) + (load36 * load48) + (load38 * load46) + j47;
        long j49 = j22 - (j47 << 21);
        long j50 = (j23 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j51 = (load43 * load412) + (load33 * load312) + (load44 * load411) + (load34 * load311) + (load35 * load310) + (load45 * load410) + (load36 * load39) + (load49 * load46) + j50;
        long j52 = j23 - (j50 << 21);
        long j53 = (j24 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j54 = (load44 * load412) + (load34 * load312) + (load35 * load411) + (load45 * load311) + (load36 * load310) + (load410 * load46) + j53;
        long j55 = j24 - (j53 << 21);
        long j56 = (j25 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j57 = (load35 * load412) + (load45 * load312) + (load36 * load411) + (load311 * load46) + j56;
        long j58 = j25 - (j56 << 21);
        long j59 = (j26 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j60 = (load36 * load412) + (load312 * load46) + j59;
        long j61 = j26 - (j59 << 21);
        long j62 = (j27 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j63 = j62 + 0;
        long j64 = j27 - (j62 << 21);
        long j65 = (j29 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j66 = j34 + j65;
        long j67 = j29 - (j65 << 21);
        long j68 = (j33 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j69 = j37 + j68;
        long j70 = j33 - (j68 << 21);
        long j71 = (j36 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j72 = j41 + j71;
        long j73 = j36 - (j71 << 21);
        long j74 = (j39 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j75 = j44 + j74;
        long j76 = j39 - (j74 << 21);
        long j77 = (j43 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j78 = j46 + j77;
        long j79 = j43 - (j77 << 21);
        long j80 = (load418 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j81 = j49 + j80;
        long j82 = load418 - (j80 << 21);
        long j83 = (j48 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j84 = j52 + j83;
        long j85 = j48 - (j83 << 21);
        long j86 = (j51 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j87 = j55 + j86;
        long j88 = j51 - (j86 << 21);
        long j89 = (j54 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j90 = j58 + j89;
        long j91 = j54 - (j89 << 21);
        long j92 = (j57 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j93 = j61 + j92;
        long j94 = j57 - (j92 << 21);
        long j95 = (j60 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j96 = j64 + j95;
        long j97 = j60 - (j95 << 21);
        long j98 = j87 - (j63 * 683901);
        long j99 = ((j84 - (j63 * 997805)) + (j96 * 136657)) - (j97 * 683901);
        long j100 = ((((j81 + (j63 * 470296)) + (j96 * 654183)) - (j97 * 997805)) + (j93 * 136657)) - (j94 * 683901);
        long j101 = j72 + (j90 * 666643);
        long j102 = j76 + (j94 * 666643) + (j90 * 470296);
        long j103 = j75 + (j93 * 666643) + (j94 * 470296) + (j90 * 654183);
        long j104 = (((j79 + (j97 * 666643)) + (j93 * 470296)) + (j94 * 654183)) - (j90 * 997805);
        long j105 = ((((j78 + (j96 * 666643)) + (j97 * 470296)) + (j93 * 654183)) - (j94 * 997805)) + (j90 * 136657);
        long j106 = (((((j82 + (j63 * 666643)) + (j96 * 470296)) + (j97 * 654183)) - (j93 * 997805)) + (j94 * 136657)) - (j90 * 683901);
        long j107 = (j101 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j108 = j102 + j107;
        long j109 = j101 - (j107 << 21);
        long j110 = (j103 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j111 = j104 + j110;
        long j112 = j103 - (j110 << 21);
        long j113 = (j105 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j114 = j106 + j113;
        long j115 = j105 - (j113 << 21);
        long j116 = (j100 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j117 = ((((j85 + (j63 * 654183)) - (j96 * 997805)) + (j97 * 136657)) - (j93 * 683901)) + j116;
        long j118 = j100 - (j116 << 21);
        long j119 = (j99 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j120 = ((j88 + (j63 * 136657)) - (j96 * 683901)) + j119;
        long j121 = j99 - (j119 << 21);
        long j122 = (j98 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j123 = j91 + j122;
        long j124 = j98 - (j122 << 21);
        long j125 = (j108 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j126 = j112 + j125;
        long j127 = j108 - (j125 << 21);
        long j128 = (j111 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j129 = j115 + j128;
        long j130 = j111 - (j128 << 21);
        long j131 = (j114 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j132 = j118 + j131;
        long j133 = j114 - (j131 << 21);
        long j134 = (j117 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j135 = j121 + j134;
        long j136 = j117 - (j134 << 21);
        long j137 = (j120 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j138 = j124 + j137;
        long j139 = j120 - (j137 << 21);
        long j140 = j129 - (j123 * 683901);
        long j141 = ((j126 - (j123 * 997805)) + (j138 * 136657)) - (j139 * 683901);
        long j142 = ((((j109 + (j123 * 470296)) + (j138 * 654183)) - (j139 * 997805)) + (j135 * 136657)) - (j136 * 683901);
        long j143 = j31 + (j132 * 666643);
        long j144 = j67 + (j136 * 666643) + (j132 * 470296);
        long j145 = j66 + (j135 * 666643) + (j136 * 470296) + (j132 * 654183);
        long j146 = (((j70 + (j139 * 666643)) + (j135 * 470296)) + (j136 * 654183)) - (j132 * 997805);
        long j147 = ((((j69 + (j138 * 666643)) + (j139 * 470296)) + (j135 * 654183)) - (j136 * 997805)) + (j132 * 136657);
        long j148 = (((((j73 + (j123 * 666643)) + (j138 * 470296)) + (j139 * 654183)) - (j135 * 997805)) + (j136 * 136657)) - (j132 * 683901);
        long j149 = (j143 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j150 = j144 + j149;
        long j151 = j143 - (j149 << 21);
        long j152 = (j145 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j153 = j146 + j152;
        long j154 = j145 - (j152 << 21);
        long j155 = (j147 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j156 = j148 + j155;
        long j157 = j147 - (j155 << 21);
        long j158 = (j142 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j159 = ((((j127 + (j123 * 654183)) - (j138 * 997805)) + (j139 * 136657)) - (j135 * 683901)) + j158;
        long j160 = j142 - (j158 << 21);
        long j161 = (j141 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j162 = ((j130 + (j123 * 136657)) - (j138 * 683901)) + j161;
        long j163 = j141 - (j161 << 21);
        long j164 = (j140 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j165 = j133 + j164;
        long j166 = j140 - (j164 << 21);
        long j167 = (j150 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j168 = j154 + j167;
        long j169 = j150 - (j167 << 21);
        long j170 = (j153 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j171 = j157 + j170;
        long j172 = j153 - (j170 << 21);
        long j173 = (j156 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j174 = j160 + j173;
        long j175 = j156 - (j173 << 21);
        long j176 = (j159 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j177 = j163 + j176;
        long j178 = j159 - (j176 << 21);
        long j179 = (j162 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j180 = j166 + j179;
        long j181 = j162 - (j179 << 21);
        long j182 = (PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED + j165) >> 21;
        long j183 = 0 + j182;
        long j184 = j151 + (j183 * 666643);
        long j185 = j169 + (j183 * 470296);
        long j186 = j168 + (j183 * 654183);
        long j187 = j172 - (j183 * 997805);
        long j188 = j175 - (j183 * 683901);
        long j189 = j184 >> 21;
        long j190 = j185 + j189;
        long j191 = j184 - (j189 << 21);
        long j192 = j190 >> 21;
        long j193 = j186 + j192;
        long j194 = j190 - (j192 << 21);
        long j195 = j193 >> 21;
        long j196 = j187 + j195;
        long j197 = j193 - (j195 << 21);
        long j198 = j196 >> 21;
        long j199 = j171 + (j183 * 136657) + j198;
        long j200 = j196 - (j198 << 21);
        long j201 = j199 >> 21;
        long j202 = j188 + j201;
        long j203 = j199 - (j201 << 21);
        long j204 = j202 >> 21;
        long j205 = j174 + j204;
        long j206 = j202 - (j204 << 21);
        long j207 = j205 >> 21;
        long j208 = j178 + j207;
        long j209 = j205 - (j207 << 21);
        long j210 = j208 >> 21;
        long j211 = j177 + j210;
        long j212 = j208 - (j210 << 21);
        long j213 = j211 >> 21;
        long j214 = j181 + j213;
        long j215 = j211 - (j213 << 21);
        long j216 = j214 >> 21;
        long j217 = j180 + j216;
        long j218 = j214 - (j216 << 21);
        long j219 = j217 >> 21;
        long j220 = (j165 - (j182 << 21)) + j219;
        long j221 = j217 - (j219 << 21);
        long j222 = j220 >> 21;
        long j223 = 0 + j222;
        long j224 = j220 - (j222 << 21);
        long j225 = j191 + (666643 * j223);
        long j226 = j225 >> 21;
        long j227 = j194 + (470296 * j223) + j226;
        long j228 = j225 - (j226 << 21);
        long j229 = j227 >> 21;
        long j230 = j197 + (654183 * j223) + j229;
        long j231 = j227 - (j229 << 21);
        long j232 = j230 >> 21;
        long j233 = (j200 - (997805 * j223)) + j232;
        long j234 = j230 - (j232 << 21);
        long j235 = j233 >> 21;
        long j236 = j203 + (136657 * j223) + j235;
        long j237 = j233 - (j235 << 21);
        long j238 = j236 >> 21;
        long j239 = (j206 - (j223 * 683901)) + j238;
        long j240 = j236 - (j238 << 21);
        long j241 = j239 >> 21;
        long j242 = j209 + j241;
        long j243 = j239 - (j241 << 21);
        long j244 = j242 >> 21;
        long j245 = j212 + j244;
        long j246 = j242 - (j244 << 21);
        long j247 = j245 >> 21;
        long j248 = j215 + j247;
        long j249 = j245 - (j247 << 21);
        long j250 = j248 >> 21;
        long j251 = j218 + j250;
        long j252 = j248 - (j250 << 21);
        long j253 = j251 >> 21;
        long j254 = j221 + j253;
        long j255 = j251 - (j253 << 21);
        long j256 = j254 >> 21;
        long j257 = j224 + j256;
        long j258 = j254 - (j256 << 21);
        bArr[0] = (byte) ((int) j228);
        bArr[1] = (byte) ((int) (j228 >> 8));
        bArr[2] = (byte) ((int) ((j228 >> 16) | (j231 << 5)));
        bArr[3] = (byte) ((int) (j231 >> 3));
        bArr[4] = (byte) ((int) (j231 >> 11));
        bArr[5] = (byte) ((int) ((j231 >> 19) | (j234 << 2)));
        bArr[6] = (byte) ((int) (j234 >> 6));
        bArr[7] = (byte) ((int) ((j234 >> 14) | (j237 << 7)));
        bArr[8] = (byte) ((int) (j237 >> 1));
        bArr[9] = (byte) ((int) (j237 >> 9));
        bArr[10] = (byte) ((int) ((j237 >> 17) | (j240 << 4)));
        bArr[11] = (byte) ((int) (j240 >> 4));
        bArr[12] = (byte) ((int) (j240 >> 12));
        bArr[13] = (byte) ((int) ((j240 >> 20) | (j243 << 1)));
        bArr[14] = (byte) ((int) (j243 >> 7));
        bArr[15] = (byte) ((int) ((j243 >> 15) | (j246 << 6)));
        bArr[16] = (byte) ((int) (j246 >> 2));
        bArr[17] = (byte) ((int) (j246 >> 10));
        bArr[18] = (byte) ((int) ((j246 >> 18) | (j249 << 3)));
        bArr[19] = (byte) ((int) (j249 >> 5));
        bArr[20] = (byte) ((int) (j249 >> 13));
        bArr[21] = (byte) ((int) j252);
        bArr[22] = (byte) ((int) (j252 >> 8));
        bArr[23] = (byte) ((int) ((j252 >> 16) | (j255 << 5)));
        bArr[24] = (byte) ((int) (j255 >> 3));
        bArr[25] = (byte) ((int) (j255 >> 11));
        bArr[26] = (byte) ((int) ((j255 >> 19) | (j258 << 2)));
        bArr[27] = (byte) ((int) (j258 >> 6));
        bArr[28] = (byte) ((int) ((j258 >> 14) | (j257 << 7)));
        bArr[29] = (byte) ((int) (j257 >> 1));
        bArr[30] = (byte) ((int) (j257 >> 9));
        bArr[31] = (byte) ((int) (j257 >> 17));
    }

    /* access modifiers changed from: private */
    public static void neg(long[] jArr, long[] jArr2) {
        for (int i11 = 0; i11 < jArr2.length; i11++) {
            jArr[i11] = -jArr2[i11];
        }
    }

    /* access modifiers changed from: private */
    public static void pow2252m3(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        Field25519.square(jArr3, jArr2);
        Field25519.square(jArr4, jArr3);
        Field25519.square(jArr4, jArr4);
        Field25519.mult(jArr4, jArr2, jArr4);
        Field25519.mult(jArr3, jArr3, jArr4);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i11 = 1; i11 < 5; i11++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i12 = 1; i12 < 10; i12++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i13 = 1; i13 < 20; i13++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i14 = 1; i14 < 10; i14++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr4, jArr3);
        for (int i15 = 1; i15 < 50; i15++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr4, jArr4, jArr3);
        Field25519.square(jArr5, jArr4);
        for (int i16 = 1; i16 < 100; i16++) {
            Field25519.square(jArr5, jArr5);
        }
        Field25519.mult(jArr4, jArr5, jArr4);
        Field25519.square(jArr4, jArr4);
        for (int i17 = 1; i17 < 50; i17++) {
            Field25519.square(jArr4, jArr4);
        }
        Field25519.mult(jArr3, jArr4, jArr3);
        Field25519.square(jArr3, jArr3);
        Field25519.square(jArr3, jArr3);
        Field25519.mult(jArr, jArr3, jArr2);
    }

    private static void reduce(byte[] bArr) {
        byte[] bArr2 = bArr;
        long load3 = load3(bArr2, 0) & TarConstants.MAXID;
        long load4 = (load4(bArr2, 2) >> 5) & TarConstants.MAXID;
        long load32 = (load3(bArr2, 5) >> 2) & TarConstants.MAXID;
        long load42 = (load4(bArr2, 7) >> 7) & TarConstants.MAXID;
        long load43 = (load4(bArr2, 10) >> 4) & TarConstants.MAXID;
        long load33 = (load3(bArr2, 13) >> 1) & TarConstants.MAXID;
        long load44 = (load4(bArr2, 15) >> 6) & TarConstants.MAXID;
        long load34 = (load3(bArr2, 18) >> 3) & TarConstants.MAXID;
        long load35 = load3(bArr2, 21) & TarConstants.MAXID;
        long load45 = (load4(bArr2, 23) >> 5) & TarConstants.MAXID;
        long load36 = (load3(bArr2, 26) >> 2) & TarConstants.MAXID;
        long load46 = (load4(bArr2, 28) >> 7) & TarConstants.MAXID;
        long load47 = (load4(bArr2, 31) >> 4) & TarConstants.MAXID;
        long load37 = (load3(bArr2, 34) >> 1) & TarConstants.MAXID;
        long load48 = (load4(bArr2, 36) >> 6) & TarConstants.MAXID;
        long load38 = (load3(bArr2, 39) >> 3) & TarConstants.MAXID;
        long load39 = load3(bArr2, 42) & TarConstants.MAXID;
        long load49 = (load4(bArr2, 44) >> 5) & TarConstants.MAXID;
        long load310 = (load3(bArr2, 47) >> 2) & TarConstants.MAXID;
        long load410 = (load4(bArr2, 49) >> 7) & TarConstants.MAXID;
        long load411 = (load4(bArr2, 52) >> 4) & TarConstants.MAXID;
        long load311 = (load3(bArr2, 55) >> 1) & TarConstants.MAXID;
        long load412 = (load4(bArr2, 57) >> 6) & TarConstants.MAXID;
        long load413 = load4(bArr2, 60) >> 3;
        long j11 = load39 - (load413 * 683901);
        long j12 = ((load48 - (load413 * 997805)) + (load412 * 136657)) - (load311 * 683901);
        long j13 = ((((load47 + (load413 * 470296)) + (load412 * 654183)) - (load311 * 997805)) + (load411 * 136657)) - (load410 * 683901);
        long j14 = load44 + (load310 * 666643);
        long j15 = load34 + (load410 * 666643) + (load310 * 470296);
        long j16 = load35 + (load411 * 666643) + (load410 * 470296) + (load310 * 654183);
        long j17 = (((load45 + (load311 * 666643)) + (load411 * 470296)) + (load410 * 654183)) - (load310 * 997805);
        long j18 = ((((load36 + (load412 * 666643)) + (load311 * 470296)) + (load411 * 654183)) - (load410 * 997805)) + (load310 * 136657);
        long j19 = (((((load46 + (load413 * 666643)) + (load412 * 470296)) + (load311 * 654183)) - (load411 * 997805)) + (load410 * 136657)) - (load310 * 683901);
        long j21 = (j14 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j22 = j15 + j21;
        long j23 = j14 - (j21 << 21);
        long j24 = (j16 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j25 = j17 + j24;
        long j26 = j16 - (j24 << 21);
        long j27 = (j18 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j28 = j19 + j27;
        long j29 = j18 - (j27 << 21);
        long j31 = (j13 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j32 = ((((load37 + (load413 * 654183)) - (load412 * 997805)) + (load311 * 136657)) - (load411 * 683901)) + j31;
        long j33 = j13 - (j31 << 21);
        long j34 = (j12 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j35 = ((load38 + (load413 * 136657)) - (load412 * 683901)) + j34;
        long j36 = j12 - (j34 << 21);
        long j37 = (j11 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j38 = load49 + j37;
        long j39 = j11 - (j37 << 21);
        long j41 = (j22 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j42 = j26 + j41;
        long j43 = j22 - (j41 << 21);
        long j44 = (j25 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j45 = j29 + j44;
        long j46 = j25 - (j44 << 21);
        long j47 = (j28 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j48 = j33 + j47;
        long j49 = j28 - (j47 << 21);
        long j50 = (j32 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j51 = j36 + j50;
        long j52 = j32 - (j50 << 21);
        long j53 = (j35 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j54 = j39 + j53;
        long j55 = j35 - (j53 << 21);
        long j56 = j45 - (j38 * 683901);
        long j57 = ((j42 - (j38 * 997805)) + (j54 * 136657)) - (j55 * 683901);
        long j58 = ((((j23 + (j38 * 470296)) + (j54 * 654183)) - (j55 * 997805)) + (j51 * 136657)) - (j52 * 683901);
        long j59 = load3 + (j48 * 666643);
        long j60 = load4 + (j52 * 666643) + (j48 * 470296);
        long j61 = load32 + (j51 * 666643) + (j52 * 470296) + (j48 * 654183);
        long j62 = (((load42 + (j55 * 666643)) + (j51 * 470296)) + (j52 * 654183)) - (j48 * 997805);
        long j63 = ((((load43 + (j54 * 666643)) + (j55 * 470296)) + (j51 * 654183)) - (j52 * 997805)) + (j48 * 136657);
        long j64 = (((((load33 + (j38 * 666643)) + (j54 * 470296)) + (j55 * 654183)) - (j51 * 997805)) + (j52 * 136657)) - (j48 * 683901);
        long j65 = (j59 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j66 = j60 + j65;
        long j67 = j59 - (j65 << 21);
        long j68 = (j61 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j69 = j62 + j68;
        long j70 = j61 - (j68 << 21);
        long j71 = (j63 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j72 = j64 + j71;
        long j73 = j63 - (j71 << 21);
        long j74 = (j58 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j75 = ((((j43 + (j38 * 654183)) - (j54 * 997805)) + (j55 * 136657)) - (j51 * 683901)) + j74;
        long j76 = j58 - (j74 << 21);
        long j77 = (j57 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j78 = ((j46 + (j38 * 136657)) - (j54 * 683901)) + j77;
        long j79 = j57 - (j77 << 21);
        long j80 = (j56 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j81 = j49 + j80;
        long j82 = j56 - (j80 << 21);
        long j83 = (j66 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j84 = j70 + j83;
        long j85 = j66 - (j83 << 21);
        long j86 = (j69 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j87 = j73 + j86;
        long j88 = j69 - (j86 << 21);
        long j89 = (j72 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j90 = j76 + j89;
        long j91 = j72 - (j89 << 21);
        long j92 = (j75 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j93 = j79 + j92;
        long j94 = j75 - (j92 << 21);
        long j95 = (j78 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j96 = j82 + j95;
        long j97 = j78 - (j95 << 21);
        long j98 = (j81 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
        long j99 = j98 + 0;
        long j100 = j67 + (j99 * 666643);
        long j101 = j85 + (j99 * 470296);
        long j102 = j84 + (j99 * 654183);
        long j103 = j88 - (j99 * 997805);
        long j104 = j91 - (j99 * 683901);
        long j105 = j100 >> 21;
        long j106 = j101 + j105;
        long j107 = j100 - (j105 << 21);
        long j108 = j106 >> 21;
        long j109 = j102 + j108;
        long j110 = j106 - (j108 << 21);
        long j111 = j109 >> 21;
        long j112 = j103 + j111;
        long j113 = j109 - (j111 << 21);
        long j114 = j112 >> 21;
        long j115 = j87 + (j99 * 136657) + j114;
        long j116 = j112 - (j114 << 21);
        long j117 = j115 >> 21;
        long j118 = j104 + j117;
        long j119 = j115 - (j117 << 21);
        long j120 = j118 >> 21;
        long j121 = j90 + j120;
        long j122 = j118 - (j120 << 21);
        long j123 = j121 >> 21;
        long j124 = j94 + j123;
        long j125 = j121 - (j123 << 21);
        long j126 = j124 >> 21;
        long j127 = j93 + j126;
        long j128 = j124 - (j126 << 21);
        long j129 = j127 >> 21;
        long j130 = j97 + j129;
        long j131 = j127 - (j129 << 21);
        long j132 = j130 >> 21;
        long j133 = j96 + j132;
        long j134 = j130 - (j132 << 21);
        long j135 = j133 >> 21;
        long j136 = (j81 - (j98 << 21)) + j135;
        long j137 = j133 - (j135 << 21);
        long j138 = j136 >> 21;
        long j139 = j138 + 0;
        long j140 = j136 - (j138 << 21);
        long j141 = j107 + (666643 * j139);
        long j142 = j141 >> 21;
        long j143 = j110 + (470296 * j139) + j142;
        long j144 = j141 - (j142 << 21);
        long j145 = j143 >> 21;
        long j146 = j113 + (654183 * j139) + j145;
        long j147 = j143 - (j145 << 21);
        long j148 = j146 >> 21;
        long j149 = (j116 - (997805 * j139)) + j148;
        long j150 = j146 - (j148 << 21);
        long j151 = j149 >> 21;
        long j152 = j119 + (136657 * j139) + j151;
        long j153 = j149 - (j151 << 21);
        long j154 = j152 >> 21;
        long j155 = (j122 - (j139 * 683901)) + j154;
        long j156 = j152 - (j154 << 21);
        long j157 = j155 >> 21;
        long j158 = j125 + j157;
        long j159 = j155 - (j157 << 21);
        long j160 = j158 >> 21;
        long j161 = j128 + j160;
        long j162 = j158 - (j160 << 21);
        long j163 = j161 >> 21;
        long j164 = j131 + j163;
        long j165 = j161 - (j163 << 21);
        long j166 = j164 >> 21;
        long j167 = j134 + j166;
        long j168 = j153;
        long j169 = j164 - (j166 << 21);
        long j170 = j167 >> 21;
        long j171 = j137 + j170;
        long j172 = j167 - (j170 << 21);
        long j173 = j171 >> 21;
        long j174 = j140 + j173;
        long j175 = j171 - (j173 << 21);
        bArr2[0] = (byte) ((int) j144);
        bArr2[1] = (byte) ((int) (j144 >> 8));
        bArr2[2] = (byte) ((int) ((j144 >> 16) | (j147 << 5)));
        bArr2[3] = (byte) ((int) (j147 >> 3));
        bArr2[4] = (byte) ((int) (j147 >> 11));
        bArr2[5] = (byte) ((int) ((j147 >> 19) | (j150 << 2)));
        bArr2[6] = (byte) ((int) (j150 >> 6));
        bArr2[7] = (byte) ((int) ((j150 >> 14) | (j168 << 7)));
        bArr2[8] = (byte) ((int) (j168 >> 1));
        bArr2[9] = (byte) ((int) (j168 >> 9));
        bArr2[10] = (byte) ((int) ((j168 >> 17) | (j156 << 4)));
        bArr2[11] = (byte) ((int) (j156 >> 4));
        bArr2[12] = (byte) ((int) (j156 >> 12));
        bArr2[13] = (byte) ((int) ((j156 >> 20) | (j159 << 1)));
        bArr2[14] = (byte) ((int) (j159 >> 7));
        bArr2[15] = (byte) ((int) ((j159 >> 15) | (j162 << 6)));
        bArr2[16] = (byte) ((int) (j162 >> 2));
        bArr2[17] = (byte) ((int) (j162 >> 10));
        bArr2[18] = (byte) ((int) ((j162 >> 18) | (j165 << 3)));
        bArr2[19] = (byte) ((int) (j165 >> 5));
        bArr2[20] = (byte) ((int) (j165 >> 13));
        bArr2[21] = (byte) ((int) j169);
        bArr2[22] = (byte) ((int) (j169 >> 8));
        bArr2[23] = (byte) ((int) ((j169 >> 16) | (j172 << 5)));
        bArr2[24] = (byte) ((int) (j172 >> 3));
        bArr2[25] = (byte) ((int) (j172 >> 11));
        bArr2[26] = (byte) ((int) ((j172 >> 19) | (j175 << 2)));
        bArr2[27] = (byte) ((int) (j175 >> 6));
        bArr2[28] = (byte) ((int) ((j175 >> 14) | (j174 << 7)));
        bArr2[29] = (byte) ((int) (j174 >> 1));
        bArr2[30] = (byte) ((int) (j174 >> 9));
        bArr2[31] = (byte) ((int) (j174 >> 17));
    }

    private static XYZ scalarMultWithBase(byte[] bArr) {
        int i11;
        byte[] bArr2 = new byte[64];
        int i12 = 0;
        while (true) {
            if (i12 >= 32) {
                break;
            }
            int i13 = i12 * 2;
            bArr2[i13 + 0] = (byte) (((bArr[i12] & 255) >> 0) & 15);
            bArr2[i13 + 1] = (byte) (((bArr[i12] & 255) >> 4) & 15);
            i12++;
        }
        int i14 = 0;
        byte b11 = 0;
        while (i14 < 63) {
            byte b12 = (byte) (bArr2[i14] + b11);
            bArr2[i14] = b12;
            int i15 = (b12 + 8) >> 4;
            bArr2[i14] = (byte) (b12 - (i15 << 4));
            i14++;
            b11 = i15;
        }
        bArr2[63] = (byte) (bArr2[63] + b11);
        PartialXYZT partialXYZT = new PartialXYZT(NEUTRAL);
        XYZT xyzt = new XYZT();
        for (i11 = 1; i11 < 64; i11 += 2) {
            CachedXYT cachedXYT = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT, i11 / 2, bArr2[i11]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT);
        }
        XYZ xyz = new XYZ();
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        doubleXYZ(partialXYZT, XYZ.fromPartialXYZT(xyz, partialXYZT));
        for (int i16 = 0; i16 < 64; i16 += 2) {
            CachedXYT cachedXYT2 = new CachedXYT(CACHED_NEUTRAL);
            select(cachedXYT2, i16 / 2, bArr2[i16]);
            add(partialXYZT, XYZT.fromPartialXYZT(xyzt, partialXYZT), cachedXYT2);
        }
        XYZ xyz2 = new XYZ(partialXYZT);
        if (xyz2.isOnCurve()) {
            return xyz2;
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static byte[] scalarMultWithBaseToBytes(byte[] bArr) {
        return scalarMultWithBase(bArr).toBytes();
    }

    private static void select(CachedXYT cachedXYT, int i11, byte b11) {
        int i12 = (b11 & 255) >> 7;
        int i13 = b11 - (((-i12) & b11) << 1);
        CachedXYT[][] cachedXYTArr = Ed25519Constants.B_TABLE;
        cachedXYT.copyConditional(cachedXYTArr[i11][0], eq(i13, 1));
        cachedXYT.copyConditional(cachedXYTArr[i11][1], eq(i13, 2));
        cachedXYT.copyConditional(cachedXYTArr[i11][2], eq(i13, 3));
        cachedXYT.copyConditional(cachedXYTArr[i11][3], eq(i13, 4));
        cachedXYT.copyConditional(cachedXYTArr[i11][4], eq(i13, 5));
        cachedXYT.copyConditional(cachedXYTArr[i11][5], eq(i13, 6));
        cachedXYT.copyConditional(cachedXYTArr[i11][6], eq(i13, 7));
        cachedXYT.copyConditional(cachedXYTArr[i11][7], eq(i13, 8));
        long[] copyOf = Arrays.copyOf(cachedXYT.yMinusX, 10);
        long[] copyOf2 = Arrays.copyOf(cachedXYT.yPlusX, 10);
        long[] copyOf3 = Arrays.copyOf(cachedXYT.t2d, 10);
        neg(copyOf3, copyOf3);
        cachedXYT.copyConditional(new CachedXYT(copyOf, copyOf2, copyOf3), i12);
    }

    public static byte[] sign(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length);
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        instance.update(bArr3, 32, 32);
        instance.update(copyOfRange);
        byte[] digest = instance.digest();
        reduce(digest);
        byte[] copyOfRange2 = Arrays.copyOfRange(scalarMultWithBase(digest).toBytes(), 0, 32);
        instance.reset();
        instance.update(copyOfRange2);
        instance.update(bArr2);
        instance.update(copyOfRange);
        byte[] digest2 = instance.digest();
        reduce(digest2);
        byte[] bArr4 = new byte[32];
        mulAdd(bArr4, digest2, bArr3, digest);
        return Bytes.concat(copyOfRange2, bArr4);
    }

    private static byte[] slide(byte[] bArr) {
        int i11;
        byte[] bArr2 = new byte[256];
        for (int i12 = 0; i12 < 256; i12++) {
            bArr2[i12] = (byte) (1 & ((bArr[i12 >> 3] & 255) >> (i12 & 7)));
        }
        int i13 = 0;
        while (i13 < 256) {
            if (bArr2[i13] != 0) {
                int i14 = 1;
                while (i14 <= 6 && (i11 = i13 + i14) < 256) {
                    byte b11 = bArr2[i11];
                    if (b11 != 0) {
                        byte b12 = bArr2[i13];
                        if ((b11 << i14) + b12 > 15) {
                            if (b12 - (b11 << i14) < -15) {
                                break;
                            }
                            bArr2[i13] = (byte) (b12 - (b11 << i14));
                            while (true) {
                                if (i11 >= 256) {
                                    break;
                                } else if (bArr2[i11] == 0) {
                                    bArr2[i11] = 1;
                                    break;
                                } else {
                                    bArr2[i11] = 0;
                                    i11++;
                                }
                            }
                        } else {
                            bArr2[i13] = (byte) (b12 + (b11 << i14));
                            bArr2[i11] = 0;
                        }
                    }
                    i14++;
                }
            }
            i13++;
        }
        return bArr2;
    }

    private static void sub(PartialXYZT partialXYZT, XYZT xyzt, CachedXYT cachedXYT) {
        long[] jArr = new long[10];
        long[] jArr2 = partialXYZT.xyz.f47310x;
        XYZ xyz = xyzt.xyz;
        Field25519.sum(jArr2, xyz.f47311y, xyz.f47310x);
        long[] jArr3 = partialXYZT.xyz.f47311y;
        XYZ xyz2 = xyzt.xyz;
        Field25519.sub(jArr3, xyz2.f47311y, xyz2.f47310x);
        long[] jArr4 = partialXYZT.xyz.f47311y;
        Field25519.mult(jArr4, jArr4, cachedXYT.yPlusX);
        XYZ xyz3 = partialXYZT.xyz;
        Field25519.mult(xyz3.f47312z, xyz3.f47310x, cachedXYT.yMinusX);
        Field25519.mult(partialXYZT.f47309t, xyzt.f47313t, cachedXYT.t2d);
        cachedXYT.multByZ(partialXYZT.xyz.f47310x, xyzt.xyz.f47312z);
        long[] jArr5 = partialXYZT.xyz.f47310x;
        Field25519.sum(jArr, jArr5, jArr5);
        XYZ xyz4 = partialXYZT.xyz;
        Field25519.sub(xyz4.f47310x, xyz4.f47312z, xyz4.f47311y);
        XYZ xyz5 = partialXYZT.xyz;
        long[] jArr6 = xyz5.f47311y;
        Field25519.sum(jArr6, xyz5.f47312z, jArr6);
        Field25519.sub(partialXYZT.xyz.f47312z, jArr, partialXYZT.f47309t);
        long[] jArr7 = partialXYZT.f47309t;
        Field25519.sum(jArr7, jArr, jArr7);
    }

    public static boolean verify(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (bArr2.length != 64) {
            return false;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr2, 32, 64);
        if (!isSmallerThanGroupOrder(copyOfRange)) {
            return false;
        }
        MessageDigest instance = EngineFactory.MESSAGE_DIGEST.getInstance("SHA-512");
        instance.update(bArr2, 0, 32);
        instance.update(bArr3);
        instance.update(bArr);
        byte[] digest = instance.digest();
        reduce(digest);
        byte[] bytes = doubleScalarMultVarTime(digest, XYZT.fromBytesNegateVarTime(bArr3), copyOfRange).toBytes();
        for (int i11 = 0; i11 < 32; i11++) {
            if (bytes[i11] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }
}
