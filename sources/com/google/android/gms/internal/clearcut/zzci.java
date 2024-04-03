package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzci {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzkt;
    private static final ByteBuffer zzku;
    private static final zzbk zzkv;

    static {
        byte[] bArr = new byte[0];
        zzkt = bArr;
        zzku = ByteBuffer.wrap(bArr);
        zzkv = zzbk.zza(bArr, 0, bArr.length, false);
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

    public static int zza(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public static Object zza(Object obj, Object obj2) {
        return ((zzdo) obj).zzbc().zza((zzdo) obj2).zzbi();
    }

    public static <T> T zza(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static int zzc(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static boolean zze(byte[] bArr) {
        return zzff.zze(bArr);
    }

    public static String zzf(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static boolean zzf(zzdo zzdo) {
        return false;
    }

    public static int zzl(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }
}
