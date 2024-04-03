package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil {
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final int EXTENDED_SAR = 255;
    private static final int H264_NAL_UNIT_TYPE_SEI = 6;
    private static final int H264_NAL_UNIT_TYPE_SPS = 7;
    private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    public static final int NAL_UNIT_TYPE_AUD = 9;
    public static final int NAL_UNIT_TYPE_IDR = 5;
    public static final int NAL_UNIT_TYPE_NON_IDR = 1;
    public static final int NAL_UNIT_TYPE_PARTITION_A = 2;
    public static final int NAL_UNIT_TYPE_PPS = 8;
    public static final int NAL_UNIT_TYPE_SEI = 6;
    public static final int NAL_UNIT_TYPE_SPS = 7;
    private static final String TAG = "NalUnitUtil";
    private static int[] scratchEscapePositions = new int[10];
    private static final Object scratchEscapePositionsLock = new Object();

    public static final class H265SpsData {
        public final int colorRange;
        public final int colorSpace;
        public final int colorTransfer;
        public final int[] constraintBytes;
        public final int generalLevelIdc;
        public final int generalProfileCompatibilityFlags;
        public final int generalProfileIdc;
        public final int generalProfileSpace;
        public final boolean generalTierFlag;
        public final int height;
        public final float pixelWidthHeightRatio;
        public final int seqParameterSetId;
        public final int width;

        public H265SpsData(int i11, boolean z11, int i12, int i13, int[] iArr, int i14, int i15, int i16, int i17, float f11, int i18, int i19, int i21) {
            this.generalProfileSpace = i11;
            this.generalTierFlag = z11;
            this.generalProfileIdc = i12;
            this.generalProfileCompatibilityFlags = i13;
            this.constraintBytes = iArr;
            this.generalLevelIdc = i14;
            this.seqParameterSetId = i15;
            this.width = i16;
            this.height = i17;
            this.pixelWidthHeightRatio = f11;
            this.colorSpace = i18;
            this.colorRange = i19;
            this.colorTransfer = i21;
        }
    }

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i11, int i12, boolean z11) {
            this.picParameterSetId = i11;
            this.seqParameterSetId = i12;
            this.bottomFieldPicOrderInFramePresentFlag = z11;
        }
    }

    public static final class SpsData {
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int maxNumRefFrames;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthHeightRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f11, boolean z11, boolean z12, int i18, int i19, int i21, boolean z13) {
            this.profileIdc = i11;
            this.constraintsFlagsAndReservedZero2Bits = i12;
            this.levelIdc = i13;
            this.seqParameterSetId = i14;
            this.maxNumRefFrames = i15;
            this.width = i16;
            this.height = i17;
            this.pixelWidthHeightRatio = f11;
            this.separateColorPlaneFlag = z11;
            this.frameMbsOnlyFlag = z12;
            this.frameNumLength = i18;
            this.picOrderCountType = i19;
            this.picOrderCntLsbLength = i21;
            this.deltaPicOrderAlwaysZeroFlag = z13;
        }
    }

    private NalUnitUtil() {
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 1;
            if (i13 < position) {
                byte b11 = byteBuffer.get(i11) & 255;
                if (i12 == 3) {
                    if (b11 == 1 && (byteBuffer.get(i13) & Ascii.US) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i11 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b11 == 0) {
                    i12++;
                }
                if (b11 != 0) {
                    i12 = 0;
                }
                i11 = i13;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static int findNalUnit(byte[] bArr, int i11, int i12, boolean[] zArr) {
        boolean z11;
        boolean z12;
        boolean z13;
        int i13 = i12 - i11;
        boolean z14 = false;
        if (i13 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        if (i13 == 0) {
            return i12;
        }
        if (zArr[0]) {
            clearPrefixFlags(zArr);
            return i11 - 3;
        } else if (i13 > 1 && zArr[1] && bArr[i11] == 1) {
            clearPrefixFlags(zArr);
            return i11 - 2;
        } else if (i13 <= 2 || !zArr[2] || bArr[i11] != 0 || bArr[i11 + 1] != 1) {
            int i14 = i12 - 1;
            int i15 = i11 + 2;
            while (i15 < i14) {
                byte b11 = bArr[i15];
                if ((b11 & 254) == 0) {
                    int i16 = i15 - 2;
                    if (bArr[i16] == 0 && bArr[i15 - 1] == 0 && b11 == 1) {
                        clearPrefixFlags(zArr);
                        return i16;
                    }
                    i15 -= 2;
                }
                i15 += 3;
            }
            if (i13 <= 2 ? i13 != 2 ? !zArr[1] || bArr[i14] != 1 : !(zArr[2] && bArr[i12 - 2] == 0 && bArr[i14] == 1) : !(bArr[i12 - 3] == 0 && bArr[i12 - 2] == 0 && bArr[i14] == 1)) {
                z12 = false;
            } else {
                z12 = true;
            }
            zArr[0] = z12;
            if (i13 <= 1 ? !zArr[2] || bArr[i14] != 0 : !(bArr[i12 - 2] == 0 && bArr[i14] == 0)) {
                z13 = false;
            } else {
                z13 = true;
            }
            zArr[1] = z13;
            if (bArr[i14] == 0) {
                z14 = true;
            }
            zArr[2] = z14;
            return i12;
        } else {
            clearPrefixFlags(zArr);
            return i11 - 1;
        }
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i11, int i12) {
        while (i11 < i12 - 2) {
            if (bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 3) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static int getH265NalUnitType(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 126) >> 1;
    }

    public static int getNalUnitType(byte[] bArr, int i11) {
        return bArr[i11 + 3] & Ascii.US;
    }

    public static boolean isNalUnitSei(@Nullable String str, byte b11) {
        if (MimeTypes.VIDEO_H264.equals(str) && (b11 & Ascii.US) == 6) {
            return true;
        }
        if (!MimeTypes.VIDEO_H265.equals(str) || ((b11 & 126) >> 1) != 39) {
            return false;
        }
        return true;
    }

    public static H265SpsData parseH265SpsNalUnit(byte[] bArr, int i11, int i12) {
        return parseH265SpsNalUnitPayload(bArr, i11 + 2, i12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.util.NalUnitUtil.H265SpsData parseH265SpsNalUnitPayload(byte[] r23, int r24, int r25) {
        /*
            com.google.android.exoplayer2.util.ParsableNalUnitBitArray r0 = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray
            r1 = r23
            r2 = r24
            r3 = r25
            r0.<init>(r1, r2, r3)
            r1 = 4
            r0.skipBits(r1)
            r2 = 3
            int r3 = r0.readBits(r2)
            r0.skipBit()
            r4 = 2
            int r6 = r0.readBits(r4)
            boolean r7 = r0.readBit()
            r5 = 5
            int r8 = r0.readBits(r5)
            r9 = 0
            r10 = 0
        L_0x0027:
            r11 = 32
            r12 = 1
            if (r10 >= r11) goto L_0x0038
            boolean r11 = r0.readBit()
            if (r11 == 0) goto L_0x0035
            int r11 = r12 << r10
            r9 = r9 | r11
        L_0x0035:
            int r10 = r10 + 1
            goto L_0x0027
        L_0x0038:
            r10 = 6
            int[] r11 = new int[r10]
            r13 = 0
        L_0x003c:
            r14 = 8
            if (r13 >= r10) goto L_0x0049
            int r14 = r0.readBits(r14)
            r11[r13] = r14
            int r13 = r13 + 1
            goto L_0x003c
        L_0x0049:
            int r13 = r0.readBits(r14)
            r10 = 0
            r15 = 0
        L_0x004f:
            if (r10 >= r3) goto L_0x0064
            boolean r16 = r0.readBit()
            if (r16 == 0) goto L_0x0059
            int r15 = r15 + 89
        L_0x0059:
            boolean r16 = r0.readBit()
            if (r16 == 0) goto L_0x0061
            int r15 = r15 + 8
        L_0x0061:
            int r10 = r10 + 1
            goto L_0x004f
        L_0x0064:
            r0.skipBits(r15)
            if (r3 <= 0) goto L_0x006f
            int r10 = 8 - r3
            int r10 = r10 * r4
            r0.skipBits(r10)
        L_0x006f:
            int r15 = r0.readUnsignedExpGolombCodedInt()
            int r10 = r0.readUnsignedExpGolombCodedInt()
            if (r10 != r2) goto L_0x007c
            r0.skipBit()
        L_0x007c:
            int r16 = r0.readUnsignedExpGolombCodedInt()
            int r17 = r0.readUnsignedExpGolombCodedInt()
            boolean r18 = r0.readBit()
            if (r18 == 0) goto L_0x00b5
            int r18 = r0.readUnsignedExpGolombCodedInt()
            int r19 = r0.readUnsignedExpGolombCodedInt()
            int r20 = r0.readUnsignedExpGolombCodedInt()
            int r21 = r0.readUnsignedExpGolombCodedInt()
            if (r10 == r12) goto L_0x00a2
            if (r10 != r4) goto L_0x009f
            goto L_0x00a2
        L_0x009f:
            r22 = r12
            goto L_0x00a4
        L_0x00a2:
            r22 = r4
        L_0x00a4:
            if (r10 != r12) goto L_0x00a8
            r10 = r4
            goto L_0x00a9
        L_0x00a8:
            r10 = r12
        L_0x00a9:
            int r18 = r18 + r19
            int r22 = r22 * r18
            int r16 = r16 - r22
            int r20 = r20 + r21
            int r10 = r10 * r20
            int r17 = r17 - r10
        L_0x00b5:
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            int r10 = r0.readUnsignedExpGolombCodedInt()
            boolean r18 = r0.readBit()
            if (r18 == 0) goto L_0x00c8
            r18 = 0
            goto L_0x00ca
        L_0x00c8:
            r18 = r3
        L_0x00ca:
            r5 = r18
        L_0x00cc:
            if (r5 > r3) goto L_0x00da
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            int r5 = r5 + 1
            goto L_0x00cc
        L_0x00da:
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x00fb
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x00fb
            skipH265ScalingList(r0)
        L_0x00fb:
            r0.skipBits(r4)
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x0110
            r0.skipBits(r14)
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
        L_0x0110:
            skipShortTermReferencePictureSets(r0)
            boolean r3 = r0.readBit()
            if (r3 == 0) goto L_0x0129
            r5 = 0
        L_0x011a:
            int r3 = r0.readUnsignedExpGolombCodedInt()
            if (r5 >= r3) goto L_0x0129
            int r3 = r10 + 4
            int r3 = r3 + r12
            r0.skipBits(r3)
            int r5 = r5 + 1
            goto L_0x011a
        L_0x0129:
            r0.skipBits(r4)
            boolean r1 = r0.readBit()
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x01c9
            boolean r1 = r0.readBit()
            if (r1 == 0) goto L_0x0172
            int r1 = r0.readBits(r14)
            r10 = 255(0xff, float:3.57E-43)
            if (r1 != r10) goto L_0x0154
            r1 = 16
            int r10 = r0.readBits(r1)
            int r1 = r0.readBits(r1)
            if (r10 == 0) goto L_0x0172
            if (r1 == 0) goto L_0x0172
            float r5 = (float) r10
            float r1 = (float) r1
            float r5 = r5 / r1
            goto L_0x0172
        L_0x0154:
            float[] r10 = ASPECT_RATIO_IDC_VALUES
            int r3 = r10.length
            if (r1 >= r3) goto L_0x015c
            r5 = r10[r1]
            goto L_0x0172
        L_0x015c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r10 = "Unexpected aspect_ratio_idc value: "
            r3.append(r10)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r3 = "NalUnitUtil"
            com.google.android.exoplayer2.util.Log.w(r3, r1)
        L_0x0172:
            boolean r1 = r0.readBit()
            if (r1 == 0) goto L_0x017b
            r0.skipBit()
        L_0x017b:
            boolean r1 = r0.readBit()
            if (r1 == 0) goto L_0x01a7
            r0.skipBits(r2)
            boolean r1 = r0.readBit()
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x01a7
            int r2 = r0.readBits(r14)
            int r3 = r0.readBits(r14)
            r0.skipBits(r14)
            int r2 = com.google.android.exoplayer2.video.ColorInfo.isoColorPrimariesToColorSpace(r2)
            if (r1 == 0) goto L_0x01a0
            r4 = r12
        L_0x01a0:
            int r3 = com.google.android.exoplayer2.video.ColorInfo.isoTransferCharacteristicsToColorTransfer(r3)
            r1 = r3
            r3 = r2
            goto L_0x01aa
        L_0x01a7:
            r1 = -1
            r3 = -1
            r4 = -1
        L_0x01aa:
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x01b6
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
        L_0x01b6:
            r0.skipBit()
            boolean r0 = r0.readBit()
            if (r0 == 0) goto L_0x01c1
            int r17 = r17 * 2
        L_0x01c1:
            r18 = r1
            r0 = r5
            r14 = r17
            r17 = r4
            goto L_0x01d1
        L_0x01c9:
            r0 = r5
            r14 = r17
            r3 = -1
            r17 = -1
            r18 = -1
        L_0x01d1:
            com.google.android.exoplayer2.util.NalUnitUtil$H265SpsData r1 = new com.google.android.exoplayer2.util.NalUnitUtil$H265SpsData
            r5 = r1
            r10 = r11
            r11 = r13
            r12 = r15
            r13 = r16
            r15 = r0
            r16 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.parseH265SpsNalUnitPayload(byte[], int, int):com.google.android.exoplayer2.util.NalUnitUtil$H265SpsData");
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i11, int i12) {
        return parsePpsNalUnitPayload(bArr, i11 + 1, i12);
    }

    public static PpsData parsePpsNalUnitPayload(byte[] bArr, int i11, int i12) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i11, i12);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    public static SpsData parseSpsNalUnit(byte[] bArr, int i11, int i12) {
        return parseSpsNalUnitPayload(bArr, i11 + 1, i12);
    }

    public static SpsData parseSpsNalUnitPayload(byte[] bArr, int i11, int i12) {
        boolean z11;
        int i13;
        boolean z12;
        int i14;
        int i15;
        boolean z13;
        float f11;
        int i16;
        int i17;
        int i18;
        int i19;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i11, i12);
        int readBits = parsableNalUnitBitArray.readBits(8);
        int readBits2 = parsableNalUnitBitArray.readBits(8);
        int readBits3 = parsableNalUnitBitArray.readBits(8);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int i21 = 1;
        if (readBits == 100 || readBits == 110 || readBits == 122 || readBits == 244 || readBits == 44 || readBits == 83 || readBits == 86 || readBits == 118 || readBits == 128 || readBits == 138) {
            i13 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (i13 == 3) {
                z11 = parsableNalUnitBitArray.readBit();
            } else {
                z11 = false;
            }
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                if (i13 != 3) {
                    i18 = 8;
                } else {
                    i18 = 12;
                }
                for (int i22 = 0; i22 < i18; i22++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        if (i22 < 6) {
                            i19 = 16;
                        } else {
                            i19 = 64;
                        }
                        skipScalingList(parsableNalUnitBitArray, i19);
                    }
                }
            }
        } else {
            i13 = 1;
            z11 = false;
        }
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt3 == 0) {
            i14 = i13;
            z12 = z11;
            i15 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 4;
            z13 = false;
        } else {
            if (readUnsignedExpGolombCodedInt3 == 1) {
                boolean readBit = parsableNalUnitBitArray.readBit();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                z12 = z11;
                long readUnsignedExpGolombCodedInt4 = (long) parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                i14 = i13;
                for (int i23 = 0; ((long) i23) < readUnsignedExpGolombCodedInt4; i23++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                }
                z13 = readBit;
            } else {
                i14 = i13;
                z12 = z11;
                z13 = false;
            }
            i15 = 0;
        }
        int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
        boolean readBit2 = parsableNalUnitBitArray.readBit();
        int readUnsignedExpGolombCodedInt7 = (true - (readBit2 ? 1 : 0)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
        if (!readBit2) {
            parsableNalUnitBitArray.skipBit();
        }
        parsableNalUnitBitArray.skipBit();
        int i24 = readUnsignedExpGolombCodedInt6 * 16;
        int i25 = readUnsignedExpGolombCodedInt7 * 16;
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt9 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt10 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt11 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            if (i14 == 0) {
                i16 = true - readBit2;
            } else {
                int i26 = i14;
                if (i26 == 3) {
                    i17 = 1;
                } else {
                    i17 = 2;
                }
                if (i26 == 1) {
                    i21 = 2;
                }
                int i27 = (true - readBit2) * i21;
                i21 = i17;
                i16 = i27;
            }
            i24 -= (readUnsignedExpGolombCodedInt8 + readUnsignedExpGolombCodedInt9) * i21;
            i25 -= (readUnsignedExpGolombCodedInt10 + readUnsignedExpGolombCodedInt11) * i16;
        }
        int i28 = i24;
        int i29 = i25;
        float f12 = 1.0f;
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            int readBits4 = parsableNalUnitBitArray.readBits(8);
            if (readBits4 == 255) {
                int readBits5 = parsableNalUnitBitArray.readBits(16);
                int readBits6 = parsableNalUnitBitArray.readBits(16);
                if (!(readBits5 == 0 || readBits6 == 0)) {
                    f12 = ((float) readBits5) / ((float) readBits6);
                }
            } else {
                float[] fArr = ASPECT_RATIO_IDC_VALUES;
                if (readBits4 < fArr.length) {
                    f11 = fArr[readBits4];
                    return new SpsData(readBits, readBits2, readBits3, readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt5, i28, i29, f11, z12, readBit2, readUnsignedExpGolombCodedInt2, readUnsignedExpGolombCodedInt3, i15, z13);
                }
                Log.w(TAG, "Unexpected aspect_ratio_idc value: " + readBits4);
            }
        }
        f11 = f12;
        return new SpsData(readBits, readBits2, readBits3, readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt5, i28, i29, f11, z12, readBit2, readUnsignedExpGolombCodedInt2, readUnsignedExpGolombCodedInt3, i15, z13);
    }

    private static void skipH265ScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = 0;
            while (i12 < 6) {
                int i13 = 1;
                if (!parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                } else {
                    int min = Math.min(64, 1 << ((i11 << 1) + 4));
                    if (i11 > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i14 = 0; i14 < min; i14++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                }
                if (i11 == 3) {
                    i13 = 3;
                }
                i12 += i13;
            }
        }
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i11) {
        int i12 = 8;
        int i13 = 8;
        for (int i14 = 0; i14 < i11; i14++) {
            if (i12 != 0) {
                i12 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i13) + 256) % 256;
            }
            if (i12 != 0) {
                i13 = i12;
            }
        }
    }

    private static void skipShortTermReferencePictureSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        boolean z11;
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < readUnsignedExpGolombCodedInt; i13++) {
            if (i13 == 0 || !parsableNalUnitBitArray.readBit()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                int i14 = i11 + i12;
                int readUnsignedExpGolombCodedInt2 = (1 - ((parsableNalUnitBitArray.readBit() ? 1 : 0) * true)) * (parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1);
                int i15 = i14 + 1;
                boolean[] zArr = new boolean[i15];
                for (int i16 = 0; i16 <= i14; i16++) {
                    if (!parsableNalUnitBitArray.readBit()) {
                        zArr[i16] = parsableNalUnitBitArray.readBit();
                    } else {
                        zArr[i16] = true;
                    }
                }
                int[] iArr3 = new int[i15];
                int[] iArr4 = new int[i15];
                int i17 = 0;
                for (int i18 = i12 - 1; i18 >= 0; i18--) {
                    int i19 = iArr2[i18] + readUnsignedExpGolombCodedInt2;
                    if (i19 < 0 && zArr[i11 + i18]) {
                        iArr3[i17] = i19;
                        i17++;
                    }
                }
                if (readUnsignedExpGolombCodedInt2 < 0 && zArr[i14]) {
                    iArr3[i17] = readUnsignedExpGolombCodedInt2;
                    i17++;
                }
                for (int i21 = 0; i21 < i11; i21++) {
                    int i22 = iArr[i21] + readUnsignedExpGolombCodedInt2;
                    if (i22 < 0 && zArr[i21]) {
                        iArr3[i17] = i22;
                        i17++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr3, i17);
                int i23 = 0;
                for (int i24 = i11 - 1; i24 >= 0; i24--) {
                    int i25 = iArr[i24] + readUnsignedExpGolombCodedInt2;
                    if (i25 > 0 && zArr[i24]) {
                        iArr4[i23] = i25;
                        i23++;
                    }
                }
                if (readUnsignedExpGolombCodedInt2 > 0 && zArr[i14]) {
                    iArr4[i23] = readUnsignedExpGolombCodedInt2;
                    i23++;
                }
                for (int i26 = 0; i26 < i12; i26++) {
                    int i27 = iArr2[i26] + readUnsignedExpGolombCodedInt2;
                    if (i27 > 0 && zArr[i11 + i26]) {
                        iArr4[i23] = i27;
                        i23++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr4, i23);
                iArr = copyOf;
                i11 = i17;
                i12 = i23;
            } else {
                int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int[] iArr5 = new int[readUnsignedExpGolombCodedInt3];
                for (int i28 = 0; i28 < readUnsignedExpGolombCodedInt3; i28++) {
                    iArr5[i28] = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                    parsableNalUnitBitArray.skipBit();
                }
                int[] iArr6 = new int[readUnsignedExpGolombCodedInt4];
                for (int i29 = 0; i29 < readUnsignedExpGolombCodedInt4; i29++) {
                    iArr6[i29] = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt() + 1;
                    parsableNalUnitBitArray.skipBit();
                }
                int[] iArr7 = iArr5;
                i11 = readUnsignedExpGolombCodedInt3;
                iArr = iArr7;
                int[] iArr8 = iArr6;
                i12 = readUnsignedExpGolombCodedInt4;
                iArr2 = iArr8;
            }
        }
    }

    public static int unescapeStream(byte[] bArr, int i11) {
        int i12;
        synchronized (scratchEscapePositionsLock) {
            int i13 = 0;
            int i14 = 0;
            while (i13 < i11) {
                try {
                    i13 = findNextUnescapeIndex(bArr, i13, i11);
                    if (i13 < i11) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i14) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i14] = i13;
                        i13 += 3;
                        i14++;
                    }
                } finally {
                }
            }
            i12 = i11 - i14;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < i14; i17++) {
                int i18 = scratchEscapePositions[i17] - i16;
                System.arraycopy(bArr, i16, bArr, i15, i18);
                int i19 = i15 + i18;
                int i21 = i19 + 1;
                bArr[i19] = 0;
                i15 = i21 + 1;
                bArr[i21] = 0;
                i16 += i18 + 3;
            }
            System.arraycopy(bArr, i16, bArr, i15, i12 - i15);
        }
        return i12;
    }
}
