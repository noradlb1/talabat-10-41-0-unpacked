package com.google.android.gms.internal.vision;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzgt {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzxc;
    private static final ByteBuffer zzxd;
    private static final zzft zzxe;

    static {
        byte[] bArr = new byte[0];
        zzxc = bArr;
        zzxd = ByteBuffer.wrap(bArr);
        zzxe = zzft.zza(bArr, 0, bArr.length, false);
    }

    public static <T> T checkNotNull(T t11) {
        t11.getClass();
        return t11;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public static <T> T zza(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static int zzab(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static Object zzb(Object obj, Object obj2) {
        return ((zzic) obj).zzgi().zza((zzic) obj2).zzgb();
    }

    public static boolean zzf(zzic zzic) {
        if (!(zzic instanceof zzev)) {
            return false;
        }
        zzev zzev = (zzev) zzic;
        return false;
    }

    public static boolean zzg(byte[] bArr) {
        return zzjs.zzg(bArr);
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int zzm(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static int zza(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }
}
