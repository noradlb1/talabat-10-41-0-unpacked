package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzgkv {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzgjn zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        zzf = zzgjn.zzH(bArr, 0, 0, false);
    }

    public static int zza(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int zzd2 = zzd(length, bArr, 0, length);
        if (zzd2 == 0) {
            return 1;
        }
        return zzd2;
    }

    public static int zzc(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static int zzd(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = i12; i14 < i12 + i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public static <T> T zze(T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T zzf(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static Object zzg(Object obj, Object obj2) {
        return ((zzglv) obj).zzaH().zzad((zzglv) obj2).zzaj();
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, zzb);
    }

    public static boolean zzi(byte[] bArr) {
        return zzgnu.zzi(bArr);
    }
}
