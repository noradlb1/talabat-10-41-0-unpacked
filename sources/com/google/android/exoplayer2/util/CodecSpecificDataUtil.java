package com.google.android.exoplayer2.util;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CodecSpecificDataUtil {
    private static final int EXTENDED_PAR = 15;
    private static final String[] HEVC_GENERAL_PROFILE_SPACE_STRINGS = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};
    private static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final int RECTANGULAR = 0;
    private static final int VISUAL_OBJECT_LAYER = 1;
    private static final int VISUAL_OBJECT_LAYER_START = 32;

    private CodecSpecificDataUtil() {
    }

    public static String buildAvcCodecString(int i11, int i12, int i13) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
    }

    public static List<byte[]> buildCea708InitializationData(boolean z11) {
        return Collections.singletonList(z11 ? new byte[]{1} : new byte[]{0});
    }

    public static String buildHevcCodecString(int i11, boolean z11, int i12, int i13, int[] iArr, int i14) {
        char c11;
        Object[] objArr = new Object[5];
        objArr[0] = HEVC_GENERAL_PROFILE_SPACE_STRINGS[i11];
        objArr[1] = Integer.valueOf(i12);
        objArr[2] = Integer.valueOf(i13);
        if (z11) {
            c11 = 'H';
        } else {
            c11 = 'L';
        }
        objArr[3] = Character.valueOf(c11);
        objArr[4] = Integer.valueOf(i14);
        StringBuilder sb2 = new StringBuilder(Util.formatInvariant("hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i15 = 0; i15 < length; i15++) {
            sb2.append(String.format(".%02X", new Object[]{Integer.valueOf(iArr[i15])}));
        }
        return sb2.toString();
    }

    public static byte[] buildNalUnit(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = NAL_START_CODE;
        byte[] bArr3 = new byte[(bArr2.length + i12)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i11, bArr3, bArr2.length, i12);
        return bArr3;
    }

    private static int findNalStartCode(byte[] bArr, int i11) {
        int length = bArr.length - NAL_START_CODE.length;
        while (i11 <= length) {
            if (isNalStartCode(bArr, i11)) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static Pair<Integer, Integer> getVideoResolutionFromMpeg4VideoConfig(byte[] bArr) {
        boolean z11;
        boolean z12;
        boolean z13;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i12 + 3;
            if (i13 < bArr.length) {
                if (parsableByteArray.readUnsignedInt24() == 1 && (bArr[i13] & 240) == 32) {
                    z11 = true;
                    break;
                }
                parsableByteArray.setPosition(parsableByteArray.getPosition() - 2);
                i12++;
            } else {
                z11 = false;
                break;
            }
        }
        Assertions.checkArgument(z11, "Invalid input: VOL not found.");
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.skipBits((i12 + 4) * 8);
        parsableBitArray.skipBits(1);
        parsableBitArray.skipBits(8);
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(4);
            parsableBitArray.skipBits(3);
        }
        if (parsableBitArray.readBits(4) == 15) {
            parsableBitArray.skipBits(8);
            parsableBitArray.skipBits(8);
        }
        if (parsableBitArray.readBit()) {
            parsableBitArray.skipBits(2);
            parsableBitArray.skipBits(1);
            if (parsableBitArray.readBit()) {
                parsableBitArray.skipBits(79);
            }
        }
        if (parsableBitArray.readBits(2) == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Assertions.checkArgument(z12, "Only supports rectangular video object layer shape.");
        Assertions.checkArgument(parsableBitArray.readBit());
        int readBits = parsableBitArray.readBits(16);
        Assertions.checkArgument(parsableBitArray.readBit());
        if (parsableBitArray.readBit()) {
            if (readBits > 0) {
                z13 = true;
            } else {
                z13 = false;
            }
            Assertions.checkArgument(z13);
            for (int i14 = readBits - 1; i14 > 0; i14 >>= 1) {
                i11++;
            }
            parsableBitArray.skipBits(i11);
        }
        Assertions.checkArgument(parsableBitArray.readBit());
        int readBits2 = parsableBitArray.readBits(13);
        Assertions.checkArgument(parsableBitArray.readBit());
        int readBits3 = parsableBitArray.readBits(13);
        Assertions.checkArgument(parsableBitArray.readBit());
        parsableBitArray.skipBits(1);
        return Pair.create(Integer.valueOf(readBits2), Integer.valueOf(readBits3));
    }

    private static boolean isNalStartCode(byte[] bArr, int i11) {
        if (bArr.length - i11 <= NAL_START_CODE.length) {
            return false;
        }
        int i12 = 0;
        while (true) {
            byte[] bArr2 = NAL_START_CODE;
            if (i12 >= bArr2.length) {
                return true;
            }
            if (bArr[i11 + i12] != bArr2[i12]) {
                return false;
            }
            i12++;
        }
    }

    public static Pair<Integer, Integer> parseAlacAudioSpecificConfig(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.setPosition(9);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.setPosition(20);
        return Pair.create(Integer.valueOf(parsableByteArray.readUnsignedIntToInt()), Integer.valueOf(readUnsignedByte));
    }

    public static boolean parseCea708InitializationData(List<byte[]> list) {
        if (list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1) {
            return true;
        }
        return false;
    }

    @Nullable
    public static byte[][] splitNalUnits(byte[] bArr) {
        int i11;
        if (!isNalStartCode(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        do {
            arrayList.add(Integer.valueOf(i12));
            i12 = findNalStartCode(bArr, i12 + NAL_START_CODE.length);
        } while (i12 != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            int intValue = ((Integer) arrayList.get(i13)).intValue();
            if (i13 < arrayList.size() - 1) {
                i11 = ((Integer) arrayList.get(i13 + 1)).intValue();
            } else {
                i11 = bArr.length;
            }
            int i14 = i11 - intValue;
            byte[] bArr3 = new byte[i14];
            System.arraycopy(bArr, intValue, bArr3, 0, i14);
            bArr2[i13] = bArr3;
        }
        return bArr2;
    }
}
