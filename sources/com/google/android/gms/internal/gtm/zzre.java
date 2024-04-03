package com.google.android.gms.internal.gtm;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzre {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzbbh;
    private static final ByteBuffer zzbbi;
    private static final zzqe zzbbj;

    static {
        byte[] bArr = new byte[0];
        zzbbh = bArr;
        zzbbi = ByteBuffer.wrap(bArr);
        zzbbj = zzqe.zza(bArr, 0, bArr.length, false);
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

    public static Object zzb(Object obj, Object obj2) {
        return ((zzsk) obj).zzpg().zza((zzsk) obj2).zzpl();
    }

    public static boolean zzf(zzsk zzsk) {
        return false;
    }

    public static boolean zzi(byte[] bArr) {
        return zztz.zzi(bArr);
    }

    public static String zzj(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int zzk(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static int zzz(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static int zza(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }
}
