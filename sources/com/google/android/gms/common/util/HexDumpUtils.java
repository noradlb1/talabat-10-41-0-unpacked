package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@KeepForSdk
public final class HexDumpUtils {
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    @Nullable
    public static String dump(@NonNull byte[] bArr, int i11, int i12, boolean z11) {
        int length;
        int i13;
        if (bArr == null || (length = bArr.length) == 0 || i11 < 0 || i12 <= 0 || i11 + i12 > length) {
            return null;
        }
        if (z11) {
            i13 = 75;
        } else {
            i13 = 57;
        }
        StringBuilder sb2 = new StringBuilder(i13 * ((i12 + 15) / 16));
        int i14 = i12;
        int i15 = 0;
        int i16 = 0;
        while (i14 > 0) {
            if (i15 == 0) {
                if (i12 < 65536) {
                    sb2.append(String.format("%04X:", new Object[]{Integer.valueOf(i11)}));
                } else {
                    sb2.append(String.format("%08X:", new Object[]{Integer.valueOf(i11)}));
                }
                i16 = i11;
            } else if (i15 == 8) {
                sb2.append(" -");
            }
            sb2.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i11] & 255)}));
            i14--;
            i15++;
            if (z11 && (i15 == 16 || i14 == 0)) {
                int i17 = 16 - i15;
                if (i17 > 0) {
                    for (int i18 = 0; i18 < i17; i18++) {
                        sb2.append("   ");
                    }
                }
                if (i17 >= 8) {
                    sb2.append("  ");
                }
                sb2.append("  ");
                for (int i19 = 0; i19 < i15; i19++) {
                    char c11 = (char) bArr[i16 + i19];
                    if (c11 < ' ' || c11 > '~') {
                        c11 = '.';
                    }
                    sb2.append(c11);
                }
            }
            if (i15 == 16 || i14 == 0) {
                sb2.append(10);
                i15 = 0;
            }
            i11++;
        }
        return sb2.toString();
    }
}
