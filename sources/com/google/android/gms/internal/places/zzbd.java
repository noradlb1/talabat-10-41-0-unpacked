package com.google.android.gms.internal.places;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzbd {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zziz;
    private static final ByteBuffer zzja;
    private static final zzai zzjb;

    static {
        byte[] bArr = new byte[0];
        zziz = bArr;
        zzja = ByteBuffer.wrap(bArr);
        zzjb = zzai.zzb(bArr, 0, bArr.length, false);
    }

    public static <T> T checkNotNull(T t11) {
        t11.getClass();
        return t11;
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zzb = zzb(length, bArr, 0, length);
        if (zzb == 0) {
            return 1;
        }
        return zzb;
    }

    public static <T> T zzb(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static int zze(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static boolean zze(byte[] bArr) {
        return zzea.zze(bArr);
    }

    public static String zzf(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static boolean zzg(zzck zzck) {
        return false;
    }

    public static int zzl(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static int zzb(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public static Object zzb(Object obj, Object obj2) {
        return ((zzck) obj).zzbk().zzb((zzck) obj2).zzbe();
    }
}
