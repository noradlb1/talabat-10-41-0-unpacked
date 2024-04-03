package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class TsUtil {
    private TsUtil() {
    }

    public static int findSyncBytePosition(byte[] bArr, int i11, int i12) {
        while (i11 < i12 && bArr[i11] != 71) {
            i11++;
        }
        return i11;
    }

    public static boolean isStartOfTsPacket(byte[] bArr, int i11, int i12, int i13) {
        int i14 = 0;
        for (int i15 = -4; i15 <= 4; i15++) {
            int i16 = (i15 * 188) + i13;
            if (i16 < i11 || i16 >= i12 || bArr[i16] != 71) {
                i14 = 0;
            } else {
                i14++;
                if (i14 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long readPcrFromPacket(ParsableByteArray parsableByteArray, int i11, int i12) {
        boolean z11;
        parsableByteArray.setPosition(i11);
        if (parsableByteArray.bytesLeft() < 5) {
            return C.TIME_UNSET;
        }
        int readInt = parsableByteArray.readInt();
        if ((8388608 & readInt) != 0 || ((2096896 & readInt) >> 8) != i12) {
            return C.TIME_UNSET;
        }
        boolean z12 = true;
        if ((readInt & 32) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 && parsableByteArray.readUnsignedByte() >= 7 && parsableByteArray.bytesLeft() >= 7) {
            if ((parsableByteArray.readUnsignedByte() & 16) != 16) {
                z12 = false;
            }
            if (z12) {
                byte[] bArr = new byte[6];
                parsableByteArray.readBytes(bArr, 0, 6);
                return readPcrValueFromPcrBytes(bArr);
            }
        }
        return C.TIME_UNSET;
    }

    private static long readPcrValueFromPcrBytes(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
