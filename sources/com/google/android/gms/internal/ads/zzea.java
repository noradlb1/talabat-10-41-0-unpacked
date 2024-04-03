package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;

public final class zzea {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};

    public static String zza(int i11, int i12, int i13) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
    }

    public static String zzb(int i11, boolean z11, int i12, int i13, int[] iArr, int i14) {
        char c11;
        Object[] objArr = new Object[5];
        objArr[0] = zzc[i11];
        objArr[1] = Integer.valueOf(i12);
        objArr[2] = Integer.valueOf(i13);
        if (true != z11) {
            c11 = 'L';
        } else {
            c11 = 'H';
        }
        objArr[3] = Character.valueOf(c11);
        objArr[4] = Integer.valueOf(i14);
        StringBuilder sb2 = new StringBuilder(zzfn.zzD("hvc1.%s%d.%X.%c%d", objArr));
        int i15 = 6;
        while (i15 > 0) {
            int i16 = i15 - 1;
            if (iArr[i16] != 0) {
                break;
            }
            i15 = i16;
        }
        for (int i17 = 0; i17 < i15; i17++) {
            sb2.append(String.format(".%02X", new Object[]{Integer.valueOf(iArr[i17])}));
        }
        return sb2.toString();
    }

    public static byte[] zzc(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = new byte[(i12 + 4)];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i11, bArr2, 4, i12);
        return bArr2;
    }
}
